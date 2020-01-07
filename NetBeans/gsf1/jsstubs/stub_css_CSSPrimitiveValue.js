var CSSPrimitiveValue = Object.extend(new CSSValue(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The value is a 
 * attribute function. The value can be obtained by using
 * the getStringValue method.
 * @type Number
 */
CSS_ATTR: undefined,
/**
 * The value is a 
 * length (cm). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_CM: undefined,
/**
 * The value is a 
 * counter or counters function. The value can be
 * obtained by using the getCounterValue method.
 * @type Number
 */
CSS_COUNTER: undefined,
/**
 * The value is an 
 * angle (deg). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_DEG: undefined,
/**
 * The value is a number with an unknown dimension. The value can
 * be obtained by using the getFloatValue method.
 * @type Number
 */
CSS_DIMENSION: undefined,
/**
 * The value is a 
 * length (ems). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_EMS: undefined,
/**
 * The value is a 
 * length (exs). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_EXS: undefined,
/**
 * The value is an 
 * angle (grad). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_GRAD: undefined,
/**
 * The value is a 
 * frequency (Hz). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_HZ: undefined,
/**
 * The value is an 
 * identifier. The value can be obtained by using the
 * getStringValue method.
 * @type Number
 */
CSS_IDENT: undefined,
/**
 * The value is a 
 * length (in). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_IN: undefined,
/**
 * The value is a 
 * frequency (kHz). The value can be obtained by using
 * the getFloatValue method.
 * @type Number
 */
CSS_KHZ: undefined,
/**
 * The value is a 
 * length (mm). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_MM: undefined,
/**
 * The value is a 
 * time (ms). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_MS: undefined,
/**
 * The value is a simple 
 * number. The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_NUMBER: undefined,
/**
 * The value is a 
 * length (pc). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_PC: undefined,
/**
 * The value is a 
 * percentage. The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_PERCENTAGE: undefined,
/**
 * The value is a 
 * length (pt). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_PT: undefined,
/**
 * The value is a 
 * length (px). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_PX: undefined,
/**
 * The value is an 
 * angle (rad). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_RAD: undefined,
/**
 * The value is a 
 * rect function. The value can be obtained by using the
 * getRectValue method.
 * @type Number
 */
CSS_RECT: undefined,
/**
 * The value is a 
 * RGB color. The value can be obtained by using the
 * getRGBColorValue method.
 * @type Number
 */
CSS_RGBCOLOR: undefined,
/**
 * The value is a 
 * time (s). The value can be obtained by using the
 * getFloatValue method.
 * @type Number
 */
CSS_S: undefined,
/**
 * The value is a 
 * STRING. The value can be obtained by using the
 * getStringValue method.
 * @type Number
 */
CSS_STRING: undefined,
/**
 * The value is not a recognized CSS2 value. The value can only be
 * obtained by using the cssText attribute.
 * @type Number
 */
CSS_UNKNOWN: undefined,
/**
 * The value is a 
 * URI. The value can be obtained by using the
 * getStringValue method.
 * @type Number
 */
CSS_URI: undefined,
/**
 * This method is used to get the Counter value.
 * If this CSS value doesn't contain a counter value, a DOMException is raised. Modification to the
 * corresponding style property can be achieved using the Counter interface.
 * @return Counter The Counter value.
 * @type Counter
 */
getCounterValue: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method is used to get a float value in a
 * specified unit. If this CSS value doesn't contain a float value or
 * can't be converted into the specified unit, a DOMException is raised.
 * @param {Number} unitType of type unsigned short A unit code to get the float value. The unit code can only be a
 * float unit type (i.e. CSS_NUMBER , CSS_PERCENTAGE , CSS_EMS , CSS_EXS , CSS_PX , CSS_CM , CSS_MM , CSS_IN , CSS_PT , CSS_PC , CSS_DEG , CSS_RAD , CSS_GRAD , CSS_MS , CSS_S , CSS_HZ , CSS_KHZ , CSS_DIMENSION ).
 * @return float The float value in the specified unit.
 * @type float
 */
getFloatValue: function(unitType) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method is used to get the RGB color. If
 * this CSS value doesn't contain a RGB color value, a DOMException is raised. Modification to the
 * corresponding style property can be achieved using the RGBColor interface.
 * @return RGBColor the RGB color value.
 * @type RGBColor
 */
getRGBColorValue: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method is used to get the Rect value. If
 * this CSS value doesn't contain a rect value, a DOMException is raised. Modification to the
 * corresponding style property can be achieved using the Rect interface.
 * @return Rect The Rect value.
 * @type Rect
 */
getRectValue: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * This method is used to get the string value. If
 * the CSS value doesn't contain a string value, a DOMException is raised. Note: Some properties (like 'font-family' or 'voice-family' ) convert a whitespace separated list of idents
 * to a string.
 * @return DOMString The string value in the current unit. The current primitiveType can only be a string unit type (i.e. CSS_STRING , CSS_URI , CSS_IDENT and CSS_ATTR ).
 * @type String
 */
getStringValue: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * The type of the value as defined by the constants specified
 * above.
 * @type Number
 */
primitiveType: undefined,
/**
 * A method to set the float value with a
 * specified unit. If the property attached with this value can not
 * accept the specified unit or the float value, the value will be
 * unchanged and a DOMException will be raised.
 * @param {Number} unitType of type unsigned short A unit code as defined above. The unit code can only be a float
 * unit type (i.e. CSS_NUMBER , CSS_PERCENTAGE , CSS_EMS , CSS_EXS , CSS_PX , CSS_CM , CSS_MM , CSS_IN , CSS_PT , CSS_PC , CSS_DEG , CSS_RAD , CSS_GRAD , CSS_MS , CSS_S , CSS_HZ , CSS_KHZ , CSS_DIMENSION ).
 * @param {Number} floatValue of type float The new float value.
 * @type void
 */
setFloatValue: function(unitType, floatValue) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * A method to set the string value with the
 * specified unit. If the property attached to this value can't accept
 * the specified unit or the string value, the value will be unchanged
 * and a DOMException will be raised.
 * @param {Number} stringType of type unsigned short A string code as defined above. The string code can only be a
 * string unit type (i.e. CSS_STRING , CSS_URI , CSS_IDENT , and CSS_ATTR ).
 * @param {String} stringValue of type DOMString The new string value.
 * @type void
 */
setStringValue: function(stringType, stringValue) {
  // This is just a stub for a builtin native JavaScript object.
},
});

