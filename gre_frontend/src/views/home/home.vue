<template>
	
	<div class="homeContent">
		<el-menu :default-active="currentMenu" class="el-menu-demo" 
		background-color="#101619"
  		text-color="#ecf8fe" active-text-color="#a0ddfb"
		mode="horizontal" @select="handleSelect">
			<el-menu-item index="wordList">Word List</el-menu-item>
			<el-menu-item index="flashCard">Flash Card</el-menu-item>
			<el-menu-item index="profile">Profile</el-menu-item>
			<div class="logout">
				<el-button type="danger" size="small" @click="handleLogOut">Logout</el-button>
			</div>
			
		</el-menu>
		<router-view></router-view>
	</div>
</template>

<script>
export default {
	name: "home",
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
			this.currentMenu = this.$store.state.adminCurrentMenu;
		}, 

		handleLogOut(){
			sessionStorage.clear()
			this.$store.commit('login', -1)
			this.$router.push('login')
		}

	},

	watch: {
		'$store.state.adminCurrentMenu':'getNavType'
	}

};
</script>

<style>
	.logout{
		float: right;
		margin-top: 12px;
		margin-right: 12px;
	}

</style>
