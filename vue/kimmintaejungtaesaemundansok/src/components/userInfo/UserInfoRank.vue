<template>
  <div class="userInfoWidth">
    <h2 class="display-10 fw-bolder">
      <span class="text-gradient d-inline">연속 운동일 랭킹</span>
    </h2>
    <hr />
    <div class="userInfoInner">
      <table style="text-align: center">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 15%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
        </colgroup>
        <thead>
          <tr>
            <th></th>
            <th>순위</th>
            <th>아이디</th>
            <th>레벨</th>
            <th>연속일</th>
          </tr>
        </thead>

        <tbody v-for="(r, index) in ranks" :key="index">
          <span v-if="index == 0"> <i class="bi bi-trophy gold"></i> </span>
          <span v-else-if="index == 1">
            <i class="bi bi-trophy silver"></i>
          </span>
          <span v-else-if="index == 2">
            <i class="bi bi-trophy bronze"></i
          ></span>

          <span class="rank-space" v-else></span>
          <td>{{ index + 1 }}</td>
          <td>{{ r.id }}</td>
          <td>{{ r.level }}</td>
          <td>{{ r.longest }}</td>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import http from "../../util/http-common";

export default {
  data() {
    return {
      ranks: [],
    };
  },
  created() {
    http({
      url: "/user/rank",
      method: "GET",
    }).then((res) => {
      this.ranks = res.data.map((rank) => {
        return {
          id: rank.id,
          level: rank.level,
          longest: rank.longest,
        };
      });
    });
  },
};
</script>

<style>
.userInfoWidth {
  width: 22rem;
}
.userInfoInner {
  width: 20rem;
  text-align: left;
  margin: auto;
}
</style>
