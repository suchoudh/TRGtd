/**
* <p>In the <a href="DOM" shape="rect" title="DOM">DOM</a>, the <b>document object</b> provides a general way to represent <a href="http://developer.mozilla.org/en/docs/HTML" shape="rect" title="HTML">HTML</a>, <a href="http://developer.mozilla.org/en/docs/XHTML" shape="rect" title="XHTML">XHTML</a>, and <a href="http://developer.mozilla.org/en/docs/XML" shape="rect" title="XML">XML</a> documents. Document objects implement the general <a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#i-Document" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#i-Document">DOM Core document</a> interface.
* </p><p>In addition to the generalized DOM Core document interface, HTML documents also implement the <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">DOM HTMLDocument</a> interface, which is a more specialized interface for dealing with HTML documents (e.g., <a href="document.cookie" shape="rect" title="DOM:document.cookie">document.cookie</a>, <a href="document.alinkColor" shape="rect" title="DOM:document.alinkColor">document.alinkColor</a>). Properties and methods listed here that are part of this more specialized interface have an asterisk (*) next to them.
* </p><p>The document is contained by the <a href="window" shape="rect" title="DOM:window">window</a> object and may contain any number of <a href="element" shape="rect" title="DOM:element">elements</a>.
* </p><p>The document interface provides access to things such as the document type, its color and formatting, plugins and applets, as well providing methods for creating and manipulating all of the document's child nodes, or elements, such as BODY and TABLE elements.
* </p>
* 
* <p>
* </p>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:document.alinkColor" shape="rect" title="DOM:document.alinkColor">document.alinkColor</a>* <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> Returns or sets the color of active links in the document body.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.anchors" shape="rect" title="DOM:document.anchors">document.anchors</a>*
* </dt><dd> <b>anchors</b> returns a list of all of the anchors in the document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.applets" shape="rect" title="DOM:document.applets">document.applets</a>*
* </dt><dd> <b>applets</b> returns an ordered list of the applets within a document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.bgColor" shape="rect" title="DOM:document.bgColor">document.bgColor</a>* <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> <b>bgColor</b> gets/sets the background color of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.body" shape="rect" title="DOM:document.body">document.body</a>*
* </dt><dd> <b>body</b> returns the BODY node of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.characterSet" shape="rect" title="DOM:document.characterSet">document.characterSet</a>
* </dt><dd> Returns the character set being used by the document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.compatMode" shape="rect" title="DOM:document.compatMode">document.compatMode</a>*
* </dt><dd> Indicates whether the document is rendered in Quirks or Strict mode.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.contentType" shape="rect" title="DOM:document.contentType">document.contentType</a>
* </dt><dd> Returns the Content-Type from the MIME Header of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.cookie" shape="rect" title="DOM:document.cookie">document.cookie</a>*
* </dt><dd> Returns a semicolon-separated list of the cookies for that document or sets a single cookie.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.defaultView" shape="rect" title="DOM:document.defaultView">document.defaultView</a>
* </dt><dd> Returns a reference to the window object.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.designMode" shape="rect" title="DOM:document.designMode">document.designMode</a>*
* </dt><dd> <b>designMode</b> gets/sets WYSYWIG editing capability of <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a>. It can only be used for HTML documents.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.doctype" shape="rect" title="DOM:document.doctype">document.doctype</a>
* </dt><dd> Returns the Document Type Definition (DTD) of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.documentElement" shape="rect" title="DOM:document.documentElement">document.documentElement</a>
* </dt><dd> Returns the Element that is a direct child of document. For HTML documents, this is normally the HTML element.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.documentURIObject" shape="rect" title="DOM:document.documentURIObject">document.documentURIObject</a> <span style="border: 1px solid #818151; background-color: #FFFFE1; font-size: 9px; vertical-align: text-top;">New in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></span>
* </dt><dd> Returns the <code><a href="http://developer.mozilla.org/en/docs/nsIURI" shape="rect" title="nsIURI">nsIURI</a></code> object representing the URI of the document.  This property only has special meaning in privileged JavaScript code (with UniversalXPConnect privileges).
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.domain" shape="rect" title="DOM:document.domain">document.domain</a>*
* </dt><dd> <b>domain</b> returns the domain of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.embeds" shape="rect" title="DOM:document.embeds">document.embeds</a>*
* </dt><dd> <b>embeds</b> returns a list of the embedded OBJECTS within the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.fgColor" shape="rect" title="DOM:document.fgColor">document.fgColor</a>* <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> <b>fgColor</b> gets/sets the foreground color, or text color, of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.firstChild" shape="rect" title="DOM:document.firstChild">document.firstChild</a>
* </dt><dd> <b>firstChild</b> returns the first node in the list of direct children of the document. (See also <a href="http://developer.mozilla.org/en/docs/firstChild" shape="rect" title="firstChild">firstChild</a> for the general element property.)
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.forms" shape="rect" title="DOM:document.forms">document.forms</a>*
* </dt><dd> <b>forms</b> returns a list of the FORM elements within the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.height" shape="rect" title="DOM:document.height">document.height</a>*
* </dt><dd> <b>height</b> gets/sets the height of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.images" shape="rect" title="DOM:document.images">document.images</a>*
* </dt><dd> <b>images</b> returns a list of the images in the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.implementation" shape="rect" title="DOM:document.implementation">document.implementation</a>*
* </dt><dd> Returns the DOM implementation associated with the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.lastModified" shape="rect" title="DOM:document.lastModified">document.lastModified</a>*
* </dt><dd> Returns the date on which the document was last modified.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.linkColor" shape="rect" title="DOM:document.linkColor">document.linkColor</a>*  <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> Gets/sets the color of hyperlinks in the document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.links" shape="rect" title="DOM:document.links">document.links</a>*
* </dt><dd> Returns a list of all the hyperlinks in the document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.location" shape="rect" title="DOM:document.location">document.location</a>*
* </dt><dd> Returns the URI of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.namespaceURI" shape="rect" title="DOM:document.namespaceURI">document.namespaceURI</a>
* </dt><dd> Returns the XML namespace of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.plugins" shape="rect" title="DOM:document.plugins">document.plugins</a>*
* </dt><dd> Returns a list of the available plugins.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.popupNode" shape="rect" title="DOM:document.popupNode">document.popupNode</a>
* </dt><dd> Returns the node upon which a <a href="http://developer.mozilla.org/en/docs/XUL:popup" shape="rect" title="XUL:popup">popup</a> was invoked (XUL documents only).
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.referrer" shape="rect" title="DOM:document.referrer">document.referrer</a>*
* </dt><dd> Returns the URI of the page that linked to this page.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.styleSheets" shape="rect" title="DOM:document.styleSheets">document.styleSheets</a>*
* </dt><dd> Returns a list of the <a href="stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a> objects on the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.title" shape="rect" title="DOM:document.title">document.title</a>*
* </dt><dd> Returns the title of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.tooltipNode" shape="rect" title="DOM:document.tooltipNode">document.tooltipNode</a>
* </dt><dd> Returns the node which is the target of the current <a href="http://developer.mozilla.org/en/docs/XUL:tooltip" shape="rect" title="XUL:tooltip">tooltip</a>.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.URL" shape="rect" title="DOM:document.URL">document.URL</a>
* </dt><dd> Returns a string containing the URL of the current document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.vlinkColor" shape="rect" title="DOM:document.vlinkColor">document.vlinkColor</a>* <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> Gets/sets the color of visited hyperlinks.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.width" shape="rect" title="DOM:document.width">document.width</a>*
* </dt><dd> Returns the width of the current document.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:document.clear" shape="rect" title="DOM:document.clear">document.clear</a>* <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span>
* </dt><dd> In majority of modern browsers, including recent versions of Firefox and Internet Explorer, this method does nothing.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.close" shape="rect" title="DOM:document.close">document.close</a>*
* </dt><dd> Closes a document stream for writing.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createAttribute" shape="rect" title="DOM:document.createAttribute">document.createAttribute</a>
* </dt><dd> Creates a new attribute node and returns it.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.createCDATASection&amp;action=edit" shape="rect" title="DOM:document.createCDATASection">document.createCDATASection</a>
* </dt><dd> Creates a new CDATA node and returns it.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.createComment&amp;action=edit" shape="rect" title="DOM:document.createComment">document.createComment</a>
* </dt><dd> Creates a new comment node and returns it.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createDocumentFragment" shape="rect" title="DOM:document.createDocumentFragment">document.createDocumentFragment</a>
* </dt><dd> Creates a new document fragment.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createElement" shape="rect" title="DOM:document.createElement">document.createElement</a>
* </dt><dd> Creates a new element with the given tag name.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createElementNS" shape="rect" title="DOM:document.createElementNS">document.createElementNS</a>
* </dt><dd> Creates a new element with the given tag name and namespace URI.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.createEntityReference&amp;action=edit" shape="rect" title="DOM:document.createEntityReference">document.createEntityReference</a>
* </dt><dd> Creates a new entity reference object and returns it.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a>
* </dt><dd> Creates an event.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createNSResolver" shape="rect" title="DOM:document.createNSResolver">document.createNSResolver</a>
* </dt><dd> Creates an XPathNSResolver.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.createProcessingInstruction&amp;action=edit" shape="rect" title="DOM:document.createProcessingInstruction">document.createProcessingInstruction</a>
* </dt><dd> Creates a new processing instruction element and returns it.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createRange" shape="rect" title="DOM:document.createRange">document.createRange</a>
* </dt><dd> Creates a Range object.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createTextNode" shape="rect" title="DOM:document.createTextNode">document.createTextNode</a>
* </dt><dd> Creates a text node.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.createTreeWalker" shape="rect" title="DOM:document.createTreeWalker">document.createTreeWalker</a>
* </dt><dd> Creates a <code><a href="treeWalker" shape="rect" title="DOM:treeWalker">TreeWalker</a></code> object.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.elementFromPoint" shape="rect" title="DOM:document.elementFromPoint">document.elementFromPoint</a> <span style="border: 1px solid #818151; background-color: #FFFFE1; font-size: 9px; vertical-align: text-top;">New in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></span>
* </dt><dd> Returns the element visible at the specified coordinates.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.evaluate" shape="rect" title="DOM:document.evaluate">document.evaluate</a>
* </dt><dd> Evaluates an XPath expression.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/Rich-Text_Editing_in_Mozilla#Executing_Commands" shape="rect" title="Rich-Text Editing in Mozilla">document.execCommand</a>*
* </dt><dd> Executes a <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a> command.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.getElementById" shape="rect" title="DOM:document.getElementById">document.getElementById</a>
* </dt><dd> Returns an object reference to the identified element.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.getElementsByName" shape="rect" title="DOM:document.getElementsByName">document.getElementsByName</a>
* </dt><dd> Returns a list of elements with the given name.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.getElementsByTagName" shape="rect" title="DOM:document.getElementsByTagName">document.getElementsByTagName</a>
* </dt><dd> Returns a list of elements with the given tag name.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.getElementsByTagNameNS" shape="rect" title="DOM:document.getElementsByTagNameNS">document.getElementsByTagNameNS</a>
* </dt><dd> Returns a list of elements with the given tag name and namespace.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.importNode" shape="rect" title="DOM:document.importNode">document.importNode</a>
* </dt><dd> Returns a clone of a node from an external document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.loadOverlay" shape="rect" title="DOM:document.loadOverlay">document.loadOverlay</a>
* </dt><dd> <span style="border: 1px solid #818151; background-color: #FFFFE1; font-size: 9px; vertical-align: text-top;">New in <a href="http://developer.mozilla.org/en/docs/Firefox_1.5_for_developers" shape="rect" title="Firefox 1.5 for developers">Firefox 1.5</a></span> Loads a <a href="http://developer.mozilla.org/en/docs/XUL_Overlays" shape="rect" title="XUL Overlays"> XUL overlay</a> dynamically. This only works in XUL documents.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.open" shape="rect" title="DOM:document.open">document.open</a>*
* </dt><dd> Opens a document stream for writing.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.queryCommandEnabled&amp;action=edit" shape="rect" title="DOM:document.queryCommandEnabled">document.queryCommandEnabled</a>*
* </dt><dd> Returns true if the <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a> command can be executed on the current range.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.queryCommandIndeterm&amp;action=edit" shape="rect" title="DOM:document.queryCommandIndeterm">document.queryCommandIndeterm</a>*
* </dt><dd> Returns true if the <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a> command is in a indeterminate state on the current range.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.queryCommandState&amp;action=edit" shape="rect" title="DOM:document.queryCommandState">document.queryCommandState</a>*
* </dt><dd> Returns true if the <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a> command has been executed on the current range.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.queryCommandValue&amp;action=edit" shape="rect" title="DOM:document.queryCommandValue">document.queryCommandValue</a>*
* </dt><dd> Returns the current value of the current range for <a href="http://developer.mozilla.org/en/docs/Midas" shape="rect" title="Midas">Midas</a> command. As of Firefox 2.0.0.2, queryCommandValue will return an empty string when a command value has not been explicitly set.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.write" shape="rect" title="DOM:document.write">document.write</a>*
* </dt><dd> Writes text to a document.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="document.writeln" shape="rect" title="DOM:document.writeln">document.writeln</a>*
* </dt><dd> Write a line of text to a document.
* </dd></dl>
* <h2> <span> Event Handlers </span></h2>
* <p>Firefox 3 introduces two new events: "online" and "offline". These two events are fired on the &lt;body&gt; of each page when the browser switches between online and offline mode. Additionally, the events bubble up from document.body, to document, ending at window. Both events are non-cancellable (you can't prevent the user from coming online, or going offline). For more info see <a href="http://developer.mozilla.org/en/docs/Online_and_offline_events" shape="rect" title="Online and offline events">Online_and_offline_events</a>.
* </p>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.ononline&amp;action=edit" shape="rect" title="DOM:document.ononline">document.ononline</a> <span style="border: 1px solid #818151; background-color: #FFFFE1; font-size: 9px; vertical-align: text-top;">New in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></span>
* </dt><dd> Returns the event handling code for the online event.
* </dd></dl>
* <dl><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=document.onoffline&amp;action=edit" shape="rect" title="DOM:document.onoffline">document.onoffline</a> <span style="border: 1px solid #818151; background-color: #FFFFE1; font-size: 9px; vertical-align: text-top;">New in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></span>
* </dt><dd> Returns the event handling code for the offline event.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Document = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the URL of the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = document.URL
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var currentURL = document.URL; alert(currentURL);
* </pre>
* <h2> <span>Notes </span></h2>
* <p><code>URL</code> is a replacement for the DOM Level 0 <code>document.location.href</code> property. However <code>document.URL</code> is not settable, unlike <code>document.location.href</code>.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-46183437" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-46183437">DOM Level 2 HTML: URL</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
URL: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Adopts a node from an external document. The node and its subtree is removed from the document it's in (if any), and its <code><a href="element.ownerDocument" shape="rect" title="DOM:element.ownerDocument">ownerDocument</a></code> is changed to the current document. The node can then be inserted into the current document.
* </p><p><b>Supported since Gecko 1.9 (Firefox 3)</b>
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>node</i> = <i>document</i>.adoptNode(<i>externalNode</i>);
* </pre>
* <ul><li> <code>node</code> is the adopted node that can be used in the current document. The new node's <code><a href="DOM:element.parentNode" shape="rect" title="DOM:element.parentNode">parentNode</a></code> is <code>null</code>, since it has not yet been inserted into the document tree.
* </li><li> <code>externalNode</code> is the node from another document to be adopted.
* </li></ul>
* <h2> <span> Example </span></h2>
* <h2> <span> Notes </span></h2>
* <p>In general the <code>adoptNode</code> call may fail due to the source node coming from a different implementation, however this should not be a problem with browser implementations.
* </p><p>Nodes from external documents must be cloned using <code><a href="document.importNode" shape="rect" title="DOM:document.importNode">importNode</a></code> (or adopted using <code><strong>adoptNode</strong></code>) before they can be inserted into the current document. For more on the <code><a href="element.ownerDocument" shape="rect" title="DOM:element.ownerDocument">ownerDocument</a></code> issues see the <a href="http://www.w3.org/DOM/faq.html#ownerdoc" rel="nofollow" shape="rect" title="http://www.w3.org/DOM/faq.html#ownerdoc">W3C DOM FAQ</a>.
* </p><p><a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a> did not enforce the use of <code>importNode</code> and <code>adoptNode</code> until 1.9. <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">Since 1.9 alphas</a>, failing to adopt or import a node before using it in a different document results in the <code>WRONG_DOCUMENT_ERR</code> (<code>NS_ERROR_DOM_WRONG_DOCUMENT_ERR</code>) exception being thrown.
* </p><p>
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-3-Core/core.html#Document3-adoptNode" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Core/core.html#Document3-adoptNode">DOM Level 3 Core: Document.adoptNode</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Attempts to adopt a node from another document
 * to this document. If supported, it changes the ownerDocument of the source node, its children, as
 * well as the attached attribute nodes if there are any. If the
 * source node has a parent it is first removed from the child list of
 * its parent. This effectively allows moving a subtree from one
 * document to another (unlike importNode() which create
 * a copy of the source node instead of moving it). When it fails,
 * applications should use Document.importNode() instead. Note that if the adopted node is already part of this
 * document (i.e. the source and target document are the same), this
 * method still has the effect of removing the source node from the
 * child list of its parent, if any. The following list describes the
 * specifics for each type of node. ATTRIBUTE_NODE The ownerElement attribute is set to null and the specified flag is set to true on the adopted Attr . The descendants of
 * the source Attr are recursively
 * adopted. DOCUMENT_FRAGMENT_NODE The descendants of the source node are recursively
 * adopted. DOCUMENT_NODE Document nodes cannot be adopted. DOCUMENT_TYPE_NODE DocumentType nodes cannot be adopted. ELEMENT_NODE Specified attribute nodes of the source element are
 * adopted. Default attributes are discarded, though if the document
 * being adopted into defines default attributes for this element
 * name, those are assigned. The descendants of the source element are
 * recursively adopted. ENTITY_NODE Entity nodes
 * cannot be adopted. ENTITY_REFERENCE_NODE Only the EntityReference node
 * itself is adopted, the descendants are discarded, since the source
 * and destination documents might have defined the entity
 * differently. If the document being imported into provides a
 * definition for this entity name, its value is assigned. NOTATION_NODE Notation nodes
 * cannot be adopted. PROCESSING_INSTRUCTION_NODE, TEXT_NODE, CDATA_SECTION_NODE,
 * COMMENT_NODE These nodes can all be adopted. No specifics. Note: Since it does not create new nodes unlike the Document.importNode() method, this method does not raise an INVALID_CHARACTER_ERR exception, and applications should use the Document.normalizeDocument() method to check if an imported name is not an XML name according to
 * the XML version in use.
 * @param {Node} source of type Node The node to move into this document.
 * @return Node The adopted node, or null if this operation fails,
 * such as when the source node comes from a different
 * implementation.
 * @type Node
 */
adoptNode: function(externalNode) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p>Returns or sets the color of an active link in the document body.  A link is active during the time between <code>mousedown</code> and <code>mouseup</code> events.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>color</i> = document.alinkColor
* document.alinkColor = <i>color</i>
* </pre>
* <p><code>color</code> is a string containing the name of the color (e.g., <code>"blue"</code>, <code>"darkblue"</code>, etc.) or the hexadecimal value of the color (e.g., <code>#0000FF</code>)
* </p>
* <h2> <span> Notes </span></h2>
* <p>The default value for this property in Mozilla Firefox is red (<code>#ee0000</code> in hexadecimal).
* </p><p><code>document.alinkColor</code> is deprecated in <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">DOM Level 2 HTML</a>.  One alternative is the CSS selector <code><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS::active&amp;action=edit" shape="rect" title="CSS::active">:active</a></code>.
* </p><p>Another alternative is <code>document.body.aLink</code>, although this is <a href="http://www.w3.org/TR/html401/struct/global.html#adef-alink" rel="nofollow" shape="rect" title="http://www.w3.org/TR/html401/struct/global.html#adef-alink">deprecated in HTML 4.01</a> in favor of the CSS alternative.
* </p><p><a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a> supports both <code>alinkColor</code>/<code>:active</code> and <code><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS::focus&amp;action=edit" shape="rect" title="CSS::focus">:focus</a></code>.  Internet Explorer 6 and 7  support <code>alinkColor</code>/<code>:active</code> only for <a href="http://developer.mozilla.org/en/docs/HTML:Element:a" shape="rect" title="HTML:Element:a"> HTML anchor (&lt;a&gt;) links</a> and the behavior is the same as <code>:focus</code> under Gecko.  There is no support for <code>:focus</code> in IE.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/alinkcolor.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/alinkcolor.asp">MSDN: alinkColor property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
alinkColor: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><code>anchors</code> returns a list of all of the anchors in the document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nodeList</i> = document.anchors
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if ( document.anchors.length &gt;= 5 ) {
* dump("dump found too many anchors");
* window.location = "http://www.google.com";
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>For reasons of backwards compatibility, the returned set of anchors only contains those anchors created with the <code>name</code> attribute, not those created with the <code>id</code> attribute.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-7577272" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-7577272">DOM Level 2 HTML: anchors</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
anchors: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><code>applets</code> returns an ordered list of the applets within a document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nodeList</i> = document.applets
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// ( When you know the second applet is the one you want )
* my_java_app = document.applets[1];
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-85113862" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-85113862">DOM Level 2 HTML: applets</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
applets: undefined,
/**
* <h2> <span>Summary</span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p><code>bgColor</code> gets/sets the background color of the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>color</i> = document.bgColor
* document.bgColor = <i>color</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>color</code> is a string representing the color as a word (e.g., "red") or hexadecimal value (e.g., "<code>#ff0000</code>").
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.bgColor = "darkblue";
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The default value for this property in Mozilla Firefox is white (<code>#ffffff</code> in hexadecimal).
* </p><p><code>document.bgColor</code> is deprecated in <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">DOM Level 2 HTML</a>.  The recommended alternative is use of the CSS style <a href="http://developer.mozilla.org/en/docs/CSS:background-color" shape="rect" title="CSS:background-color"> background-color</a> which can be accessed through the DOM with <code>document.body.style.backgroundColor</code>.  Another alternative is <code>document.body.bgColor</code>, although this is also deprecated in HTML 4.01 in favor of the CSS alternative.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
bgColor: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the <code>&lt;body&gt;</code> or <code>&lt;frameset&gt;</code> node of the current document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>objRef</i> = document.body
* document.body = <i>objRef</i>
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// in HTML: &lt;body id="oldBodyElement"&gt;&lt;/body&gt;
* alert(document.body.id); // "oldBodyElement"
* var aNewBodyElement = document.createElement("body");
* aNewBodyElement.id = "newBodyElement";
* document.body = aNewBodyElement;
* alert(document.body.id); // "newBodyElement"
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>document.body</code> is the element that contains the content for the document. In documents with <code>&lt;body&gt;</code> contents, returns the <code>&lt;body&gt;</code> element, and in frameset documents, this returns the outermost <code>&lt;frameset&gt;</code> element.
* </p><p>Though <code>body</code> is settable, setting a new body on a document will effectively remove all the current children of the existing <code>&lt;body&gt;</code> element.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-56360201" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-56360201">DOM Level 2 HTML: HTMLDocument.body</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
body: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the character encoding of the current document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = document.characterSet
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">&lt;button onclick="alert(document.characterSet);"&gt;Show character set&lt;/button&gt;
* // returns document's character set, such as "ISO-8859-1 or UTF-8"
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The character encoding is the character set used for rendering the document, which may be different from the encoding specified by the page (the user can override the encoding).
* </p><p>The related, nonstandard method <code><a href="http://msdn2.microsoft.com/en-us/library/ms533553.aspx" rel="nofollow" shape="rect" title="http://msdn2.microsoft.com/en-us/library/ms533553.aspx">document.charset</a></code> and the property <code><a href="http://msdn2.microsoft.com/en-us/library/ms533714.aspx" rel="nofollow" shape="rect" title="http://msdn2.microsoft.com/en-us/library/ms533714.aspx">document.defaultCharset</a></code> are not supported by Gecko.
* </p><p>For a complete list of character sets, see:
* <a href="http://www.iana.org/assignments/character-sets" rel="nofollow" shape="rect" title="http://www.iana.org/assignments/character-sets">http://www.iana.org/assignments/character-sets</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
characterSet: undefined,
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p>This method used to clear the whole specified document in early (pre-1.0) versions of Mozilla.
* </p><p>In recent versions of Mozilla-based applications as well as in Internet Explorer and Netscape 4 this method does nothing.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.clear()
* </pre>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
clear: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>The <code>document.close()</code> method finishes writing to a document, opened with <a href="document.open" shape="rect" title="DOM:document.open">document.open()</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.close();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // open a document to write to it.
* // write the content of the document.
* // close the document.
* document.open();
* document.write("&lt;p&gt;The one and only content.&lt;/p&gt;");
* document.close();
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-98948567" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-98948567">DOM Level 2 HTML: <code>close()</code> Method</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
close: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Indicates whether the document is rendered in Quirks mode or Strict mode.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>mode</i> = document.compatMode
* </pre>
* <ul><li><code>mode</code> is a string containing "BackCompat" for Quirks mode or "CSS1Compat" for Strict mode.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (document.compatMode == "BackCompat") {
* // use some quirky stuff
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>There is a third mode, <a href="http://developer.mozilla.org/en/docs/Gecko%27s_%22Almost_Standards%22_Mode" shape="rect" title="Gecko's &quot;Almost Standards&quot; Mode">Gecko's "Almost_Standards" Mode</a>, which only differs from Strict mode in the layout of images inside table cells.  This third mode is reported the same way as Strict mode: "CSS1Compat".
* </p>
* <h2> <span> Specification </span></h2>
* <p>Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/compatmode.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/compatmode.asp">MSDN: compatMode property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
compatMode: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the Content-Type from the HTTP headers of the document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>contentType</var> = <var>document</var>.contentType;
* </pre>
* <p><code>contentType</code> is a read-only property.
* </p>
* <h2> <span> Notes </span></h2>
* <p>The property returns the MIME property "Content-Type" set in the HTTP Header and not the META property set in the HEAD section of the document.
* </p>
* <h2> <span> Specification </span></h2>
* <p>Non-standard, only supported by <a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a>. To be used in chrome code (i.e. <a href="http://developer.mozilla.org/en/docs/Extensions" shape="rect" title="Extensions">Extensions</a> and XUL applications).
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
contentType: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Get and set the cookies associated with the current document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>allCookies</i> = <i>document</i>.cookie;
* </pre>
* <ul><li> <code>allCookies</code> is a string containing a semicolon-separated list of cookies (i.e. <code><i>key</i>=<i>value</i></code> pairs)
* </li></ul>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>document</i>.cookie = <i>updatedCookie</i>;
* </pre>
* <ul><li> <code>updatedCookie</code> is a string of form <code><i>key</i>=<i>value</i></code>, optionally followed by cookie attribute values, specifying the cookie to set/update. Note that you can only set/update a single cookie at a time using this method.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.cookie = "name=oeschger";
* document.cookie = "favorite_food=tripe";
* alert(document.cookie);
* // displays: name=oeschger;favorite_food=tripe
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Starting with Firefox 2, a better mechanism for client-side storage is available - <a href="DOM:Storage" shape="rect" title="DOM:Storage">WHATWG DOM Storage</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-8747038" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-8747038">DOM Level 2: HTMLDocument.cookie</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsContent" shape="rect" title="Category:NeedsContent">NeedsContent</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cookie: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>createAttribute</b> creates a new attribute node, and returns it.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>attribute</i> = document.createAttribute(name)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li> <code>attribute</code> is an attribute node.
* </li><li> <code>name</code> is a string containing the name of the attribute.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* 
* &lt;head&gt;
* &lt;title&gt; create/set/get Attribute example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function doAttrib()
* {
* var node = document.getElementById("div1");
* var a = document.createAttribute("my_attrib");
* a.nodeValue = "newVal";
* node.setAttributeNode(a);
* alert(node.getAttribute("my_attrib")); // "newVal"
* }
* 
* // alternative form not actually using createAttribute
* //function doAttrib()
* //{
* //var node = document.getElementById("div1");
* //node.setAttribute("my_attrib", "newVal");
* //alert(node.getAttribute("my_attrib")); // "newVal"
* //}
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onload="doAttrib();"&gt;
* &lt;div id="div1"&gt;
* &lt;p&gt;Some content here&lt;/p&gt;
* &lt;/div&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The return value is a node of type <code>attribute</code>. Once you have this node you can, as in the foregoing example, set its value by assigning a string to the nodeValue property, or in the alternate form by using the <a href="element.setAttribute" shape="rect" title="DOM:element.setAttribute">setAttribute()</a> method. The DOM does not enforce what sort of attributes can be added to a particular element in this manner.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-1084891198" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-1084891198">createAttribute </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Creates an Attr of the given name.
 * Note that the Attr instance can then be
 * set on an Element using the setAttributeNode method. To create an attribute with a qualified name and namespace URI , use the createAttributeNS method.
 * @param {String} name of type DOMString The name of the attribute.
 * @return Attr A new Attr object with the nodeName attribute set to name , and localName , prefix , and namespaceURI set to null . The value of
 * the attribute is the empty string.
 * @type Attr
 
 * @type Attr
*/
createAttribute: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates an attribute of the given qualified name and namespace URI . Per [ XML Namespaces ],
 * applications must use the value null as the namespaceURI parameter for methods if they wish to
 * have no namespace.
 * @param {String} namespaceURI of type DOMString The namespace URI of the attribute to create.
 * @param {String} qualifiedName of type DOMString The qualified name of the attribute to instantiate.
 * @return Attr A new Attr object with the
 * following attributes: Attribute Value Node.nodeName qualifiedName Node.namespaceURI namespaceURI Node.prefix prefix, extracted from qualifiedName , or null if there is no
 * prefix Node.localName local name , extracted from qualifiedName Attr.name qualifiedName Node.nodeValue the empty string
 * @type Attr
 
 * @type Attr
*/
createAttributeNS: function(namespaceURI, qualifiedName) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates a CDATASection node whose
 * value is the specified string.
 * @param {String} data of type DOMString The data for the CDATASection contents.
 * @return CDATASection The new CDATASection object.
 * @type CDATASection
 
 * @type CDATASection
*/
createCDATASection: function(data) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates a Comment node given the
 * specified string.
 * @param {String} data of type DOMString The data for the node.
 * @return Comment The new Comment object.
 * @type Comment
 
 * @type Comment
*/
createComment: function(comment) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Creates an empty document fragment.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>docFragment</i> = document.createDocumentFragment();
* </pre>
* <p><code>docFragment</code> is a reference to an empty <code>DocumentFragment</code> object.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* var frag = document.createDocumentFragment();
* frag.appendChild(document.createTextNode('Ipsum Lorem'));
* document.body.appendChild(frag);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>A <code><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-B63ED1A3" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-B63ED1A3">DocumentFragment</a></code> is a minimal document object that has no parent. It supports the following DOM 2 methods: <code><a href="element.appendChild" shape="rect" title="DOM:element.appendChild">appendChild</a></code>, <code><a href="element.cloneNode" shape="rect" title="DOM:element.cloneNode">cloneNode</a></code>, <code><a href="element.hasAttributes" shape="rect" title="DOM:element.hasAttributes">hasAttributes</a></code>, <code><a href="element.hasChildNodes" shape="rect" title="DOM:element.hasChildNodes">hasChildNodes</a></code>, <code><a href="element.insertBefore" shape="rect" title="DOM:element.insertBefore">insertBefore</a></code>, <code><a href="element.normalize" shape="rect" title="DOM:element.normalize">normalize</a></code>, <code><a href="element.removeChild" shape="rect" title="DOM:element.removeChild">removeChild</a></code>, <code><a href="element.replaceChild" shape="rect" title="DOM:element.replaceChild">replaceChild</a></code>.
* </p><p>It also supports the following DOM 2 properties: <code><a href="element.attributes" shape="rect" title="DOM:element.attributes">attributes</a></code>, <code><a href="element.childNodes" shape="rect" title="DOM:element.childNodes">childNodes</a></code>, <code><a href="element.firstChild" shape="rect" title="DOM:element.firstChild">firstChild</a></code>, <code><a href="element.lastChild" shape="rect" title="DOM:element.lastChild">lastChild</a></code>, <code><a href="element.localName" shape="rect" title="DOM:element.localName">localName</a></code>, <code><a href="element.namespaceURI" shape="rect" title="DOM:element.namespaceURI">namespaceURI</a></code>, <code><a href="element.nextSibling" shape="rect" title="DOM:element.nextSibling">nextSibling</a></code>, <code><a href="element.nodeName" shape="rect" title="DOM:element.nodeName">nodeName</a></code>, <code><a href="element.nodeType" shape="rect" title="DOM:element.nodeType">nodeType</a></code>, <code><a href="element.nodeValue" shape="rect" title="DOM:element.nodeValue">nodeValue</a></code>, <code><a href="element.ownerDocument" shape="rect" title="DOM:element.ownerDocument">ownerDocument</a></code>, <code><a href="element.parentNode" shape="rect" title="DOM:element.parentNode">parentNode</a></code>, <code><a href="element.prefix" shape="rect" title="DOM:element.prefix">prefix</a></code>, <code><a href="element.previousSibling" shape="rect" title="DOM:element.previousSibling">previousSibling</a></code>, <code><a href="element.textContent" shape="rect" title="DOM:element.textContent">textContent</a></code>.
* </p><p>Various other methods can take a document fragment as an argument (e.g. <code><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-1950641247" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-1950641247">Node</a></code> interface methods such as <code><a href="element.appendChild" shape="rect" title="DOM:element.appendChild">appendChild</a></code> and <code><a href="element.insertBefore" shape="rect" title="DOM:element.insertBefore">insertBefore</a></code>), in which case the children of the fragment are appended or inserted, not the fragment itself.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 2: <a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-35CB04B5" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-35CB04B5">createDocumentFragment</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Creates an empty DocumentFragment object.
 * @return DocumentFragment A new DocumentFragment .
 * @type DocumentFragment
 
 * @type DocumentFragment
*/
createDocumentFragment: function() { // COMPAT=IE6|IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Creates an element with the specified tag name.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>element</var> = <var>document</var>.createElement(<var>tagName</var>);
* </pre>
* <ul><li> <code>element</code> is the created <a href="DOM:element" shape="rect" title="DOM:element">element</a> object.
* </li><li> <code>tagName</code> is a string that specifies the type of element to be created. The <a href="element.nodeName" shape="rect" title="DOM:element.nodeName">nodeName</a> of the created element is initialized with the value of <code>tagName</code>.
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>This creates a new &lt;div&gt; and inserts it before the element with id "org_div1":
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;||Working with elements||&lt;/title&gt;
* &lt;/head&gt;
* 
* &lt;script type="text/javascript"&gt;
* var my_div = null;
* var newDiv = null;
* 
* function addElement()
* {
* // create a new div element
* // and give it some content
* newDiv = document.createElement("div");
* newDiv.innerHTML = "&lt;h1&gt;Hi there and greetings!&lt;/h1&gt;";
* 
* // add the newly created element and it's content into the DOM
* my_div = document.getElementById("org_div1");
* document.body.insertBefore(newDiv, my_div);
* }
* 
* &lt;/script&gt;
* 
* &lt;body onload="addElement()"&gt;
* &lt;div id='org_div1'&gt; The text above has been created dynamically.&lt;/div&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If there are known attributes with default values, attribute nodes representing them are automatically created and attached to the element.
* </p><p>To create an element with a qualified name and namespace URI, use the <a href="document.createElementNS" shape="rect" title="DOM:document.createElementNS">createElementNS</a> method.
* </p><p>Gecko implementation of <code>createElement</code> doesn't conform to the DOM spec for XUL and XHTML documents: <code>localName</code> and <code>namespaceURI</code> are not set to <code>null</code> on the created element. See <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=280692" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=280692">bug 280692</a> for details.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-2141741547" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-2141741547">DOM 2 Core: createElement</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Creates an element of the type specified. Note
 * that the instance returned implements the Element interface, so
 * attributes can be specified directly on the returned object. In addition, if there are known attributes with default values, Attr nodes
 * representing them are automatically created and attached to the
 * element. To create an element with a qualified name and namespace URI , use the createElementNS method.
 * @param {String} tagName of type DOMString The name of the element type to instantiate. For XML, this is
 * case-sensitive, otherwise it depends on the case-sensitivity of the
 * markup language in use. In that case, the name is mapped to the
 * canonical form of that markup by the DOM implementation.
 * @return Element A new Element object with the nodeName attribute set to tagName , and localName , prefix , and namespaceURI set to null .
 * @type Element
 
 * @type Element
*/
createElement: function(tagName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Creates an element with the specified namespace URI and qualified name.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>element</var> = <var>document</var>.createElementNS(<var>namespaceURI</var>, <var>qualifiedName</var>);
* </pre>
* <ul><li> <code>element</code> is the created <a href="DOM:element" shape="rect" title="DOM:element">element</a>.
* </li><li> <code>namespaceURI</code> is a string that specifies the <a href="http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407/glossary.html#dt-namespaceURI" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407/glossary.html#dt-namespaceURI">namespace URI</a> to associate with the element. The <a href="element.namespaceURI" shape="rect" title="DOM:element.namespaceURI">namespaceURI</a> property of the created element is initialized with the value of <code>namespaceURI</code>.
* </li><li> <code>qualifiedName</code> is a string that specifies the type of element to be created. The <a href="element.nodeName" shape="rect" title="DOM:element.nodeName">nodeName</a> property of the created element is initialized with the value of <code>qualifiedName</code>.
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>This creates a new &lt;div&gt; element in the <a href="http://developer.mozilla.org/en/docs/XHTML" shape="rect" title="XHTML">XHTML</a> namespace and appends it to the vbox element. Although this is not an extremely useful <a href="http://developer.mozilla.org/en/docs/XUL" shape="rect" title="XUL">XUL</a> document, it does demonstrate the use of elements from two different namespaces within a single document:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;?xml version="1.0"?&gt;
* &lt;page xmlns="http://www.mozilla.org/keymaster/gatekeeper/there.is.only.xul"
* xmlns:html="http://www.w3.org/1999/xhtml"
* title="||Working with elements||"
* onload="init()"&gt;
* 
* &lt;script type="text/javascript"&gt;&lt;![CDATA[
* var container;
* var newdiv;
* var txtnode;
* 
* function init(){
* container = document.getElementById("ContainerBox");
* newdiv = document.createElementNS("http://www.w3.org/1999/xhtml","html:div");
* txtnode = document.createTextNode("This is text that was constructed dynamically with createElementNS and createTextNode then inserted into the document using appendChild.");
* newdiv.appendChild(txtnode);
* container.appendChild(newdiv);
* }
* 
* ]]&gt;&lt;/script&gt;
* 
* &lt;vbox id='ContainerBox' flex='1'&gt;
* &lt;html:div&gt;
* The script on this page will add dynamic content below:
* &lt;/html:div&gt;
* &lt;/vbox&gt;
* 
* &lt;/page&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The example given above uses inline script which is not recommended in XHTML documents.  This particular example is actually an XUL document with embedded XHTML, however, the recommendation still applies. Inline script does not cause any problems for this short example, however, for any serious work you should learn about <a href="http://developer.mozilla.org/en/docs/Properly_Using_CSS_and_JavaScript_in_XHTML_Documents" shape="rect" title="Properly Using CSS and JavaScript in XHTML Documents">Properly Using CSS and JavaScript in XHTML Documents</a>.
* </p><p>To create an element without specifying a namespace URI, use the <a href="document.createElement" shape="rect" title="DOM:document.createElement">createElement</a> method.
* </p>
* <h2> <span> See Also </span></h2>
* <p><a href="DOM:document.createElement" shape="rect" title="DOM:document.createElement">document.createElement</a>
* </p><p><a href="document.createTextNode" shape="rect" title="DOM:document.createTextNode">document.createTextNode</a>
* </p><p><a href="element.namespaceURI" shape="rect" title="DOM:element.namespaceURI">element.namespaceURI</a>
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-DocCrElNS" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-DocCrElNS">DOM 2 Core: createElementNS</a>
* </p><p><a href="http://www.w3.org/TR/1999/REC-xml-names-19990114" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1999/REC-xml-names-19990114">Namespaces in XML</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Creates an element of the given qualified name and namespace URI . Per [ XML Namespaces ],
 * applications must use the value null as the
 * namespaceURI parameter for methods if they wish to have no
 * namespace.
 * @param {String} namespaceURI of type DOMString The namespace URI of the element to create.
 * @param {String} qualifiedName of type DOMString The qualified name of the element type to instantiate.
 * @return Element A new Element object with the
 * following attributes: Attribute Value Node.nodeName qualifiedName Node.namespaceURI namespaceURI Node.prefix prefix, extracted from qualifiedName , or null if there is no
 * prefix Node.localName local name , extracted from qualifiedName Element.tagName qualifiedName
 * @type Element
 
 * @type Element
*/
createElementNS: function(namespaceURI, qualifiedName) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates an EntityReference object. In
 * addition, if the referenced entity is known, the child list of the EntityReference node is
 * made the same as that of the corresponding Entity node. Note: If any descendant of the Entity node has an unbound namespace prefix ,
 * the corresponding descendant of the created EntityReference node is
 * also unbound; (its namespaceURI is null ).
 * The DOM Level 2 and 3 do not support any mechanism to resolve
 * namespace prefixes in this case.
 * @param {String} name of type DOMString The name of the entity to reference. Unlike Document.createElementNS or Document.createAttributeNS ,
 * no namespace well-formed checking is done on the entity name.
 * Applications should invoke Document.normalizeDocument() with the parameter " namespaces " set to true in order to ensure that the entity name is
 * namespace well-formed.
 * @return EntityReference The new EntityReference object.
 * @type EntityReference
 */
createEntityReference: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Creates an <a href="event" shape="rect" title="DOM:event">event</a> of the type specified. The returned object should be first initialized and can then be passed to <a href="element.dispatchEvent" shape="rect" title="DOM:element.dispatchEvent">element.dispatchEvent</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i> = <i>document</i>.createEvent(<i>type</i>)
* </pre>
* <ul><li> <code>event</code> is the created <a href="DOM:event" shape="rect" title="DOM:event">Event</a> object.
* </li><li> <code>type</code> is a string that represents the type of event to be created. Possible event types include <code>"UIEvents"</code>, <code>"MouseEvents"</code>, <code>"MutationEvents"</code>, and <code>"HTMLEvents"</code>. See <a href="document.createEvent#Notes" shape="rect" title="">Notes</a> section for details.
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>This example demonstrates simulating a click on a checkbox using DOM methods. You can view the example in action <a href="http://developer.mozilla.org/samples/domref/dispatchEvent.html" rel="nofollow" shape="rect" title="http://developer.mozilla.org/samples/domref/dispatchEvent.html">here</a>.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function simulateClick() {
* var evt = <strong>document.createEvent</strong>("MouseEvents");
* evt.<a href="event.initMouseEvent" shape="rect" title="DOM:event.initMouseEvent">initMouseEvent</a>("click", true, true, window,
* 0, 0, 0, 0, 0, false, false, false, false, 0, null);
* var cb = document.getElementById("checkbox");
* var canceled = !cb.<a href="element.dispatchEvent" shape="rect" title="DOM:element.dispatchEvent">dispatchEvent</a>(evt);
* if(canceled) {
* // A handler called preventDefault
* alert("canceled");
* } else {
* // None of the handlers called preventDefault
* alert("not canceled");
* }
* }
* </pre>
* <p>
* </p><p>
* </p>
* <h2> <span> Notes </span></h2>
* <p>Event type strings suitable for passing to <code>createEvent</code> are defined in <i>event modules</i>. Some event modules are defined in DOM Events specifications, some modules are defined in other specification (such as SVG), and some event types are Gecko-specific. See the table below for details.
* </p><p><i>To-do: add event names to the table too.</i>
* </p>
* <table border="1" style="background:#FFFFFF none repeat scroll 0%;border: 1px solid #666666;margin-bottom:10px;margin-top:10px" width="100%">
* <tr>
* <th colspan="1" rowspan="1">Event Module</th>
* <th colspan="1" rowspan="1">Event type to pass to <code>createEvent</code></th>
* <th colspan="1" rowspan="1">Method to be used to initialize the event</th>
* </tr>
* 
* <tr style="background-color: #eee">
* <td colspan="3" rowspan="1"><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-eventgroupings" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-eventgroupings">DOM Level 2 Events</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">User Interface event module</td>
* <td colspan="1" rowspan="1"><code>"UIEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initUIEvent" shape="rect" title="DOM:event.initUIEvent">event.initUIEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Mouse event module</td>
* <td colspan="1" rowspan="1"><code>"MouseEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initMouseEvent" shape="rect" title="DOM:event.initMouseEvent">event.initMouseEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Mutation event module</td>
* <td colspan="1" rowspan="1"><code>"MutationEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initMutationEvent&amp;action=edit" shape="rect" title="DOM:event.initMutationEvent">event.initMutationEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">HTML event module</td>
* <td colspan="1" rowspan="1"><code>"HTMLEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initEvent" shape="rect" title="DOM:event.initEvent">event.initEvent</a></td>
* </tr>
* 
* <tr style="background-color: #eee">
* <td colspan="3" rowspan="1"><a href="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-eventgroupings" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-eventgroupings">DOM Level 3 Events</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">User Interface event module</td>
* <td colspan="1" rowspan="1"><code>"UIEvent"</code>, <code>"UIEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initUIEvent" shape="rect" title="DOM:event.initUIEvent">event.initUIEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Mouse event module</td>
* <td colspan="1" rowspan="1"><code>"MouseEvent"</code>, <code>"MouseEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initMouseEvent" shape="rect" title="DOM:event.initMouseEvent">event.initMouseEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Mutation event module</td>
* <td colspan="1" rowspan="1"><code>"MutationEvent"</code>, <code>"MutationEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initMutationEvent&amp;action=edit" shape="rect" title="DOM:event.initMutationEvent">event.initMutationEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Mutation name event module (not implemented in Gecko as of June 2006)</td>
* <td colspan="1" rowspan="1"><code>"MutationNameEvent"</code></td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initMutationNameEvent&amp;action=edit" shape="rect" title="DOM:event.initMutationNameEvent">event.initMutationNameEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Text event module</td>
* <td colspan="1" rowspan="1"><code>"TextEvent"</code> (Gecko also supports <code>"TextEvents"</code>)</td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initTextEvent&amp;action=edit" shape="rect" title="DOM:event.initTextEvent">event.initTextEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Keyboard event module</td>
* <td colspan="1" rowspan="1"><code>"KeyboardEvent"</code> (Gecko also supports <code>"KeyEvents"</code>)</td>
* <td colspan="1" rowspan="1"><a href="event.initKeyEvent" shape="rect" title="DOM:event.initKeyEvent">event.initKeyEvent</a> (Gecko-specific; the DOM 3 Events working draft uses <code>initKeyboardEvent</code> instead)</td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1">Basic events module</td>
* <td colspan="1" rowspan="1"><code>"Event"</code> (Gecko also supports <code>"Events"</code>)</td>
* <td colspan="1" rowspan="1"><a href="event.initEvent" shape="rect" title="DOM:event.initEvent">event.initEvent</a></td>
* </tr>
* 
* <tr style="background-color: #eee">
* <td colspan="3" rowspan="1"><a href="http://www.w3.org/TR/SVG/script.html#DOMInterfaces" rel="nofollow" shape="rect" title="http://www.w3.org/TR/SVG/script.html#DOMInterfaces">SVG 1.1 Scripting</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="2">SVG</td>
* <td colspan="1" rowspan="1"><code>"SVGEvents"</code> (Gecko also supports <code>"SVGEvent"</code>)</td>
* <td colspan="1" rowspan="1"><a href="event.initEvent" shape="rect" title="DOM:event.initEvent">event.initEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>"SVGZoomEvents"</code> (Gecko also supports <code>"SVGZoomEvent"</code>)</td>
* <td colspan="1" rowspan="1"><a href="event.initUIEvent" shape="rect" title="DOM:event.initUIEvent">event.initUIEvent</a></td>
* </tr>
* 
* <tr style="background-color: #eee">
* <td colspan="3" rowspan="1">Other event types supported by Gecko </td>
* </tr>
* <tr>
* <td colspan="1" rowspan="3">-</td>
* <td colspan="1" rowspan="1"><code>"MouseScrollEvents"</code>, <code>"PopupEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="event.initMouseEvent" shape="rect" title="DOM:event.initMouseEvent">event.initMouseEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>"PopupBlockedEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initPopupBlockedEvent&amp;action=edit" shape="rect" title="DOM:event.initPopupBlockedEvent">event.initPopupBlockedEvent</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>"XULCommandEvent"</code>, <code>"XULCommandEvents"</code></td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/index.php?title=event.initCommandEvent&amp;action=edit" shape="rect" title="DOM:event.initCommandEvent">event.initCommandEvent</a></td>
* </tr>
* </table>
* <p>The reason some events can be created using any of two event type strings is that DOM Level 3 Events changed the event type strings to be singular, while still supporting older plural names for backwards-compatibility.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-DocumentEvent-createEvent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-DocumentEvent-createEvent">DOM Level 2 Events: createEvent</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-DocumentEvent-createEvent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-DocumentEvent-createEvent">DOM Level 3 Events: createEvent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * @type Event
*/
createEvent: function(type) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Creates an <code>XPathNSResolver</code> which resolves namespaces with respect to the definitions in scope for a specified node.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nsResolver</i> = document.createNSResolver(<i>node</i>);
* </pre>
* <p>where
* </p>
* <ul><li> <code>nsResolver</code> is an XPathNSResolver object.
* </li><li> <code>node</code> is the node to be used as a context for namespace resolution.
* </li></ul>
* <h2> <span> Notes </span></h2>
* <p>Adapts any DOM node to resolve namespaces so that an <a href="http://developer.mozilla.org/en/docs/XPath" shape="rect" title="XPath">XPath</a> expression can be easily evaluated relative to the context of the node where it appeared within the document. This adapter works like the DOM Level 3 method <code>lookupNamespaceURI</code> on nodes in resolving the <code>namespaceURI</code> from a given prefix using the current information available in the node's hierarchy at the time <code>lookupNamespaceURI</code> is called. Also correctly resolving the implicit <tt>xml</tt> prefix.
* </p><p><code>createNSResolver</code> was introduced in DOM Level 3.
* </p>
* <h2> <span> See also </span></h2>
* <ul><li> <a href="DOM:document.evaluate" shape="rect" title="DOM:document.evaluate">document.evaluate</a>
* </li><li> <a href="http://developer.mozilla.org/en/docs/Introduction_to_using_XPath_in_JavaScript" shape="rect" title="Introduction to using XPath in JavaScript">Introduction to using XPath in JavaScript</a>
* </li></ul>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-3-XPath/xpath.html#XPathEvaluator-createNSResolver" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-XPath/xpath.html#XPathEvaluator-createNSResolver">DOM Level 3 XPath Specification: createNSResolver</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createNSResolver: function(node) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates a ProcessingInstruction node given the specified name and data strings.
 * @param {String} target of type DOMString The target part of the processing instruction. Unlike Document.createElementNS or Document.createAttributeNS ,
 * no namespace well-formed checking is done on the target name.
 * Applications should invoke Document.normalizeDocument() with the parameter " namespaces " set to true in order to ensure that the target name is
 * namespace well-formed.
 * @param {String} data of type DOMString The data for the node.
 * @return ProcessingInstruction The new ProcessingInstruction object.
 * @type ProcessingInstruction
 
 * @type ProcessingExpression
*/
createProcessingInstruction: function(target,data) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a new <code><a href="range" shape="rect" title="DOM:range">Range</a></code> object.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>range</var> = <var>document</var>.createRange();
* </pre>
* <p><code>range</code> is the created <a href="DOM:range" shape="rect" title="DOM:range">range</a> object.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var range = document.createRange();
* range.setStart(startNode, startOffset);
* range.setEnd(endNode, endOffset);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Once a <code>Range</code> is created, you need to set its boundary points before you can make use of most of its methods.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-DocumentRange-method-createRange" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html#Level2-DocumentRange-method-createRange">DOM Level 2 Range: DocumentRange.createRange</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * @type Range
*/
createRange: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Creates a new Text node.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>text</i> = document.createTextNode(<i>data</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>text</code> is a Text node.
* </li><li><code>data</code> is a string containing the data to be put in the text node.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;createTextNode example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function addTextNode()
* {
* var newtext = document.createTextNode(" Some text added dynamically. ");
* var para = document.getElementById("p1");
* para.appendChild(newtext);
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;div style="border: 1px solid red"&gt;
* &lt;p id="p1"&gt;First line of paragraph.&lt;br /&gt;&lt;/p&gt;
* &lt;/div&gt;&lt;br /&gt;
* 
* &lt;button onclick="addTextNode();"&gt;add another textNode.&lt;/button&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-1975348127" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-1975348127">createTextNode </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Creates a Text node given the
 * specified string.
 * @param {String} data of type DOMString The data for the node.
 * @return Text The new Text object.
 * @type Text
 
 * @type Text
*/
createTextNode: function(data) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a new <code><a href="treeWalker" shape="rect" title="DOM:treeWalker">TreeWalker</a></code> object.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var treeWalker = document.createTreeWalker(root, whatToShow, filter, entityReferenceExpansion);
* </pre>
* <ul><li> <code>root</code> is the root of the TreeWalker's traversal
* </li><li> <code>whatToShow</code> is one of the constant properties of <code><a href="http://www.xulplanet.com/references/xpcomref/ifaces/nsIDOMNodeFilter.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/xpcomref/ifaces/nsIDOMNodeFilter.html">NodeFilter</a></code>
* </li><li> <code>filter</code> is an object with a method <code>acceptNode</code>, which is called by the TreeWalker to determine whether or not to accept a node. The function should return <code>NodeFilter.FILTER_ACCEPT</code> or <code>NodeFilter.FILTER_REJECT</code>. (See example)
* </li><li> <code>entityReferenceExpansion</code>
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var treeWalker = document.createTreeWalker(
* document.body,
* NodeFilter.SHOW_ELEMENT,
* { acceptNode: function(node) { return NodeFilter.FILTER_ACCEPT; } },
* false
* );
* var nodeList = new Array();
* while(treeWalker.nextNode()) nodeList.push(treeWalker.currentNode);
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/traversal.html#Traversal-TreeWalker" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Traversal-Range/traversal.html#Traversal-TreeWalker">DOM Level 2 Traversal: TreeWalker</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsExample" shape="rect" title="Category:NeedsExample">NeedsExample</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsContent" shape="rect" title="Category:NeedsContent">NeedsContent</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
createTreeWalker: function(root, whatToShow, filter, entityReferenceExpansion) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p><b>document.defaultView</b> returns a reference to the default <a href="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-AbstractView" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-AbstractView">AbstractView</a> for the document, or <code>null</code> if none available
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var docDView = document.defaultView;
* </pre>
* <p>This property is read-only.
* </p>
* <h2> <span> Notes </span></h2>
* <p><code>document.defaultView</code> is part of the DOM Level 2 <a href="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-DocumentView" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-DocumentView">DocumentView</a> interface.
* </p><p><code>document.defaultView</code> is generally a reference to the <a href="window" shape="rect" title="DOM:window">window</a> object for the document, however that is not defined in the specification and can't be relied upon for all host environments, particularly as not all browsers implement it.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-DocumentView-defaultView" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Views/views.html#Views-DocumentView-defaultView">DOM Level 2 Views: defaultView</a>
* </p>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
defaultView: undefined,
/**
* <p>use in a iframe.
* iframe.document.designMode = "on";
* you can get the iframe text with iframe.document.body.innerHTML
* </p>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
designMode: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the Document Type Declaration (DTD) associated with current document. The returned object implements <a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-412266927" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/core.html#ID-412266927">DocumentType</a> interface.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>doctype</var> = <var>document</var>.doctype;
* </pre>
* <p><code>doctype</code> is a read-only property.
* </p>
* <h2> <span> Notes </span></h2>
* <p>The property returns <code>null</code> if there is no DTD associated with the current document.
* </p><p>DOM level 2 doesn't support editing the document type declaration.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-B63ED1A31" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-B63ED1A31">DOM Level 2 Core: doctype</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The Document Type Declaration (see DocumentType) associated
 * with this document. For XML documents without a document type
 * declaration this returns null. For HTML documents, a
 * DocumentType object may
 * be returned, independently of the presence or absence of document
 * type declaration in the HTML document.
 * This provides direct access to the DocumentType node, child
 * node of this Document. This node can be set at
 * document creation time and later changed through the use of child
 * nodes manipulation methods, such as Node.insertBefore, or
 * Node.replaceChild. Note,
 * however, that while some implementations may instantiate different
 * types of Document objects supporting additional
 * features than the "Core", such as "HTML" [DOM Level 2
 * HTML], based on the DocumentType specified at
 * creation time, changing it afterwards is very unlikely to result in
 * a change of the features supported.
 * @type DocumentType
 */
doctype: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p><b>Read-only</b>
* </p><p>Returns the <code><a href="element" shape="rect" title="DOM:element">Element</a></code> that is the root element of the <a href="document" shape="rect" title="DOM:document">document</a> (for example, the <code>&lt;html&gt;</code> element for HTML documents).
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>element</i> = document.documentElement;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var rootElement = document.documentElement;
* var firstTier = rootElement.childNodes;
* // firstTier is the NodeList of the direct children of the root element
* for (var i = 0; i &lt; firstTier.length; i++) {
* // do something with each direct kid of the root element
* // as firstTier[i]
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This property is a read-only convenience for getting the root element associated with any document.
* </p><p>HTML documents typically contain a single child node, <code>&lt;html&gt;</code>, perhaps with a DOCTYPE declaration before it. XML documents often contain multiple child nodes: the root element, the DOCTYPE declaration, and <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:ProcessingInstruction&amp;action=edit" shape="rect" title="DOM:ProcessingInstruction"> processing instructions</a>.
* </p><p>That's why you should use <code>document.documentElement</code> rather than <code><a href="document.firstChild" shape="rect" title="DOM:document.firstChild">document.firstChild</a></code> to get the root element.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-87CD092" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-87CD092">DOM Level 2 Core: Document.documentElement</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * This is a convenience attribute that
 * allows direct access to the child node that is the document element of the
 * document.
 * @type Element
 */
documentElement: undefined,
/**
 * The location of the document or null if undefined
 * or if the Document was created using DOMImplementation.createDocument.
 * No lexical checking is performed when setting this attribute; this
 * could result in a null value returned when using
 * Node.baseURI.
 * Beware that when the Document supports the feature
 * "HTML" [DOM Level 2 HTML], the href
 * attribute of the HTML BASE element takes precedence over this
 * attribute when computing Node.baseURI.
 * @type String
 */
documentURI: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p><b>Read-only</b>
* </p><p>Returns an <code><a href="http://developer.mozilla.org/en/docs/nsIURI" shape="rect" title="nsIURI">nsIURI</a></code> object representing the URI of the <a href="document" shape="rect" title="DOM:document">document</a>.
* </p><p>This only works for privileged (UniversalXPConnect) scripts, including extension code. For web content this property doesn't have any special meaning and can be used just like any other custom property.
* </p><p>Privileged code must be careful not to try getting or setting this property on a non-wrapped content object (e.g. on a <code>wrappedJSObject</code> of an <code><a href="http://developer.mozilla.org/en/docs/XPCNativeWrapper" shape="rect" title="XPCNativeWrapper">XPCNativeWrapper</a></code>). See <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=324464" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=324464">bug 324464</a>'s comments for details.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>uri</i> = <i>doc</i>.documentURIObject;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Check that the URI scheme of the current tab in Firefox is 'http',
* // assuming this code runs in context of browser.xul
* var uriObj = content.document.documentURIObject;
* var uriPort = uriObj.port;
* 
* if (uriObj.schemeIs('http')) {
* ...
* }
* </pre>
* <h2> <span> Specification </span></h2>
* <p>Not part of any specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
documentURIObject: undefined,
/**
 * The configuration used when Document.normalizeDocument()
 * is invoked.
 * @type DOMConfiguration
 */
domConfig: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Gets/sets the domain of the current document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>domainString</i> = document.domain;
* document.domain = <i>string</i>;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// for document www.love.com/good.html,
* // this script closes the window
* var badDomain = "www.love.com";
* if (document.domain == badDomain)
* window.close();
* </pre>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// For the URI <a href="DOM" rel="nofollow" shape="rect" title="http://developer.mozilla.org/en/docs/DOM">http://developer.mozilla.org/en/docs/DOM</a> the
* // following sets domain to the string "developer.mozilla.org"
* var domain = document.domain;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This property returns <code>null</code> if the domain of the document cannot be identified.
* </p><p>In the DOM spec, this property is listed as being read-only, but Mozilla lets you set it to a superdomain of the current value. For example, on developer.mozilla.org it is possible to set it to "mozilla.org" and "org" but not "mozilla.com".
* </p>
* <h2> <span> References </span></h2>
* <p><span><a href="http://developer.mozilla.org/en/docs/Scripts_and_the_Same_Origin_Policy_%28external%29" shape="rect" title="Scripts and the Same Origin Policy (external)">Scripts and the Same Origin Policy</a></span>
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-2250147" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-2250147">DOM Level 2 HTML: document.domain</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
domain: undefined,
/**
* <div style="border: 1px solid #818151; background-color: #FFFFE1; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">This article covers features introduced in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></p></div>
* 
* <h2> <span> Summary </span></h2>
* <p>Returns the element visible at the given point, which is specified relative to the top left visible point in the document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>element</i> = document.elementFromPoint(<i>x</i>, <i>y</i>);
* </pre>
* <p>where
* </p>
* <ul><li> <code>element</code> is an <a href="element" shape="rect" title="DOM:element">element</a> object.
* </li><li> <code>x</code> and <code>y</code> specify the coordinates to check.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;elementFromPoint example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function changeColor(newColor)
* {
* elem = document.elementFromPoint(2, 2);
* elem.style.color = newColor;
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;p id="para1"&gt;Some text here&lt;/p&gt;
* &lt;button onclick="changeColor('blue');"&gt;blue&lt;/button&gt;
* &lt;button onclick="changeColor('red');"&gt;red&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If the element at the specified point belongs to another document (for example, an iframe's subdocument), the element in the calling document's DOM (the iframe itself) is returned.  If the element at the given point is anonymous or XBL generated content, such as a textbox's scroll bars, then the first non-anonymous parent element (for example, the textbox) is returned.
* </p><p>If the specified point is outside the visible portion of the document or either coordinate is negative, the result is <code>NULL</code>.
* </p>
* <blockquote><div><b>Note:</b> Callers from XUL documents should wait until the <code>onload</code> event has fired before calling this method.</div></blockquote>
* <h2> <span> Specification </span></h2>
* <ul><li> Preliminary specification: <code><a href="http://dev.w3.org/csswg/cssom/#documentlayout-elementfrompoint" rel="nofollow" shape="rect" title="http://dev.w3.org/csswg/cssom/#documentlayout-elementfrompoint">elementFromPoint</a></code>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
elementFromPoint: function(x, y) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><code>embeds</code> returns a list of the embedded OBJECTS within the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nodeList</i> = document.embeds
* </pre>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/collections/embeds.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/collections/embeds.asp">MSDN: embeds collection</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
embeds: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns an <code><a href="http://developer.mozilla.org/en/docs/index.php?title=XPathResult&amp;action=edit" shape="rect" title="XPathResult">XPathResult</a></code> based on an <a href="http://developer.mozilla.org/en/docs/XPath" shape="rect" title="XPath">XPath</a> expression and other given parameters.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var xpathResult = document.evaluate(
* xpathExpression,
* contextNode,
* namespaceResolver,
* resultType,
* result);
* </pre>
* <ul><li> <code>xpathExpression</code> is a string representing the XPath to be evaluated.
* </li><li> <code>contextNode</code> specifies the <i>context node</i> for the query (see the [<a href="http://www.w3.org/TR/xpath" rel="nofollow" shape="rect" title="http://www.w3.org/TR/xpath">http://www.w3.org/TR/xpath</a> XPath specification). It's common to pass <code>document</code> as the context node.
* </li><li> <code>namespaceResolver</code> is a function that will be passed any namespace prefixes and should return a string representing the namespace URI associated with that prefix. It will be used to resolve prefixes within the XPath itself, so that they can be matched with the document. <code>null</code> is common for HTML documents or when no namespace prefixes are used.
* </li><li> <code>resultType</code> is an integer that corresponds to the type of result <code>XPathResult</code> to return. Use <a href="document.evaluate#Result_types" shape="rect" title="">named constant properties</a>, such as <code>XPathResult.ANY_TYPE</code>, of the XPathResult constructor, which correspond to integers from 0 to 9.
* </li><li> <code>result</code> is an existing <code>XPathResult</code> to use for the results. <code>null</code> is the most common and will create a new <code>XPathResult</code>
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>From the <a href="http://www-xray.ast.cam.ac.uk/~jgraham/mozilla/xpath-tutorial.html" rel="nofollow" shape="rect" title="http://www-xray.ast.cam.ac.uk/~jgraham/mozilla/xpath-tutorial.html">Mozilla XPath Tutorial</a>:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var headings = document.evaluate("//h2", document, null, XPathResult.ANY_TYPE, null);
* / * Search the document for all h2 elements.
* * The result will likely be an unordered node iterator. * /
* var thisHeading = headings.iterateNext();
* var alertText = "Level 2 headings in this document are:\n"
* while (thisHeading) {
* alertText += thisHeading.textContent + "\n"
* thisHeading = headings.iterateNext();
* }
* alert(alertText); // Alerts the text of all h2 elements
* </pre>
* <h2> <span> Notes </span></h2>
* <p>XPath expressions can be evaluated on HTML and XML documents.
* </p>
* <h2> <span> Result types </span></h2>
* <p>These are supported values for the <code>resultType</code> parameter of the <code>evaluate</code> method:
* </p>
* <table border="1" style="background:#FFFFFF none repeat scroll 0%;border: 1px solid #666666;margin-bottom:10px;margin-top:10px" width="100%">
* 
* <tr>
* <td colspan="1" rowspan="1" style="background:#DDDDDD none repeat scroll 0%; border:1px solid #BBBBBB;">Result Type
* </td><td colspan="1" rowspan="1" style="background:#DDDDDD none repeat scroll 0%; border:1px solid #BBBBBB;">Value
* </td><td colspan="1" rowspan="1" style="background:#DDDDDD none repeat scroll 0%; border:1px solid #BBBBBB;">Description
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>ANY_TYPE</code>
* </td><td colspan="1" rowspan="1">0
* </td><td colspan="1" rowspan="1">Whatever type naturally results from the given expression.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>NUMBER_TYPE</code>
* </td><td colspan="1" rowspan="1">1
* </td><td colspan="1" rowspan="1">A result set containing a single number.  Useful, for example, in an XPath expression using the <code>count()</code> function.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>STRING_TYPE</code>
* </td><td colspan="1" rowspan="1">2
* </td><td colspan="1" rowspan="1">A result set containing a single string.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>BOOLEAN_TYPE</code>
* </td><td colspan="1" rowspan="1">3
* </td><td colspan="1" rowspan="1">A result set containing a single boolean value. Useful, for example, an an XPath expression using the <code>not()</code> function.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>UNORDERED_NODE_ITERATOR_TYPE</code>
* </td><td colspan="1" rowspan="1">4
* </td><td colspan="1" rowspan="1">A result set containing all the nodes matching the expression.  The nodes in the result set are not necessarily in the same order they appear in the document.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>ORDERED_NODE_ITERATOR_TYPE</code>
* </td><td colspan="1" rowspan="1">5
* </td><td colspan="1" rowspan="1">A result set containing all the nodes matching the expression.  The nodes in the result set are in the same order they appear in the document.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>UNORDERED_NODE_SNAPSHOT_TYPE</code>
* </td><td colspan="1" rowspan="1">6
* </td><td colspan="1" rowspan="1">A result set containing snapshots of all the nodes matching the expression. The nodes in the result set are not necessarily in the same order they appear in the document.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>ORDERED_NODE_SNAPSHOT_TYPE</code>
* </td><td colspan="1" rowspan="1">7
* </td><td colspan="1" rowspan="1">A result set containing snapshots of all the nodes matching the expression. The nodes in the result set are in the same order they appear in the document.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>ANY_UNORDERED_NODE_TYPE</code>
* </td><td colspan="1" rowspan="1">8
* </td><td colspan="1" rowspan="1">A result set containing any single node that matches the expression. The node is not necessarily the first node in the document that matches the expression.
* </td></tr>
* 
* <tr>
* <td colspan="1" rowspan="1"><code>FIRST_ORDERED_NODE_TYPE</code>
* </td><td colspan="1" rowspan="1">9
* </td><td colspan="1" rowspan="1">A result set containing the first node in the document that matches the expression.
* </td></tr>
* </table>
* <p>Results of <code>NODE_ITERATOR</code> types contain references to nodes in the document.  Modifying a node will invalidate the iterator.  After modifying a node, attempting to iterate through the results will result in an error.
* </p><p>Results of <code>NODE_SNAPSHOT</code> types are snapshots, which are essentially lists of matched nodes.  You can make changes to the document by altering snapshot nodes.  Modifying the document doesn't invalidate the snapshot; however, if the document is changed, the snapshot may not correspond to the current state of the document, since nodes may have moved, been changed, added, or removed.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-3-XPath/xpath.html#XPathEvaluator-evaluate" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-XPath/xpath.html#XPathEvaluator-evaluate">DOM Level 3 XPath</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
evaluate: function( xpathExpression,contextNode,namespaceResolver,resultType,result) {
  // This is just a stub for a builtin native JavaScript object.
},
execCommand: function(aCommandName, aShowDefaultUI, aValueArgument) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p><code>fgColor</code> gets/sets the foreground color, or text color, of the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">  <i>color</i> = document.fgColor
* document.fgColor = <i>color</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>color</code> is a string representing the color as a word (e.g., "red") or hexadecimal value (e.g., "<code>#ff0000</code>").
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.fgColor = "white";
* document.bgColor = "darkblue";
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The default value for this property in Mozilla Firefox is black (<code>#000000</code> in hexadecimal).
* </p><p><code>document.fgColor</code> is <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">deprecated in DOM Level 2 HTML</a>.  The recommended alternative is the CSS property <code><a href="http://developer.mozilla.org/en/docs/CSS:color" shape="rect" title="CSS:color">color</a></code> (e.g., <code>document.body.style.color = "red"</code>).
* </p><p>Another alternative is <code>document.body.text</code>, although this is <a href="http://www.w3.org/TR/html401/struct/global.html#adef-text" rel="nofollow" shape="rect" title="http://www.w3.org/TR/html401/struct/global.html#adef-text">deprecated in HTML 4.01</a> in favor of the CSS alternative above.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/fgcolor.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/fgcolor.asp">MSDN: fgColor Property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
fgColor: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the first node in the list of direct children of the <code>Document</code>.
* </p>
* <blockquote><div><b>Note:</b> The returned node is not necessarily the root element of the document; it can also be a processing instruction, for example. If you need the root element, use <code><a href="document.documentElement" shape="rect" title="DOM:document.documentElement">document.documentElement</a></code>.</div></blockquote>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>child</i> = <i>document</i>.firstChild
* </pre>
* <ul><li><code>child</code> is the returned <code>Node</code>.
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>Suppose we have an HTML document. The following statement will alert <tt>[object DocumentType]</tt> if the document has a DTD, or <tt>[object HTMLHtmlElement]</tt> if the first node is <tt>&lt;html&gt;</tt>:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">alert(document.firstChild);
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-169727388" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-169727388">DOM Level 2 Core: Node.firstChild</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * <p>(Placeholder)
* </p>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
firstChild: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p><code>forms</code> returns a list of the FORM elements within the current document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><code>nodeList</code> = document.forms
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* 
* &lt;head&gt;
* &lt;title&gt; document.forms example&lt;/title&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;form id="robby"&gt;
* &lt;input type="button" onclick="alert(document.forms[0].id);"
* value="robby's form" /&gt;
* &lt;/form&gt;
* 
* &lt;form id="dave"&gt;
* &lt;input type="button" onclick="alert(document.forms[1].id);"
* value="dave's form" /&gt;
* &lt;/form&gt;
* 
* &lt;form id="paul"&gt;
* &lt;input type="button" onclick="alert(document.forms[2].id);"
* value="paul's form" /&gt;
* &lt;/form&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-1689064" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-1689064">forms DOM Level 2 HTML: forms</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
forms: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the element whose ID is specified.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>element</i> = document.getElementById(<i>id</i>);
* </pre>
* <p>where
* </p>
* <ul><li> <code>element</code> is an <a href="DOM:element" shape="rect" title="DOM:element">element</a> object.
* </li><li> <code>id</code> is a string representing the unique ID of the element being sought.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;getElementById example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function changeColor(newColor)
* {
* elem = document.getElementById("para1");
* elem.style.color = newColor;
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;p id="para1"&gt;Some text here&lt;/p&gt;
* &lt;button onclick="changeColor('blue');"&gt;blue&lt;/button&gt;
* &lt;button onclick="changeColor('red');"&gt;red&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If there is no element with the given id, this function returns <code>null</code>. Note also that the DOM implementation must have information that says which attributes are of type ID. Attributes with the name "id" are not of type ID unless so defined in the document's DTD. The <code>id</code> attribute is defined to be of ID type in the common cases of <a href="http://developer.mozilla.org/en/docs/XHTML" shape="rect" title="XHTML">XHTML</a>, <a href="http://developer.mozilla.org/en/docs/XUL" shape="rect" title="XUL">XUL</a>, and other. Implementations that do not know whether attributes are of type ID or not are expected to return <code>null</code>.
* </p><p>Simply creating an element and assigning an ID will not make the element accessible by <code>getElementById</code>. Instead one needs to insert the element first into the document tree with <code><a href="element.insertBefore" shape="rect" title="DOM:element.insertBefore">insertBefore</a></code> or a similar method, probably into a hidden div.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var element = document.createElement("div");
* element.id = 'testqq';
* var el = document.getElementById('testqq'); // el will be null!
* </pre>
* <p><code>getElementById</code> was introduced in DOM Level 1 for HTML documents and moved to all documents in DOM Level 2.
* </p>
* <h2> <span> Specification </span></h2>
* <ul><li> DOM Level 2 Core Specification: <a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-getElBId" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-getElBId">getElementById</a>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Returns the Element that has an ID
 * attribute with the given value. If no such element exists, this
 * returns null . If more than one element has an ID
 * attribute with that value, what is returned is undefined. The DOM implementation is expected to use the attribute Attr.isId to determine if an
 * attribute is of type ID. Note: Attributes with the name "ID" or "id" are not of
 * type ID unless so defined.
 * @param {String} elementId of type DOMString The unique id value for an element.
 * @return Element The matching element or null if there is none.
 * @type Element
 
 * @type Element
*/
getElementById: function(id) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a list of elements with a given <code><a href="element.name" shape="rect" title="DOM:element.name">name</a></code> in the (X)HTML document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>elements</i> = document.getElementsByName(<i>name</i>)
* </pre>
* <ul><li> <code>elements</code> is a <a href="http://developer.mozilla.org/en/docs/index.php?title=NodeList&amp;action=edit" shape="rect" title="NodeList">NodeList</a> of elements.
* </li><li> <code>name</code> is the value of the <code>name</code> attribute of the element.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // return some of the divs
* //&lt;div name="up"&gt;200&lt;/div&gt;
* //&lt;div name="up"&gt;145&lt;/div&gt;
* //&lt;div name="down"&gt;146&lt;/div&gt;
* //&lt;div name="other"&gt;178&lt;/div&gt;
* up_divs = document.getElementsByName("up");
* dump(up_divs.item(0).tagName); // returns "div"
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The <a href="element.name" shape="rect" title="DOM:element.name">name</a> attribute is only valid for a limited set of HTML elements, therefore <code>getElementsByName()</code> is only applicable to those elements.
* </p><p>This method is only applicable to (X)HTML documents.
* </p><p><code>document.getElementsByName</code> returns a <a href="http://developer.mozilla.org/en/docs/index.php?title=NodeList&amp;action=edit" shape="rect" title="NodeList">NodeList</a> of all the elements with a given value for the name attribute. Unlike <a href="document.getElementsByTagName" shape="rect" title="DOM:document.getElementsByTagName">getElementsByTagName</a>, which uses the name of the tag itself, this method applies only to elements that have been given a value for their <code>name</code> attribute.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-71555259" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-71555259">DOM Level 2 HTML: getElementsByName</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
getElementsByName: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a list of elements with the given tag name. The complete document is searched, including the root node.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>elements</i> = document.getElementsByTagName(<i>name</i>)
* </pre>
* <ul><li> <code>elements</code> is a live <code>NodeList</code> of found elements in the order they appear in the tree.
* </li><li> <code>name</code> is a string representing the name of the elements. The special string "*" represents all elements.
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>In the following example <code>getElementsByTagName</code> starts from a particular parent element, and searches topdown recursively through the DOM from that parent element, looking for child elements matching the tag <code>name</code> parameter.
* </p><p>Note that when the node on which <code>getElementsByTagName</code> is invoked is not the <code>document</code> node, in fact the <a href="element.getElementsByTagName" shape="rect" title="DOM:element.getElementsByTagName">element.getElementsByTagName</a> method is used.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* 
* &lt;head&gt;
* &lt;title&gt;getElementsByTagName example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function getAllParaElems()
* {
* var allParas = document.getElementsByTagName("p");
* 
* var num = allParas.length;
* 
* alert("There are " + num + " &lt;p&gt; elements in this document");
* }
* 
* function div1ParaElems()
* {
* var div1 = document.getElementById("div1")
* var div1Paras = div1.getElementsByTagName("p");
* 
* var num = div1Paras.length;
* 
* alert("There are " + num + " &lt;p&gt; elements in div1 element");
* }
* 
* function div2ParaElems()
* {
* var div2 = document.getElementById("div2")
* var div2Paras = div2.getElementsByTagName("p");
* 
* var num = div2Paras.length;
* 
* alert("There are " + num + " &lt;p&gt; elements in div2 element");
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body style="border: solid green 3px"&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* 
* &lt;div id="div1" style="border: solid blue 3px"&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* 
* &lt;div id="div2" style="border: solid red 3px"&gt;
* &lt;p&gt;Some div2 text&lt;/p&gt;
* &lt;p&gt;Some div2 text&lt;/p&gt;
* &lt;/div&gt;
* &lt;/div&gt;
* 
* &lt;p&gt;Some outer text&lt;/p&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* 
* &lt;button onclick="getAllParaElems();"&gt;
* show all p elements in document&lt;/button&gt;&lt;br /&gt;
* 
* &lt;button onclick="div1ParaElems();"&gt;
* show all p elements in div1 element&lt;/button&gt;&lt;br /&gt;
* 
* &lt;button onclick="div2ParaElems();"&gt;
* show all p elements in div2 element&lt;/button&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-A6C9094" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-A6C9094">DOM Level 2 Core: Document.getElementsByTagName</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Returns a NodeList of all descendant Elements with a given tag name, in document order .
 * @param name of type DOMString The name of the tag to match on. The special value "*" matches
 * all tags.
 * @return NodeList A list of matching Element nodes.
 * @type NodeList
 * @param {String} tagname
 
 * @type Element[]
*/
getElementsByTagName: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a list of elements with the given tag name belonging to the given namespace. The complete document is searched, including the root node.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>elements</i> = document.getElementsByTagNameNS(<i>namespace</i>, <i>name</i>)
* </pre>
* <ul><li> <code>elements</code> is a live <code>NodeList</code> of found elements in the order they appear in the tree.
* </li><li> <code>namespace</code> is the namespace URI of elements to look for (see <code><a href="DOM:element.namespaceURI" shape="rect" title="DOM:element.namespaceURI">element.namespaceURI</a></code>).
* </li><li> <code>name</code> is either the local name of elements to look for or the special value <code>"*"</code>, which matches all elements (see <code><a href="element.localName" shape="rect" title="DOM:element.localName">element.localName</a></code>).
* </li></ul>
* <h2> <span> Example </span></h2>
* <p>In the following example <code>getElementsByTagNameNS</code> starts from a particular parent element, and searches topdown recursively through the DOM from that parent element, looking for child elements matching the tag <code>name</code> parameter.
* </p><p>Note that when the node on which <code>getElementsByTagName</code> is invoked is not the <code>document</code> node, in fact the <a href="DOM:element.getElementsByTagNameNS" shape="rect" title="DOM:element.getElementsByTagNameNS">element.getElementsByTagNameNS</a> method is used.
* </p><p>To use the following example, just copy/paste it into a new file saved with the .xhtml extension.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html xmlns="http://www.w3.org/1999/xhtml"&gt;
* 
* &lt;head&gt;
* &lt;title&gt;getElementsByTagNameNS example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function getAllParaElems()
* {
* var allParas = document.getElementsByTagNameNS("http://www.w3.org/1999/xhtml", "p");
* 
* var num = allParas.length;
* 
* alert("There are " + num + " &amp;lt;p&amp;gt; elements in this document");
* }
* 
* function div1ParaElems()
* {
* var div1 = document.getElementById("div1")
* var div1Paras = div1.getElementsByTagNameNS("http://www.w3.org/1999/xhtml", "p");
* 
* var num = div1Paras.length;
* 
* alert("There are " + num + " &amp;lt;p&amp;gt; elements in div1 element");
* }
* 
* function div2ParaElems()
* {
* var div2 = document.getElementById("div2")
* var div2Paras = div2.getElementsByTagNameNS("http://www.w3.org/1999/xhtml", "p");
* 
* var num = div2Paras.length;
* 
* alert("There are " + num + " &amp;lt;p&amp;gt; elements in div2 element");
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body style="border: solid green 3px"&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* 
* &lt;div id="div1" style="border: solid blue 3px"&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* &lt;p&gt;Some div1 text&lt;/p&gt;
* 
* &lt;div id="div2" style="border: solid red 3px"&gt;
* &lt;p&gt;Some div2 text&lt;/p&gt;
* &lt;p&gt;Some div2 text&lt;/p&gt;
* &lt;/div&gt;
* &lt;/div&gt;
* 
* &lt;p&gt;Some outer text&lt;/p&gt;
* &lt;p&gt;Some outer text&lt;/p&gt;
* 
* &lt;button onclick="getAllParaElems();"&gt;
* show all p elements in document&lt;/button&gt;&lt;br /&gt;
* 
* &lt;button onclick="div1ParaElems();"&gt;
* show all p elements in div1 element&lt;/button&gt;&lt;br /&gt;
* 
* &lt;button onclick="div2ParaElems();"&gt;
* show all p elements in div2 element&lt;/button&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-getElBTNNS" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-getElBTNNS">DOM Level 2 Core: Document.getElementsByTagNameNS</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Returns a NodeList of all the descendant Elements with a given local name and namespace URI in document order .
 * @param {String} namespaceURI of type DOMString The namespace URI of the elements to match on. The special value "*" matches all
 * namespaces.
 * @param {String} localName of type DOMString The local name of the
 * elements to match on. The special value "*" matches all local
 * names.
 * @return NodeList A new NodeList object
 * containing all the matched Elements .
 * @type NodeList
 
 * @type Element[]
*/
getElementsByTagNameNS: function(namespace, name) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the height of the body element of the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>height_value</i> = document.height
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>height_value</code> is the number of pixels.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// alert document height
* alert(document.height);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <code><a href="http://developer.mozilla.org/en/docs/document.width" shape="rect" title="document.width">document.width</a></code>.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
height: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p><code>document.images</code> returns a collection of the images in the current HTML document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>htmlCollection</i> = document.images
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var ilist = document.images;
* for(var i = 0; i &lt; ilist.length; i++) {
* if(ilist[i] == "banner.gif") {
* // found the banner
* }
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>document.images.length</code> ‚Äì property, returns the number of images on the page.
* </p><p><code>document.images</code> is part of DOM HTML, and it only works for HTML documents.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-90379117" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-90379117">DOM Level 2 HTML: HTMLDocument.images</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
images: undefined,
/**
* <h2> <span>Summary </span></h2>
* <p>Returns a <code><a href="http://www.xulplanet.com/references/objref/DOMImplementation.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/DOMImplementation.html">DOMImplementation</a></code> object associated with the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>DOMImpObj</i> = document.DOMImplementation
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* var modName = "HTML";
* var modVer = "2.0";
* var conformTest = document.implementation.hasFeature(modName, modVer);
* 
* alert("DOM " + modName + " " + modVer + " supported?: " + conformTest);
* 
* // alerts with: "DOM HTML 2.0 supported?: true" if DOM Level 2 HTML module is supported.
* </pre>
* <p>A list of module names (e.g., Core, HTML, XML, etc) is available in the DOM Level 2 <a href="http://www.w3.org/TR/DOM-Level-2-Core/introduction.html#ID-Conformance-h2" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/introduction.html#ID-Conformance-h2">Conformance Section</a>
* </p>
* <h2> <span>Notes </span></h2>
* <p>The W3C's DOM Level 1 Recommendation only specified the <code>hasFeature</code> method, which is one way to determine if a DOM module is supported by a browser (see example above and <a href="http://www.w3.org/2003/02/06-dom-support.html" rel="nofollow" shape="rect" title="http://www.w3.org/2003/02/06-dom-support.html">What does your user agent claim to support?</a>).  If available, other <code>DOMImplementation</code> methods provide services for controlling things outside of a single document. For example, the DOMImplementation interface includes a <code>createDocumentType</code> method with which DTDs can be created for one or more documents managed by the implementation.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-102161490" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#ID-102161490">DOM Level 2 Core: implementation</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The DOMImplementation object
 * that handles this document. A DOM application may use objects from
 * multiple implementations.
 * @type DOMImplementation
 */
implementation: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Creates a copy of a node from an external document that can be inserted into the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>node</i> = <i>document</i>.importNode(<i>externalNode</i>, <i>deep</i>);
* </pre>
* <ul><li> <code>node</code> is the new node that is imported into the document. The new node's <code><a href="DOM:element.parentNode" shape="rect" title="DOM:element.parentNode">parentNode</a></code> is <code>null</code>, since it has not yet been inserted into the document tree.
* </li><li> <code>externalNode</code> is the node from another document to be imported.
* </li><li> <code>deep</code> is a boolean, indicating whether the children of the node need to be imported.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var iframe = document.getElementsByTagName("iframe")[0];
* var oldNode = iframe.contentDocument.getElementById("myNode");
* var newNode = document.importNode(oldNode,true);
* document.getElementById("container").appendChild(newNode);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The original node is not removed from the original document. The imported node is a clone of the original.
* </p><p>Nodes from external documents must be cloned using <code><strong>importNode</strong></code> (or adopted using <code><a href="document.adoptNode" shape="rect" title="DOM:document.adoptNode">adoptNode</a></code>) before they can be inserted into the current document. For more on the <code><a href="element.ownerDocument" shape="rect" title="DOM:element.ownerDocument">ownerDocument</a></code> issues see the <a href="http://www.w3.org/DOM/faq.html#ownerdoc" rel="nofollow" shape="rect" title="http://www.w3.org/DOM/faq.html#ownerdoc">W3C DOM FAQ</a>.
* </p><p><a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a> did not enforce the use of <code>importNode</code> and <code>adoptNode</code> until 1.9. <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">Since 1.9 alphas</a>, failing to adopt or import a node before using it in a different document results in the <code>WRONG_DOCUMENT_ERR</code> (<code>NS_ERROR_DOM_WRONG_DOCUMENT_ERR</code>) exception being thrown.
* </p><p>
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#Core-Document-importNode" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#Core-Document-importNode">DOM Level 2 Core: Document.importNode</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Imports a node from another document to this
 * document, without altering or removing the source node from the
 * original document; this method creates a new copy of the source
 * node. The returned node has no parent; ( parentNode is null ). For all nodes, importing a node creates a node object owned by the
 * importing document, with attribute values identical to the source
 * node's nodeName and nodeType , plus the
 * attributes related to namespaces ( prefix , localName , and namespaceURI ). As in the cloneNode operation, the source node is not altered.
 * User data associated to the imported node is not carried over.
 * However, if any UserDataHandlers has
 * been specified along with the associated data these handlers will
 * be called with the appropriate parameters before this method
 * returns. Additional information is copied as appropriate to the nodeType , attempting to mirror the behavior expected
 * if a fragment of XML or HTML source was copied from one document to
 * another, recognizing that the two documents may have different DTDs
 * in the XML case. The following list describes the specifics for
 * each type of node. ATTRIBUTE_NODE The ownerElement attribute is set to null and the specified flag is set to true on the generated Attr . The descendants of the source Attr are recursively
 * imported and the resulting nodes reassembled to form the
 * corresponding subtree. Note that the deep parameter has no effect on Attr nodes; they always
 * carry their children with them when imported. DOCUMENT_FRAGMENT_NODE If the deep option was set to true ,
 * the descendants of the
 * source DocumentFragment are
 * recursively imported and the resulting nodes reassembled under the
 * imported DocumentFragment to form
 * the corresponding subtree. Otherwise, this simply generates an
 * empty DocumentFragment . DOCUMENT_NODE Document nodes cannot be imported. DOCUMENT_TYPE_NODE DocumentType nodes cannot be imported. ELEMENT_NODE Specified attribute nodes of the source element are
 * imported, and the generated Attr nodes are attached
 * to the generated Element . Default
 * attributes are not copied, though if the document being
 * imported into defines default attributes for this element name,
 * those are assigned. If the importNode deep parameter was set to true , the descendants of the source
 * element are recursively imported and the resulting nodes
 * reassembled to form the corresponding subtree. ENTITY_NODE Entity nodes
 * can be imported, however in the current release of the DOM the DocumentType is
 * readonly. Ability to add these imported nodes to a DocumentType will be
 * considered for addition to a future release of the DOM. On import, the publicId , systemId , and notationName attributes are copied. If a deep import is requested, the descendants of the the source Entity are
 * recursively imported and the resulting nodes reassembled to form
 * the corresponding subtree. ENTITY_REFERENCE_NODE Only the EntityReference itself is
 * copied, even if a deep import is requested, since the
 * source and destination documents might have defined the entity
 * differently. If the document being imported into provides a
 * definition for this entity name, its value is assigned. NOTATION_NODE Notation nodes
 * can be imported, however in the current release of the DOM the DocumentType is
 * readonly. Ability to add these imported nodes to a DocumentType will be
 * considered for addition to a future release of the DOM. On import, the publicId and systemId attributes are copied. Note that the deep parameter has no effect on this
 * type of nodes since they cannot have any children. PROCESSING_INSTRUCTION_NODE The imported node copies its target and data values from those of the source node. Note that the deep parameter has no effect on this
 * type of nodes since they cannot have any children. TEXT_NODE, CDATA_SECTION_NODE, COMMENT_NODE These three types of nodes inheriting from CharacterData copy their data and length attributes from those of
 * the source node. Note that the deep parameter has no effect on these
 * types of nodes since they cannot have any children.
 * @param {Node} importedNode of type Node The node to import.
 * @param {Boolean} deep of type boolean If true , recursively import the subtree under the
 * specified node; if false , import only the node itself,
 * as explained above. This has no effect on nodes that cannot have
 * any children, and on Attr , and EntityReference nodes.
 * @return Node The imported node that belongs to this Document .
 * @type Node
 
 * @type Node
*/
importNode: function(externalNode, deep) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a string representing the encoding under which the document was parsed (e.g. <tt>ISO-8859-1</tt>).
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><var>encoding</var> = <code>document.inputEncoding;</code>
* </pre>
* <p><code>inputEncoding</code> is a read-only property.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-3-Core/core.html#Document3-inputEncoding" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Core/core.html#Document3-inputEncoding">DOM Level 3 Core</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * An attribute specifying the encoding used for this entity at
 * the time of parsing, when it is an external parsed entity. This is
 * null if it an entity from the internal subset or if it
 * is not known.
 * @type String
 */
inputEncoding: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span>Summary</span></h2>
* <p>Returns a string containing the date and time on which the current document was last modified.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = document.lastModified
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">dump(document.lastModified);
* // returns: Tuesday, July 10, 2001 10:19:42
* </pre>
* <h2> <span>Notes </span></h2>
* <p>Note that as a string, <code>lastModified</code> cannot easily be used for comparisions between the modified dates of documents.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/lastmodified.asp?frame=true" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/lastmodified.asp?frame=true">MSDN: lastModified property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
lastModified: undefined,
/**
* <h2> <span>Summary</span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p><code>linkColor</code> gets/sets the color of links within the document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>color</i> = document.linkColor
* document.linkColor = <i>color</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>color</code> is a string representing the color as a word (e.g., "red") or hexadecimal value (e.g., "<code>#ff0000</code>").
* </li></ul>
* <h2> <span>Notes </span></h2>
* <p>The default value for this property in Mozilla Firefox is blue (<code>#0000ee</code> in hexadecimal).
* </p><p><code>document.linkColor</code> is <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">deprecated in DOM Level 2 HTML</a>.
* </p><p>Alternatives involve the use of the CSS <code><a href="http://developer.mozilla.org/en/docs/CSS:color" shape="rect" title="CSS:color">color</a></code> property on either <a href="http://developer.mozilla.org/en/docs/HTML:Element:a" shape="rect" title="HTML:Element:a">HTML anchor (&lt;a&gt;) links</a> (e.g., <code>a {color:red;}</code>) or <code><a href="http://www.w3.org/TR/CSS21/selector.html#link-pseudo-classes" rel="nofollow" shape="rect" title="http://www.w3.org/TR/CSS21/selector.html#link-pseudo-classes">:link</a></code> pseudo-class (e.g., <code>:link {color:red;}</code>).
* </p><p>Another alternative is <code>document.body.link</code>, although this is <a href="http://www.w3.org/TR/html401/struct/global.html#adef-link" rel="nofollow" shape="rect" title="http://www.w3.org/TR/html401/struct/global.html#adef-link">deprecated in HTML 4.01</a>.
* </p>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.linkColor = "blue";
* </pre>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/linkcolor.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/linkcolor.asp">MSDN: linkColor Property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
linkColor: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>The <code>links</code> property returns a collection of all AREA elements and anchor elements in a document with a value for the href attribute.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nodeList</i> = document.links
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var links = document.links;
* for(var i = 0; i &lt; links.length; i++) {
* var linkHref = document.createTextNode(links[i].href);
* var lineBreak = document.createElement("br");
* document.body.appendChild(linkHref);
* document.body.appendChild(lineBreak);
* }
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-7068919" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-7068919">DOM Level 2 HTML: links</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
links: undefined,
/**
* <div style="border: 1px solid #818151; background-color: #FFFFE1; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">This article covers features introduced in <a href="http://developer.mozilla.org/en/docs/Firefox_1.5_for_developers" shape="rect" title="Firefox 1.5 for developers">Firefox 1.5</a></p></div>
* 
* <h2> <span> Summary </span></h2>
* <p>Loads a <a href="http://developer.mozilla.org/en/docs/XUL_Overlays" shape="rect" title="XUL Overlays">XUL overlay</a> and merges it with the current document, notifying an observer when the merge is complete.
* </p>
* <h2> <span> Usage </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.loadOverlay(<i>url</i>, <i>observer</i>);
* </pre>
* <dl><dt style="font-weight:bold"> url </dt><dd> A string containing the absolute URL of the overlay to load.
* </dd><dt style="font-weight:bold"> observer </dt><dd> An object implementing <code><a href="http://developer.mozilla.org/en/docs/nsIObserver" shape="rect" title="nsIObserver">nsIObserver</a></code> that will be notified with a message of topic "xul-overlay-merged" when the merge is complete, or <code>null</code> if no observer is needed. The <code>subject</code> parameter of <code>observe</code> will implement <code><a href="http://developer.mozilla.org/en/docs/nsIURI" shape="rect" title="nsIURI">nsIURI</a></code> and will contain the URI of the merged overlay.
* </dd></dl>
* <h2> <span> Notes </span></h2>
* <p>This API is not frozen and may change later.
* </p><p>Subsequent <code>document.loadOverlay</code> calls do not work <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=330458" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=330458">bug 330458</a>. You have to rely on observers to queue subsequent overlay loads.
* </p><p>Loading an overlay with the same URI twice is not currently supported, although it may work sometimes.
* </p>
* <h2> <span> Specification </span></h2>
* <p>XUL-specific method. Not part of any specification. Defined in <a href="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#83" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#83">nsIDOMXULDocument.idl</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
loadOverlay: function(url, observer) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a <code>Location</code> object, which contains information about the URL of the document and provides methods for changing that URL. In Gecko browsers you can also assign to this property to load another URL.
* </p><p>For details, refer to <a href="window.location" shape="rect" title="DOM:window.location">window.location</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Get the location object
* var locationObj = document.location;
* 
* // Set the value of the location object (see <a href="DOM:document.location#Notes" shape="rect" title="">Notes</a> section)
* document.location = 'http://www.mozilla.org';
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">dump(document.location);
* // Prints a string like
* // "http://www.example.com/juicybits.html" to the console
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>Location</code> objects have a <code>toString</code> method returning the current URL. You can also assign a string to <code>document.location</code>. This means that you can work with <code>document.location</code> as if it were a string in most cases. Sometimes, for example when you need to call a <code><a href="http://developer.mozilla.org/en/docs/String" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:String">String</a></code> method on it, you have to explicitly call <code>toString</code>:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">alert(document.location.toString().charAt(17))
* </pre>
* <p><code>document.location</code> was originally a read-only property, although Gecko browsers allow you to assign to it as well. For cross-browser safety, use <code><a href="window.location" shape="rect" title="DOM:window.location">window.location</a></code> instead.
* </p><p>To retrieve just the URL as a string, the read-only <code><a href="document.URL" shape="rect" title="DOM:document.URL">document.URL</a></code> property can be used.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
location: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><code>namespaceURI</code> returns the XML namespace for the current document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>NSURI</i> = document.namespaceURI
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li> <code>NSURI</code> is a string containing the namespace.
* </li></ul>
* <h2> <span>Notes </span></h2>
* <p>The DOM does not handle or enforce namespace validation per se. It is up to the DOM application to do any validation necessary. Note too that the namespace prefix, once it is associated with a particular node, cannot be changed.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Core/core.html#Namespaces-Considerations" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Core/core.html#Namespaces-Considerations">DOM Level 2 Core: namespaceURI</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * <p>(Placeholder)
* </p>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
namespaceURI: undefined,
/**
 * This method acts as if the document was going
 * through a save and load cycle, putting the document in a "normal"
 * form. As a consequence, this method updates the replacement tree of EntityReference nodes and normalizes Text nodes, as defined
 * in the method Node.normalize() . Otherwise, the actual result depends on the features being set on
 * the Document.domConfig object and governing what operations actually take place.
 * Noticeably this method could also make the document namespace well-formed according to the algorithm described in Namespace
 * Normalization , check the character normalization, remove the CDATASection nodes, etc. See DOMConfiguration for
 * details. Mutation events, when supported, are generated to reflect the
 * changes occurring on the document. If errors occur during the invocation of this method, such as an
 * attempt to update a read-only node or a Node.nodeName contains an
 * invalid character according to the XML version in use, errors or
 * warnings ( DOMError.SEVERITY_ERROR or DOMError.SEVERITY_WARNING )
 * will be reported using the DOMErrorHandler object associated with the " error-handler " parameter.
 * Note this method might also report fatal errors ( DOMError.SEVERITY_FATAL_ERROR )
 * if an implementation cannot recover from an error.
 * @type void
 */
normalizeDocument: function() { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
onoffline: undefined,
ononline: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>The <code>document.open()</code> method opens a document for <a href="document.write" shape="rect" title="DOM:document.write">writing</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.open();
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // In this example, the document contents are
* // overwritten as the document
* // is reinitialized on open().
* document.write("&lt;html&gt;&lt;p&gt;remove me&lt;/p&gt;&lt;/html&gt;");
* document.open();
* // document is empty.
* </pre>
* <h2> <span> Notes </span></h2>
* <p>If a document exists in the target, this method clears it (see the example above).
* </p><p>Also, an automatic <code>document.open()</code> call happens when <a href="DOM:document.write" shape="rect" title="DOM:document.write">document.write()</a> is called after the page has loaded, but that's not defined in the W3C specification.
* </p><p>Do not confuse this method with <a href="window.open" shape="rect" title="DOM:window.open">window.open()</a>. <code>document.open</code> allows you overwrite current document or append to it, while <code>window.open</code> provides a way to open a new window, leaving the current document intact. Since <code>window</code> is the global object, just calling <code>open(...)</code> does the same as <code>window.open(...)</code>.
* </p><p>You can close the opened document using <a href="document.close" shape="rect" title="DOM:document.close">document.close()</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">DOM Level 2 HTML: <code>open()</code> Method</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
open: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Returns an <a href="http://www.xulplanet.com/references/objref/HTMLCollection.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/HTMLCollection.html">HTMLCollection</a> object containing one or more <a href="http://www.xulplanet.com/references/objref/HTMLEmbedElement.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/HTMLEmbedElement.html">HTMLEmbedElement</a>s or <code>null</code> which represent the <code>&lt;embed&gt;</code> elements in the current document.
* </p>
* <div>For a list of installed plugins, use <code><a href="window.navigator.plugins" shape="rect" title="DOM:window.navigator.plugins">navigator.plugins</a></code> instead.</div>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>embedArrayObj</i> = document.plugins
* </pre>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/collections/plugins_0.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/collections/plugins_0.asp">MSDN: plugins Collection</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
plugins: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>When a popup attached via the <code>popup</code> or <code>context</code> attributes is opened, the XUL document's popupNode property is set to the node that was clicked on. This will be the target of the mouse event that activated the popup. If the popup was opened via the keyboard, the popup node may be set to null. Typically, this property will be checked during a popupshown handler for a context menu to initialize the menu based on the context.
* </p><p>This property is only set for popups attached via the <code>popup</code> or <code>context</code> attributes. For other types of popups, the value is not changed.
* In these other cases, for example when calling the popup's <code>showPopup</code> method, you may wish to set the <code>popupNode</code> property directly beforehand.
* </p><p>This property applies only to XUL documents.
* </p>
* <h2> <span> Usage </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var node = <i>document</i>.popupNode;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">&lt;menupopup id="toolbarContextMenu"&gt;
* ...
* &lt;menuitem name="Delete" onclick="mailNewsCore.deleteButton(document.popupNode)"&gt;
* ...
* &lt;/menupopup&gt;
* </pre>
* <p>See <a href="http://www.mozilla.org/xpfe/xptoolkit/popups.html" rel="nofollow" shape="rect" title="http://www.mozilla.org/xpfe/xptoolkit/popups.html">http://www.mozilla.org/xpfe/xptoolkit/popups.html</a>
* </p>
* <h2> <span> Specification </span></h2>
* <p>XUL-specific method. Not part of any specification. Defined in <a href="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#48" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#48">nsIDOMXULDocument.idl</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
popupNode: undefined,
queryCommandEnabled: function(commandIdentifier) {
  // This is just a stub for a builtin native JavaScript object.
},
queryCommandIndeterm: function(commandIdentifier) {
  // This is just a stub for a builtin native JavaScript object.
},
queryCommandState: function(commandIdentifier) {
  // This is just a stub for a builtin native JavaScript object.
},
queryCommandValue: function(commandIdentifier) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the <a href="http://www.w3.org/Addressing/#background" rel="nofollow" shape="rect" title="http://www.w3.org/Addressing/#background">URI</a> of the page that linked to this page.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = document.referrer
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The value is an empty string if the user navigated to the page directly (not through a link, but, for example, via a bookmark).  Since this property returns only a string, it does not give you DOM access to the referring page.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-95229140" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-95229140">DOM Level 2: referrer</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
referrer: undefined,
/**
 * Rename an existing node of type ELEMENT_NODE or ATTRIBUTE_NODE . When possible this simply changes the name of the given node,
 * otherwise this creates a new node with the specified name and
 * replaces the existing node with the new node as described
 * below. If simply changing the name of the given node is not possible, the
 * following operations are performed: a new node is created, any
 * registered event listener is registered on the new node, any user
 * data attached to the old node is removed from that node, the old
 * node is removed from its parent if it has one, the children are
 * moved to the new node, if the renamed node is an Element its attributes
 * are moved to the new node, the new node is inserted at the position
 * the old node used to have in its parent's child nodes list if it
 * has one, the user data that was attached to the old node is
 * attached to the new node. When the node being renamed is an Element only the
 * specified attributes are moved, default attributes originated from
 * the DTD are updated according to the new element name. In addition,
 * the implementation may update default attributes from other
 * schemas. Applications should use Document.normalizeDocument() to guarantee these attributes are up-to-date. When the node being renamed is an Attr that is attached to
 * an Element , the
 * node is first removed from the Element attributes map.
 * Then, once renamed, either by modifying the existing node or
 * creating a new one as described above, it is put back. In addition, a user data event NODE_RENAMED is fired, when the implementation supports the feature
 * "MutationNameEvents", each mutation operation involved in this
 * method fires the appropriate event, and in the end the event
 * { http://www.w3.org/2001/xml-events , DOMElementNameChanged } or
 * { http://www.w3.org/2001/xml-events , DOMAttributeNameChanged } is fired.
 * @param {Node} n of type Node The node to rename.
 * @param {String} namespaceURI of type DOMString The new namespace
 * URI .
 * @param {String} qualifiedName of type DOMString The new qualified
 * name .
 * @return Node The renamed node. This is either the specified node or the new
 * node that was created to replace the specified node.
 * @type Node
 */
renameNode: function(n, namespaceURI, qualifiedName) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * An attribute specifying whether error checking is enforced or
 * not. When set to false, the implementation is free to
 * not test every possible error case normally defined on DOM
 * operations, and not raise any DOMException on DOM
 * operations or report errors while using Document.normalizeDocument().
 * In case of error, the behavior is undefined. This attribute is
 * true by default.
 * @type Boolean
 */
strictErrorChecking: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a list of <a href="stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a> objects for stylesheets explicitly linked into or embedded in a document.
* </p>
* <h2> <span> Properties </span></h2>
* <p><code>styleSheetList.length</code> - returns the number of stylesheet objects contained in the object.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>styleSheetList</i> = <i>document</i>.styleSheets
* </pre>
* <p>The returned object is a <a href="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-DocumentStyle-styleSheets" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-DocumentStyle-styleSheets">StyleSheetList</a>.
* </p><p>It is an ordered collection of <a href="stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a> objects. <code><i>styleSheetList</i>.item(<i>index</i>)</code> or simply <code><i>styleSheetList</i>[<i>index</i>]</code> returns a single stylesheet object by its index (<code>index</code> is 0-based).
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-DocumentStyle-styleSheets" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-DocumentStyle-styleSheets">DOM Level 2 Style: styleSheets</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
styleSheets: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Gets or sets the title of the document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>title</i> = <i>document</i>.title;
* </pre>
* <ul><li> <code>title</code> is a string containing the <code>document</code>'s title. If the title was overridden by setting <code>document.title</code>, returns that value. Otherwise returns the title specified in the markup (see the <a href="DOM:document.title#Notes" shape="rect" title="">Notes</a> below).
* </li></ul>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>document</i>.title = <i>newTitle</i>;
* </pre>
* <ul><li> <code>newTitle</code> is the new title of the document. The assignment affects the return value of <code>document.title</code>, the title displayed for the document (e.g. in the titlebar of the window), but does not affect the DOM of the document (e.g. the content of the <code>&lt;title&gt;</code> element in an HTML document).
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;Hello World!&lt;/title&gt;
* &lt;/head&gt;
* &lt;body&gt;
* &lt;script&gt;
* alert(document.title); // displays "Hello World!"
* document.title = "Goodbye World!";
* alert(document.title); // displays "Goodbye World!"
* &lt;/script&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>This property applies to HTML, SVG, XUL, and other documents in Gecko.
* </p><p>For HTML documents the initial value of <code>document.title</code> is the text content of the <code>&lt;title&gt;</code> element. For XUL it's the value of the <a href="http://developer.mozilla.org/en/docs/XUL:Attribute:title" shape="rect" title="XUL:Attribute:title">title</a> attribute of the <a href="http://developer.mozilla.org/en/docs/XUL:window" shape="rect" title="XUL:window">window</a> or other top-level XUL element.
* </p><p>In XUL, accessing <code>document.title</code> before the document is fully loaded has undefined behavior (<code>document.title</code> may return an empty string and setting <code>document.title</code> may have no effect).
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-18446827" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-18446827">DOM Level 2 HTML: document.title</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
title: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the node which is the target of the current <a href="http://developer.mozilla.org/en/docs/XUL:tooltip" shape="rect" title="XUL:tooltip">tooltip</a>.
* </p>
* <h2> <span> Usage </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.tooltipNode;
* </pre>
* <h2> <span> Specification </span></h2>
* <p>XUL-specific method. Not part of any specification. Defined in <a href="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#59" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source/dom/public/idl/xul/nsIDOMXULDocument.idl#59">nsIDOMXULDocument.idl</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
tooltipNode: undefined,
/**
* <h2> <span>Summary</span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p>Gets/sets the color of links that the user has visited in the document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>color</i> = document.vlinkColor
* document.vlinkColor = <i>color</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>color</code> is a string representing the color as a word (e.g., "red") or hexadecimal value (e.g., "<code>#ff0000</code>").
* </li></ul>
* <h2> <span>Notes </span></h2>
* <p>The default value for this property in Mozilla Firefox is purple (<code>#551a8b</code> in hexadecimal).
* </p><p><code>document.vlinkColor</code> is <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-26809268">deprecated in DOM Level 2 HTML</a>.
* </p><p>The recommended alternative is to get/set the color of the CSS <code><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS::visited&amp;action=edit" shape="rect" title="CSS::visited">:visited</a></code> pseudo-class on <a href="http://developer.mozilla.org/en/docs/HTML:Element:a" shape="rect" title="HTML:Element:a"> HTML anchor (&lt;a&gt;) links</a> (e.g., <code>a:visited {color:red;}</code>).
* </p><p>Another alternative is <code>document.body.vLink</code>, although this is <a href="http://www.w3.org/TR/html401/struct/global.html#adef-vlink" rel="nofollow" shape="rect" title="http://www.w3.org/TR/html401/struct/global.html#adef-vlink">deprecated in HTML 4.01</a> in favor of the CSS alternative.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p><a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/vlinkcolor.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/vlinkcolor.asp">MSDN vlinkColor Property</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
vlinkColor: undefined,
/**
* <h2> <span> Summary</span></h2>
* <p>Returns the width of the body element of the current document in pixels.
* </p><p>Not supported by IE.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>pixels</i> = document.width;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function init() {
* alert("The width of the document is " + document.width + " pixels.");
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <code><a href="http://developer.mozilla.org/en/docs/document.height" shape="rect" title="document.height">document.height</a></code>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
width: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Writes a string of text to a document stream opened by <a href="document.open" shape="rect" title="DOM:document.open">document.open()</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.write(<i>markup</i>);
* </pre>
* <ul><li> <code>markup</code> is a string containing the text to be written to the document.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* 
* &lt;head&gt;
* &lt;title&gt;write example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function newContent()
* {
* alert("load new content");
* document.open();
* document.write("&lt;h1&gt;Out with the old - in with the new!&lt;/h1&gt;");
* document.close();
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onload="newContent();"&gt;
* &lt;p&gt;Some original document content.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Writing to a document that has already loaded without calling <a href="DOM:document.open" shape="rect" title="DOM:document.open">document.open()</a> will automatically perform a <code>document.open</code> call. Once you have finished writing, it is recommended to call <a href="document.close" shape="rect" title="DOM:document.close">document.close()</a>, to tell the browser to finish loading the page. The text you write is parsed into the document's structure model. In the example above, the <code>h1</code> element becomes a node in the document.
* </p><p>If the <code>document.write()</code> call is embedded directly in the HTML code, then it will not call <code>document.open()</code>. For example:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;div&gt;
* &lt;script type="text/javascript"&gt;
* document.write("&lt;h1&gt;Main title&lt;/h1&gt;")
* &lt;/script&gt;
* &lt;/div&gt;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75233634" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75233634">DOM Level 2 HTML: <code>write()</code> Method</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
write: function(markup) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Writes a string of text followed by a newline character to a document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.writeln(<i>line</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>line</code> is string containing a line of text.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* document.writeln("&lt;p&gt;enter password:&lt;/p&gt;");
* </pre>
* <h2> <span>Notes </span></h2>
* <p><b>document.writeln</b> is the same as <a href="http://developer.mozilla.org/en/docs/document.write" shape="rect" title="document.write">document.write</a> but adds a newline.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/WD-DOM-Level-2-HTML-20001113/html.html#ID-35318390" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/WD-DOM-Level-2-HTML-20001113/html.html#ID-35318390">writeln </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
writeln: function(line) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * An attribute specifying, as part of the text declaration, the
 * encoding of this entity, when it is an external parsed entity. This
 * is null otherwise.
 * @type String
 */
xmlEncoding: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * An attribute specifying, as part of the XML
 * declaration, whether this document is standalone. This is
 * false when unspecified.
 * Note: No verification is done on the value when setting
 * this attribute. Applications should use Document.normalizeDocument()
 * with the "validate"
 * parameter to verify if the value matches the validity
 * constraint for standalone document declaration as defined
 * in [XML 1.0].
 * Exceptions on setting
 * @type Boolean
 */
xmlStandalone: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * An attribute specifying, as part of the text declaration, the
 * version number of this entity, when it is an external parsed
 * entity. This is null otherwise.
 * @type String
 */
xmlVersion: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
});

