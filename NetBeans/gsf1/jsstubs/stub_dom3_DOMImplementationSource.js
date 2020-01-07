var DOMImplementationSource = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * A method to request the first DOM
 * implementation that supports the specified features.
 * @param {String} features of type DOMString A string that specifies which features and versions are
 * required. This is a space separated list in which each feature is
 * specified by its name optionally followed by a space and a version
 * number. This method returns the first item of the list returned by getDOMImplementationList . As an example, the string "XML 3.0 Traversal +Events
 * 2.0" will request a DOM implementation that supports the
 * module "XML" for its 3.0 version, a module that support of the
 * "Traversal" module for any version, and the module "Events" for its
 * 2.0 version. The module "Events" must be accessible using the
 * method Node.getFeature() and DOMImplementation.getFeature() .
 * @return DOMImplementation The first DOM implementation that support the desired features,
 * or null if this source has none.
 * @type DOMImplementation
 */
getDOMImplementation: function(features) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * A method to request a list of DOM
 * implementations that support the specified features and versions,
 * as specified in DOM Features .
 * @param {String} features of type DOMString A string that specifies which features and versions are
 * required. This is a space separated list in which each feature is
 * specified by its name optionally followed by a space and a version
 * number. This is something like: "XML 3.0 Traversal +Events
 * 2.0"
 * @return DOMImplementationList A list of DOM implementations that support the desired
 * features.
 * @type DOMImplementationList
 */
getDOMImplementationList: function(features) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

