var StyleSheet = {
  // This is just a stub for a builtin native JavaScript object.
/**
 * false if the style sheet is applied to the
 * document. true if it is not. Modifying this attribute
 * may cause a new resolution of style for the document. A stylesheet
 * only applies if both an appropriate medium definition is present
 * and the disabled attribute is false. So, if the media doesn't apply
 * to the current user agent, the disabled attribute is
 * ignored.
 * @type Boolean
 */
disabled: undefined,
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
 * The node that associates this style sheet with the document.
 * For HTML, this may be the corresponding LINK or
 * STYLE element. For XML, it may be the linking
 * processing instruction. For style sheets that are included by other
 * style sheets, the value of this attribute is
 * null.
 * @type Node
 */
ownerNode: undefined,
/**
 * For style sheet languages that support the concept of style
 * sheet inclusion, this attribute represents the including style
 * sheet, if one exists. If the style sheet is a top-level style
 * sheet, or the style sheet language does not support inclusion, the
 * value of this attribute is null.
 * @type StyleSheet
 */
parentStyleSheet: undefined,
/**
 * The advisory title. The title is often specified in the
 * ownerNode. See the 
 * title attribute definition for the LINK
 * element in HTML 4.0, and the title pseudo-attribute for the XML 
 * style sheet processing instruction.
 * @type String
 */
title: undefined,
/**
 * This specifies the style sheet language for this style sheet.
 * The style sheet language is specified as a content type (e.g.
 * "text/css"). The 
 * content type is often specified in the
 * ownerNode. Also see the 
 * type attribute definition for the LINK
 * element in HTML 4.0, and the type pseudo-attribute for the XML style
 * sheet processing instruction.
 * @type String
 */
type: undefined,
};

