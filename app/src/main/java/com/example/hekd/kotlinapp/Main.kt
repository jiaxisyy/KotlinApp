package com.example.hekd.kotlinapp

/**
 * Created by hekd on 2017/9/19.
 */

fun main(args: Array<out String>) {

    println("hello kotlin")
    println(Students(1, "better"))
    println(sum(1, 2))
    println(sum2(2, 3))
    printSum(5, 5)
    printSum2(1, 9)
    printSum3()
    println(printSum4(10, 3))
    println(maxOf(5, 6))
    printSum5()

}


data class Students(val id: Int, val name: String)


fun sum(a: Int, b: Int): Int = a + b


fun sum2(a: Int, b: Int) = a + b
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSum2(a: Int, b: Int) {
    var x = 5
    println("sum of $a and $b is ${a + b}")
    x += 1
    println("x=$x")
}

fun printSum3() {
    var a = 1
// simple name in template:
    val s1 = "a is $a"

    a = 2
// arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun printSum4(a: Int, b: Int) = a - b

fun printSum5() {



}