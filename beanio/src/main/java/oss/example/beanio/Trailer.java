package oss.example.beanio;

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
	public String get총DataRecord수() {
		return 총DataRecord수;
	}
	public void set총DataRecord수(String 총DataRecord수) {
		this.총DataRecord수 = 총DataRecord수;
	}
	public String get건수() {
		return 건수;
	}
	public void set건수(String 건수) {
		this.건수 = 건수;
	}
	public String get금액() {
		return 금액;
	}
	public void set금액(String 금액) {
		this.금액 = 금액;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	public String getMAC검증값() {
		return MAC검증값;
	}
	public void setMAC검증값(String mAC검증값) {
		MAC검증값 = mAC검증값;
	}
	@Override
	public String toString() {
		return "Trailer [Record구분=" + Record구분 + ", 일련번호=" + 일련번호 + ", 기관코드=" + 기관코드 + ", FILE이름=" + FILE이름
				+ ", 총DataRecord수=" + 총DataRecord수 + ", 건수=" + 건수 + ", 금액=" + 금액 + ", FILLER=" + FILLER + ", MAC검증값="
				+ MAC검증값 + "]";
	}
	
}
