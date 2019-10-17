
from time import time


def workload(list):
    for i in range(1, 4000):
        list.reverse()


totalTime = 0
runs = 6
for i in range(runs):
    list = [i for i in range(1, 100000)]
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
