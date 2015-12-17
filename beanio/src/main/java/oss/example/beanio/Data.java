package oss.example.beanio;

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
	public String getRecord구분() {
		return Record구분;
	}
	public void setRecord구분(String record구분) {
		Record구분 = record구분;
	}
	public String getData일련번호() {
		return Data일련번호;
	}
	public void setData일련번호(String data일련번호) {
		Data일련번호 = data일련번호;
	}
	public String get기관코드() {
		return 기관코드;
	}
	public void set기관코드(String 기관코드) {
		this.기관코드 = 기관코드;
	}
	public String get은행점코드() {
		return 은행점코드;
	}
	public void set은행점코드(String 은행점코드) {
		this.은행점코드 = 은행점코드;
	}
	public String get입금계좌번호() {
		return 입금계좌번호;
	}
	public void set입금계좌번호(String 입금계좌번호) {
		this.입금계좌번호 = 입금계좌번호;
	}
	public String get입금액() {
		return 입금액;
	}
	public void set입금액(String 입금액) {
		this.입금액 = 입금액;
	}
	public String get생년월일() {
		return 생년월일;
	}
	public void set생년월일(String 생년월일) {
		this.생년월일 = 생년월일;
	}
	public String get입금여부() {
		return 입금여부;
	}
	public void set입금여부(String 입금여부) {
		this.입금여부 = 입금여부;
	}
	public String get불능코드() {
		return 불능코드;
	}
	public void set불능코드(String 불능코드) {
		this.불능코드 = 불능코드;
	}
	public String get통장기재내용() {
		return 통장기재내용;
	}
	public void set통장기재내용(String 통장기재내용) {
		this.통장기재내용 = 통장기재내용;
	}
	public String get자금종류() {
		return 자금종류;
	}
	public void set자금종류(String 자금종류) {
		this.자금종류 = 자금종류;
	}
	public String get이용기관사용영역() {
		return 이용기관사용영역;
	}
	public void set이용기관사용영역(String 이용기관사용영역) {
		this.이용기관사용영역 = 이용기관사용영역;
	}
	public String getCheck여부() {
		return Check여부;
	}
	public void setCheck여부(String check여부) {
		Check여부 = check여부;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	@Override
	public String toString() {
		return "Data [Record구분=" + Record구분 + ", Data일련번호=" + Data일련번호 + ", 기관코드=" + 기관코드 + ", 은행점코드=" + 은행점코드
				+ ", 입금계좌번호=" + 입금계좌번호 + ", 입금액=" + 입금액 + ", 생년월일=" + 생년월일 + ", 입금여부=" + 입금여부 + ", 불능코드=" + 불능코드
				+ ", 통장기재내용=" + 통장기재내용 + ", 자금종류=" + 자금종류 + ", 이용기관사용영역=" + 이용기관사용영역 + ", Check여부=" + Check여부
				+ ", FILLER=" + FILLER + "]";
	}
	
}
