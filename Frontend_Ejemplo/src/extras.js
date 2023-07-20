export function darFormatoFecha(fecha){
    return new Intl.DateTimeFormat("es-ES",{dateStyle:"medium", timeStyle:"short"}).format(new Date(fecha));}