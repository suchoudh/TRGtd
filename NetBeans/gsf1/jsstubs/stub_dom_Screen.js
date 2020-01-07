var Screen = {
  // This is just a stub for a builtin native JavaScript object.
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the amount of vertical space available to the window on the screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">iAvail = window.screen.availHeight
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if window.screen.availHeight != window.screen.height {
* // something's in the way!
* // use available to size window
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p><i>no notes</i>
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
availHeight: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the first available pixel available from the left side of the screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">iAvail = window.screen.availLeft
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">setY = window.screen.height - window.screen.availTop;
* setX = window.screen.width - window.screen.availLeft;
* window.moveTo(setX, setY);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>In most cases, this property returns 0.
* </p><p>If you work with two screens this property evaluated on the right screen returns width of the left one in pixels. This way you can detect whether there is a screen available on the left. (Similar analogy aplies to screen.availTop property.)
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
availLeft: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Specifies the y-coordinate of the first pixel that is not allocated to permanent or semipermanent user interface features.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">iAvail = window.screen.availTop
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">setY = window.screen.height - window.screen.availTop;
* setX = window.screen.width - window.screen.availLeft;
* window.moveTo(setX, setY);
* </pre>
* <h2> <span> Notes </span></h2>
* <p>In most cases, this property returns 0.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
availTop: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the amount of horizontal space in pixels available to the window.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">iAvail = window.screen.availWidth
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// example code here
* </pre>
* <h2> <span> Notes </span></h2>
* <p><i>no notes</i>
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
availWidth: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the color depth of the screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">bitDepth = window.screen.colorDepth
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// check the color depth of the screen
* if ( window.screen.colorDepth &lt; 8) {
* // use low-color version of page
* } else {
* // use regular, colorful page
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <a href="DOM:window.screen.pixelDepth" shape="rect" title="DOM:window.screen.pixelDepth">window.screen.pixelDepth</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
colorDepth: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the height of the screen in pixels.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">iHeight = window.screen.height
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">if (window.screen.availHeight != window.screen.height) {
* // something is occupying some screen real estate!
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Note that not all of the height given by this property may be available to the window itself. Widgets such as taskbars or other special application windows that integrate with the OS (e.g., the Spinner player minimized to act like an additional toolbar on windows) may reduce the amount of space available to browser windows and other applications.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
height: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the distance in pixels from the left side of the main screen to the left side of the current screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var <i>left</i> = <i>window</i>.screen.left;
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <a href="window.screen.top" shape="rect" title="DOM:window.screen.top">window.screen.top</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of any standard.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Categories</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span> | <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:DOM_0" shape="rect" title="Category:DOM 0">DOM 0</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
left: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the bit depth of the screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">depth = window.screen.pixelDepth
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// if there is not adequate bit depth
* // choose a simpler color
* if ( window.screen.pixelDepth &gt; 8 ) {
* document.style.color = "#FAEBD7";
* } else {
* document.style.color = "#FFFFFF";
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>See also <a href="DOM:window.screen.colorDepth" shape="rect" title="DOM:window.screen.colorDepth">window.screen.colorDepth</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
pixelDepth: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the distance in pixels from the top side of the current screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">var Itop = window.screen.top
* </pre>
* <p>
* </p>
* <h2> <span> Notes </span></h2>
* <p>See also <a href="window.screen.left" shape="rect" title="DOM:window.screen.left">window.screen.left</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
top: undefined,
/**
* <h2> <span> Summary </span></h2>
* <p>Returns the width of the screen.
* </p>
* <h2> <span> Syntax </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">lWidth = window.screen.width
* </pre>
* <h2> <span> Example </span></h2>
* <pre style="background:#EEEEEE none repeat scroll 0% 50%;border:1px solid #666666;padding:5px 5px" xml:space="preserve">// crude way to check that the screen is at 1024x768
* if (window.screen.width &gt; 1000) {
* // resolution is below 10 x 7
* }
* </pre>
* <h2> <span> Notes </span></h2>
* <p>Note that not all of the width given by this property may be available to the window itself. When other widgets occupy space that cannot be used by the <code>window</code> object, there is a difference in <code>window.screen.width</code> and <code>window.screen.availWidth</code>.
* See also <a href="DOM:window.screen.height" shape="rect" title="DOM:window.screen.height">window.screen.height</a>.
* </p>
* <h2> <span> Specification </span></h2>
* <p>DOM Level 0. Not part of specification.
* </p>
* 
* <div id="catlinks"><p><a href="http://developer.mozilla.org/en/docs/Special:Categories" shape="rect" title="Special:Categories">Category</a>: <span dir="ltr"><a href="http://developer.mozilla.org/en/docs/Category:Gecko_DOM_Reference" shape="rect" title="Category:Gecko DOM Reference">Gecko DOM Reference</a></span></p></div>
* 
* <ul style="list-style-type:none;font-size:0.9em;text-align:center">
* <li id="f-copyright">Content is available under <a href="http://developer.mozilla.org/en/docs/MDC:Copyrights" shape="rect" title="MDC:Copyrights">these licenses</a>.</li>	  		<li id="f-about"><a href="http://developer.mozilla.org/en/docs/MDC:About" shape="rect" title="MDC:About">About MDC</a></li>	  				</ul>
*/
width: undefined,
};

var screen = new Screen();
