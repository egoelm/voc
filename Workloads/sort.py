from time import time


def workload(list):
    list.sort()


len = 1500000
totalTime = 0
runs = 1
for run in range(runs):
    list = [i for i in range(len, -1, -1)]
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
