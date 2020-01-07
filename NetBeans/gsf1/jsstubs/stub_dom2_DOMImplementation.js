var DOMImplementation = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Creates a DOM Document object of the specified
 * type with its document element. Note that based on the DocumentType given to
 * create the document, the implementation may instantiate specialized Document objects
 * that support additional features than the "Core", such as "HTML"
 * [ DOM Level 2 HTML ]. On the
 * other hand, setting the DocumentType after the
 * document was created makes this very unlikely to happen.
 * Alternatively, specialized Document creation methods,
 * such as createHTMLDocument [ DOM Level 2
 * HTML ], can be used to obtain specific types of Document objects.
 * @param {String} namespaceURI of type DOMString The namespace URI of the document element to create or null .
 * @param {String} qualifiedName of type DOMString The qualified name of the document element to be created or null .
 * @param {DocumentType} doctype of type DocumentType The type of document to be created or null . When doctype is not null , its Node.ownerDocument attribute is set to the document being created.
 * @return Document A new Document object with its
 * document element. If the NamespaceURI , qualifiedName , and doctype are null , the returned Document is empty with no
 * document element.
 * @type Document
 */
createDocument: function(namespaceURI, qualifiedName,doctype) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Creates an empty DocumentType node. Entity
 * declarations and notations are not made available. Entity reference
 * expansions and default attribute additions do not occur..
 * @param {String} qualifiedName of type DOMString The qualified name of the document type to be created.
 * @param {String} publicId of type DOMString The external subset public identifier.
 * @param {String} systemId of type DOMString The external subset system identifier.
 * @return DocumentType A new DocumentType node with Node.ownerDocument set
 * to null .
 * @type DocumentType
 
 * @type DocumentType
*/
createDocumentType: function(qualifiedName, publicId,systemId) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method returns a specialized object which
 * implements the specialized APIs of the specified feature and
 * version, as specified in DOM
 * Features . The specialized object may also be obtained by using
 * binding-specific casting methods but is not necessarily expected
 * to, as discussed in Mixed DOM
 * Implementations . This method also allow the implementation to
 * provide specialized objects which do not support the Node interface.
 * @param {String} feature of type DOMString The name of the feature requested. Note that any plus sign "+"
 * prepended to the name of the feature will be ignored since it is
 * not significant in the context of this method.
 * @param {String} version of type DOMString This is the version number of the feature to test.
 * @return DOMObject Returns an object which implements the specialized APIs of the
 * specified feature and version, if any, or null if
 * there is no object which implements interfaces associated with that
 * feature. If the DOMObject returned by this
 * method implements the Node interface, it must delegate
 * to the primary core Node and not return results
 * inconsistent with the primary core Node such as
 * attributes, childNodes, etc.
 * @type Object
 */
getFeature: function(feature, version) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Test if the DOM implementation implements a
 * specific feature and version, as specified in DOM Features .
 * @param {String} feature of type DOMString The name of the feature to test.
 * @param {String} version of type DOMString This is the version number of the feature to test.
 * @return boolean true if the feature is implemented in the specified
 * version, false otherwise.
 
 * @type Boolean
*/
hasFeature: function(feature, version) {
  // This is just a stub for a builtin native JavaScript object.
},
};

