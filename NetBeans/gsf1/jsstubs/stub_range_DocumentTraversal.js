var DocumentTraversal = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Create a new NodeIterator over the subtree rooted at the specified node.
 * @param {Node} root of type Node The node which will be iterated together with its children. The
 * iterator is initially positioned just before this node. The whatToShow flags and the filter, if any, are not
 * considered when setting this position. The root must not be null .
 * @param {Number} whatToShow of type unsigned long This flag specifies which node types may appear in the logical
 * view of the tree presented by the iterator. See the description of NodeFilter for the set of possible SHOW_ values. These flags can be combined using OR .
 * @param {NodeFilter} filter of type NodeFilter The NodeFilter to be used with this TreeWalker ,
 * or null to indicate no filter.
 * @param {Boolean} entityReferenceExpansion of
 * type boolean The value of this flag determines whether entity reference
 * nodes are expanded.
 * @return NodeIterator The newly created NodeIterator .
 * @type NodeIterator
 */
createNodeIterator: function(root, whatToShow, filter,entityReferenceExpansion) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Create a new TreeWalker over the subtree rooted at the specified node.
 * @param {Node} root of type Node The node which will serve as the root for the TreeWalker .
 * The whatToShow flags and the NodeFilter are not considered when setting this value; any node type will be
 * accepted as the root . The currentNode of
 * the TreeWalker is initialized to this node, whether or not it is visible. The root functions as a stopping point for traversal
 * methods that look upward in the document structure, such as parentNode and nextNode. The root must
 * not be null .
 * @param {Number} whatToShow of type unsigned long This flag specifies which node types may appear in the logical
 * view of the tree presented by the tree-walker. See the description
 * of NodeFilter for the set of possible SHOW_ values. These flags can be combined using OR .
 * @param {NodeFilter} filter of type NodeFilter The NodeFilter to be used with this TreeWalker ,
 * or null to indicate no filter.
 * @param {Boolean} entityReferenceExpansion of
 * type boolean If this flag is false, the contents of EntityReference nodes are not presented in the logical
 * view.
 * @return TreeWalker The newly created TreeWalker .
 * @type TreeWalker
 */
createTreeWalker: function(root, whatToShow, filter,entityReferenceExpansion) { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

