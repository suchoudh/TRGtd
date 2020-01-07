/**
* <h2> <span>HTML Table Row Element Interface</span></h2>
* <p>DOM <code>table row</code> objects expose the <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6986576" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6986576">HTMLTableRowElement</a></code> interface, which provides special properties and methods (beyond the regular <a href="element" shape="rect" title="DOM:element">element</a> object interface they also have available to them by inheritance) for manipulating the layout and presentation of rows in an HTML table.
* </p>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:tableRow.align&amp;action=edit" shape="rect" title="DOM:tableRow.align">row.align</a>Ê</dt><dd> <b>align</b> gets or sets the horizontal alignment of data within cells of the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.bgColor&amp;action=edit" shape="rect" title="DOM:tableRow.bgColor">row.bgColor</a> <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>Ê</dt><dd> <b>bgColor</b> gets or sets the background colour of the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.cells&amp;action=edit" shape="rect" title="DOM:tableRow.cells">row.cells</a>Ê</dt><dd> <b>cells</b> returns a read-only <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506">HTMLCollection</a></code> of the cells in the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.ch&amp;action=edit" shape="rect" title="DOM:tableRow.ch">row.ch</a>Ê</dt><dd> <b>ch</b> gets or sets the alignment character for cells in a column.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.chOff&amp;action=edit" shape="rect" title="DOM:tableRow.chOff">row.chOff</a>Ê</dt><dd> <b>chOff</b> gets or sets the offset of the alignment character.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.rowIndex&amp;action=edit" shape="rect" title="DOM:tableRow.rowIndex">row.rowIndex</a>Ê</dt><dd> <b>rowIndex</b> gets the logical order of the row within the entire table.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.sectionRowIndex&amp;action=edit" shape="rect" title="DOM:tableRow.sectionRowIndex">row.sectionRowIndex</a>Ê</dt><dd> <b>sectionRowIndex</b> gets the logical order of the row within the table section it belongs to.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.vAlign&amp;action=edit" shape="rect" title="DOM:tableRow.vAlign">row.vAlign</a>Ê</dt><dd> <b>vAlign</b> gets or sets the offset of the alignment character.
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:tableRow.deleteCell&amp;action=edit" shape="rect" title="DOM:tableRow.deleteCell">row.deleteCell</a>Ê</dt><dd> <b>deleteCell</b> deletes a cell from the row.
* </dd><dt style="font-weight:bold"> <a href="tableRow.insertCell" shape="rect" title="DOM:tableRow.insertCell">row.insertCell</a>Ê</dt><dd> <b>insertCell</b> inserts a new cell into the row and returns a reference to the new cell.
* </dd></dl>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var TableRow = {
  // This is just a stub for a builtin native JavaScript object.
align: undefined,
bgColor: undefined,
cells: undefined,
ch: undefined,
chOff: undefined,
deleteCell: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Inserts a new cell into a table row and returns a reference to the cell.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>cell</i> = <i>HTMLTableRowElement</i>.insertCell(<i>index</i>);
* </pre>
* <ul><li> <code>HTMLTableRowElement</code> is a reference to an HTML table row element.
* </li><li> <code>index</code> is the cell index of the new cell.
* </li><li> <code>cell</code> is assigned a reference to the new cell. If <code>index</code> is -1 or equal to the number of cell, the cell is appended as the last cell in the row. If <code>index</code> is omitted or greater than the number of rows, an error will result.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;table&gt;
* &lt;tr id="row0"&gt;
* &lt;td&gt;Original cell&lt;/td&gt;
* &lt;/tr&gt;
* &lt;/table&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function addCell(tableRowID)
* {
* 
* // Get a reference to the tableRow
* var rowRef = document.getElementById(tableRowID);
* 
* // Insert a cell in the row at cell index 0
* var newCell   = rowRef.insertCell(0);
* 
* // Append a text node to the cell
* var newText  = document.createTextNode('New cell')
* newCell.appendChild(newText);
* }
* 
* // Call addCell() with the ID of a table row
* addCell('row0');
* 
* &lt;/script&gt;
* </pre>
* <p>To be valid in an HTML document, a TR must have at least one TD element.
* </p><p>Note that <code>insertCell</code> inserts the cell directly into the table and returns a reference to the new cell.  The cell does not need to be appended separately as would be the case if <code><a href="document.createElement" shape="rect" title="DOM:document.createElement">document.createElement()</a></code> had been used to create the new TD element.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-68927016" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-68927016">DOM Level 2 HTML: insertCell</a>
* <a href="http://www.w3.org/TR/html4/struct/tables.html#edef-TD" rel="nofollow" shape="rect" title="http://www.w3.org/TR/html4/struct/tables.html#edef-TD">HTML 4.01 Table Cell: TD</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
insertCell: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
rowIndex: undefined,
sectionRowIndex: undefined,
vAlign: undefined,
};

/**
* <h2> <span>HTML Table Row Element Interface</span></h2>
* <p>DOM <code>table row</code> objects expose the <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6986576" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6986576">HTMLTableRowElement</a></code> interface, which provides special properties and methods (beyond the regular <a href="element" shape="rect" title="DOM:element">element</a> object interface they also have available to them by inheritance) for manipulating the layout and presentation of rows in an HTML table.
* </p>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:tableRow.align&amp;action=edit" shape="rect" title="DOM:tableRow.align">row.align</a>Ê</dt><dd> <b>align</b> gets or sets the horizontal alignment of data within cells of the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.bgColor&amp;action=edit" shape="rect" title="DOM:tableRow.bgColor">row.bgColor</a> <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>Ê</dt><dd> <b>bgColor</b> gets or sets the background colour of the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.cells&amp;action=edit" shape="rect" title="DOM:tableRow.cells">row.cells</a>Ê</dt><dd> <b>cells</b> returns a read-only <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506">HTMLCollection</a></code> of the cells in the row.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.ch&amp;action=edit" shape="rect" title="DOM:tableRow.ch">row.ch</a>Ê</dt><dd> <b>ch</b> gets or sets the alignment character for cells in a column.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.chOff&amp;action=edit" shape="rect" title="DOM:tableRow.chOff">row.chOff</a>Ê</dt><dd> <b>chOff</b> gets or sets the offset of the alignment character.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.rowIndex&amp;action=edit" shape="rect" title="DOM:tableRow.rowIndex">row.rowIndex</a>Ê</dt><dd> <b>rowIndex</b> gets the logical order of the row within the entire table.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.sectionRowIndex&amp;action=edit" shape="rect" title="DOM:tableRow.sectionRowIndex">row.sectionRowIndex</a>Ê</dt><dd> <b>sectionRowIndex</b> gets the logical order of the row within the table section it belongs to.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=tableRow.vAlign&amp;action=edit" shape="rect" title="DOM:tableRow.vAlign">row.vAlign</a>Ê</dt><dd> <b>vAlign</b> gets or sets the offset of the alignment character.
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:tableRow.deleteCell&amp;action=edit" shape="rect" title="DOM:tableRow.deleteCell">row.deleteCell</a>Ê</dt><dd> <b>deleteCell</b> deletes a cell from the row.
* </dd><dt style="font-weight:bold"> <a href="tableRow.insertCell" shape="rect" title="DOM:tableRow.insertCell">row.insertCell</a>Ê</dt><dd> <b>insertCell</b> inserts a new cell into the row and returns a reference to the new cell.
* </dd></dl>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var tableRow = new TableRow();
