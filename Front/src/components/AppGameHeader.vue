<!--
	Timer: mdiClockTimeFiveOutline
	Timer Alerta: mdiClockAlertOutline
-->
<!--
	Progresso: <v-progress-circular :value="20"></v-progress-circular>
-->
<template>
	<v-banner class="mx-5 my-1 px-5">
		<div class="d-flex justify-space-between">
			<div>
				<v-icon
					color="blue-grey darken-2"
					size="36"
				>
					mdi-cards
				</v-icon>
				{{cardPairsRemaining}}/{{dificulty.cardQuantity/2}}
			</div>

			<!-- TODO: Colocar o habitat -->
			<span class="text-h4 font-weight-medium">{{level}} - {{dificulty.name}}</span>

			<div>
				{{timeRemaining | secondsFormatter}}
				<v-icon
					color="blue-grey darken-2"
					size="36"
				>
					mdi-clock-time-five-outline
				</v-icon>
			</div>
		</div>
	</v-banner>
</template>

<script>
export default {
  props: {
		pLevel: {
			type: String,
			required: true
		},
		pDificulty: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
			level: this.pLevel, 
      dificulty: this.pDificulty, 
      cardPairsRemaining: this.pDificulty.cardQuantity/2, 
      timeRemaining: this.pDificulty.timeLimit, 
    }
  },
	filters: {
		secondsFormatter(timeInSeconds) {
			function str_pad_left(string,pad,length) {return (new Array(length+1).join(pad)+string).slice(-length);}
			var minutes = Math.floor(timeInSeconds / 60);
			var seconds = timeInSeconds - minutes * 60;
			return str_pad_left(minutes,'0',2)+':'+str_pad_left(seconds,'0',2);
		}
	}
};
</script>

<style scoped>

</style>