var CSSImportRule = Object.extend(new CSSRule(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * If the style sheet is a linked style sheet, the value of its
 * attribute is its location. For inline style sheets, the value of
 * this attribute is null. See the 
 * href attribute definition for the LINK
 * element in HTML 4.0, and the href pseudo-attribute for the XML 
 * style sheet processing instruction.
 * @type String
 */
href: undefined,
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
/**
 * The style sheet referred to by this rule, if it has been
 * loaded. The value of this attribute is null if the
 * style sheet has not yet been loaded or if it will not be loaded
 * (e.g. if the style sheet is for a media type not supported by the
 * user agent).
 * @type CSSStyleSheet
 */
styleSheet: undefined,
});

