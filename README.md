# 전기차 충전소 조회 서비스 "Elecar"의 Android 버전입니다.

## 기능 구현 목록

### 기본 UI 제작
프론트 파트의 피그마 디자인에 따라 제작


- 홈 화면
    - 카카오 지도 API 받아오기
    - 검색 창 구현
    - 바텀시트 구현
- 스플래시 스크린 넣기
- 시작 시 회원가입 및 로그인 페이지 구현


### 동작
- 홈 화면
    - 카카오 지도
        - 서버에서 받아온 충전소 위치가 마커로 표시
        - 사각 범위 기준 조회
        - 마커 클릭 시 바텀 시트에 해당 충전소의 정보가 표시됨
        - 그 외 추가 기능 구현


    - 검색 창
      - 기본 위치는 카카오 맵 위에 플로팅 되어있음
      - 검색 바 클릭 시 검색 기록이 나옴
      - chargerStation name을 기준으로 검색
      - 필터 기능 추가 예정

  
    - 바텀 시트
      - 주변 클릭 시 내 위치 기준 주변 충전소 위치 받아옴  -> 지도 마커 표시
        - 바텀 시트를 끝까지 올리면 리뷰 내역 표시, 길찾기 버튼 표시
          - 리뷰 작성 시 새로운 리뷰 작성 창으로 넘어감 (바텀시트 X), 내용과 별점 입력 가능
          - 길찾기 버튼 클릭 시 카카오 맵으로 자동 연동 (브라우저)
      - 내 정보 클릭 시 프로필 사진, 닉네임과 프로필 수정 버튼, 설정 버튼, 최근 목록, 리뷰 내역 표시
        - 리뷰 내역 클릭 시 내가 쓴 리뷰 내역과 평균 별점 표시
        - 리뷰 내역은 수정 및 삭제 가능
        - 프로필 수정 버튼 클릭 시 닉네임, 프로필사진 변경 가능


- 스플래시 화면 및 회원 가입
    - 초기 앱 구동 시 스플래시 화면 -> 로그인이 안되어 있을 시 계정만들기/로그인 화면으로 넘어감
        - 계정 만들기 클릭 시 로컬 계정 생성
            - 회원 가입 약관, 정보 입력, 회원가입 완료 창으로 구성