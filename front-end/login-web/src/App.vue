<template>
  <div>
    <Cadastro v-if="tela === 'cadastro'" />

    <Login
      v-if="tela === 'login'"
      @login-sucesso="irParaHome"
    />

    <Home v-if="tela === 'home'" />

    <hr />

    <button @click="tela = 'login'">Login</button>
    <button @click="tela = 'cadastro'">Cadastro</button>
  </div>
</template>

<script>
import Cadastro from './components/Cadastro.vue'
import Login from './components/Login.vue'
import Home from './components/Home.vue'

export default {
  name: 'App',
  components: {
    Cadastro,
    Login,
    Home
  },
  data() {
    return {
      tela: 'login'
    }
  },
  methods: {
    irParaHome() {
      this.tela = 'home'
    }
  }
}
</script>
