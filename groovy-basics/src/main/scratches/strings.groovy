

def s1 = "World"
def s2 = "Hello, $s1!"
assert s2 == "Hello, World!"

s2 = "Hello, ${s1.toUpperCase()}!"
assert s2 == "Hello, WORLD!"

def s3 = 'a\nb\nc'

def s4 = """a
b
c"""

assert s4 == s3

def s5 = '''\
a
b
c\
'''

assert s5 == s3

def s6 = '''\
        a
        b
        c'''.stripIndent()

assert s6 == s3

def s7 = '''\
        a
        b
        c\
'''.stripIndent()

assert s7 == s3
