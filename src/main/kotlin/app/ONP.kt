package app

import java.io.IOException
import java.util.*

object ONP {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var output = ""
        val input = "((2*55+1)/2)"

        // clasa stosu
        class Stack {
            var tablicaStosu = LinkedList<String>()
            fun push(newElement: String) {
                tablicaStosu.add(0, newElement)
            }
        }
        println("Dane wejściowe : $input\n|            |\nV            V")
        val symbols: MutableMap<String, Int> = TreeMap()
        symbols["^"] = 3
        symbols["*"] = 2
        symbols["/"] = 2
        symbols["+"] = 1
        symbols["-"] = 1
        symbols[")"] = 0
        symbols["("] = 0
        symbols["="] = 4
        val stack = Stack()
        var currentCharacter: String
        var i = 0
        while (i < input.length) {
            if (!Character.isDigit(input[i])) {
                currentCharacter = input[i].toString()
            } else {
                currentCharacter = ""
                while (Character.isDigit(input[i])) {
                    currentCharacter += input[i]
                    i++
                }
                i--
            }
            if (!symbols.containsKey(currentCharacter)) {
                output += currentCharacter
                output += " "
            } else if (currentCharacter == "=") {
                while (!stack.tablicaStosu.isEmpty()) {
                    output += stack.tablicaStosu.first
                    output += " "
                    stack.tablicaStosu.removeFirst()
                }
            } else if (currentCharacter == "(") {
                stack.push(currentCharacter)
            } else if (currentCharacter == ")") {
                while (stack.tablicaStosu.first != "(") {
                    output += stack.tablicaStosu.first
                    output += " "
                    stack.tablicaStosu.removeFirst()
                }
                stack.tablicaStosu.removeFirst()
            } else {
                if (!stack.tablicaStosu.isEmpty()) {
                    while (symbols[currentCharacter]!! < symbols[stack.tablicaStosu.first]!!) {
                        output += stack.tablicaStosu.first
                        output += " "
                        stack.tablicaStosu.removeFirst()
                    }
                }
                stack.push(currentCharacter)
            }
            i++
        }
        println("Dane wyjściowe : $output")
    }
}