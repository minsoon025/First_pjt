<template>
  <div class="userInfoWidth"> 
    <h2 class="display-10 fw-bolder">
        <span class="text-gradient d-inline">나의 운동 기록</span>
    </h2>
    <hr>
    <div class="userInfoInner2">
        <table>
            <colgroup>
                <col style="width: 40%">
                <col style="width: 5%">
                <col style="width: 30%">
            </colgroup>
            <tbody>
                <tr>
                    <th class="th-right">현재 연속 운동일 </th>
                    <td class="th-space"></td>
                    <td>{{ this.th }} days</td>
                </tr>
                <tr>
                    <th class="th-right">최고 연속 운동일 </th>
                    <td class="th-space"></td>
                    <td>{{ this.longest }} days</td>
                </tr>
                <tr>
                    <th class="th-right">총 운동 시간 </th>
                    <td class="th-space"></td>
                    <td>{{ this.hour }} h {{ this.min }} min </td>
                </tr>
                <tr>
                    <th class="th-right">총 운동 참여일 </th>
                    <td class="th-space"></td>
                    <td>{{ this.day }} days</td>
                </tr>
            </tbody>
        </table>
        <!-- 현재 연속 운동일 : {{ this.th }} days <br>
        최고 연속 운동일 : {{ this.longest }} days<br> 
        총 운동 시간 : {{ this.hour }} h {{ this.min }} min<br>
        총 운동 참여일 : {{ this.day }} days <br> -->
    </div>
  </div>
</template>

<script>
import http from "../../util/http-common";

export default {
    data() {
        return {
            th: 0,
            longest: 0,
            hour: 0,
            min: 0,
            day: 0,
        }
    },
    methods: {
        infoCalc(){
            // 현재 연속 운동일
            http({
                url: "/user/day",
                method: "GET",
                params: {
                    id: sessionStorage.getItem("user"),
                },
            })
            .then((res) => {
                console.log("현재 연속 운동일 : "+this.th)
                this.th = res.data;
            })
    
            // 최고 연속 운동일
            http({
                url: "/user/longest",
                method: "GET",
                params: {
                    id: sessionStorage.getItem("user"),
                },
            })
            .then((res) => {
                this.longest = res.data;
            })

            // 총 운동 시간
            http({
                url: "/user/totalTime",
                method: "GET",
                params: {
                    id: sessionStorage.getItem("user"),
                },
            })
            .then((res) => {
                let time = res.data;
                this.hour = Math.round(time / 60);
                this.min = time % 60;
            })

            // 총 운동 참여일
            http({
                url: "/user/totalDay",
                method: "GET",
                params: {
                    id: sessionStorage.getItem("user"),
                }
            })
            .then((res) => {
                this.day = res.data;
            })

        }
    },
    created() {
        
    }
}
</script>

<style>
.userInfoInner2 {
    width: 15rem;
    text-align: left;
    margin: auto;
}
.th-right {
    text-align: right;
}
</style>