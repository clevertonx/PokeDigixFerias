
<template>
  <v-item-group>
    <v-container>
      <v-row>
        <v-col v-for="pokemon in pokemons" :key="pokemon" cols="12" md="4">
          <v-item v-slot="{ isSelected, toggle }">
            <v-card :color="isSelected ? 'primary' : ''" class="d-flex align-center" dark height="200" @click="toggle">
              <v-scroll-y-transition>
                <div class="text-h4 flex-grow-1 text-center">
                  {{ isSelected? pokemon.nome + " foi selecionado": pokemon.nome }}
                </div>
              </v-scroll-y-transition>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
    </v-container>
  </v-item-group>
</template>


<script>
import axios from 'axios';
export default {
  data() {
    return {
      pokemons: [
        {
          nome: "Gengar",
          nivel: "80",
          numeroPokedex: "094"
        },
        {
          nome: "Venusaur",
          nivel: "100",
          numeroPokedex: "003"
        },
        {
          nome: "Arcanine",
          nivel: "70",
          numeroPokedex: "059"
        }
      ]
    }
  },
  methods: {
    buscarPokemon() {
      axios.get('localhost:8080/pokemon').then((resposta) => {
        this.pokemons = resposta.pokemons;
      })
        .catch((erro) => {
          console.log(erro);
        })
    }
  },
  mounted() {
    this.buscarPokemon();
  }
}
</script>
