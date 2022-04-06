# HAPPYHOUSE 리팩토링

<p align="center">
  <img src=images/image.png><br>
  <em>HAPPY HOUSE 프로젝트</em>
</p>

## 1. 프로젝트 내용

싸피 1학기 백엔드 커리큘럼을 마치고 진행한 관통 프로젝트이다.

구현한 내용은 아래와 같다.

### 1.1. 필수 기능

-   회원 관리 기능(로그인, 로그아웃)
-   아파트 실거래 가격 조회 기능
-   아파트 위치 지도 조회 기능(카카오 맵 API 사용)

### 1.2. 추가 기능

-   계정별 관심 지역 관리 기능
-   관심 지역 기준 동네 업종 정보 조회(카카오 맵 API 사용)

### 1.3. 심화 기능

-   공지사항 관리 기능

---

## 2. 현재 프로젝트의 문제점

-   도메인 접근은 슬래시를 이용하여 하는건 좋은데, 도메인의 하위 리소스에 접근할 때 쿼리스트링을 이용하여 접근하는건 무언가 어색하다.
    -   예) 현재 공지사항 리스트는 `http://localhost:8080/board?action=list`으로 접근한다.
    -   해결법) `http://localhost:8080/board/articles`처럼 디렉토리를 표현하는 `/`를 활용하여 리소스에 접근하도록 만든다. → 대신 서블릿 파일(컨트롤러)의 개수가 많아질 것이다.
-   각각의 컨트롤러에 중복되는 코드가 너무 많다. 심지어 앞서 말한 서블릿 파일의 수가 많아진다면 더욱 중복이 많아져 후에 유지보수에 불리한 코드가 될 것이다.
    -   해결법) 스프링의 `Dispatcher Servlet`처럼 `FrontController`패턴을 활용해서 중복되는 부분을 프론트 컨트롤러에서 처리한 후 각각의 컨트롤러에게 넘겨준다.
-   DTO를 생성하고 setter로 필드에 값이 입력되는 부분이 너무 많다. 가독성이 좋아보이지 않는다.
    -   예)
        ```java
        MemberDto dto = new MemberDto();

        dto.setId(request.getParameter("id"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        dto.setNickname(request.getParameter("nickname"));
        dto.setEmail(request.getParameter("email"));
        dto.setTel(request.getParameter("tel"));

        int result = memberService.join(dto);
        ```
    -   해결법) 이펙티브 자바 초반부에 `생성자에 매개변수가 많다면 빌더를 고려하라`는 말이 있다. 빌더 패턴으로 구현한다면 코드의 가독성을 높일 수 있을거라 생각이 든다.
-   리소스 파일(JSP)이 네이밍 규칙이 들쑥날쑥해서 알아보기 쉽지 않다.
    -   예) `getDongPrice.jsp`는 동별 아파트 실거래 가격 조회 페이지인데 이름만 보고 알기 쉽지 않다.
    -   해결법) 컨벤션을 정해서 이름을 확실하게 알 수 있게 정한다.

---

## 3. 개발 환경

톰캣 서버를 간단하게 연결하기 위한 용도로 스프링 부트 환경에서 개발한다. 스프링 프레임워크를 일절 사용하지 않고 현재 관통 프로젝트처럼 오직 서블릿과 JSP(JSTL, EL)만 사용해서 구현할 예정이다.
