var MutationEvent = Object.extend(new Event(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The Attr was just added.
 * @type Number
 */
ADDITION: undefined,
/**
 * The Attr was modified in place.
 * @type Number
 */
MODIFICATION: undefined,
/**
 * The Attr was just removed.
 * @type Number
 */
REMOVAL: undefined,
/**
 * attrChange indicates the type of change which
 * triggered the DOMAttrModified event. The values can be
 * MODIFICATION, ADDITION, or
 * REMOVAL.
 * @type Number
 */
attrChange: undefined,
/**
 * attrName indicates the name of the changed
 * Attr node in a DOMAttrModified event.
 * @type String
 */
attrName: undefined,
/**
 * The initMutationEvent method is
 * used to initialize the value of a MutationEvent created through the DocumentEvent interface. This method may only be called before the MutationEvent has been dispatched via the dispatchEvent method, though it may be called multiple
 * times during that phase if necessary. If called multiple times, the
 * final invocation takes precedence.
 * @param {String} typeArg of type DOMString Specifies the event type.
 * @param {Boolean} canBubbleArg of type boolean Specifies whether or not the event can bubble.
 * @param {Boolean} cancelableArg of type boolean Specifies whether or not the event's default action can be
 * prevented.
 * @param {Node} relatedNodeArg of type Node Specifies the Event 's related
 * Node.
 * @param {String} prevValueArg of type DOMString Specifies the Event 's prevValue attribute. This value may be null.
 * @param {String} newValueArg of type DOMString Specifies the Event 's newValue attribute. This value may be null.
 * @param {String} attrNameArg of type DOMString Specifies the Event 's attrName attribute. This value may be null.
 * @param {Number} attrChangeArg of type unsigned short Specifies the Event 's attrChange attribute
 * @type void
 */
initMutationEvent: function(typeArg, canBubbleArg, cancelableArg,relatedNodeArg, prevValueArg, newValueArg, attrNameArg,attrChangeArg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * newValue indicates the new value of the
 * Attr node in DOMAttrModified events, and of the
 * CharacterData node in DOMCharDataModified
 * events.
 * @type String
 */
newValue: undefined,
/**
 * prevValue indicates the previous value of the
 * Attr node in DOMAttrModified events, and of the
 * CharacterData node in DOMCharDataModified
 * events.
 * @type String
 */
prevValue: undefined,
/**
 * relatedNode is used to identify a secondary node
 * related to a mutation event. For example, if a mutation event is
 * dispatched to a node indicating that its parent has changed, the
 * relatedNode is the changed parent. If an event is
 * instead dispatched to a subtree indicating a node was changed
 * within it, the relatedNode is the changed node. In the
 * case of the DOMAttrModified event it indicates the
 * Attr node which was modified, added, or removed.
 * @type Node
 */
relatedNode: undefined,
});

