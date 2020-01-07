var Entity = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * An attribute specifying the encoding used for this entity at
 * the time of parsing, when it is an external parsed entity. This is
 * null if it an entity from the internal subset or if it
 * is not known.
 * @type String
 */
inputEncoding: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * For unparsed entities, the name of the notation for the entity.
 * For parsed entities, this is null.
 * @type String
 */
notationName: undefined,
/**
 * The public identifier associated with the entity if specified,
 * and null otherwise.
 * @type String
 */
publicId: undefined,
/**
 * The system identifier associated with the entity if specified,
 * and null otherwise. This may be an absolute URI or
 * not.
 * @type String
 */
systemId: undefined,
/**
 * An attribute specifying, as part of the text declaration, the
 * encoding of this entity, when it is an external parsed entity. This
 * is null otherwise.
 * @type String
 */
xmlEncoding: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * An attribute specifying, as part of the text declaration, the
 * version number of this entity, when it is an external parsed
 * entity. This is null otherwise.
 * @type String
 */
xmlVersion: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
});

