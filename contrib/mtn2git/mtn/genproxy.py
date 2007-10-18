#!/usr/bin/env python

class GeneratorProxy(object):
    def __init__(self, generator):
        self.generator = generator
    def __iter__(self):
        return self
    def next(self):
        return self.generator.next()

class Seedy(GeneratorProxy):
    def __del__(self):
        print "testing"
        
def test():
    yield 2
    yield 3
    yield 4

if __name__ == '__main__':
    a = test()
    b = Seedy(test())
    for i in b:
        print i
    