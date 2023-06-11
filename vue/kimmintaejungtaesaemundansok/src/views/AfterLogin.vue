<template>
  <div>
    <header-nav />
    <router-view></router-view>
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import HeaderNav from "../components/common/HeaderNav.vue";
import FooterNav from '../components/common/FooterNav.vue'

export default {
  components: { FooterNav, HeaderNav },

  created() {
    if (sessionStorage.getItem("user") == null) {
      console.log(">> 로그인 안된 상태");
      this.$router.push({ name: "start" });
    } else {
      console.log(">> 로그인 된 상태");
    }
  },
};
</script>

<style></style>
