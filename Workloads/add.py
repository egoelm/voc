from time import time


def workload():
    list = []
    for i in range(1, 10000):
        temp = [i]
        list = list.__add__(temp)


totalTime = 0
runs = 5
for i in range(runs):
    start = time()
    workload()
    totalTime += time() - start


print(totalTime/runs)
