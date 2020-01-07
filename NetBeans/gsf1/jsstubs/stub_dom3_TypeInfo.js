var TypeInfo = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * This method returns if there is a derivation
 * between the reference type definition, i.e. the TypeInfo on which the method is being called, and the
 * other type definition, i.e. the one passed as parameters.
 * @param {String} typeNamespaceArg of type DOMString the namespace of the other type definition.
 * @param {String} typeNameArg of type DOMString the name of the other type definition.
 * @param {Number} derivationMethod of type unsigned long the type of derivation and conditions applied between two
 * types, as described in the list of constants provided in this
 * interface.
 * @return boolean If the document's schema is a DTD or no schema is associated
 * with the document, this method will always return false . If the document's schema is an XML Schema, the method will true if the reference type definition is derived from
 * the other type definition according to the derivation parameter. If
 * the value of the parameter is 0 (no bit is set to 1 for the derivationMethod parameter),
 * the method will return true if the other type
 * definition can be reached by recursing any combination of {base
 * type definition}, {item type definition}, or {member type
 * definitions} from the reference type definition.
 */
isDerivedFrom: function(typeNamespaceArg, typeNameArg,derivationMethod) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The name of a type declared for the associated element or
 * attribute, or null if unknown.
 * @type String
 */
typeName: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * The namespace of the type declared for the associated element
 * or attribute or null if the element does not have
 * declaration or if no namespace information is available.
 * @type String
 */
typeNamespace: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
};

