/**
* <h2> <span>DOM CSS Properties List</span></h2>
* <p>The following is a list of the CSS properties that are supported in the Netscape 6 DOM and accessible by means of the <code><a href="style" shape="rect" title="DOM:style">style</a></code> property on elements.
* </p><p>The following complete document example shows the typical use of the <code><a href="element.style" shape="rect" title="DOM:element.style">element.style</a></code> property to set a CSS property:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;script&gt;
* function changeStyle()  {
* c = document.getElementById("tid");
* c.style.paddingRight = "20px";
* }
* &lt;/script&gt;
* &lt;table border="1"&gt;&lt;tr&gt;
* &lt;td id="tid"&gt;Example Cell&lt;/td&gt;&lt;/tr&gt;
* &lt;/table&gt;
* &lt;form&gt;
* &lt;input value="addpad"
* type="button"
* onclick="changeStyle();" /&gt;
* &lt;/form&gt;
* &lt;/html&gt;
* </pre>
* <p>CSS styles can be returned or set with the <code>style</code> property and its attributes.  However, you cannot set values directly using constructions such as <code>style="background-color: blue"</code>, where the string contains both the attribute ("background-color") and the value ("blue"). By itself, the style property should only be used as a "getter" to read values and not a "setter" to change values. In other words, the first of the following two constructions is bad, and the latter is better practice in the DOM:
* </p>
* <dl><dt style="font-weight:bold"> <b>bad</b></dt><dd> <code>element.style = "background-color: blue";</code>
* </dd><dt style="font-weight:bold"> <b>good</b></dt><dd> <code>element.style.backgroundColor = "blue";</code>
* </dd></dl>
* <p>Note that the bad example above may actually set the background color of the given element, but this assignment overwrites any style information that already existed on that element, and then cannot be added to or updated without other overwrites. The special style attributes available off of the element's style property allow you to "manage" the style of your elements in a safer and more organized way.
* </p><p>See also: the Element <a href="http://developer.mozilla.org/en/docs/style" shape="rect" title="style">style</a> property.
* You can check the syntax for the values of these attributes by consulting the DOM CSS specification.
* </p>
* <ul><li><a href="http://developer.mozilla.org/en/docs/CSS:azimuth" shape="rect" title="CSS:azimuth">azimuth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background" shape="rect" title="CSS:background">background</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background-attachment" shape="rect" title="CSS:background-attachment">backgroundAttachment</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background-color" shape="rect" title="CSS:background-color">backgroundColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background-image" shape="rect" title="CSS:background-image">backgroundImage</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background-position" shape="rect" title="CSS:background-position">backgroundPosition</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:background-repeat" shape="rect" title="CSS:background-repeat">backgroundRepeat</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border" shape="rect" title="CSS:border">border</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-bottom" shape="rect" title="CSS:border-bottom">borderBottom</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-bottom-color" shape="rect" title="CSS:border-bottom-color">borderBottomColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-bottom-style" shape="rect" title="CSS:border-bottom-style">borderBottomStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-bottom-width" shape="rect" title="CSS:border-bottom-width">borderBottomWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-collapse" shape="rect" title="CSS:border-collapse">borderCollapse</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-color" shape="rect" title="CSS:border-color">borderColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-left" shape="rect" title="CSS:border-left">borderLeft</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-left-color" shape="rect" title="CSS:border-left-color">borderLeftColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-left-style" shape="rect" title="CSS:border-left-style">borderLeftStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-left-width" shape="rect" title="CSS:border-left-width">borderLeftWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-right" shape="rect" title="CSS:border-right">borderRight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-right-color" shape="rect" title="CSS:border-right-color">borderRightColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-right-style" shape="rect" title="CSS:border-right-style">borderRightStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-right-width" shape="rect" title="CSS:border-right-width">borderRightWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-spacing" shape="rect" title="CSS:border-spacing">borderSpacing</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-style" shape="rect" title="CSS:border-style">borderStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-top" shape="rect" title="CSS:border-top">borderTop</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-top-color" shape="rect" title="CSS:border-top-color">borderTopColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-top-style" shape="rect" title="CSS:border-top-style">borderTopStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-top-width" shape="rect" title="CSS:border-top-width">borderTopWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:border-width" shape="rect" title="CSS:border-width">borderWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:bottom" shape="rect" title="CSS:bottom">bottom</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:caption-side&amp;action=edit" shape="rect" title="CSS:caption-side">captionSide</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:clear" shape="rect" title="CSS:clear">clear</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:clip" shape="rect" title="CSS:clip">clip</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:color" shape="rect" title="CSS:color">color</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:content&amp;action=edit" shape="rect" title="CSS:content">content</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:counter-increment" shape="rect" title="CSS:counter-increment">counterIncrement</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:counter-reset" shape="rect" title="CSS:counter-reset">counterReset</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:float" shape="rect" title="CSS:float">cssFloat</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:cssText&amp;action=edit" shape="rect" title="DOM:CSS:cssText">cssText</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:cue&amp;action=edit" shape="rect" title="CSS:cue">cue</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:cue-after&amp;action=edit" shape="rect" title="CSS:cue-after">cueAfter</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:cue-before&amp;action=edit" shape="rect" title="CSS:cue-before">onBefore</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:cursor" shape="rect" title="CSS:cursor">cursor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:direction" shape="rect" title="CSS:direction">direction</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:display" shape="rect" title="CSS:display">displays</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:elevation&amp;action=edit" shape="rect" title="CSS:elevation">elevation</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:emptyCells&amp;action=edit" shape="rect" title="CSS:emptyCells">emptyCells</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font" shape="rect" title="CSS:font">font</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-family" shape="rect" title="CSS:font-family">fontFamily</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-size" shape="rect" title="CSS:font-size">fontSize</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-size-adjust" shape="rect" title="CSS:font-size-adjust">fontSizeAdjust</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-stretch" shape="rect" title="CSS:font-stretch">fontStretch</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-style" shape="rect" title="CSS:font-style">fontStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-variant" shape="rect" title="CSS:font-variant">fontVariant</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:font-weight" shape="rect" title="CSS:font-weight">fontWeight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:height" shape="rect" title="CSS:height">height</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:left" shape="rect" title="CSS:left">left</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:length" shape="rect" title="CSS:length">length</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:letter-spacing" shape="rect" title="CSS:letter-spacing">letterSpacing</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:line-height" shape="rect" title="CSS:line-height">lineHeight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:list-style" shape="rect" title="CSS:list-style">listStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:list-style-image" shape="rect" title="CSS:list-style-image">listStyleImage</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:list-style-position" shape="rect" title="CSS:list-style-position">listStylePosition</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:list-style-type" shape="rect" title="CSS:list-style-type">listStyleType</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:margin" shape="rect" title="CSS:margin">margin</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:margin-bottom" shape="rect" title="CSS:margin-bottom">marginBottom</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:margin-left" shape="rect" title="CSS:margin-left">marginLeft</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:margin-right" shape="rect" title="CSS:margin-right">marginRight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:margin-top" shape="rect" title="CSS:margin-top">marginTop</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:marker-offset&amp;action=edit" shape="rect" title="CSS:marker-offset">markerOffset</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:marks&amp;action=edit" shape="rect" title="CSS:marks">marks</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:max-height" shape="rect" title="CSS:max-height">maxHeight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:max-width" shape="rect" title="CSS:max-width">maxWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:min-height" shape="rect" title="CSS:min-height">minHeight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:min-width" shape="rect" title="CSS:min-width">minWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:-moz-binding" shape="rect" title="CSS:-moz-binding">MozBinding</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:-moz-opacity" shape="rect" title="CSS:-moz-opacity">MozOpacity</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:opacity" shape="rect" title="CSS:opacity">opacity</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:orphans&amp;action=edit" shape="rect" title="CSS:orphans">orphans</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:outline" shape="rect" title="CSS:outline">outline</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:outline-color" shape="rect" title="CSS:outline-color">outlineColor</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:outline-style" shape="rect" title="CSS:outline-style">outlineStyle</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:outline-width" shape="rect" title="CSS:outline-width">outlineWidth</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:overflow" shape="rect" title="CSS:overflow">overflow</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:overflow-x&amp;action=edit" shape="rect" title="CSS:overflow-x">overflowX</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:overflow-y&amp;action=edit" shape="rect" title="CSS:overflow-y">overflowY</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:padding" shape="rect" title="CSS:padding">padding</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:padding-bottom" shape="rect" title="CSS:padding-bottom">paddingBottom</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:padding-left" shape="rect" title="CSS:padding-left">paddingLeft</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:padding-right" shape="rect" title="CSS:padding-right">paddingRight</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:padding-top" shape="rect" title="CSS:padding-top">paddingTop</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:page&amp;action=edit" shape="rect" title="CSS:page">page</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:page-break-after&amp;action=edit" shape="rect" title="CSS:page-break-after">pageBreakAfter</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:page-break-before&amp;action=edit" shape="rect" title="CSS:page-break-before">pageBreakBefore</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:page-break-inside&amp;action=edit" shape="rect" title="CSS:page-break-inside">pageBreakInside</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:parentRule&amp;action=edit" shape="rect" title="CSS:parentRule">parentRule</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:pause&amp;action=edit" shape="rect" title="CSS:pause">pause</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:pause-after&amp;action=edit" shape="rect" title="CSS:pause-after">pauseAfter</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:pause-before&amp;action=edit" shape="rect" title="CSS:pause-before">pauseBefore</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:pitch&amp;action=edit" shape="rect" title="CSS:pitch">pitch</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:pitch-range&amp;action=edit" shape="rect" title="CSS:pitch-range">pitchRange</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:play-during&amp;action=edit" shape="rect" title="CSS:play-during">playDuring</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:position" shape="rect" title="CSS:position">position</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:quotes&amp;action=edit" shape="rect" title="CSS:quotes">quotes</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:richness&amp;action=edit" shape="rect" title="CSS:richness">richness</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:right" shape="rect" title="CSS:right">right</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:size&amp;action=edit" shape="rect" title="CSS:size">size</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:speak&amp;action=edit" shape="rect" title="CSS:speak">speak</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:speak-header&amp;action=edit" shape="rect" title="CSS:speak-header">speakHeader</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:speak-numeral&amp;action=edit" shape="rect" title="CSS:speak-numeral">speakNumeral</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:speak-punctuation&amp;action=edit" shape="rect" title="CSS:speak-punctuation">speakPunctuation</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:speech-rate&amp;action=edit" shape="rect" title="CSS:speech-rate">speechRate</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:stress&amp;action=edit" shape="rect" title="CSS:stress">stress</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:table-layout&amp;action=edit" shape="rect" title="CSS:table-layout">tableLayout</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:text-align" shape="rect" title="CSS:text-align">textAlign</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:text-decoration" shape="rect" title="CSS:text-decoration">textDecoration</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:text-indent" shape="rect" title="CSS:text-indent">textIndent</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:text-shadow&amp;action=edit" shape="rect" title="CSS:text-shadow">textShadow</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:text-transform" shape="rect" title="CSS:text-transform">textTransform</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:top" shape="rect" title="CSS:top">top</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:unicode-bidi&amp;action=edit" shape="rect" title="CSS:unicode-bidi">unicodeBidi</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:vertical-align" shape="rect" title="CSS:vertical-align">verticalAlign</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:visibility" shape="rect" title="CSS:visibility">visibility</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:voice-family&amp;action=edit" shape="rect" title="CSS:voice-family">voiceFamily</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:volume&amp;action=edit" shape="rect" title="CSS:volume">volume</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:white-space" shape="rect" title="CSS:white-space">whiteSpace</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/index.php?title=CSS:widows&amp;action=edit" shape="rect" title="CSS:widows">widows</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:width" shape="rect" title="CSS:width">width</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:word-spacing" shape="rect" title="CSS:word-spacing">wordSpacing</a>
* </li><li><a href="http://developer.mozilla.org/en/docs/CSS:z-index" shape="rect" title="CSS:z-index">zIndex</a>
* </li></ul>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM" shape="rect" title="Category:DOM">DOM</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsTechnicalReview" shape="rect" title="Category:NeedsTechnicalReview">NeedsTechnicalReview</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var CSS = {
  // This is just a stub for a builtin native JavaScript object.
};

