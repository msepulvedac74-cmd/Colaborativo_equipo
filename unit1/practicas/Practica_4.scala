Alumnos:

Mauricio Sepúlveda C
Ricardo González Z

Primera Función – Booleana
La primera función booleana es sencilla y explica cómo definir si el número que se inyecta en la definición es un número par; de ser así, regresará el valor “true”:

def isEven(num:Int): Boolean = {  return num%2 == 0 }

Segunda Función – Es par o non

def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
val l = List(1,2,3,4,5,6,7,8)

En esta función, se puede insertar un listado de números enteros en forma de cadena (string). Despues se ejecuta un “for” para accesar cada uno de los números de la lista y hacer el cálculo, si el número es par se imprime en pantalla “X is even”, y se termina la función, si no es par, continua en la sección “else” en donde si el número no es par se imprime “X is odd”.

Tercera Funcion - Afortunado

def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

val af= List(1,7,7)
println(afortunado(af))


La función recibe una lista de números. En el “for” se recorre la lista de números y va sumando los numero de la lista y acumulando su valor. La condición es que, si el número de la lista es igual a 7, se le suman 14; para cualquier otro número, se le suma el valor del número y se añade al acumulado.
En el ejemplo la lista es 1, 7, 7; por tanto, la función imprimirá en pantalla los valores: 1, 15 y 29

Tercera Funcion - Balance
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0
    segunda = list.sum
    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)
        if(primera == segunda){
            return true
        }
    }
    return false 
}

val bl = List(3,2,1)
balance(bl)

Esta es una función que busca encontrar un balance en la lista de números que se alimentan a la función, si encuentra balance es “true”, si no arroja “false” como resultado.

Se le alimenta una lista de números. Se crean dos variables que servirán de comparativo. La primer variable es igual a cero, y la segunda es igual a la sumatoria de todos los números. Se utiliza un “for” para recorrer la lista de números. A la primer variable se le van sumando los números de la lista conforme se van recorriendo, en la segunda variable se va restando el valor del número de la lista. Si en algún punto hay balance, se termina la función y devuelve “true”; si recorre todos los números sin encontrar balance, termina y devuelve “false”.



Cuarta Funcion – Palindromo

Un palíndromo es la palabra que tiene el mismo orden de caracteres si se lee al derecho o al revés.

def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"

println(palindromo(palabra))

En esta función, se alimenta una lista de caracteres. En la variable se utiliza la opción “reverse” para cambiar el orden de los caracteres. Si al cabiar el orden de los caracteres es igual, regresa un valor de true, si por el contrario no es igual, arroja un valor de “false”. En esta función importa si los caracteres son mayúsculas o minúsculas.
