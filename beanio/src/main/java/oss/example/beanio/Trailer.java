package oss.example.beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class Trailer {
	@Field(length=1, rid=true, literal="T")
	private String Record����;
	@Field(length=8)
	private String �Ϸù�ȣ;
	@Field(length=10)
	private String ����ڵ�;
	@Field(length=8)
	private String FILE�̸�;
	@Field(length=8)
	private String ��DataRecord��;
	@Field(length=8)
	private String �Ǽ�;
	@Field(length=13)
	private String �ݾ�;
	@Field(length=84)
	private String FILLER;
	@Field(length=10)
	private String MAC������;
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
	public String get��DataRecord��() {
		return ��DataRecord��;
	}
	public void set��DataRecord��(String ��DataRecord��) {
		this.��DataRecord�� = ��DataRecord��;
	}
	public String get�Ǽ�() {
		return �Ǽ�;
	}
	public void set�Ǽ�(String �Ǽ�) {
		this.�Ǽ� = �Ǽ�;
	}
	public String get�ݾ�() {
		return �ݾ�;
	}
	public void set�ݾ�(String �ݾ�) {
		this.�ݾ� = �ݾ�;
	}
	public String getFILLER() {
		return FILLER;
	}
	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}
	public String getMAC������() {
		return MAC������;
	}
	public void setMAC������(String mAC������) {
		MAC������ = mAC������;
	}
	@Override
	public String toString() {
		return "Trailer [Record����=" + Record���� + ", �Ϸù�ȣ=" + �Ϸù�ȣ + ", ����ڵ�=" + ����ڵ� + ", FILE�̸�=" + FILE�̸�
				+ ", ��DataRecord��=" + ��DataRecord�� + ", �Ǽ�=" + �Ǽ� + ", �ݾ�=" + �ݾ� + ", FILLER=" + FILLER + ", MAC������="
				+ MAC������ + "]";
	}
	
}
