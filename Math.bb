;Here are some helpful math routines I use - Josh

;Nearest Log2 integer, rounded up
Function Log2%(n%)
    Return Ceil(Log(n%) / Log(2))
End Function

;Nearest power-of-two number rounded up
Function Pow2%(n%)
    Local exponent = Ceil(Log2(n))
    Return 2.0 ^ exponent
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D