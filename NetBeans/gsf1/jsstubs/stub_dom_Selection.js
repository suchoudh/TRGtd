/**
* <h2> <span> Summary </span></h2>
* <p>The class of the object returned by <code><a href="window.getSelection" shape="rect" title="DOM:window.getSelection"> window.getSelection()</a></code> and other methods.
* </p>
* <h2> <span> Description </span></h2>
* <p>A selection object represents the <a href="DOM:range" shape="rect" title="DOM:range">ranges</a> that the user has selected. Typically, it holds only one range, accessed as follows:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = sel.getRangeAt(0);
* </pre>
* <p>Calling the <code><a href="Selection:toString" shape="rect" title="DOM:Selection:toString">toString()</a></code> method returns the text contained in the selection, e.g
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">selObj = window.getSelection();
* window.alert(selObj);
* </pre>
* <h2> <span> Glossary </span></h2>
* <p>Other key terms used in this section.
* </p>
* <dl><dt style="font-weight:bold">anchor
* </dt><dd>The anchor of a selection is the beginning point of the selection.  When making a selection with a mouse, the anchor is where in the document the mouse button is initially pressed.  As the user changes the selection using the mouse or the keyboard, the anchor does not move.
* </dd><dt style="font-weight:bold">focus
* </dt><dd>The focus of a selection is the end point of the selection.  When making a selection with a mouse, the focus is where in the document the mouse button is released.  As the user changes the selection using the mouse or the keyboard, the focus is the end of the selection that moves.
* </dd><dt style="font-weight:bold">range
* </dt><dd>A range is a contiguous part of a document.  A range can contain entire nodes as well as portions of nodes, such as a portion of a text node.  A user will normally only select a single range at a time, but it's possible for a user to select multiple ranges (e.g. by using the Control key).  A range can be retrieved from a selection as a <a href="DOM:range" shape="rect" title="DOM:range">range</a> object. Range objects can also be created via the DOM and programmatically added or removed from a selection.
* </dd></dl>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:Selection:anchorNode" shape="rect" title="DOM:Selection:anchorNode"> anchorNode</a></dt><dd> Returns the node in which the selection begins.
* </dd><dt style="font-weight:bold"><a href="Selection:anchorOffset" shape="rect" title="DOM:Selection:anchorOffset"> anchorOffset</a></dt><dd> Returns the number of characters that the selection's anchor is offset within the anchorNode.
* </dd><dt style="font-weight:bold"><a href="Selection:focusNode" shape="rect" title="DOM:Selection:focusNode"> focusNode</a></dt><dd> Returns the node in which the selection ends.
* </dd><dt style="font-weight:bold"><a href="Selection:focusOffset" shape="rect" title="DOM:Selection:focusOffset"> focusOffset</a></dt><dd> Returns the number of characters that the selection's focus is offset within the focusNode.
* </dd><dt style="font-weight:bold"><a href="Selection:isCollapsed" shape="rect" title="DOM:Selection:isCollapsed"> isCollapsed</a></dt><dd> Returns a boolean indicating whether the selection's start and end points are at the same position.
* </dd><dt style="font-weight:bold"><a href="Selection:rangeCount" shape="rect" title="DOM:Selection:rangeCount"> rangeCount</a></dt><dd> Returns the number of ranges in the selection.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:Selection:getRangeAt" shape="rect" title="DOM:Selection:getRangeAt"> getRangeAt</a></dt><dd> Returns a range object representing one of the ranges currently selected.
* </dd><dt style="font-weight:bold"><a href="Selection:collapse" shape="rect" title="DOM:Selection:collapse"> collapse</a></dt><dd> Collapses the current selection to a single point.
* </dd><dt style="font-weight:bold"><a href="Selection:extend" shape="rect" title="DOM:Selection:extend"> extend</a></dt><dd> Moves the focus of the selection to a specified point.
* </dd><dt style="font-weight:bold"><a href="Selection:collapseToStart" shape="rect" title="DOM:Selection:collapseToStart"> collapseToStart</a></dt><dd> Moves the focus of the selection to the same point at the anchor.
* </dd><dt style="font-weight:bold"><a href="Selection:collapseToEnd" shape="rect" title="DOM:Selection:collapseToEnd"> collapseToEnd</a></dt><dd> Moves the anchor of the selection to the same point as the focus. The focus does not move.
* </dd><dt style="font-weight:bold"><a href="Selection:selectAllChildren" shape="rect" title="DOM:Selection:selectAllChildren"> selectAllChildren</a></dt><dd> Adds all the children of the specified node to the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:addRange" shape="rect" title="DOM:Selection:addRange"> addRange</a></dt><dd> A range object that will be added to the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:removeRange" shape="rect" title="DOM:Selection:removeRange"> removeRange</a></dt><dd> Removes a range from the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:removeAllRanges" shape="rect" title="DOM:Selection:removeAllRanges"> removeAllRanges</a></dt><dd> Removes all ranges from the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:deleteFromDocument" shape="rect" title="DOM:Selection:deleteFromDocument"> deleteFromDocument</a></dt><dd> Deletes the selection's content from the document.
* </dd><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=Selection:selectionLanguageChange&amp;action=edit" shape="rect" title="DOM:Selection:selectionLanguageChange"> selectionLanguageChange</a></dt><dd>
* </dd><dt style="font-weight:bold"><a href="Selection:toString" shape="rect" title="DOM:Selection:toString"> toString</a></dt><dd> Returns a string currently being represented by the selection object, i.e. the currently selected text.
* </dd><dt style="font-weight:bold"><a href="Selection:containsNode" shape="rect" title="DOM:Selection:containsNode"> containsNode</a></dt><dd> Indicates if a certain node is part of the selection.
* </dd></dl>
* <h2> <span> See also </span></h2>
* <p><a href="DOM:window.getSelection" shape="rect" title="DOM:window.getSelection">window.getSelection</a>,
* <a href="range" shape="rect" title="DOM:range">Range</a>
* </p>
* <h2> <span> External links </span></h2>
* <ul><li> <a href="http://lxr.mozilla.org/mozilla/source/content/base/public/nsISelection.idl" rel="nofollow" shape="rect" title="http://lxr.mozilla.org/mozilla/source/content/base/public/nsISelection.idl">IDL definition in Mozilla cross-reference</a>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Selection = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span> Summary </span></h2>
* <p>Adds a range to the selection.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.addRange(<i>range</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>range</code></i>
* </dt><dd>A <a href="range" shape="rect" title="DOM:range">range</a> object that will be added to the selection.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> / * Select all STRONG elements in an HTML document * /
* var strongs = document.getElementsByTagName("strong");
* var s = window.getSelection();
* if(s.rangeCount &gt; 0) s.removeAllRanges();
* for(var i = 0; i &lt; strongs.length; i++) {
* var range = document.createRange();
* range.selectNode(strongs[i]);
* s.addRange(range);
* }
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
addRange: function(range) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the node in which the selection begins.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.anchorNode
* </pre>
* <h2> <span> Notes </span></h2>
* <p>A user may make a selection from left to right (in document order) or right to left (reverse of document order).  The anchor is where the user began the selection.  This can be visualized by holding the Shift key and pressing the arrow keys on your keyboard.  The selection's anchor does not move, but the selection's focus, the other end of the selection, does move.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
anchorNode: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the number of characters that the selection's anchor is offset within the <a href="Selection:anchorNode" shape="rect" title="DOM:Selection:anchorNode">anchorNode</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.anchorOffset
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This number is zero-based.  If the selection begins with the first character in the <a href="Selection:anchorNode" shape="rect" title="DOM:Selection:anchorNode">anchorNode</a>, 0 is returned.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
anchorOffset: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Collapses the current selection to a single point.  The document is not modified.  If the content is focused and editable, the caret will blink there.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.collapse(<i>parentNode</i>, <i>offset</i>);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>parentNode</code></i>
* </dt><dd>The caret location will be within this node.
* </dd></dl>
* <dl><dt style="font-weight:bold"><i><code>offset</code></i>
* </dt><dd>The caret will be placed this number of character from the beginning of the <i><code>parentNode</code>'</i>s text.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">/ * Place the caret at the beginning of an HTML document's body. * /
* var body = document.getElementsByTagName("body")[0];
* window.getSelection().collapse(body,0);
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
collapse: function(parentNode, offset) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Moves the anchor of the selection to the same point as the focus.  The focus does not move.  If the content is focused and editable, the caret will blink there.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.collapseToEnd()
* </pre>
* <h2> <span> Parameters </span></h2>
* <p>None.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
collapseToEnd: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Moves the focus of the selection to the same point at the anchor.  The anchor does not move.  If the content is focused and editable, the caret will blink there.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.collapseToStart()
* </pre>
* <h2> <span> Parameters </span></h2>
* <p>None.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
collapseToStart: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Indicates if the node is part of the selection.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.containsNode(<i>aNode</i>, <i>aPartlyContained</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>aNode</code></i>
* </dt><dd>The node that is being looked for whether it is part of the selection
* </dd><dt style="font-weight:bold"><i><code>aPartlyContained</code></i>
* </dt><dd>When <i>true</i>, <code>containsNode</code> returns true when a part of the node is part of the selection.
* </dd><dd>When <i>false</i>, <code>containsNode</code> only returns true when the entire node is part of the selection.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> / * Check to see if anything inside the body element is selected * /
* alert(window.getSelection().containsNode(document.body, true));
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
containsNode: function(aNode, aPartlyContained) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Deletes the actual text being represented by a selection object from the document's DOM.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.deleteFromDocument()
* </pre>
* <h2> <span> Parameters </span></h2>
* <p>None.
* </p>
* <h2> <span> Examples </span></h2>
* <p>A user selects the (imaginary) text "ve two ea" from "Rabbits have two ears." on a web page. The user then clicks a button that executes the JavaScript snippet <code>window.getSelection().deleteFromDocument()</code>. The document's text becomes "Rabbits hars."
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteFromDocument: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Moves the focus of the selection to a specified point.  The anchor of the selection does not move.  The selection will be from the anchor to the new focus regardless of direction.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.extend(<i>parentNode</i>, <i>offset</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>parentNode</code></i>
* </dt><dd>The node within which the focus will be moved.
* </dd></dl>
* <dl><dt style="font-weight:bold"><i><code>offset</code></i>
* </dt><dd>The number of characters from the beginning of <i><code>parentNode</code>'</i>s text the focus will be placed.
* </dd></dl>
* <p>}
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
extend: function(parentNode, offset) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the node in which the selection ends.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.focusNode
* </pre>
* <h2> <span> Notes </span></h2>
* <p>A user may make a selection from left to right (in document order) or right to left (reverse of document order).  The focus is where the user ended the selection.  This can be visualized by holding the Shift key and pressing the arrow keys on your keyboard to modify the current selection.  The selection's focus moves, but the selection's anchor, the other end of the selection, does not move.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
focusNode: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the number of characters that the selection's focus is offset within the <a href="Selection:focusNode" shape="rect" title="DOM:Selection:focusNode">focusNode</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.focusOffset
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This number is zero-based.  If the selection ends with the first character in the <a href="Selection:focusNode" shape="rect" title="DOM:Selection:focusNode">focusNode</a>, 0 is returned.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
focusOffset: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a range object representing one of the ranges currently selected.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>range</i> = <i>sel</i>.getRangeAt(<i>index</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>range</code></i>
* </dt><dd>The <a href="range" shape="rect" title="DOM:range">range</a> object that will be returned.
* </dd></dl>
* <dl><dt style="font-weight:bold"><i><code>index</code></i>
* </dt><dd>The zero-based index of the range to return.  A negative number or a number greater than or equal to <a href="Selection:rangeCount" shape="rect" title="DOM:Selection:rangeCount">rangeCount</a> will result in an error.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">ranges = [];
* sel = window.getSelection();
* for(var i = 0; i &lt; sel.rangeCount; i++) {
* ranges[i] = sel.getRangeAt(i);
* }
* / * Each item in the ranges array is now
* * a range object representing one of the
* * ranges in the current selection * /
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
getRangeAt: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a boolean indicating whether the selection's start and end points are at the same position.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.isCollapsed
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Even a collapsed selection may have a rangeCount greater than 0.  <code>sel.getRangeAt(0)</code> may return a range that is also collapsed.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
isCollapsed: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the number of ranges in the selection.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.rangeCount
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Before the user has clicked a freshly loaded page, the <code>rangeCount</code> is 0.  A user can normally only select one range at a time, so the <code>rangeCount</code> will usually be 1. Scripting can be use to make the selection contain more than 1 range.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
rangeCount: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Removes all ranges from the selection, leaving the <a href="Selection:anchorNode" shape="rect" title="DOM:Selection:anchorNode">anchorNode</a> and <a href="Selection:focusNode" shape="rect" title="DOM:Selection:focusNode">focusNode</a> properties equal to <code>null</code> and leaving nothing selected.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.removeAllRanges();
* </pre>
* <h2> <span> Parameters </span></h2>
* <p>None.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
removeAllRanges: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Removes a range from the selection.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.removeRange(<i>range</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>range</code></i>
* </dt><dd>A range object that will be removed to the selection.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">/ * Programmaticaly, more than one range can be selected.
* * This will remove all ranges except the first. * /
* s = window.getSelection();
* if(s.rangeCount &gt; 1) {
* for(var i = 1; i &lt; s.rangeCount; i++) {
* s.removeRange(s.getRangeAt(i));
* }
* }
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
removeRange: function(range) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Adds all the children of the specified node to the selection.  Previous selection is lost.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>sel</i>.selectAllChildren(<i>parentNode</i>)
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"><i><code>parentNode</code></i>
* </dt><dd>All children of <i><code>parentNode</code></i> will be selected.  <i><code>parentNode</code></i> itself is not part of the selection.
* </dd></dl>
* <h2> <span> Examples </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">footer = document.getElementById("footer");
* window.getSelection().selectAllChildren(footer);
* / * Everything inside the footer is now selected * /
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
selectAllChildren: function(parentNode) {
  // This is just a stub for a builtin native JavaScript object.
},
selectionLanguageChange: function(rtlflag) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a string currently being represented by the selection object, i.e. the currently selected text.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = <i>sel</i>.toString()
* </pre>
* <ul><li> <code>string</code> is the string representation of selection.
* </li></ul>
* <h2> <span> Parameters </span></h2>
* <p>None.
* </p>
* <h2> <span> Description </span></h2>
* <p>This method returns the currently selected text.
* </p><p>In <a href="http://developer.mozilla.org/en/docs/JavaScript" shape="rect" title="JavaScript">JavaScript</a>, this method is called automatically when a function the selection object is passed to requires a string:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">alert(window.getSelection()) // What is called
* alert(window.getSelection().toString())  // What is actually being effectively called.
* </pre>
* <h2> <span> See Also </span></h2>
* <ul><li> <a href="http://developer.mozilla.org/en/docs/Core_JavaScript_1.5_Reference:Objects:Object:toString" shape="rect" title="Core JavaScript 1.5 Reference:Objects:Object:toString">Object.toString</a>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
toString: function() {
  // This is just a stub for a builtin native JavaScript object.
},
};

/**
* <h2> <span> Summary </span></h2>
* <p>The class of the object returned by <code><a href="window.getSelection" shape="rect" title="DOM:window.getSelection"> window.getSelection()</a></code> and other methods.
* </p>
* <h2> <span> Description </span></h2>
* <p>A selection object represents the <a href="DOM:range" shape="rect" title="DOM:range">ranges</a> that the user has selected. Typically, it holds only one range, accessed as follows:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = sel.getRangeAt(0);
* </pre>
* <p>Calling the <code><a href="Selection:toString" shape="rect" title="DOM:Selection:toString">toString()</a></code> method returns the text contained in the selection, e.g
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">selObj = window.getSelection();
* window.alert(selObj);
* </pre>
* <h2> <span> Glossary </span></h2>
* <p>Other key terms used in this section.
* </p>
* <dl><dt style="font-weight:bold">anchor
* </dt><dd>The anchor of a selection is the beginning point of the selection.  When making a selection with a mouse, the anchor is where in the document the mouse button is initially pressed.  As the user changes the selection using the mouse or the keyboard, the anchor does not move.
* </dd><dt style="font-weight:bold">focus
* </dt><dd>The focus of a selection is the end point of the selection.  When making a selection with a mouse, the focus is where in the document the mouse button is released.  As the user changes the selection using the mouse or the keyboard, the focus is the end of the selection that moves.
* </dd><dt style="font-weight:bold">range
* </dt><dd>A range is a contiguous part of a document.  A range can contain entire nodes as well as portions of nodes, such as a portion of a text node.  A user will normally only select a single range at a time, but it's possible for a user to select multiple ranges (e.g. by using the Control key).  A range can be retrieved from a selection as a <a href="DOM:range" shape="rect" title="DOM:range">range</a> object. Range objects can also be created via the DOM and programmatically added or removed from a selection.
* </dd></dl>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:Selection:anchorNode" shape="rect" title="DOM:Selection:anchorNode"> anchorNode</a></dt><dd> Returns the node in which the selection begins.
* </dd><dt style="font-weight:bold"><a href="Selection:anchorOffset" shape="rect" title="DOM:Selection:anchorOffset"> anchorOffset</a></dt><dd> Returns the number of characters that the selection's anchor is offset within the anchorNode.
* </dd><dt style="font-weight:bold"><a href="Selection:focusNode" shape="rect" title="DOM:Selection:focusNode"> focusNode</a></dt><dd> Returns the node in which the selection ends.
* </dd><dt style="font-weight:bold"><a href="Selection:focusOffset" shape="rect" title="DOM:Selection:focusOffset"> focusOffset</a></dt><dd> Returns the number of characters that the selection's focus is offset within the focusNode.
* </dd><dt style="font-weight:bold"><a href="Selection:isCollapsed" shape="rect" title="DOM:Selection:isCollapsed"> isCollapsed</a></dt><dd> Returns a boolean indicating whether the selection's start and end points are at the same position.
* </dd><dt style="font-weight:bold"><a href="Selection:rangeCount" shape="rect" title="DOM:Selection:rangeCount"> rangeCount</a></dt><dd> Returns the number of ranges in the selection.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:Selection:getRangeAt" shape="rect" title="DOM:Selection:getRangeAt"> getRangeAt</a></dt><dd> Returns a range object representing one of the ranges currently selected.
* </dd><dt style="font-weight:bold"><a href="Selection:collapse" shape="rect" title="DOM:Selection:collapse"> collapse</a></dt><dd> Collapses the current selection to a single point.
* </dd><dt style="font-weight:bold"><a href="Selection:extend" shape="rect" title="DOM:Selection:extend"> extend</a></dt><dd> Moves the focus of the selection to a specified point.
* </dd><dt style="font-weight:bold"><a href="Selection:collapseToStart" shape="rect" title="DOM:Selection:collapseToStart"> collapseToStart</a></dt><dd> Moves the focus of the selection to the same point at the anchor.
* </dd><dt style="font-weight:bold"><a href="Selection:collapseToEnd" shape="rect" title="DOM:Selection:collapseToEnd"> collapseToEnd</a></dt><dd> Moves the anchor of the selection to the same point as the focus. The focus does not move.
* </dd><dt style="font-weight:bold"><a href="Selection:selectAllChildren" shape="rect" title="DOM:Selection:selectAllChildren"> selectAllChildren</a></dt><dd> Adds all the children of the specified node to the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:addRange" shape="rect" title="DOM:Selection:addRange"> addRange</a></dt><dd> A range object that will be added to the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:removeRange" shape="rect" title="DOM:Selection:removeRange"> removeRange</a></dt><dd> Removes a range from the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:removeAllRanges" shape="rect" title="DOM:Selection:removeAllRanges"> removeAllRanges</a></dt><dd> Removes all ranges from the selection.
* </dd><dt style="font-weight:bold"><a href="Selection:deleteFromDocument" shape="rect" title="DOM:Selection:deleteFromDocument"> deleteFromDocument</a></dt><dd> Deletes the selection's content from the document.
* </dd><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=Selection:selectionLanguageChange&amp;action=edit" shape="rect" title="DOM:Selection:selectionLanguageChange"> selectionLanguageChange</a></dt><dd>
* </dd><dt style="font-weight:bold"><a href="Selection:toString" shape="rect" title="DOM:Selection:toString"> toString</a></dt><dd> Returns a string currently being represented by the selection object, i.e. the currently selected text.
* </dd><dt style="font-weight:bold"><a href="Selection:containsNode" shape="rect" title="DOM:Selection:containsNode"> containsNode</a></dt><dd> Indicates if a certain node is part of the selection.
* </dd></dl>
* <h2> <span> See also </span></h2>
* <p><a href="DOM:window.getSelection" shape="rect" title="DOM:window.getSelection">window.getSelection</a>,
* <a href="range" shape="rect" title="DOM:range">Range</a>
* </p>
* <h2> <span> External links </span></h2>
* <ul><li> <a href="http://lxr.mozilla.org/mozilla/source/content/base/public/nsISelection.idl" rel="nofollow" shape="rect" title="http://lxr.mozilla.org/mozilla/source/content/base/public/nsISelection.idl">IDL definition in Mozilla cross-reference</a>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var selection = new Selection();
