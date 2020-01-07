/**
* <p>The <code>Range</code> object represents a fragment of a document that can contain nodes and parts of text nodes in a given document.
* </p><p>A range can be created using the <code><a href="DOM:document.createRange" shape="rect" title="DOM:document.createRange">createRange</a></code> method of the <code><a href="document" shape="rect" title="DOM:document">Document</a></code> object.  Range objects can also be retrieved by using the <code><a href="Selection:getRangeAt" shape="rect" title="DOM:Selection:getRangeAt">getRangeAt</a></code> method of the <code><a href="Selection" shape="rect" title="DOM:Selection">selection</a></code> object.
* </p>
* 
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:range.collapsed" shape="rect" title="DOM:range.collapsed">collapsed</a>
* </dt><dd>Returns a boolean indicating whether the range's start and end points are at the same position.
* </dd><dt style="font-weight:bold"><a href="range.commonAncestorContainer" shape="rect" title="DOM:range.commonAncestorContainer">commonAncestorContainer</a>
* </dt><dd>Returns the deepest Node that contains the startContainer and endContainer Nodes.
* </dd><dt style="font-weight:bold"><a href="range.endContainer" shape="rect" title="DOM:range.endContainer">endContainer</a>
* </dt><dd>Returns the Node within which the Range ends.
* </dd><dt style="font-weight:bold"><a href="range.endOffset" shape="rect" title="DOM:range.endOffset">endOffset</a>
* </dt><dd>Returns a number representing where in the endContainer the Range ends.
* </dd><dt style="font-weight:bold"><a href="range.startContainer" shape="rect" title="DOM:range.startContainer">startContainer</a>
* </dt><dd>Returns the Node within which the Range starts.
* </dd><dt style="font-weight:bold"><a href="range.startOffset" shape="rect" title="DOM:range.startOffset">startOffset</a>
* </dt><dd>Returns a number representing where in the startContainer the Range starts.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <h3> <span> Positioning Methods </span></h3>
* <p>These methods set the start and end points of a range.
* </p>
* <dl><dt style="font-weight:bold"><a href="range.setStart" shape="rect" title="DOM:range.setStart">setStart</a>
* </dt><dd>Sets the start position of a Range.
* </dd><dt style="font-weight:bold"><a href="range.setEnd" shape="rect" title="DOM:range.setEnd">setEnd</a>
* </dt><dd>Sets the end position of a Range.
* </dd><dt style="font-weight:bold"><a href="range.setStartBefore" shape="rect" title="DOM:range.setStartBefore">setStartBefore</a>
* </dt><dd>Sets the start position of a Range relative to another Node.
* </dd><dt style="font-weight:bold"><a href="range.setStartAfter" shape="rect" title="DOM:range.setStartAfter">setStartAfter</a>
* </dt><dd>Sets the start position of a Range relative to another Node.
* </dd><dt style="font-weight:bold"><a href="range.setEndBefore" shape="rect" title="DOM:range.setEndBefore">setEndBefore</a>
* </dt><dd>Sets the end position of a Range relative to another Node.
* </dd><dt style="font-weight:bold"><a href="range.setEndAfter" shape="rect" title="DOM:range.setEndAfter">setEndAfter</a>
* </dt><dd>Sets the end position of a Range relative to another Node.
* </dd><dt style="font-weight:bold"><a href="range.selectNode" shape="rect" title="DOM:range.selectNode">selectNode</a>
* </dt><dd>Sets the Range to contain the node and its contents.
* </dd><dt style="font-weight:bold"><a href="range.selectNodeContents" shape="rect" title="DOM:range.selectNodeContents">selectNodeContents</a>
* </dt><dd>Sets the Range to contain the contents of a Node.
* </dd><dt style="font-weight:bold"><a href="range.collapse" shape="rect" title="DOM:range.collapse">collapse</a>
* </dt><dd>Collapses the Range to one of its boundary points.
* </dd></dl>
* <h3> <span> Editing Methods </span></h3>
* <p>These methods retrieve Nodes from a range and modify the contents of a range.
* </p>
* <dl><dt style="font-weight:bold"><a href="DOM:range.cloneContents" shape="rect" title="DOM:range.cloneContents">cloneContents</a>
* </dt><dd>Returns a document fragment copying the nodes of a Range.
* </dd><dt style="font-weight:bold"><a href="range.deleteContents" shape="rect" title="DOM:range.deleteContents">deleteContents</a>
* </dt><dd>Removes the contents of a Range from the document.
* </dd><dt style="font-weight:bold"><a href="range.extractContents" shape="rect" title="DOM:range.extractContents">extractContents</a>
* </dt><dd>Moves contents of a Range from the document tree into a document fragment
* </dd><dt style="font-weight:bold"><a href="range.insertNode" shape="rect" title="DOM:range.insertNode">insertNode</a>
* </dt><dd>Insert a node at the start of a Range.
* </dd><dt style="font-weight:bold"><a href="range.surroundContents" shape="rect" title="DOM:range.surroundContents">surroundContents</a>
* </dt><dd>Moves content of a Range into a new node.
* </dd></dl>
* <h3> <span> Other Methods </span></h3>
* <dl><dt style="font-weight:bold"><a href="DOM:range.compareBoundaryPoints" shape="rect" title="DOM:range.compareBoundaryPoints">compareBoundaryPoints</a>
* </dt><dd>Compares the boundary points of two Ranges.
* </dd><dt style="font-weight:bold"><a href="range.cloneRange" shape="rect" title="DOM:range.cloneRange">cloneRange</a>
* </dt><dd>Returns a Range object with boundary points identical to the cloned Range.
* </dd><dt style="font-weight:bold"><a href="range.detach" shape="rect" title="DOM:range.detach">detach</a>
* </dt><dd>Releases Range from use to improve performance.
* </dd><dt style="font-weight:bold"><a href="range.toString" shape="rect" title="DOM:range.toString">toString</a>
* </dt><dd>Returns the text of the Range
* </dd></dl>
* <h3> <span> Gecko Methods </span></h3>
* <p>This section describes <code>Range</code> methods that are particular to Mozilla and not part of the W3C DOM specifications.
* </p>
* <dl><dt style="font-weight:bold"><a href="DOM:range.compareNode" shape="rect" title="DOM:range.compareNode">compareNode</a> <span style="border: 1px solid #FF9999; background-color: #FFDBDB; font-size: 9px; vertical-align: text-top;">Obsolete</span>
* </dt><dd>Returns a constant representing whether the node is before, after, inside, or surrounding the range.
* </dd><dt style="font-weight:bold"><a href="range.comparePoint" shape="rect" title="DOM:range.comparePoint">comparePoint</a>
* </dt><dd>Returns -1, 0, or 1 indicating whether the point occurs before, inside, or after the range.
* </dd><dt style="font-weight:bold"><a href="range.createContextualFragment" shape="rect" title="DOM:range.createContextualFragment">createContextualFragment</a>
* </dt><dd>Returns a document fragment created from a given string of code.
* </dd><dt style="font-weight:bold"><a href="range.intersectsNode" shape="rect" title="DOM:range.intersectsNode">intersectsNode</a> <span style="border: 1px solid #FF9999; background-color: #FFDBDB; font-size: 9px; vertical-align: text-top;">Obsolete</span>
* </dt><dd>Returns a boolean indicating whether the given node intersects the range.
* </dd><dt style="font-weight:bold"><a href="range.isPointInRange" shape="rect" title="DOM:range.isPointInRange">isPointInRange</a>
* </dt><dd>Returns a boolean indicating whether the given point is in the range.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Range = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Compare end boundary-point of sourceRange to end
 * boundary-point of Range on which compareBoundaryPoints
 * is invoked.
 * @type Number
 */
END_TO_END: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Compare end boundary-point of sourceRange to start
 * boundary-point of Range on which compareBoundaryPoints
 * is invoked.
 * @type Number
 */
END_TO_START: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Compare start boundary-point of sourceRange to end
 * boundary-point of Range on which compareBoundaryPoints
 * is invoked.
 * @type Number
 */
START_TO_END: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Compare start boundary-point of sourceRange to
 * start boundary-point of Range on which
 * compareBoundaryPoints is invoked.
 * @type Number
 */
START_TO_START: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a document fragment copying the nodes of a Range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">documentFragment = range.cloneContents();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* documentFragment = range.cloneContents();
* document.body.appendChild(documentFragment);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Event Listeners added using DOM Events are not copied during cloning. HTML attribute events are duplicated as they are for the DOM Core cloneNode method. HTML id attributes are also cloned, which can lead to an invalid document through cloning.
* </p><p>Partially selected nodes include the parent tags necessary to make the document fragment valid.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-cloneContents" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-cloneContents">cloneContents</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Duplicates the contents of a Range
 * @return DocumentFragment A DocumentFragment that contains content equivalent to this
 * Range.
 * @type DocumentFragment
 */
cloneContents: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a Range object with boundary points identical to the cloned Range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">clone = range.cloneRange();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* clone = range.cloneRange();
* </pre>
* <h2> <span> Notes </span></h2>
* <p>clone is copied by value, not reference, so a change in either Range does not effect the other.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-clone" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-clone">cloneRange</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Produces a new Range whose boundary-points are
 * equal to the boundary-points of the Range.
 * @return Range The duplicated Range.
 * @type Range
 */
cloneRange: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Collapses the Range to one of its boundary points.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.collapse(toStart);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold">toStart </dt><dd> A boolean, true collapses the Range to its start, false to its end.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.selectNode(referenceNode);
* range.collapse(true);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>A collapsed Range is empty, containing no content, specifying a single-point in a DOM tree. To determine if a Range is already collapsed, see the <a href="range.collapsed" shape="rect" title="DOM:range.collapsed">collapsed</a> property.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-collapse" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-collapse">collapse</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Collapse a Range onto one of its
 * boundary-points
 * @param {Boolean} toStart of type boolean If TRUE, collapses the Range onto its start; if FALSE,
 * collapses it onto its end.
 * @type void
 */
collapse: function(toStart) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a boolean indicating whether the range's start and end points are at the same position.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">isCollapsed = range.collapsed;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* isCollapsed = range.collapsed;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Returns a boolean of true if the start and end boundary points of the Range are the same point in the DOM, false if not.
* </p><p>A collapsed Range is empty, containing no content, specifying a single-point in a DOM tree. The collapsed property is read-only. To collapse a range, see the <a href="DOM:range.collapse" shape="rect" title="DOM:range.collapse"> collapse</a> method.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-collapsed" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-collapsed">collapsed</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * TRUE if the Range is collapsed
 * @type Boolean
 */
collapsed: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the deepest Node that contains the <a href="range.startContainer" shape="rect" title="DOM:range.startContainer"> startContainer</a> and <a href="range.endContainer" shape="rect" title="DOM:range.endContainer"> endContainer</a> Nodes.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">rangeAncestor = range.commonAncestorContainer;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* rangeAncestor = range.commonAncestorContainer;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Returns the deepest, or further down the document tree, Node that contains both the <a href="DOM:range.startContainer" shape="rect" title="DOM:range.startContainer"> startContainer</a> and <a href="range.endContainer" shape="rect" title="DOM:range.endContainer"> endContainer</a> nodes. Since a Range need not be continuous, and may also partially select Nodes, this is a convenient way to find a Node which encloses a Range.
* </p><p>This property is read-only. To change the ancestor container of a Node, consider using the various methods to set the start and end positions of the Range.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-commonParent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-commonParent">commonAncestorContainer</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The deepest
 * common ancestor
 * container of the Range's two boundary-points.
 * @type Node
 */
commonAncestorContainer: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Compares the boundary points of two <a href="range" shape="rect" title="DOM:range">Ranges</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>compare</i> = <i>range</i>.compareBoundaryPoints(<i>how</i>, <i>sourceRange</i>);
* </pre>
* <dl><dt style="font-weight:bold"> compare </dt><dd> A number, -1, 0, or 1, indicating whether the corresponding boundary-point of <i>range</i> is respectively before, equal to, or after the corresponding boundary-point of <code>sourceRange</code>.
* </dd><dt style="font-weight:bold"> how </dt><dd> A constant describing the comparison method, one of values described below.
* </dd><dt style="font-weight:bold"> sourceRange </dt><dd> A <a href="DOM:range" shape="rect" title="DOM:range">Range</a> to compare boundary points with range
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var range, sourceRange, compare;
* range = document.createRange();
* range.selectNode(document.getElementsByTagName("div")[0]);
* sourceRange = document.createRange();
* sourceRange.selectNode(document.getElementsByTagName("div")[1]);
* compare = range.compareBoundaryPoints(Range.START_TO_END, sourceRange);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Any of the following constants can be passed as the value of <i>how</i> parameter:
* </p>
* <ul><li> <code>Range.END_TO_END</code> compares the end boundary-point of <code>sourceRange</code> to the end boundary-point of <code>range</code>.
* </li><li> <code>Range.END_TO_START</code> compares the end boundary-point of <code>sourceRange</code> to the start boundary-point of <code>range</code>.
* </li><li> <code>Range.START_TO_END</code> compares the start boundary-point of <code>sourceRange</code> to the end boundary-point of <code>range</code>.
* </li><li> <code>Range.START_TO_START</code> compares the start boundary-point of <code>sourceRange</code> to the start boundary-point of <code>range</code>.
* </li></ul>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-compareBoundaryPoints" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-compareBoundaryPoints">DOM Level 2 Traversal: compareBoundaryPoints</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Compare the boundary-points of two Ranges in a
 * document.
 * @param {Number} how of type unsigned
 * short A code representing the type of comparison, as defined
 * above.
 * @param {Range} sourceRange of type Range The Range on which this current Range is compared to.
 * @return short -1, 0 or 1 depending on whether the corresponding boundary-point
 * of the Range is respectively before, equal to, or after the
 * corresponding boundary-point of sourceRange .
 * @type short
 */
compareBoundaryPoints: function(how, sourceRange) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #FF5151; background-color: #FEBCBC; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Obsolete</p></div>
* <p>Returns a constant (see notes).
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">returnValue = range.compareNode( referenceNode );
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to compare with the <code>Range</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* returnValue = range.compareNode(document.getElementsByTagName("p").item(0));
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This method is obsolete; you should use the W3C DOM Range methods (see <code><a href="range.compareBoundaryPoints" shape="rect" title="DOM:range.compareBoundaryPoints">compareBoundaryPoints()</a></code>).
* </p>
* <div><b>Warning:</b> This method <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">has been removed</a> from <a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a> 1.9 and will not exist in future versions of Firefox; you should switch to <code>compareBoundaryPoints()</code> as soon as possible.</div>
* <p>The following function can be used as replacement:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function rangeCompareNode(range, node) {
* var nodeRange = node.ownerDocument.createRange();
* try {
* nodeRange.selectNode(node);
* }
* catch (e) {
* nodeRange.selectNodeContents(node);
* }
* var nodeIsBefore = range.compareBoundaryPoints(Range.START_TO_START, nodeRange) == 1;
* var nodeIsAfter = range.compareBoundaryPoints(Range.END_TO_END, nodeRange) == -1;
* 
* if (nodeIsBefore &amp;&amp; !nodeIsAfter)
* return 0;
* if (!nodeIsBefore &amp;&amp; nodeIsAfter)
* return 1;
* if (nodeIsBefore &amp;&amp; nodeIsAfter)
* return 2;
* 
* return 3;
* }
* </pre>
* <p>The above method returns one of this constants:
* </p>
* <dl><dt style="font-weight:bold"> NODE_BEFORE = 0 </dt><dd> Node starts before the Range
* </dd><dt style="font-weight:bold"> NODE_AFTER = 1 </dt><dd> Node ends after the Range
* </dd><dt style="font-weight:bold"> NODE_BEFORE_AND_AFTER = 2 </dt><dd> Node starts before and ends after the Range
* </dd><dt style="font-weight:bold"> NODE_INSIDE = 3 </dt><dd> Node starts after and ends before the Range, i.e. the Node is completely selected by the Range.
* </dd></dl>
* <h2> <span> Specification </span></h2>
* <p>This method is not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
compareNode: function( referenceNode ) { // COMPAT=FF1|FF2|FF3
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns -1, 0, or 1 depending on whether the <code>referenceNode</code> is before, the same as, or after the range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">returnValue = range.comparePoint( referenceNode, offset )
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to compare with the <code>Range</code>.
* </dd><dt style="font-weight:bold"> offset </dt><dd> An integer greater than or equal to zero representing the offset inside the <code>referenceNode</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* returnValue = range.comparePoint(document.getElementsByTagName("p").item(0),1);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If the <code>referenceNode</code> is a <code>Node</code> of type <code>Text</code>, <code>Comment</code>, or <code>CDATASection</code>, then offset is the number of characters from the start of <code>referenceNode</code>. For other <code>Node</code> types, offset is the number of child nodes between the start of the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>This method is not part of a specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
comparePoint: function( referenceNode, offset ) { // COMPAT=FF1|FF2|FF3
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a document fragment.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">documentFragment = range.createContextualFragment( tagString )
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> tagString </dt><dd> Text that contains text and tags to be converted to a document fragment.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var tagString = "&lt;div&gt;I am a div node&lt;/div&gt;";
* var range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* var documentFragment = range.createContextualFragment(tagString);
* document.body.appendChild(documentFragment);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This method takes a string and uses Mozilla's parser to convert it to a DOM tree.
* </p>
* <h2> <span> Specification </span></h2>
* <p>This method is not part of a specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createContextualFragment: function( tagString ) { // COMPAT=FF1|FF2|FF3
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Removes the contents of a Range from the document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.deleteContents()
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* range.deleteContents();
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Unlike extractContents, this method does not return a documentFragment containing the deleted content.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-deleteContents" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-deleteContents">deleteContents</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Removes the contents of a Range from the
 * containing document or document fragment without returning a
 * reference to the removed content.
 * @type void
 */
deleteContents: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Releases Range from use to improve performance.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.detach();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* range.detach();
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Allows mozilla to relinquish resources associated with this Range. Subsequent attempts to use the detached range will result in a DOMException being thrown with an error code of INVALID_STATE_ERR.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-detach" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-detach">detach</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Detaches the NodeIterator from the
 * set which it iterated over, releasing any computational resources
 * and placing the iterator in the INVALID state. After detach has been invoked, calls to nextNode or previousNode will raise the
 * exception INVALID_STATE_ERR.
 * @type void
 */
detach: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the Node within which the Range ends.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">endRangeNode = range.endContainer;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* endRangeNode = range.endContainer;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Returns a reference to the Node in the document within which the Range ends. This property is read-only. To change the end position of a node, use the <a href="DOM:range.setEnd" shape="rect" title="DOM:range.setEnd"> setEnd</a> method or a similar method.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-endParent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-endParent">endContainer</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Node within which the Range ends
 * @type Node
 */
endContainer: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a number representing where in the <a href="range.endContainer" shape="rect" title="DOM:range.endContainer"> endContainer</a> the Range ends.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">endRangeOffset = range.endOffset;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* endRangeOffset = range.endOffset;
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>endOffset</code> has two meanings. If the <code>endContainer</code> is a <code>Node</code> of type <code>Text</code>, <code>Comment</code>, or <code>CDATASection</code>, then the offset is the number of characters from the start of the <code>endContainer</code> to the boundary point of the Range. For other <code>Node</code> types, the endOffset is the number of child nodes between the start of the endContainer and the boundary point of the Range. This property is read-only. To change the endOffset of a Range, use one of the setEnd methods.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-endOffset" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-endOffset">endOffset</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Offset within the ending node of the Range.
 * @type Number
 */
endOffset: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Moves contents of a Range from the document tree into a document fragment.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">documentFragment = range.extractContents();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* documentFragment = range.extractContents();
* document.body.appendChild(documentFragment);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Event Listeners added using DOM Events are not retained during extraction. HTML attribute events are retained or duplicated as they are for the DOM Core cloneNode method. HTML id attributes are also cloned, which can lead to an invalid document if a partially-selected node is extracted and appened to the document.
* </p><p>Partially selected nodes are cloned to include the parent tags necessary to make the document fragment valid.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-extractContents" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-extractContents">extractContents</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Moves the contents of a Range from the
 * containing document or document fragment to a new DocumentFragment.
 * @return DocumentFragment A DocumentFragment containing the extracted contents.
 * @type DocumentFragment
 */
extractContents: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Insert a node at the start of a Range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.insertNode(newNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> newNode </dt><dd> is a Node.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* newNode = document.createElement("p");
* newNode.appendChild(document.createTextNode("New Node Inserted Here"));
* range.selectNode(document.getElementsByTagName("div").item(0));
* range.insertNode(newNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>newNode is inserted at the start boundary point of the Range. If the newNodes is to be added to a text Node, that Node is split at the insertion point, and the insertion occurs between the two text Nodes (Blocked by <a href="http://bugzilla.mozilla.org/show_bug.cgi?id=135922" rel="nofollow" shape="rect" title="http://bugzilla.mozilla.org/show_bug.cgi?id=135922">http://bugzilla.mozilla.org/show_bug.cgi?id=135922</a> )
* </p><p>If newNode is a document fragment, the children of the document fragment are inserted instead.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-insertNode" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-insertNode">insertNode</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Inserts a node into the Document or
 * DocumentFragment at the start of the Range. If the container is a
 * Text node, this will be split at the start of the Range (as if the
 * Text node's splitText method was performed at the insertion point)
 * and the insertion will occur between the two resulting Text nodes.
 * Adjacent Text nodes will not be automatically merged. If the node
 * to be inserted is a DocumentFragment node, the children will be
 * inserted rather than the DocumentFragment node itself.
 * @param {Node} newNode of type Node The node to insert at the start of the Range
 * @type void
 */
insertNode: function(newNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #FF5151; background-color: #FEBCBC; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Obsolete</p></div>
* <p>Returns a boolean indicating whether the given node intersects the range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">bool = range.intersectsNode( referenceNode )
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to compare with the <code>Range</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* bool = range.intersectsNode(document.getElementsByTagName("p").item(0));
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This method is obsolete; you should instead use the W3C DOM Range methods (see <code><a href="range.compareBoundaryPoints" shape="rect" title="DOM:range.compareBoundaryPoints">compareBoundaryPoints()</a></code>).
* </p>
* <div><b>Warning:</b> This method <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">has been removed</a> from <a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a> 1.9 and will not exist in future versions of Firefox; you should switch to <code>compareBoundaryPoints()</code> as soon as possible.</div>
* <p>The following function can be used as replacement:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function rangeIntersectsNode(range, node) {
* var nodeRange = node.ownerDocument.createRange();
* try {
* nodeRange.selectNode(node);
* }
* catch (e) {
* nodeRange.selectNodeContents(node);
* }
* 
* return range.compareBoundaryPoints(Range.END_TO_START, nodeRange) == -1 &amp;&amp;
* range.compareBoundaryPoints(Range.START_TO_END, nodeRange) == 1;
* }
* </pre>
* <h2> <span> Specification </span></h2>
* <p>This method is not part of a specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
intersectsNode: function( referenceNode ) { // COMPAT=FF1|FF2|FF3
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a boolean indicating whether the given point is in the range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">bool = range.isPointInRange( referenceNode, offset )
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to compare with the <code>Range</code>.
* </dd><dt style="font-weight:bold"> offset </dt><dd> The offset into <code>Node</code> of the point to compare with the <code>Range</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* bool = range.isPointInRange(document.getElementsByTagName("p").item(0),1);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Returns true if the point (cursor position) at <code>offset</code> within <code>ReferenceNode</code> is within <code>this</code> range.
* </p>
* <h2> <span> Specification </span></h2>
* <p>This method is not part of a specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
isPointInRange: function( referenceNode, offset ) { // COMPAT=FF1|FF2|FF3
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the <code>Range</code> to contain the node and its contents.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.selectNode(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to select within a <code>Range</code>
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.selectNode(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of the start and end of the <code>Range</code> will be the same as the parent of the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-selectNode" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-selectNode">selectNode</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Select a node and its contents
 * @param {Node} refNode of type Node The node to select.
 * @type void
 */
selectNode: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the <code>Range</code> to contain the contents of a <code>Node</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.selectNodeContents(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> whose contents will be selected within a <code>Range</code>
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div")[0];
* range.selectNodeContents(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of the start and end of the <code>Range</code> will be the <code>referenceNode</code>. The <code>startOffset</code> is 0, and the <code>endOffset</code> is the number of child <code>Nodes</code> or number of characters contained in the reference node.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-selectNodeContents" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-selectNodeContents">selectNodeContents</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Select the contents within a node
 * @param {Node} refNode of type Node Node to select from
 * @type void
 */
selectNodeContents: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the end position of a <code><a href="range" shape="rect" title="DOM:range">Range</a></code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>range</i>.setEnd(<i>endNode</i>, <i>endOffset</i>);
* </pre>
* <dl><dt style="font-weight:bold"> endNode </dt><dd> The <code>Node</code> to end the <code>Range</code>
* </dd><dt style="font-weight:bold"> endOffset </dt><dd> An integer greater than or equal to zero representing the offset for the end of the <code>Range</code> from the start of <code>endNode</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* endNode = document.getElementsByTagName("p").item(3);
* endOffset = document.getElementsByTagName("p").item(3).childNodes.length;
* range.setEnd(endNode,endOffset);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If the <code>endNode</code> is a <code>Node</code> of type <code>Text</code>, <code>Comment</code>, or <code>CDATASection</code>, then <code>endOffset</code> is the number of characters from the start of <code>endNode</code>. For other <code>Node</code> types, <code>endOffset</code> is the number of child nodes between the start of the <code>endNode</code>.
* </p><p>Setting the end point above (higher in the document) the start point will throw an <code>NS_ERROR_ILLEGAL_VALUE</code> exception.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-setEnd" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-setEnd">DOM Level 2 Range: Range.setEnd</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the attributes describing the end of a
 * Range.
 * @param {Node} refNode of type Node The refNode value. This parameter must be
 * different from null .
 * @param {Number} offset of type long The endOffset value.
 * @type void
 */
setEnd: function(endNode, endOffset) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the end position of a <code>Range</code> relative to another <code>Node</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.setEndAfter(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to end the <code>Range</code> after
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.setEndAfter(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of end of the <code>Range</code> will be the same as that for the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setEndAfter" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setEndAfter">setEndAfter</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the end of a Range to be after a node
 * @param {Node} refNode of type Node Range ends after refNode .
 * @type void
 */
setEndAfter: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the end position of a <code>Range</code> relative to another <code>Node</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.setEndBefore(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to end the <code>Range</code> before
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.setEndBefore(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of end of the <code>Range</code> will be the same as that for the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setEndBefore" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setEndBefore">setEndBefore</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the end position to be before a node.
 * @param {Node} refNode of type Node Range ends before refNode
 * @type void
 */
setEndBefore: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the start position of a <code><a href="range" shape="rect" title="DOM:range">Range</a></code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>range</i>.setStart(<i>startNode</i>, <i>startOffset</i>);
* </pre>
* <dl><dt style="font-weight:bold"> startNode </dt><dd> The <code>Node</code> to start the <code>Range</code>
* </dd><dt style="font-weight:bold"> startOffset </dt><dd> An integer greater than or equal to zero representing the offset for the start of the <code>Range</code> from the start of <code>startNode</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* startNode = document.getElementsByTagName("p").item(2);
* startOffset = 0;
* range.setStart(startNode,startOffset);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If the <code>startNode</code> is a <code>Node</code> of type <code>Text</code>, <code>Comment</code>, or <code>CDATASection</code>, then <code>startOffset</code> is the number of characters from the start of <code>startNode</code>. For other <code>Node</code> types, <code>startOffset</code> is the number of child nodes between the start of the <code>startNode</code>.
* </p><p>Setting the start point below (further down in the document) than the end point will throw an <code>NS_ERROR_ILLEGAL_VALUE</code> exception.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-setStart" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-Range-method-setStart">DOM Level 2 Range: Range.setStart</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the attributes describing the start of the
 * Range.
 * @param {Node} refNode of type Node The refNode value. This parameter must be
 * different from null .
 * @param {Number} offset of type long The startOffset value.
 * @type void
 */
setStart: function(startNode, startOffset) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the start position of a <code>Range</code> relative to another <code>Node</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.setStartAfter(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to start the <code>Range</code> after
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.setStartAfter(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of the start of the <code>Range</code> will be the same as that for the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setStartAfter" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setStartAfter">setStartAfter</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the start position to be after a node
 * @param {Node} refNode of type Node Range starts after refNode
 * @type void
 */
setStartAfter: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Sets the start position of a <code>Range</code> relative to another <code>Node</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range.setStartBefore(referenceNode);
* </pre>
* <h2> <span> Parameters </span></h2>
* <dl><dt style="font-weight:bold"> referenceNode </dt><dd> The <code>Node</code> to start the <code>Range</code> before
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* referenceNode = document.getElementsByTagName("div").item(0);
* range.setStartBefore(referenceNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The parent <code>Node</code> of the start of the <code>Range</code> will be the same as that for the <code>referenceNode</code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setStartBefore" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-setStartBefore">setStartBefore</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Sets the start position to be before a node
 * @param {Node} refNode of type Node Range starts before refNode
 * @type void
 */
setStartBefore: function(referenceNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the <code>Node</code> within which the <code>Range</code> starts.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">startRangeNode = range.startContainer;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* startRangeNode = range.startContainer;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Returns a reference to the <code>Node</code> in the document within which the <code>Range</code> starts. This property is read-only. To change the start position of a node, use one of the <code>setStart</code> methods.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-startParent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-startParent">startParent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Node within which the Range begins
 * @type Node
 */
startContainer: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a number representing where in the <code>startContainer</code> the <code>Range</code> starts.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">startRangeOffset = range.startOffset;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.setStart(startNode,startOffset);
* range.setEnd(endNode,endOffset);
* startRangeOffset = range.startOffset;
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>startOffset</code> has two meanings. If the <code>startContainer</code> is a <code>Node</code> of type <code>Text</code>, <code>Comment</code>, or <code>CDATASection</code>, then the offset is the number of characters from the start of the <code>startContainer</code> to the boundary point of the <code>Range</code>. For other <code>Node</code> types, the <code>startOffset</code> is the number of child nodes between the start of the <code>startContainer</code> and the boundary point of the <code>Range</code>. This property is read-only. To change the <code>startOffset</code> of a <code>Range</code>, use one of the <code>setStart</code> methods.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-startOffset" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level-2-Range-attr-startOffset">startOffset</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Offset within the starting node of the Range.
 * @type Number
 */
startOffset: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Moves content of a <a href="range" shape="rect" title="DOM:range">Range</a> into a new node, placing the new node at the start of the specified range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>range</i>.surroundContents(<i>newNode</i>);
* </pre>
* <dl><dt style="font-weight:bold"> newNode </dt><dd> a Node
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var range = document.createRange();
* var newNode = document.createElement("p");
* range.selectNode(document.getElementsByTagName("div").item(0));
* range.surroundContents(newNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>surroundContents</code> is equivalent to <code>newNode.appendChild(<a href="DOM:range.extractContents" shape="rect" title="DOM:range.extractContents">range.extractContents()</a>); range.insertNode(newNode)</code>. After surrounding, the boundary points of the <code>range</code> include <code>newNode</code>. (Previously hindered by <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=135928" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=135928">bug 135928</a>.)
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-surroundContents" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-surroundContents">DOM Level 2 Range: Range.surroundContents</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Reparents the contents of the Range to the
 * given node and inserts the node at the position of the start of the
 * Range.
 * @param {Node} newParent of type Node The node to surround the contents with.
 * @type void
 */
surroundContents: function(newNode) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the text of the Range.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">text = range.toString();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">range = document.createRange();
* range.selectNode(document.getElementsByTagName("div").item(0));
* text = range.toString();
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Alerting the contents of a Range makes an implicit toString() call, so comparing range and text through an alert dialog is ineffective
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-toString" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Traversal-Range-20001113/ranges.html#Level2-Range-method-toString">toString</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Returns the contents of a Range as a string.
 * This string contains only the data characters, not any markup.
 * @return DOMString The contents of the Range.
 * @type String
 */
toString: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

