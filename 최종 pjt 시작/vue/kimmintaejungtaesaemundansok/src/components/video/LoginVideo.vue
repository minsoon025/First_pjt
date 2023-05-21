<template>
  <div>
    <section class="">
      <div class="container3">
        <div class="video-container">
          <!-- 운동 영상을 삽입하세요 -->
          <iframe
            src="https://www.youtube.com/embed/kdjqgylQBTg"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
          ></iframe>
        </div>
        <div class="timer-container">
          <div class="timer">{{ formattedTime }}</div>
          <a href="list">
          <button class="end-button" @click="finishExercise">
            Exercise finished
          </button></a>
        </div>
      </div>
    </section>

    <!-- Footer-->
    <footer class="bg-black py-4 mt-auto">
      <div class="container px-5">
        <div class="row align-items-center justify-content-between">
          <div class="col-auto">
            <div class="small m-0">
              &copy; 김민태정태세문단속 Website 2023
            </div>
          </div>
          <div class="col-auto">
            <a
              class="small"
              href="#!"
              onclick="alert('서울특별시 강남구 역삼동 테헤란로 212')"
            >
              오시는 길
            </a>
            <span class="mx-1">&middot;</span>
            <a
              class="small"
              href="#!"
              onclick="alert('ssafy@ssafy.com으로 문의 바랍니다.')"
            >
              문의
            </a>
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
  data() {
    return {
      time: 0,
      intervalId: null
    };
  },
  computed: {
    formattedTime() {
      const minutes = Math.floor(this.time / 60);
      const seconds = this.time % 60;
      return `${minutes < 10 ? '0' : ''}${minutes}:${
        seconds < 10 ? '0' : ''
      }${seconds}`;
    }
  },
  methods: {
    startTimer() {
      this.intervalId = setInterval(() => {
        this.time++;
      }, 1000);
    },
    finishExercise() {
      clearInterval(this.intervalId);
      alert('고생하셨습니다!');
      alert('운동 시간이 기록됩니다......');
    }
  },
  mounted() {
    this.startTimer();
  }
};
</script>

<style>
 @import '/css/styles.css';
</style>