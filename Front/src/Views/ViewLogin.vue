<template>
  <v-container>
    <div class="interface">
      <div class="interfaceForms">
        <h3 style="font-size: 5vh; color: rgba(20, 15, 40, 0.87)">Login</h3>

        <div class="forms">
          <v-text-field
            label="Usuário"
            placeholder="maria@gmail.com"
            outlined
            v-model="user.mail"
          ></v-text-field>

          <v-text-field v-model="user.password"  label="Senha" outlined type="password"></v-text-field>

          <div class="footerLinks">
            <div><a> Esqueci minha senha </a></div>
            <router-link to="/Register">
              <div style="margin-left: 45vh"><a> Cadastrar </a></div>
            </router-link>
          </div>
        </div>
        <router-link :to="`${this.route}`">
          <v-btn x-large color="primary" class="mr-4" @click="validate">
            <v-icon left dark>mdi-login</v-icon>
            Logar
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
      user:{
        mail: "",
        password: ""
      },
      route:''
    }
  },
   methods: {
     validate: function(){
      //  this.$store.state.count
       if(this.user.mail == "gustavo" && this.user.password == "123")
        this.route = '/Menu'
     },
     passwordState: function(){
       console.log("opa tudo bom")
     }
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

