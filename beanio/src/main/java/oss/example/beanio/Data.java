package oss.example.beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Data {
	@Field(length=1, rid=true, literal="R")
	private String Record����;
	@Field(length=8)
	private String Data�Ϸù�ȣ;
	@Field(length=10)
	private String ����ڵ�;
	@Field(length=7)
	private String �������ڵ�;
	@Field(length=16)
	private String �Աݰ��¹�ȣ;
	@Field(length=13)
	private String �Աݾ�;
	@Field(length=13)
	private String �������;
	@Field(length=1)
	private String �Աݿ���;
	@Field(length=4)
	private String �Ҵ��ڵ�;
	@Field(length=16)
	private String ������系��;
	@Field(length=2)
	private String �ڱ�����;
	@Field(length=25)
	private String �̿�����뿵��;
	@Field(length=1)
	private String Check����;
	@Field(length=33)
	private String FILLER;
	public String getRecord����() {
		return Record����;
	}
	public void setRecord����(String record����) {
		Record���� = record����;
	}
	public String getData�Ϸù�ȣ() {
		return Data�Ϸù�ȣ;
	}
	public void setData�Ϸù�ȣ(String data�Ϸù�ȣ) {
		Data�Ϸù�ȣ = data�Ϸù�ȣ;
	}
	public String get����ڵ�() {
		return ����ڵ�;
	}
	public void set����ڵ�(String ����ڵ�) {
		this.����ڵ� = ����ڵ�;
	}
	public String get�������ڵ�() {
		return �������ڵ�;
	}
	public void set�������ڵ�(String �������ڵ�) {
		this.�������ڵ� = �������ڵ�;
	}
	public String get�Աݰ��¹�ȣ() {
		return �Աݰ��¹�ȣ;
	}
	public void set�Աݰ��¹�ȣ(String �Աݰ��¹�ȣ) {
		this.�Աݰ��¹�ȣ = �Աݰ��¹�ȣ;
	}
	public String get�Աݾ�() {
		return �Աݾ�;
	}
	public void set�Աݾ�(String �Աݾ�) {
		this.�Աݾ� = �Աݾ�;
	}
	public String get�������() {
		return �������;
	}
	public void set�������(String �������) {
		this.������� = �������;
	}
	public String get�Աݿ���() {
		return �Աݿ���;
	}
	public void set�Աݿ���(String �Աݿ���) {
		this.�Աݿ��� = �Աݿ���;
	}
	public String get�Ҵ��ڵ�() {
		return �Ҵ��ڵ�;
	}
	public void set�Ҵ��ڵ�(String �Ҵ��ڵ�) {
		this.�Ҵ��ڵ� = �Ҵ��ڵ�;
	}
	public String get������系��() {
		return ������系��;
	}
	public void set������系��(String ������系��) {
		this.������系�� = ������系��;
	}
	public String get�ڱ�����() {
		return �ڱ�����;
	}
	public void set�ڱ�����(String �ڱ�����) {
		this.�ڱ����� = �ڱ�����;
	}
	public String get�̿�����뿵��() {
		return �̿�����뿵��;
	}
	public void set�̿�����뿵��(String �̿�����뿵��) {
		this.�̿�����뿵�� = �̿�����뿵��;
	}
	public String getCheck����() {
		return Check����;
	}
	public void setCheck����(String check����) {
		Check���� = check����;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	@Override
	public String toString() {
		return "Data [Record����=" + Record���� + ", Data�Ϸù�ȣ=" + Data�Ϸù�ȣ + ", ����ڵ�=" + ����ڵ� + ", �������ڵ�=" + �������ڵ�
				+ ", �Աݰ��¹�ȣ=" + �Աݰ��¹�ȣ + ", �Աݾ�=" + �Աݾ� + ", �������=" + ������� + ", �Աݿ���=" + �Աݿ��� + ", �Ҵ��ڵ�=" + �Ҵ��ڵ�
				+ ", ������系��=" + ������系�� + ", �ڱ�����=" + �ڱ����� + ", �̿�����뿵��=" + �̿�����뿵�� + ", Check����=" + Check����
				+ ", FILLER=" + FILLER + "]";
	}
	
}
