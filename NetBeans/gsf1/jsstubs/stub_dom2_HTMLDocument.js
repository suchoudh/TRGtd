var HTMLDocument = Object.extend(new Document(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The absolute URI [IETF RFC 2396] of the
 * document.
 * @type String
 */
URL: undefined,
/**
 * A collection of all the anchor (A) elements in a
 * document with a value for the name attribute. 
 * @type HTMLCollection
 */
anchors: undefined,
/**
 * A collection of all the OBJECT elements that
 * include applets and APPLET (deprecated)
 * elements in a document.
 * @type HTMLCollection
 */
applets: undefined,
/**
 * The element that contains the content for the document. In
 * documents with BODY contents, returns the
 * BODY element. In frameset documents, this returns the
 * outermost FRAMESET element.
 * @type HTMLElement
 */
body: undefined,
/**
 * Closes a document stream opened by open() and forces rendering.
 * @type void
 */
close: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This mutable string attribute denotes persistent state
 * information that (1) is associated with the current frame or
 * document and (2) is composed of information described by the
 * cookies non-terminal of [IETF RFC 2965], Section
 * 4.2.2.
 *  If no persistent state information is available for the current
 * frame or document document, then this property's value is an empty
 * string.
 *  When this attribute is read, all cookies are returned as a single
 * string, with each cookie's name-value pair concatenated into a list
 * of name-value pairs, each list item being separated by a ';'
 * (semicolon).
 *  When this attribute is set, the value it is set to should be a
 * string that adheres to the cookie non-terminal of [IETF RFC
 * 2965]; that is, it should be a single name-value pair followed
 * by zero or more cookie attribute values. If no domain attribute is
 * specified, then the domain attribute for the new value defaults to
 * the host portion of an absolute URI [IETF RFC 2396] of the current
 * frame or document. If no path attribute is specified, then the path
 * attribute for the new value defaults to the absolute path portion
 * of the URI [IETF RFC 2396] of the current
 * frame or document. If no max-age attribute is specified, then the
 * max-age attribute for the new value defaults to a user agent
 * defined value. If a cookie with the specified name is already
 * associated with the current frame or document, then the new value
 * as well as the new attributes replace the old value and attributes.
 * If a max-age attribute of 0 is specified for the new value, then
 * any existing cookies of the specified name are removed from the
 * cookie storage. 
 * @type String
 */
cookie: undefined,
/**
 * The domain name of the server that served the document, or
 * null if the server cannot be identified by a domain
 * name.
 * @type String
 */
domain: undefined,
/**
 * A collection of all the forms of a document.
 * @type HTMLCollection
 */
forms: undefined,
/**
 * Returns the Element whose id is
 * given by elementId. If no such element exists, returns null . Behavior is not defined if more than one element
 * has this id . elementId The unique id value for an element. Return Value The matching element. This method raises no exceptions.
 * @type Element
 * @param {DOMString} elementId
 */
getElementById: function(elementId) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * With [ HTML 4.01 ] documents, this method
 * returns the (possibly empty) collection of elements whose name value is given by elementName . In
 * [ XHTML
 * 1.0 ] documents, this methods only return the (possibly empty)
 * collection of form controls with matching name. This method is case
 * sensitive.
 * @param {String} elementName of type DOMString The name attribute value for an element.
 * @return NodeList The matching elements.
 * @type NodeList
 */
getElementsByName: function(elementName) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * A collection of all the IMG elements in a
 * document. The behavior is limited to IMG elements for
 * backwards compatibility. 
 * @type HTMLCollection
 */
images: undefined,
/**
 * A collection of all AREA elements and anchor
 * (A) elements in a document with a value for the
 * href attribute.
 * @type HTMLCollection
 */
links: undefined,
/**
 * Open a document stream for writing. If a
 * document exists in the target, this method clears it. Note: This method and the ones following allow a user to
 * add to or replace the structure model of a document using strings
 * of unparsed HTML. At the time of writing alternate methods for
 * providing similar functionality for both HTML and XML documents
 * were being considered (see [ DOM Level 3 Load and Save ]).
 * @type void
 */
open: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Returns the URI [IETF RFC 2396] of the page that
 * linked to this page. The value is an empty string if the user
 * navigated to the page directly (not through a link, but, for
 * example, via a bookmark).
 * @type String
 */
referrer: undefined,
/**
 * The element's advisory title. See the 
 * title attribute definition in HTML 4.01.
 * @type String
 */
title: undefined,
/**
 * Write a string of text to a document stream
 * opened by open() . Note that the function will produce
 * a document which is not necessarily driven by a DTD and therefore
 * might be produce an invalid result in the context of the document.
 * @param {String} text of type DOMString The string to be parsed into some structure in the document
 * structure model.
 * @type void
 */
write: function(text) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Write a string of text followed by a newline
 * character to a document stream opened by open() . Note
 * that the function will produce a document which is not necessarily
 * driven by a DTD and therefore might be produce an invalid result in
 * the context of the document
 * @param {String} text of type DOMString The string to be parsed into some structure in the document
 * structure model.
 * @type void
 */
writeln: function(text) {
  // This is just a stub for a builtin native JavaScript object.
},
});

