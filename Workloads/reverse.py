
from time import time


def workload(list):
    list.reverse()


totalTime = 0
runs = 6
for i in range(runs):
    for len in range(1, 1000):
        list = [i for i in range(len)]
        start = time()
        workload(list)
        totalTime += time() - start


print(totalTime/runs)
