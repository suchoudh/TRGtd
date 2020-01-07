/**
* <p>The <code>CSSRule</code> object represents a single CSS style rule. It may be a part of a <a href="DOM:stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a>'s <a href="stylesheet.cssRules" shape="rect" title="DOM:stylesheet.cssRules">cssRules</a> list.
* </p><p>There are several kinds of rules. All of them share a few common properties on the <a href="cssRule#CSSRule" shape="rect" title="">CSSRule</a> interface and most of them have some properties specific to a particular rule type.
* </p>
* <table border="1" style="background:#FFFFFF none repeat scroll 0%;border: 1px solid #666666;margin-bottom:10px;margin-top:10px" width="100%">
* <tr>
* <th colspan="1" rowspan="1">Type</th>
* <th colspan="1" rowspan="1">Rule-specific interface</th>
* <th colspan="1" rowspan="1">Description</th>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.STYLE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSStyleRule" shape="rect" title="">CSSStyleRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.MEDIA_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSMediaRule" shape="rect" title="">CSSMediaRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.FONT_FACE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSFontFaceRule" shape="rect" title="">CSSFontFaceRule</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.PAGE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSPageRule" shape="rect" title="">CSSPageRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.IMPORT_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSImportRule" shape="rect" title="">CSSImportRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.CHARSET_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSCharsetRule" shape="rect" title="">CSSCharsetRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.UNKNOWN_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSUnknownRule" shape="rect" title="">CSSUnknownRule</a></td>
* 
* </tr>
* </table>
* 
* <h2> <span> CSSRule </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:cssRule.cssText" shape="rect" title="DOM:cssRule.cssText">cssText</a> </dt><dd> Returns the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }".
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=cssRule.parentRule&amp;action=edit" shape="rect" title="DOM:cssRule.parentRule">parentRule</a> </dt><dd> Returns the containing rule, if any (e.g. a style rule inside an @media block).
* </dd><dt style="font-weight:bold"> <a href="cssRule.parentStyleSheet" shape="rect" title="DOM:cssRule.parentStyleSheet">parentStyleSheet</a> </dt><dd> Returns the <a href="stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a> object that this rule is part of.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=cssRule.type&amp;action=edit" shape="rect" title="DOM:cssRule.type">type</a> </dt><dd> The type of the rule, e.g. <code>CSSRule.CHARSET_RULE</code> or <code>CSSRule.IMPORT_RULE</code>.
* </dd></dl>
* <h2> <span> CSSStyleRule </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:cssRule.selectorText" shape="rect" title="DOM:cssRule.selectorText">selectorText</a> </dt><dd> Gets/sets the textual representation of the selector for this rule, e.g. "h1,h2".
* </dd><dt style="font-weight:bold"> <a href="cssRule.style" shape="rect" title="DOM:cssRule.style">style</a> </dt><dd> Returns the <a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleDeclaration" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleDeclaration">CSSStyleDeclaration</a> object for the <a href="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block">declaration block</a> of the rule.
* </dd></dl>
* <h2> <span> CSSStyleRule </span></h2>
* <h2> <span> CSSMediaRule </span></h2>
* <h2> <span> CSSFontFaceRule </span></h2>
* <h2> <span> CSSPageRule </span></h2>
* <h2> <span> CSSImportRule </span></h2>
* <h2> <span> CSSCharsetRule </span></h2>
* <h2> <span> CSSUnknownRule </span></h2>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSRule" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSRule">DOM Level 2 CSS: CSSRule</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsContent" shape="rect" title="Category:NeedsContent">NeedsContent</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var CSSRule = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span>Summary</span></h2>
* <p><b>cssText</b> returns the actual text of the style rule.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = cssRule.cssText
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if ( myRule.cssText.indexOf("background-color") != -1 ) {
* bgRule = myRule;
* }
* ...
* </pre>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 2 Style - cssRule
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
cssText: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>parentStyleSheet</b> returns the stylesheet object in which the current rule is defined.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>stylesheet</i> = cssRule.parentStyleSheet
* </pre>
* <h2> <span>Parameters </span></h2>
* <ul><li><code>stylesheet</code> is a stylesheet object.
* </li></ul>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if ( bgRule.parentStyleSheet != mySheet ) {
* // alien style rule!
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>See <a href="Gecko_DOM_Reference:event#DOM_styleSheet_Object" shape="rect" title="Gecko DOM Reference:event">Gecko DOM Reference:event#DOM_styleSheet_Object</a> for more information about the stylesheet object interface.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 2 Style - cssRule
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
* <p><b>selectorText</b> gets/sets the textual representation of the selector for the rule set.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = cssRule.selectorText
* cssRule.selectorText = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // for cssrule: body { background-color: darkblue; }
* cssrule = document.styleSheets[1]
* !!TODO!!
* selector = cssrule.selectorText;
* // selector is now "body"
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The implementation may have stripped out insignificant whitespace while parsing the selector.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 2 Style - cssRule
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
selectorText: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the <a href="CSS" shape="rect" title="DOM:CSS">CSSStyleDeclaration</a> object for the <a href="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block">declaration block</a> of the rule.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>styleObj</i> = <i>cssRule</i>.style
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">function stilo() {
* alert(document.styleSheets[0].cssRules[0].style.cssText);
* }
* // displays "background-color: gray;"
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The declaration block is that part of the style rule that appears within the braces and that actually provides the style definitions (for the selector, the part that comes before the braces).
* </p>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleRule-style" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleRule-style">DOM Level 2 CSS: style</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
style: undefined,
};

/**
* <p>The <code>CSSRule</code> object represents a single CSS style rule. It may be a part of a <a href="DOM:stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a>'s <a href="stylesheet.cssRules" shape="rect" title="DOM:stylesheet.cssRules">cssRules</a> list.
* </p><p>There are several kinds of rules. All of them share a few common properties on the <a href="cssRule#CSSRule" shape="rect" title="">CSSRule</a> interface and most of them have some properties specific to a particular rule type.
* </p>
* <table border="1" style="background:#FFFFFF none repeat scroll 0%;border: 1px solid #666666;margin-bottom:10px;margin-top:10px" width="100%">
* <tr>
* <th colspan="1" rowspan="1">Type</th>
* <th colspan="1" rowspan="1">Rule-specific interface</th>
* <th colspan="1" rowspan="1">Description</th>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.STYLE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSStyleRule" shape="rect" title="">CSSStyleRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.MEDIA_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSMediaRule" shape="rect" title="">CSSMediaRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.FONT_FACE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSFontFaceRule" shape="rect" title="">CSSFontFaceRule</a></td>
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.PAGE_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSPageRule" shape="rect" title="">CSSPageRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.IMPORT_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSImportRule" shape="rect" title="">CSSImportRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.CHARSET_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSCharsetRule" shape="rect" title="">CSSCharsetRule</a></td>
* 
* </tr>
* <tr>
* <td colspan="1" rowspan="1"><code>CSSRule.UNKNOWN_RULE</code></td><td colspan="1" rowspan="1"><a href="cssRule#CSSUnknownRule" shape="rect" title="">CSSUnknownRule</a></td>
* 
* </tr>
* </table>
* 
* <h2> <span> CSSRule </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:cssRule.cssText" shape="rect" title="DOM:cssRule.cssText">cssText</a> </dt><dd> Returns the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }".
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=cssRule.parentRule&amp;action=edit" shape="rect" title="DOM:cssRule.parentRule">parentRule</a> </dt><dd> Returns the containing rule, if any (e.g. a style rule inside an @media block).
* </dd><dt style="font-weight:bold"> <a href="cssRule.parentStyleSheet" shape="rect" title="DOM:cssRule.parentStyleSheet">parentStyleSheet</a> </dt><dd> Returns the <a href="stylesheet" shape="rect" title="DOM:stylesheet">stylesheet</a> object that this rule is part of.
* </dd><dt style="font-weight:bold"> <a href="http://developer.mozilla.org/en/docs/index.php?title=cssRule.type&amp;action=edit" shape="rect" title="DOM:cssRule.type">type</a> </dt><dd> The type of the rule, e.g. <code>CSSRule.CHARSET_RULE</code> or <code>CSSRule.IMPORT_RULE</code>.
* </dd></dl>
* <h2> <span> CSSStyleRule </span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:cssRule.selectorText" shape="rect" title="DOM:cssRule.selectorText">selectorText</a> </dt><dd> Gets/sets the textual representation of the selector for this rule, e.g. "h1,h2".
* </dd><dt style="font-weight:bold"> <a href="cssRule.style" shape="rect" title="DOM:cssRule.style">style</a> </dt><dd> Returns the <a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleDeclaration" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSStyleDeclaration">CSSStyleDeclaration</a> object for the <a href="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block" rel="nofollow" shape="rect" title="http://www.w3.org/TR/1998/REC-CSS2-19980512/syndata.html#block">declaration block</a> of the rule.
* </dd></dl>
* <h2> <span> CSSStyleRule </span></h2>
* <h2> <span> CSSMediaRule </span></h2>
* <h2> <span> CSSFontFaceRule </span></h2>
* <h2> <span> CSSPageRule </span></h2>
* <h2> <span> CSSImportRule </span></h2>
* <h2> <span> CSSCharsetRule </span></h2>
* <h2> <span> CSSUnknownRule </span></h2>
* <h2> <span> Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSRule" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-Style/css.html#CSS-CSSRule">DOM Level 2 CSS: CSSRule</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:NeedsContent" shape="rect" title="Category:NeedsContent">NeedsContent</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var cssRule = new CSSRule();
