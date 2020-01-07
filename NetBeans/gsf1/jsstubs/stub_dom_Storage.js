/**
* <div style="border: 1px solid #818151; background-color: #FFFFE1; font-weight: bold; text-align: center; padding: 0px 10px 0px 10px; margin: 10px 0px 10px 0px;"><p style="margin: 4px 0px 4px 0px;">This article covers features introduced in <a href="http://developer.mozilla.org/en/docs/Firefox_2_for_developers" shape="rect" title="Firefox 2 for developers">Firefox 2</a></p></div>
* 
* <h2> <span> Summary </span></h2>
* <p>DOM Storage is the name given to the set of <a href="http://www.whatwg.org/specs/web-apps/current-work/#storage" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/#storage">storage-related features</a> introduced in the <a href="http://www.whatwg.org/specs/web-apps/current-work/" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/">Web Applications 1.0</a> specification. DOM Storage is designed to provide a larger, securer, and easier-to-use alternative to storing information in cookies. It is currently only available in Mozilla-based browsers, notably starting with <a href="http://developer.mozilla.org/en/docs/Firefox_2" shape="rect" title="Firefox 2">Firefox 2</a>.
* </p>
* <div><b>Note:</b> DOM Storage is not the same as <a href="http://developer.mozilla.org/en/docs/Storage" shape="rect" title="Storage">mozStorage</a> (Mozilla's XPCOM interfaces to SQLite) or the <a href="http://developer.mozilla.org/en/docs/Session_store_API" shape="rect" title="Session store API">Session store API</a> (an <a href="http://developer.mozilla.org/en/docs/XPCOM" shape="rect" title="XPCOM">XPCOM</a> storage utility for use by extensions).</div>
* <h2> <span> Description </span></h2>
* <p>The DOM Storage mechanism is a means through which string key/value pairs can be securely stored and later retrieved for use. The goal of this addition is to provide a comprehensive means through which interactive applications can be built (including advanced abilities, such as being able to work "offline" for extended periods of time).
* </p><p>Currently, only Mozilla-based browsers provide a working implementation of the DOM Storage specification. However, Internet Explorer does have a similar feature called "<a href="http://msdn.microsoft.com/workshop/author/behaviors/reference/behaviors/userdata.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/behaviors/reference/behaviors/userdata.asp">userData behavior</a>" that allows you to persist data across multiple browser sessions.
* </p><p>DOM Storage is useful because no good browser-only methods exist for persisting reasonable amounts of data for any period of time.  <a href="http://en.wikipedia.org/wiki/HTTP_cookie" rel="nofollow" shape="rect" title="http://en.wikipedia.org/wiki/HTTP_cookie">Browser cookies</a> have limited capacity and provide no support for organizing persisted data, and other methods (such as <a href="http://www.macromedia.com/support/documentation/en/flashplayer/help/help02.html" rel="nofollow" shape="rect" title="http://www.macromedia.com/support/documentation/en/flashplayer/help/help02.html">Flash Local Storage</a>) require an external plugin.
* </p><p>One of the first public applications to make use of the new DOM Storage functionality (in addition to Internet Explorer's userData Behavior) was <a href="http://aaronboodman.com/halfnote/" rel="nofollow" shape="rect" title="http://aaronboodman.com/halfnote/">halfnote</a> (a note-taking application) written by <a href="http://aaronboodman.com/" rel="nofollow" shape="rect" title="http://aaronboodman.com/">Aaron Boodman</a>. In his application, Aaron simultaneously saved notes back to a server (when Internet connectivity was available) and a local data store. This allowed the user to safely write backed-up notes even with sporadic Internet connectivity.
* </p><p>While the concept, and implementation, presented in halfnote was comparatively simple, its creation shows the possibility for a new breed of web applications that are usable both online and offline.
* </p>
* <h2> <span> Reference </span></h2>
* <p>The following are global objects that exist as properties of every <a href="DOM:window" shape="rect" title="DOM:window"><code>window</code> object</a>. This means that they can be accessed as <code>sessionStorage</code> or <code>window.sessionStorage</code>. (This is important because you can then use IFrames to store, or access, additional data, beyond what is immediately included in your page.)
* </p>
* <h3> <span> <code>sessionStorage</code> </span></h3>
* <p>This is a global object (<code>sessionStorage</code>) that maintains a storage area that's available for the duration of the page session. A page session lasts for as long as the browser is open and survives over page reloads and restores. Opening a page in a new tab or window will cause a new session to be initiated.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Save data to a the current session's store
* sessionStorage.username = "John";
* 
* // Access some stored data
* alert( "username = " + sessionStorage.username );
* </pre>
* <p>The <code>sessionStorage</code> object is most useful for hanging on to temporary data that should be saved and restored if the browser is accidentally refreshed.
* </p>
* <div><b>Note:</b> <code>sessionStorage</code> should also be capable of restoring data after the browser has crashed (and been restored), but due to <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=339445" rel="nofollow" shape="rect" title="https://bugzilla.mozilla.org/show_bug.cgi?id=339445">bug 339445</a> that doesn't work in Firefox yet. Until this is resolved, the use of <code>sessionStorage</code> as a preventative measure is debatable.</div>
* <p><b>Examples:</b>
* </p><p>Autosave the contents of a text field, and if the browser is accidentally refreshed, restore the text field contents, so that no writing is lost.
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> // Get the text field that we're going to track
* var field = document.getElementById("field");
* 
* // See if we have an autosave value
* // (this will only happen if the page is accidentally refreshed)
* if ( sessionStorage.autosave ) {
* // Restore the contents of the text field
* field.value = sessionStorage.autosave;
* }
* 
* // Check the contents of the text field every second
* setInterval(function(){
* // And save the results into the session storage object
* sessionStorage.autosave = field.value;
* }, 1000);
* </pre>
* <p><b>More information:</b>
* </p>
* <ul><li> <a href="http://www.whatwg.org/specs/web-apps/current-work/#sessionstorage" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/#sessionstorage">sessionStorage specification</a>
* </li></ul>
* <h3> <span> <code>globalStorage</code> </span></h3>
* <p>This is a global object (<code>globalStorage</code>) that maintains multiple public, and private, storage areas that can be used to hold data over a long period of time (e.g. over multiple pages and browser sessions).
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// Save data that only scripts on the mozilla.org domain can access
* globalStorage['mozilla.org'].snippet = "&lt;b&gt;Hello&lt;/b&gt;, how are you?";
* 
* // Save some data that any web page, on any domain, can access
* globalStorage[''].favBrowser = "Firefox";
* </pre>
* <p>Specifically, the <code>globalStorage</code> object provides access to a number of different storage objects into which data can be stored. For example, if we were to build a web page that used <code>globalStorage</code> on this domain (developer.mozilla.org) we'd have the following storage objects available to us:
* </p>
* <ul><li> <code>globalStorage['developer.mozilla.org']</code> - All web pages within the developer.mozilla.org sub-domain can both read and write data to this storage object.
* </li><li> <code>globalStorage['mozilla.org']</code> - All web pages with the mozilla.org domain can both read and write to this storage object.
* </li><li> <code>globalStorage['org']</code> - All web pages on all .org domains can both read and write to this storage object.
* </li><li> <code>globalStorage['']</code> - All web pages on all domains can both read and write to this storage object.
* </li></ul>
* <div><b>Note:</b> <code>globalStorage[tld]</code> and <code>globalStorage['']</code> are presently not implemented by Firefox (throw a security error), due to speculated negative security properties of public read/write access to these namespaces. <a href="http://ejohn.org/blog/dom-storage-answers/" rel="nofollow" shape="rect" title="http://ejohn.org/blog/dom-storage-answers/">More information</a></div>
* <p><b>Examples:</b>
* </p><p>All of these examples require that you have a script inserted (with each of the following code) in every page that you want to see the result on.
* </p><p>Remember a user's username for the particular sub-domain that is being visited:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> globalStorage['developer.mozilla.org'].username = "John";
* </pre>
* <p>Keep track of the number of times that a user visits all pages of your domain:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> // parseInt must be used since all data is stored as a string
* globalStorage['mozilla.org'].visits =
* parseInt( globalStorage['mozilla.org'].visits || 0 ) + 1;
* </pre>
* <p>Remember all the web sites that you visit:
* </p>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve"> globalStorage[''].sites += "," + location.hostname;
* </pre>
* <p><b>More information:</b>
* </p>
* <ul><li> <a href="http://www.whatwg.org/specs/web-apps/current-work/#globalstorage" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/#globalstorage">globalStorage specification</a>
* </li></ul>
* <h2> <span> More information </span></h2>
* <ul><li> <a href="http://www.whatwg.org/specs/web-apps/current-work/" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/">Web Applications 1.0 Specification</a>
* </li><li> <a href="http://www.whatwg.org/specs/web-apps/current-work/#storage" rel="nofollow" shape="rect" title="http://www.whatwg.org/specs/web-apps/current-work/#storage">Web Applications 1.0 Storage Specification</a>
* </li><li> <a href="http://kb.mozillazine.org/Dom.storage.enabled" rel="nofollow" shape="rect" title="http://kb.mozillazine.org/Dom.storage.enabled">Enable/Disable DOM Storage in Firefox or SeaMonkey</a>
* </li></ul>
* <h2> <span> Examples </span></h2>
* <ul><li> <a href="http://channy.creation.net/work/firefox/domstorage/" rel="nofollow" shape="rect" title="http://channy.creation.net/work/firefox/domstorage/">Basic DOMStorage Examples</a>
* </li><li> <a href="http://aaronboodman.com/halfnote/" rel="nofollow" shape="rect" title="http://aaronboodman.com/halfnote/">halfnote</a> - Note writing application that uses DOM Storage.
* </li></ul>
* <h2> <span> Related </span></h2>
* <ul><li> <a href="http://en.wikipedia.org/wiki/HTTP_cookie" rel="nofollow" shape="rect" title="http://en.wikipedia.org/wiki/HTTP_cookie">HTTP cookies</a> (<code><a href="document.cookie" shape="rect" title="DOM:document.cookie">document.cookie</a></code>)
* </li><li> <a href="http://www.macromedia.com/support/documentation/en/flashplayer/help/help02.html" rel="nofollow" shape="rect" title="http://www.macromedia.com/support/documentation/en/flashplayer/help/help02.html">Flash Local Storage</a>
* </li><li> <a href="http://msdn.microsoft.com/workshop/author/behaviors/reference/behaviors/userdata.asp" rel="nofollow" shape="rect" title="http://msdn.microsoft.com/workshop/author/behaviors/reference/behaviors/userdata.asp">Internet Explorer userData behavior</a><a href="http://developer.mozilla.org/en/docs/index.php?title=cn:Storage&amp;action=edit" shape="rect" title="cn:DOM:Storage">cn:DOM:Storage</a>
* </li></ul>
* <p>
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM" shape="rect" title="Category:DOM">DOM</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:JavaScript" shape="rect" title="Category:JavaScript">JavaScript</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
var Storage = {
  // This is just a stub for a builtin native JavaScript object.
};

