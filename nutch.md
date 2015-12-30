# Nutch

 - 설치
  - [다운로드](http://nutch.apache.org/downloads.html)
  - 버전 : 1.11
  - 압축해제

 - 설치 확인
 ```
 $ bin/crawl
 Usage: crawl [-i|--index] [-D "key=value"] [-w|--wait] <Seed Dir> <Crawl Dir> <Num Rounds>
        -i|--index      Indexes crawl results into a configured indexer
        -D              A Java property to pass to Nutch calls
        -w|--wait       NUMBER[SUFFIX] Time to wait before generating a new segment when no URLs
                        are scheduled for fetching. Suffix can be: s for second,
                        m for minute, h for hour and d for day. If no suffix is
                        specified second is used by default.
        Seed Dir        Directory in which to look for a seeds file
        Crawl Dir       Directory where the crawl/link/segments dirs are saved
        Num Rounds      The number of rounds to run this crawl for
 ```
 
 - 환경설정

   - conf/nutch-default.xml 

       - http.agent.name 설정
       
         ```xml
         <property>
            <name>http.agent.name</name>
            <value>CrawlBot</value>
         </property>  
         ``` 
   
- Crawl 예제   

   - 대상 설정

   - 실행
    ```sh
     $ bin/crawl urls crawl 3
     
    ```
