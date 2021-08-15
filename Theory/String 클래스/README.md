<blockquote data-ke-style="style2"><br /><span style="font-family: Noto Sans Demilight, Noto Sans KR;"><b>서론 </b></span></blockquote>
<p style="text-align: left;" data-ke-size="size16"><span style="font-family: Noto Sans Demilight, Noto Sans KR;"> 처음 배우는 프로그래밍 언어는 모두 제각각이겠지만, C를 먼저 배운 사람들은 문자열을 다룰 때 어려움을 겪었을 것이다. char 타입의 배열을 다루거나 char 포인터를 사용해야 하기 때문이다. 필자 또한 이런 어려움을 겪었지만, 자바를 배우면서 달라졌다. 자바에는 String 클래스가 존재한다. 우리는 String 클래스를 이용하여 손쉽게 문자열을 다룰 수 있다. 그럼 자금부터 String 클래스에 대해 알아보자.</span><br /><br /></p>
<blockquote data-ke-style="style2"><br /><span style="font-family: Noto Sans Demilight, Noto Sans KR;"><b>String 클래스에 대하여</b></span></blockquote>
<p style="text-align: left;" data-ke-size="size16"><span style="font-family: Noto Sans Demilight, Noto Sans KR;"> 자바는 문자열을 저장하는 String클래스와 여러 메서드를 제공한다. 아마 이 글을 읽는 사람들은 이미 몇 가지 메서드는 알고 있겠지만, String 클래스는 아주 중요하므로, 자세히 알아보자.</span></p>
<pre id="code_1626628315012" class="java" data-ke-language="java" data-ke-type="codeblock"><code>public final class String implements java.io.Serializable, Comparable {
         private char[] value;
         . . .
}</code></pre>
<p style="text-align: left;" data-ke-size="size16"><span style="font-family: Noto Sans Demilight, Noto Sans KR;">&nbsp;&nbsp;String 클래스에는 문자열을 저장하기 위해 문자형 배열 참조변수인 value를 인스턴스 변수로 정의해놓고 있다. String 객체 생성 시 생성자의 매개젼수로 입력받는 문자열은 이 인스턴스 변수 value에 문자형 배열로 저장되는 것이다.</span><br /><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">한편, String 클래스는 저장된 문자열을 읽어올 수만 있고, 변경할 수는 없는 immutable 클래스다. 예를 들어 '+' 연사자를 이용해서 문자열을 결합하는 경우는 객체 내의 문자열을 바꾸는게 아니라 새로운 문자열이 담긴 String 객체를 생성하는 것이다. 따라서 문자열을 결합하는 것은 메모리 공간을 낭비하는 것과 같으므로 결합횟수를 최대한 줄이는 것이 좋다. 추가로 결합이나 추출 등 문자열을 다루는 작업이 많을 경우엔 String 클래스 대신 StringBuffer 클래스를 사용하는 것이 좋다. (StringBuffer 클래스에 대해선 나중에 다시 다루겠다.)</span></p>
<p style="text-align: left;" data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>String 객체 생성 및 비교</b></span></blockquote>
<p style="text-align: left;" data-ke-size="size16"><span style="font-family: Noto Sans Demilight, Noto Sans KR;">&nbsp; 문자열을 만들 때는 크게 두 가지 방법이 있다.&nbsp;</span></p>
<pre id="code_1626628336350" class="java" data-ke-language="java" data-ke-type="codeblock"><code>    String s1 = "abc";
    String s2 = "abc";
    String s3 = new String("abc");
    String s4 = new String("abc");</code></pre>
<p style="text-align: left;" data-ke-size="size16"><span style="font-family: Noto Sans Demilight, Noto Sans KR;">&nbsp;1, 2열과 같이 문자열 리터럴 "abc"의 주소에 객체를 저장하는 방법과 3, 4열과 같이 새로운 String 객체를 생성하는 방법이 있다.&nbsp; 주소도 아래의 그림과 같이 지정된다.</span></p>
<p>[##_Image|kage@cnLWAU/btq9OHYLSo8/U2JPHJPaRlKp45tp03SbAk/img.png|alignCenter|data-origin-width="1280" data-origin-height="553" width="344" height="149" data-ke-mobilestyle="widthOrigin"|참고 그림 by iPad||_##]</p>
<pre id="code_1626628351572" class="java" data-ke-language="java" data-ke-type="codeblock"><code>    System.out.println(s1==s2);
    System.out.println(s3==s4);</code></pre>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;따라서 위와 같은 코드를 실행하면 "=="연산자는 객체 자체를 비교하기 때문에 true(1열)와 false(2열)로 출력된다. 만약 문자열을 비교하고 싶다면 equals( ) 메서드를 사용하면 된다. (밑에서 메서드에 대해 다룰 것이다.)</span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>빈 문자열</b></span></blockquote>
<blockquote data-ke-style="style3"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">String s = "";</span></blockquote>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;일반적으로 변수를 선언할 때, 각 타입의 기본값으로 초기화 해주지만, String 클래스는 레퍼런스 타입의 기본값이 null보다는 빈 문자열로 초기화 해준다.</span></p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>String 클래스의 메서드</b></span></blockquote>
<table style="border-collapse: collapse; width: 100%; height: 867px;" border="1" data-ke-align="alignLeft" data-ke-style="style4">
<tbody>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px; text-align: center;"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>Method</b></span></td>
<td style="width: 20.1164%; height: 19px; text-align: center;"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>Explain</b></span></td>
<td style="width: 32.7908%; height: 19px; text-align: center;"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>Example code</b></span></td>
<td style="width: 15.465%; height: 19px; text-align: center;"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>Example Value</b></span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">char <span style="color: #ee2323;"><b>charAt</b></span>(int index)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 인덱스에 있는 문자 리턴</span></td>
<td style="width: 32.7908%; height: 19px;">&nbsp;</td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">c = 'e'</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int <span style="color: #ee2323;"><b>compareTo</b></span>(String str)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열과 사전순서로 비교하여 이전이면 음수, 이후면 양수 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int i = "aaa".compareTo("aaa");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int ii = "aaa".compareTo("bbb");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int iii = "bbb".compareTo("aaa");</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">i = 0</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">ii = -1</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">iii = 1</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <span style="color: #ee2323;"><b>concat</b></span>(String str)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열을 뒤에 덧붙여서 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "Hello";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s2 = s.concat(" !");</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">s2 = "Hello !"</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean <span style="color: #ee2323;"><b>contains</b></span>(CharSequence c)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 문자열이 포함돼 있는지 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "abcd";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean b = s.contains("bc");</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 22px;">
<td style="width: 31.6278%; height: 22px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean <b>endsWith</b>(Stringsuffix)</span></td>
<td style="width: 20.1164%; height: 22px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 문자열로 끝나는지 리턴</span></td>
<td style="width: 32.7908%; height: 22px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "abcd";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean b = s.endsWith("d");</span></td>
<td style="width: 15.465%; height: 22px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean <span style="color: #ee2323;"><b>equals</b></span>(Object obj)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열 비교 결과 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = new String("abc");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = new String("abc");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean b = s.equals(s1);</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean <b>equalsIgnoreCase</b>(String str)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열과 String 객체의 문자열을 대소문자 구분없이 비교하여 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = new String("abc");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = new String("ABC");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean b = s.<span style="background-color: #f9f9f9;">equalsIgnoreCase</span>(s1);</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int <span style="color: #ee2323;"><b>indexOf</b></span>(int ch)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">주어진 문자가 문자열에 존재하는지 확인하여 인덱스 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "Hello";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int idx1 = s.indexOf('o');</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int idx2 = s.indexOf('q');</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx1 =&nbsp; 4</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx2 = -1</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int<b> indexOf</b>(int ch, int pos)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">주어진 문자가 문자열에 존재하는지 정된 위치부터 확인하여 인덱스 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "Hello";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int idx1 = s.indexOf('e', 0);</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int idx2 = s.indexOf(<span style="background-color: #f9f9f9;">'e', 2)</span>;</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx1 =&nbsp; 1</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx2 = -1</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int<b> indexOf</b>(String str)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">주어진 문자열이 존재하는지 확인하여 인덱스 반환</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "ABCDE";</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int idx = s.indexOf("BC);</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx = 1</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>intern</b>( )</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열을 상수풀에 등록</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = new String("abc");</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s2 = new String("abc");<br />boolean b =&nbsp;<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; (s1.intern( ) == s2.intern( );)</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int <b>lastIndexof</b>(char ch)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 인덱스 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;"><span style="background-color: #f9f9f9;">String s = "Hello";<br /></span>int idx = s.lastIndexOf('l');</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx = 3</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int <b>lastIndexOf</b>(String str)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 문자열을 객체의 문자열 끝에서 부터 찾아서 인덱스 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;"><span style="background-color: #f9f9f9;">String s = "Hello";<br /></span>int idx = s.lastIndexOf("ll");</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">idx = 2</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">int <span style="color: #ee2323;"><b>length</b></span>( )</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열의 길이 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;"><span style="background-color: #f9f9f9;">String s = "Hello";<br /></span>int len = s.length();</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">len = 5</span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 31.6278%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <span style="color: #ee2323;"><b>replace</b></span>(char old,&nbsp; char new)</span></td>
<td style="width: 20.1164%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">old를 new로 바꾸어 리턴</span></td>
<td style="width: 32.7908%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;"><span style="background-color: #f9f9f9;">String s = "Hello";<br /></span>String rs = s.replace('e', 'a');</span></td>
<td style="width: 15.465%; height: 19px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">rs = "Hallo"</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>replace</b>(CharSequence old, CharSequence new)</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열 중 old를 new로 바꾸어 리턴</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;"><span style="background-color: #f9f9f9;">String s = "Hellollo";<br /></span><span style="background-color: #f9f9f9;">String rs = s.replace("ll", "LL");</span></span></td>
<td style="width: 15.465%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">re = "HeLLoLLo"</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>replaceAll</b>(String regex, String replacement)</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열 중 지정된 문자열과 일치하는 것을 새로운 문자열로 모두 변경하여 리턴</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String ab = "AABBAABB";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = ab.replaceAll("BB", "bb");</span></td>
<td style="width: 15.465%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">r = "AAbbAAbb"</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>replaceFirst</b>(String regex, String replacement)</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열 중 지정된 문자열과 일치한 것 중, 첫번째 것만 새로운 문자열로 변경하여 리턴</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String ab = "AABBAABB";</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = ab.replaceFirst("BB", "bb");</span></td>
<td style="width: 15.465%; height: 40px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">r = "AAbbAABB"</span></td>
</tr>
<tr style="height: 20px;">
<td style="width: 31.6278%; height: 20px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String[] <span style="color: #ee2323;"><b>split</b></span>(String regex)</span></td>
<td style="width: 20.1164%; height: 20px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열을 지정된 분리자로 나누어 문자열 배열에 담아 리턴</span></td>
<td style="width: 32.7908%; height: 20px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "010,1234,5678"</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String[] arr = s.split(",");</span></td>
<td style="width: 15.465%; height: 20px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">arr[0] = "010"</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">arr[1] = "1234"</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">arr[2] = "5678"</span></td>
</tr>
<tr style="height: 20px;">
<td style="width: 31.6278%; height: 20px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String[] <b>split</b>(String regex, int limit)</span></td>
<td style="width: 20.1164%; height: 20px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열을 지정된 분리자로 나누어 문자열 배열에 담아 리턴하는데, 문자열 전체를 지정된 수로 자름</span></td>
<td style="width: 32.7908%; height: 20px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "010,1234,5678"</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String[] arr = s.split(",", 2);</span></td>
<td style="width: 15.465%; height: 20px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">arr[0] = "010"</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">arr[1] = <br />&nbsp; &nbsp; &nbsp;"1234, 5678"</span></td>
</tr>
<tr style="height: 60px;">
<td style="width: 31.6278%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">static String<b> join</b>(String r, String[] s)</span></td>
<td style="width: 20.1164%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">여러 문자열 사이에 구분자를 넣어서 결합 후 리턴</span></td>
<td style="width: 32.7908%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "010,1234,5678"</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String[] arr = s.split(",");</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String str = String.join("-", arr)</span></td>
<td style="width: 15.465%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">str = </span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">&nbsp; 010-1234-5678</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean <b>startsWith</b>(String prefix)</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">주어진 문자열로 시작하는지 리턴</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "abcd";</span><br /><span style="background-color: #f9f9f9; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">boolean b = s.endsWith("a");</span></td>
<td style="width: 15.465%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">b = true</span></td>
</tr>
<tr style="height: 60px;">
<td style="width: 31.6278%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <span style="color: #ee2323;"><b>substring</b></span>(int begin)</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <span style="color: #ee2323;"><b>substring</b></span>(int begin, int end)</span></td>
<td style="width: 20.1164%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">시작 위치부터 끝 위치 범위에 포함된 문자열 리턴</span></td>
<td style="width: 32.7908%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "I like Java";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String c = s.substring(3, 6);</span></td>
<td style="width: 15.465%; height: 60px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">c = "ike "</span></td>
</tr>
<tr style="height: 80px;">
<td style="width: 31.6278%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>toLowerCase</b>( )</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <b>toUpperCase</b>( )</span></td>
<td style="width: 20.1164%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String 객체에 저장된 문자열을 소문자(또는 대문자)로 변환하여 반환</span></td>
<td style="width: 32.7908%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "abCdE";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String l = s.toLowerCase();</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String u = s.toUpperCase();</span></td>
<td style="width: 15.465%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">l = "abcde"</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">u = "ABCDE"</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String <span style="color: #ee2323;"><b>toString</b></span>( )</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String 객체에 저장돼 있는 문자열 반환</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "Hello";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s1 = s.toString();</span></td>
<td style="width: 15.465%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">s1 = "Hello"</span></td>
</tr>
<tr style="height: 40px;">
<td style="width: 31.6278%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String<b> trim</b>( )</span></td>
<td style="width: 20.1164%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">문자열 양쪽 끝에 있는 공백을 제거하여 리턴</span></td>
<td style="width: 32.7908%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = "&nbsp; &nbsp;Hi&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;";</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String rs = s.trim();</span></td>
<td style="width: 15.465%; height: 40px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">rs = "Hi"</span></td>
</tr>
<tr style="height: 80px;">
<td style="width: 31.6278%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">static String <span style="color: #ee2323;"><b>valueOf</b></span>(type t)</span></td>
<td style="width: 20.1164%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">지정된 값을 문자열로 변환하여 반환</span></td>
<td style="width: 32.7908%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s = String.valueOf(true);</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">java.util.Date dd = new java.util.Date();</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">String s2 = String.valueOf(dd);</span></td>
<td style="width: 15.465%; height: 80px;"><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">s1 = "true"</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">s2 = </span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">"Mon Jul 19 01:</span><br /><span style="font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, 돋움, sans-serif;">50:30 KST 2021"</span></td>
</tr>
</tbody>
</table>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';"><b>문자 인코딩 변환</b></span></blockquote>
<p data-ke-size="size16"><span style="font-family: 'Noto Sans Demilight', 'Noto Sans KR';">&nbsp;getBytes(String charsetName)을 사용하면, 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다. Java가 UTF-16을 사용하지만, 문자열 리터럴에 포함되는 문자들은&nbsp; OS의 인코딩을 사용한다. 한글 windows의 경우 문자 인코딩으로 CP949를 사용하며, UTF-8로 변경하려면 아래와 같이 코드를 써주면 된다.</span></p>
<pre id="code_1626628366723" class="java" data-ke-language="java" data-ke-type="codeblock"><code>byte[] utf8_arr = "가".getBytes("UTF-8");
String str = new String(utf8_arr, "UTF-8");</code></pre>
<p data-ke-size="size16">&nbsp;</p>
