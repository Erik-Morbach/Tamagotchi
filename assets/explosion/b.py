import os

values = set()
for i in range(1, 60):
    values.add(i)

for i in range(1,60):
    if os.path.exists("explosionF{}.txt".format(i)):
        mex = min(values)
        values.remove(mex)
        if mex == i:
            continue
        os.system("cp explosionF{}.txt explosionF{}.txt".format(i,mex))
        os.remove("explosionF{}.txt".format(i))
        values.add(i)

