var NodeFilter = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Accept the node. Navigation methods defined for NodeIterator
 * or TreeWalker
 * will return this node.
 * @type Number
 */
FILTER_ACCEPT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Reject the node. Navigation methods defined for NodeIterator
 * or TreeWalker
 * will not return this node. For TreeWalker,
 * the children of this node will also be rejected. NodeIterators
 * treat this as a synonym for FILTER_SKIP.
 * @type Number
 */
FILTER_REJECT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Skip this single node. Navigation methods defined for NodeIterator
 * or TreeWalker
 * will not return this node. For both NodeIterator
 * and TreeWalker,
 * the children of this node will still be considered.
 * @type Number
 */
FILTER_SKIP: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show all Nodes.
 * @type Number
 */
SHOW_ALL: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Attr nodes. This is meaningful only when
 * creating an iterator or tree-walker with an attribute node as its
 * root; in this case, it means that the attribute node
 * will appear in the first position of the iteration or traversal.
 * Since attributes are never children of other nodes, they do not
 * appear when traversing over the document tree.
 * @type Number
 */
SHOW_ATTRIBUTE: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show CDATASection nodes.
 * @type Number
 */
SHOW_CDATA_SECTION: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Comment nodes.
 * @type Number
 */
SHOW_COMMENT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Document nodes.
 * @type Number
 */
SHOW_DOCUMENT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show DocumentFragment nodes.
 * @type Number
 */
SHOW_DOCUMENT_FRAGMENT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show DocumentType nodes.
 * @type Number
 */
SHOW_DOCUMENT_TYPE: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Element nodes.
 * @type Number
 */
SHOW_ELEMENT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Entity nodes. This is meaningful only when
 * creating an iterator or tree-walker with an Entity
 * node as its root; in this case, it means that the
 * Entity node will appear in the first position of the
 * traversal. Since entities are not part of the document tree, they
 * do not appear when traversing over the document tree.
 * @type Number
 */
SHOW_ENTITY: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show EntityReference nodes.
 * @type Number
 */
SHOW_ENTITY_REFERENCE: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Notation nodes. This is meaningful only when
 * creating an iterator or tree-walker with a Notation
 * node as its root; in this case, it means that the
 * Notation node will appear in the first position of the
 * traversal. Since notations are not part of the document tree, they
 * do not appear when traversing over the document tree.
 * @type Number
 */
SHOW_NOTATION: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show ProcessingInstruction nodes.
 * @type Number
 */
SHOW_PROCESSING_INSTRUCTION: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Show Text nodes.
 * @type Number
 */
SHOW_TEXT: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
};

