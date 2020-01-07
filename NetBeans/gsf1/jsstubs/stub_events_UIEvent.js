var UIEvent = Object.extend(new Event(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Specifies some detail information about the Event, depending
 * on the type of event.
 * @type Number
 */
detail: undefined,
/**
 * The initUIEvent method is used to
 * initialize the value of a UIEvent created through the DocumentEvent interface. This method may only be called before the UIEvent has been dispatched via the dispatchEvent method, though it may be called multiple
 * times during that phase if necessary. If called multiple times, the
 * final invocation takes precedence.
 * @param {String} typeArg of type DOMString Specifies the event type.
 * @param {Boolean} canBubbleArg of type boolean Specifies whether or not the event can bubble.
 * @param {Boolean} cancelableArg of type boolean Specifies whether or not the event's default action can be
 * prevented.
 * @param {AbstractView} viewArg of type views::AbstractView Specifies the Event 's AbstractView .
 * @param {Number} detailArg of type long Specifies the Event 's
 * detail.
 * @type void
 */
initUIEvent: function(typeArg, canBubbleArg, cancelableArg, viewArg,detailArg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The view attribute identifies the
 * AbstractView from which the event was generated.
 * @type AbstractView
 */
view: undefined,
});

