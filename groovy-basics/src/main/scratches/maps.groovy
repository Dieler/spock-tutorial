
// map
def m = [a: 1, b: 2, c: 3]
assert m instanceof HashMap
assert m instanceof LinkedHashMap
assert m == ["c": 3, "b": 2, "a": 1]
assert m["a"] == 1
assert m['a'] == 1
assert m.a == 1
String key1 = "a", key2 = "b", key3 = "c"
assert m == [(key1): 1, (key2): 2, (key3): 3]
m.c = 4
assert m == ["c": 4, "b": 2, "a": 1]
assert m + [d: 4] == [a: 1, b: 2, c: 4, d: 4]
assert m - [c: 4] == [a: 1, b: 2]
assert m.intersect([c: 4]) == [c: 4]
assert 'a' in m
// non-empty map evaluates to true
assert m // Java: m != null && m.size() > 0
// empty map evaluates to false
assert ![:] // Java: new HashMap().size() == 0
assert m.is(m) // Java: m == m
assert !m.is(["c": 4, "b": 2, "a": 1])
m = null
assert m.is(null)
assert m == null
