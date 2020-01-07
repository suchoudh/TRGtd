var DOMError = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The location of the error.
 * @type DOMLocator
 */
location: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * An implementation specific string describing the error that
 * occurred.
 * @type String
 */
message: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The related DOMError.type
 * dependent data if any.
 * @type Object
 */
relatedData: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The related platform dependent exception if any.
 * @type Object
 */
relatedException: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The severity of the error, either
 * SEVERITY_WARNING, SEVERITY_ERROR, or
 * SEVERITY_FATAL_ERROR.
 * @type Number
 */
severity: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * A DOMString
 * indicating which related data is expected in
 * relatedData. Users should refer to the specification
 * of the error in order to find its DOMString type and
 * relatedData definitions if any.
 * Note: As an example, Document.normalizeDocument()
 * does generate warnings when the "split-cdata-sections"
 * parameter is in use. Therefore, the method generates a
 * SEVERITY_WARNING with type
 * "cdata-sections-splitted" and the first CDATASection node in
 * document order resulting from the split is returned by the
 * relatedData attribute.
 * @type String
 */
type: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
};

