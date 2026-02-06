<template>
  <div>
    <h1>Cadastro</h1>

    <input type="text" placeholder="Nome" v-model="nome" />
    <br /><br />

    <input type="email" placeholder="Email" v-model="email" />
    <br /><br />

    <input type="password" placeholder="Senha" v-model="senha" />
    <br /><br />

    <button @click="cadastrar">Cadastrar</button>

    <p>{{ mensagem }}</p>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'App',

  data() {
    return {
      nome: '',
      email: '',
      senha: '',
      mensagem: ''
    }
  },

  methods: {
    async cadastrar() {
      try {
        const response = await axios.post(
          'http://localhost:8080/api/users/cadastro',
          {
            nome: this.nome,
            email: this.email,
            senha: this.senha
          }
        )
        this.mensagem = response.data
      } catch (error) {
        this.mensagem = 'Erro ao cadastrar'
        console.error(error)
      }
    }
  }
}
</script>
