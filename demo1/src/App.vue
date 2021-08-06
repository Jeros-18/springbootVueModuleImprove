<template>
    <div>
        <!--    <router-link to="/">Home</router-link> |-->
        <!--    <router-link to="/about">About</router-link>-->
        <!--    头部-->
        <Header/>
        <div style="display: flex">
            <!--      侧边栏-->
            <Aside/>
            <!--      主体内容-->
            <router-view style="flex: 1;"/>
        </div>

    </div>

</template>

<style>

</style>
<script>
    import Header from "./components/Header";
    import Aside from "./components/Aside";

    export default {
        components: {Aside, Header}
    }
</script>