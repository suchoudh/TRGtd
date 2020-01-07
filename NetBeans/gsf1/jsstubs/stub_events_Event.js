/**
* <h2> <span> Introduction </span></h2>
* <p>This chapter describes the DOM Level 2 Event Model as implemented by <a href="http://developer.mozilla.org/en/docs/Gecko" shape="rect" title="Gecko">Gecko</a>. The <a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event">Event</a> interface itself is described, as well as the interfaces for event registration on nodes in the DOM, event handlers and event listeners, and several longer examples that show how the various event interfaces relate to one another.
* </p><p>There is an excellent diagram that clearly explains the three phases of event flow through the DOM in the <a href="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-flow" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-flow">DOM Level 3 Events draft</a>.
* </p>
* <h3> <span> DOM <code>Event</code> interface </span></h3>
* <p>Event handlers may be attached to various elements in the DOM. When an event occurs, an event object is dynamically created, and passed sequentially to the event listeners that are allowed to handle the event. The DOM <code>Event</code> interface is then accessible within the handler function, via the event object passed as the first (and the only) argument.
* </p><p>The following simple example shows how an event object is passed to the event handler function, and can be used from within one such function.
* </p><p>Note there is no "evt" parameter passed in the code below. The event object gets passed automatically to <i>foo</i>. All that is needed is to define a parameter in the event handler to receive the event object.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* function foo(evt) {
* // event handling functions like this one
* // get an implicit reference to the event object they handle
* // (in this case we chose to call it "evt").
* alert(evt);
* }
* table_el.onclick = foo;
* </pre>
* <p>This example is woefully simplistic, but it shows an important feature of events in the Gecko DOM, which is that event objects in the DOM are typically accessed in the event handler functions. Once you have a reference to the event object, you can access all of the properties and methods described in this chapter.
* </p><p>Also see <a href="Gecko_DOM_Reference:Examples#Example_5:_Event_Propagation" shape="rect" title="Gecko DOM Reference:Examples">Example 5: Event Propagation</a> in the Examples chapter for a more detailed example of how events move through the DOM.
* </p>
* <h3> <span> DOM event handler List </span></h3>
* <p>In addition to the <code>event</code> object described here, the Gecko DOM also provides methods for registering event listeners on nodes in the DOM, removing those event listeners, and dispatching events from the DOM. These and the various <a href="DOM:element#Event_Handlers" shape="rect" title="DOM:element">Event Handlers</a> on HTML or XML elements are the main entry points for events in the DOM. These three methods are described in the <a href="element" shape="rect" title="DOM:element">DOM Element Reference</a> list.
* </p><p>You can also pass the event object reference as a predefined parameter, named <code>event</code>, to the function that handles the event. This is very similar to the way <code>this</code> works, but for event objects, rather than element object references.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;event object parameter example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* alert(
* "clientX value: " + evt.clientX + "\n" +
* "clientY value: " + evt.clientY + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* &lt;p&gt;To display the mouse coordinates click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>Using the predefined <code>event</code> object parameter allows you to pass other parameters to the event handling function as well, if required:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;event object &amp; extra parameters example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* var par2 = 'hello';
* var par3 = 'world!';
* 
* function showCoords(evt, p2, p3){
* alert(
* "clientX value: " + evt.clientX + "\n"
* + "clientY value: " + evt.clientY + "\n"
* + "p2: " + p2 + "\n"
* + "p3: " + p3 + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event, par2, par3)"&gt;
* &lt;p&gt;To display the mouse coordinates please click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:event.altKey" shape="rect" title="DOM:event.altKey">event.altKey</a> </dt><dd> Returns a boolean indicating whether the <code>&lt;alt&gt;</code> key was pressed during the event.
* </dd><dt style="font-weight:bold"> <a href="event.bubbles" shape="rect" title="DOM:event.bubbles">event.bubbles</a> </dt><dd> Returns a boolean indicating whether the event bubbles up through the DOM or not.
* </dd><dt style="font-weight:bold"> <a href="event.button" shape="rect" title="DOM:event.button">event.button</a> </dt><dd> Returns a mouse key.
* </dd><dt style="font-weight:bold"> <a href="event.cancelBubble" shape="rect" title="DOM:event.cancelBubble">event.cancelBubble</a> </dt><dd> <span style="border: 1px solid #9898F0; background-color: #DDDDFF; font-size: 9px; vertical-align: text-top;">Deprecated</span> Returns a boolean indicating whether the bubbling up of the event has been canceled or not.
* </dd><dt style="font-weight:bold"> <a href="event.cancelable" shape="rect" title="DOM:event.cancelable">event.cancelable</a> </dt><dd> Returns a boolean indicating whether the event is cancelable.
* </dd><dt style="font-weight:bold"> <a href="event.charCode" shape="rect" title="DOM:event.charCode">event.charCode</a> </dt><dd> Returns the Unicode value of a character key that was pressed as part of a <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keypress&amp;action=edit" shape="rect" title="DOM:event:keypress">keypress</a> event.
* </dd><dt style="font-weight:bold"> <a href="event.clientX" shape="rect" title="DOM:event.clientX">event.clientX</a> </dt><dd> Returns the horizontal position of the event.
* </dd><dt style="font-weight:bold"> <a href="event.clientY" shape="rect" title="DOM:event.clientY">event.clientY</a> </dt><dd> Returns the vertical position of the event.
* </dd><dt style="font-weight:bold"> <a href="event.ctrlKey" shape="rect" title="DOM:event.ctrlKey">event.ctrlKey</a> </dt><dd> Returns a boolean indicating whether the <code>&lt;ctrl&gt;</code> key was pressed during the event.
* </dd><dt style="font-weight:bold"> <a href="event.currentTarget" shape="rect" title="DOM:event.currentTarget">event.currentTarget</a> </dt><dd> Returns a reference to the currently registered target for the event.
* </dd><dt style="font-weight:bold"> <a href="event.detail" shape="rect" title="DOM:event.detail">event.detail</a> </dt><dd> Returns detail about the event, depending on the type of event.
* </dd><dt style="font-weight:bold"> <a href="event.eventPhase" shape="rect" title="DOM:event.eventPhase">event.eventPhase</a> </dt><dd> Used to indicate which phase of the event flow is currently being evaluated.
* </dd><dt style="font-weight:bold"> <a href="event.explicitOriginalTarget" shape="rect" title="DOM:event.explicitOriginalTarget">event.explicitOriginalTarget</a> </dt><dd> The explicit original target of the event (Mozilla-specific).
* </dd><dt style="font-weight:bold"> <a href="event.isChar" shape="rect" title="DOM:event.isChar">event.isChar</a> </dt><dd> Returns a boolean indicating whether the event produced a key character or not.
* </dd><dt style="font-weight:bold"> <a href="event.keyCode" shape="rect" title="DOM:event.keyCode">event.keyCode</a> </dt><dd> Returns the Unicode value of a non-character key in a <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keypress&amp;action=edit" shape="rect" title="DOM:event:keypress">keypress</a> event or any key in any other type of keyboard event.
* </dd><dt style="font-weight:bold"> <a href="event.layerX" shape="rect" title="DOM:event.layerX">event.layerX</a> </dt><dd> Returns the horizontal coordinate of the event relative to the current layer.
* </dd><dt style="font-weight:bold"> <a href="event.layerY" shape="rect" title="DOM:event.layerY">event.layerY</a> </dt><dd> Returns the vertical coordinate of the event relative to the current layer.
* </dd><dt style="font-weight:bold"> <a href="event.metaKey" shape="rect" title="DOM:event.metaKey">event.metaKey</a> </dt><dd> Returns a boolean indicating whether the <code>meta</code> key was pressed during the event.
* </dd><dt style="font-weight:bold"> <a href="event.originalTarget" shape="rect" title="DOM:event.originalTarget">event.originalTarget</a> </dt><dd> The original target of the event, before any retargetings (Mozilla-specific).
* </dd><dt style="font-weight:bold"> <a href="event.pageX" shape="rect" title="DOM:event.pageX">event.pageX</a> </dt><dd> Returns the horizontal coordinate of the event relative to the page.
* </dd><dt style="font-weight:bold"> <a href="event.pageY" shape="rect" title="DOM:event.pageY">event.pageY</a> </dt><dd> Returns the vertical coorindate of the event relative to the page.
* </dd><dt style="font-weight:bold"> <a href="event.relatedTarget" shape="rect" title="DOM:event.relatedTarget">event.relatedTarget</a> </dt><dd> Identifies a secondary target for the event.
* </dd><dt style="font-weight:bold"> <a href="event.screenX" shape="rect" title="DOM:event.screenX">event.screenX</a> </dt><dd> Returns the horizontal position of the event on the screen.
* </dd><dt style="font-weight:bold"> <a href="event.screenY" shape="rect" title="DOM:event.screenY">event.screenY</a> </dt><dd> Returns the vertical position of the event on the screen.
* </dd><dt style="font-weight:bold"> <a href="event.shiftKey" shape="rect" title="DOM:event.shiftKey">event.shiftKey</a> </dt><dd> Returns a boolean indicating whether the <code>&lt;shift&gt;</code> key was pressed when the event was fired.
* </dd><dt style="font-weight:bold"> <a href="event.target" shape="rect" title="DOM:event.target">event.target</a> </dt><dd> Returns a reference to the target to which the event was originally dispatched.
* </dd><dt style="font-weight:bold"> <a href="event.timeStamp" shape="rect" title="DOM:event.timeStamp">event.timeStamp</a> </dt><dd> Returns the time that the event was created.
* </dd><dt style="font-weight:bold"> <a href="event.type" shape="rect" title="DOM:event.type">event.type</a> </dt><dd> Returns the name of the event (case-insensitive).
* </dd><dt style="font-weight:bold"> <a href="event.view" shape="rect" title="DOM:event.view">event.view</a> </dt><dd> The view attribute identifies the <code>AbstractView</code> from which the event was generated.
* </dd><dt style="font-weight:bold"> <a href="event.which" shape="rect" title="DOM:event.which">event.which</a> </dt><dd> Returns the Unicode value of a key in a keyboard event, regardless of which type of key is pressed.
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:event.initEvent" shape="rect" title="DOM:event.initEvent">event.initEvent</a> </dt><dd> Initializes the value of an Event created through the <code>DocumentEvent</code> interface.
* </dd><dt style="font-weight:bold"> <a href="event.initKeyEvent" shape="rect" title="DOM:event.initKeyEvent">event.initKeyEvent</a> </dt><dd> Initializes a keyboard event. Gecko-specific.
* </dd><dt style="font-weight:bold"> <a href="event.initMouseEvent" shape="rect" title="DOM:event.initMouseEvent">event.initMouseEvent</a> </dt><dd> Initializes a mouse event once it's been created
* </dd><dt style="font-weight:bold"> <a href="event.initUIEvent" shape="rect" title="DOM:event.initUIEvent">event.initUIEvent</a> </dt><dd> Initializes a UI event once it's been created.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=event.preventBubble&amp;action=edit" shape="rect" title="DOM:event.preventBubble">event.preventBubble</a> </dt><dd> <span style="border: 1px solid #FF9999; background-color: #FFDBDB; font-size: 9px; vertical-align: text-top;">Obsolete</span> Prevents the event from bubbling. This method is deprecated in favor of standard <a href="event.stopPropagation" shape="rect" title="DOM:event.stopPropagation">stopPropagation</a> and is <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">removed in Gecko 1.9</a>.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=event.preventCapture&amp;action=edit" shape="rect" title="DOM:event.preventCapture">event.preventCapture</a> </dt><dd> <span style="border: 1px solid #FF9999; background-color: #FFDBDB; font-size: 9px; vertical-align: text-top;">Obsolete</span> This method is deprecated in favor of standard <a href="event.stopPropagation" shape="rect" title="DOM:event.stopPropagation">stopPropagation</a> and is <a href="http://developer.mozilla.org/en/docs/Gecko_1.9_Changes_affecting_websites" shape="rect" title="Gecko 1.9 Changes affecting websites">removed in Gecko 1.9</a>.
* </dd><dt style="font-weight:bold"> <a href="event.preventDefault" shape="rect" title="DOM:event.preventDefault">event.preventDefault</a> </dt><dd> Cancels the event (if it is cancelable).
* </dd><dt style="font-weight:bold"> <a href="event.stopPropagation" shape="rect" title="DOM:event.stopPropagation">event.stopPropagation</a> </dt><dd> Stops the propagation of events further along in the DOM.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Event = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The event is currently being evaluated at the target EventTarget.
 * @type Number
 */
AT_TARGET: undefined,
/**
 * The current event phase is the bubbling phase.
 * @type Number
 */
BUBBLING_PHASE: undefined,
/**
 * The current event phase is the capturing phase.
 * @type Number
 */
CAPTURING_PHASE: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Indicates whether the ALT key was pressed when the event fired.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = event.altKey
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending on whether the alt key was held down or not, when the event fired.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;altKey example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showChar(e){
* alert(
* "Key Pressed: " + String.fromCharCode(e.charCode) + "\n"
* + "charCode: " + e.charCode + "\n"
* + "ALT key pressed: " + e.altKey + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeypress="showChar(event);"&gt;
* &lt;p&gt;
* Press any character key,
* with or without holding down the ALT key.&lt;br /&gt;
* You can also use the SHIFT key together with the ALT key.
* &lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
altKey: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Indicates whether the given event bubbles up through the DOM or not.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = event.bubbles
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending on whether the event can bubble or not.
* </p>
* <h2> <span> Notes </span></h2>
* <p>Only certain events can bubble. Events that do bubble have this property set to true. You can use this property to check if an event is allowed to bubble or not.
* </p>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* function goInput(e) {
* // checks bubbles and
* if not e.bubbles {
* // passes event along if it's not
* passItOn(e);
* }
* // already bubbling
* doOutput(e)
* }
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to indicate whether or not an event is a bubbling event.
 * If the event can bubble the value is true, else the value is
 * false.
 * @type Boolean
 */
bubbles: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Indicates which mouse button caused the event.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* var buttonCode = event.button;
* </pre>
* <p>Returns an integer value indicating the button that changed state.
* </p>
* <ul><li> 0 for standard 'click', usually left button
* </li><li> 1 for middle button, usually wheel-click
* </li><li> 2 for right button, usually right-click
* </li></ul>
* <p>The order of buttons may be different depending on how the pointing device has been configured.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;script type="text/javascript"&gt;
* 
* function whichButton(e)
* {
* // Handle different event models
* var e = e || window.event;
* var btnCode;
* 
* if ('object' == typeof e){
* btnCode = e.button;
* 
* switch (btnCode){
* case 0  : alert('Left button clicked');
* break;
* case 1  : alert('Middle button clicked');
* break;
* case 2  : alert('Right button clicked');
* break;
* default : alert('Unexpected code: ' + btnCode);
* }
* }
* }
* 
* &lt;/script&gt;
* 
* &lt;p onclick="whichButton(event);"&gt;Click with mouse...&lt;/p&gt;
* 
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Because mouse clicks are frequently intercepted by the user interface, it may be difficult to detect buttons other than those for a standard mouse click (usually the left button) in some circumstances.
* </p><p>Users may change the configuration of buttons on their pointing device so that if an event's button property is zero, it may not have been caused by the button that is physically left–most on the pointing device; however, it should behave as if the left button was clicked in the standard button layout.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM 2 Events Specification: <a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-button" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-button">button</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
button: undefined,
/**
* <h2> <span> Summary </span></h2>
* <div style="border: 1px solid #5151FF; background-color: #B9B9FF; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">Deprecated</p></div>
* <p>Indicates if event bubbling for this event has been canceled or not.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">event.cancelBubble = <i>bool</i>
* <i>bool</i> = event.cancelBubble
* </pre>
* <p><code>bool</code> is the boolean value of <code>true</code> or <code>false</code>.
* </p>
* <h2> <span> Notes </span></h2>
* <p><code>cancelBubble</code> is set to <code>false</code> by default. This allows the event to bubble up the DOM, if it is a bubbleable event. Setting this property to <code>true</code> stops the event from bubbling up the DOM. Not all events are allowed to bubble up the DOM.
* </p><p>Use <a href="event.stopPropagation" shape="rect" title="DOM:event.stopPropagation">event.stopPropagation()</a> instead of this non-standard method.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cancelBubble: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Indicates whether the event is cancelable or not.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = <i>event</i>.cancelable;
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending
* on whether the event can have its default action prevented.
* </p>
* <h2> <span> Notes </span></h2>
* <p>Whether an event can be canceled or not is something that's determined when that event is initialized.
* </p><p>To cancel an event, call the <a href="event.preventDefault" shape="rect" title="DOM:event.preventDefault">preventDefault</a> method on the event. This keeps the implementation from executing the default action that is associated with the event.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-canCancel" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-canCancel">DOM Level 2 Events: cancelable</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to indicate whether or not an event can have its default
 * action prevented. If the default action can be prevented the value
 * is true, else the value is false.
 * @type Boolean
 */
cancelable: undefined,
/**
* <h2> <span> Summary</span></h2>
* <p>Returns the Unicode value of a character key pressed during a <a href="http://developer.mozilla.org/en/docs/index.php?title=element:keypress&amp;action=edit" shape="rect" title="DOM:element:keypress">keypress</a> event.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>value</i> = event.charCode
* </pre>
* <ul><li> <code>value</code> is the Unicode value of the character key that was pressed.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;charCode example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showChar(e)
* {
* alert("Key Pressed: " + String.fromCharCode(e.charCode) + "\n"
* + "charCode: " + e.charCode);
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeypress="showChar(event);"&gt;
* &lt;p&gt;Press any 'character' type key.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>In a <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:event:keypress&amp;action=edit" shape="rect" title="DOM:event:keypress">keypress</a> event, the Unicode value of the key pressed is stored in either the <code><a href="event.keyCode" shape="rect" title="DOM:event.keyCode">keyCode</a></code> or <code>charCode</code> property, never both. If the key pressed generates a character (e.g. 'a'), <code>charCode</code> is set to the code of that character, respecting the letter case. (i.e. <code>charCode</code> takes into account whether the shift key is held down). Otherwise, the code of the pressed key is stored in <code>keyCode</code>.
* </p><p><code>charCode</code> is never set in the <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keydown&amp;action=edit" shape="rect" title="DOM:event:keydown">keydown</a> and <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keyup&amp;action=edit" shape="rect" title="DOM:event:keyup">keyup</a> events. In these cases, <code>keyCode</code> is set instead.
* </p><p>To get the code of the key regardless of whether it was stored in <code>keyCode</code> or <code>charCode</code>, query the <a href="event.which" shape="rect" title="DOM:event.which">which</a> property.
* </p><p>Characters entered through an IME do not register through <code>keyCode</code> or <code>charCode</code>.
* </p><p>For a list of the <code>charCode</code> values associated with particular keys, run the example in <a href="Gecko_DOM_Reference:Examples#Example_7:_Displaying_Event_Object_Constants" shape="rect" title="Gecko DOM Reference:Examples">Gecko DOM Reference:Examples #Example 7: Displaying Event Object Constants</a> and view the resulting HTML table.
* </p>
* <h2> <span>Specification </span></h2>
* <p>Not part of specification. See <a href="http://developer.mozilla.org/en/docs/index.php?title=nsIDOMKeyEvent&amp;action=edit" shape="rect" title="nsIDOMKeyEvent">nsIDOMKeyEvent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
charCode: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the horizontal coordinate within the application's client area at which the event occurred (as opposed to the coordinates within the page). For example, clicking in the top-left corner of the client area will always result in a mouse event with a <code>clientX</code> value of 0, regardless of whether the page is scrolled horizontally.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>x</i> = <i>event</i>.clientX;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;clientX\clientY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* function showCoords(evt){
* alert(
* "clientX value: " + evt.clientX + "\n"
* + "clientY value: " + evt.clientY + "\n"
* );
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* &lt;p&gt;To display the mouse coordinates click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <a href="DOM:event.clientY" shape="rect" title="DOM:event.clientY">clientY</a>, <a href="event.screenX" shape="rect" title="DOM:event.screenX">screenX</a>, and <a href="event.screenY" shape="rect" title="DOM:event.screenY">screenY</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-clientX" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-clientX">DOM Level 2 Events: MouseEvent.clientX</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
clientX: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the vertical coordinate within the application's client area at which the event occurred (as opposed to the coordinates within the page). For example, clicking in the top-left corner of the client area will always result in a mouse event with a <code>clientY</code> value of 0, regardless of whether the page is scrolled vertically.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>y</i> = <i>event</i>.clientY
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;clientX\clientY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* function showCoords(evt){
* alert(
* "clientX value: " + evt.clientX + "\n"
* + "clientY value: " + evt.clientY + "\n"
* );
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* &lt;p&gt;To display the mouse coordinates click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>See also <a href="DOM:event.clientX" shape="rect" title="DOM:event.clientX">clientX</a>, <a href="event.screenX" shape="rect" title="DOM:event.screenX">screenX</a>, and <a href="event.screenY" shape="rect" title="DOM:event.screenY">screenY</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-clientY" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-clientY">DOM Level 2 Events: MouseEvent.clientY</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
clientY: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Indicates whether the CTRL key was pressed when the event fired.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = event.ctrlKey
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending on whether the ctrl key was held down or not, when the event fired.
* </p>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;ctrlKey example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showChar(e){
* alert(
* "Key Pressed: " + String.fromCharCode(e.charCode) + "\n"
* + "charCode: " + e.charCode + "\n"
* + "CTRL key pressed: " + e.ctrlKey + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeypress="showChar(event);"&gt;
* &lt;p&gt;Press any character key, with or without holding down the CTRL key.&lt;br /&gt;
* You can also use the SHIFT key together with the CTRL key.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-ctrlKey" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-ctrlKey">ctrlKey </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
ctrlKey: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Identifies the current target for the event, as the event traverses the DOM.
* </p><p>See also <a href="event:Comparison_of_Event_Targets" shape="rect" title="DOM:event:Comparison of Event Targets">Comparison of Event Targets</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>target</i> = <i>event</i>.currentTarget;
* </pre>
* <ul><li> <code>target</code> is a reference to the <code><a href="DOM:EventTarget" shape="rect" title="DOM:EventTarget">EventTarget</a></code> whose event listeners are currently being processed.
* </li></ul>
* <h2> <span> Example </span></h2>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-currentTarget" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-currentTarget">DOM Level 2 Events: Event.currentTarget</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsExample" shape="rect" title="Category:NeedsExample">NeedsExample</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to indicate the EventTarget
 * whose EventListeners
 * are currently being processed. This is particularly useful during
 * capturing and bubbling.
 * @type EventTarget
 */
currentTarget: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns additional numerical information about the event, depending on the type of event. For mouse events the value indicates the number of subsequent clicks.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>number</i> = event.detail;
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;event.detail example&lt;/title&gt;
* &lt;script type="text/javascript"&gt;
* function giveDetails(e) {
* var text = document.getElementById("t");
* text.value = e.detail;
* }
* function init() {
* var b1 = document.getElementById("b");
* b1.onclick = giveDetails;
* }
* &lt;/script&gt;
* &lt;/head&gt;
* &lt;body onload="init();"&gt;
* &lt;form&gt;
* &lt;input id="b" type="button" value="details"&gt;
* &lt;input id="t" type="text" value=""&gt;&lt;br&gt;
* &lt;input type="reset"&gt;
* &lt;/form&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>For mouse events, such as <code>click</code>, <code>dblclick</code>, <code>mousedown</code>, or <code>mouseup</code>, the <code>detail</code> property indicates how many times the mouse has been clicked in the same location for this event.
* </p><p>For a <code>dblclick</code> event the value of <code>detail</code> is always 2.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-UIEvent-detail" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-UIEvent-detail">DOM Level 2 Events: UIEvent.detail</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
detail: undefined,
/**
* <h2> <span> Summary</span></h2>
* <p>Indicates which phase of the event flow is currently being evaluated.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>phase</i> = event.eventPhase
* </pre>
* <p>
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-eventPhase" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-eventPhase">eventPhase </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to indicate which phase of event flow is currently being
 * evaluated.
 * @type Number
 */
eventPhase: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>The explicit original target of the event. (Mozilla-specific)
* </p><p>If the event was <a href="http://developer.mozilla.org/en/docs/index.php?title=event_retargeting&amp;action=edit" shape="rect" title="DOM:event retargeting">retargeted</a> for some reason other than an <a href="http://developer.mozilla.org/en/docs/index.php?title=anonymous_boundary_crossing&amp;action=edit" shape="rect" title="DOM:anonymous boundary crossing">anonymous boundary crossing</a>, this will be set to the target before the retargeting occurs.  For example, mouse events are retargeted to their parent node when they happen over text nodes (see <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=185889" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=185889">bug 185889</a>), and in that case <code><a href="event.currentTarget" shape="rect" title="DOM:event.currentTarget">currentTarget</a></code> will show the parent and <code>explicitOriginalTarget</code> will show the text node.
* </p><p><code>explicitOriginalTarget</code> differs from <code><a href="event.originalTarget" shape="rect" title="DOM:event.originalTarget">originalTarget</a></code> in that it will never contain <a href="http://developer.mozilla.org/en/docs/index.php?title=anonymous_content&amp;action=edit" shape="rect" title="DOM:anonymous content">anonymous content</a>.
* </p><p>See also <a href="event:Comparison_of_Event_Targets" shape="rect" title="DOM:event:Comparison of Event Targets">Comparison of Event Targets</a>
* </p>
* <h2> <span> Example </span></h2>
* <p><i>Need an example that makes sense here</i>
* </p>
* <h2> <span> Specification </span></h2>
* <p>This is a Mozilla-specific property. Defined in <a href="http://mxr.mozilla.org/mozilla/source//dom/public/idl/events/nsIDOMNSEvent.idl" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source//dom/public/idl/events/nsIDOMNSEvent.idl"><code>/dom/public/idl/events/nsIDOMNSEvent.idl</code></a>
* </p><p>This event property is <b>not defined</b> in the <a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html">W3.org DOM Level 2 Events</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsExample" shape="rect" title="Category:NeedsExample">NeedsExample</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
explicitOriginalTarget: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>The <code>initEvent</code> method is used to initialize the value of an <a href="event" shape="rect" title="DOM:event">event</a> created using <a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i>.initEvent(<i>type</i>, <i>bubbles</i>, <i>cancelable</i>)
* </pre>
* <dl><dt style="font-weight:bold"><code>type</code> </dt><dd> The type of event.
* </dd><dt style="font-weight:bold"><code>bubbles</code> </dt><dd> A boolean indicating whether the event should bubble up through the event chain or not (see <a href="DOM:event.bubbles" shape="rect" title="DOM:event.bubbles">bubbles</a>).
* </dd><dt style="font-weight:bold"><code>cancelable</code> </dt><dd> A boolean indicating whether the event can be canceled (see <a href="event.cancelable" shape="rect" title="DOM:event.cancelable">cancelable</a>).
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// create a click event that bubbles up and
* // cannot be canceled
* event.initEvent("click", true, false);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Events initialized in this way must have been created with the <a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a> method. <code>initEvent</code> must be called to set the event before it is <a href="element.dispatchEvent" shape="rect" title="DOM:element.dispatchEvent">dispatched</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initEvent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initEvent">DOM Level 2 Events: Event.initEvent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The initEvent method is used to
 * initialize the value of an Event created through the DocumentEvent interface. This method may only be called before the Event has been dispatched via the dispatchEvent method, though it may be called multiple
 * times during that phase if necessary. If called multiple times the
 * final invocation takes precedence. If called from a subclass of Event interface only the values specified in the initEvent method are modified, all other attributes
 * are left unchanged.
 * @param {String} eventTypeArg of type DOMString Specifies the event type. This type may be any event type
 * currently defined in this specification or a new event type.. The
 * string must be an XML
 * name . Any new event type must not begin with any upper, lower, or mixed
 * case version of the string "DOM". This prefix is reserved for
 * future DOM event sets. It is also strongly recommended that third
 * parties adding their own events use their own prefix to avoid
 * confusion and lessen the probability of conflicts with other new
 * events.
 * @param {Boolean} canBubbleArg of type boolean Specifies whether or not the event can bubble.
 * @param {Boolean} cancelableArg of type boolean Specifies whether or not the event's default action can be
 * prevented.
 * @type void
 
 * @type void
*/
initEvent: function(type, bubbles, cancelable) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>The <code>initKeyEvent</code> method is used to initialize the value of an <a href="event" shape="rect" title="DOM:event">event</a> created using <code><a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a>("KeyboardEvent")</code>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i>.initKeyEvent (type, bubbles, cancelable, viewArg,
* ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg,
* keyCodeArg, charCodeArg)
* </pre>
* <dl><dt style="font-weight:bold"><code>type</code> </dt><dd> The type of event.
* </dd><dt style="font-weight:bold"><code>bubbles</code> </dt><dd> A boolean indicating whether the event should bubble up through the event chain or not (see <a href="DOM:event.bubbles" shape="rect" title="DOM:event.bubbles">bubbles</a>).
* </dd><dt style="font-weight:bold"><code>cancelable</code> </dt><dd> A boolean indicating whether the event can be canceled (see <a href="event.cancelable" shape="rect" title="DOM:event.cancelable">cancelable</a>).
* </dd><dt style="font-weight:bold"><code>viewArg</code> </dt><dd>  Specifies UIEvent.view. This value may be <code>null</code>.
* </dd><dt style="font-weight:bold"><code>ctrlKeyArg</code> </dt><dd> bool True if the Virtual Key to be generated is a combination of the Ctrl key and other keys
* </dd><dt style="font-weight:bold"><code>altKeyArg</code> </dt><dd> bool  True if the Virtual Key to be generated is a combination of the Alt key and other keys
* </dd><dt style="font-weight:bold"><code>shiftKeyArg</code> </dt><dd> bool True if the Virtual Key to be generated is a combination of the Shift key and other keys
* </dd><dt style="font-weight:bold"><code>metaKeyArg</code> </dt><dd> bool  True if the Virtual Key to be generated is a combination of the Meta key and other keys
* </dd><dt style="font-weight:bold"><code>keyCodeArg</code> </dt><dd> unsigned long  the virtual key code value of the key which was depressed, otherwise zero
* </dd><dt style="font-weight:bold"><code>charCodeArg</code></dt><dd> unsigned long  the Unicode character associated with the depressed key otherwise zero
* </dd></dl>
* <p>See <a href="http://mxr.mozilla.org/mozilla/source/dom/public/idl/events/nsIDOMKeyEvent.idl" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source/dom/public/idl/events/nsIDOMKeyEvent.idl"><code>dom/public/idl/events/nsIDOMKeyEvent.idl</code></a> for the list of key codes.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// create a key event
* event.initKeyEvent(
* "keypress",        //  in DOMString typeArg,
* true,             //  in boolean canBubbleArg,
* true,             //  in boolean cancelableArg,
* null,             //  in nsIDOMAbstractView viewArg,  Specifies UIEvent.view. This value may be null.
* false,            //  in boolean ctrlKeyArg,
* false,            //  in boolean altKeyArg,
* false,            //  in boolean shiftKeyArg,
* false,            //  in boolean metaKeyArg,
* 9,               //  in unsigned long keyCodeArg,
* 0);              //  in unsigned long charCodeArg);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Events initialized in this way must have been created with the <code><a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a>("KeyboardEvent")</code> method. <code>initKeyEvent</code> must be called to set the event before it is <a href="element.dispatchEvent" shape="rect" title="DOM:element.dispatchEvent">dispatched</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>This implementation of keyboard events is based on the key events spec in the <a href="http://www.w3.org/TR/1999/WD-DOM-Level-2-19990923/events.html" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1999/WD-DOM-Level-2-19990923/events.html">early versions of DOM 2 Events</a>, later removed from that spec.
* </p><p>The <code>initKeyEvent</code> is the current Gecko equivalent of the DOM Level 3 Events draft <code>initKeyboardEvent</code> method with the following arguments :
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">typeArg of type DOMString
* canBubbleArg of type boolean
* cancelableArg of type boolean
* viewArg of type views::AbstractView
* keyIdentifierArg of type DOMString
* keyLocationArg of type unsigned long
* modifiersList of type DOMString);
* </pre>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
initKeyEvent: function(type, bubbles, cancelable, viewArg, ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, keyCodeArg, charCodeArg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Intializes the value of a mouse event once it's been created (normally using <a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a> method).
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i>.initMouseEvent(<i>type</i>, <i>canBubble</i>, <i>cancelable</i>, <i>view</i>,
* <i>detail</i>, <i>screenX</i>, <i>screenY</i>, <i>clientX</i>, <i>clientY</i>,
* <i>ctrlKey</i>, <i>altKey</i>, <i>shiftKey</i>, <i>metaKey</i>,
* <i>button</i>, <i>relatedTarget</i>);
* </pre>
* <dl><dt style="font-weight:bold"> <code>type</code> </dt><dd> the string to set the event's <a href="DOM:event.type" shape="rect" title="DOM:event.type">type</a> to. Possible types for mouse events include: <code>click</code>, <code>mousedown</code>, <code>mouseup</code>, <code>mouseover</code>, <code>mousemove</code>, <code>mouseout</code>.
* </dd><dt style="font-weight:bold"> <code>canBubble</code> </dt><dd> whether or not the event can bubble. Sets the value of <a href="event.bubbles" shape="rect" title="DOM:event.bubbles">event.bubbles</a>.
* </dd><dt style="font-weight:bold"> <code>cancelable</code> </dt><dd> whether or not the event's default action can be prevented.  Sets the value of <a href="event.cancelable" shape="rect" title="DOM:event.cancelable">event.cancelable</a>.
* </dd><dt style="font-weight:bold"> <code>view</code> </dt><dd> the Event's AbstractView. You should pass the <a href="window" shape="rect" title="DOM:window">window</a> object here. Sets the value of <a href="event.view" shape="rect" title="DOM:event.view">event.view</a>.
* </dd><dt style="font-weight:bold"> <code>detail</code> </dt><dd> the Event's mouse click count. Sets the value of <a href="event.detail" shape="rect" title="DOM:event.detail">event.detail</a>.
* </dd><dt style="font-weight:bold"> <code>screenX</code> </dt><dd> the Event's screen x coordinate. Sets the value of <a href="event.screenX" shape="rect" title="DOM:event.screenX">event.screenX</a>.
* </dd><dt style="font-weight:bold"> <code>screenY</code> </dt><dd> the Event's screen y coordinate. Sets the value of <a href="event.screenY" shape="rect" title="DOM:event.screenY">event.screenY</a>.
* </dd><dt style="font-weight:bold"> <code>clientX</code> </dt><dd> the Event's client x coordinate. Sets the value of <a href="event.clientX" shape="rect" title="DOM:event.clientX">event.clientX</a>.
* </dd><dt style="font-weight:bold"> <code>clientY</code> </dt><dd> the Event's client y coordinate. Sets the value of <a href="event.clientY" shape="rect" title="DOM:event.clientY">event.clientY</a>.
* </dd><dt style="font-weight:bold"> <code>ctrlKey</code> </dt><dd> whether or not control key was depressed during the Event. Sets the value of <a href="event.ctrlKey" shape="rect" title="DOM:event.ctrlKey">event.ctrlKey</a>.
* </dd><dt style="font-weight:bold"> <code>altKey</code> </dt><dd> whether or not alt key was depressed during the Event. Sets the value of <a href="event.altKey" shape="rect" title="DOM:event.altKey">event.altKey</a>.
* </dd><dt style="font-weight:bold"> <code>shiftKey</code> </dt><dd> whether or not shift key was depressed during the Event. Sets the value of <a href="event.shiftKey" shape="rect" title="DOM:event.shiftKey">event.shiftKey</a>.
* </dd><dt style="font-weight:bold"> <code>metaKey</code> </dt><dd> whether or not meta key was depressed during the Event. Sets the value of <a href="event.metaKey" shape="rect" title="DOM:event.metaKey">event.metaKey</a>.
* </dd><dt style="font-weight:bold"> <code>button</code> </dt><dd> the Event's mouse <a href="event.button" shape="rect" title="DOM:event.button">event.button</a>.
* </dd><dt style="font-weight:bold"> <code>relatedTarget</code> </dt><dd> the Event's <a href="event.relatedTarget" shape="rect" title="DOM:event.relatedTarget">related EventTarget</a>. Only used with some event types (e.g. <code>mouseover</code> and <code>mouseout</code>). In other cases, pass <code>null</code>.
* </dd></dl>
* <h2> <span> Example </span></h2>
* <p>This example demonstrates simulating a click on a checkbox using DOM methods. You can view the example in action <a href="http://developer.mozilla.org/samples/domref/dispatchEvent.html" rel="nofollow" shape="rect" title="http://developer.mozilla.org/samples/domref/dispatchEvent.html">here</a>.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function simulateClick() {
* var evt = <a href="document.createEvent" shape="rect" title="DOM:document.createEvent">document.createEvent</a>("MouseEvents");
* evt.<strong>initMouseEvent</strong>("click", true, true, window,
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
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initMouseEvent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initMouseEvent">DOM Level 2 Events: initMouseEvent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
initMouseEvent: function(type, canBubble, cancelable, view, detail, screenX, screenY, clientX, clientY, ctrlKey, altKey, shiftKey, metaKey, button, relatedTarget) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Initializes a UI event once it's been created.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">event.initUIEvent(<i>type</i>, <i>canBubble</i>, <i>cancelable</i>, <i>view</i>, <i>detail</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <dl><dt style="font-weight:bold"><code>type</code> </dt><dd> The type of event.
* </dd><dt style="font-weight:bold"><code>canBubble</code> </dt><dd> A boolean indicating whether the event should bubble up through the event chain or not (see <a href="event.bubbles" shape="rect" title="DOM:event.bubbles">bubbles</a>).
* </dd><dt style="font-weight:bold"><code>cancelable</code> </dt><dd> A boolean indicating whether the event can be canceled (see <a href="event.cancelable" shape="rect" title="DOM:event.cancelable">cancelable</a>).
* </dd><dt style="font-weight:bold"><code>view</code> </dt><dd> The <a href="http://developer.mozilla.org/en/docs/index.php?title=AbstractView&amp;action=edit" shape="rect" title="DOM:AbstractView">AbstractView</a> associated with the event.
* </dd><dt style="font-weight:bold"><code>detail</code> </dt><dd> A number specifying some detail information about the event, depending on the type of event. For mouse events, it indicates how many times the mouse has been clicked on a given screen location (usually 1).
* </dd></dl>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">e = document.createEvent("UIEvents");
* // creates a click event that bubbles, can be cancelled,
* // and with its view and detail property initialized to window and 1,
* // respectively
* e.initUIEvent("click", true, true, window, 1);
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2001/WD-DOM-Level-3-Events-20010823/events.html#Events-Event-initUIEvent" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2001/WD-DOM-Level-3-Events-20010823/events.html#Events-Event-initUIEvent">initUIEvent </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
initUIEvent: function(type, canBubble, cancelable, view, detail) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>Returns a boolean indicating whether the event produced a key character or not.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">bool = event.isChar
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* if e.isChar
* echoInput(e.type);
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>Some key combos may raise events but not produce any character (example: ctrl + alt ?). When this is the case, <b>isChar</b> returns false.
* <b>isChar</b> is used when event handlers need to do something like echo the input on the screen.
* </p><p>There is currently a known bug affecting the return result, which is always <code>false</code> and never <code>true</code>. Please see the discussion link in the sidebar for more details.
* </p>
* <h2> <span>Specification </span></h2>
* <p>Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
isChar: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the Unicode value of a non-character key in a <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keypress&amp;action=edit" shape="rect" title="DOM:event:keypress">keypress</a> event or any key in any other type of keyboard event.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>value</i> = event.keyCode
* </pre>
* <ul><li> <code>value</code> is the Unicode value of the key that was pressed.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;keyCode example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showKeyCode(e)
* {
* alert("keyCode for the key pressed: " + e.keyCode + "\n");
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeydown="showKeyCode(event);"&gt;
* &lt;p&gt;Press any key.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>In a <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:event:keypress&amp;action=edit" shape="rect" title="DOM:event:keypress">keypress</a> event, the Unicode value of the key pressed is stored in either the <code>keyCode</code> or <code><a href="event.charCode" shape="rect" title="DOM:event.charCode">charCode</a></code> property, never both. If the key pressed generates a character (e.g. 'a'), <code>charCode</code> is set to the code of that character, respecting the letter case. (i.e. <code>charCode</code> takes into account whether the shift key is held down). Otherwise, the code of the pressed key is stored in <code>keyCode</code>.
* </p><p><code>keyCode</code> is always set in the <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keydown&amp;action=edit" shape="rect" title="DOM:event:keydown">keydown</a> and <a href="http://developer.mozilla.org/en/docs/index.php?title=event:keyup&amp;action=edit" shape="rect" title="DOM:event:keyup">keyup</a> events. In these cases, <code>charCode</code> is never set.
* </p><p>To get the code of the key regardless of whether it was stored in <code>keyCode</code> or <code>charCode</code>, query the <a href="event.which" shape="rect" title="DOM:event.which">which</a> property.
* </p><p>Characters entered through an IME do not register through <code>keyCode</code> or <code>charCode</code>.
* </p><p>For a list of the <code>keyCode</code> values associated with particular keys, run the example in <a href="Gecko_DOM_Reference:Examples#Example_7:_Displaying_Event_Object_Constants" shape="rect" title="Gecko DOM Reference:Examples">Example 7: Displaying Event Object Constants</a> and view the resulting HTML table.
* </p>
* <h2> <span> Specification </span></h2>
* <p>Not part of specification. See <a href="http://developer.mozilla.org/en/docs/index.php?title=nsIDOMKeyEvent&amp;action=edit" shape="rect" title="nsIDOMKeyEvent">nsIDOMKeyEvent</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
keyCode: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the horizontal coordinate of the event relative to the current layer.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>Xpos</i> = event.layerX
* </pre>
* <ul><li> <code>Xpos</code> is an integer value in pixels for the X coordinate of the mouse pointer, when the mouse event fired.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;pageX\pageY &amp; layerX\layerY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* var form = document.forms.form_coords;
* var parent_id = evt.target.parentNode.id;
* form.parentId.value = parent_id;
* form.pageXCoords.value = evt.pageX;
* form.pageYCoords.value = evt.pageY;
* form.layerXCoords.value = evt.layerX;
* form.layerYCoords.value = evt.layerY;
* }
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* 
* #d1 {
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d2 {
* position: absolute;
* top: 180px;
* left: 80%;
* right:auto;
* width: 40%;
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d3 {
* position: absolute;
* top: 240px;
* left: 20%;
* width: 50%;
* border: solid blue 1px;
* padding: 10px;
* }
* 
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* 
* &lt;p&gt;To display the mouse coordinates please click anywhere on the page.&lt;/p&gt;
* 
* &lt;div id="d1"&gt;
* &lt;span&gt;This is an un-positioned div so clicking it will return
* layerX/layerY values almost the same as pageX/PageY values.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d2"&gt;
* 
* &lt;span&gt;This is a positioned div so clicking it will return layerX/layerY
* values that are relative to the top-left corner of this positioned
* element. Note the pageX\pageY properties still return the
* absolute position in the document, including page scrolling.&lt;/span&gt;
* 
* &lt;span&gt;Make the page scroll more! This is a positioned div so clicking it
* will return layerX/layerY values that are relative to the top-left
* corner of this positioned element. Note the pageX\pageY properties still
* return the absolute position in the document, including page
* scrolling.&lt;/span&gt;
* 
* &lt;/div&gt;
* 
* &lt;div id="d3"&gt;
* &lt;form name="form_coords" id="form1"&gt;
* Parent Element id: &lt;input type="text" name="parentId" size="7" /&gt;&lt;br /&gt;
* pageX:&lt;input type="text" name="pageXCoords" size="7" /&gt;  
* pageY:&lt;input type="text" name="pageYCoords" size="7" /&gt;&lt;br /&gt;
* layerX:&lt;input type="text" name="layerXCoords" size="7" /&gt;  
* layerY:&lt;input type="text" name="layerYCoords" size="7" /&gt;
* &lt;/form&gt;
* &lt;/div&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>layerX</code> takes scrolling of the page into account, and returns a value relative to the whole of the document, unless the event occurs inside a positioned element, where the returned value is relative to the top left of the positioned element.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
layerX: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the vertical coordinate of the event relative to the current layer.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>Ypos</i> = event.layerY
* </pre>
* <ul><li> <code>Ypos</code> is an integer value in pixels for the Y coordinate of the mouse pointer, when the mouse event fired.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;pageX\pageY &amp; layerX\layerY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* var form = document.forms.form_coords;
* var parent_id = evt.target.parentNode.id;
* form.parentId.value = parent_id;
* form.pageXCoords.value = evt.pageX;
* form.pageYCoords.value = evt.pageY;
* form.layerXCoords.value = evt.layerX;
* form.layerYCoords.value = evt.layerY;
* }
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* 
* #d1 {
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d2 {
* position: absolute;
* top: 180px;
* left: 80%;
* right:auto;
* width: 40%;
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d3 {
* position: absolute;
* top: 240px;
* left: 20%;
* width: 50%;
* border: solid blue 1px;
* padding: 10px;
* }
* 
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* 
* &lt;p&gt;To display the mouse coordinates please click anywhere on the page.&lt;/p&gt;
* 
* &lt;div id="d1"&gt;
* &lt;span&gt;This is an un-positioned div so clicking it will return
* layerX/layerY values almost the same as pageX/PageY values.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d2"&gt;
* 
* &lt;span&gt;This is a positioned div so clicking it will return layerX/layerY
* values that are relative to the top-left corner of this positioned
* element. Note the pageX\pageY properties still return the
* absolute position in the document, including page scrolling.&lt;/span&gt;
* 
* &lt;span&gt;Make the page scroll more! This is a positioned div so clicking it
* will return layerX/layerY values that are relative to the top-left
* corner of this positioned element. Note the pageX\pageY properties still
* return the absolute position in the document, including page
* scrolling.&lt;/span&gt;
* 
* &lt;/div&gt;
* 
* &lt;div id="d3"&gt;
* &lt;form name="form_coords" id="form1"&gt;
* Parent Element id: &lt;input type="text" name="parentId" size="7" /&gt;&lt;br /&gt;
* pageX:&lt;input type="text" name="pageXCoords" size="7" /&gt;  
* pageY:&lt;input type="text" name="pageYCoords" size="7" /&gt;&lt;br /&gt;
* layerX:&lt;input type="text" name="layerXCoords" size="7" /&gt;  
* layerY:&lt;input type="text" name="layerYCoords" size="7" /&gt;
* &lt;/form&gt;
* &lt;/div&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p><code>layerY</code> takes scrolling of the page into account, and returns a value relative to the whole of the document, unless the event occurs inside a positioned element, where the returned value is relative to the top left of the positioned element.
* </p>
* <h2> <span>Specification </span></h2>
* <p>Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
layerY: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Indicates whether the META key was pressed when the event fired.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = event.metaKey
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending on whether the meta key was held down or not, when the event fired.
* </p>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* function goInput(e) {
* // checks metaKey and
* if e.metaKey
* // passes event along
* superSizeOutput(e);
* else
* doOutput(e)
* }
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-metaKey" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-metaKey">metaKey </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
metaKey: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>The original target of the event before any <a href="http://developer.mozilla.org/en/docs/index.php?title=event_retargeting&amp;action=edit" shape="rect" title="DOM:event retargeting">retargetings</a>. (Mozilla-specific)
* </p><p><code>originalTarget</code> can be <a href="http://developer.mozilla.org/en/docs/index.php?title=anonymous_content&amp;action=edit" shape="rect" title="DOM:anonymous content">anonymous content</a>. (Unlike <code><a href="event.explicitOriginalTarget" shape="rect" title="DOM:event.explicitOriginalTarget">event.explicitOriginalTarget</a></code>)
* </p><p>See also <a href="event:Comparison_of_Event_Targets" shape="rect" title="DOM:event:Comparison of Event Targets">Comparison of Event Targets</a>
* </p>
* <h2> <span> Example </span></h2>
* <p><i>Need an example that makes sense here</i>
* </p>
* <h2> <span> Specification </span></h2>
* <p>This is a Mozilla-specific property. Defined in <a href="http://mxr.mozilla.org/mozilla/source//dom/public/idl/events/nsIDOMNSEvent.idl" rel="nofollow" shape="rect" title="http://mxr.mozilla.org/mozilla/source//dom/public/idl/events/nsIDOMNSEvent.idl"><code>/dom/public/idl/events/nsIDOMNSEvent.idl</code></a>
* </p><p>This event property is <b>not defined</b> in the <a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html">W3.org DOM Level 2 Events</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsExample" shape="rect" title="Category:NeedsExample">NeedsExample</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
originalTarget: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the horizontal coordinate of the event relative to whole document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>pageX</i> = <i>event</i>.pageX;
* </pre>
* <p><code>pageX</code> is an integer value in pixels for the X coordinate of the mouse pointer, relative to the whole document, when the mouse event fired. This property takes into account any horizontal scrolling of the page.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;pageX\pageY &amp; layerX\layerY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* var form = document.forms.form_coords;
* var parent_id = evt.target.parentNode.id;
* form.parentId.value = parent_id;
* form.pageXCoords.value = evt.pageX;
* form.pageYCoords.value = evt.pageY;
* form.layerXCoords.value = evt.layerX;
* form.layerYCoords.value = evt.layerY;
* }
* 
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* 
* #d1 {
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d2 {
* position: absolute;
* top: 180px;
* left: 80%;
* right:auto;
* width: 40%;
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d3 {
* position: absolute;
* top: 240px;
* left: 20%;
* width: 50%;
* border: solid blue 1px;
* padding: 10px;
* }
* 
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* 
* &lt;p&gt;To display the mouse coordinates please click anywhere on the page.&lt;/p&gt;
* 
* &lt;div id="d1"&gt;
* &lt;span&gt;This is an un-positioned div so clicking it will return
* layerX/layerY values almost the same as pageX/PageY values.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d2"&gt;
* &lt;span&gt;This is a positioned div so clicking it will return layerX/layerY
* values that are relative to the top-left corner of this positioned
* element. Note the pageX\pageY properties still return the
* absolute position in the document, including page scrolling.&lt;/span&gt;
* 
* &lt;span&gt;Make the page scroll more! This is a positioned div so clicking it
* will return layerX/layerY values that are relative to the top-left
* corner of this positioned element. Note the pageX\pageY properties still
* return the absolute position in the document, including page
* scrolling.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d3"&gt;
* &lt;form name="form_coords"&gt;
* Parent Element id: &lt;input type="text" name="parentId" size="7" /&gt;&lt;br /&gt;
* pageX:&lt;input type="text" name="pageXCoords" size="7" /&gt;  
* pageY:&lt;input type="text" name="pageYCoords" size="7" /&gt;&lt;br /&gt;
* layerX:&lt;input type="text" name="layerXCoords" size="7" /&gt;  
* layerY:&lt;input type="text" name="layerYCoords" size="7" /&gt;
* &lt;/form&gt;
* &lt;/div&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Specification </span></h2>
* <p>Not part of any public standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
pageX: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the vertical coordinate of the event relative to the whole document.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>pageY</i> = <i>event</i>.pageY;
* </pre>
* <p><code>pageY</code> is an integer value in pixels for the Y coordinate of the mouse pointer, relative to the whole document, when the mouse event fired. This property takes into account any vertical scrolling of the page.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;pageX\pageY &amp; layerX\layerY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* var form = document.forms.form_coords;
* var parent_id = evt.target.parentNode.id;
* form.parentId.value = parent_id;
* form.pageXCoords.value = evt.pageX;
* form.pageYCoords.value = evt.pageY;
* form.layerXCoords.value = evt.layerX;
* form.layerYCoords.value = evt.layerY;
* }
* 
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* 
* #d1 {
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d2 {
* position: absolute;
* top: 180px;
* left: 80%;
* right:auto;
* width: 40%;
* border: solid blue 1px;
* padding: 20px;
* }
* 
* #d3 {
* position: absolute;
* top: 240px;
* left: 20%;
* width: 50%;
* border: solid blue 1px;
* padding: 10px;
* }
* 
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* 
* &lt;p&gt;To display the mouse coordinates please click anywhere on the page.&lt;/p&gt;
* 
* &lt;div id="d1"&gt;
* &lt;span&gt;This is an un-positioned div so clicking it will return
* layerX/layerY values almost the same as pageX/PageY values.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d2"&gt;
* &lt;span&gt;This is a positioned div so clicking it will return layerX/layerY
* values that are relative to the top-left corner of this positioned
* element. Note the pageX\pageY properties still return the
* absolute position in the document, including page scrolling.&lt;/span&gt;
* 
* &lt;span&gt;Make the page scroll more! This is a positioned div so clicking it
* will return layerX/layerY values that are relative to the top-left
* corner of this positioned element. Note the pageX\pageY properties still
* return the absolute position in the document, including page
* scrolling.&lt;/span&gt;
* &lt;/div&gt;
* 
* &lt;div id="d3"&gt;
* &lt;form name="form_coords"&gt;
* Parent Element id: &lt;input type="text" name="parentId" size="7" /&gt;&lt;br /&gt;
* pageX:&lt;input type="text" name="pageXCoords" size="7" /&gt;  
* pageY:&lt;input type="text" name="pageYCoords" size="7" /&gt;&lt;br /&gt;
* layerX:&lt;input type="text" name="layerXCoords" size="7" /&gt;  
* layerY:&lt;input type="text" name="layerYCoords" size="7" /&gt;
* &lt;/form&gt;
* &lt;/div&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Specification </span></h2>
* <p>Not part of any public standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
pageY: undefined,
preventBubble: function() {
  // This is just a stub for a builtin native JavaScript object.
},
preventCapture: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Cancels the event if it is cancelable, without stopping further propagation of the event.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i>.preventDefault()
* </pre>
* <h2> <span> Example </span></h2>
* <p>Toggling a checkbox is the default action of clicking on a checkbox. This example demonstrates how to prevent that happening:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;preventDefault example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function stopDefAction(evt) {
* evt.preventDefault();
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* 
* &lt;p&gt;Please click on the checkbox control.&lt;/p&gt;
* 
* &lt;form&gt;
* &lt;input type="checkbox" onclick="stopDefAction(event);"/&gt;
* &lt;label for="checkbox"&gt;Checkbox&lt;/label&gt;
* &lt;/form&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>You can see <code>preventDefault</code> in action <a href="http://developer.mozilla.org/samples/domref/dispatchEvent.html" rel="nofollow" shape="rect" title="http://developer.mozilla.org/samples/domref/dispatchEvent.html">here</a>.
* </p><p>The following example demonstrates how invalid text input can be stopped from
* reaching the input field with preventDefault().
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;preventDefault example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function checkName(evt) {
* var charCode = evt.charCode;
* 
* if (charCode != 0) {
* if (charCode &lt; 97 || charCode &gt; 122) {
* evt.preventDefault();
* alert("Please use lowecase letters only." + "\n"
* + "charCode: " + charCode + "\n"
* );
* }
* }
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* 
* &lt;p&gt;Please enter your name using lowercase letters only.&lt;/p&gt;
* &lt;form&gt;
* &lt;input type="text" onkeypress="checkName(event);"/&gt;
* &lt;/form&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Calling <code>preventDefault</code> during any stage of event flow cancels the event, meaning that any default action normally taken by the implementation as a result of the event will not occur.
* </p><p>You can use <a href="DOM:event.cancelable" shape="rect" title="DOM:event.cancelable">event.cancelable</a> to check if the event is cancelable. Calling <code>preventDefault</code> for a non-cancelable event has no effect.
* </p><p><code>preventDefault</code> doesn't stop further propagation of the event through the DOM. <a href="event.stopPropagation" shape="rect" title="DOM:event.stopPropagation">event.stopPropagation</a> should be used for that.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-preventDefault" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-preventDefault">DOM Level 2 Events: preventDefault</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * If an event is cancelable, the preventDefault method is used to signify that the
 * event is to be canceled, meaning any default action normally taken
 * by the implementation as a result of the event will not occur. If,
 * during any stage of event flow, the preventDefault method is called the event is canceled. Any default action
 * associated with the event will not occur. Calling this method for a
 * non-cancelable event has no effect. Once preventDefault has been called it will remain in
 * effect throughout the remainder of the event's propagation. This
 * method may be used during any stage of event flow.
 * @type void
 
 * @type void
*/
preventDefault: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Identifies a secondary target for the event. Only <code>MouseEvent</code>s have this property, and its value makes sense only for certain <code>MouseEvent</code>s:
* </p>
* <ul><li> For the <code>mouseover</code> event and the non-standard <code>dragenter</code> event this property indicates the <code><a href="EventTarget" shape="rect" title="DOM:EventTarget">EventTarget</a></code> which the pointing device exited
* </li><li> For the <code>mouseout</code> event and the non-standard <code>dragexit</code> event this property indicates the <code><a href="EventTarget" shape="rect" title="DOM:EventTarget">EventTarget</a></code> which the pointing device entered.
* </li></ul>
* <p>See also <a href="event:Comparison_of_Event_Targets" shape="rect" title="DOM:event:Comparison of Event Targets">Comparison of Event Targets</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>target</i> = <i>event</i>.relatedTarget
* </pre>
* <ul><li> <code>target</code> is a reference to the secondary <code><a href="DOM:EventTarget" shape="rect" title="DOM:EventTarget">EventTarget</a></code> for this event. See <a href="event.relatedTarget#Summary" shape="rect" title="">Summary</a> for details.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var rel = event.relatedTarget;
* // dump("LEAVING " + (rel ? rel.localName : "null") + "\n");
* // relatedTarget is null when the titletip is first shown:
* // a mouseout event fires because the mouse is exiting
* // the main window and entering the titletip "window".
* // relatedTarget is also null when the mouse exits the main
* // window completely, so count how many times relatedTarget
* // was null after titletip is first shown and hide popup
* // the 2nd time
* if (!rel) {
* ++this._mouseOutCount;
* if (this._mouseOutCount &gt; 1)
* this.hidePopup();
* return;
* }
* // find out if the node we are entering is one of our
* // anonymous children
* while (rel) {
* if (rel == this)
* break;
* rel = rel.parentNode;
* }
* // if the entered node is not a descendant of ours, hide
* // the tooltip
* if (rel != this &amp;&amp; this._isMouseOver) {
* this.hidePopup();
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The <code>relatedTarget</code> property is used to find the other element, if any, involved in an event. Events like <code>mouseover</code> are oriented around a certain target, but also involve a secondary target, such as the target that is exited as the <code>mouseover</code> event fires for the primary target.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-relatedTarget" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-MouseEvent-relatedTarget">DOM Level 2 Events: MouseEvent.relatedTarget</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
relatedTarget: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the horizontal coordinate of the event within the screen as a whole..
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>pixelNumber</i> = event.screenX
* </pre>
* <ul><li><code>pixelNumber</code> is the offset from the left side of the screen in pixels.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;screenX\screenY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* alert(
* "screenX value: " + evt.screenX + "\n"
* + "screenY value: " + evt.screenY + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* &lt;p&gt;To display the mouse coordinates click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* function checkClickMap(e) {
* if (e.screenX &lt; 50) doRedButton();
* if (50 &lt;= e.screenX) &lt; 100 doYellowButton();
* if (e.screenX &gt;= 100) doRedButton();
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>When you trap events on the window, document, or other roomy elements, you can get the coordinates of that event (e.g., a click) and route it properly, as the "clickMap" example demonstrates.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-screenX" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-screenX">screenX </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
screenX: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the vertical coordinate of the event within the screen as a whole..
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>pixelNumber</i> = event.screenY
* </pre>
* <ul><li><code>pixelNumber</code> is the offset from the top of the screen in pixels.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;screenX\screenY example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showCoords(evt){
* alert(
* "screenX value: " + evt.screenX + "\n"
* + "screenY value: " + evt.screenY + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="showCoords(event)"&gt;
* &lt;p&gt;To display the mouse coordinates click anywhere on the page.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>When you trap events on the window, document, or other roomy elements, you can get the coordinates of that event (e.g., a click) and route it properly, as the <a href="http://developer.mozilla.org/en/docs/screenX#Example" shape="rect" title="screenX">"clickMap"</a> example demonstrates.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-screenY" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-screenY">screenY </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
screenY: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Indicates whether the SHIFT key was pressed when the event fired.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = event.shiftKey
* </pre>
* <p><code>bool</code> contains <code>true</code> or <code>false</code>, depending on whether the shift key was held down or not, when the event fired.
* </p>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;shiftKey example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showChar(e){
* alert(
* "Key Pressed: " + String.fromCharCode(e.charCode) + "\n"
* + "charCode: " + e.charCode + "\n"
* + "SHIFT key pressed: " + e.shiftKey + "\n"
* + "ALT key pressed: " + e.altKey + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeypress="showChar(event);"&gt;
* &lt;p&gt;Press any character key, with or without holding down
* the SHIFT key.&lt;br /&gt;
* You can also use the SHIFT key together with the ALT key.&lt;/p&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-shiftKey" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-MouseEvent-shiftKey">shiftKey </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
shiftKey: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Prevents further propagation of the current event.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>event</i>.stopPropagation()
* </pre>
* <h2> <span> Example </span></h2>
* <p>See Example 5: <a href="Gecko_DOM_Reference:Examples#Example_5:_Event_Propagation" shape="rect" title="Gecko DOM Reference:Examples">Event Propagation</a> in the Examples chapter for a more detailed example of this method and event propagation in the DOM.
* </p>
* <h2> <span> Notes </span></h2>
* <p>See the <a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-flow-capture" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-flow-capture">DOM specification</a> for the explanation of event flow. (The <a href="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-flow" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-3-Events/events.html#Events-flow">DOM Level 3 Events draft</a> has an illustration.)
* </p><p><a href="event.preventDefault" shape="rect" title="DOM:event.preventDefault">preventDefault</a> is a complementary function that can be used to prevent the default action of the event from happening.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-stopPropagation" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-stopPropagation">DOM Level 2 Events: stopPropagation</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The stopPropagation method is used
 * prevent further propagation of an event during event flow. If this
 * method is called by any EventListener the event will cease propagating through the tree. The event will
 * complete dispatch to all listeners on the current EventTarget before event flow stops. This method may be used during any stage
 * of event flow.
 * @type void
 
 * @type void
*/
stopPropagation: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the target to which the event was dispatched.
* </p><p>See also <a href="event:Comparison_of_Event_Targets" shape="rect" title="DOM:event:Comparison of Event Targets">Comparison of Event Targets</a>.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>target</i> = <i>event</i>.target
* </pre>
* <ul><li> <code>target</code> is a reference to the <code><a href="DOM:EventTarget" shape="rect" title="DOM:EventTarget">EventTarget</a></code>, to which the event was dispatched.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;target example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function highlightTarget(evt) {
* evt.target.style.backgroundColor = 'blue';
* }
* 
* function resetTarget(evt) {
* evt.target.style.backgroundColor = 'silver';
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onmousedown="highlightTarget(event)" onmouseup="resetTarget(event)"&gt;
* 
* &lt;p&gt;This example demonstrates how, by using event propagation, two event
* handler functions in the body element can use the &lt;i&gt;target&lt;/i&gt; property
* to distinguish between, and process, all other bubbleable events occuring
* lower down the DOM. Note: not all events can bubble up the DOM.&lt;/p&gt;
* 
* &lt;p&gt;As an event lower down the DOM bubbles up and reaches the body
* object, the &lt;i&gt;target&lt;/i&gt; property contains the object reference of the
* original event target. In this case which element in the document
* received an onmousedown or onmouseup event.&lt;/p&gt;
* 
* &lt;p&gt;This allows the event handlers of the body object to process bubbleable
* events occuring lower down the DOM structure, which means there is no need
* to attach the event handlers to every button &amp; para element of the page.&lt;/p&gt;
* 
* &lt;button&gt;button 1&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 2&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 3&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 4&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 5&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 6&lt;/button&gt;&lt;br /&gt;
* &lt;button&gt;button 7&lt;/button&gt;&lt;br /&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-target" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-target">DOM Level 2 Events: Event.target</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to indicate the EventTarget
 * to which the event was originally dispatched.
 * @type EventTarget
 */
target: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the time (in milliseconds since the epoch) that the event was created.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>number</i> = event.timeStamp
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* 
* &lt;title&gt;timeStamp example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* var curr_time = null;
* 
* function getTime(evt) {
* curr_time = evt.timeStamp;
* document.getElementById("time").firstChild.nodeValue = curr_time;
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body onkeypress="getTime(event)"&gt;
* 
* &lt;p&gt;Press any key to get the current timestamp
* for the onkeypress event.&lt;/p&gt;
* &lt;p&gt;timeStamp: &lt;span id="time"&gt;-&lt;/span&gt;&lt;/p&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This property only works if the event system supports it for the particular event.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-timeStamp" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-timeStamp">timestamp </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * Used to specify the time (in milliseconds relative to the
 * epoch) at which the event was created. Due to the fact that some
 * systems may not provide this information the value of
 * timeStamp may be not available for all events. When
 * not available, a value of 0 will be returned. Examples of epoch
 * time are the time of the system start or 0:0:0 UTC 1st January
 * 1970.
 * @type Date
 */
timeStamp: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the name of the event (case-insensitive).
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = event.type
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* 
* &lt;title&gt;type example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* var currEvent = null;
* 
* function getEvtType(evt) {
* currEvent = evt.type;
* document.getElementById("Etype").firstChild.nodeValue = currEvent;
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body
* onkeydown="getEvtType(event)"
* onkeyup="getEvtType(event)"
* onmousedown="getEvtType(event)"
* onmouseup="getEvtType(event)"&gt;
* 
* &lt;p&gt;Press any key or click the mouse to get the event type.&lt;/p&gt;
* &lt;p&gt;Event type: &lt;span id="Etype"&gt;-&lt;/span&gt;&lt;/p&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The type must be an XML name..
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-type" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Events-20001113/events.html#Events-Event-type">type </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * <p>Original W3C documentation:</p>
 * The name of the event (case-insensitive). The name must be an
 * XML name.
 * @type String
 */
type: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the <code>AbstractView</code> object from which the event was generated. In browsers, this is the <a href="window" shape="rect" title="DOM:window">window</a> object the event happened in.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>view</i> = <i>event</i>.view
* </pre>
* <ul><li> <code>view</code> is a reference to an <code>AbstractView</code> object.
* </li></ul>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-UIEvent-view" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-UIEvent-view">DOM Level 2 Events: UIEvent.view</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
view: undefined,
/**
* <h2> <span> Summary</span></h2>
* <p>Returns the numeric <code>keyCode</code> of the key pressed, or the character code (<code>charCode</code>) for an alphanumeric key pressed.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>keyResult</i> = event.which
* </pre>
* <p><code>keyResult</code> contains the numeric code for a particular key pressed, depending on whether an alphanumeric or non-alphanumeric key was pressed. Please see <code><a href="DOM:event.charCode" shape="rect" title="DOM:event.charCode">charCode</a></code> and <code><a href="event.keyCode" shape="rect" title="DOM:event.keyCode">keyCode</a></code> for more details.
* </p>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;charCode/keyCode/which example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function showKeyPress(evt)
* {
* alert("onkeypress handler: \n"
* + "keyCode property: " + evt.keyCode + "\n"
* + "which property: " + evt.which + "\n"
* + "charCode property: " + evt.charCode + "\n"
* + "Character Key Pressed: "
* + String.fromCharCode(evt.charCode) + "\n"
* );
* }
* 
* function keyDown(evt)
* {
* alert("onkeydown handler: \n"
* + "keyCode property: " + evt.keyCode + "\n"
* + "which property: " + evt.which + "\n"
* );
* }
* 
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body
* onkeypress="showKeyPress(event);"
* onkeydown="keyDown(event);"
* &gt;
* 
* &lt;p&gt;Please press any key.&lt;/p&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
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
which: undefined,
};

