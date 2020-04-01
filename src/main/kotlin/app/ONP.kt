package app

import java.io.IOException
import java.util.*

//todo change to double
object ONP {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        convertToONP()
        val calc = Calculate()
        val result = calc.calculate("2 55 * 1 + 2 /")
        println("RESULT: $result")
    }
    fun convertToONP() {
        var output = ""
        val input = "((2*55+1)/2)"
        val stack = LinkedList<String>();

        println("Dane wejściowe : $input\n|            |\nV            V")
        val symbols: MutableMap<String, Int> = TreeMap()
        symbols["="] = 4
        symbols["^"] = 3
        symbols["√"] = 3
        symbols["*"] = 2
        symbols["/"] = 2
        symbols["+"] = 1
        symbols["-"] = 1
        symbols[")"] = 0
        symbols["("] = 0

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
            } else if (currChar == "(") {
                stack.push(currChar)
            } else if (currChar == ")") {
                while (stack.first != "(") {
                    output += stack.first
                    output += " "
                    stack.removeFirst()
                }
                stack.removeFirst()
            } else {
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
        println("Dane wyjściowe : $output")
    }


}

//todo bad result, change to double
class Calculate {
    fun isOperator(s: String): Boolean {
        return s == "+" || s == "-" || s == "*" || s == "/"
    }

    fun calculate(result1: String): Int {
        var result = result1
        //result = result.trim { it <= ' ' }
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