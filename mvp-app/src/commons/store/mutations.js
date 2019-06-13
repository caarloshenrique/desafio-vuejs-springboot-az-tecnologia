import {mutationTypes} from "../constants";

export default {
    [mutationTypes.SET_PRODUTOS](state, produtos){
        state.produtos = produtos
    }
}