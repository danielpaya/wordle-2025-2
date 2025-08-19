package com.unisabana.wordle.data

val words = listOf<String>(
    "abeto", "abril", "acero", "actor", "adobe", "agudo", "ajeno", "alejo", "arena", "aroma",
    "autos", "aviso", "banco", "barra", "bello", "blusa", "bosco", "brazo", "brisa", "burro",
    "cable", "canto", "carga", "carne", "carta", "cielo", "cinta", "clase", "clima", "cobre",
    "coral", "crema", "crudo", "cuero", "dardo", "denso", "dieta", "diosa", "duelo", "dupla",
    "ebrio", "ecoar", "edito", "elite", "entra", "envio", "error", "etapa", "famos", "fango",
    "feliz", "feria", "firma", "flaco", "fluir", "fondo", "forma", "fruta", "fuego", "fusil",
    "gallo", "gente", "globo", "grano", "grave", "grupo", "guapo", "habla", "hecho", "hielo",
    "hondo", "honor", "hojas", "hotel", "huevo", "ideal", "islas", "joven", "jugar", "junto",
    "karma", "largo", "leche", "libro", "llave", "lleno", "luzca", "madre", "mango", "marca",
    "miedo", "mitad", "monte", "mujer", "mundo", "nacer", "niega", "nivel", "norte", "nubes"
)

fun getRandomWord():String{
    return words.random()
}