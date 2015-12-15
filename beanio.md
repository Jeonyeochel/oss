
# 파일처리

## 파일설계서
- 출처 : eGiro (http://e-giro.giro.or.kr) - [자료실] - [지로 안내자료] - [전자수납서비스 이용안내]

### Header Record (320 Bytes)

|    항번    |    이   름             |    MODE    |    LENGTH    |    비     고                                                  |
|------------|------------------------|------------|--------------|---------------------------------------------------------------|
|    1       |    업무구분            |    AN      |    6         |    GR6533/GR6633                                              |
|    2       |    데이터구분          |    AN      |    2         |    Header Record 구분 : “11”                                  |
|    3       |    발행기관분류코드    |    N       |    2         |    일반장표 : “90”                                            |
|    4       |    지로번호            |    N       |    7         |                                                               |
|    5       |    이용기관명          |    ANHS    |    16        |    한글 8자 이내 표시   (납부고객 영수증 및 통장 기재사항)    |
|    6       |    전 송 일            |    N       |    8         |    YYYYMMDD                                                   |
|    7       |    FILLER              |    AN      |    279       |                                                               |

### Data Record (320Byte)

|    항번    |    이    름                  |    MODE    |    LENGTH    |    비        고                                                                         |
|------------|------------------------------|------------|--------------|-----------------------------------------------------------------------------------------|
|    1       |    업무구분                  |    AN      |    6         |    GR6533/GR6633                                                                        |
|    2       |    데이터구분                |    N       |    2         |    Data   Record 구분 : “22”                                                            |
|    3       |    일련번호                  |    N       |    7         |    “0000001” ～ “9999999”                                                               |
|    4       |    고객조회번호              |    N       |    20        |    검증숫자 포함                                                                        |
|    5       |    납기내 금액               |    N       |    12        |    지로장표 금액과 동일해야 함                                                          |
|    6       |    납기후 금액               |    N       |    12        |    납기내․후 금액은 동일해야 함                                                         |
|    7       |    데이터 형식구분           |    A       |    1         |    ‘A’ 로 setting(기본데이타)                                                           |
|    8       |    납기일                    |    N       |    8         |    “YYYYMMDD” 표시,   미래일로 표시                                                     |
|    9       |    고지마감일                |    N       |    8         |    “YYYYMMDD” 표시,   미래일로 표시                                                     |
|    10      |    지로번호                  |    N       |    7         |    -                                                                                    |
|    11      |    전자납부번호              |    AN      |    14        |    "-"제외, 공란은 space                                                                |
|    12      |    고객관리번호              |    ANHS    |    30        |    "-"제외, 공란은 space                                                                |
|    13      |    고지(발행)형태            |    N       |    1         |    정상분   : “0”, 연체분   : “1”, 독촉분   : “2”   임의분   : “3”, 체납분   : “4”,     |
|    14      |    기타 구분코드             |    N       |    2         |    구분없음 : “00”                                                                      |
|    15      |    납부자성명                |    ANHS    |    16        |    성명이 없는 경우 주소(번지, 동호 등) 포함                                            |
|    16      |    Filler                    |    ANHS    |    13        |    space                                                                                |
|    17      |    납부년월(회)차            |    N       |    6         |    "YYYYMM"   표시                                                                      |
|    18      |    고객 주소                 |    ANHS    |    80        |    -                                                                                    |
|    19      |    처리결과코드              |    AN      |    2         |    “고지결과내역” 파일 작성시 사용                                                      |
|    20      |    납부우선순위              |    N       |    1         |    순서없음 : “0”, 순서 : “1”~“9”                                                       |
|    21      |    체납기간                  |    N       |    8         |    “YYMMYYMM" 표시(시작년월~끝년월)                                                     |
|    22      |    체납개월수                |    N       |    3         |    체납개월수 표시                                                                      |
|    23      |    기타고지정보 건수         |    N       |    2         |    1 ~ 7까지 사용가능, 구분없음 : “00”                                                  |
|    24      |    기타고지정보1(title)      |    ANHS    |    10        |                                                                                         |
|            |    기타고지정보1(내용)       |    ANHS    |    30        |                                                                                         |
|    25      |    Filler                    |    ANHS    |    19        |                                                                                         |
### Trailer Record

|    항번    |    이   름             |    MODE    |    LENGTH    |    비     고                       |
|------------|------------------------|------------|--------------|------------------------------------|
|    1       |    업무구분            |    AN      |    6         |    GR6533/GR6633                   |
|    2       |    데이터구분          |    N       |    2         |    Trailer   Record 구분 : “33”    |
|    3       |    총건수*             |    N       |    7         |    Data   Record의 건수 합계       |
|    4       |    납기내 금액합계*    |    N       |    14        |    Data   Record의 금액 합계       |
|    5       |    납기후 금액합계*    |    N       |    14        |    Data   Record의 금액 합계       |
|    6       |    FILLER              |    AN      |    277       |                                    |


## 파일 구조에 해당하는 Bean 생성

### Header.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Header {
	@Field(length=6)
	private String 업무구분;
	@Field(length=2,rid=true,literal="11")
	private String 데이터구분;
	@Field(length=2)
	private String 발행기관분류코드;
	@Field(length=7)
	private String 지로번호;
	@Field(length=16)
	private String 이용기관명;
	@Field(length=8)
	private String 전송일;
	@Field(length=279)
	private String FILLER;
}	
```

### Data.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Data {
	@Field(length=6)
	private String 업무구분;
	@Field(length=2,rid=true,literal="22")
	private String 데이터구분;
	@Field(length=7)
	private String 일련번호;
	@Field(length=20)
	private String 고객조회번호;
	@Field(length=12)
	private String 납기내금액;
	@Field(length=12)
	private String 납기후금액;
	@Field(length=1)
	private String 데이터형식구분;
	@Field(length=8)
	private String 납기일;		
	@Field(length=8)
	private String 고지마감일;	
	@Field(length=7)
	private String 지로번호;		
	@Field(length=14)
	private String 전자납부번호;	
	@Field(length=30)
	private String 고객관리번호;
	@Field(length=1)
	private String 고지발행형태;
	@Field(length=2)
	private String 기타구분코드;
	@Field(length=16)
	private String 납부자성명;
	@Field(length=13)
	private String Filler1;
	@Field(length=6)
	private String 납부년월회차;
	@Field(length=80)
	private String 고객주소;
	@Field(length=2)
	private String 처리결과코드;	
	@Field(length=1)
	private String 납부우선순위	;
	@Field(length=8)
	private String 체납기간;
	@Field(length=3)
	private String 체납개월수;	
	@Field(length=2)
	private String 기타고지정보건수;	
	@Field(length=10)
	private String 기타고지정보1제목;	
	@Field(length=30)
	private String 기타고지정보1내용;	
	@Field(length=19)
	private String Filler2;
}	
```

### Trailer.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Trailer {
	@Field(length=6)
	private String 업무구분;
	@Field(length=2,rid=true,literal="33")
	private String 데이터구분;
	@Field(length=7)
	private String 총건수;
	@Field(length=14)
	private String 납기내금액합계;
	@Field(length=14)
	private String 납기후금액합계;
	@Field(length=277)
	private String FILLER;
}
```

## 프로그램 (Main.java)

### Mapper 설정
```java
String fileName = "GR6533";
StreamBuilder streamBuilder = new StreamBuilder(fileName)
		.format("fixedlength")
		.parser(new FixedLengthParserBuilder().recordTerminator(""))
		.addRecord(Header.class)
		.addRecord(Data.class)
		.addRecord(Trailer.class);
		
StreamFactory factory = StreamFactory.newInstance();
factory.define(streamBuilder);
```

### 데이터 읽는 부분
 - 예제 프로그램에서는 Guava 라이브러리를 사용하여, 전체 데이터를 Collection으로 변환
 - 실 업무에서는 파일크기가 클 수 있기 때문에 Stream 형태로 구현하거나 SpringBatch 프레임워크 사용해야 함.

```java
// 레코드 길이
int recordLen = 320;
// 파일 데이터 내용
String content ="GR65331190400035          ..."
	  + "GR6533220000001               ..."
	  + "GR653333                      ...";

Iterable<String> result = Splitter.fixedLength(recordLen).split(content);
```

### 파싱 후 결과 출력
```java
Unmarshaller u = factory.createUnmarshaller(fileName);
for (String record : result) {
	System.out.println("원문 [" + record + "]");

	Object o = u.unmarshal(record);
			
	// Parsing 결과
	System.out.println(o);
}
```

## 참고자료
 - beanIO : http://beanio.org
 
