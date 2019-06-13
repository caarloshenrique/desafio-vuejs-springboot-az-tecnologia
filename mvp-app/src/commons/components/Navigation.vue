<template>
    <v-navigation-drawer
            app
            v-model="drawer"
            :mini-variant.sync="mini"
            hide-overlay
            stateless
    >
        <v-toolbar color="primary" flat class="transparent">
            <v-list class="pa-0">
                <v-list-tile avatar>
                    <v-list-tile-avatar>
                        <img src="https://randomuser.me/api/portraits/men/85.jpg">
                    </v-list-tile-avatar>
                    <v-list-tile-content>
                        <v-list-tile-title class="white--text">Carlos</v-list-tile-title>
                    </v-list-tile-content>
                    <v-list-tile-action>
                        <v-btn
                                icon
                                @click.stop="mini = !mini"
                        >
                            <v-icon color="white">chevron_left</v-icon>
                        </v-btn>
                    </v-list-tile-action>
                </v-list-tile>
            </v-list>
        </v-toolbar>
        <v-list class="pt-0" dense>
            <v-divider></v-divider>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>dashboard</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <router-link to="/" tag="li"><v-list-tile-title>Home</v-list-tile-title></router-link>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>add_circle</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <router-link to="/cadastro" tag="li"><v-list-tile-title>Cadastro</v-list-tile-title></router-link>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    export default {
        name: 'Navigation',
        data () {
            return {
                drawer: true,
                items: [
                    { title: 'Home', icon: 'dashboard' },
                    { title: 'Cadastro', icon: 'add_circle' }
                ],
                mini: false,
                right: null
            }
        }
    }
</script>
