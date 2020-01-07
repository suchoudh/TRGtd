/**
* <h2> <span> HTML Form Element Interface</span></h2>
* <p><code>FORM</code> elements share all of the properties and methods of other HTML elements described in the <a href="element" shape="rect" title="DOM:element">element</a> section. They also have the specialized interface <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-40002357" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-40002357">HTMLFormElement</a>.
* </p><p>This interface provides methods to create and modify <code>FORM</code> elements using the DOM. The following example shows how to create a new form element, modify its attributes and submit it.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // Create a form
* var f = document.createElement("form");
* 
* // Add it to the document body
* document.body.appendChild(f);
* 
* // Add action and method attributes
* f.action = "/cgi-bin/some.cgi";
* f.method = "POST"
* 
* // Call the form's submit method
* f.submit();
* </pre>
* <p>In addition, the following complete HTML document shows how to extract information from a form element and to set some of its attributes.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;title&gt;Form example&lt;/title&gt;
* &lt;script type="text/javascript"&gt;
* function getFormInfo() {
* var info;
* 
* // Get a reference using the forms collection
* var f = document.forms["formA"];
* info = "f.elements: " + f.elements + "\n"
* + "f.length: " + f.length + "\n"
* + "f.name: " + f.elements + "\n"
* + "f.acceptCharset: " + f.acceptCharset + "\n"
* + "f.action: " + f.action + "\n"
* + "f.enctype: " + f.enctype + "\n"
* + "f.encoding: " + f.encoding + "\n"
* + "f.method: " + f.method + "\n"
* + "f.target: " + f.target;
* document.forms["formA"].elements['tex'].value = info;
* }
* 
* // A reference to the form is passed from the
* // button's onclick attribute using 'this.form'
* function setFormInfo(f) {
* f.method = "GET";
* f.action = "/cgi-bin/evil_executable.cgi";
* f.name   = "totally_new";
* }
* &lt;/script&gt;
* 
* &lt;h1&gt;Form  example&lt;/h1&gt;
* 
* &lt;form name="formA" id="formA"
* action="/cgi-bin/test" method="POST"&gt;
* &lt;p&gt;Click "Info" to see information about the form.
* Click set to change settings, then info again
* to see their effect&lt;/p&gt;
* &lt;p&gt;
* &lt;input type="button" value="info"
* onclick="getFormInfo();"&gt;
* &lt;input type="button" value="set"
* onclick="setFormInfo(this.form);"&gt;
* &lt;input type="reset" value="reset"&gt;
* &lt;br&gt;
* &lt;textarea id="tex" style="height:15em; width:20em"&gt;
* &lt;/p&gt;
* &lt;/form&gt;
* </pre>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:form.elements" shape="rect" title="DOM:form.elements">form.elements</a>Ê</dt><dd> elements returns an array of all the form controls contained in the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.length" shape="rect" title="DOM:form.length">form.length</a>Ê</dt><dd> length returns the number of controls in the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.name" shape="rect" title="DOM:form.name">form.name</a>Ê</dt><dd> name returns the name of the current <code>FORM</code> element as a string.
* </dd><dt style="font-weight:bold"> <a href="form.acceptCharset" shape="rect" title="DOM:form.acceptCharset">form.acceptCharset</a>Ê</dt><dd> acceptCharset returns a list of the supported character sets for the current <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.action" shape="rect" title="DOM:form.action">form.action</a>Ê</dt><dd> action gets/sets the action of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.enctype" shape="rect" title="DOM:form.enctype">form.enctype</a>Ê</dt><dd> enctype gets/sets the content type of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.encoding" shape="rect" title="DOM:form.encoding">form.encoding</a>Ê</dt><dd> encoding gets/sets the content type of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.method" shape="rect" title="DOM:form.method">form.method</a>Ê</dt><dd> method gets/sets the HTTP method used to submit the form.
* </dd><dt style="font-weight:bold"> <a href="form.target" shape="rect" title="DOM:form.target">form.target</a>Ê</dt><dd> target gets/sets the target of the action (i.e., the frame to render its output in).
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:form.submit" shape="rect" title="DOM:form.submit">form.submit</a>Ê</dt><dd> submit() submits the form.
* </dd><dt style="font-weight:bold"> <a href="form.reset" shape="rect" title="DOM:form.reset">form.reset</a>Ê</dt><dd> reset() resets the form to its initial state.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Form = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span>Summary</span></h2>
* <p><b>acceptCharset</b> returns a list of the supported <a href="http://developer.mozilla.org/en/docs/index.php?title=character_encoding&amp;action=edit" shape="rect" title="character encoding">character encodings</a> for the given FORM element. This list can be comma- or space-separated.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.acceptCharset;
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">inputs = document.forms["myform"].acceptCharset
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-19661795" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-19661795">DOM Level 2 HTML: acceptCharset</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
acceptCharset: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>action</b> gets/sets the action of the FORM element.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.action
* form.action = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <p>form.action = "/cgi-bin/publish";
* </p>
* <h2> <span>Notes </span></h2>
* <p>The action of a form is the program that is executed on the server when the form is submitted. This property can be retrieved or set.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-74049184" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-74049184">DOM Level 2 HTML: action</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
action: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>elements</b> returns an <code><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-75708506">HTMLCollection</a></code> of all the form controls contained in the FORM element.
* </p><p>You can access a particular element by using either an index or the element <a href="element.name" shape="rect" title="DOM:element.name">name</a> or <a href="element.id" shape="rect" title="DOM:element.id">id</a>.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>nodeList</i> = <i>HTMLFormElement</i>.elements
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var inputs = document.getElementById("form1").elements;
* var inputByIndex = inputs[2];
* var inputByName = inputs["login"];
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76728479" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76728479">DOM Level 2 HTML: elements</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * @type HTMLCollection
*/
elements: undefined,
/**
* <p>Ç
* <b>encoding</b> is an alternative name for the <a href="DOM:form.enctype" shape="rect" title="DOM:form.enctype">enctype</a> element on the DOM FormElement object.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
encoding: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>enctype</b> gets/sets the content type of the FORM element.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.enctype
* form.enctype = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">form.enctype = "application/x-www-form-urlencoded";
* </pre>
* <h2> <span>Notes </span></h2>
* <p>The encoding type is generally "application/x-www-form-urlencoded".
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-84227810" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-84227810">DOM Level 2 HTML: enctype</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
enctype: undefined,
/**
* <h3> <span>Summary</span></h3>
* <p>length returns the number of controls in the FORM element.
* </p>
* <h3> <span>Syntax </span></h3>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>integer</i> = form.length
* </pre>
* <h3> <span>Example </span></h3>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (document.getElementById("form1").length &gt; 1) {
* // more than one form control here
* }
* </pre>
* <h3> <span>Specification </span></h3>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#HTML-HTMLFormElement-length" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#HTML-HTMLFormElement-length">DOM Level 2: length</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
length: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><b>method</b> gets/sets the HTTP method used to submit the form.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.method
* form.method = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.forms["myform"].method = "POST";
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-82545539" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-82545539">DOM Level 2 HTML: method</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
method: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><code>name</code> returns the name of the current <code>FORM</code> element as a string.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.name
* form.name = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">form1 = document.getElementById("form1").name;
* if (form1Ê!= document.form.form1) {
* // browser doesn't support this form of reference
* }
* </pre>
* <h2> <span>Notes </span></h2>
* <p>Note that this property is read/write, which means that you can change the name of a form or set.
* </p><p>If your <code>FORM</code> contains an element named "name" then that element overrides the <code>form.name</code> property, so that you can't access it.
* </p><p>Internet Explorer (IE) does not allow the name attribute of an element created using <code>createElement()</code> to be set or modified using the <code>name</code> property.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-22051454" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-22051454">DOM Level 2 HTML: name</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
name: undefined,
/**
* <h2> <span>Summary</span></h2>
* <p><code>reset</code> resets the form to its initial state.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLFormElement</i>.reset()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.forms["myform"].reset();
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This method does the same thing as clicking the form's reset button.
* </p><p>If a form control (such as a reset button) has a name or id of <var>reset</var> it will mask the form's reset method.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76767677" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76767677">DOM Level 2 HTML: reset</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
reset: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><code>submit</code> submits the form.
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>HTMLFormElement</i>.submit()
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">document.forms["myform"].submit()
* </pre>
* <h2> <span>Notes </span></h2>
* <p>This method does the same thing as clicking the form submit button.
* </p><p>If a form control (such as a submit button) has a name or id of <var>submit</var> it will mask the form's submit method.
* </p>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76767676" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-76767676">DOM Level 2 HTML: submit</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
 * @type void
*/
submit: function() {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span>Summary</span></h2>
* <p><b>target</b> gets/sets the target of the action (i.e., the frame to render its output in).
* </p>
* <h2> <span>Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>string</i> = form.target
* form.target = <i>string</i>
* </pre>
* <h2> <span>Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">myForm.target = document.frames[1].name;
* </pre>
* <h2> <span>Specification </span></h2>
* <p><a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6512890" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-6512890">DOM Level 2 HTML: target</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
target: undefined,
};

/**
* <h2> <span> HTML Form Element Interface</span></h2>
* <p><code>FORM</code> elements share all of the properties and methods of other HTML elements described in the <a href="element" shape="rect" title="DOM:element">element</a> section. They also have the specialized interface <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-40002357" rel="nofollow" shape="rect" title="http://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-40002357">HTMLFormElement</a>.
* </p><p>This interface provides methods to create and modify <code>FORM</code> elements using the DOM. The following example shows how to create a new form element, modify its attributes and submit it.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* // Create a form
* var f = document.createElement("form");
* 
* // Add it to the document body
* document.body.appendChild(f);
* 
* // Add action and method attributes
* f.action = "/cgi-bin/some.cgi";
* f.method = "POST"
* 
* // Call the form's submit method
* f.submit();
* </pre>
* <p>In addition, the following complete HTML document shows how to extract information from a form element and to set some of its attributes.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;title&gt;Form example&lt;/title&gt;
* &lt;script type="text/javascript"&gt;
* function getFormInfo() {
* var info;
* 
* // Get a reference using the forms collection
* var f = document.forms["formA"];
* info = "f.elements: " + f.elements + "\n"
* + "f.length: " + f.length + "\n"
* + "f.name: " + f.elements + "\n"
* + "f.acceptCharset: " + f.acceptCharset + "\n"
* + "f.action: " + f.action + "\n"
* + "f.enctype: " + f.enctype + "\n"
* + "f.encoding: " + f.encoding + "\n"
* + "f.method: " + f.method + "\n"
* + "f.target: " + f.target;
* document.forms["formA"].elements['tex'].value = info;
* }
* 
* // A reference to the form is passed from the
* // button's onclick attribute using 'this.form'
* function setFormInfo(f) {
* f.method = "GET";
* f.action = "/cgi-bin/evil_executable.cgi";
* f.name   = "totally_new";
* }
* &lt;/script&gt;
* 
* &lt;h1&gt;Form  example&lt;/h1&gt;
* 
* &lt;form name="formA" id="formA"
* action="/cgi-bin/test" method="POST"&gt;
* &lt;p&gt;Click "Info" to see information about the form.
* Click set to change settings, then info again
* to see their effect&lt;/p&gt;
* &lt;p&gt;
* &lt;input type="button" value="info"
* onclick="getFormInfo();"&gt;
* &lt;input type="button" value="set"
* onclick="setFormInfo(this.form);"&gt;
* &lt;input type="reset" value="reset"&gt;
* &lt;br&gt;
* &lt;textarea id="tex" style="height:15em; width:20em"&gt;
* &lt;/p&gt;
* &lt;/form&gt;
* </pre>
* <h2> <span>Properties</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:form.elements" shape="rect" title="DOM:form.elements">form.elements</a>Ê</dt><dd> elements returns an array of all the form controls contained in the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.length" shape="rect" title="DOM:form.length">form.length</a>Ê</dt><dd> length returns the number of controls in the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.name" shape="rect" title="DOM:form.name">form.name</a>Ê</dt><dd> name returns the name of the current <code>FORM</code> element as a string.
* </dd><dt style="font-weight:bold"> <a href="form.acceptCharset" shape="rect" title="DOM:form.acceptCharset">form.acceptCharset</a>Ê</dt><dd> acceptCharset returns a list of the supported character sets for the current <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.action" shape="rect" title="DOM:form.action">form.action</a>Ê</dt><dd> action gets/sets the action of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.enctype" shape="rect" title="DOM:form.enctype">form.enctype</a>Ê</dt><dd> enctype gets/sets the content type of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.encoding" shape="rect" title="DOM:form.encoding">form.encoding</a>Ê</dt><dd> encoding gets/sets the content type of the <code>FORM</code> element.
* </dd><dt style="font-weight:bold"> <a href="form.method" shape="rect" title="DOM:form.method">form.method</a>Ê</dt><dd> method gets/sets the HTTP method used to submit the form.
* </dd><dt style="font-weight:bold"> <a href="form.target" shape="rect" title="DOM:form.target">form.target</a>Ê</dt><dd> target gets/sets the target of the action (i.e., the frame to render its output in).
* </dd></dl>
* <h2> <span>Methods</span></h2>
* <dl><dt style="font-weight:bold"> <a href="DOM:form.submit" shape="rect" title="DOM:form.submit">form.submit</a>Ê</dt><dd> submit() submits the form.
* </dd><dt style="font-weight:bold"> <a href="form.reset" shape="rect" title="DOM:form.reset">form.reset</a>Ê</dt><dd> reset() resets the form to its initial state.
* </dd></dl>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var form = new Form();
