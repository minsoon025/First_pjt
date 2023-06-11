<template>
  <div>
    <section class="py-5">
      <div class="container px-5 mb-5">
        <div class="text-center mb-5">
          <h1 class="display-5 fw-bolder mb-0">
            <span class="text-gradient d-inline"> 운동 영상 리스트</span>
          </h1>
        </div>
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-11 col-xl-9 col-xxl-8">
            <!-- Project Card 1 -->
            <transition-group name="fade" mode="out-in">
              <div
                v-for="video in filteredVideos"
                :key="video.youtube_id"
                class="card overflow-hidden shadow rounded-4 border-0 mb-5"
              >
                <a
                  class="senddetail"
                  :href="'video?youtube_id=' + video.youtube_id"
                  @click="showAlert1(video)"
                >
                  <div class="card-body p-0">
                    <div class="d-flex align-items-center">
                      <div class="p-5">
                        <!-- 비디오 제목과 설명을 받아온다. -->
                        <h3 class="fw-bolder">{{ video.title }}</h3>
                        <p>{{ video.descript }}</p>
                        <p>영상길이 : {{ video.length }}분</p>
                      </div>
                      <img
                        class="img-fluid1"
                        :src="
                          'https://img.youtube.com/vi/' +
                          video.youtube_id +
                          '/mqdefault.jpg'
                        "
                        alt="..."
                      />
                    </div>
                  </div>
                </a>
              </div>
            </transition-group>

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
          <a
            class="btn btn-outline-light btn-lg px-5 py-3 fs-6 fw-bolder"
            href="/list"
            >전체 운동 하기</a
          >
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import http from "../../util/http-common";

export default {
  data() {
    return {
      videos: [],
      bPartFilter: "", // b_part 값 초기화
    };
  },
  mounted() {
    this.fetchVideos();
    this.bPartFilter = this.$route.query.b_part || "전체"; // 전 페이지에서 받은 b_part 값 설정
  },
  computed: {
    filteredVideos() {
      if (this.bPartFilter != "전체") {
        console.log("this.bPartFilter : "+this.bPartFilter)
        return this.videos.filter((video) => video.b_part === this.bPartFilter);
      }
      else{
        console.log("여기 왔음!!!!!!")
        return this.videos;
      }
    },
  },
  methods: {
    fetchVideos() {
      http
        .get("/video/") // API 엔드포인트
        .then((response) => {
          this.videos = response.data.map((video) => {
            return {
              youtube_id: video.youtube_id,
              title: video.title,
              descript: video.descript,
              channel_name: video.channel_name,
              b_part: video.b_part,
              s_part: video.s_part,
              length: video.length,
            };
          });
        })
        .catch((error) => {
          console.error(error);
        });
    },
    showAlert1(video) {
      alert(
        `확인을 누르면 \n"${video.title}" 운동이 바로 시작됩니다!!! \n준비 되셨나요!!!`
      );
    },
  },
};
</script>

<style>
.img-fluid1 {
  padding: 2rem;
  border-radius: 10%;
}

.senddetail {
  text-decoration: none;
  color: black;
}

.alert-content {
  background-color: #f10216;
  color: #e6dadb;
  /* 기타 스타일 속성 */
}
</style>
