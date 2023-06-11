<template>
  <div>
    <!-- About Section-->
    <section class="bg-light py-5">
      <div class="container px-5">
        <div class="row gx-5 justify-content-center">
          <div>
            <div class="text-center my-5">
              <!-- <h2 class="display-5 fw-bolder">
                <span class="text-gradient d-inline">여기엔 뭐 쓰지</span>
              </h2>
              <br> -->
              <!-- <p class="lead fw-light mb-4"> 여기에 다른거 넣을 거임~~~~ </p>
              <p class="text-muted"> 여기에 아마 랭킹 버튼이랑 </p> -->
              <div class="flexx">
                <user-info-rank></user-info-rank>
                <div class="line"></div>
                <user-info-record ref="child_a"></user-info-record>
              </div>

            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import UserInfoRank from "./UserInfoRank.vue"
import UserInfoRecord from "./UserInfoRecord.vue"

export default {
  components: {
    UserInfoRank,
    UserInfoRecord,
  },
}
</script>

<style>
  .flexx {
    display: flex;
    align-content: center;
    justify-content: space-around;
  }
  .line {
    border: 0.5px solid lightgray;
    width: 0.1px;
    height: 16rem;
  }
</style>