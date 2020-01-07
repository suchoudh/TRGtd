var Navigator = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span> Summary </span></h2>
* <p>Allows code to determine whether or not a given resource is available.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">window.navigator.isLocallyAvailable(<i>uri</i>, <i>ifOffline</i>);
* </pre>
* <ul><li> <code>uri</code> the URI of the resource whose availability is to be checked, as a string.
* </li><li> <code>ifOffline</code> allows you to specify whether or not the offline resources cache should be checked; specify <code>true</code> to consider the offline resources cache.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var available = navigator.isLocallyAvailable("my-image-file.png", true);
* if (available) {
* / * the offline resource is present * /
* } else {
* alert("Certain needed resources are not available until you connect to the network.");
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <blockquote><div><b>Note:</b> Security exceptions can occur if the requested URI is not from the same origin.</div></blockquote>
* <h2> <span> Specification </span></h2>
* <p>None; however there is information available: <a href="http://www.campd.org/stuff/Offline%20Cache.html" rel="nofollow" shape="rect" title="http://www.campd.org/stuff/Offline%20Cache.html">Marking Resources for Offline Use</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
isLocallyAvailable: function(uri, ifOffline) {
  // This is just a stub for a builtin native JavaScript object.
},
/**
* <h2> <span> Summary </span></h2>
* <p>Returns a boolean value indicating whether the browser is online or not.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>online</i> = <i>window</i>.navigator.onLine;
* </pre>
* <ul><li><code>online</code> is a boolean <code>true</code> or <code>false</code>.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">alert(navigator.onLineÊ? "You're online"Ê: "You're offline");
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See <a href="http://developer.mozilla.org/en/docs/Online/Offline_Events" shape="rect" title="Online/Offline Events">Online/Offline Eventsâ€Ž</a> for a more detailed description of this property as well as new offline-related features introduced in Firefox 3.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p><p>Described in the <a href="http://www.whatwg.org/specs/web-apps/current-work/#navigator.online" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/#navigator.online">HTML 5 Working draft</a>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
onLine: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns an <code><a href="http://www.xulplanet.com/references/objref/PluginArray.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/PluginArray.html">PluginArray</a></code> object, listing the plugins installed in the application.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"><i>plugins</i> = navigator.plugins;
* </pre>
* <p><code>plugins</code> is a <code>PluginArray</code>, containing <code><a href="http://www.xulplanet.com/references/objref/Plugin.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/Plugin.html">Plugin</a></code> objects for the installed plugins.
* </p><p>The returned value is not a JavaScript array, but has the <code>length</code> property and supports accessing individual items using bracket notation (<code>plugins[2]</code>), as well as via <code>item(<i>index</i>)</code> and <code>namedItem(<i>"name"</i>)</code> methods.
* </p>
* <h2> <span> Example </span></h2>
* <p>The following example prints out information about the installed plugin(s) for the high-level document.  Note the properties available on the Plugin object: name, filename, and description.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">
* &lt;script type="text/javascript"&gt;
* var L = navigator.plugins.length;
* document.write(L.toString().bold() + " Plugin(s)".bold());
* document.write("&lt;br&gt;");
* document.write("Name | Filename | description".bold());
* document.write("&lt;br&gt;");
* for(var i=0; i&lt;L; i++) {
* document.write(navigator.plugins[i].name);
* document.write(" | ");
* document.write(navigator.plugins[i].filename);
* document.write(" | ");
* document.write(navigator.plugins[i].description);
* document.write("&lt;br&gt;");
* }
* &lt;/script&gt;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>The <code><a href="http://www.xulplanet.com/references/objref/Plugin.html" rel="nofollow" shape="rect" title="http://www.xulplanet.com/references/objref/Plugin.html">Plugin</a></code> object exposes a small interface for getting information about the various plugins installed in your browser.  A list of plugins is also available by entering <kbd>about:plugins</kbd> in the browser's Location bar.
* </p>
* <h2> <span>Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
plugins: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Allows web sites to register themselves as possible handlers for content of a particular MIME type.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">window.navigator.registerContentHandler(<i>mimeType</i>, <i>uri</i>, <i>title</i>);
* </pre>
* <ul><li> <code>mimeType</code> is the desired MIME type as a string.
* </li><li> <code>uri</code> is the URI to the handler as a string.
* </li><li> <code>title</code> is the title of the handler presented to the user as a string.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">navigator.registerContentHandler("application/vnd.mozilla.maybe.feed",
* "http://www.example.tld/?foo=%s",
* "My Feed Reader");
* </pre>
* <h2> <span> Notes </span></h2>
* <p>For <a href="http://developer.mozilla.org/en/docs/Firefox_2" shape="rect" title="Firefox 2">Firefox 2</a>, only the <code>application/vnd.mozilla.maybe.feed</code>, <code>application/atom+xml</code>, and <code>application/rss+xml</code> MIME types are supported. All values have the same effect, and the registered handler will receive feeds in all Atom and RSS versions.
* </p>
* <h2> <span> Specification </span></h2>
* <p>Specified by the WHATWG's <a href="http://whatwg.org/specs/web-apps/current-work/#custom-handlers" rel="nofollow" shape="rect" title="http://whatwg.org/specs/web-apps/current-work/#custom-handlers">Web Applications 1.0 working draft</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
registerContentHandler: undefined,
/**
* <div style="border: 1px solid #818151; background-color: #FFFFE1; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">This article covers features introduced in <a href="http://developer.mozilla.org/en/docs/Firefox_3_for_developers" shape="rect" title="Firefox 3 for developers">Firefox 3</a></p></div>
* 
* <h2> <span> Summary </span></h2>
* <p>Allows web sites to register themselves as possible handlers for particular protocols.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">window.navigator.registerProtocolHandler(<i>protocol</i>, <i>uri</i>, <i>title</i>);
* </pre>
* <ul><li> <code>protocol</code> is the protocol the site wishes to handle, specified as a string.
* </li><li> <code>uri</code> is the URI to the handler as a string.  You can include "%s" to indicate where to insert the escaped URI of the document to be handled.
* </li><li> <code>title</code> is the title of the handler presented to the user as a string.
* </li></ul>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">navigator.registerProtocolHandler("mailto",
* "https://mail.google.com/mail?view=cm&amp;tf=0&amp;to=%s",
* "Google Mail");
* </pre>
* <p>This creates a handler that allows mailto links to direct the user to Google Mail, inserting the email address specified in the link into the URL.
* </p>
* <h2> <span> Specification </span></h2>
* <p>Specified by the WHATWG's <a href="http://whatwg.org/specs/web-apps/current-work/#custom-handlers" rel="nofollow" shape="rect" title="http://whatwg.org/specs/web-apps/current-work/#custom-handlers">Web Applications 1.0 working draft</a>.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Firefox_3" shape="rect" title="Category:Firefox 3">Firefox 3</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
registerProtocolHandler: undefined,
};

var navigator = new Navigator();
