# KoreAuaProjectSpring


# 💧KoreAqua

수질 조회 사이트 팀 프로젝트 5조 - KoreAqua webSite

## Project 소개

실생활에서 접하는 물, 수질에 대해 정보를 얻기위해 공공API를 활용하여, 가정에서 사용하는 수돗물, 약수터, 해수욕장의 수질 검색 기능을 구현하였다. 추가로 물에 대한 정보를 안내하기 위해 한국의 5대강(한강, 금강, 낙동강, 섬진강, 영산강)의 근처 주요 관광지와 추천 여행 코스, 물에 관한 궁금한 단어의 정의를 검색해볼 수 있는 물과 백과사전, 사용자가 Website 서비스에 대한 궁금한 점을 문의 할 수 있는 Q&A 게시판을 구현하였다.

## Function

1. 🚿지역별 수돗물 수질 조회
    - 일/주/월 별 원하는 지역별, 기간별 수질 조회
    - 공공데이터 포털의 openAPI 활용
    - Modal창을 사용해 Onclick event를 걸어 원하는 정보 출력
    - 지역 검색의 경우 ajax 비동기처리, 날짜 검색은 Jquery의 Datepicker 사용
    - 출력 정보 내용
        - 일별 검색 : 검사년월, 맛, 색도, pH, 탁도, 잔류염소
        - 주별 검색 : 측정일, 일반 세균, 총 대장균, 대장균, 암모니아성질소, 질산성질소, 증발 잔류물
        - 월별 검색 : 검사년월, 맛, 색도, pH, 탁도, 잔류염소, 일반세균, 대장균, 암모니아성질소, 증발잔류물
        

2.⛲약수터 수질 조회

- 전국 약수터 위치 및 검색을 기반으로 약수터 수질 데이터 제공
- 공공데이터 포털의 openAPI 활용
- 카카오맵 Web API 활용하여, 지도상의 클러스터method로 원하는 약수터를 클릭하여 약수터 수질 정보를 출력 or selectBox를 이용해 원하는 지역을 선택 후 조회버튼을 이용하여 약수터 수질 정보 출력
- 지역검색의 경우, Ajax 비동기처리.
- 출력 정보 내용
    - 약수터명, 이용 인구수(일 기준), 수질검사일자, 수질검사 결과, 부적합항목, 관리기관명, 기준일자

3. 🏖️해수욕장 수질 조회
- 전국 해수욕장 위치 및 검색을 기반으로 해수욕장 수질 데이터 제공
- 카카오맵 Web API, 공공데이터 포털의 openAPI 활용
- 지역을 선택 후, 해당 지역의 해수욕장들의 마커가 지도에 띄어지고, 원하는 해수욕장을 선택하면, 해당 해수욕장의 수질 정보 출력
- 해수욕장명을 이용하여 정보 검색 가능
- 출력 정보 내용
    - 시도명, 정점명, 대장균, 장구균, 적합여부, 검사년도, 길찾기
    

4. 🗺️물과 여행정보
- 5대강(한강, 금강, 낙동강, 섬진강, 영산강) 주변 여행코스 추천, 강 근처 명소 소개
- 공공데이터 포털의 openAPI 활용
- 강물 따라 코스의 경우, 5대강 권역 구분 지도를 클릭하여, 해당 강 주변의 추천 코스 정보 출력
- 강 근처 명소의 경우, 5대강 중 원하는 강명을 검색 하면, 해당 강 근처의 명소 정보 출력
- 정보 출력 결과 10페이지 단위로 페이징

5. 📗물과 백과사전
- 물에 관한 궁금한 단어의 정의를 검색해볼 수 있는 백과사전 기능
- 공공데이터 포털의 openAPI 활용
- 단어 검색 시, 해당 단어의 정의 출력
- 단어 검색 기능과, ㄱㄴㄷ 순의 자음 정렬 기능
- 페이지 당 10개 단어 출력하고, 하단에 페이징 처리

6. 📑Q&A
- 관리자 로그인
    - 게시글의 답글 기능(관리자 답변)
    - Client가 남긴 글에 대해 비밀번호 없이 접근 가능
- 게시판 작성, 삭제, 수정
- 게시판 글 작성 시 작성자 이메일로 답변예정 
- 글의 제목, 내용, 작성자를 이용해 게시글 검색 가능
- 게시글 작성 시 파일첨부(이미지 파일) 가능
- 게시판의 글번호, 제목, 작성자, 작성일, 조회수 확인 가능
- 하단에 게시글 갯수에 따라 페이징 처리


## 사용한 기술셋

- Web 개발

    BackEnd→

    Java, JDBC, Servelt, JSP, Oracle, Spring Framework

    FrontEnd→

    HTML, CSS, Javascript, JQuery, Ajax, ECMA6

- Spring FrameWork
    - Server : Tomcat 8.5.58
    - Database : Oracle 11g SQL Developer
    - IDE : eclipse, sts
    - Framework : Springboot 2.1.7
    - Java JDK ver. : 1.8
    - ORM : Mybatis(3.5.5), Mybatis-spring(2.0.5), JDBC, DataSource:dbcp2
- JAVA
    - JSP, Servelt, JDBC, JavaApplication, Spring, EL & JSTL
- WEB Front
    - html, css, Javascript, jQuery, bootstrap, tern.repository(1.2.1), Ajax

## 개발환경

- macOs
- Window 10
- Tomcat 8.5
- JAVA JDK 1.8 (Java SE Development Kit 8u211)
- Oracle 11g
- STS
