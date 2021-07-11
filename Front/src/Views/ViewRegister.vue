<template>
  <v-container>
    <div class="interface">
      <div class="interfaceForms">
        <h3 style="fontSize:5vh; color:rgba(20, 15, 40, 0.87)">Cadastro</h3>
        <h4 style="fontSize:3vh; color:rgba(108, 108, 108)">
          Seja bem vindo! Faça seu cadastro logo a baixo!
        </h4>
        <h2 style="color:red" v-show="!valido">Registro inválido</h2>
        <div class="forms">
          <v-text-field label="Nome" v-model="nome" outlined></v-text-field>

          <v-text-field
            label="Usuário"
            v-model="usuario"
            outlined
          ></v-text-field>

          <v-text-field type="password" label="Senha" v-model="senha" outlined></v-text-field>
        </div>

        <router-link :to="this.valido ? '/Login' : '/Register'">
          <v-btn x-large color="primary" class="mr-4" @click="validate">
            Cadastrar
          </v-btn>
        </router-link>
      </div>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      nome: "",
      usuario: "",
      senha: "",
      valido: true,
    };
  },
  methods: {
    validate: function() {
      var opts = {
        nome: this.nome,
        usuario: this.usuario,
        senha: this.senha,
      };
      fetch("http://localhost:8090/pac3/aluno/cadastrar", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(opts),
      })
        .then((response) => {
          if (response.status !== 201) {
            console.log("Request Error! Status: " + response.status);
            this.valido = false;
            return;
          }
          this.valido = true;
        })
        .catch((error) => {
          console.log("Fetch Error! " + error);
        });
    },
  },
};
</script>

<style>
.footerLinks {
  display: flex;
  margin-top: -15px;
  width: 100%;
}

.forms {
  margin: 7vh 0px;
}

.interfaceForms {
  width: 50%;
  margin: auto;
  text-align: center;
}

.interface {
  display: flex;
  justify-content: center;
  box-shadow: 1px 1px 10px 1.3px #0c32585b;
  height: 93vh;
  border-radius: 10px;
}
</style>
