var CSSMediaRule = Object.extend(new CSSRule(), {
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
 * The intended destination media for style information. The media
 * is often specified in the ownerNode. If no media has
 * been specified, the MediaList
 * will be empty. See the 
 * media attribute definition for the LINK
 * element in HTML 4.0, and the media pseudo-attribute for the XML 
 * style sheet processing instruction . Modifying the
 * media list may cause a change to the attribute
 * disabled.
 * @type MediaList
 */
media: undefined,
});

