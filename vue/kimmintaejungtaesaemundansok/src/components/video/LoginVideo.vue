 <template>
  <div class="container3">
    <div class="video-container" v-if="showVideo" :key="youtubeId">
      <iframe
        :src="youtubeUrl"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      ></iframe>
    </div>

    <div class="timer-container">
      <div class="timer">{{ formattedTime }}</div>
      <button class="end-button" @click="finishExercise">
        Exercise finished
      </button>
    </div>
  </div>
  <!-- 여기까지 이동 -->
</template>

<script>
import http from "../../util/http-common";

export default {
  data() {
    return {
      time: 0,
      intervalId: null,
      youtubeId: "", // YouTube 동영상의 ID 값을 저장할 변수
      videoLength: 0, // 영상의 길이를 저장할 변수
      showVideo: false, // 동영상 표시 여부를 저장할 변수
    };
  },
  computed: {
    formattedTime() {
      const minutes = Math.floor(this.time / 60);
      const seconds = this.time % 60;
      return `${minutes < 10 ? "0" : ""}${minutes}:${
        seconds < 10 ? "0" : ""
      }${seconds}`;
    },
    youtubeUrl() {
      return `https://www.youtube.com/embed/${this.youtubeId}?autoplay=1&mute=0`; // autoplay와 mute 옵션 추가
    },
  },
  methods: {
    startTimer() {
      this.intervalId = setInterval(() => {
        this.time++;
        if (this.time >= this.videoLength * 60) clearInterval(this.intervalId);
      }, 1000);
    },
    finishExercise() {
      clearInterval(this.intervalId);

      http({
        url: "/user/record",
        method: "PUT",
        params: {
          date: "",
          exTime: Math.round(this.time / 60),
          th: 0,
          user_id: sessionStorage.getItem("user"),
        },
      });

      alert(
        "고생하셨습니다! 운동시간: " +
          Math.round(this.time / 60) +
          "분 \n\n운동 시간이 기록됩니다..."
      );

      this.$router.push({ path: "/" });
    },
    getVideoLength() {
      const videoId = this.youtubeId;
      http
        .get(`/video/play/${videoId}`) // API 엔드포인트
        .then((response) => {
          const videoData = response.data;
          if (videoData.length) {
            this.videoLength = videoData.length; // 영상의 길이를 변수에 저장
            this.showVideo = true; // 동영상 표시
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  mounted() {
    const youtubeId = this.$route.query.youtube_id; // 링크에서 전달된 youtube_id 값을 가져옴
    this.youtubeId = youtubeId; // youtubeId 변수에 할당
    this.getVideoLength(); // 영상의 길이를 가져오기 위해 호출
    this.startTimer();
    setTimeout(() => {
      window.scrollTo(0, document.body.scrollHeight);
    }, 0);
  },
};
</script>

<style>
.container3 {
  background-color: black; /* 검정색 배경 */
  height: 67rem; /* 원하는 높이로 조정 */
}

</style>