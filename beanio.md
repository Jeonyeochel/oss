
# BeanIO를 활용하여 고정길이 문자열 파싱

## 파일설계서
- 출처 :  [CMS](http://www.cmsedi.or.kr) - [자료실] - [업무자료] - "CMS 전산설계서"

### Header Record (150 Bytes)

| 항번 | 항목         | MODE | LENGTH | 비고                       |
|------|--------------|------|--------|----------------------------|
| 1    | Record 구분  | A    | 1      | Header Record 식별부호 “H" |
| 2    | 일련번호     | N    | 8      | "00000000"(고정값)         |
| 3    | 기관코드     | AN   | 10     | 이용기관식별코드           |
| 4    | FILE 이름    | AN   | 8      | MMDD                       |
| 5    | 입금일자     | AN   | 6      | YYMMDD                     |
| 6    | 은행 점코드  | AN   | 7      | 은행 점코드                |
| 7    | 출금계좌번호 | AN   | 16     | 계좌번호                   |
| 8    | FILLER       | AN   | 94     | SPACE                      |

### Data Record (320Byte)

| 항번 | 항목                                | MODE | LENGTH | 비고                                 |
|------|-------------------------------------|------|--------|--------------------------------------|
| 1    | Record 구분                         | A    | 1      | Data Record 식별부호 “R"             |
| 2    | Data 일련번호                       | N    | 8      | "00000001" ～                        |
| 3    | 기관코드                            | AN   | 10     | 이용기관식별코드                     |
| 4    | 은행 점코드                         | AN   | 7      | •참가기관(은행) 코드                 |
| 5    | 입금계좌번호                        | AN   | 16     |                                      |
| 6    | 입금액                              | N    | 13     |                                      |
| 7    | 생년월일(사업자등록번호)            | AN   | 13     |                                      |
| 8    | 입금여부                            | A    | 1      | SPACE                                |
|      | 불능코드                            | AN   | 4      | SPACE                                |
| 9    | 통장기재내용                        | H,AN | 16     |                                      |
| 10   | 자금종류                            | AN   | 2      | 입금자금의 종류                      |
| 11   | 이용기관사용영역                    | AN   | 25     | 미사용시 SPACE처리                   |
| 12   | 생년월일(사업자등록번호) Check 여부 | A    | 1      | Check를 원하면 ‘Y' 원하지 않으면 ’N' |
| 13   | FILLER                              | AN   | 33     | SPACE                                |

                                                                                    |
### Trailer Record

| 항번 | 항목              | MODE | LENGTH | 비고                             |
|------|-------------------|------|--------|----------------------------------|
| 1    | Record 구분       | A    | 1      | Trailer Record 식별부호 “T"      |
| 2    | 일련번호          | N    | 8      | "99999999"(고정값)               |
| 3    | 기관코드          | AN   | 10     | 이용기관식별코드                 |
| 4    | FILE 이름         | AN   | 8      | HEADER의 FILE 이름과 동일한 이름 |
| 5    | 총 Data Record 수 | N    | 8      |                                  |
| 6    | 건수              | N    | 8      | 입금의뢰한 Record 건수           |
| 7    | 금액              | N    | 13     | 입금의뢰금액 합계                |
| 8    | FILLER            | AN   | 84     | SPACE                            |
| 9    | MAC검증값         | AN   | 10     | PC기관:SPACE, HOST기관:MAC생성값 |


## 파일 구조에 해당하는 Bean 생성

### Header.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Header {
	@Field(length=1, rid=true, literal="H")
	private String Record구분;
	@Field(length=8)
	private String 일련번호;
	@Field(length=10)
	private String 기관코드;
	@Field(length=8)
	private String FILE이름;
	@Field(length=6)
	private String 입금일자;
	@Field(length=7)
	private String 은행점코드;
	@Field(length=16)
	private String 출금계좌번호;
	@Field(length=94)
	private String FILLER;
}	
```

### Data.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Data {
	@Field(length=1, rid=true, literal="R")
	private String Record구분;
	@Field(length=8)
	private String Data일련번호;
	@Field(length=10)
	private String 기관코드;
	@Field(length=7)
	private String 은행점코드;
	@Field(length=16)
	private String 입금계좌번호;
	@Field(length=13)
	private String 입금액;
	@Field(length=13)
	private String 생년월일;
	@Field(length=1)
	private String 입금여부;
	@Field(length=4)
	private String 불능코드;
	@Field(length=16)
	private String 통장기재내용;
	@Field(length=2)
	private String 자금종류;
	@Field(length=25)
	private String 이용기관사용영역;
	@Field(length=1)
	private String Check여부;
	@Field(length=33)
	private String FILLER;
}	
```

### Trailer.java
```java
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Trailer {
	@Field(length=1, rid=true, literal="T")
	private String Record구분;
	@Field(length=8)
	private String 일련번호;
	@Field(length=10)
	private String 기관코드;
	@Field(length=8)
	private String FILE이름;
	@Field(length=8)
	private String 총DataRecord수;
	@Field(length=8)
	private String 건수;
	@Field(length=13)
	private String 금액;
	@Field(length=84)
	private String FILLER;
	@Field(length=10)
	private String MAC검증값;
}
```

## 프로그램 (Main.java)

### Mapper 설정
```java
String streamName = "GR6533";
StreamBuilder streamBuilder = new StreamBuilder(streamName)
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
Unmarshaller u = factory.createUnmarshaller(streamName);
for (String record : result) {
	System.out.println("원문 [" + record + "]");

	Object o = u.unmarshal(record);
			
	// Parsing 결과
	System.out.println(o);
}
```

## 참고자료
 - beanIO : http://beanio.org
 
