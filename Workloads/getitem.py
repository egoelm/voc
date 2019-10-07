
from time import time

len = 300000


def workload(list):
    for i in range(0, len-1):
        list.__getitem__(i)


totalTime = 0
runs = 8
list = [i for i in range(len)]
for i in range(runs):
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
