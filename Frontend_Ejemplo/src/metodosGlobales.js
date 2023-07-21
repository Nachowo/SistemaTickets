import Vue from "vue"

Vue.prototype.$darFormato = function (fecha){
    return new Intl.DateTimeFormat("es-ES",{dateStyle:"medium", timeStyle:"short"}).format(new Date(fecha));
};