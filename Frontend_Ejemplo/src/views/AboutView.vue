<template>
  <v-layout class="rounded rounded-md">
    <NavBar />
  </v-layout>
</template>

<script>
import NavBar from "../components/NavBar.vue";
export default {
  components: {
    NavBar,
  },
};
</script>

<style scoped>
.icon {
  margin-right: 10px;
  margin-left: 10px;
}
</style>
