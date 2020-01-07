/**
* <p>Ç </p>
* <p>An <code>EventTarget</code> is a DOM interface implemented by
* objects that can receive DOM events and have listeners for them.
* The most common <code>EventTarget</code>s are <a href="DOM:element" shape="rect" title="DOM:element">DOM elements</a>, although other objects can be
* <code>EventTarget</code>s too, for example <a href="document" shape="rect" title="DOM:document">document</a>, <a href="window" shape="rect" title="DOM:window">window</a>, <a href="http://developer.mozilla.org/en/docs/XMLHttpRequest" shape="rect" title="XMLHttpRequest">XMLHttpRequest</a>, and others.</p>
* 
* <h2> <span>Methods</span></h2>
* <table border="1" style="background:#FFFFFF none repeat scroll 0%;border: 1px solid #666666;margin-bottom:10px;margin-top:10px" width="100%">
* <tr>
* <th colspan="1" rowspan="1">Name &amp; Description</th>
* <th colspan="1" rowspan="1">Return</th>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code><a href="DOM:element.addEventListener" shape="rect" title="DOM:element.addEventListener">addEventListener</a>( <a href="http://developer.mozilla.org/en/docs/String" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:String">type</a>,
* <a href="http://developer.mozilla.org/en/docs/Function" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:Function">handler</a>,
* <a href="http://developer.mozilla.org/en/docs/Boolean" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:Boolean">bubble</a>
* )</code>
* Register an event handler of a specific event type on the
* <code>EventTarget</code>.</td>
* <td colspan="1" rowspan="1">-</td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code><a href="element.removeEventListener" shape="rect" title="DOM:element.removeEventListener">removeEventListener</a>( <a href="http://developer.mozilla.org/en/docs/String" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:String">type</a>,
* <a href="http://developer.mozilla.org/en/docs/Function" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:Function">handler</a>
* )</code>
* Removes an event listener from the <code>EventTarget</code>.</td>
* <td colspan="1" rowspan="1">-</td>
* </tr>
* <tr>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code><a href="element.dispatchEvent" shape="rect" title="DOM:element.dispatchEvent">dispatchEvent</a>( <a href="event" shape="rect" title="DOM:event">event</a> )</code>
* Dispatch an event to this <code>EventTarget</code>.</td>
* <td colspan="1" rowspan="1"><a href="http://developer.mozilla.org/en/docs/Boolean" shape="rect" title="Core JavaScript 1.5 Reference:Global Objects:Boolean">Boolean</a></td>
* </tr>
* </table>
* 
* <h2> <span>Specification</span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-EventTarget" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-EventTarget">DOM Level 2 Events: EventTarget</a></p>
* 
* <div id="catlinks">
* <p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM
* Reference</a></span></p>
* </div>
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>
* <li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>
* </ul>
*/
var EventTarget = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * This method allows the registration of event
 * listeners on the event target. If an EventListener is added to an EventTarget while it is processing an
 * event, it will not be triggered by the current actions but may be
 * triggered during a later stage of event flow, such as the bubbling
 * phase. If multiple identical EventListener s
 * are registered on the same EventTarget with the same
 * parameters the duplicate instances are discarded. They do not cause
 * the EventListener to be called twice and since they are discarded they do not need to
 * be removed with the removeEventListener method.
 * @param {String} type of type DOMString The event type for which the user is registering
 * @param {EventListener} listener of type EventListener The listener parameter takes an interface
 * implemented by the user which contains the methods to be called
 * when the event occurs.
 * @param {Boolean} useCapture of type boolean If true, useCapture indicates that the user wishes
 * to initiate capture. After initiating capture, all events of the
 * specified type will be dispatched to the registered EventListener before being dispatched to any EventTargets beneath
 * them in the tree. Events which are bubbling upward through the tree
 * will not trigger an EventListener designated to use capture.
 * @type void
 */
addEventListener: function(type, listener, useCapture) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method allows the dispatch of events into
 * the implementations event model. Events dispatched in this manner
 * will have the same capturing and bubbling behavior as events
 * dispatched directly by the implementation. The target of the event
 * is the EventTarget on which dispatchEvent is called.
 * @param {Event} evt of type Event Specifies the event type, behavior, and contextual information
 * to be used in processing the event.
 * @return boolean The return value of dispatchEvent indicates whether
 * any of the listeners which handled the event called preventDefault . If preventDefault was
 * called the value is false, else the value is true.
 * @type Boolean
 */
dispatchEvent: function(evt) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method allows the removal of event
 * listeners from the event target. If an EventListener is removed from an EventTarget while it is processing
 * an event, it will not be triggered by the current actions. EventListener s
 * can never be invoked after being removed. Calling removeEventListener with arguments which do
 * not identify any currently registered EventListener on the EventTarget has no effect.
 * @param {String} type of type DOMString Specifies the event type of the EventListener being removed.
 * @param {EventListener} listener of type EventListener The EventListener parameter indicates the EventListener to be
 * removed.
 * @param {Boolean} useCapture of type boolean Specifies whether the EventListener being removed was registered as a capturing listener or not. If a
 * listener was registered twice, one with capture and one without,
 * each must be removed separately. Removal of a capturing listener
 * does not affect a non-capturing version of the same listener, and
 * vice versa.
 * @type void
 */
removeEventListener: function(type, listener, useCapture) {
  // This is just a stub for a builtin native JavaScript object.
},
};

