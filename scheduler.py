"""
Day #10: Medium.

This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
"""
import time
def scheduler(f,n):
    milliseconds = n/1000
    time.sleep(milliseconds)
    f()
def printHello():
    print("Hello, function called")

scheduler(printHello,2000)