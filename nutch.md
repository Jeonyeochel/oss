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
       ```sh
       $ mkdir urls
       $ echo http://nutch.apache.org > urls/seed.txt
       ```

   - 실행
      ```sh
       $ bin/crawl urls crawl 3
       Injecting seed URLs
       /csehome/poshi/apache-nutch-1.11/bin/nutch inject crawl/crawldb urls
       Injector: starting at 2015-12-30 15:11:28
       Injector: crawlDb: crawl/crawldb
       Injector: urlDir: urls
       Injector: Converting injected urls to crawl db entries.
       Injector: Total number of urls rejected by filters: 0
       Injector: Total number of urls after normalization: 1
       Injector: Merging injected urls into crawl db.
       Injector: overwrite: false
       Injector: update: false
       Injector: URLs merged: 1
       Injector: Total new urls injected: 0
       Injector: finished at 2015-12-30 15:11:32, elapsed: 00:00:03
       Wed Dec 30 15:11:32 KST 2015 : Iteration 1 of 3
       Generating a new segment
       ...
       DeduplicationJob: starting at 2015-12-30 15:22:09
       Deduplication: 90 documents marked as duplicates
       Deduplication: Updating status of duplicate urls into crawl db.
       Deduplication finished at 2015-12-30 15:22:15, elapsed: 00:00:05
       Skipping indexing ...
       Wed Dec 30 15:22:15 KST 2015 : Finished loop with 3 iterations
      ```

   - 정보확인
      ```sh
      $ bin/nutch readdb crawl/crawldb/ -stats
      CrawlDb statistics start: crawl/crawldb/
      Statistics for CrawlDb: crawl/crawldb/
      TOTAL urls:     12067
      retry 0:        12060
      retry 1:        7
      min score:      0.0
      avg score:      1.961548E-4
      max score:      1.131
      status 1 (db_unfetched):        10891
      status 2 (db_fetched):  768
      status 3 (db_gone):     103
      status 4 (db_redir_temp):       57
      status 5 (db_redir_perm):       156
      status 7 (db_duplicate):        92
      CrawlDb statistics: done
      ```
