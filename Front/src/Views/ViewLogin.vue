<template>
  <v-container>
    <div class="interface">
      <div class="interfaceForms">
        <h3 style="font-size: 5vh; color: rgba(20, 15, 40, 0.87)">Login</h3>
        <h2 style="color:red" v-show="!valido">Login inválido</h2>

        <div class="forms">
          <v-text-field
            label="Usuário"
            placeholder="maria123"
            outlined
            v-model="user.username"
          ></v-text-field>

          <v-text-field v-model="user.password"  label="Senha" outlined type="password"></v-text-field>

          <div class="footerLinks">
            <div><a> Esqueci minha senha </a></div>
            <router-link to="/Register">
              <div style="margin-left: 45vh"><a> Cadastrar </a></div>
            </router-link>
          </div>
        </div>
        <v-btn x-large color="primary" class="mr-4" @click="validate">
          <v-icon left dark>mdi-login</v-icon>
          Logar
        </v-btn>
      </div>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      user:{
        username: "",
        password: ""
      },
      route:'', 
      valido: true
    }
  },
  methods: {
    validate: function(){
      var opts = {
        usuario: this.user.username,
        senha: this.user.password,
      }
      fetch('http://localhost:8090/pac3/aluno/login', {
        "method": 'POST',
        "headers": {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        "body": JSON.stringify(opts)
      })
      .then((response) => {
        if(response.status !== 202) {
          console.log("Request Error! Status: "+response.status)
          this.valido = false
          return
        } 
        response.json().then((res) => { 
          this.$store.commit('logIn', { userId:  res.id, userLevel: res.fase})
          this.valido = true
        })
      })
      .catch((error) => {
        console.log("Fetch Error! "+error)
      })
      .finally(() => {
        this.$router.push("Menu")
      })
    },
  }
};
</script>

<style >
.footerLinks {
  display: flex;
  margin-top: -15px;
  width: 100%;
  text-decoration: none;
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

