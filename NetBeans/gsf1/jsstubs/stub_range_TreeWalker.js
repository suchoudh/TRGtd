/**
* <h2> <span> Introduction </span></h2>
* <p>The <code>TreeWalker</code> object represents the nodes of a document subtree and a position within them.
* </p><p>A TreeWalker can be created using the <a href="document.createTreeWalker" shape="rect" title="DOM:document.createTreeWalker">createTreeWalker</a> method of the <a href="document" shape="rect" title="DOM:document">document</a> object.
* </p>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"><a href="DOM:treeWalker.root" shape="rect" title="DOM:treeWalker.root">root</a>
* </dt><dt style="font-weight:bold"><a href="treeWalker.whatToShow" shape="rect" title="DOM:treeWalker.whatToShow">whatToShow</a>
* </dt><dt style="font-weight:bold"><a href="treeWalker.filter" shape="rect" title="DOM:treeWalker.filter">filter</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.ExpandEntityReferences&amp;action=edit" shape="rect" title="DOM:treeWalker.ExpandEntityReferences">expandEntityReferences</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.currentNode&amp;action=edit" shape="rect" title="DOM:treeWalker.currentNode">currentNode</a>
* </dt></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:treeWalker.parentNode&amp;action=edit" shape="rect" title="DOM:treeWalker.parentNode">parentNode</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.firstChild&amp;action=edit" shape="rect" title="DOM:treeWalker.firstChild">firstChild</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.lastChild&amp;action=edit" shape="rect" title="DOM:treeWalker.lastChild">lastChild</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.previousSibling&amp;action=edit" shape="rect" title="DOM:treeWalker.previousSibling">previousSibling</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.nextSibling&amp;action=edit" shape="rect" title="DOM:treeWalker.nextSibling">nextSibling</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.previousNode&amp;action=edit" shape="rect" title="DOM:treeWalker.previousNode">previousNode</a>
* </dt><dt style="font-weight:bold"><a href="http://developer.mozilla.org/en/docs/index.php?title=treeWalker.nextNode&amp;action=edit" shape="rect" title="DOM:treeWalker.nextNode">nextNode</a>
* </dt></dl>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/traversal.html#Traversal-TreeWalker" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/traversal.html#Traversal-TreeWalker">DOM Level 2 Traversal: TreeWalker</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsContent" shape="rect" title="Category:NeedsContent">NeedsContent</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var TreeWalker = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The node at which the TreeWalker is currently
 * positioned.
 * Alterations to the DOM tree may cause the current node to no longer
 * be accepted by the TreeWalker's associated filter.
 * currentNode may also be explicitly set to any node,
 * whether or not it is within the subtree specified by the
 * root node or would be accepted by the filter and
 * whatToShow flags. Further traversal occurs relative to
 * currentNode even if it is not part of the current
 * view, by applying the filters in the requested direction; if no
 * traversal is possible, currentNode is not
 * changed.
 * @type Node
 */
currentNode: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The value of this flag determines whether the children of
 * entity reference nodes are visible to the TreeWalker.
 * If false, they and their descendants will be
 * rejected. Note that this rejection takes precedence over
 * whatToShow and the filter, if any.
 *  To produce a view of the document that has entity references
 * expanded and does not expose the entity reference node itself, use
 * the whatToShow flags to hide the entity reference node
 * and set expandEntityReferences to true when creating
 * the TreeWalker. To produce a view of the document that
 * has entity reference nodes but no entity expansion, use the
 * whatToShow flags to show the entity reference node and
 * set expandEntityReferences to false.
 * @type Boolean
 */
expandEntityReferences: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns an object with a method <code>acceptNode(node)</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">nodeFilter = treeWalker.filter;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var treeWalker = document.createTreeWalker(
* document.body,
* NodeFilter.SHOW_ELEMENT,
* { acceptNode: function(node) { return NodeFilter.FILTER_ACCEPT; } },
* false
* );
* nodeFilter = treeWalker.filter; // document.body in this case
* </pre>
* <h2> <span> Notes </span></h2>
* <p>When creating the TreeWalker, the filter object is passed in as the third parameter, and the object method <code>acceptNode(node)</code> is called on every single node to determine whether or not to accept it. This function should return the constant <code>NodeFilter.FILTER_ACCEPT</code> for cases when the node should be accepted and <code>NodeFilter.FILTER_REJECT</code> for cases when the node should be rejected.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The filter used to screen nodes.
 * @type NodeFilter
 */
filter: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Moves the TreeWalker to the first
 * visible child of the
 * current node, and returns the new node. If the current node has no
 * visible children, returns null , and retains the
 * current node.
 * @return Node The new node, or null if the current node has no
 * visible children in the TreeWalker 's logical view.
 * @type Node
 */
firstChild: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the last
 * visible child of the
 * current node, and returns the new node. If the current node has no
 * visible children, returns null , and retains the
 * current node.
 * @return Node The new node, or null if the current node has no
 * children in the TreeWalker 's logical view.
 * @type Node
 */
lastChild: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the next
 * visible node in document order relative to the current node, and
 * returns the new node. If the current node has no next node, or if
 * the search for nextNode attempts to step upward from the TreeWalker 's root node, returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * next node in the TreeWalker 's logical view.
 * @type Node
 */
nextNode: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the next sibling of the
 * current node, and returns the new node. If the current node has no
 * visible next sibling , returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * next sibling . in
 * the TreeWalker 's logical view.
 * @type Node
 */
nextSibling: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves to and returns the closest visible ancestor node of the
 * current node. If the search for parentNode attempts to
 * step upward from the TreeWalker 's root node, or if it fails to find a visible ancestor node, this
 * method retains the current position and returns null .
 * @return Node The new parent node, or null if the current node has no parent in the TreeWalker 's logical view.
 * @type Node
 */
parentNode: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the
 * previous visible node in document order relative to the current
 * node, and returns the new node. If the current node has no previous
 * node, or if the search for previousNode attempts to
 * step upward from the TreeWalker 's root node, returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * previous node in the TreeWalker 's logical view.
 * @type Node
 */
previousNode: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the
 * previous sibling of
 * the current node, and returns the new node. If the current node has
 * no visible previous sibling , returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * previous sibling .
 * in the TreeWalker 's logical view.
 * @type Node
 */
previousSibling: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the node that is the root of what the TreeWalker traverses.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">root = treeWalker.root;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var treeWalker = document.createTreeWalker(
* document.body,
* NodeFilter.SHOW_ELEMENT,
* { acceptNode: function(node) { return NodeFilter.FILTER_ACCEPT; } },
* false
* );
* root = treeWalker.root; // document.body in this case
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The root node of the TreeWalker, as
 * specified when it was created.
 * @type Node
 */
root: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a number signifying what types of nodes should be returned by the treeWalker.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var nodeTypes = treeWalker.whatToShow;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var treeWalker = document.createTreeWalker(
* document.body,
* NodeFilter.SHOW_ELEMENT + NodeFilter.SHOW_COMMENT + NodeFilter.SHOW_TEXT,
* { acceptNode: function(node) { return NodeFilter.FILTER_ACCEPT; } },
* false
* );
* if( (treeWalker.whatToShow == NodeFilter.SHOW_ALL) ||
* (treeWalker.whatToShow % (NodeFilter.SHOW_COMMENT*2)) &gt;= NodeFilter.SHOW_COMMENT) {
* // treeWalker will show comments
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Valid flags for <code>whatToShow</code> are:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">NodeFilter.SHOW_ALL = -1
* NodeFilter.SHOW_ELEMENT = 1
* NodeFilter.SHOW_ATTRIBUTE = 2
* NodeFilter.SHOW_TEXT = 4
* NodeFilter.SHOW_CDATA_SECTION = 8
* NodeFilter.SHOW_ENTITY_REFERENCE = 16
* NodeFilter.SHOW_ENTITY = 32
* NodeFilter.SHOW_PROCESSING_INSTRUCTION = 64
* NodeFilter.SHOW_COMMENT = 128
* NodeFilter.SHOW_DOCUMENT = 256
* NodeFilter.SHOW_DOCUMENT_TYPE = 512
* NodeFilter.SHOW_DOCUMENT_FRAGMENT = 1024
* NodeFilter.SHOW_NOTATION = 2048
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * This attribute determines which node types are presented via
 * the TreeWalker. The available set of constants is
 * defined in the NodeFilter
 * interface. Nodes not accepted by whatToShow will be
 * skipped, but their children may still be considered. Note that this
 * skip takes precedence over the filter, if any.
 * @type Number
 */
whatToShow: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
};

