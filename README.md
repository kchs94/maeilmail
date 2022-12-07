## 프로젝트 요약

기술 면접 대비를 위한 매일 메일 서비스입니다.

매일 매일

학교 수업, 과제, 프로젝트, 이직 준비로 바쁜 와중에도 

예상 질문을 매일 아침 7시마다 메일로 보내주는 서비스이며 이용자들이 예상 질문에 대한 답변을 작성할 수 있는 게시판과 서로 정보 공유 및 일상을 공유할 수 있는 자유 게시판, 서비스에 대한 건의를 할 수 있는 건의 게시판이 있습니다.

원하는 카테고리를 구독하여 해당 카테고리에 대한 질문을 메일로 받으실 수 있습니다.


## 프로젝트 목표

- 프론트엔드와 백엔드 소통 연습하기
  
- 새로운 서비스를 실제로 배포하여 다른 사람들이 직접 사용할 수 있게 만들기
  

## 기간

- 5주 : 2022.09.07(수) ~ 2022.10.12(수)

## 팀 소개

| [한정윤](https://github.com/JungYunHan) | [이창훈](https://github.com/anotheranotherhoon) | [김충섭](https://github.com/kchs94) | [김수빈](https://github.com/soobinkim-kor) |
| :---: | :---: | :---: | :---: |
| ![](https://github.com/JungYunHan.png) | ![](https://github.com/anotheranotherhoon.png) | ![](https://github.com/kchs94.png) | ![](https://github.com/soobinkim-kor.png) |
| Frontend(팀장) | Frontend | Backend | Backend |

## 서비스 동작 화면

### 렌딩페이지

![ 렌딩페이지](https://user-images.githubusercontent.com/49191949/206222525-ae52f68e-3494-459c-82df-98f31d64f61a.gif)



### 회원가입 페이지

![회원가입](https://user-images.githubusercontent.com/49191949/206223541-bed9e269-12c0-47a9-982e-c529a967823c.gif)



### 로그인 페이지

![로그인](https://user-images.githubusercontent.com/49191949/206223704-96e58804-ac3f-4c2e-b560-2ccce861623f.gif)



### 구독 페이지

![구독페이지](https://user-images.githubusercontent.com/49191949/206223787-00876bf6-862c-4f15-bf4b-a2c0b3a935dd.gif)



### 이메일로 데일리 기술질문 전송

![이메일](https://user-images.githubusercontent.com/49191949/206223952-b8d66f51-8470-43f5-847b-8e8ce667d343.gif)



### 질문/답변 게시판 및 검색기능

![질문게시판](https://user-images.githubusercontent.com/49191949/206223994-d5998854-b64e-4a5b-a994-c3585437e83f.gif)



### 답변게시판

![답변게시판](https://user-images.githubusercontent.com/49191949/206224296-43bead5d-4027-4007-baef-9f3f46b4bab4.gif)



### 자유/건의 게시판

![자유게시판](https://user-images.githubusercontent.com/49191949/206224779-cec97f4f-cb96-4536-bf28-f4cbe37002d0.gif)



### 글작성 페이지

![글작성페이지](https://user-images.githubusercontent.com/49191949/206224823-102e6b35-e0f3-4693-8e38-b639d5e46ea2.gif)

### 마이페이지

![마이페이지](https://user-images.githubusercontent.com/49191949/206224959-8529fcaf-6630-41cf-93d9-bb80646900f2.gif)





### 프로젝트 구조

![구조](https://user-images.githubusercontent.com/49191949/206225575-63cfe312-3177-4b07-8a2e-999cf432787c.png)



## 기술 스택

### FrontEnd

- `HTML`
- `CSS`
- `Javascript`
- `React`
- `Redux Toolkit`
- `Styled Components`
- `Axios`
- `Toast`
- `React Scroll Motion`

### **BackEnd**

- `Java 11`
- `Gradle 7.4.2`
- `Spring Boot 2.7.3`
- `H2`
- `MySQL`
- `Spring Data JPA`
- `Spring Security`
- `JWT`
- `Spring Validation`
- `Lombok`
- `Mapstruct`
- `Swagger`
- `Google SMTP`

### **배포**
- `AWS EC2`
- `AWS amplify`
- `AWS S3`
- `AWS RDS`

### **문서/협업**

- `Github Projects`
  - `Issue`
  - `Milestones`
- `Git`
- `Slack`
- `Zoom`

### 브랜치 전략

- `git flow`
  
  - main : 운영환경에서 사용되는 브랜치입니다.
    
  - dev: 개발환경에서 사용되는 브랜치입니다.
    
  - feat: 기능을 개발할 때 사용되는 브랜치입니다.
    

## 기능 정의

- 회원가입
  
- 토큰을 이용한 유저 판별
  
- 로그인/로그아웃

- 프로필 사진, 프로필 닉네임, 비밀번호 수정 
  
- 유저 등록, 수정, 조회

- 질문 등록, 수정, 삭제, 조회

- 답변 등록, 수정, 삭제, 조회

- 댓글 등록, 수정, 삭제, 조회

- 게시판 페이징

- 게시글 검색

- Light/Dark 모드

- 질문, 답변 좋아요

- 회원 구독 카테고리 메일 전송

## API 문서
회원 관련 API
https://documenter.getpostman.com/view/21358738/2s83mbpjZN

게시글 관련 API
https://documenter.getpostman.com/view/15776280/2s83maLkak

## Figma
https://www.figma.com/file/b2KuIpCLIvchUL8sai0pQE/Untitled?node-id=0%3A1

## 엔티티 클래스 다이어그램
https://drive.google.com/file/d/11KQgu9tFPHk1Sj8x9bjyvWXCxsZWwf6V/view?usp=sharing 
