package oss.example.beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Header {
	@Field(length=1, rid=true, literal="H")
	private String Record����;
	@Field(length=8)
	private String �Ϸù�ȣ;
	@Field(length=10)
	private String ����ڵ�;
	@Field(length=8)
	private String FILE�̸�;
	@Field(length=6)
	private String �Ա�����;
	@Field(length=7)
	private String �������ڵ�;
	@Field(length=16)
	private String ��ݰ��¹�ȣ;
	@Field(length=94)
	private String FILLER;
	public String getRecord����() {
		return Record����;
	}
	public void setRecord����(String record����) {
		Record���� = record����;
	}
	public String get�Ϸù�ȣ() {
		return �Ϸù�ȣ;
	}
	public void set�Ϸù�ȣ(String �Ϸù�ȣ) {
		this.�Ϸù�ȣ = �Ϸù�ȣ;
	}
	public String get����ڵ�() {
		return ����ڵ�;
	}
	public void set����ڵ�(String ����ڵ�) {
		this.����ڵ� = ����ڵ�;
	}
	public String getFILE�̸�() {
		return FILE�̸�;
	}
	public void setFILE�̸�(String fILE�̸�) {
		FILE�̸� = fILE�̸�;
	}
	public String get�Ա�����() {
		return �Ա�����;
	}
	public void set�Ա�����(String �Ա�����) {
		this.�Ա����� = �Ա�����;
	}
	public String get�������ڵ�() {
		return �������ڵ�;
	}
	public void set�������ڵ�(String �������ڵ�) {
		this.�������ڵ� = �������ڵ�;
	}
	public String get��ݰ��¹�ȣ() {
		return ��ݰ��¹�ȣ;
	}
	public void set��ݰ��¹�ȣ(String ��ݰ��¹�ȣ) {
		this.��ݰ��¹�ȣ = ��ݰ��¹�ȣ;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	@Override
	public String toString() {
		return "Header [Record����=" + Record���� + ", �Ϸù�ȣ=" + �Ϸù�ȣ + ", ����ڵ�=" + ����ڵ� + ", FILE�̸�=" + FILE�̸� + ", �Ա�����="
				+ �Ա����� + ", �������ڵ�=" + �������ڵ� + ", ��ݰ��¹�ȣ=" + ��ݰ��¹�ȣ + ", FILLER=" + FILLER + "]";
	}
	
}
