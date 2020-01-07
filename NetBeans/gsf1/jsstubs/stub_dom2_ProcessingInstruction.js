var ProcessingInstruction = Object.extend(new Node(), {
  // This is just a stub for a builtin native JavaScript object.
/**
 * The content of this processing instruction. This is from the
 * first non white space character after the target to the character
 * immediately preceding the ?>.
 * Exceptions on setting
 * @type String
 */
data: undefined,
/**
 * The target of this processing instruction. XML defines this as
 * being the first token
 * following the markup that begins the processing
 * instruction.
 * @type String
 */
target: undefined,
});

