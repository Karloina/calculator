package app

import java.io.IOException
import java.util.*

object ONP {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {}

    fun setResult(args: Array<String>) : String{
        val onp = convertToONP(args[0] + "=")
        val calc = Calculate()
        return calc.calculate(onp).toString()
    }

    fun convertToONP(input: String) : String {
        var output = ""
        val stack = LinkedList<String>();

        val symbols: MutableMap<String, Int> = TreeMap()
        symbols["="] = 2
        symbols["*"] = 1
        symbols["/"] = 1
        symbols["+"] = 0
        symbols["-"] = 0

        var currChar: String
        var i = 0
        while (i < input.length) {
            if (!Character.isDigit(input[i])) {
                currChar = input[i].toString()
            } else {
                currChar = ""
                while (Character.isDigit(input[i])) {
                    currChar += input[i]
                    i++
                }
                i--
            }
            if (!symbols.containsKey(currChar)) {
                output += currChar
                output += " "
            } else if (currChar == "=") {
                while (!stack.isEmpty()) {
                    output += stack.first
                    output += " "
                    stack.removeFirst()
                }
            }
            else {
                if (!stack.isEmpty()) {
                    while (symbols[currChar]!! < symbols[stack.first]!!) {
                        output += stack.first
                        output += " "
                        stack.removeFirst()
                    }
                }
                stack.push(currChar)
            }
            i++
        }
        return output
    }
}

class Calculate {
    fun isOperator(s: String): Boolean {
        return s == "+" || s == "-" || s == "*" || s == "/"
    }

    fun calculate(result1: String): Int {
        var result=""
        if (result1 != null && result1.isNotEmpty() && result1[result1.length - 1] == ' ') {
            result = result1.substring(0, result1.length - 1);
        }
        val values = Stack<Int>() //stos
        val tokens = result.split(" ").toTypedArray()
        var answer = 0
        for (token in tokens) {
            if (!isOperator(token)) {
                values.add(token.toInt())
            } else {
                val a = values.pop()
                val b = values.pop()
                when (token) {
                    "+" -> answer = a + b
                    "-" -> answer = b - a
                    "*" -> answer = a * b
                    "/" -> answer = a / b
                }
                values.add(answer)
            }
        }
        return answer
    }
}