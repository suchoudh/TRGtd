/**
* <h2> <span>HTML Table Element Interface</span></h2>
* <p><code>table</code> objects expose the <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64060425" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64060425">HTMLTableElement</a></code> interface, which provides special properties and methods (beyond the regular <a href="element" shape="rect" title="DOM:element">element</a> object interface they also have available to them by inheritance) for manipulating the layout and presentation of tables in HTML.
* </p>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:table.caption" shape="rect" title="DOM:table.caption">table.caption</a> </dt><dd> <b>caption</b> returns the table caption.
* </dd><dt style="font-weight:bold"> <a href="table.tHead" shape="rect" title="DOM:table.tHead">table.tHead</a> </dt><dd> <b>tHead</b> returns the table head.
* </dd><dt style="font-weight:bold"> <a href="table.tFoot" shape="rect" title="DOM:table.tFoot">table.tFoot</a> </dt><dd> <b>tFoot</b> returns the table footer.
* </dd><dt style="font-weight:bold"> <a href="table.rows" shape="rect" title="DOM:table.rows">table.rows</a> </dt><dd> <b>rows</b> returns the rows in the table.
* </dd><dt style="font-weight:bold"> <a href="table.tBodies" shape="rect" title="DOM:table.tBodies">table.tBodies</a> </dt><dd> <b>tBodies</b> returns the table bodies.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="table.align" shape="rect" title="DOM:table.align">table.align</a> </dt><dd> <b>align</b> gets/sets the alignment of the table.
* </dd><dt style="font-weight:bold"> <a href="table.bgColor" shape="rect" title="DOM:table.bgColor">table.bgColor</a> <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span> </dt><dd> <b>bgColor</b> gets/sets the background color of the table.
* </dd><dt style="font-weight:bold"> <a href="table.border" shape="rect" title="DOM:table.border">table.border</a> </dt><dd> <b>border</b> gets/sets the table border.
* </dd><dt style="font-weight:bold"> <a href="table.cellPadding" shape="rect" title="DOM:table.cellPadding">table.cellPadding</a> </dt><dd> <b>cellPadding</b> gets/sets the cell padding.
* </dd><dt style="font-weight:bold"> <a href="table.cellSpacing" shape="rect" title="DOM:table.cellSpacing">table.cellSpacing</a> </dt><dd> <b>cellSpacing</b> gets/sets the spacing around the table.
* </dd><dt style="font-weight:bold"> <a href="table.frame" shape="rect" title="DOM:table.frame">table.frame</a> </dt><dd> <b>frame</b> specifies which sides of the table have borders.
* </dd><dt style="font-weight:bold"> <a href="table.rules" shape="rect" title="DOM:table.rules">table.rules</a> </dt><dd> <b>rules</b> specifies which interior borders are visible.
* </dd><dt style="font-weight:bold"> <a href="table.summary" shape="rect" title="DOM:table.summary">table.summary</a> </dt><dd> <b>summary</b> gets/sets the table summary.
* </dd><dt style="font-weight:bold"> <a href="table.width" shape="rect" title="DOM:table.width">table.width</a> </dt><dd> <b>width</b> gets/sets the width of the table.
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:table.createTHead" shape="rect" title="DOM:table.createTHead">table.createTHead</a> </dt><dd> <b>createTHead</b> creates a table header.
* </dd><dt style="font-weight:bold"> <a href="table.deleteTHead" shape="rect" title="DOM:table.deleteTHead">table.deleteTHead</a> </dt><dd> <b>deleteTHead</b> removes the table header.
* </dd><dt style="font-weight:bold"> <a href="table.createTFoot" shape="rect" title="DOM:table.createTFoot">table.createTFoot</a> </dt><dd> <b>createTFoot</b> creates a table footer.
* </dd><dt style="font-weight:bold"> <a href="table.deleteTFoot" shape="rect" title="DOM:table.deleteTFoot">table.deleteTFoot</a> </dt><dd> <b>deleteTFoot</b> removes a table footer.
* </dd><dt style="font-weight:bold"> <a href="table.createCaption" shape="rect" title="DOM:table.createCaption">table.createCaption</a> </dt><dd> <b>createCaption</b> creates a new caption for the table.
* </dd><dt style="font-weight:bold"> <a href="table.deleteCaption" shape="rect" title="DOM:table.deleteCaption">table.deleteCaption</a> </dt><dd> <b>deleteCaption</b> removes the table caption.
* </dd><dt style="font-weight:bold"> <a href="table.insertRow" shape="rect" title="DOM:table.insertRow">table.insertRow</a> </dt><dd> <b>insertRow</b> inserts a new row.
* </dd><dt style="font-weight:bold"> <a href="table.deleteRow" shape="rect" title="DOM:table.deleteRow">table.deleteRow</a> </dt><dd> <b>deleteRow</b> removes a row.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Table = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span>Summary</span></h2>
* <p><b>align</b> gets/sets the alignment of the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.align = <i>alignment</i>;
* var <i>alignment</i> = <i>HTMLTableElement</i>.align;
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>alignment</code> is a string with one of the following values:
* <ul><li>left
* </li><li>center
* </li><li>right
* </li></ul>
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set the alignmnet of a table
* var t = document.getElementById('TableA');
* t.align = 'center';
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The align attribute is deprecated in HTML4.0.
* </p>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-23180977" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-23180977"><i>HTMLTableElement</i>.align</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
align: undefined,
/**
* <h2> <span>Summary</span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p><code>bgcolor</code> gets/sets the background color of the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>color</i> = table.bgColor
* table.bgColor = <i>color</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>color</code> is a string representing a color value.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set table background colour to lightblue
* var t = document.getElementById('TableA');
* t.bgColor = 'lightblue';
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The <code>bgColor</code> attribute is deprecated in HTML 4.01.  The <code><a href="http://developer.mozilla.org/en/docs/CSS:background-color" shape="rect" title="CSS:background-color">CSS:background-color</a></code> property should be used instead by modifying the element's <code><a href="style#DOM_Style_Object" shape="rect" title="DOM:style">style</a></code> object or using a style rule.
* </p><p>Also available on DOM <code><a href="table.tBodies" shape="rect" title="DOM:table.tBodies">tbody</a></code>, <code><a href="table.rows" shape="rect" title="DOM:table.rows">row</a></code> and <code><a href="http://developer.mozilla.org/en/docs/index.php?title=table.cells&amp;action=edit" shape="rect" title="DOM:table.cells">cell</a></code> objects.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-83532985" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-83532985">DOM Level 2 HTML: <i>HTMLTableElement</i>.bgColor</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
bgColor: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>border</b> gets/sets the border width.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.border = <i>border</i>;
* var <i>border</i> = <i>HTMLTableElement</i>.border;
* </pre>
* <ul><li> <code>border</code> is string representing the width of the border in pixels.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set the width of a table border to 2 pixels
* var t = document.getElementById("TableA");
* t.border="2";
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This attribute is deprecated in HTML 4.0.
* </p>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-50969400" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-50969400"><i>HTMLTableElement</i>.border</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
border: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>caption</b> returns the table caption.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = table.caption
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (table.caption) {
* // do something with the caption
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This property returns void if no caption element exists for the table.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-14594520" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-14594520">caption</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-12035137" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-12035137">Interface HTMLTableCaptionElement</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
caption: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>cellPadding</b> gets/sets the padding around the individual cells of the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.cellPadding = <i>padding</i>;
* var <i>padding</i> = <i>HTMLTableElement</i>.cellPadding;
* </pre>
* <ul><li> <code>padding</code> is either a number of pixels (e.g. "10") or a percentage value (e.g. "10%").
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set cell padding to 10 pixels
* var t = document.getElementById("TableA");
* t.cellPadding = "10";
* </pre>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-59162158" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-59162158"><i>HTMLTableElement</i>.cellPadding</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cellPadding: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>cellSpacing</b> gets/sets the spacing around the individual cells of the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.cellSpacing = <i>spacing</i>;
* var <i>spacing</i> = <i>HTMLTableElement</i>.cellSpacing;
* </pre>
* <ul><li> <code>spacing</code> is either a number of pixels (e.g. "10") or a percentage value (e.g. "10%").
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set the cell spacing to 10 pixels
* var t = document.getElementById('TableA');
* t.cellSpacing = "10";
* </pre>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-68907883" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-68907883"><i>HTMLTableElement</i>.cellSpacing</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cellSpacing: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>createCaption</b> creates a new caption for the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i> = table.createCaption()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">mycap = mytable.createCaption();
* </pre>
* <h2> <span>Notes </span></h2>
* <p>If a caption element already exists on the table, this method returns that element.
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-96920263" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-96920263">createCaption</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createCaption: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>createTFoot</b> creates a new TFOOT for the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i> = table.createTFoot()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">myfoot = mytable.createTFoot();
* //checking: myfoot == mytable.tFoot
* </pre>
* <h2> <span>Notes </span></h2>
* <p>If a tfoot element already exists for the table, this method returns that element
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-8453710" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-8453710">createTFoot</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createTFoot: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>createTHead</b> creates a new THEAD for the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLElementObject</i> = table.createTHead()
* </pre>
* <h2> <span>Example</span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">myhead = mytable.createTHead();
* //checking: myhead == mytable.tHead
* </pre>
* <h2> <span>Notes </span></h2>
* <p>If a thead element already exists for the table, this method returns that element.
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-70313345" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-70313345">createTHead</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createTHead: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>deleteCaption</b> removes the caption from the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.deleteCaption()
* </pre>
* <h2> <span>Example </span></h2>
* <p>mytable.deleteCaption();
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-22930071" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-22930071">deleteCaption</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteCaption: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>deleteRow</b> removes a row from the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.deleteRow(<i>index</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>index</code> is a number representing the row that should be deleted.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">mytable.deleteRow(1);
* // delete the second row
* </pre>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-13114938" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-13114938">deleteRow</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteRow: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>deleteTFoot</b> removes a TFOOT from the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.deleteTFoot()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">mytable.deleteTFoot();
* </pre>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-78363258" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-78363258">deleteTFoot</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteTFoot: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>deleteTHead</b> removes a THEAD from the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.deleteTHead()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">mytable.deleteTHead();
* </pre>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-38310198" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-38310198">deleteTHead</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteTHead: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>frame</b> specifies which external table borders to render.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.frame = <i>side</i>;
* var <i>side</i> = <i>HTMLTableElement</i>.frame;
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>side</code> is a string with one of the following values:
* </li></ul>
* <dl><dt style="font-weight:bold">void </dt><dd> no sides. this is the default.
* </dd><dt style="font-weight:bold">above </dt><dd> top side
* </dd><dt style="font-weight:bold">below </dt><dd> bottom side
* </dd><dt style="font-weight:bold">hsides </dt><dd> top and bottom only
* </dd><dt style="font-weight:bold">vsides </dt><dd> right and left sides only
* </dd><dt style="font-weight:bold">lhs </dt><dd> left-hand side only
* </dd><dt style="font-weight:bold">rhs </dt><dd> right-hand side only
* </dd><dt style="font-weight:bold">box </dt><dd> all four sides
* </dd><dt style="font-weight:bold">border </dt><dd> all four sides
* </dd></dl>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Set the frame of TableA to 'border'
* var t = document.getElementById('TableA');
* t.frame  = "border";
* t.border = "2px";
* </pre>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64808476" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64808476"><i>HTMLTableElement</i>.frame</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
frame: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p><code>insertRow</code> inserts a new row in the table.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>row</i> = <i>HTMLTableElement</i>.insertRow(<i>index</i>);
* </pre>
* <ul><li> <code>HTMLTableElement</code> is a reference to a HTML table element.
* </li><li> <code>index</code> is the row index of the new row.
* </li><li> <code>row</code> is assigned a reference to the new row. If <code>index</code> is -1 or equal to the number of rows, the row is appended as the last row. If <code>index</code> is omitted or greater than the number of rows, an error will result.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;table id="TableA"&gt;
* &lt;tr&gt;
* &lt;td&gt;Old top row&lt;/td&gt;
* &lt;/tr&gt;
* &lt;/table&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function addRow(tableID)
* {
* 
* // Get a reference to the table
* var tableRef = document.getElementById(tableID);
* 
* // Insert a row in the table at row index 0
* var newRow   = tableRef.insertRow(0);
* 
* // Insert a cell in the row at index 0
* var newCell  = newRow.insertCell(0);
* 
* // Append a text node to the cell
* var newText  = document.createTextNode('New top row')
* newCell.appendChild(newText);
* }
* 
* // Call addRow() with the ID of a table
* addRow('TableA');
* 
* &lt;/script&gt;
* </pre>
* <p>To be valid in an HTML document, a TR must have at least one TD element.
* </p><p>Note that <code>insertRow</code> inserts the row directly into the table and returns a reference to the new row.  The row does not need to be appended separately as would be the case if <code><a href="document.createElement" shape="rect" title="DOM:document.createElement">document.createElement()</a></code> had been used to create the new TR element.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-39872903" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-39872903">DOM Level 2 HTML: insertRow</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
insertRow: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>rows</b> returns a collection of all the rows in the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLCollectionObject</i> = table.rows
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">myrows = mytable.rows;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The collection returned by the rows property of a table object includes all the rows in THEAD, TFOOT and all TBODY elements of the table.
* </p><p>The rows property of a table section element (THEAD, TFOOT or TBODY) contains only the rows in that section element.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6156016" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6156016">rows</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506">HTMLcollection</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
rows: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>rules</b> specifies which cell borders to render in the table.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.rules = <i>rules</i>;
* var <i>rules</i> = <i>HTMLTableElement</i>.rules;
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>rules</code> is a string with one of the following values:
* </li></ul>
* <dl><dt style="font-weight:bold">none</dt><dd> no rules
* </dd><dt style="font-weight:bold">groups</dt><dd> lines between groups only
* </dd><dt style="font-weight:bold">rows</dt><dd> lines between rows
* </dd><dt style="font-weight:bold">cols</dt><dd> lines between cols
* </dd><dt style="font-weight:bold">all</dt><dd> lines between all cells
* </dd></dl>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Turn on all the internal borders of a table
* var t = document.getElementById("TableID");
* t.rules = "all";
* </pre>
* <h2> <span>Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26347553" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26347553"><i>HTMLTableElement</i>.rules</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
rules: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>summary</b> gets/sets a table description.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.summary = <i>string</i>;
* var <i>string</i> = <i>HTMLTableElement</i>.summary;
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.summary = "Usage statistics";
* </pre>
* <h2> <span>Specification</span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-44998528" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-44998528"><i>HTMLTableElement</i>.summary</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
summary: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>tBodies</b> returns a collection of the table bodies.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLCollectionObject</i> = table.tBodies
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">length(mytable.tBodies);
* </pre>
* <h2> <span>Notes</span></h2>
* <p>The collection returned includes implicit TBODY elements.  e.g.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;table&gt;
* &lt;tr&gt;
* &lt;td&gt;cell one&lt;/td&gt;
* &lt;/tr&gt;
* &lt;/table&gt;
* </pre>
* <p>The DOM generated from the above HTML will have a TBODY element even though the tags are not included in the source HTML.
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-63206416" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-63206416">tBodies</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506">Interface HTMLCollection</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
tBodies: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>tFoot</b> returns the table's TFOOT element.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableSectionElementObject</i> = table.tFoot
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (table.tFoot == my_foot) {
* ...
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This property returns VOID if no TFOOT element exists.
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64197097" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64197097">tfoot</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-67417573" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-67417573">Interface HTMLTableSectionElement</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
tFoot: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>tHead</b> returns the table's THEAD.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>th_el</i> = table.tHead
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>th_el</code> is a <a href="http://developer.mozilla.org/en/docs/index.php?title=HTMLTableSectionElement&amp;action=edit" shape="rect" title="HTMLTableSectionElement">HTMLTableSectionElement</a>.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (table.tHead == my_head_el) {
* ...
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This property returns VOID if no THEAD element exists.
* </p>
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-9530944" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-9530944">thead</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-67417573" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-67417573">Interface HTMLTableSectionElement</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
tHead: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p><b>width</b> specifies the desired width of the table.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLTableElement</i>.width = <i>width</i>;
* var <i>width</i> = <i>HTMLTableElement</i>.width;
* </pre>
* <p>Where <code><a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/tables.html#adef-width-TABLE" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1999/REC-html401-19991224/struct/tables.html#adef-width-TABLE">width</a></code> is a string representing the width in number of pixels or as a percentage value.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">mytable.width = "75%";
* </pre>
* <h2> <span> Specification </span></h2>
* <p>W3C DOM 2 HTML Specification <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-77447361" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-77447361"><i>HTMLTableElement</i>.width</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
width: undefined,
};

/**
* <h2> <span>HTML Table Element Interface</span></h2>
* <p><code>table</code> objects expose the <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64060425" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-64060425">HTMLTableElement</a></code> interface, which provides special properties and methods (beyond the regular <a href="element" shape="rect" title="DOM:element">element</a> object interface they also have available to them by inheritance) for manipulating the layout and presentation of tables in HTML.
* </p>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:table.caption" shape="rect" title="DOM:table.caption">table.caption</a> </dt><dd> <b>caption</b> returns the table caption.
* </dd><dt style="font-weight:bold"> <a href="table.tHead" shape="rect" title="DOM:table.tHead">table.tHead</a> </dt><dd> <b>tHead</b> returns the table head.
* </dd><dt style="font-weight:bold"> <a href="table.tFoot" shape="rect" title="DOM:table.tFoot">table.tFoot</a> </dt><dd> <b>tFoot</b> returns the table footer.
* </dd><dt style="font-weight:bold"> <a href="table.rows" shape="rect" title="DOM:table.rows">table.rows</a> </dt><dd> <b>rows</b> returns the rows in the table.
* </dd><dt style="font-weight:bold"> <a href="table.tBodies" shape="rect" title="DOM:table.tBodies">table.tBodies</a> </dt><dd> <b>tBodies</b> returns the table bodies.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="table.align" shape="rect" title="DOM:table.align">table.align</a> </dt><dd> <b>align</b> gets/sets the alignment of the table.
* </dd><dt style="font-weight:bold"> <a href="table.bgColor" shape="rect" title="DOM:table.bgColor">table.bgColor</a> <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span> </dt><dd> <b>bgColor</b> gets/sets the background color of the table.
* </dd><dt style="font-weight:bold"> <a href="table.border" shape="rect" title="DOM:table.border">table.border</a> </dt><dd> <b>border</b> gets/sets the table border.
* </dd><dt style="font-weight:bold"> <a href="table.cellPadding" shape="rect" title="DOM:table.cellPadding">table.cellPadding</a> </dt><dd> <b>cellPadding</b> gets/sets the cell padding.
* </dd><dt style="font-weight:bold"> <a href="table.cellSpacing" shape="rect" title="DOM:table.cellSpacing">table.cellSpacing</a> </dt><dd> <b>cellSpacing</b> gets/sets the spacing around the table.
* </dd><dt style="font-weight:bold"> <a href="table.frame" shape="rect" title="DOM:table.frame">table.frame</a> </dt><dd> <b>frame</b> specifies which sides of the table have borders.
* </dd><dt style="font-weight:bold"> <a href="table.rules" shape="rect" title="DOM:table.rules">table.rules</a> </dt><dd> <b>rules</b> specifies which interior borders are visible.
* </dd><dt style="font-weight:bold"> <a href="table.summary" shape="rect" title="DOM:table.summary">table.summary</a> </dt><dd> <b>summary</b> gets/sets the table summary.
* </dd><dt style="font-weight:bold"> <a href="table.width" shape="rect" title="DOM:table.width">table.width</a> </dt><dd> <b>width</b> gets/sets the width of the table.
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:table.createTHead" shape="rect" title="DOM:table.createTHead">table.createTHead</a> </dt><dd> <b>createTHead</b> creates a table header.
* </dd><dt style="font-weight:bold"> <a href="table.deleteTHead" shape="rect" title="DOM:table.deleteTHead">table.deleteTHead</a> </dt><dd> <b>deleteTHead</b> removes the table header.
* </dd><dt style="font-weight:bold"> <a href="table.createTFoot" shape="rect" title="DOM:table.createTFoot">table.createTFoot</a> </dt><dd> <b>createTFoot</b> creates a table footer.
* </dd><dt style="font-weight:bold"> <a href="table.deleteTFoot" shape="rect" title="DOM:table.deleteTFoot">table.deleteTFoot</a> </dt><dd> <b>deleteTFoot</b> removes a table footer.
* </dd><dt style="font-weight:bold"> <a href="table.createCaption" shape="rect" title="DOM:table.createCaption">table.createCaption</a> </dt><dd> <b>createCaption</b> creates a new caption for the table.
* </dd><dt style="font-weight:bold"> <a href="table.deleteCaption" shape="rect" title="DOM:table.deleteCaption">table.deleteCaption</a> </dt><dd> <b>deleteCaption</b> removes the table caption.
* </dd><dt style="font-weight:bold"> <a href="table.insertRow" shape="rect" title="DOM:table.insertRow">table.insertRow</a> </dt><dd> <b>insertRow</b> inserts a new row.
* </dd><dt style="font-weight:bold"> <a href="table.deleteRow" shape="rect" title="DOM:table.deleteRow">table.deleteRow</a> </dt><dd> <b>deleteRow</b> removes a row.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var table = new Table();
