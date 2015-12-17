package oss.example.beanio;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import com.google.common.base.Splitter;

public class Main {
	
	public static void main(String[] args) {
		String streamName = "EB31";
		StreamBuilder streamBuilder = new StreamBuilder(streamName)
				.format("fixedlength")
				.parser(new FixedLengthParserBuilder().recordTerminator(""))
				.addRecord(Header.class)
				.addRecord(Data.class)
				.addRecord(Trailer.class);
		
		StreamFactory factory = StreamFactory.newInstance();
		factory.define(streamBuilder);
		
		
		// 레코드 길이
		int recordLen = 150;
		// 파일 데이터 내용
		String content =  "H000000009912345678EB310725110725004655465501053333                                                                                                   " 
						+ "R0000000019912345678088000079620201030154  0000000010000340507           KFTC       　　　999020043                  Y                                   " 
						+ "R000000029912345678004000097004193006      0000000020000770204           KFTC       　　　999819956                  Y                                   " 
						+ "R000000039912345678005000088502153090      0000000010000750111           KFTC       　　　997713566                  Y                                   " 
						+ "R000000049912345678006000066702072127      0000000030000620711           KFTC       　　　999312584                  Y                                   " 
						+ "R00000005991234567820907000061602158480    0000000010000760713           KFTC       　　　998420343                  Y                                   " 
						+ "R000000069912345678011000045622097004      0000000030000581215           KFTC       　　　998920034                  Y                                   " 
						+ "T99999999912345678EB31071000000006000000060000000090000                  1234567890                                                                   ";

		Iterable<String> result = Splitter.fixedLength(recordLen).split(content);
		
		Unmarshaller u = factory.createUnmarshaller(streamName);
		for (String record : result) {
			System.out.println("원문 [" + record + "]");

			Object o = u.unmarshal(record);
			
			// Parsing 결과
			System.out.println(o);
		}
		
	}
	
}
