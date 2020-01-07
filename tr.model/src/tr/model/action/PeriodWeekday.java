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
import java.util.Date;
import java.util.List;
import java.util.Vector;
import tr.prefs.recurrence.RecurrencePrefs;

/**
 * Weekday period (ie not weekends).
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class PeriodWeekday extends Period {

    public static final byte ID = 1;
    public static final String BUNDLE_KEY = "period.weekday";

    /**
     * Creates a clone.
     */
    public Period clone() {
        return new PeriodWeekday();
    }

    public final byte getID() {
        return ID;
    }

    public final String getBundleKey() {
        return BUNDLE_KEY;
    }

    /*
     * Calculates the start date of the period for a given date.
     * @param date The given date.
     * @return The given date if it is a weekday or the next Monday if the date
     * is a Saturday or Sunday. Time values are cleared.
     */
    private Date calculateStartDate(Date date) {
        assert (date != null);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, 2);
        } else if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /*
     * Calculates the end date of the period for a given date.
     * @param date The given date.
     * @return The given date if it is a weekday or the next Monday if the date
     * is a Saturday or Sunday. The time is set to the last millisecond of the
     * day.
     */
    private Date calculateEndDate(Date date) {
        assert (date != null);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, 2);
        } else if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    private Date addWeekdays(Date date, int weekdays) {
        assert (date != null);
        assert (weekdays > 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int days = 0;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                days = weekdays + (((int) (weekdays / 5)) * 2);
                break;
            case Calendar.TUESDAY:
                days = weekdays + (((int) ((weekdays + 1) / 5)) * 2);
                break;
            case Calendar.WEDNESDAY:
                days = weekdays + (((int) ((weekdays + 2) / 5)) * 2);
                break;
            case Calendar.THURSDAY:
                days = weekdays + (((int) ((weekdays + 3) / 5)) * 2);
                break;
            case Calendar.FRIDAY:
                days = weekdays + (((int) ((weekdays + 4) / 5)) * 2);
                break;
            case Calendar.SATURDAY:
                days = weekdays + (((int) ((weekdays - 1) / 5)) * 2) + 1;
                break;
            case Calendar.SUNDAY:
                days = weekdays + (((int) ((weekdays - 1) / 5)) * 2);
                break;
        }

        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    private Date minusWeekdays(Date date, int weekdays) {
        assert (date != null);
        assert (weekdays > 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int days = 0;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.FRIDAY:
                days = weekdays + (((int) (weekdays / 5)) * 2);
                break;
            case Calendar.THURSDAY:
                days = weekdays + (((int) ((weekdays + 1) / 5)) * 2);
                break;
            case Calendar.WEDNESDAY:
                days = weekdays + (((int) ((weekdays + 2) / 5)) * 2);
                break;
            case Calendar.TUESDAY:
                days = weekdays + (((int) ((weekdays + 3) / 5)) * 2);
                break;
            case Calendar.MONDAY:
                days = weekdays + (((int) ((weekdays + 4) / 5)) * 2);
                break;
            case Calendar.SUNDAY:
                days = weekdays + (((int) ((weekdays - 1) / 5)) * 2) + 1;
                break;
            case Calendar.SATURDAY:
                days = weekdays + (((int) ((weekdays - 1) / 5)) * 2);
                break;
        }

        calendar.add(Calendar.DAY_OF_YEAR, days * -1);
        return calendar.getTime();
    }

    public List<Date> getSelectedDates(Date startDate, Date templateDate) {
        assert (startDate != null);
        assert (templateDate != null);

        Calendar templateCal = Calendar.getInstance();
        templateCal.setTime(templateDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.set(Calendar.HOUR_OF_DAY, templateCal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, templateCal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, templateCal.get(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, templateCal.get(Calendar.MILLISECOND));

        List<Date> dates = new Vector<Date>(1);
        dates.add(cal.getTime());
        return dates;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof PeriodWeekday;
    }

    @Override
    public int hashCode() {
        return ID;
    }

    @Override
    public void initialise(Date startDate) {
        // nothing to do.
    }

    @Override
    public int getDefaultAdvanceNbr() {
        return RecurrencePrefs.getNbrFutureWeekday();
    }

    @Override
    public PeriodType getType() {
        return PeriodType.WEEKDAY;
    }

    @Override
    public Interval getPeriod(Date date) {
        return new Interval(calculateStartDate(date), calculateEndDate(date));
    }

    @Override
    public Interval addPeriods(Interval interval, int n) {
        if (n > 0) {
            return getPeriod(addWeekdays(interval.start, n));
        }
        if (n < 0) {
            return getPeriod(minusWeekdays(interval.start, Math.abs(n)));
        }
        return getPeriod(interval.start);
    }
}
