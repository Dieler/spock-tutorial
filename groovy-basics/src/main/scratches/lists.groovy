

def l = [1, 2, 3, 4, 5]
assert l instanceof ArrayList
assert l == [1, 2, 3, 4, 5]
assert l[0] == 1
assert l[1..-1] == [2, 3, 4, 5]
l[6] = 7
assert l == [1, 2, 3, 4, 5, null, 7]
l[-2] = 6
assert l == [1, 2, 3, 4, 5, 6, 7]
assert l + [8, 9, 10] == [1, 2, 3, 4, 5, 6, 7, 8, 9 , 10]
assert l - [1, 3, 5, 7] == [2, 4, 6]
assert l.intersect([6, 7, 8, 9, 10]) == [6, 7]
assert l.disjoint([8, 9, 10])
assert 1 in l // Java: l.contains(1)
// non-empty list evaluates to true
assert l // Java: l != null && l.size() > 0
// empty list evaluates to false
assert ![]
assert l.is(l) // Java: l == l
assert !l.is([1, 2, 3, 4, 5, 6, 7])
l = null
assert l.is(null)
assert l == null
