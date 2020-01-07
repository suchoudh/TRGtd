var Attr = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Returns whether this attribute is known to be of type ID (i.e.
 * to contain an identifier for its owner element) or not. When it is
 * and its value is unique, the ownerElement of this
 * attribute can be retrieved using the method Document.getElementById.
 * The implementation could use several ways to determine if an
 * attribute node is known to contain an identifier:
 * @type Boolean
 */
isId: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The name of DTD; i.e., the name immediately following the
 * DOCTYPE keyword.
 * @type String
 */
name: undefined,
/**
 * The Element
 * node this attribute is attached to or null if this
 * attribute is not in use.
 * @type Element
 */
ownerElement: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The type information associated with this element.
 * @type TypeInfo
 */
schemaTypeInfo: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * True if this attribute was explicitly given a
 * value in the instance document, false otherwise. If
 * the application changed the value of this attribute node (even if
 * it ends up having the same value as the default value) then it is
 * set to true. The implementation may handle attributes
 * with default values from other schemas similarly but applications
 * should use Document.normalizeDocument()
 * to guarantee this information is up-to-date.
 * @type Boolean
 */
specified: undefined,
/**
 * On retrieval, the value of the attribute is returned as a
 * string. Character and general entity references are replaced with
 * their values. See also the method getAttribute on the
 * Element
 * interface.
 * On setting, this creates a Text node with the
 * unparsed contents of the string, i.e. any characters that an XML
 * processor would recognize as markup are instead treated as literal
 * text. See also the method Element.setAttribute().
 * @type String
 */
value: undefined,
});

