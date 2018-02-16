import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Collectors


def toUpperCase = { String s -> s.toUpperCase() }
assert !(toUpperCase instanceof Function)
assert toUpperCase instanceof Closure

def strings = ["hello", ",", "world", "!"]
assert strings.collect(toUpperCase) == ["HELLO", ",", "WORLD", "!"]
assert strings.collect { toUpperCase.call(it) } == ["HELLO", ",", "WORLD", "!"]
assert strings.collect { it.toUpperCase() } == ["HELLO", ",", "WORLD", "!"]
assert strings.stream().map(toUpperCase).collect(Collectors.toList()) == ["HELLO", ",", "WORLD", "!"]
// Java: strings.stream().map(toUppercase::call).collect(Collectors.toList())
assert strings.stream().map(toUpperCase.&call).collect(Collectors.toList()) == ["HELLO", ",", "WORLD", "!"]



def isInteger = { String s -> s ==~ /^\d+$/ }
assert !(isInteger instanceof Predicate)

strings = ["1", "a", "02", "b", "300"]

assert strings.find(isInteger) == "1"
assert strings.find { isInteger.call(it) } == "1"
assert strings.find { it ==~ /^\d+$/ } == "1"
assert strings.stream().filter(isInteger).findFirst().get() == "1"
assert strings.stream().filter(isInteger.&call).findFirst().get() == "1"

assert strings.findAll(isInteger) == ["1", "02", "300"]
assert strings.findAll { it ==~ /^\d+$/ } == ["1", "02", "300"]
assert strings.stream().filter(isInteger).collect(Collectors.toList()) == ["1", "02", "300"]



assert strings.findAll { it ==~ /^\d+$/ }.collect { it as Integer } == [1, 2, 300]


def result = new StringBuilder()
strings.each { result << it << ", " }
assert result.toString() == "1, a, 02, b, 300, "


result = new StringBuilder()
strings.eachWithIndex { String s, int i ->
    if (i > 0) {
        result << ", "
    }
    result << s
}
assert result.toString() == "1, a, 02, b, 300"


assert strings.any(isInteger)
assert strings.any { it ==~ /^\d+$/ }
assert !strings.every(isInteger)
assert !strings.every { it ==~ /^\d+$/ }
assert strings.findAll(isInteger).every(isInteger)
