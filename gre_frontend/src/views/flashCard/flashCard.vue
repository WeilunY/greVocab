<template>
    <div class="container">
        <card></card>
    </div>
</template>

<script>
import Card from './component/card.vue'

export default {
    name: 'flash-card',

    components: {
        Card,
    },

    props:{
        word_id: Number,
    },

    data() {
        return {}
    },
    methods: {}
}
</script>
<style lang="css">
    .container {
        font-size: 40px;
    }
</style>