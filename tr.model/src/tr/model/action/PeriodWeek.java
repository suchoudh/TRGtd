/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can get a copy of the License at http://www.thinkingrock.com.au/cddl.html
 * or http://www.thinkingrock.com.au/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.thinkingrock.com.au/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * The Original Software is ThinkingRock. The Initial Developer of the Original
 * Software is Avente Pty Ltd, Australia.
 *
 * Portions Copyright 2006-2007 Avente Pty Ltd. All Rights Reserved.
 */
package tr.model.action;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import tr.prefs.dates.DatesPrefs;
import tr.prefs.recurrence.RecurrencePrefs;

/**
 * Week period.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class PeriodWeek extends Period {

    public static final byte ID = 3;
    public static final String BUNDLE_KEY = "period.week";
    public static final int MONDAY = Calendar.MONDAY;
    public static final int TUESDAY = Calendar.TUESDAY;
    public static final int WEDNESDAY = Calendar.WEDNESDAY;
    public static final int THURSDAY = Calendar.THURSDAY;
    public static final int FRIDAY = Calendar.FRIDAY;
    public static final int SATURDAY = Calendar.SATURDAY;
    public static final int SUNDAY = Calendar.SUNDAY;
    private final List<Integer> selectedDays;

    public PeriodWeek() {
        this.selectedDays = new Vector<Integer>();
    }

    public PeriodWeek(List<Integer> selectedDays) {
        this.selectedDays = selectedDays;
    }

    /**
     * Creates a clone.
     */
    public Period clone() {
        return new PeriodWeek(new Vector<Integer>(selectedDays));
    }

    public final String getBundleKey() {
        return BUNDLE_KEY;
    }

    public final byte getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (selectedDays != null ? selectedDays.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (object instanceof PeriodWeek) {
            PeriodWeek other = (PeriodWeek) object;
            return selectedDays.equals(other.selectedDays);
        }
        return false;
    }

    public List<Integer> getSelectedDays() {        
        Collections.sort(selectedDays);        
        return selectedDays;
    }

    public boolean isSelected(Integer dayOfWeek) {
        synchronized (this) {
            return selectedDays.contains(dayOfWeek);
        }
    }

    public void select(Integer dayOfWeek) {
        synchronized (this) {
            if (!isSelected(dayOfWeek)) {
                selectedDays.add(dayOfWeek);
            }
        }
    }

    public void deselected(Integer dayOfWeek) {
        synchronized (this) {
            selectedDays.remove(dayOfWeek);
        }
    }

    /*
     * Calculates the start date of the period a given date is in.
     * @param date The given date.
     * @return The first day of the week of date with time values cleared.
     */
    private Date calculateStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());
        calendar.set(Calendar.DAY_OF_WEEK, DatesPrefs.getFirstDayOfWeek());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /*
     * Calculates the end date of the period a given date is in.
     * @param date The given date.
     * @return The last day of the week that the date is in, with time set to
     * the last millisecond of that day.
     */
    private Date calculateEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getMaximum(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    private Date addWeeks(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, n);
        return calendar.getTime();
    }

    public List<Date> getSelectedDates(Date periodDate) {
        List<Date> dates = new Vector<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());

        Date startDate = calculateStartDate(periodDate);

        for (Integer day : selectedDays) {
            calendar.setTime(startDate);
            calendar.set(Calendar.DAY_OF_WEEK, day);
            dates.add(calendar.getTime());
        }
        return dates;
    }

    public List<Date> getSelectedDates(Date startDate, Date templateDate) {
        assert (startDate != null);
        assert (templateDate != null);

        List<Date> dates = new Vector<Date>();

        Calendar templateCal = Calendar.getInstance();
        templateCal.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());
        templateCal.setTime(templateDate);

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(DatesPrefs.getFirstDayOfWeek());
        cal.setTime(startDate);

        for (Integer day : selectedDays) {
            cal.set(Calendar.DAY_OF_WEEK, day);
            cal.set(Calendar.HOUR_OF_DAY, templateCal.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, templateCal.get(Calendar.MINUTE));
            cal.set(Calendar.SECOND, templateCal.get(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, templateCal.get(Calendar.MILLISECOND));
            dates.add(cal.getTime());
        }

        return dates;
    }

    @Override
    public void initialise(Date startDate) {
        selectedDays.clear();
        if (startDate != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            selectedDays.add(cal.get(Calendar.DAY_OF_WEEK));
        }
    }
    
    @Override
    public int getDefaultAdvanceNbr() {
        return RecurrencePrefs.getNbrFutureWeek();
    }

    @Override
    public PeriodType getType() {
        return PeriodType.WEEK;
    }
    
    @Override
    public Interval getPeriod(Date date) {
        return new Interval(calculateStartDate(date), calculateEndDate(date));
    }

    @Override
    public Interval addPeriods(Interval interval, int n) {
        return getPeriod(addWeeks(interval.start, n));
    }
    
}
