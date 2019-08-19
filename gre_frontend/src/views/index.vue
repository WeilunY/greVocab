<template>
	<div id="app">
		<router-view></router-view>
	</div>
</template>

<script>
export default {
	name: "index",
	data() {
		return {};
	},
	props: {
		firstRouter: {
			type: Object
		}
	},
	mounted() {
		if (this.firstRouter && this.firstRouter.path !== "/") {
			this.$router.replace(Object.assign({}, this.firstRouter));
		} else {
			this.$router.replace({ name: "wordList" });
		}
	}
};
</script>

<style>
* {
	margin: 0;
	padding: 0;
}
#app {
	font-family: "Avenir", Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
}
</style>
