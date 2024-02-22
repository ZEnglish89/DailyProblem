"""
(Hard)
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
"""

def Easy(list):
    product=1
    for i in range(len(list)):
        product*=list[i]
    newlist=[]
    for i in list:
        newlist.append(int(product/i))
    return newlist

#now for the hard part
#this could obviously be achieved with a nested for loop and an if statement,
#but that's in WAY worse time complexity.
#clearly there's some actually efficient way to do this.

#The more I think about it, the more it seems like it's impossible to do
#better than O(n^2) time complexity without using division, so for now I'll
#just do it that way and sit in my shame.
def NoDiv(list):
    newlist=[]
    for i in range(len(list)):
        product=1
        for j in list:
            if list.index(j)!=i:
                product*=j
        newlist.append(product)
    return newlist

a=[1,2,3,4,5]
b=[3,2,1]
print(Easy(a))
print(Easy(b))
print(NoDiv(a))
print(NoDiv(b))