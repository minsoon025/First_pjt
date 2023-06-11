<template>
<div>
  <main>
    <section class="py-5">
      <div class="container px-5">
        <!-- Contact form -->
        <div class="bg-light rounded-4 py-5 px-4 px-md-5">
          <div class="text-center mb-5">
            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3">
              <i class="bi bi-person-add"></i>
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                class="bi bi-person-add" viewBox="0 0 16 16">
                <path
                  d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z" />
                <path
                  d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z" />
              </svg>
            </div>
            <h1 class="fw-bolder">회원가입</h1>
            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
          </div>
          <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
              <form id="contactForm" data-sb-form-api-token="API_TOKEN">

                <!-- Name input -->
                <div class="form-floating mb-3">
                  <input v-model="name" class="form-control" id="name" type="text" placeholder="Enter your name..."
                    data-sb-validations="required" />
                  <label for="name">이름</label>
                  <div class="invalid-feedback" data-sb-feedback="name:required">
                    이름을 입력해주세요.
                  </div>
                </div>

                <!-- 아이디 input -->
                <div class="form-floating mb-3">
                  <input v-model="id" class="form-control" id="id" type="text" placeholder="Enter your id..."
                    data-sb-validations="required" />
                  <label for="id">아이디</label>
                  <div class="invalid-feedback" data-sb-feedback="id:required">
                    아이디를 입력해주세요.
                  </div>
                </div>

                <!-- 비밀번호 input -->
                <div class="form-floating mb-3">
                  <input v-model="password" class="form-control" id="pw" type="text" placeholder="Enter your pw..."
                    data-sb-validations="required" />
                  <label for="pw">비밀번호</label>
                  <div class="invalid-feedback" data-sb-feedback="pw:required">
                    비밀번호를 입력해주세요.
                  </div>
                </div>

              <!-- 운동 수행 능력 체크하기 input -->
              <div class="form-floating mb-3">
                <select v-model="level" class="form-select" id="work" data-sb-validations="required">
                  <option value="0" disabled>운동량에 영향이 가는 부분입니다.</option>
                  <option value="3">상</option>
                  <option value="2">중</option>
                  <option value="1">하</option>
                </select>
                <label for="work"> 운동 수행 능력을 선택해주세요.</label>
                <div class="invalid-feedback" data-sb-feedback="work:required">
                  
                </div>
              </div>
              </form>
            </div>
            <div class="d-none" id="submitSuccessMessage">
              <div class="text-center mb-3">
                <div class="fw-bolder">Form submission successful!</div>
                To activate this form, sign up at
                <br />
                <a
                  href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
              </div>
            </div>
            <div class="d-none" id="submitErrorMessage">
              <div class="text-center text-danger mb-3">
                Error sending message!
              </div>
            </div>

            <!-- Submit Button -->
            <div class="d-grid">
              <div class="idflex">
                <a @click="regist" class="btn btn-primary btn-lg px-5 py-3 me-sm-3 fs-6 fw-bolder">
                  회원가입
                </a>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>
  </main>
  </div>
</template>


  
  
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>

<script>
import http from "../../util/http-common"

export default {
  data() {
    return {
      name: "",
      id: "",
      password: "",
      level: "0",
    }
  },
  methods: {
    regist() {
      if(this.name.length == 0 || this.id.length == 0 
            || this.password.length == 0 || this.level == "0") {
        alert("모든 칸을 채워주세요. ")
      }
      else {
        console.log("회원가입 기능!")
        http({
          url:"/user/regist",
          method: "POST",
          params: {
            id: this.id,
            level: this.level * 1,
            name: this.name,
            password: this.password,
          },
        })
        .then((res) => {
          console.log(res.data)
          if(typeof res.data != "object"){
            alert(res.data);
          }
          else {
            sessionStorage.setItem("user", this.id);
            console.log("로그인 완료")
            this.$router.push({ name: "user-info" });
          }
        })
      }
    },
  },
  created(){
    if(sessionStorage.getItem("user") != null) {
        console.log(">> 로그인 된 상태");
        this.$router.push({ name: "user-info" })
    }
    else {
        console.log(">> 로그인 안된 상태");
    }
  },
}
</script>

<style>

</style>