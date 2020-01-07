<?xml version="1.0" encoding="UTF-8"?>
<!-- 
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
-->
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0"/>
    
    <!--=====================================================================-->
    <!-- Parameters                                                          -->	
    <!--=====================================================================-->
    <xsl:param name="context"/>
    <xsl:param name="topic"/>
    <xsl:param name="include-done"/>
    <xsl:param name="include-inactive"/>
    <xsl:param name="include-doasap"/>
    <xsl:param name="include-scheduled"/>
    <xsl:param name="include-delegated"/>
    <xsl:param name="date-format"/>
    <xsl:param name="p-field-1"/>
    <xsl:param name="p-field-2"/>
    <xsl:param name="p-field-3"/>
    <xsl:param name="p-field-4"/>
    <xsl:param name="p-field-5"/>
    <xsl:param name="p-field-6"/>
    <xsl:param name="p-field-7"/>
    <xsl:param name="p-field-8"/>
    <xsl:param name="p-field-9"/>
    <xsl:param name="p-field-10"/>
    <xsl:param name="p-field-11"/>
    <xsl:param name="p-field-12"/>
    <xsl:param name="p-field-13"/>
    <xsl:param name="p-field-14"/>
    <xsl:param name="field-1"/>
    <xsl:param name="field-2"/>
    <xsl:param name="field-3"/>
    <xsl:param name="field-4"/>
    <xsl:param name="field-5"/>
    <xsl:param name="field-6"/>
    <xsl:param name="field-7"/>
    <xsl:param name="field-8"/>
    <xsl:param name="field-9"/>
    <xsl:param name="field-10"/>
    <xsl:param name="field-11"/>
    <xsl:param name="field-12"/>
    <xsl:param name="field-13"/>
    <xsl:param name="field-14"/>
    <xsl:param name="field-15"/>
    <xsl:param name="field-16"/>
    <xsl:param name="field-17"/>
    <xsl:param name="field-18"/>
    <xsl:param name="field-19"/>
    <xsl:param name="field-20"/>
    
    <!--=====================================================================-->
    <!-- Variables                                                           -->	
    <!--=====================================================================-->
    <xsl:variable name="context-key">
        <xsl:choose>
            <xsl:when test="$context='all'">
                <xsl:value-of select="$context"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="/data/contexts/context[name=$context]/@key"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:variable>
    <xsl:variable name="topic-key">
        <xsl:choose>
            <xsl:when test="$topic='all'">
                <xsl:value-of select="$topic"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="/data/topics/topic[name=$topic]/@key"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:variable>
    
    <!--=====================================================================-->
    <!-- Root element                                                        -->
    <!--=====================================================================-->
    <xsl:template match="data">
        <extract>
            <projects>
                <xsl:apply-templates select="projects/project"/>
            </projects>
            <single-actions>
                <xsl:apply-templates select="single_actions/action"/>
            </single-actions>
        </extract>
    </xsl:template>

    <!-- Project filter -->
    <xsl:template match="project">
        <xsl:choose>
            <xsl:when test="$include-done='false' and done='true'"/>
            <xsl:when test="$topic!='all' and topic-key!=$topic-key"/>
            <xsl:otherwise>
                <xsl:call-template name="export-project">
                    <xsl:with-param name="project" select="."/>
                </xsl:call-template>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <!-- Project export -->
    <xsl:template name="export-project">
        <xsl:param name="project"/>
        <project>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-1"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-2"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-3"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-4"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-5"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-6"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-7"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-8"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-9"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-10"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-11"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-12"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-13"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:call-template name="p-export-field">
                <xsl:with-param name="field" select="$p-field-14"/>
                <xsl:with-param name="project" select="$project"/>
            </xsl:call-template>
            <xsl:apply-templates select="//projects/project[@key=$project/children/project/@key]"/>
            <xsl:apply-templates select="//actions/action[@key=$project/children/action/@key]"/>
        </project>
    </xsl:template>
    
    <!--=====================================================================-->
    <!-- Action filter                                                       -->	
    <!--=====================================================================-->
    <xsl:template match="action">
        <xsl:variable name="type" select="state/@type"/>
        <xsl:variable name="date" select="substring(state/date,1,8)"/>
        <xsl:choose>
            <xsl:when test="$include-done='false' and done='true'"/>
            <xsl:when test="$include-doasap='false' and $type='ASAP'"/>
            <xsl:when test="$include-inactive='false' and $type='INACTIVE'"/>
            <xsl:when test="$include-scheduled='false' and $type='SCHEDULED'"/>
            <xsl:when test="$include-delegated='false' and $type='DELEGATED'"/>
            <xsl:when test="$context!='all' and context-key!=$context-key"/>
            <xsl:when test="$topic!='all' and topic-key!=$topic-key"/>
            <xsl:otherwise>
                <xsl:call-template name="export-action">
                    <xsl:with-param name="action" select="."/>
                </xsl:call-template>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>	
    
    <!--=====================================================================-->
    <!-- Action export                                                       -->	
    <!--=====================================================================-->
    <xsl:template name="export-action">
        <xsl:param name="action"/>
        <action>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-1"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-2"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-3"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-4"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-5"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-6"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-7"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-8"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-9"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-10"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-11"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-12"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-13"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-14"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-15"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-16"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-17"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-18"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-19"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
            <xsl:call-template name="export-field">
                <xsl:with-param name="field" select="$field-20"/>
                <xsl:with-param name="action" select="$action"/>
            </xsl:call-template>
        </action>
    </xsl:template>
    
    <!--=====================================================================-->
    <!-- Action fields export                                                       -->	
    <!--=====================================================================-->
    <xsl:template name="export-field">
        <xsl:param name="field"/>
        <xsl:param name="action"/>
        <xsl:choose>
            <xsl:when test="$field='none'"/>
            <xsl:when test="$field='field-id'">
                <xsl:attribute name="id">
                    <xsl:value-of select="substring($action/@key,2)"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-desc'">
                <xsl:attribute name="desc">
                    <xsl:value-of select="$action/desc"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-notes'">
                <xsl:attribute name="notes">
                    <xsl:value-of select="$action/notes"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-created'">
                <xsl:attribute name="created">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$action/created"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-done'">
                <xsl:attribute name="done">
                    <xsl:value-of select="$action/done"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-done-date'">
                <xsl:attribute name="done-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$action/done_date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-thought-desc'">
                <xsl:attribute name="thought">
                    <xsl:value-of select="//thoughts/thought[@key=$action/thought-key]/desc"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-topic-desc'">
                <xsl:attribute name="topic">
                    <xsl:value-of select="//topics/topic[@key=$action/topic-key]/name"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-context-desc'">
                <xsl:attribute name="context">
                    <xsl:value-of select="//contexts/context[@key=$action/context-key]/name"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-state'">
                <xsl:attribute name="state">
                    <xsl:value-of select="$action/state/@type"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-action-date'">
                <xsl:attribute name="action-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$action/action-date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-scheduled-datetime'">
                <xsl:attribute name="scheduled-date">
                    <xsl:choose>
                        <xsl:when test="$action/state/@type='SCHEDULED'">
                            <xsl:call-template name="write-date">
                                <xsl:with-param name="date" select="$action/state/date"/>
                            </xsl:call-template>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:call-template name="write">
                                <xsl:with-param name="string" select=""/>
                            </xsl:call-template>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-scheduled-duration'">
                <xsl:attribute name="scheduled-duration">
                    <xsl:choose>
                        <xsl:when test="$action/state/@type='SCHEDULED'">
                            <xsl:variable name="duration">
                                <xsl:value-of select="$action/state/duration-hrs"/>
                                <xsl:text>:</xsl:text>
                                <xsl:value-of select="$action/state/duration-mns"/>
                            </xsl:variable>
                            <xsl:call-template name="write">
                                <xsl:with-param name="string" select="$duration"/>
                            </xsl:call-template>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:call-template name="write">
                                <xsl:with-param name="string" select=""/>
                            </xsl:call-template>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-delegated-to'">
                <xsl:attribute name="delegated-to">
                    <xsl:value-of select="$action/state/to"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-start-date'">
                <xsl:attribute name="start-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$action/start-date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-due-date'">
                <xsl:attribute name="due-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$action/due-date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-success'">
                <xsl:attribute name="success">
                    <xsl:value-of select="$action/success"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-time'">
                <xsl:attribute name="time">
                    <xsl:value-of select="$action/time"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-energy'">
                <xsl:attribute name="energy">
                    <xsl:value-of select="$action/energy"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='field-priority'">
                <xsl:attribute name="priority">
                    <xsl:value-of select="$action/priority"/>
                </xsl:attribute>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    
    <!--=====================================================================-->
    <!-- Project fields export                                                       -->	
    <!--=====================================================================-->
    <xsl:template name="p-export-field">
        <xsl:param name="field"/>
        <xsl:param name="project"/>
        <xsl:choose>
            <xsl:when test="$field='none'"/>
            <xsl:when test="$field='p-field-id'">
                <xsl:attribute name="id">
                    <xsl:value-of select="substring($project/@key,2)"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-desc'">
                <xsl:attribute name="description">
                    <xsl:value-of select="$project/desc"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-notes'">
                 <xsl:attribute name="notes">
                    <xsl:value-of select="$project/notes"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-created'">
                <xsl:attribute name="created">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$project/created"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-done'">
                <xsl:attribute name="done">
                    <xsl:value-of select="$project/done"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-done-date'">
                <xsl:attribute name="done-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$project/done_date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-thought-desc'">
                <xsl:attribute name="thought">
                    <xsl:value-of select="//thoughts/thought[@key=$project/thought-key]/desc"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-topic-desc'">
                <xsl:attribute name="topic">
                    <xsl:value-of select="//topics/topic[@key=$project/topic-key]/name"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-start-date'">
                <xsl:attribute name="start-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$project/start-date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-due-date'">
                <xsl:attribute name="due-date">
                    <xsl:call-template name="write-date">
                        <xsl:with-param name="date" select="$project/due-date"/>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-purpose'">
                <xsl:attribute name="purpose">
                    <xsl:value-of select="$project/purpose"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-success'">
                <xsl:attribute name="vision">
                    <xsl:value-of select="$project/success"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-brainstorming'">
                <xsl:attribute name="brainstorming">
                    <xsl:value-of select="$project/brainstorming"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="$field='p-field-organising'">
                <xsl:attribute name="organising">
                    <xsl:value-of select="$project/organising"/>
                </xsl:attribute>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    
    <!--=====================================================================-->
    <!-- Write a string after removing seperator characters                  -->	
    <!--=====================================================================-->
    <xsl:template name="write">
        <xsl:param name="string"/>
        <xsl:value-of select="$string"/>
    </xsl:template>	
    
    <!--=====================================================================-->
    <!-- Write a date                                                        -->	
    <!--=====================================================================-->
    <xsl:template name="write-date">
        <xsl:param name="date"/>
        <xsl:choose>
            <xsl:when test="$date-format='f1'">
                <xsl:value-of select="substring($date,1,14)"/>
            </xsl:when>
            <xsl:when test="$date-format='f2'">
                <xsl:value-of select="substring($date,15,string-length($date))"/>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    
    <!--=====================================================================-->
</xsl:stylesheet>
