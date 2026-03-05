package functionCall

type Pos = {v: Int with v > 0}

def aa(p: Pos): Int = 1

val x = aa(2)