<template>
	<div class="homeContent">
		<div class="menu">
			<div
				class="menuItem"
				@click="menuClick(item, index)"
				:class="{'selected':currentMenu===index+1}"
				v-for="(item, index) in navList"
				:key="index"
			>{{item.name}}</div>
		</div>
		<router-view></router-view>
	</div>
</template>

<script>
export default {
	name: "App",
	data() {
		return {
			currentMenu: 1,
			navList: [
				{
					name: "Word List",
					url: "wordList"
				},
				{
					name: "Flash Card",
					url: "flashCard"
				},
				{
					name: "Test",
					url: "msgCenter"
				},
				{
					name: "Profile",
					url: "orderCenter"
				}
			]
		};
	},
	props: {
		firstRouter: {
			type: Object
		}
	},
	methods: {
		menuClick(menu, index) {
			this.$router.push({
				name: menu.url
			});
			this.currentMenu = index + 1;
		}
	},
	mounted() {
        const routeName = this.$route.name;
		if (routeName === "home") {
			this.$router.replace({ name: "wordList" });
		}
		this.currentMenu = this.navList.findIndex(item => item.url === routeName) + 1;
	}
};
</script>

<style>
.menu {
	display: flex;
	width: 100%;
	height: 60px;
	background-color: #545c64;
}
.menuItem {
	position: relative;
	width: 96px;
	height: 60px;
	text-align: center;
	line-height: 60px;
	color: #ffffff;
	cursor: pointer;
}
.menuItem:hover {
	color: cyan;
}
.selected {
	color: cyan;
}
.selected:after {
	position: absolute;
	content: "";
	width: 100%;
	height: 4px;
	bottom: 0;
	left: 0;
	background-color: cyan;
}
</style>
