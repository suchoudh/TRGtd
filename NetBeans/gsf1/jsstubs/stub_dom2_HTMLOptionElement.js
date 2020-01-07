var HTMLOptionElement = Object.extend(new HTMLElement(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * Represents the value of the HTML selected attribute. The value
 * of this attribute does not change if the state of the corresponding
 * form control, in an interactive user agent, changes. See the 
 * selected attribute definition in HTML 4.01.
 * @type Boolean
 */
defaultSelected: undefined,
/**
 * The control is unavailable in this context. See the 
 * disabled attribute definition in HTML 4.01.
 * @type Boolean
 */
disabled: undefined,
/**
 * Returns the FORM element containing this control.
 * Returns null if this control is not within the context
 * of a form.
 * @type HTMLFormElement
 */
form: undefined,
/**
 * The index of this OPTION in its parent
 * SELECT, starting from 0.
 * @type Number
 */
index: undefined,
/**
 * Option label for use in hierarchical menus. See the 
 * label attribute definition in HTML 4.01.
 * @type String
 */
label: undefined,
/**
 * Represents the current state of the corresponding form control,
 * in an interactive user agent. Changing this attribute changes the
 * state of the form control, but does not change the value of the
 * HTML selected attribute of the element.
 * @type Boolean
 */
selected: undefined,
/**
 * The script content of the element.
 * @type String
 */
text: undefined,
/**
 * The value of a run-time parameter. See the 
 * value attribute definition in HTML 4.01.
 * @type String
 */
value: undefined,
});

