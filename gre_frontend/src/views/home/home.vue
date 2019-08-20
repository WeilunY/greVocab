<template>
	<div class="homeContent">
		<el-menu :default-active="currentMenu" class="el-menu-demo" 
		background-color="#101619"
  		text-color="#ecf8fe" active-text-color="#c6eafc"
		mode="horizontal" @select="handleSelect">
			<el-menu-item index="wordList">Word List</el-menu-item>
			<el-menu-item index="flashCard">Flash Card</el-menu-item>
		</el-menu>
		<router-view></router-view>
	</div>
</template>

<script>
export default {
	name: "App",
	data() {
		return {
			currentMenu: 'wordList',
			
		 };
	},
	props: {
		firstRouter: {
			type: Object
		}
	},
	methods: {

		handleSelect(key) {
			this.$router.push(key)
			this.$store.state.adminCurrentMenu=key;
		}, 

		getNavType(){
			this.currentMenu=this.$store.state.adminCurrentMenu;
		}

	},
	mounted() {
        const routeName = this.$route.name;
		if (routeName === "home") {
			this.$router.replace({ name: "wordList" });
		}
	},

	watch: {
		'$store.state.adminCurrentMenu':'getNavType'
	}

};
</script>

<style>

</style>
