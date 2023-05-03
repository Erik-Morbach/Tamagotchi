import copy
import os

def loadIcon(path):
    response = []
    with open(path) as file:
        response = file.readlines()
    return response

def rotateLine(line, x):
    return line[x:] + line[:x]


def rotateArray(arr, dx, dy):
    nArr = []
    for line in arr:
        line = line.replace('\n','')
        rotatedLine = rotateLine(line, dx)
        nArr += [rotatedLine+'\n']

    while dy:
        nArr += nArr[0]
        del nArr[0]
        dy -= 1
    return nArr

def drawFrame(frameIndex, lines):
    if os.path.exists("F{}.txt".format(frameIndex)):
        os.system("rm F{}.txt".format(frameIndex))
    with open("F{}.txt".format(frameIndex), 'x') as file:
        file.write("".join(lines))

idle = loadIcon("icon.txt")
jumping = loadIcon("jump.txt")


jumpMax = 3
dY = 1
dX = 1

x = 0
y = 0
goingDown = False

frame = 0


while x >= -50 and y >=0 :
    print(x,y)
    if y == 0:
        drawFrame(frame, rotateArray(idle, abs(x), abs(y)))
    else:
        drawFrame(frame, rotateArray(jumping, abs(x), abs(y)))
    x -= dX
    if goingDown:
        y -= dY
        if y == 0:
            goingDown = False
    else:
        y += dY
        if y ==jumpMax:
            goingDown = True
    frame += 1



