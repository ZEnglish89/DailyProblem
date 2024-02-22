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

#This is the result of me looking at solutions on Leetcode lol
def NoDivCorrect(list):
    length=len(list)
    ans = [1]*len(list)
    suf=1 #represents the product of all values to the "right" of the current one
    pre=1 #the product of all values to the "left"
    for i in range(length):
        ans[i]*=pre #multiply the current value(sweeping from left to right) by the product to its left
        pre*=list[i] #update pre to include one more value to the right
        ans[length-1-i]*=suf #multiply the current value(sweeping from right to left) by the product on its right
        suf*=list[length-1-i] #update suf to include one more value to the left
#By the end of the loop, every value will have been multiplied by the products on both its left and right, that is
#they will have been multiplied by both suf and pre, but not themselves, achieving the correct result.
    return ans
a=[1,2,3,4,5]
b=[3,2,1]
print(Easy(a))
print(Easy(b))
print(NoDiv(a))
print(NoDiv(b))
print(NoDivCorrect(a))
print(NoDivCorrect(b))