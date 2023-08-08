# com.yunbo3.book


문제
1. 보안이슈로 실행이안되는 현상발생
해결:SecurityConfig클래스 생성해서 기본 사용자 정의해서 인증해서 실행함
2. 인텔리제이랑 github랑 연동시킴. 다만 파일확인시 .class파일상에선 아무 내용이 안보임 
실제로 파일을 다운로드해서 확인하면 내용이 들어있는것을 확인.
해결: .class파일은 바이너리코드로  컴파일된 JAVA클래스 파일이기에 github에서 아무 내용도 없어 보일 수가 있다.
3. (2)번 문제 확인차 remote master 브랜치의 파일을 내려받고 파일비교 수행과정에서 어플리케이션이 작동안하는 현상이발생.
해결:파일.ignore파일에 gradle파일 추가한걸 잊어버렸었다.
4. Cannot open Local Terminal 터미널실행이안되는 현상
해결:File-Settings-terminal에서 powershell 경로 확인. cmd.ext로 실행
5. 룸북기능테스트코드 실행시 gradle 버전 차이로 실행이 안되는 현상 발생
터미널에 gradlew wrapper --gradle-version 4.10.2 로 다운그레이드 시도해봤으나 실패
해결:gradle-wrapper-gradle-wrappper.properties에서 distributionUrl란의 gradleversion을 4.10.2로 바꿈
	

 
  


