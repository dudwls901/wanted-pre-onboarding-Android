# wanted-pre-onboarding-Android
프리 온보딩 사전 과제 뉴스 앱

# TopNews
<img width="220" height="420" alt="topnews" src="https://user-images.githubusercontent.com/66052467/189525422-dc032d4c-b748-41a2-9ed9-41a2f0574c4c.png"><img width="220" height="420" alt="topnews_detail" src="https://user-images.githubusercontent.com/66052467/189525411-c30a204e-ee85-47db-84c6-6278ff01b4f5.png">

# Categories
<img width="220" height="420" alt="category" src="https://user-images.githubusercontent.com/66052467/189525492-178c56ad-3e88-4efc-84b8-86a2d4ef382e.png"><img width="220" height="420" alt="category_list" src="https://user-images.githubusercontent.com/66052467/189525506-34378c27-ff4b-4d73-85a8-c26f3b32dec2.png"><img width="220" height="420" alt="category_detail" src="https://user-images.githubusercontent.com/66052467/189525516-4af19519-5af8-4999-bd9f-9250c774303f.png">

# Saved News
<img width="220" height="420" alt="saved_empty" src="https://user-images.githubusercontent.com/66052467/189525540-7e2b0b39-65d1-48b8-9aef-cb33dc338b25.png"><img width="220" height="420" alt="saved_list" src="https://user-images.githubusercontent.com/66052467/189525544-6d678019-0a3f-4e5e-a0fd-30efbe06974e.png"><img width="220" height="420" alt="saved_detail" src="https://user-images.githubusercontent.com/66052467/189525546-f3c0c786-38b0-4fff-b698-a33d3bc83397.png">

## TODO
- Paging
- Multiple Backstack(Navigation-Bottomnavigationview)
  - 탭의 첫 페이지에도 '<-'버튼 생성되는 이슈
  - Top News 탭에서 newsDetail 프래그먼트까지 활성화하고 Categories 탭으로 넘어간 후 다시 Top News 탭 클릭하면 화면은 newsDetail 프래그먼트이지만 탭은 여전히 Categories가 활성화되는 이슈
  <img width="220" height="420" alt="issue" src="https://user-images.githubusercontent.com/66052467/189526425-396fe1f7-3110-4d5e-a325-161271381c26.png">

## 🪒Stacks
- MVVM pattern 
- Navigation : 프래그먼트 관리
- LiveData : 생명주기에 따른 데이터 관리
- ViewModel : UI 데이터 저장 및 데이터 로직 캡슐화
- Retrofit2, Gson, OkHttp3 : 네트워킹
- Coroutine : 비동기 처리
- DataBinding : 데이터와 뷰 연결
- Room : 로컬 데이터베이스
- Glide : 이미지 로드
