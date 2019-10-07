
from time import time

len = 14000


def workload(list):
    for i in range(0, len):
        list.__contains__(i)


totalTime = 0
runs = 10
list = [i for i in range(len)]
for i in range(runs):
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
