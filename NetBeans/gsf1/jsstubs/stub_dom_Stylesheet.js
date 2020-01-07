/**
* <p>This section describes the <a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet">CSSStyleSheet</a> object, which represents a single CSS stylesheet.
* </p><p>A CSS stylesheet consists of CSS rules, each of them can be manipulated through its <a href="cssRule" shape="rect" title="DOM:cssRule">CSSRule</a> object. The stylesheet object itself lets you examine and modify the stylesheet, including its list of rules.
* </p><p>You can get the list of stylesheets for a given document using the <a href="document.styleSheets" shape="rect" title="DOM:document.styleSheets">document.styleSheets</a> property.
* </p>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:stylesheet.cssRules" shape="rect" title="DOM:stylesheet.cssRules">stylesheet.cssRules</a>Ê</dt><dd> Returns all of the CSS rules in the stylesheet as an array.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.disabled" shape="rect" title="DOM:stylesheet.disabled">stylesheet.disabled</a>Ê</dt><dd> This property indicates whether the current stylesheet has been applied or not.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.href" shape="rect" title="DOM:stylesheet.href">stylesheet.href</a>Ê</dt><dd> Returns the location of the stylesheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.media" shape="rect" title="DOM:stylesheet.media">stylesheet.media</a>Ê</dt><dd> Specifies the intended destination medium for style information.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.ownerNode" shape="rect" title="DOM:stylesheet.ownerNode">stylesheet.ownerNode</a>Ê</dt><dd> Returns the node that associates this style sheet with the document.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.ownerRule" shape="rect" title="DOM:stylesheet.ownerRule">stylesheet.ownerRule</a>Ê</dt><dd> If this style sheet comes from an @import rule, the ownerRule property will contain the CSSImportRule.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.parentStyleSheet" shape="rect" title="DOM:stylesheet.parentStyleSheet">stylesheet.parentStyleSheet</a>Ê</dt><dd> Returns the stylesheet that is including this one, if any.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.title" shape="rect" title="DOM:stylesheet.title">stylesheet.title</a>Ê</dt><dd> Returns the advisory title of the current style sheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.type" shape="rect" title="DOM:stylesheet.type">stylesheet.type</a>Ê</dt><dd> Specifies the style sheet language for this style sheet.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:stylesheet.deleteRule" shape="rect" title="DOM:stylesheet.deleteRule">stylesheet.deleteRule</a>Ê</dt><dd> Deletes a rule from the stylesheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.insertRule" shape="rect" title="DOM:stylesheet.insertRule">stylesheet.insertRule</a>Ê</dt><dd> Inserts a new style rule into the current style sheet.
* </dd></dl>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-StyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-StyleSheet">DOM Level 2 Style Sheets: StyleSheet</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet">DOM Level 2 CSS: CSSStyleSheet</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Stylesheet = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span> Summary </span></h2>
* <p>Returns all of the CSS rules in the stylesheet as a <a href="http://developer.mozilla.org/en/docs/index.php?title=CSSRuleList&amp;action=edit" shape="rect" title="DOM:CSSRuleList">CSSRuleList</a>, an array-like object.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>rules</i> = stylesheet.cssRules
* </pre>
* <p><code>rules</code> is a <a href="http://developer.mozilla.org/en/docs/index.php?title=DOM:CSSRuleList&amp;action=edit" shape="rect" title="DOM:CSSRuleList">CSSRuleList</a> of individual <code>cssRule</code> objects. The individual <code>cssRule</code> object can refer to one of the following objects:
* </p>
* <ul><li> <a href="cssRule#CSSStyleRule" shape="rect" title="DOM:cssRule">CSSStyleRule</a>
* </li><li> <a href="cssRule#CSSMediaRule" shape="rect" title="DOM:cssRule">CSSMediaRule</a>
* </li><li> <a href="cssRule#CSSFontFaceRule" shape="rect" title="DOM:cssRule">CSSFontFaceRule</a>
* </li><li> <a href="cssRule#CSSPageRule" shape="rect" title="DOM:cssRule">CSSPageRule</a>
* </li><li> <a href="cssRule#CSSImportRule" shape="rect" title="DOM:cssRule">CSSImportRule</a>
* </li><li> <a href="cssRule#CSSCharsetRule" shape="rect" title="DOM:cssRule">CSSCharsetRule</a>
* </li><li> <a href="cssRule#CSSUnknownRule" shape="rect" title="DOM:cssRule">CSSUnknownRule</a>
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// get the first style sheetâ€™s first rule
* first_rule = document.styleSheets[0].cssRules[0];
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See DOM <a href="cssRule" shape="rect" title="DOM:cssRule">cssRule</a> object.
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet-cssRules" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet-cssRules">DOM Level 2 Style: CSSStyleSheet.cssRules</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cssRules: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>The <b>deleteRule</b> method removes a style rule from the current style sheet object.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">stylesheet.deleteRule(<i>index</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>index</code> is a long number representing the position of the rule.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* myStyles.deleteRule(0);
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-deleteRule" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-deleteRule">deleteRule </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
deleteRule: function(index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p>This property indicates whether the current stylesheet is applied or not.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>bool</i> = stylesheet.disabled
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // if the stylesheet is disabled...
* if (stylesheet.disabled) {
* // apply style in-line
* }
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-disabled" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-disabled">disabled </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
disabled: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the location of the stylesheet.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>uri</i> = stylesheet.href
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>uri</code> is a string containing the stylesheet's URI.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // on a local machine:
* &lt;html&gt;
* &lt;head&gt;
* &lt;link rel="StyleSheet" href="example.css" type="text/css" /&gt;
* &lt;script&gt;
* function sref() {
* alert(document.styleSheets[0].href);
* }
* &lt;/script&gt;
* &lt;/head&gt;
* &lt;body&gt;
* &lt;div class="thunder"&gt;Thunder&lt;/div&gt;
* &lt;button onclick="sref()"&gt;ss&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* // returns "file:////C:/Windows/Desktop/example.css
* </pre>
* <h2> <span>Notes </span></h2>
* <p>If the style sheet is a linked style sheet, the value of its attribute is its location. For inline style sheets, the value of this attribute is NULL.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-href" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-href">href </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
href: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>The <b>insertRule</b> method inserts a new style rule into the current style sheet.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">stylesheet.insertRule(<i>rule</i>, <i>index</i>)
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>rule</code> is a string containing the rule to be inserted (selector and declaration).
* </li><li><code>index</code> is a number representing the position to be inserted.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // push a new rule onto the top of my stylesheet
* myStyle.insertRule("#blanc { color: white }", 0);
* </pre>
* <h2> <span>Notes </span></h2>
* <p>For rule sets this contains both the selector and the style declaration. For at-rules, this specifies both the at-identifier and the rule content.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-insertRule" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-insertRule">insertRule </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
insertRule: function(rule, index) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>media</b> specifies the intended destination medium for style information.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>medium</i> = stylesheet.media
* stylesheet.media = <i>medium</i>
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>medium</code> is a string describing a single medium or a comma-separated list.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;link rel="StyleSheet" href="document.css" type="text/css" media="screen" /&gt;
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The default value for media is "screen."
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 2 Styles - STYLESHEET
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
media: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>ownerNode</b> returns the node that associates this style sheet with the document.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>objRef</i> = stylesheet.ownerNode
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">&lt;html&gt;
* &lt;head&gt;
* &lt;link rel="StyleSheet" href="example.css" type="text/css" /&gt;
* &lt;script&gt;
* function stilo() {
* alert(document.styleSheets[0].ownerNode);
* }
* &lt;/script&gt;
* &lt;/head&gt;
* &lt;body&gt;
* </pre>
* <div>Thunder</div>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">  &lt;button onclick="stilo()"&gt;ss&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* // displays "object HTMLLinkElement"
* </pre>
* <h2> <span>Notes </span></h2>
* <p>For HTML, <b>ownerNode</b> may be the corresponding <a href="http://developer.mozilla.org/en/docs/index.php?title=LINK&amp;action=edit" shape="rect" title="LINK">LINK</a> or <a href="http://developer.mozilla.org/en/docs/index.php?title=STYLE&amp;action=edit" shape="rect" title="STYLE">STYLE</a> element. For XML, it may be the linking processing instruction. For style sheets that are included by other style sheets, the value of this attribute is NULL.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 2 Styles - STYLESHEET
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
ownerNode: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>If this style sheet comes from an <code>@import</code> rule, the <b>ownerRule</b> property will contain the CSSImportRule.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>rule</i> = stylesheet.ownerRule
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>rule</code> is a string containing the importing rule in the HTML or XML document.
* </li></ul>
* <h2> <span>Notes </span></h2>
* <p>Note that if the value of the <b>ownerNode</b> property on the current <a href="http://developer.mozilla.org/en/docs/index.php?title=STYLE&amp;action=edit" shape="rect" title="STYLE">STYLE</a> element is NULL, then then <b>ownerRule</b> returns the rule thatÊ!!TODO!!. And vice versa.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-ownerRule" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/css.html#CSS-CSSStyleSheet-ownerRule">ownerRule </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
ownerRule: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>Returns the stylesheet that is including this one, if any.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>objRef</i> = stylesheet.parentStyleSheet
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// find the top level stylesheet
* if (stylesheet.parentStyleSheet) {
* sheet = stylesheet.parentStyleSheet;
* }
* else
* { sheet = stylesheet; }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This property returns NULL is the current stylesheet is a top-level stylesheet or if stylesheeet inclusion is not supported.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-parentStyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-parentStyleSheet">parentStyleSheet </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
parentStyleSheet: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>title</b> returns the advisory title of the current style sheet.
* </p>
* <h2> <span>Notes </span></h2>
* <p>The title is often specified in the <a href="http://developer.mozilla.org/en/docs/ownerNode" shape="rect" title="ownerNode">ownerNode</a>.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-title" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-title">title </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
title: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p>type specifies the style sheet language for this style sheet.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = stylesheet.type
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* ss.type = "text/css";
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-type" rel="nofollow" shape="rect" title="http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113/stylesheets.html#StyleSheets-StyleSheet-type">type </a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
type: undefined,
};

/**
* <p>This section describes the <a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet">CSSStyleSheet</a> object, which represents a single CSS stylesheet.
* </p><p>A CSS stylesheet consists of CSS rules, each of them can be manipulated through its <a href="cssRule" shape="rect" title="DOM:cssRule">CSSRule</a> object. The stylesheet object itself lets you examine and modify the stylesheet, including its list of rules.
* </p><p>You can get the list of stylesheets for a given document using the <a href="document.styleSheets" shape="rect" title="DOM:document.styleSheets">document.styleSheets</a> property.
* </p>
* <h2> <span> Properties </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:stylesheet.cssRules" shape="rect" title="DOM:stylesheet.cssRules">stylesheet.cssRules</a>Ê</dt><dd> Returns all of the CSS rules in the stylesheet as an array.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.disabled" shape="rect" title="DOM:stylesheet.disabled">stylesheet.disabled</a>Ê</dt><dd> This property indicates whether the current stylesheet has been applied or not.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.href" shape="rect" title="DOM:stylesheet.href">stylesheet.href</a>Ê</dt><dd> Returns the location of the stylesheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.media" shape="rect" title="DOM:stylesheet.media">stylesheet.media</a>Ê</dt><dd> Specifies the intended destination medium for style information.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.ownerNode" shape="rect" title="DOM:stylesheet.ownerNode">stylesheet.ownerNode</a>Ê</dt><dd> Returns the node that associates this style sheet with the document.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.ownerRule" shape="rect" title="DOM:stylesheet.ownerRule">stylesheet.ownerRule</a>Ê</dt><dd> If this style sheet comes from an @import rule, the ownerRule property will contain the CSSImportRule.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.parentStyleSheet" shape="rect" title="DOM:stylesheet.parentStyleSheet">stylesheet.parentStyleSheet</a>Ê</dt><dd> Returns the stylesheet that is including this one, if any.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.title" shape="rect" title="DOM:stylesheet.title">stylesheet.title</a>Ê</dt><dd> Returns the advisory title of the current style sheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.type" shape="rect" title="DOM:stylesheet.type">stylesheet.type</a>Ê</dt><dd> Specifies the style sheet language for this style sheet.
* </dd></dl>
* <h2> <span> Methods </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:stylesheet.deleteRule" shape="rect" title="DOM:stylesheet.deleteRule">stylesheet.deleteRule</a>Ê</dt><dd> Deletes a rule from the stylesheet.
* </dd><dt style="font-weight:bold"> <a href="stylesheet.insertRule" shape="rect" title="DOM:stylesheet.insertRule">stylesheet.insertRule</a>Ê</dt><dd> Inserts a new style rule into the current style sheet.
* </dd></dl>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-StyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/stylesheets.html#StyleSheets-StyleSheet">DOM Level 2 Style Sheets: StyleSheet</a>
* </p><p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleSheet">DOM Level 2 CSS: CSSStyleSheet</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var stylesheet = new Stylesheet();
