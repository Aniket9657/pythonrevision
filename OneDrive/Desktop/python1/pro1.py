speed=int(input("enter the speed in km/hr :"))
def safty(speed):
    if speed>80:
        return("Your are over speed limit ")
    elif speed==0:
        return("your car is not moving")
    elif speed<80:
        return("you are under speed limit")
    elif speed<0:
        return("enter a positive number")
    
    

print(safty(speed))
