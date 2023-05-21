<template>
  <div>
    <header class="">
      <div class="container2">
        <div class="fullimage">
          <img class="profile-full-img" src="..\assets\prgile_full.png" alt="..." />
        </div>
        <div class="ments">
          <i class="bi bi-bell-fill">
            시도하지 않는 슛은 100% 실패이다.
          </i>
          <div class="buttons">
            <a href="list"><i class="bi bi-activity">상체</i></a>
            <a href="list"><i class="bi bi-activity">하체</i></a>
            <a href="list"><i class="bi bi-activity">코어</i></a>
            <a href="list"><i class="bi bi-activity">유산소</i></a>
          </div>
        </div>
      </div>
    </header>
    <br /><br />
    <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xxl-start mb-3"></div>
    <div class="percentbar">
      <h2>운동량 80% <br><br></h2>
      <progress id="progress" value="80" min="0" max="100"></progress>
    </div>
    <br />
    <br />
    <!-- About Section-->
    <section class="bg-light py-5">
      <div class="container px-5">
        <div class="row gx-5 justify-content-center">
          <div class="col-xxl-8">
            <div class="text-center my-5">
              <h2 class="display-5 fw-bolder">
                <span class="text-gradient d-inline">About our service</span>
              </h2>
              <p class="lead fw-light mb-4">
                우리는 원하는 체력 증진 · 체중 감량 · 근력 증가를 할 수 있게
                도와줍니다.
              </p>
              <p class="text-muted">
                개인별 운동량과 운동 부위의 피로도를 가지고 운동을 추천해
                줍니다. 퍼센트를 가지고 운동의 피로도를 고려해서 운동을 추천해
                줍니다. 영상을 시청하면 운동량이 증가하고 잠에 들면 피로도가
                감소합니다.
              </p>
              <div class="d-flex justify-content-center fs-2 gap-4">
                <a class="text-gradient" href="https://twitter.com/"><i class="bi bi-twitter"></i></a>
                <a class="text-gradient" href="https://www.linkedin.com/"><i class="bi bi-linkedin"></i></a>
                <a class="text-gradient" href="https://github.com/"><i class="bi bi-github"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Footer-->
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
            <a class="small" href="#!" onclick="alert(' ssafy@ssafy.com 로 문의 바랍니다.')">문의</a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>



    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>

<script>
export default {

}
</script>

<style>
 @import '/css/styles.css';

</style>