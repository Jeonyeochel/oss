package oss.example.beanio;

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
	public String getRecord구분() {
		return Record구분;
	}
	public void setRecord구분(String record구분) {
		Record구분 = record구분;
	}
	public String get일련번호() {
		return 일련번호;
	}
	public void set일련번호(String 일련번호) {
		this.일련번호 = 일련번호;
	}
	public String get기관코드() {
		return 기관코드;
	}
	public void set기관코드(String 기관코드) {
		this.기관코드 = 기관코드;
	}
	public String getFILE이름() {
		return FILE이름;
	}
	public void setFILE이름(String fILE이름) {
		FILE이름 = fILE이름;
	}
	public String get입금일자() {
		return 입금일자;
	}
	public void set입금일자(String 입금일자) {
		this.입금일자 = 입금일자;
	}
	public String get은행점코드() {
		return 은행점코드;
	}
	public void set은행점코드(String 은행점코드) {
		this.은행점코드 = 은행점코드;
	}
	public String get출금계좌번호() {
		return 출금계좌번호;
	}
	public void set출금계좌번호(String 출금계좌번호) {
		this.출금계좌번호 = 출금계좌번호;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	@Override
	public String toString() {
		return "Header [Record구분=" + Record구분 + ", 일련번호=" + 일련번호 + ", 기관코드=" + 기관코드 + ", FILE이름=" + FILE이름 + ", 입금일자="
				+ 입금일자 + ", 은행점코드=" + 은행점코드 + ", 출금계좌번호=" + 출금계좌번호 + ", FILLER=" + FILLER + "]";
	}
	
}
