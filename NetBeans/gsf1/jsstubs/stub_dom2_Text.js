var Text = Object.extend(new CharacterData(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Returns whether this text node contains 
 * element content whitespace, often abusively called
 * "ignorable whitespace". The text node is determined to contain
 * whitespace in element content during the load of the document or if
 * validation occurs while using Document.normalizeDocument().
 * @type Boolean
 */
isElementContentWhitespace: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Replaces the text of the current node and all logically-adjacent
 * text nodes with the specified text. All logically-adjacent
 * text nodes are removed including the current node unless it was
 * the recipient of the replacement text. This method returns the node which received the replacement text.
 * The returned node is: null , when the replacement text is the empty
 * string; the current node, except when the current node is read-only ; a new Text node of the same type
 * ( Text or CDATASection ) as the
 * current node inserted at the location of the replacement. For instance, in the above example calling replaceWholeText on the Text node that
 * contains "bar" with "yo" in argument results in the following: Where the nodes to be removed are read-only descendants of an EntityReference ,
 * the EntityReference must be
 * removed instead of the read-only nodes. If any EntityReference to be
 * removed has descendants that are not EntityReference , Text , or CDATASection nodes, the replaceWholeText method must fail before performing
 * any modification of the document, raising a DOMException with the code NO_MODIFICATION_ALLOWED_ERR . For instance, in the example below calling replaceWholeText on the Text node that
 * contains "bar" fails, because the EntityReference node "ent"
 * contains an Element node which cannot
 * be removed.
 * @param {String} content of type DOMString The content of the replacing Text node.
 * @return Text The Text node created with the specified
 * content.
 * @type Text
 */
replaceWholeText: function(content) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Breaks this node into two nodes at the
 * specified offset , keeping both in the tree as siblings . After being split, this
 * node will contain all the content up to the offset point. A new node of the same type, which contains all the content
 * at and after the offset point, is returned. If the
 * original node had a parent node, the new node is inserted as the
 * next sibling of the original
 * node. When the offset is equal to the length of this
 * node, the new node has no data.
 * @param {Number} offset of type unsigned long The 16-bit unit offset at which to split, starting from 0 .
 * @return Text The new node, of the same type as this node.
 * @type Text
 */
splitText: function(offset) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Returns all text of Text nodes logically-adjacent
 * text nodes to this node, concatenated in document order.
 * For instance, in the example below wholeText on the
 * Text node that contains "bar" returns "barfoo", while
 * on the Text node that contains "foo" it returns
 * "barfoo".
 * @type String
 */
wholeText: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
});

