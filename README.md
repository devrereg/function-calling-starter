# Function Calling 실습 — 시작 코드 (주문 조회 사례)

## 준비
- JDK 17+, Maven (또는 IDE 내장 Maven)
- OpenAI API 키: 프로젝트 루트에서 `.env.example`을 복사해 `.env`를 만들고 키를 넣습니다.
  ```bash
  cp .env.example .env   # 그다음 .env 파일의 OPENAI_API_KEY 값을 수정
  ```
  - `application.yml`의 `spring.config.import`가 `.env`를 읽습니다. 프로젝트 루트에서 실행해야 합니다.
  - `.env`는 `.gitignore`에 들어 있어 커밋되지 않습니다.
- 모델: `gpt-4o-mini`
  
- 실행: `mvn spring-boot:run` 또는 IDE에서 `FunctionCallingApplication` 실행

## 테스트 데이터
| 주문 번호 | 소유자 | 상품 | 상태 | 도착 예정 |
|---|---|---|---|---|
| ORD-1001 | user-1 | 무선 키보드 | 배송중 | 2026-11-24 |
| ORD-1002 | user-1 | USB-C 허브 | 배송완료 | 2026-11-18 |
| ORD-2001 | user-2 | 게이밍 모니터 | 배송준비중 | 2026-11-27 |

## 수정할 파일
- `tool/OrderTools.java`
- `web/ChatController.java`




## 확인용 요청
```bash

curl -s -G localhost:8080/chat -H "X-User-Id: user-1" --data-urlencode "message=ORD-1001 언제 도착해요?"

```
