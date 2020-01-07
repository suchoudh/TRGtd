var MouseEvent = Object.extend(new UIEvent(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Used to indicate whether the 'alt' key was depressed during the
 * firing of the event. On some platforms this key may map to an
 * alternative key name.
 * @type Boolean
 */
altKey: undefined,
/**
 * During mouse events caused by the depression or release of a
 * mouse button, button is used to indicate which mouse
 * button changed state. The values for button range from
 * zero to indicate the left button of the mouse, one to indicate the
 * middle button if present, and two to indicate the right button. For
 * mice configured for left handed use in which the button actions are
 * reversed the values are instead read from right to left.
 * @type Number
 */
button: undefined,
/**
 * The horizontal coordinate at which the event occurred relative
 * to the DOM implementation's client area.
 * @type Number
 */
clientX: undefined,
/**
 * The vertical coordinate at which the event occurred relative to
 * the DOM implementation's client area.
 * @type Number
 */
clientY: undefined,
/**
 * Used to indicate whether the 'ctrl' key was depressed during
 * the firing of the event.
 * @type Boolean
 */
ctrlKey: undefined,
/**
 * The initMouseEvent method is used
 * to initialize the value of a MouseEvent created
 * through the DocumentEvent interface. This method may only be called before the MouseEvent has been dispatched via the dispatchEvent method, though it may be called multiple
 * times during that phase if necessary. If called multiple times, the
 * final invocation takes precedence.
 * @param {String} typeArg of type DOMString Specifies the event type.
 * @param {Boolean} canBubbleArg of type boolean Specifies whether or not the event can bubble.
 * @param {Boolean} cancelableArg of type boolean Specifies whether or not the event's default action can be
 * prevented.
 * @param {AbstractView} viewArg of type views::AbstractView Specifies the Event 's AbstractView .
 * @param {Number} detailArg of type long Specifies the Event 's mouse
 * click count.
 * @param {Number} screenXArg of type long Specifies the Event 's screen x
 * coordinate
 * @param {Number} screenYArg of type long Specifies the Event 's screen y
 * coordinate
 * @param {Number} clientXArg of type long Specifies the Event 's client x
 * coordinate
 * @param {Number} clientYArg of type long Specifies the Event 's client y
 * coordinate
 * @param {Boolean} ctrlKeyArg of type boolean Specifies whether or not control key was depressed during the Event .
 * @param {Boolean} altKeyArg of type boolean Specifies whether or not alt key was depressed during the Event .
 * @param {Boolean} shiftKeyArg of type boolean Specifies whether or not shift key was depressed during the Event .
 * @param {Boolean} metaKeyArg of type boolean Specifies whether or not meta key was depressed during the Event .
 * @param {Number} buttonArg of type unsigned short Specifies the Event 's mouse
 * button.
 * @param {EventTarget} relatedTargetArg of type EventTarget Specifies the Event 's related EventTarget .
 * @type void
 */
initMouseEvent: function(typeArg, canBubbleArg, cancelableArg,viewArg, detailArg, screenXArg, screenYArg, clientXArg, clientYArg,ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, buttonArg,relatedTargetArg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Used to indicate whether the 'meta' key was depressed during
 * the firing of the event. On some platforms this key may map to an
 * alternative key name.
 * @type Boolean
 */
metaKey: undefined,
/**
 * Used to identify a secondary EventTarget
 * related to a UI event. Currently this attribute is used with the
 * mouseover event to indicate the EventTarget
 * which the pointing device exited and with the mouseout event to
 * indicate the EventTarget
 * which the pointing device entered.
 * @type EventTarget
 */
relatedTarget: undefined,
/**
 * The horizontal coordinate at which the event occurred relative
 * to the origin of the screen coordinate system.
 * @type Number
 */
screenX: undefined,
/**
 * The vertical coordinate at which the event occurred relative to
 * the origin of the screen coordinate system.
 * @type Number
 */
screenY: undefined,
/**
 * Used to indicate whether the 'shift' key was depressed during
 * the firing of the event.
 * @type Boolean
 */
shiftKey: undefined,
});

