<template>
  <div>
    <header class="">
      <div
        class="container2 px-10"
        style="display: flex; justify-content: center"
      >

        <div class="img-frame">
          <img src="../../../assets/profile.jpg" alt="" class="img-profile">
          <br>
          <br>
          <div class="ments" style="width: 50rem;">
            <div style="height: 2rem;"></div>
            <a @mouseover="changeImage('hi')"> <i class="bi bi-bell-fill"> {{ ment }} </i> </a>
            
            <div class="buttons" style="padding: 60px 0px">

              <div class="hov-top">
                <a href="list?b_part=상체" @mouseover="changeImage('상체')">
                  <i class="bi bi-activity">상체</i>
                </a>
              </div>
              <div class="img-top"><img src="../../../assets/top.jpg" alt=""></div>
              
              <div class="hov-bottom">
                <a href="list?b_part=하체" @mouseover="changeImage('하체')">
                  <i class="bi bi-activity">하체</i>
                </a>
              </div>
              <div class="img-bottom"><img src="../../../assets/bottom.jpg" alt=""></div>

              <div class="hov-core">
                <a href="list?b_part=코어" @mouseover="changeImage('코어')">
                  <i class="bi bi-activity">코어</i>
                </a>
              </div>
              <div class="img-core"><img src="../../../assets/core.jpg" alt=""></div>

              <div class="hov-run">
                <a href="list?b_part=유산소" @mouseover="changeImage('유산소')">
                  <i class="bi bi-activity">유산소</i>
                </a>  
              </div>
              <div class="img-run"><img src="../../../assets/run.jpg" alt=""></div>

            </div>
          </div>

        </div>
      </div>
    </header>
    <div
      class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xxl-start mb-3"
    ></div>
    
    <div class="space">
      {{ perMent }}
    </div>
    <div
      class="percentbar px-20"
      style="display: flex; justify-content: center"
    >
      <br />
      <a @mouseover="changeImage('hi')">

      <h3>
        운동량 <span id="currentPercent">{{ exPer }}</span
        >%
        <span class="span-space"></span>
      </h3>
      </a>
      
      <progress
        id="progress"
        ref="progressBar"
        value="0"
        min="0"
        max="100"
      ></progress>
      <span class="span-space"></span>
      <h4 style="color: gray">/ {{ this.goal }} min</h4>
    </div>
    <br />
    <br />
    <user-info ref="child_b"></user-info>
  </div>
</template>

<script>
import http from "../../util/http-common";
import UserInfo from "../userInfo/UserInfo.vue";

export default {
  components: { UserInfo },
  data() {
    return {
      exPer: 0,
      exerciseTime: 0, // 운동 시간 초기값
      level: 0,
      goal: 0,
      ment: "",
      imageSource: "", // 기본이미지 설정
      perMent: "",
    };
  },
  created() {
    this.imageSource = require("../../../assets/profile.jpg"); // 이미지 초기값 설정
    this.getData();
    this.getMent();
  },
  mounted() {
    this.imageSource = require("../../../assets/profile.jpg");
    this.getData();
    this.getMent();
    this.animateProgress();
  },
  methods: {
    animateProgress() {
      const progress = this.$refs.progressBar;
      const currentPercent = this.exPer;
      const increment = currentPercent / 100;

      let currentValue = 0;
      const timer = setInterval(() => {
        if (currentValue >= currentPercent) {
          clearInterval(timer);
        } else {
          currentValue += increment;
          progress.value = currentValue;
        }
      }, 25);
    },

    changeImage(part) {
  if (part === "상체") {
    this.imageSource = require("../../../assets/top.jpg");
  } else if (part === "하체") {
    this.imageSource = require("../../../assets/bottom.jpg");
  } else if (part === "코어") {
    this.imageSource = require("../../../assets/core.jpg");
  } else if (part === "유산소") {
    this.imageSource = require("../../../assets/run.jpg");
  } else {
    this.imageSource = require("../../../assets/profile.jpg");
  }
},


    async getData() {
      try {
        const recordResponse = await http.get("/user/record", {
          params: {
            user_id: sessionStorage.getItem("user"),
          },
        });
        this.exerciseTime = recordResponse.data.exTime;
        console.log("이 유저의 오늘 운동시간 : " + this.exerciseTime);

        const userResponse = await http.get("/user", {
          params: {
            id: sessionStorage.getItem("user"),
          },
        });
        this.level = userResponse.data.level;
        if (this.level == 1) this.goal = 30;
        else if (this.level == 2) this.goal = 60;
        else if (this.level == 3) this.goal = 120;
        console.log("이 유저의 레벨 : " + this.level);

        this.calc();
        this.animateProgress();
        this.$refs.child_b.$refs.child_a.infoCalc();
      } catch (error) {
        console.error("데이터 가져오기 오류:", error);
      }
    },

    calc() {
      console.log("calc 부름!!");
      if (this.level === 1) {
        // 초급
        this.exPer = (this.exerciseTime / 30) * 100;
      } else if (this.level === 2) {
        // 중급
        console.log("> " + (this.exerciseTime / 60) * 100);
        this.exPer = (this.exerciseTime / 60) * 100;
      } else if (this.level === 3) {
        // 고급
        this.exPer = (this.exerciseTime / 120) * 100;
      }

      if (this.exPer > 100) {
        this.exPer = 100;
      }
      this.exPer = Math.round(this.exPer * 100) / 100;
      this.perMentCalc();
    },

    perMentCalc() {
      http({
        url: "/ment/percent",
        method: "GET",
        params: {
          percent: this.exPer,
        },
      }).then((res) => {
        this.perMent = res.data;
      });
    },

    getMent() {
      http({
        url: "/ment",
        method: "GET",
      }).then((res) => {
        // console.log(res.data)
        this.ment = res.data;
      });
    },
  },
};
</script>

<style>
/* @import "/css/styles.css"; */
.space {
  margin-left: 25%;
  margin-right: 20%;
}
.span-space {
  display: inline-block;
  width: 1rem;
}
.img-frame {
  margin : 0px auto;
  position: relative;
  display: flex;
}
.img-profile {
  top: 0px;
  left: 0px;
  height: 338px;
}
.img-top {
  position: absolute;
  top: 0px;
  left: 0px;
  display: none;
}
.img-bottom {
  position: absolute;
  top: 0px;
  left: 0px;
  display: none;
}
.img-core {
  position: absolute;
  top: 0px;
  left: 0px;
  display: none;
}
.img-run {
  position: absolute;
  top: 0px;
  left: 0px;
  display: none;
}

.hovv:hover ~ .targ {
  color: red;
}
.hov-top:hover ~ .img-top {
  display: block;
}
.hov-bottom:hover ~ .img-bottom {
  display: block;
}
.hov-core:hover ~ .img-core {
  display: block;
}
.hov-run:hover ~ .img-run {
  display: block;
}
</style>
