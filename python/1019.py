a=str(input())
date=a.split(".")
print("%04d.%02d.%02d" % (int(date[0]), int(date[1]) , int(date[2])))