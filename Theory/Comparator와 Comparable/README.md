# Comparator와 Comparable


<blockquote data-ke-style="style2"><br /><b>1. Comparator와 Comparable</b></blockquote>
<p data-ke-size="size16">&nbsp;코드를 짜다보면, 특히 코딩 문제를 풀다보면 Arrays.sort( )나 Collections.sort( )를 많이 사용하게 된다. 역순으로 정렬한다면 간단히 sort 괄호 안에 Collections.reverseOrder() 옵션을 추가해주면 된다. 이것은 우리 눈에 컴퓨터가 알아서 배열을 정렬해주는 것처럼 보이지만, 사실 Character 클래스의 Comparable의 구현에 의해 정렬되는 것이다.&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;Comparator와 Comparable은 모두 인터페이스(interface)로 컬렉션을 정렬하는데 필요한 메서드를 정의하고 있다.&nbsp; Java API문서에서 Comparable을 찾아보면 이를 구현한 클래스의 목록을 볼 수 있다. 아래 코드는 Comparator와 Comparable의 실제 소스다. 참고로 Comparator는 java.util 패키지에 있고, Comparable은 java.lang 패키지에 있다.</p>
<pre id="code_1630757585547" class="java" data-ke-language="java" data-ke-type="codeblock"><code>// Comparator 인터페이스
public interface Comparator {
	int compare(Object o1, Object o2);
&nbsp;       boolean equals(Object obj);
}
&nbsp;
// Comparable 인터페이스
public interface Comparable {
&nbsp;	public int compareTo(Object o);
}</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;compare( )와 compareTo( )는 선언 형태와 이름이 약간 다를 뿐 두 객체를 비교한다는 기능을 위해 고안된 것이다. 위코드를 보면 두 메서드의 리턴값은 int지만, 사실은 비교하는 두 객체가 같으면 0, 비교하는 값보다 작으면 음수, 크면 양수를 리턴하도록 구현돼 있다.&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;Comparable을 구현한 클래스들이 기본적으로 오름차순으로 정렬돼 있지만, 내림차순으로 정렬한다던가 아니면 다른 기준에 의해 정렬하고 싶을 때는 Comparator를 구현해서 정렬기준을 제공할 수 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><b><span style="color: #666666;">⦁ Comparable : 기본 정렬기준을 구현하는데 사용</span></b></p>
<p data-ke-size="size16"><b><span style="color: #666666;">⦁ Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용</span></b></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;필자는 처음에 Comparator와 Comparable을 구현하는 것이 어렵다고 생각하고 공부를 미루었지만, 공부한 후에는 그렇지 않다는 것을 느꼈다. 그렇다면 이제부터 예제를 살펴보자.</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>2. Comparable과 Comparator의 사용</b></blockquote>
<pre id="code_1630760504427" class="java" data-ke-language="java" data-ke-type="codeblock"><code>import java.util.*;

class MainClass {
	public static void main(String[] args) {
    	String[] s = {"kim", "Kwon", "han", "lee", "Ko", "park"};
        
        Arrays.sort(s);	// String 클래스의 Comparable 구현에 의한 정렬
        System.out.println("s: " + Arrays.toString(s));
        
        Arrays.sort(s, String.CASE_INSENSITIVE_ORDER);	// 대소문자 구분 없이 정렬
        System.out.println("s: " + Arrays.toString(s));
        
        Arrays.sort(s, new Descend());	// 역순(내림차순)으로 정렬
        System.out.println("s: " + Arrays.toString(s));
    }
}
class Descend {
&nbsp;	public int compare(Object o1, Object o2){
&nbsp;    	if(o1 instanceof Comparable &amp;&amp; o2 instanceof Comparable){
&nbsp;        	Comparable c1 = (Comparable)o1;
&nbsp;        	Comparable c2 = (Comparable)o2;
&nbsp;        	return c1.compareTo(c2) * -1;
&nbsp;        }
&nbsp;        return -1;
&nbsp;    }
}</code></pre>
<p data-ke-size="size16">&nbsp;위 코드로 우리는 세 가지 정렬을 알 수 있다. 먼저 String 클래스의 Comparable 구현에 의한 정렬은 문자열을 사전 순으로 정렬되도록 작성돼 있다. 당연히 공백, 숫자, 대문자, 소문자 모두 정렬의 기준이 된다. 두 번째는 sort의 조건으로 <b>String.CASE_INSENSITIVE_ORDER</b>을 기재해주었다. 눈치가 빠르다면 알 것이다. 이 조건을 통해 대소문자 구분 없이 정렬을 해줄 수 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;가장 생소한 것은 마지막, Comparator의 구현에 의한 정렬이다. 위의 코드에선 내림차순으로 커스텀 해주었는데, 이는 간단하게 compareTo( )의 결과에 -1을 곱하면서 해결된다. 다른 방법으로는 비교하는 객체의 위치를 바꿔주어도 상관없다. 다만 compare( ) 매개변수가 Object 타입이기 때문에 compareTo( )를 바로 호출할 수 없으므로 먼저 Comparable로 형변환해야 한다는 것은 기억해두자.</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>3. Comparator 커스텀</b></blockquote>
<p data-ke-size="size16">&nbsp;위에서 우리는 굉장히 간단한 Comparator 커스텀을 보았다. 이 밖에도 우리는 우리가 원하는 기준을 만들어 Comparator를 커스텀하고, 커스텀한 Comparator를 통해 원하는 기준으로 객체를 정렬할 수 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<pre id="code_1630761712596" class="java" data-ke-language="java" data-ke-type="codeblock"><code>import java.util.*;

class MainClass {
&nbsp;	public static void main(String[] args) {
&nbsp;		Student[] students = new Student[5];

		students[0] = new Student(24, "kim");
		students[1] = new Student(23, "kwon");
		students[2] = new Student(21, "han");
		students[3] = new Student(24, "ko");
		students[4] = new Student(20, "lee");
    	
    	Arrays.sort(students, new Comparator&lt;Student&gt;() { 
	        @Override 
	        public int compare(Student st1, Student st2) { 
                int result = st1.age - st2.age;
                
                if(result == 0)
                    return st1.name.compareTo(st2.name);
		        return result; 
	        } 
          });
    	
    	for(Student student : students)
    		System.out.println(student.age + " " + student.name);
    }
}
class Student {
&nbsp;    int age;
&nbsp;    String name;
    
&nbsp;    Student(int age, String name){
&nbsp;        this.age = age;
&nbsp;        this.name = name;
&nbsp;    }
}</code></pre>
<p data-ke-size="size16">&nbsp;위의 예제는 students라는 Student 클래스 객체 배열을 나이(age)순으로 먼저 정렬하고, 나이가 같다면 이름(name)을 사전순으로 정렬하는 예제이다. 이렇게 우리가 원하는 조건으로 정렬을 할 수 있다.</p>
<p data-ke-size="size16">&nbsp;</p>
<blockquote data-ke-style="style2"><br /><b>4. == 연산자와 equals( ) 메서드, compareTo( ) 메서드의 차이</b></blockquote>
<p data-ke-size="size16">&nbsp;공부하다보면 우리는 한 가지 의문점이 생길 수 있다. == 연산자와 equals( ) 메서드, compareTo( )의 차이는 무엇일까?답은 객체와 객체의 값으로 나뉜다.
	&nbsp;
	일단 == 연산자는 객체 자체가 같은 객체인지 비교한다. equals( ) 메서드는 객체의 값을 비교한다. == 연산자와 equals( ) 메서드는 비교하여 Boolean 값을 리턴해준다. 즉, 같은지 같지 않은지를 리턴해준다. 하지만 compareTo( ) 메서드는 자신과 전달 받은 인자를 비교하여 같은지, 큰지, 작은지를 0, 양수, 음수로 리턴해준다. 이 정도 개념만 알고 있다면 언제 어떤 것을 사용할지 감이 올 것이다.</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
