var NamedNodeMap = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Retrieves a node specified by name.
 * @param {String} name of type DOMString The nodeName of a node to retrieve.
 * @return Node A Node (of any type) with
 * the specified nodeName , or null if it
 * does not identify any node in this map.
 * @type Node
 */
getNamedItem: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Retrieves a node specified by local name and
 * namespace URI. Per [ XML Namespaces ],
 * applications must use the value null as the namespaceURI parameter
 * for methods if they wish to have no namespace.
 * @param {String} namespaceURI of type DOMString The namespace URI of the node to retrieve.
 * @param {String} localName of type DOMString The local name of the
 * node to retrieve.
 * @return Node A Node (of any type) with
 * the specified local name and namespace URI, or null if
 * they do not identify any node in this map.
 * @type Node
 */
getNamedItemNS: function(namespaceURI, localName) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Returns the index th item in the
 * map. If index is greater than or equal to the number
 * of nodes in this map, this returns null .
 * @param {Number} index of type unsigned long Index into this map.
 * @return Node The node at the index th position in the map, or null if that is not a valid index.
 * @type Node
 */
item: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The number of 16-bit
 * units that are available through data and the
 * substringData method below. This may have the value
 * zero, i.e., CharacterData nodes may be
 * empty.
 * @type Number
 */
length: undefined,
/**
 * Removes a node specified by name. When this map
 * contains the attributes attached to an element, if the removed
 * attribute is known to have a default value, an attribute
 * immediately appears containing the default value as well as the
 * corresponding namespace URI, local name, and prefix when
 * applicable.
 * @param {String} name of type DOMString The nodeName of the node to remove.
 * @return Node The node removed from this map if a node with such a name
 * exists.
 * @type Node
 */
removeNamedItem: function(name) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Removes a node specified by local name and
 * namespace URI. A removed attribute may be known to have a default
 * value when this map contains the attributes attached to an element,
 * as returned by the attributes attribute of the Node interface. If so,
 * an attribute immediately appears containing the default value as
 * well as the corresponding namespace URI, local name, and prefix
 * when applicable. Per [ XML Namespaces ],
 * applications must use the value null as the namespaceURI parameter
 * for methods if they wish to have no namespace.
 * @param {String} namespaceURI of type DOMString The namespace URI of the node to remove.
 * @param {String} localName of type DOMString The local name of the
 * node to remove.
 * @return Node The node removed from this map if a node with such a local name
 * and namespace URI exists.
 * @type Node
 */
removeNamedItemNS: function(namespaceURI, localName) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Adds a node using its nodeName attribute. If a node with that name is already present in this map,
 * it is replaced by the new one. Replacing a node by itself has no
 * effect. As the nodeName attribute is used to derive the name
 * which the node must be stored under, multiple nodes of certain
 * types (those that have a "special" string value) cannot be stored
 * as the names would clash. This is seen as preferable to allowing
 * nodes to be aliased.
 * @param {Node} arg of type Node A node to store in this map. The node will later be accessible
 * using the value of its nodeName attribute.
 * @return Node If the new Node replaces an
 * existing node the replaced Node is returned,
 * otherwise null is returned.
 * @type Node
 */
setNamedItem: function(arg) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Adds a node using its namespaceURI and localName . If a node with that namespace URI and
 * that local name is already present in this map, it is replaced by
 * the new one. Replacing a node by itself has no effect. Per [ XML Namespaces ],
 * applications must use the value null as the namespaceURI parameter
 * for methods if they wish to have no namespace.
 * @param {Node} arg of type Node A node to store in this map. The node will later be accessible
 * using the value of its namespaceURI and localName attributes.
 * @return Node If the new Node replaces an
 * existing node the replaced Node is returned,
 * otherwise null is returned.
 * @type Node
 */
setNamedItemNS: function(arg) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

