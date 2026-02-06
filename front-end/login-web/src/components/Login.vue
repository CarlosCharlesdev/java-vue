<template>
  <div>
    <h1>Login</h1>

    <input type="email"  placeholder="Email"  v-model="email"  />
    <br /><br />

    <input  type="password"   placeholder="Senha"   v-model="senha" />
    <br /><br />

    <button @click="login">Entrar</button>

    <p>{{ mensagem }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Login',

  data() {
    return {
      email: '',
      senha: '',
      mensagem: ''
    }
  },

  methods: {
    async login() {
      try {
        const response = await axios.post(
          'http://localhost:8080/api/users/login',
          {
            email: this.email,
            senha: this.senha
          }
        )
        
        this.mensagem = response.data
        if(response.data == 'Login Efetuado com sucesso'){
            this.$emit('login-sucesso')
        }
      } catch (error) {
        this.mensagem = 'Erro ao fazer login'
        console.error(error)
      }
    }
  }
}
</script>
