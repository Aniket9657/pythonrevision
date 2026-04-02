list = [1,2,3,4,5,6]
N=int(input("enter the length to print: "))
def print_list(list,N):
 for i in list:
    if N>=len(list):
        return("index out of range")
    else:
        return(list[:N+1])

print(print_list(list,N))
