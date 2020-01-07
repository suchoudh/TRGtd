var CSSStyleDeclaration = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * A string representation of the current value.
 * @type String
 */
cssText: undefined,
/**
 * Used to retrieve the object representation of
 * the value of a CSS property if it has been explicitly set within
 * this declaration block. This method returns null if
 * the property is a shorthand property. Shorthand property values can only
 * be accessed and modified as strings, using the getPropertyValue and setProperty methods.
 * @param {String} propertyName of type DOMString The name of the CSS property. See the CSS property index .
 * @return CSSValue Returns the value of the property if it has been explicitly set
 * for this declaration block. Returns null if the
 * property has not been set.
 * @type CSSValue
 */
getPropertyCSSValue: function(propertyName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Used to retrieve the priority of a CSS property
 * (e.g. the "important" qualifier) if the property has
 * been explicitly set in this declaration block.
 * @param {String} propertyName of type DOMString The name of the CSS property. See the CSS property index .
 * @return DOMString A string representing the priority (e.g. "important" ) if one exists. The empty string if none
 * exists.
 * @type String
 */
getPropertyPriority: function(propertyName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Used to retrieve the value of a CSS property if
 * it has been explicitly set within this declaration block.
 * @param {String} propertyName of type DOMString The name of the CSS property. See the CSS property index .
 * @return DOMString Returns the value of the property if it has been explicitly set
 * for this declaration block. Returns the empty string if the
 * property has not been set.
 * @type String
 */
getPropertyValue: function(propertyName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Returns the index th in the list.
 * If index is greater than or equal to the number of
 * media in the list, this returns null .
 * @param {Number} index of type unsigned long Index into the collection.
 * @return DOMString The medium at the index th position in the MediaList , or null if that is not a valid
 * index.
 * @type String
 */
item: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The number of media in the list. The range of valid media is
 * 0 to length-1 inclusive.
 * @type Number
 */
length: undefined,
/**
 * The CSS rule that contains this declaration block or
 * null if this CSSStyleDeclaration is not
 * attached to a CSSRule.
 * @type CSSRule
 */
parentRule: undefined,
/**
 * Used to remove a CSS property if it has been
 * explicitly set within this declaration block.
 * @param {String} propertyName of type DOMString The name of the CSS property. See the CSS property index .
 * @return DOMString Returns the value of the property if it has been explicitly set
 * for this declaration block. Returns the empty string if the
 * property has not been set or the property name does not correspond
 * to a known CSS property.
 * @type String
 */
removeProperty: function(propertyName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Used to set a property value and priority
 * within this declaration block.
 * @param {String} propertyName of type DOMString The name of the CSS property. See the CSS property index .
 * @param {String} value of type DOMString The new value of the property.
 * @param {String} priority of type DOMString The new priority of the property (e.g. "important" ).
 * @type void
 */
setProperty: function(propertyName, value, priority) {
  // This is just a stub for a builtin native JavaScript object.
},
};

