var CharacterData = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Append the string to the end of the character
 * data of the node. Upon success, data provides access
 * to the concatenation of data and the DOMString specified.
 * @param {String} arg of type DOMString The DOMString to
 * append.
 * @type void
 */
appendData: function(arg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The content of this processing instruction. This is from the
 * first non white space character after the target to the character
 * immediately preceding the ?>.
 * Exceptions on setting
 * @type String
 */
data: undefined,
/**
 * Remove a range of 16-bit units from the node. Upon
 * success, data and length reflect the
 * change.
 * @param {Number} offset of type unsigned long The offset from which to start removing.
 * @param {Number} count of type unsigned long The number of 16-bit units to delete. If the sum of offset and count exceeds length then all 16-bit units from offset to the end of the data are deleted.
 * @type void
 */
deleteData: function(offset, count) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Insert a string at the specified 16-bit unit offset.
 * @param {Number} offset of type unsigned long The character offset at which to insert.
 * @param {String} arg of type DOMString The DOMString to
 * insert.
 * @type void
 */
insertData: function(offset, arg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The number of 16-bit
 * units that are available through data and the
 * substringData method below. This may have the value
 * zero, i.e., CharacterData nodes may be
 * empty.
 * @type Number
 */
length: undefined,
/**
 * Replace the characters starting at the
 * specified 16-bit unit offset with the specified string.
 * @param {Number} offset of type unsigned long The offset from which to start replacing.
 * @param {Number} count of type unsigned long The number of 16-bit units to replace. If the sum of offset and count exceeds length , then all 16-bit units to the end of the data
 * are replaced; (i.e., the effect is the same as a remove method call with the same range, followed by an append method invocation).
 * @param {String} arg of type DOMString The DOMString with which the
 * range must be replaced.
 * @type void
 */
replaceData: function(offset, count, arg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Extracts a range of data from the node.
 * @param {Number} offset of type unsigned long Start offset of substring to extract.
 * @param {Number} count of type unsigned long The number of 16-bit units to extract.
 * @return DOMString The specified substring. If the sum of offset and count exceeds the length , then all 16-bit
 * units to the end of the data are returned.
 
 * @type String
*/
substringData: function(offset, count) {
  // This is just a stub for a builtin native JavaScript object.
},
});

