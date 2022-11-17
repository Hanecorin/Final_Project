# PLAY DATA TALK

<img width="525" alt="스크린샷 2022-11-17 오후 11 48 32" src="https://user-images.githubusercontent.com/105684835/202477865-d2f53246-6081-4ebf-ac36-f972c42ed785.png">

<br>

## 📋 서비스
### `PLAY DATA TALK`은 플레이데이터 학생들을 위한 소통공간입니다.
#### 온오프라인, 기수, 교육과정 상관없이 모든 플레이데이터 학생들이 소통할 수 있는 공간을 만들고 싶었습니다.

## ✏️ 목표

- 기존 SNS와 유사한 글 작성, 삭제, 좋아요, 댓글 및 프로필 보기 구현
- 글 작성 시 사용자가 직접 키워드를 작성해도 되지만 머신 러닝 모델을 통해 키워드 추천 받기
- Search 기능을 통해 키워드가 들어간 게시 글 조회하기
- 가장 많이 언급 된 키워드 상위 5개 시각화 하여 보여주기
- AWS를 이용하여 배포하기 ❌ ➡️  비용, 성능 문제로 인해서 GCP(Google Cloud Platform)을 이용한 배포를 하기

<br>

## 👨‍👧‍👧 팀원

- [한예찬](https://github.com/Hanecorin) : `FireBase 기반 회원가입, 로그인 구현 & Front & Back 통합 테스트, UI, 발표`
- [최우성](https://github.com/perfumemakes) : Spring Boot 기반 REST API 개발, DataBase 구축
- [김규리](https://github.com/jkl1212) : FireBase 기반 회원가입, 로그인 구현
- [김민성](https://github.com/mswork0616) : 키워드 Leaning, GCP(Google Cloud Platform)이용 배포
- [이세하](https://github.com/Mudeon47) : REST API 연동, React.JS 기반 Front 기능구현

<br>

## 🗓 프로젝트 기간
2022.10.17 ~ 2022.11.10

<br>

## ⚙ 개발 환경

- Front End : <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">  <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=Firebase&logoColor=white">

- Back End : <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">

- Machine-learning : <img src="https://img.shields.io/badge/Flask-000000?style=for-the-badge&logo=Flask&logoColor=white"> <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white"> 

- Data Base : <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=Firebase&logoColor=white">

- Deployment : <img src="https://img.shields.io/badge/Google%20Cloud-4285F4?style=for-the-badge&logo=GoogleCloud&logoColor=white">

- IDE : <img src="https://img.shields.io/badge/Spring%20Tool%20Suite-6DB33F.svg?style=for-the-badge&logo=spring-ool-suite&logoColor=white"> <img src="https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white"> <img src="https://img.shields.io/badge/Jupyter-F37626.svg?style=for-the-badge&logo=Jupyter&logoColor=white"> 

- Communication Tools : <img src="https://img.shields.io/badge/Jira Software-0052CC.svg?style=for-the-badge&logo=Jira Software&logoColor=white"> <img src="https://img.shields.io/badge/slack-4A154B.svg?style=for-the-badge&logo=slack&logoColor=white"> <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">

<br>

## ⌗ Data Table

![image](https://user-images.githubusercontent.com/105684835/202476929-9efe9416-c87c-43e0-aa0d-6cc1210a2393.png)

<br>

## 💁‍♂️ 기능 화면

![image](https://user-images.githubusercontent.com/105684835/202464798-920cd5af-d89e-4ed2-8d62-db1c49a14af7.png)

<img width="713" alt="스크린샷 2022-11-17 오후 11 53 10" src="https://user-images.githubusercontent.com/105684835/202479076-be0de902-b8f5-457d-9a78-51175fb95c30.png">


### 로그인 및 회원가입페이지

- Firebase를 이용한 로그인 및 회원가입
  - FirebaseAuthentication 에 회원가입시 정보저장, 동시에 MySQL에도 똑같이 회원정보 저장
  - Firebase를 이용하여 Email 중복, 비밀번호 자릿수 검증

<br>

![image](https://user-images.githubusercontent.com/105684835/202480224-a26c91ef-ffd5-4d9c-98ab-352aaa377b7e.png)

<img width="696" alt="스크린샷 2022-11-18 오전 12 00 47" src="https://user-images.githubusercontent.com/105684835/202481041-d6233450-5ba0-433f-8ed8-93e7bd7f8225.png">

### 메인페이지

- 모든 사용자의 게시글 불러오기
  - 위에서부터 최신글을 불러온다
  - 좋아요 버튼 기능을 추가하여 좋아요,좋아요 취소를 가능하게 하였다.
- 네비게이션 바를 고정시키고 게시글만 스크롤로 불러오게 구현하였다.
  - 네비게이션 바에 메뉴들을 포함시켜 해당 기능들로 이동가능하게 만들었다.
- 글쓰기 버튼을 누르면 작성페이지로 이동

<br>

<img width="710" alt="스크린샷 2022-11-18 오전 12 02 03" src="https://user-images.githubusercontent.com/105684835/202481334-96b2748c-f491-49ea-8645-8792cfecace4.png">

- Search 기능을 통해 해쉬태그, 글 내용안에 포함되어있는 단어로 글을 검색한다.

<br>

![image](https://user-images.githubusercontent.com/105684835/202481611-8f171f20-4e04-403e-bb4d-f7a86791bdba.png)

- Keyword 메뉴에선 지금까지 등록된 키워들을 집계하여 그래프로 보여준다.
  - 집계수가 가장 높은 키워드부터 보여준다.
  
<br>

![image](https://user-images.githubusercontent.com/105684835/202482023-8f14ddfe-66a1-4ef5-a1f7-1da0f10eb861.png)

<img width="700" alt="스크린샷 2022-11-18 오전 12 04 56" src="https://user-images.githubusercontent.com/105684835/202482070-325a01e8-81e7-4147-9287-06fe69d4edcc.png">


- Profile 메뉴를 통해 자신의 Profile 확인, 자신의 게시글 확인.
  - 닉네임 수정을 버튼을눌러 닉네임 수정을 가능하게 하였다.
  - 자신의 게시글을 수정/삭제 할 수 있다.
  - 접속시 가입했던 email 주소를 보여준다.

<br>

<img width="704" alt="스크린샷 2022-11-18 오전 12 07 27" src="https://user-images.githubusercontent.com/105684835/202482652-7b5b38e0-e6d6-4397-b228-a8bdf82912ca.png">

<img width="697" alt="스크린샷 2022-11-18 오전 12 07 46" src="https://user-images.githubusercontent.com/105684835/202482739-10da9936-3ab8-42de-bece-4d35c4d72dfc.png">

- 글쓰기 버튼을 통해 글을 작성할 수 있다.
  - 글 내용을 입럭하고 키워드추천 버튼을 누르면 내용에 어울리는 키워드가 3개 생성된다.
  - 저장 후 게시물 업로드가 되어있고 수정/삭제가 가능하다.
  
  
<br>


## 🎞 시연 영상
[![PLAY DATA TALK 서비스 시연영상](https://user-images.githubusercontent.com/105684835/202490662-7b7f7de0-87a4-4312-84c5-055bde0ae260.png)](https://youtu.be/Rx2oEc5BLsc)
