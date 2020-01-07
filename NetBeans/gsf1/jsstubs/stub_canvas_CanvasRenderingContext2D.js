var CanvasRenderingContext2D = {
  // This is just a stub for a builtin native JavaScript object.
/** The arc(x, y, radius, startAngle, endAngle, anticlockwise) method draws an arc. If the context has any subpaths, then the method will add a straight line from the last point in the subpath to the start point of the arc. In any case, it must draw the arc between the start point of the arc and the end point of the arc, and add the start and end points of the arc to the subpath.
@param {Number} x
 @param {Number} y
@param {Number} radius
 @param {Number} startAngle
@param {Number} endAngle
@param {Boolean} anticlockwise
* @type void
*/
arc: function(x,y,radius,startAngle,endAngle,anticlockwise) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The arcTo(x1, y1, x2, y2, radius) method will do nothing if the context has no subpaths. If the context does have a subpath, then the behavior depends on the arguments and the last point in the subpath.
@param {Number} x1
 @param {Number} y1
@param {Number} x2
 @param {Number} y2
@param {Number} radius
* @type void
*/
arcTo: function(x1,y1,x2,y2,radius) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The beginPath() method will empty the list of subpaths so that the context once again has zero subpaths.
@type void
*/
beginPath: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y) method will do nothing if the context has no subpaths. Otherwise, it must connect the last point in the subpath to the given point (x, y) using a cubic BŽzier curve with control points (cp1x, cp1y) and (cp2x, cp2y). Then, it must add the point (x, y) to the subpath.
@param {Number} cp1x
 @param {Number} cp1y
@param {Number} cp2x
 @param {Number} cp2y
@param {Number} x
 @param {Number} y
* @type void
*/
bezierCurveTo: function(cp1x, cp1y, cp2x, cp2y, x, y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** @type HTMLCanvasElement */
canvas: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The clearRect(x, y, w, h) method will clear the pixels in the specified rectangle that also intersect the current clipping region to a fully transparent black, erasing any previous image. If either height or width are zero, this method has no effect.
@param {Number} x
 @param {Number} y
 @param {Number} w
 @param {Number} h
* @type void
*/
clearRect: function(x, y, w, h) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The clip()  method will create a new clipping region by calculating the intersection of the current clipping region and the area described by the current path, using the non-zero winding number rule. Open subpaths must be implicitly closed when computing the clipping region, without affecting the actual subpaths. The new clipping region replaces the current clipping region.
@type void
*/
clip: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The closePath() method will do nothing if the context has no subpaths. Otherwise, it must mark the last subpath as closed, create a new subpath whose first point is the same as the previous subpath's first point, and finally add this new subpath to the path. (If the last subpath had more than one point in its list of points, then this is equivalent to adding a straight line connecting the last point back to the first point, thus "closing" the shape, and then repeating the last moveTo() call.)
@type void
*/
closePath: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The createImageData(sw, sh) method will return an ImageData object representing a rectangle with a width in CSS pixels equal to the absolute magnitude of sw and a height in CSS pixels equal to the absolute magnitude of sh, filled with transparent black.
@param {Number} sw
@param {Number} sh
* @type ImageData
*/
createImageData: function(sw,sh) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The createLinearGradient(x0, y0, x1, y1) method takes four arguments that, after being subjected to the current transformation matrix, represent the start point (x0, y0) and end point (x1, y1) of the gradient. If any of the arguments to createLinearGradient() are infinite or NaN, the method will raise an INDEX_SIZE_ERR  exception. Otherwise, the method will return a linear CanvasGradient initialised with the specified line.
@param {Number} x0
 @param {Number} y0
 @param {Number} x1
 @param {Number} y1
* @type CanvasGradient
*/
createLinearGradient: function(x0, y0, x1, y1) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** Patterns are represented by objects implementing the opaque CanvasPattern interface. To create objects of this type, the createPattern(image, repetition) method is used. The first argument gives the image to use as the pattern (either an HTMLImageElement or an HTMLCanvasElement). Modifying this image after calling the createPattern() method will not affect the pattern. The second argument must be a string with one of the following values: repeat, repeat-x, repeat-y, no-repeat. If the empty string or null is specified, repeat must be assumed. If an unrecognised value is given, then the user agent must raise a SYNTAX_ERR exception. User agents must recognise the four values described above exactly (e.g. they must not do case folding). The method will return a CanvasPattern object suitably initialised. 
@param {HTMLImageElement|HTMLCanvasElement} image
 @param {String} repetition
* @type CanvasPattern
*/
createPattern: function(image, repetition) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The createRadialGradient(x0, y0, r0, x1, y1, r1) method takes six arguments, the first three representing the start circle with origin (x0, y0) and radius r0, and the last three representing the end circle with origin (x1, y1) and radius r1. The values are in coordinate space units. If either of r0 or r1 are negative, or if any of the arguments are infinite or NaN, an INDEX_SIZE_ERR exception must be raised. Otherwise, the method will return a radial CanvasGradient initialised with the two specified circles, after transforming them according to the current transformation matrix.
@param {Number} x0
 @param {Number} y0
 @param {Number} x1
 @param {Number} y1
@param {Number} r0
@param {Number} r1
* @type CanvasGradient
*/
createRadialGradient: function(x0, y0, r0, x1, y1, r1) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** To draw images onto the canvas, the drawImage method can be used.
 @param {HTMLImageElement|HTMLCanvasElement} image
 @param {Number} dx
@param {Number} dy
* @type void
*/
drawImage: function(image,dx,dy) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** To draw images onto the canvas, the drawImage method can be used.
The source rectangle is the rectangle whose corners are the four points (sx, sy), (sx+sw, sy), (sx+sw, sy+sh), (sx, sy+sh).
The destination rectangle is the rectangle whose corners are the four points (dx, dy), (dx+dw, dy), (dx+dw, dy+dh), (dx, dy+dh).
@param {HTMLImageElement|HTMLCanvasElement} image
 @param {Number} sx
@param {Number} sy
 @param {Number} sw
@param {Number} sh
@param {Number} dx
@param {Number} dy
 @param {Number} dw
@param {Number} dh
* @type void
*/
drawImage: function(image,sx,sy,sw,sh,dx,dy,dw,dh) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** To draw images onto the canvas, the drawImage method can be used.
The destination rectangle is the rectangle whose corners are the four points (dx, dy), (dx+dw, dy), (dx+dw, dy+dh), (dx, dy+dh).
@param {HTMLImageElement|HTMLCanvasElement} image
 @param {Number} dx
@param {Number} dy
 @param {Number} dw
@param {Number} dh
* @type void
*/
drawImage: function(image,dx,dy,dw,dh) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The fill()  method will fill all the subpaths of the current path, using fillStyle, and using the non-zero winding number rule. Open subpaths must be implicitly closed when being filled (without affecting the actual subpaths).
@type void
*/
fill: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The fillRect(x, y, w, h) method will paint the specified rectangular area using the fillStyle. If either height or width are zero, this method has no effect.
@param {Number} x
 @param {Number} y
 @param {Number} w
 @param {Number} h
* @type void
*/
fillRect: function(x,y,w,h) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The fillStyle attribute represents the color or style to use inside the shapes.
@default black */
fillStyle: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The getImageData(sx, sy, sw, sh) method will return an ImageData object representing the underlying pixel data for the area of the canvas denoted by the rectanglewhose corners are the four points (sx, sy), (sx+sw, sy), (sx+sw, sy+sh), (sx, sy+sh), in canvas coordinate space units. Pixels outside the canvas must be returned as transparent black. Pixels must be returned as non-premultiplied alpha values.
@param {Number} sx
@param {Number} sy
@param {Number} sw
@param {Number} sh
* @type ImageData
*/
getImageData: function(sx,sy,sw,sh) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The globalAlpha attribute gives an alpha value that is applied to shapes and images before they are composited onto the canvas. The value must be in the range from 0.0 (fully transparent) to 1.0 (no additional transparency). If an attempt is made to set the attribute to a value outside this range, the attribute must retain its previous value. When the context is created, the globalAlpha attribute must initially have the value 1.0.
@type Number
@default 1.0 */
globalAlpha: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The globalCompositeOperation  attribute sets how shapes and images are drawn onto the existing bitmap, once they have had globalAlpha and the current transformation matrix applied. It must be set to a value from the following list. In the descriptions below, the source image, A, is the shape or image being rendered, and the destination image, B, is the current state of the bitmap.
@type String
@default source-over */
globalCompositeOperation: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The isPointInPath(x, y) method will return true if the point given by the x and y coordinates passed to the method, when treated as coordinates in the canvas coordinate space unaffected by the current transformation, is inside the current path; and must return false otherwise. Points on the path itself are considered to be inside the path. If either of the arguments is infinite or NaN, then the method will return false.
@param {Number} x
@param {Number} y
 @type Boolean
*/
isPointInPath: function(x,y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The lineCap attribute defines the type of endings that UAs will place on the end of lines. The three valid values are butt, round, and square. The butt value means that the end of each line is a flat edge perpendicular to the direction of the line. The round value means that a semi-circle with the diameter equal to the width of the line must then be added on to the end of the line. The square value means that a rectangle with the length of the line width and the width of half the line width, placed flat against the edge perpendicular to the direction of the line, must be added at the end of each line. On setting, any other value than the literal strings butt, round, and square must be ignored, leaving the value unchanged.
"butt", "round", "square"
@type String
@default "butt" */
lineCap: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The lineJoin attribute defines the type of corners that UAs will place where two lines meet. The three valid values are bevel, round, and miter.
"round", "bevel", "miter"
 @type String
@default "miter" */
lineJoin: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The lineTo(x, y) method will do nothing if the context has no subpaths. Otherwise, it must connect the last point in the subpath to the given point (x, y) using a straight line, and must then add the given point (x, y) to the subpath.
@param {Number} x
 @param {Number} y
* @type void
*/
lineTo: function(x, y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The lineWidth attribute gives the width of lines, in coordinate space units. On setting, zero, negative, infinite, and NaN values must be ignored, leaving the value unchanged.
 @type Number
@default 1 */
lineWidth: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** pop state stack and restore state
* @type void
*/
load: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** @type Number
@default 10 */
miterLimit: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The moveTo(x, y) method will create a new subpath with the specified point as its first (and only) point.
@param {Number} x
 @param {Number} y
* @type void
*/
moveTo: function(x, y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The putImageData(imagedata, dx, dy, dirtyX, dirtyY, dirtyWidth, dirtyHeight)  method writes data from ImageData  structures back to the canvas.
@param {ImageData} imagedata
@param {Number} dx
@param {Number} dy
@param {Number} dirtyX
@param {Number} dirtyY
@param {Number} dirtyWidth
@param {Number} dirtyHeight
* @type void
*/
putImageData: function(imagedata,dx,dy,dirtyX,dirtyY,dirtyWidth,dirtyHeight) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** @param {ImageData} imagedata
@param {Number} dx
@param {Number} dy
* @type void
*/
putImageData: function(imagedata,dx,dy) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The quadraticCurveTo(cpx, cpy, x, y) method will do nothing if the context has no subpaths. Otherwise it must connect the last point in the subpath to the given point (x, y) using a quadratic BŽzier curve with control point (cpx, cpy), and must then add the given point (x, y) to the subpath.
@param {Number} cpx
 @param {Number} cpy
@param {Number} x
 @param {Number} y
* @type void
*/
quadraticCurveTo: function(cpx, cpy, x, y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The rect(x, y, w, h) method will create a new subpath containing just the four points (x, y), (x+w, y), (x+w, y+h), (x, y+h), with those four points connected by straight lines, and must then mark the subpath as closed. It must then create a new subpath with the point (x, y) as the only point in the subpath.
@param {Number} x
 @param {Number} y
 @param {Number} w
 @param {Number} h
* @type void
*/
rect: function(x,y,w,h) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The rotate(angle) method will add the rotation transformation described by the argument to the transformation matrix. The angle argument represents a clockwise rotation angle expressed in radians. If the angle argument is infinite, the method call must be ignored.
@param {Number} angle
* @type void
*/
rotate: function(x,y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** push state on state stack
* @type void
*/
save: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The scale(x, y) method will add the scaling transformation described by the arguments to the transformation matrix. The x argument represents the scale factor in the horizontal direction and the y argument represents the scale factor in the vertical direction. The factors are multiples.
  @param {Number} x
@param {Number} y
* @type void
*/
scale: function(x,y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The setTransform(m11, m12, m21, m22, dx, dy) method will reset the current transform to the identity matrix, and then invoke the transform(m11, m12, m21, m22, dx, dy) method with the same arguments.
@param {Number} m11
 @param {Number} m12
 @param {Number} m21
 @param {Number} m22
@param {Number} dx
@param {Number} dy
* @type void
*/
setTransform: function(m11, m12, m21, m22, dx, dy) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The shadowBlur attribute specifies the size of the blurring effect. (The units do not map to coordinate space units, and are not affected by the current transformation matrix.)
@type Number
@default 0 */
shadowBlur: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The shadowColor attribute sets the color of the shadow.
@type String
@default transparent black */
shadowColor: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The shadowOffsetX and shadowOffsetY  attributes specify the distance that the shadow will be offset in the positive horizontal and positive vertical distance respectively. Their values are in coordinate space units. They are not affected by the current transformation matrix.
@type Number
@default 0 */
shadowOffsetX: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The shadowOffsetX and shadowOffsetY  attributes specify the distance that the shadow will be offset in the positive horizontal and positive vertical distance respectively. Their values are in coordinate space units. They are not affected by the current transformation matrix.
@type Number
@default 0 */
shadowOffsetY: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The stroke() method will calculate the strokes of all the subpaths of the current path, using the lineWidth, lineCap, lineJoin, and (if appropriate) miterLimit attributes, and then fill the combined stroke area using the strokeStyle, attribute.
@type void
*/
stroke: function() { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The strokeRect(x, y, w, h) method will stroke the specified rectangle's path using the strokeStyle, lineWidth, lineJoin, and (if appropriate) miterLimit attributes. If both height and width are zero, this method has no effect, since there is no path to stroke (it's a point). If only one of the two is zero, then the method will draw a line instead (the path for the outline is just a straight line along the non-zero dimension).
@param {Number} x
 @param {Number} y
 @param {Number} w
 @param {Number} h
* @type void
*/
strokeRect: function(x,y,w,h) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The strokeStyle attribute represents the color or style to use for the lines around shapes
@default black */
strokeStyle: undefined, // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
/** The transform(m11, m12, m21, m22, dx, dy) method will multiply the current transformation matrix with the given matrix.
@param {Number} m11
 @param {Number} m12
 @param {Number} m21
 @param {Number} m22
@param {Number} dx
@param {Number} dy
* @type void
*/
transform: function(m11, m12, m21, m22, dx, dy) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
/** The translate(x, y) method will add the translation transformation described by the arguments to the transformation matrix. The x argument represents the translation distance in the horizontal direction and the y argument represents the translation distance in the vertical direction. The arguments are in coordinate space units.
@param {Number} x
@param {Number} y
* @type void
*/
translate: function(x,y) { // COMPAT=FF2|FF3|OPERA|SAFARI2|SAFARI3|KONQ
  // This is just a stub for a builtin native JavaScript object.
},
};

