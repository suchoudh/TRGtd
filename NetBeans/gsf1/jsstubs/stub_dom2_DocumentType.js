var DocumentType = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * A NamedNodeMap containing
 * the general entities, both external and internal, declared in the
 * DTD. Parameter entities are not contained. Duplicates are
 * discarded. For example in:
 * @type NamedNodeMap
 */
entities: undefined,
/**
 * The internal subset as a string, or null if there
 * is none. This is does not contain the delimiting square brackets.
 * Note: The actual content returned depends on how much
 * information is available to the implementation. This may vary
 * depending on various parameters, including the XML processor used
 * to build the document.
 * @type String
 */
internalSubset: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The name of DTD; i.e., the name immediately following the
 * DOCTYPE keyword.
 * @type String
 */
name: undefined,
/**
 * A NamedNodeMap containing
 * the notations declared in the DTD. Duplicates are discarded. Every
 * node in this map also implements the Notation interface.
 * The DOM Level 2 does not support editing notations, therefore
 * notations cannot be altered in any way.
 * @type NamedNodeMap
 */
notations: undefined,
/**
 * The public identifier associated with the entity if specified,
 * and null otherwise.
 * @type String
 */
publicId: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The system identifier associated with the entity if specified,
 * and null otherwise. This may be an absolute URI or
 * not.
 * @type String
 */
systemId: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
});

