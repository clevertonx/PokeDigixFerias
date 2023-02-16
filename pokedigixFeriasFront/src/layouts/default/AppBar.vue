<template>
  <v-app-bar :elevation="2" color="#006400" density="compact">

    <template v-slot:prepend>
      <v-app-bar-nav-icon class="hamburg" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

    </template>


    <v-app-bar-title class="letra-branca">PokeDigix</v-app-bar-title>

  </v-app-bar>

  <v-navigation-drawer v-model="drawer" temporary>
    <v-list :items="menus"></v-list>

  </v-navigation-drawer>
</template>

<script v-model="drawer" temporary>
export default {
  data() {
    return {
      drawer: false,
      menus: [
        {
          title: "Pokemons",
          value: "/pokemons"
        },
        {
          title: "Ataques",
          value: "/ataques"
        },
        {
          title: "Tipos",
          value: "/tipos"
        }
      ]
    }
  },
}
</script>

<style scoped>
.letra-branca {
  color: white;
}

.hamburg {
  color: white;
}
</style>
