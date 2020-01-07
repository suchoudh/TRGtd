var HTMLTableRowElement = Object.extend(new HTMLElement(), {
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
 * Cell background color. See the 
 * bgcolor attribute definition in HTML 4.01. This attribute is
 * deprecated in HTML 4.01.
 * @type String
 */
bgColor: undefined,
/**
 * The collection of cells in this row.
 * @type HTMLCollection
 */
cells: undefined,
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
 * Delete a cell from the current row.
 * @param {Number} index of type long The index of the cell to delete, starting from 0. If the index
 * is -1 the last cell in the row is deleted.
 * @type void
 */
deleteCell: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Insert an empty TD cell into this
 * row. If index is -1 or equal to the number of cells,
 * the new cell is appended.
 * @param {Number} index of type long The place to insert the cell, starting from 0.
 * @return HTMLElement The newly created cell.
 * @type HTMLElement
 */
insertCell: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This is in logical order and not in document order. The
 * rowIndex does take into account sections
 * (THEAD, TFOOT, or TBODY)
 * within the table, placing THEAD rows first in the
 * index, followed by TBODY rows, followed by
 * TFOOT rows.
 * @type Number
 */
rowIndex: undefined,
/**
 * The index of this row, relative to the current section
 * (THEAD, TFOOT, or TBODY),
 * starting from 0.
 * @type Number
 */
sectionRowIndex: undefined,
/**
 * Vertical alignment of data in cell. See the 
 * valign attribute definition in HTML 4.01.
 * @type String
 */
vAlign: undefined,
});

