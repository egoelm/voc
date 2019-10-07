
from time import time

len = 14000


def workload(list):
    for i in range(0, len):
        list.remove(len-i)


totalTime = 0
runs = 6
for i in range(runs):
    list = [i for i in range(len+1)]
    start = time()
    workload(list)
    totalTime += time() - start


print(totalTime/runs)
