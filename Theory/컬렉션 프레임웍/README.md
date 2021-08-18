# Lambda Expression

<blockquote data-ke-style="style2"><span><b><br />서론</b></span></blockquote>
<p data-ke-size="size16">&nbsp;자바에 큰 변화를 준 것이 두 개가 있는데, 그 중 하나는 JDK 1.8부터 추가된 람다식이다. 람다식으로 인해 자바는 객체지향언어인 동시에 함수형 언어가 되었다. 덕분에 우리는 함수형 언어의 장점들을 자바에서도 누릴 수 있게 되었는데, 그럼 지금부터 람다식에 대해 알아보자.<br /><br /></p>
<blockquote data-ke-style="style2"><br /><span><b>1. 람다식이란?</b></span></blockquote>
<p data-ke-size="size16"><b>def.</b> 메서드를 하나의 식으로 표현한 것으로, 익명함수라고도 부른다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;바로 예제를 보면서 이해해보자.</p>
<pre id="code_1629039557147" class="java" data-ke-language="java" data-ke-type="codeblock"><code>int[] arr = new int[5];
Arrays.setAll(arr, (i) -&gt; (int)(Math.random()*5+1);
&nbsp;
int method(){
&nbsp;	return (int)(Math.random()*5) + 1;
}</code></pre>
<p data-ke-size="size16">&nbsp;위의 코드에서 ' ( ) -&gt; (int)(Math.random()*5+1 '이 람다식이다. 이 람식은 method( )를 간결하게 표현한 것이다. 코드를 봤을 때 당연히 람다식이 더 이해하기 쉬울 것이다. 또 메서드로 표현하려면 클래스를 만들어야 하고, 호출하려면 객체까지 생성해야 한다. 하지만 람다식을 사용한다면 이 과정들을 거치지 않아도 된다. 또 람다식은 메서드의 매개변수로도 전달 가능하고, 메서드의 결과로 반환될 수도 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><span><b><br />2. 람다식 표현</b></span></blockquote>
<blockquote data-ke-style="style3"><s>반환타입&nbsp; 메서드이름</s> (매개변수 선언) -&gt; {<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;// 내용<br />}</blockquote>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><b>&nbsp;</b>메서드에서 이름과 반환타입을 제거하고, 매개변수 선언부와 몸통{ } 사이에 -&gt;를 추가해주면 된다. 반환값이 있는 메서드의 경우, return문 대신 식으로 대신 할 수 있는데, 이럴 경우 문장이 아닌 식이므로 세미콜론을 붙이지 않아도 된다. 예시를 보면서 이해해보자.</p>
<blockquote data-ke-style="style3">int max(int a, int b){&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br />&nbsp; &nbsp; &nbsp; return a &gt; b ? a : b;&nbsp; &nbsp; <b>&rarr;</b>&nbsp; &nbsp; (int a, int b) -&gt; { return a &gt; b ? a : b; }&nbsp; &nbsp;&nbsp;<b>&rarr;</b>&nbsp; &nbsp; (int a, int b) -&gt; a &gt; b ? a : b<br />}</blockquote>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;람다식에 선언된 매개변수의 타입은 추론이 가능한 경우 생략 가능한데, 대부분의 경우 생략 가능하다. 람다식에 반환타입이 없는 이유 또한 항상 추론이 가능하기 때문이다. 위의 예제에서도 a와 b의 타입을 지워도 상관없다. 이 때 둘 중 하나만 지우는 것은 허용되지 않으므로 주의해야 한다.</p>
<pre id="code_1629041083696" class="java" data-ke-language="java" data-ke-type="codeblock"><code>(a, b) -&gt; a &gt; b ? a : b</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;만약 매개변수가 하나뿐인 경우에는 괄호도 생락 가능하다. 단, 매개변수의 타입이 있다면 생략 불가능하다.</p>
<pre id="code_1629043205314" class="java" data-ke-language="java" data-ke-type="codeblock"><code>a -&gt; a * a  // Ok
int a -&gt; a * a  // Error</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;마찬가지로, 중괄호 안에 문장이 하나라면 이 또한 생략 가능하다.</p>
<blockquote data-ke-style="style3">(String name, int i) -&gt; {&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br />&nbsp; &nbsp; &nbsp; System.out.println(name+"="+i);&nbsp; &nbsp;<span>&nbsp; &nbsp;</span><b>&rarr;</b>&nbsp; &nbsp; &nbsp; (String name, int i) -&gt; System.out.println(name+"="+i)&nbsp; &nbsp;<br />}</blockquote>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>3. 함수형 인터페이스(Functional Interface)</b></blockquote>
<p data-ke-size="size16">&nbsp;자바에서는 모든 메서드가 클래스에 포함돼야 한다. 람다식 또한 마찬가지이고, 익명 클래스의 객체와 동등하다. 아래 코드를 보면서 이해해보자.</p>
<blockquote data-ke-style="style3">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; new Object( ) {<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; int max(int a, int b){<br />(int a, int b) -&gt; a &gt; b ? a : b&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; <b>&harr;</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return&nbsp; a &gt; b ? a : b;<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;}&nbsp; &nbsp;</blockquote>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;그렇다면 람다식으로 정의된 익명 객체의 메서드를 어떻게 호출할 수 있는 것일까? 인터페이스가 그 정답을 가지고 있다. 아래의 코드를 보자. MyFunction이라는 인터페이스를 f라는 클래스에서 구현했다. 메서드 max( )를 보면 람다식 ' <span style="background-color: #fcfcfc; color: #666666;">(int a, int b) -&gt; a &gt; b ? a : b '와 선언부가 일치한다. 따라서 우리는 익명 객체를 람다식으로 대체할 수 있는 것이다.</span></p>
<pre id="code_1629065428241" class="java" data-ke-language="java" data-ke-type="codeblock"><code>interface MyFunction {
&nbsp;	public abstract int max(int a, int b);
}
&nbsp;
MyFunction f = new MyFunction(){
&nbsp;	            public int max(int a, int b){
&nbsp;                    	return a &gt; b ? a : b;
&nbsp;                    }
&nbsp;               };

MyFunction l = (int a, int b) -&gt; a &gt; b ? a : b;</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;실제로 람다식 또한 익명 객체이고, MyFunction 인터페이스를 구현한 익명 객체의 메서드 max( )와 매개변수의 타입, 개수, 그리고 리턴값이 일치하기 때문에 가능한 것이다. 이렇듯 인터페이스는 자바의 규칙들을 어기지 않았다. 따라서 인터페이스를 통해 람다식을 다루기로 하였고, 이 인터페이스를 "함수형 인터페이스"라고 부른다. 단, 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의돼야 한다. 이를 통해 우리는 아래의 코드처럼 간단하게 코드를 짤 수 있게 되었다.</p>
<pre id="code_1629066115312" class="java" data-ke-language="java" data-ke-type="codeblock"><code>List&lt;String&gt; list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
&nbsp;
// 기존 방식
Collections.sort(list, new Comparator&lt;String&gt;() {
&nbsp;	public int compare(String s1, String s2) {
&nbsp;    		return s2.compareTo(s1);
&nbsp;    }
});
&nbsp;
// 람다식
Collections.sort(list, (s1, s2) -&gt; s2.compareTo(s1));</code></pre>
<p data-ke-size="size16">&nbsp;</p>
