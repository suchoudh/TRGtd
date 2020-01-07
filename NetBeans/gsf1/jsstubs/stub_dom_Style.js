/**
* <h2> <span> Notes </span></h2>
* <p>See the following pages for information on some of the objects used to manipulate specified CSS properties using the DOM:
* </p>
* <ul><li> <a href="element.style" shape="rect" title="DOM:element.style">DOM element.style Object</a>
* </li><li> <a href="stylesheet" shape="rect" title="DOM:stylesheet">DOM stylesheet Object</a>
* </li><li> <a href="cssRule" shape="rect" title="DOM:cssRule">DOM cssRule Object</a>
* </li><li> <a href="CSS" shape="rect" title="DOM:CSS">DOM CSS Properties List</a>
* </li></ul>
* <h2> <span> Material to be moved to other pages </span></h2>
* <p>The basic <code>style</code> object exposes the <code>StyleSheet</code> and the <code>CSSStyleSheet</code> interfaces from the <i>DOM Level 2 Style</i> specification. Those interfaces contain members like <code>insertRule</code>, <code>selectorText</code>, and <code>parentStyleSheet</code> for accessing and manipulating the individual style rules that make up a CSS stylesheet.
* </p><p>To get to the <code>style</code> objects from the <code>document</code>, you can use the <code>document.styleSheets</code> property and access the individual objects by index (e.g., <code>document.styleSheets[0]</code> is the first stylesheet defined for the document, etc.). Though there are various syntaxes for expressing stylesheets for a document, Netscape supports CSS exclusively, so the <code>style</code> object retrieved from this array implements both the StyleSheet and CSSStyleSheet interfaces.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var ss = document.styleSheets[1];
* ss.cssRules[0].style.backgroundColor="blue";
* </pre>
* <p>The list of properties available in the DOM from the style property is given on the <a href="DOM:CSS" shape="rect" title="DOM:CSS">DOM CSS Properties List</a> page.
* </p><p>The element <strong>style</strong> property can also be used to get and set the styles on an element. However, this property only returns style attributes that have been set <i>in-line</i> (e.g, <code>&lt;td style="background-color: lightblue"&gt;</code> returns the string "background-color:lightblue", or directly for that element using <code>element.style.propertyName</code>, even though there may be other styles on the element from a stylesheet).
* </p><p>Also, when you set this property on an element, you override and erase any styles that have been set elsewhere for that element's particular property you are setting. Setting the border property, for example, will overide settings made elsewhere for that element's border property in the head section, or external style sheets. However, this will not affect any other property declarations for that element's styles, such as padding or margin or font, for example.
* </p><p>To change a particular element's style, you can adapt the following example for the element(s) you want to style.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;simple style example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function alterStyle(elem) {
* elem.style.background = 'green';
* }
* 
* function resetStyle(elemId) {
* elem = document.getElementById(elemId);
* elem.style.background = 'white';
* }
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* #p1 {
* border: solid blue 2px;
* }
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* 
* &lt;!-- passes a reference to the element's object as parameter 'this'. --&gt;
* &lt;p id="p1" onclick="alterStyle(this)";&gt;
* Click here to change background color. &lt;/p&gt;
* 
* &lt;!-- passes the 'p1' id of another element's style to modify. --&gt;
* &lt;button onclick="resetStyle('p1');"&gt;Reset background color&lt;/button&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>The <code>getComputedStyle()</code> method on the <code>document.defaultView</code> object returns all styles that have actually been computed for an element. See <a href="Gecko_DOM_Reference:Examples#Example_6:_getComputedStyle" shape="rect" title="Gecko DOM Reference:Examples">Example 6: getComputedStyle</a> in the examples chapter for more information on how to use this method.
* </p>
* <h3> <span>DOM Style Object</span></h3>
* <p>The <code>style</code> object represents an individual style statement. Unlike the individual rules available from the <code><a href="DOM:document.styleSheets" shape="rect" title="DOM:document.styleSheets">document.styleSheets</a></code> collection, the style object is accessed from the <code>document</code> or from the elements to which that style is applied. It represents the <i>in-line</i> styles on a particular element.
* </p><p>More important than the two properties noted here is the use of the <code>style</code> object to set individual style properties on an element:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
* "http://www.w3.org/TR/html4/loose.dtd"&gt;
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;style Property Example&lt;/title&gt;
* &lt;link rel="StyleSheet" href="example.css" type="text/css"&gt;
* &lt;script type="text/javascript"&gt;
* function stilo()
* {
* document.getElementById("d").style.color = "orange";
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;div id="d" class="thunder"&gt;Thunder&lt;/div&gt;
* &lt;button onclick="stilo()"&gt;ss&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>The <b>media</b> and <b>type</b> of the style may or may not be given. Note that you can also change style of an element by getting a reference to it and then use its <code><a href="element.setAttribute" shape="rect" title="DOM:element.setAttribute">setAttribute</a></code> method to specify the CSS property and its value.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* var el = document.getElementById("some-element");
* el.setAttribute("style", "background-color:darkblue;");
* </pre>
* <p>Be aware, however, that <code>setAttribute</code> will remove all other style properties that may already have been defined in the element's style object. If the <var>some-element</var> element above had an in–line style attribute of say <code>style="font-size: 18px"</code>, that value would have been removed by the use of <code>setAttribute</code>.
* </p>
* <h4> <span>Properties</span></h4>
* <dl><dt style="font-weight:bold"> <a href="DOM:style.media" shape="rect" title="DOM:style.media">style.media</a> </dt><dd> Specifies the intended destination medium for style information.
* </dd><dt style="font-weight:bold"> <a href="style.type" shape="rect" title="DOM:style.type">style.type</a> </dt><dd> Returns the type of style being applied by this statement.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Style = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span>Summary</span></h2>
* <p><b>media</b> specifies the intended destination medium for style information.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>medium</i> = style.media
* style.media = <i>medium</i>
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
* <p>DOM Level 2 Styles - STYLE
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
* <p>Returns the type of the current style.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = style.type
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* if (newStyle.type != "text/css"){
* // not supported!
* warnCSS();
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>For Gecko, the type is most often given as "text/css."
* From the W3C spec on CSS: "The expectation is that binding-specific casting methods can be used to cast down from an instance of the CSSRule interface to the specific derived interface implied by the type."
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
* <h2> <span> Notes </span></h2>
* <p>See the following pages for information on some of the objects used to manipulate specified CSS properties using the DOM:
* </p>
* <ul><li> <a href="element.style" shape="rect" title="DOM:element.style">DOM element.style Object</a>
* </li><li> <a href="stylesheet" shape="rect" title="DOM:stylesheet">DOM stylesheet Object</a>
* </li><li> <a href="cssRule" shape="rect" title="DOM:cssRule">DOM cssRule Object</a>
* </li><li> <a href="CSS" shape="rect" title="DOM:CSS">DOM CSS Properties List</a>
* </li></ul>
* <h2> <span> Material to be moved to other pages </span></h2>
* <p>The basic <code>style</code> object exposes the <code>StyleSheet</code> and the <code>CSSStyleSheet</code> interfaces from the <i>DOM Level 2 Style</i> specification. Those interfaces contain members like <code>insertRule</code>, <code>selectorText</code>, and <code>parentStyleSheet</code> for accessing and manipulating the individual style rules that make up a CSS stylesheet.
* </p><p>To get to the <code>style</code> objects from the <code>document</code>, you can use the <code>document.styleSheets</code> property and access the individual objects by index (e.g., <code>document.styleSheets[0]</code> is the first stylesheet defined for the document, etc.). Though there are various syntaxes for expressing stylesheets for a document, Netscape supports CSS exclusively, so the <code>style</code> object retrieved from this array implements both the StyleSheet and CSSStyleSheet interfaces.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var ss = document.styleSheets[1];
* ss.cssRules[0].style.backgroundColor="blue";
* </pre>
* <p>The list of properties available in the DOM from the style property is given on the <a href="DOM:CSS" shape="rect" title="DOM:CSS">DOM CSS Properties List</a> page.
* </p><p>The element <strong>style</strong> property can also be used to get and set the styles on an element. However, this property only returns style attributes that have been set <i>in-line</i> (e.g, <code>&lt;td style="background-color: lightblue"&gt;</code> returns the string "background-color:lightblue", or directly for that element using <code>element.style.propertyName</code>, even though there may be other styles on the element from a stylesheet).
* </p><p>Also, when you set this property on an element, you override and erase any styles that have been set elsewhere for that element's particular property you are setting. Setting the border property, for example, will overide settings made elsewhere for that element's border property in the head section, or external style sheets. However, this will not affect any other property declarations for that element's styles, such as padding or margin or font, for example.
* </p><p>To change a particular element's style, you can adapt the following example for the element(s) you want to style.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;simple style example&lt;/title&gt;
* 
* &lt;script type="text/javascript"&gt;
* 
* function alterStyle(elem) {
* elem.style.background = 'green';
* }
* 
* function resetStyle(elemId) {
* elem = document.getElementById(elemId);
* elem.style.background = 'white';
* }
* &lt;/script&gt;
* 
* &lt;style type="text/css"&gt;
* #p1 {
* border: solid blue 2px;
* }
* &lt;/style&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* 
* &lt;!-- passes a reference to the element's object as parameter 'this'. --&gt;
* &lt;p id="p1" onclick="alterStyle(this)";&gt;
* Click here to change background color. &lt;/p&gt;
* 
* &lt;!-- passes the 'p1' id of another element's style to modify. --&gt;
* &lt;button onclick="resetStyle('p1');"&gt;Reset background color&lt;/button&gt;
* 
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>The <code>getComputedStyle()</code> method on the <code>document.defaultView</code> object returns all styles that have actually been computed for an element. See <a href="Gecko_DOM_Reference:Examples#Example_6:_getComputedStyle" shape="rect" title="Gecko DOM Reference:Examples">Example 6: getComputedStyle</a> in the examples chapter for more information on how to use this method.
* </p>
* <h3> <span>DOM Style Object</span></h3>
* <p>The <code>style</code> object represents an individual style statement. Unlike the individual rules available from the <code><a href="DOM:document.styleSheets" shape="rect" title="DOM:document.styleSheets">document.styleSheets</a></code> collection, the style object is accessed from the <code>document</code> or from the elements to which that style is applied. It represents the <i>in-line</i> styles on a particular element.
* </p><p>More important than the two properties noted here is the use of the <code>style</code> object to set individual style properties on an element:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
* "http://www.w3.org/TR/html4/loose.dtd"&gt;
* &lt;html&gt;
* &lt;head&gt;
* &lt;title&gt;style Property Example&lt;/title&gt;
* &lt;link rel="StyleSheet" href="example.css" type="text/css"&gt;
* &lt;script type="text/javascript"&gt;
* function stilo()
* {
* document.getElementById("d").style.color = "orange";
* }
* &lt;/script&gt;
* &lt;/head&gt;
* 
* &lt;body&gt;
* &lt;div id="d" class="thunder"&gt;Thunder&lt;/div&gt;
* &lt;button onclick="stilo()"&gt;ss&lt;/button&gt;
* &lt;/body&gt;
* &lt;/html&gt;
* </pre>
* <p>The <b>media</b> and <b>type</b> of the style may or may not be given. Note that you can also change style of an element by getting a reference to it and then use its <code><a href="element.setAttribute" shape="rect" title="DOM:element.setAttribute">setAttribute</a></code> method to specify the CSS property and its value.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* var el = document.getElementById("some-element");
* el.setAttribute("style", "background-color:darkblue;");
* </pre>
* <p>Be aware, however, that <code>setAttribute</code> will remove all other style properties that may already have been defined in the element's style object. If the <var>some-element</var> element above had an in–line style attribute of say <code>style="font-size: 18px"</code>, that value would have been removed by the use of <code>setAttribute</code>.
* </p>
* <h4> <span>Properties</span></h4>
* <dl><dt style="font-weight:bold"> <a href="DOM:style.media" shape="rect" title="DOM:style.media">style.media</a> </dt><dd> Specifies the intended destination medium for style information.
* </dd><dt style="font-weight:bold"> <a href="style.type" shape="rect" title="DOM:style.type">style.type</a> </dt><dd> Returns the type of style being applied by this statement.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var style = new Style();
