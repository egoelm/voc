from time import time


def workload(list):
    list.__len__()


len = 14000
totalTime = 0
runs = 8
for run in range(runs):
    list = [i for i in range(len)]
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
