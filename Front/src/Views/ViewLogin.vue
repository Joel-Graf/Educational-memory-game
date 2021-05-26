<template>
  <v-container>
   <div class="interface"> 
      
     <div class="interfaceForms"> 
       <h3 style="fontSize:5vh; color:rgba(20, 15, 40, 0.87)"> Login </h3>

        <div class="forms"> 
            <v-text-field
                label="Usuário"
                placeholder="maria@gmail.com"
                outlined
            ></v-text-field>

            <v-text-field
                label="Senha"
                outlined
            ></v-text-field>

            <div class="footerLinks"> 
               <div> <a> Esqueci minha senha </a> </div>
               <div style="margin-left:45vh"> <a> Cadastrar </a> </div> 
            </div>
        </div>

         <v-btn
             x-large
            color="primary"
            class="mr-4"
            @click="validate"
          >
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
        user: "",
        password:""
      }
    }
  }
</script>

<style >

  .footerLinks{
    display: flex;
    margin-top: -15px;
    width: 100%;
    
  }

    .forms{
      margin:7vh 0px;
    }

    .interfaceForms{    
      width: 50%;
      margin: auto;
      text-align: center;
    }

    .interface{
      display: flex;
      justify-content: center;
      box-shadow: 1px 1px 10px 1.3px #0c32585b;
      height: 95vh;
      border-radius:10px
    }
</style>

