<template>
  <div>
    <section class="py-5">
      <div class="container px-5 mb-5">
        <div class="text-center mb-5">
          <h1 class="display-5 fw-bolder mb-0">
            <span class="text-gradient d-inline">운동 영상 리스트</span>
          </h1>
        </div>
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-11 col-xl-9 col-xxl-8">
            <!-- Project Card 1 -->
            <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
              <div class="card-body p-0">
                <div class="d-flex align-items-center">
                  <div class="p-5">
                  <a class="senddetail" href="video" @click="showAlert1">
                      <h2 class="fw-bolder">내 이런 이런 운동입니다.</h2>
                      <p>
                        간단한 운동과 설명과, 추가하고 싶으면 난이도나, 간단한
                        설명이 들어가면 좋을 듯합니다. 힘들땐 다같이 침토리~!!!
                      </p>
                    </a>
                  </div>
                  <img class="img-fluid" src="..\assets\침토리.png" alt="..." />
                </div>
              </div>
            </div>
            <!-- Project Card 2 -->
            <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
              <div class="card-body p-0">
                <div class="d-flex align-items-center">
                  <div class="p-5">
                  <a class="senddetail" href="video" @click="showAlert1">
                      <h2 class="fw-bolder">내 이런 이런 운동입니다.</h2>
                      <p>
                        간단한 운동과 설명과, 추가하고 싶으면 난이도나, 간단한
                        설명이 들어가면 좋을 듯합니다. 힘들땐 다같이 침토리~!!!
                      </p>
                    </a>
                  </div>
                  <img class="img-fluid" src="..\assets\침토리.png" alt="..." />
                </div>
              </div>
            </div>
            <!-- Project Card 3 -->
            <div class="card overflow-hidden shadow rounded-4 border-0">
              <div class="card-body p-0">
                <div class="d-flex align-items-center">
                  <div class="p-5">
                  <a class="senddetail" href="video" @click="showAlert1">
                      <h2 class="fw-bolder">내 이런 이런 운동입니다.</h2>
                      <p>
                        간단한 운동과 설명과, 추가하고 싶으면 난이도나, 간단한
                        설명이 들어가면 좋을 듯합니다. 힘들땐 다같이 침토리~!!!
                      </p>
                    </a>
                  </div>
                  <img class="img-fluid" src="..\assets\침토리.png" alt="..." />
                </div>
              </div>
            </div>
            <!-- 카드 섹션 -->
          </div>
        </div>
      </div>
    </section>

    <!-- Call to action section -->
    <section class="py-5 bg-gradient-primary-to-secondary text-white">
      <div class="container px-5 my-5">
        <div class="text-center">
          <h2 class="display-4 fw-bolder mb-4">우리 모두 건강해져요!</h2>
          <a class="btn btn-outline-light btn-lg px-5 py-3 fs-6 fw-bolder" href="/list">전체 운동 하기</a>
        </div>
      </div>
    </section>
    
    <!-- Footer -->
    <footer class="bg-white py-4 mt-auto">
      <div class="container px-5">
        <div class="row align-items-center justify-content-between flex-column flex-sm-row">
          <div class="col-auto">
            <div class="small m-0">
              Copyright &copy; 김민태정태세문단속 Website 2023
            </div>
          </div>
          <div class="col-auto">
            <a class="small" href="#!" onclick="alert('서울특별시 강남구 역삼동 테헤란로 212')">오시는 길</a>
            <span class="mx-1">&middot;</span>
            <a class="small" href="#!" onclick="alert('ssafy@ssafy.com로 문의 바랍니다.')">문의</a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>



  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js">  </script>

<script>
export default {
  methods: {
    showAlert1() {
      alert("확인을 누르면 운동이 바로 시작됩니다! 준비 되셨나요!!!!!"); // 원하는 경고 창 내용으로 변경
    }
  }
}
</script>

<style>
 @import '/css/styles.css';      

</style>