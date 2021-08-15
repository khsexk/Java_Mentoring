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
<blockquote data-ke-style="style3">int max(int a, int b){&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br />&nbsp; &nbsp;return a &gt; b ? a : b;&nbsp; &nbsp; <b>&rarr;</b>&nbsp; &nbsp; (int a, int b) -&gt; { return a &gt; b ? a : b; }&nbsp; &nbsp;&nbsp;<b>&rarr;</b>&nbsp; &nbsp; (int a, int b) -&gt; a &gt; b ? a : b<br />}</blockquote>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;람다식에 선언된 매개변수의 타입은 추론이 가능한 경우 생략 가능한데, 대부분의 경우 생략 가능하다. 람다식에 반환타입이 없는 이유 또한 항상 추론이 가능하기 때문이다. 위의 예제에서도 a와 b의 타입을 지워도 상관없다. 이 때 둘 중 하나만 지우는 것은 허용되지 않으므로 주의해야 한다.</p>
<pre id="code_1629041083696" class="java" data-ke-language="java" data-ke-type="codeblock"><code>(a, b) -&gt; a &gt; b ? a : b</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;만약 매개변수가 하나뿐인 경우에는 괄호도 생락 가능하다. 단, 매개변수의 타입이 있다면 생략 불가능하다.</p>
<pre id="code_1629043205314" class="java" data-ke-language="java" data-ke-type="codeblock"><code>a -&gt; a * a  // Ok
int a -&gt; a * a  // Error</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;마찬가지로, 중괄호 안에 문장이 하나라면 이 또한 생략 가능하다.</p>
<blockquote data-ke-style="style3">(String name, int i) -&gt; {&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br />&nbsp; &nbsp;System.out.println(name+"="+i);&nbsp; &nbsp;<span>&nbsp; &nbsp;</span><b>&rarr;</b>&nbsp; &nbsp; &nbsp; (String name, int i) -&gt; System.out.println(name+"="+i)&nbsp; &nbsp;<br />}</blockquote>
