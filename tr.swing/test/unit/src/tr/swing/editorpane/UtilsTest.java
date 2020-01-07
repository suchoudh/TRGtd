/*
 * UtilsTest.java
 * JUnit based test
 *
 * Created on May 18, 2007, 12:21 PM
 */

package tr.swing.editorpane;

import junit.framework.*;

/**
 *
 * @author jmoore
 */
public class UtilsTest extends TestCase {
    
    public UtilsTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
    }
    
    protected void tearDown() throws Exception {
    }
    
    public void process(String string, String expect) {
        try {
            String result = Utils.text2html(string);
            
            System.err.print("========================================");
            System.err.println("========================================");
            System.err.println("STRING: " + string);
            System.err.println("EXPECT: " + expect);
            System.err.println("RESULT: " + result);
            
            assertEquals("FAILED", expect, result);
            
        } catch (Exception ex) {
            
            fail("EXCEPTION: " + ex.getMessage());
            
        }
    }
    
    public void testConvertURLs_1_0() {
        String string = "";
        String expect = "<html><body></body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_1_1() {
        String string = "a b c d e ";
        String expect = "<html><body>a b c d e </body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_1_2() {
        String string = "the quick\nbrown fox   jumped   over the lazy  cow ";
        String expect = "<html><body>the quick<br>brown fox&nbsp;&nbsp; jumped&nbsp;&nbsp; over the lazy&nbsp;&nbsp;cow </body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_1_3() {
        String string = "the quick\nbrown fox [www.thinkingrock.com.au|Thinking Rock]   jumped   over the lazy  cow";
        String expect = "<html><body>the quick<br>brown fox <a href=\"http://www.thinkingrock.com.au\">Thinking Rock</a>&nbsp;&nbsp; jumped&nbsp;&nbsp; over the lazy&nbsp;&nbsp;cow</body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_1_4() {
        String string = "one two  three   [www.thinkingrock.com.au|Thinking   Rock    Web Site]   is  here";
        String expect = "<html><body>one two&nbsp;&nbsp;three&nbsp;&nbsp; <a href=\"http://www.thinkingrock.com.au\">Thinking&nbsp;&nbsp; Rock&nbsp;&nbsp;&nbsp;&nbsp;Web Site</a>&nbsp;&nbsp; is&nbsp;&nbsp;here</body></html>";
        process(string, expect);
    }
    
    
    public void testConvertURLs_2_1() {
        String string = "www.thinkingrock.com.au";
        String expect = "<html><body><a href=\"http://www.thinkingrock.com.au\">www.thinkingrock.com.au</a></body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_2_2() {
        String string = "howdi  doodi   www.thinkingrock.com.au ficki \n flacki";
        String expect = "<html><body>howdi&nbsp;&nbsp;doodi&nbsp;&nbsp; <a href=\"http://www.thinkingrock.com.au\">www.thinkingrock.com.au</a> ficki <br> flacki</body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_3_1() {
        String string = "file:/Users/jimoore/somefile.pdf";
        String expect = "<html><body><a href=\"file:/Users/jimoore/somefile.pdf\">file:/Users/jimoore/somefile.pdf</a></body></html>";
        process(string, expect);
    }
    
    
    public void testText2html_1_1() {
        String string = "hello world!";
        String expect = "<html><body>hello world!</body></html>";
        process(string, expect);
    }
    
    public void testText2html_1_2() {
        String string = "hello < > world!";
        String expect = "<html><body>hello &lt; &gt; world!</body></html>";
        process(string, expect);
    }
    
    public void testCase_2_1() {
        String string = "www.netbeans.org";
        String expect = "<html><body><a href=\"http://www.netbeans.org\">www.netbeans.org</a></body></html>";
        process(string, expect);
    }
    public void testCase_2_2() {
        String string = "[www.netbeans.org]";
        String expect = "<html><body><a href=\"http://www.netbeans.org\">www.netbeans.org</a></body></html>";
        process(string, expect);
    }
    public void testCase_2_3() {
        String string = "a [www.netbeans.org] b";
        String expect = "<html><body>a <a href=\"http://www.netbeans.org\">www.netbeans.org</a> b</body></html>";
        process(string, expect);
    }
    public void testCase_2_4() {
        String string = "file:/Users/jimoore/somefile.xyz";
        String expect = "<html><body><a href=\"file:/Users/jimoore/somefile.xyz\">file:/Users/jimoore/somefile.xyz</a></body></html>";
        process(string, expect);
    }
    public void testCase_2_5() {
        String string = "file:///Users/jimoore/somefile.xyz";
        String expect = "<html><body><a href=\"file:///Users/jimoore/somefile.xyz\">file:///Users/jimoore/somefile.xyz</a></body></html>";
        process(string, expect);
    }
    public void testCase_2_6() {
        String string = "[file:///Users/jimoore/somefile.xyz|a b c]";
        String expect = "<html><body><a href=\"file:///Users/jimoore/somefile.xyz\">a b c</a></body></html>";
        process(string, expect);
    }
    public void testCase_2_7() {
        String string = " a  b   c    d     [file:///Users/jimoore/somefile.xyz|a b c]";
        String expect = "<html><body> a&nbsp;&nbsp;b&nbsp;&nbsp; c&nbsp;&nbsp;&nbsp;&nbsp;d&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"file:///Users/jimoore/somefile.xyz\">a b c</a></body></html>";
        process(string, expect);
    }
    
    
    /** Test input contains A tag. */
    public void testCase_3_1() {
        String string = "[http://www.a.com|a web site]";
        String expect = "<html><body><a href=\"http://www.a.com\">a web site</a></body></html>";
        process(string, expect);
    }

    /** Test containing A tag and http:// URL */
    public void testCase_3_2() {
        String string = "a  b  [http://www.a.com|a web site]  c  d  http://www.b.com  e  f";
        String expect = "<html><body>a&nbsp;&nbsp;b&nbsp;&nbsp;<a href=\"http://www.a.com\">a web site</a>&nbsp;&nbsp;c&nbsp;&nbsp;d&nbsp;&nbsp;<a href=\"http://www.b.com\">http://www.b.com</a>&nbsp;&nbsp;e&nbsp;&nbsp;f</body></html>";
        process(string, expect);
    }

//    /** Test containing anchor (A) tag and two http:// URLs */
//    public void testCase_2_3() {
//        String string = "<html><body>a  b  <a href=\"http://www.a.com\">a web site</a>  c  d  http://www.b.com  e  f  http://www.c.com  g  h</body></html>";
//        String expect = "<html><body>a  b  <a href=\"http://www.a.com\">a web site</a>  c  d  <a href=\"http://www.b.com\">http://www.b.com</a>  e  f  <a href=\"http://www.c.com\">http://www.c.com</a>  g  h</body></html>";
//        process(string, expect);
//    }
//
//
//    /** Test containing paragraphs (P) tags and an http:// URL */
//    public void testCase_3_1() {
//        String string = "<html><body>a  b  <p>  c  d  http://www.a.com  e  f  <p>  g  h  http://www.b.com  i  j  </p></p></body></html>";
//        String expect = "<html><body>a  b  <p>  c  d  <a href=\"http://www.a.com\">http://www.a.com</a>  e  f  <p>  g  h  <a href=\"http://www.b.com\">http://www.b.com</a>  i  j  </p></p></body></html>";
//        process(string, expect);
//    }
//
//    /** Test containing unordered list (UL) and an http:// URL */
//    public void testCase_4_1() {
//        String string = "<html><body>a  b  <ul><li>  c  d  http://www.a.com  e  f  </li><li>  g  h  http://www.b.com  i  j  </li></ul></body></html>";
//        String expect = "<html><body>a  b  <ul><li>  c  d  <a href=\"http://www.a.com\">http://www.a.com</a>  e  f  </li><li>  g  h  <a href=\"http://www.b.com\">http://www.b.com</a>  i  j  </li></ul></body></html>";
//        process(string, expect);
//    }
//
//    public void testCase_5_1() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a b c http://www.a.com d e f\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a b c <a href=\"http://www.a.com\">http://www.a.com</a> d e f\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    /** Text www.* URL */
//    public void testCase_6_1() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a b c www.a.com d e f\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a b c <a href=\"http://www.a.com\">www.a.com</a> d e f\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    /** Text www.* URL and http:// URL */
//    public void testCase_6_2() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  www.a.com  d  e  f\n"
//              + "        g  h  i  http://www.b.com  j  k  l\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  <a href=\"http://www.a.com\">www.a.com</a>  d  e  f\n"
//              + "        g  h  i  <a href=\"http://www.b.com\">http://www.b.com</a>  j  k  l\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    public void testCase_7_1() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  www.a.com  d  e  f\n"
//              + "        g  h  i  http://www.b.com  j  k  l\n"
//              + "        m  n  o  [http://www.c.com]  p  q  r\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  <a href=\"http://www.a.com\">www.a.com</a>  d  e  f\n"
//              + "        g  h  i  <a href=\"http://www.b.com\">http://www.b.com</a>  j  k  l\n"
//              + "        m  n  o  <a href=\"http://www.c.com\">http://www.c.com</a>  p  q  r\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    public void testCase_7_2() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  www.a.com  d  e  f\n"
//              + "        g  h  i  http://www.b.com  j  k  l\n"
//              + "        m  n  o  [http://www.c.com]  p  q  r\n"
//              + "        s  t  u  [www.d.com]  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  <a href=\"http://www.a.com\">www.a.com</a>  d  e  f\n"
//              + "        g  h  i  <a href=\"http://www.b.com\">http://www.b.com</a>  j  k  l\n"
//              + "        m  n  o  <a href=\"http://www.c.com\">http://www.c.com</a>  p  q  r\n"
//              + "        s  t  u  <a href=\"http://www.d.com\">www.d.com</a>  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    public void testCase_8_1() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  www.a.com  d  e  f\n"
//              + "        g  h  i  http://www.b.com  j  k  l\n"
//              + "        m  n  o  [http://www.c.com|The c web site]  p  q  r\n"
//              + "        s  t  u  [www.d.com|The d web site]  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  <a href=\"http://www.a.com\">www.a.com</a>  d  e  f\n"
//              + "        g  h  i  <a href=\"http://www.b.com\">http://www.b.com</a>  j  k  l\n"
//              + "        m  n  o  <a href=\"http://www.c.com\">The c web site</a>  p  q  r\n"
//              + "        s  t  u  <a href=\"http://www.d.com\">The d web site</a>  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
//
//    public void testCase_9_1() {
//        String string =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  www.a.com  d  e  f\n"
//              + "        g  h  i  foobar://something1:somewhere1:ref1  j  k  l\n"
//              + "        m  n  o  [foobar://something2:somewhere2:ref2|A foobar protocol URL]  p  q  r\n"
//              + "        s  t  u  [www.d.com|The d web site]  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        String expect =
//                "<html>\n"
//              + "    <body>\n"
//              + "        a  b  c  <a href=\"http://www.a.com\">www.a.com</a>  d  e  f\n"
//              + "        g  h  i  <a href=\"foobar://something1:somewhere1:ref1\">foobar://something1:somewhere1:ref1</a>  j  k  l\n"
//              + "        m  n  o  <a href=\"foobar://something2:somewhere2:ref2\">A foobar protocol URL</a>  p  q  r\n"
//              + "        s  t  u  <a href=\"http://www.d.com\">The d web site</a>  v  w  x\n"
//              + "    </body>\n"
//              + "</html>";
//        process(string, expect);
//    }
    
    public void testConvertURLs_4_1() {
        String string = "Mit Luft nur Temperaturen < 100 ¡C.";
        String expect = "<html><body>Mit Luft nur Temperaturen &lt; 100 &#176;C.</body></html>";
        process(string, expect);
    }
    
    public void testConvertURLs_4_2() {
        String string = "ŒºÅ¶©úûÂµ¹Ï¨§ ·Å´½";
        String expect = "<html><body>&#229;&#8747;&#8776;&#8706;&#169;&#729;&#730;&#172;&#181;&#960;&#339;&#174;&#223;&#8224;&#8721;&#8776;&#165;&#937;</body></html>";
        process(string, expect);
    }

    public void testConvertURLs_5_1() {
        String string = "[http://www.yahoo.com|Yahoo] [file:/Users/jmoore/zFeedReader Application/abc.pdf|abc.pdf]";
        String expect = "<html><body><a href=\"http://www.yahoo.com\">Yahoo</a> <a href=\"file:/Users/jmoore/zFeedReader Application/abc.pdf\">abc.pdf</a></body></html>";
        process(string, expect);
    }
    
    
    
}
