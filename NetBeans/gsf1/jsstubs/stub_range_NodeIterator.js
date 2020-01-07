var NodeIterator = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Detaches the NodeIterator from the
 * set which it iterated over, releasing any computational resources
 * and placing the iterator in the INVALID state. After detach has been invoked, calls to nextNode or previousNode will raise the
 * exception INVALID_STATE_ERR.
 * @type void
 */
detach: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The value of this flag determines whether the children of
 * entity reference nodes are visible to the TreeWalker.
 * If false, they and their descendants will be
 * rejected. Note that this rejection takes precedence over
 * whatToShow and the filter, if any.
 *  To produce a view of the document that has entity references
 * expanded and does not expose the entity reference node itself, use
 * the whatToShow flags to hide the entity reference node
 * and set expandEntityReferences to true when creating
 * the TreeWalker. To produce a view of the document that
 * has entity reference nodes but no entity expansion, use the
 * whatToShow flags to show the entity reference node and
 * set expandEntityReferences to false.
 * @type Boolean
 */
expandEntityReferences: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The filter used to screen nodes.
 * @type NodeFilter
 */
filter: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Moves the TreeWalker to the next
 * visible node in document order relative to the current node, and
 * returns the new node. If the current node has no next node, or if
 * the search for nextNode attempts to step upward from the TreeWalker 's root node, returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * next node in the TreeWalker 's logical view.
 * @type Node
 */
nextNode: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Moves the TreeWalker to the
 * previous visible node in document order relative to the current
 * node, and returns the new node. If the current node has no previous
 * node, or if the search for previousNode attempts to
 * step upward from the TreeWalker 's root node, returns null , and retains the current node.
 * @return Node The new node, or null if the current node has no
 * previous node in the TreeWalker 's logical view.
 * @type Node
 */
previousNode: function() { // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The root node of the TreeWalker, as
 * specified when it was created.
 * @type Node
 */
root: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * This attribute determines which node types are presented via
 * the TreeWalker. The available set of constants is
 * defined in the NodeFilter
 * interface. Nodes not accepted by whatToShow will be
 * skipped, but their children may still be considered. Note that this
 * skip takes precedence over the filter, if any.
 * @type Number
 */
whatToShow: undefined, // COMPAT=FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
};

