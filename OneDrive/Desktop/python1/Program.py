name="Aniket"
num=7385
print(" this is my name {} and this is my number {}".format(name,num))

print(" this is my name {one} and this is my number {two}".format(one="Aniket",two=7386))


word="Holy GOD"


print(word[3])

#slicing

print(word[0:4])


#nest
L1=[1,[2],[3,4,[7,8,9],5],5]
for i in L1:
    print(i)
    
d={'k1':{'key2':[1,2,3]}}    
print(d['k1']['key2'][1])



#set
s={1,1,1,3,4,5}
print(s)


seq=[1,2,3,4,5]
s=[]
for num in seq:
    s.append(num**2)
print(s)    


def tim2(var):
    return var*2

print(tim2(5))

    


print(list(map(tim2,seq)))