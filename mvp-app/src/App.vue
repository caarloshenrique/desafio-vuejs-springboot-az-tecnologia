<template>
    <v-app id="inspire">
        <Navigation/>
        <Toolbar/>
        <br>
        <v-content grey lighten-4>
            <router-view/>
        </v-content>
        <br>
        <Footer/>
    </v-app>
</template>

<script>
    import Navigation from "@/commons/components/Navigation"
    import Toolbar from "@/commons/components/ToolBar"
    import Footer from "@/commons/components/Footer"

    export default {
        components: {Navigation, Toolbar, Footer}
    };
</script>