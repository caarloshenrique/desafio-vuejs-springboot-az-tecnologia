<template>
  <v-app>
    <app-toolbar/>
    <br>
    <v-content>
      <app-form/>
      <br>
      <app-card-list/>
    </v-content>
    <v-footer app></v-footer>
  </v-app>
</template>

<script>
import ToolBar from "./ToolBar.vue";
import ItemProduto from "./ItemProduto.vue";
import Form from "./Form.vue";
export default {
  components: {
    "app-toolbar": ToolBar,
    "app-card-list": ItemProduto,
    "app-form": Form
  }
};
</script>