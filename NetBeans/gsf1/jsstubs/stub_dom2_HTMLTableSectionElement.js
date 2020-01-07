var HTMLTableSectionElement = Object.extend(new HTMLElement(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Aligns this object (vertically or horizontally) with respect to
 * its surrounding text. See the 
 * align attribute definition in HTML 4.01. This attribute is
 * deprecated in HTML 4.01.
 * @type String
 */
align: undefined,
/**
 * Alignment character for cells in a column. See the 
 * char attribute definition in HTML 4.01.
 * @type String
 */
ch: undefined,
/**
 * Offset of alignment character. See the 
 * charoff attribute definition in HTML 4.01.
 * @type String
 */
chOff: undefined,
/**
 * Delete a row from this section.
 * @param {Number} index of type long The index of the row to be deleted, or -1 to delete the last
 * row. This index starts from 0 and is relative only to the rows
 * contained inside this section, not all the rows in the table.
 * @type void
 */
deleteRow: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Insert a row into this section. The new row is
 * inserted immediately before the current index th row in
 * this section. If index is -1 or equal to the number of
 * rows in this section, the new row is appended.
 * @param {Number} index of type long The row number where to insert a new row. This index starts
 * from 0 and is relative only to the rows contained inside this
 * section, not all the rows in the table.
 * @return HTMLElement The newly created row.
 * @type HTMLElement
 */
insertRow: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The number of rows of frames in the frameset. See the 
 * rows attribute definition in HTML 4.01.
 * @type HTMLCollection
 */
rows: undefined,
/**
 * Vertical alignment of data in cell. See the 
 * valign attribute definition in HTML 4.01.
 * @type String
 */
vAlign: undefined,
});

