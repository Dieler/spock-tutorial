
def r1 = 0..3
assert r1 instanceof List
assert r1 == [0, 1, 2, 3]
assert r1[0] == 0
assert r1[3] == 3
def r2 = 'a'..<'d'
assert r2[0] == 'a'
assert r2[2] == 'c'
assert r2.size() == 3
