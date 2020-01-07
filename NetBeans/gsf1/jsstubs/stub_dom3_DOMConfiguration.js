var DOMConfiguration = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Check if setting a parameter to a specific
 * value is supported.
 * @param {String} name of type DOMString The name of the parameter to check.
 * @param {Object} value of type DOMUserData An object. if null , the returned value is true .
 * @return boolean true if the parameter could be successfully set to
 * the specified value, or false if the parameter is not
 * recognized or the requested value is not supported. This does not
 * change the current value of the parameter itself.
 */
canSetParameter: function(name, value) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Return the value of a parameter if known.
 * @param {String} name of type DOMString The name of the parameter.
 * @return DOMUserData The current object associated with the specified parameter or null if no object has been associated or if the
 * parameter is not supported.
 * @type Object
 */
getParameter: function(name) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The list of the parameters supported by this
 * DOMConfiguration object and for which at least one
 * value can be set by the application. Note that this list can also
 * contain parameter names defined outside this
 * specification.
 * @type DOMStringList
 */
parameterNames: undefined, // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/**
 * Set the value of a parameter.
 * @param {String} name of type DOMString The name of the parameter to set.
 * @param {Object} value of type DOMUserData The new value or null if the user wishes to unset
 * the parameter. While the type of the value parameter is defined as DOMUserData , the object
 * type must match the type defined by the definition of the
 * parameter. For example, if the parameter is "error-handler" , the value
 * must be of type DOMErrorHandler .
 * @type void
 */
setParameter: function(name, value) { // COMPAT=IE7|FF1|FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

