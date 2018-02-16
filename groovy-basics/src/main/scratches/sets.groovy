
// set
def s = ["a", "b", "c", "a"] as Set
assert s instanceof HashSet
assert s instanceof LinkedHashSet
assert s == ["a", "c", "b"] as Set
assert s << 'd' == ['a', 'b', 'c', 'd'].toSet()
assert s - 'c' == ['a', 'b', 'd'].toSet()
assert s - ['a', 'b'] == ['c', 'd'].toSet()
assert !s.is(null) && s.size() > 0
assert ![].toSet()

