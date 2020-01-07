var CSSStyleSheet = Object.extend(new StyleSheet(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * A list of all CSS rules contained within the media block.
 * @type CSSRuleList
 */
cssRules: undefined,
/**
 * Used to delete a rule from the media block.
 * @param {Number} index of type unsigned long The index within the media block's rule collection of the rule
 * to remove.
 * @type void
 */
deleteRule: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * Used to insert a new rule into the media block.
 * @param {String} rule of type DOMString The parsable text representing the rule. For rule sets this
 * contains both the selector and the style declaration. For at-rules,
 * this specifies both the at-identifier and the rule content.
 * @param {Number} index of type unsigned long The index within the media block's rule collection of the rule
 * before which to insert the specified rule. If the specified index
 * is equal to the length of the media blocks's rule collection, the
 * rule will be added to the end of the media block.
 * @return unsigned long The index within the media block's rule collection of the newly
 * inserted rule.
 * @type Number
 */
insertRule: function(rule, index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
 * If this style sheet comes from an @import rule,
 * the ownerRule attribute will contain the CSSImportRule.
 * In that case, the ownerNode attribute in the StyleSheet
 * interface will be null. If the style sheet comes from
 * an element or a processing instruction, the ownerRule
 * attribute will be null and the ownerNode
 * attribute will contain the Node.
 * @type CSSRule
 */
ownerRule: undefined,
});

