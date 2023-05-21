<template>
  <div>
    <header-nav />
    after login page 확인용 지우면됨
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNav from '../components/common/HeaderNav.vue'
export default {
  components: { HeaderNav },

  created(){
    sessionStorage.setItem("user", "user2");
    // console.log("> "+ sessionStorage.getItem("user"));
    // sessionStorage.removeItem("user");
    // console.log("> "+ sessionStorage.getItem("user"));

    if(sessionStorage.getItem("user") == null) {
        console.log(">> 로그인 안된 상태");
        this.$router.push({ name: "start" })
    }
    else {
        console.log(">> 로그인 된 상태");
    }
  },
  
}
</script>

<style>

</style>