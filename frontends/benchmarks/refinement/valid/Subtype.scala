package subtype

def id(x: Int) = x

val x: {v: Int with v > 0} = 2
val res = id(x)