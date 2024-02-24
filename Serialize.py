"""
(Medium)
This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
"""
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def serialize(root):
    s=""
    if(root==None): #If you've hit an empty node, mark it with a -1 and skip the rest
        s+="-1"
    else:
        s+=str(root.val)+' ' #add the current value
        s+=serialize(root.left)+' ' #recursively add all the values to the left until you hit an empty node
        s+=serialize(root.right)+' ' #once you've hit an empty node on the left, recursively add all the values to the right until you hit another
    return s #return back up to the parent node, or if this is the root, return the completed string

def deserialize(s):
    if(type(s) is str): #only split the string if it hasn't been split already
        s=s.split() #split the string into a list
    if len(s)>0: #if the string/list is empty, the process is done
        value=s.pop(0) #reads the value and removes it, so even if it's -1 we're still moving on to the next value
        if value!='-1': #if this is not an empty node:
            Root=Node(value)
            Root.left=deserialize(s) #recursively deserialize everything to the left, until the process ends or you hit an empty string
            Root.right=deserialize(s) #repeat that to the right
            return Root #return this node and all of its children, if this is the root then the process is now over.
    return None #if the process is over or the node is empty, None is python's version of "null," and it matches the Node class's default values

test = Node('20',Node('8'),Node('22'))
test1 = Node('10',Node('4',Node('3',Node('1')),Node('6')),Node('12',Node('11'),Node('17')))
#print(serialize(test))
#print(serialize(test1))
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
print(deserialize(serialize(node)).left.left.val) #Should print 'left.left'
print(deserialize(serialize(test1)).right.left.val) #should print '11'