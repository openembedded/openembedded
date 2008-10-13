#!/usr/bin/env python

import os, processing
from child import Child

MTN = ["mtn", "--db=~/oe/OE.mtn"]
DIFF = ["diff", "-u"]

def handle_parents(revision):
    parents = Child(*MTN+["au", "parents", revision]).stdout.strip().split('\n')
    if not parents:
        return
    print "revision: %s (parents: %s)" % (revision, parents)
    for parent in parents:
        filename = os.path.join("mtn2cache", "patch", parent+"-"+revision)
        curfilename = os.path.join("mtn2cache", "manifest", revision)
        parfilename = os.path.join("mtn2cache", "manifest", parent)
        if not os.path.exists(filename):
            diff = Child(*DIFF+[parfilename, curfilename]).stdout
            try:
                file(filename, "w").write(diff)
            except:
                os.unlink(filename)
                raise

def handle_revision(revision):
    print "revision: %s" % revision
    filename = os.path.join("mtn2cache", "revision", revision)
    if not os.path.exists(filename):
        data = Child(*MTN+["au", "get_revision", revision]).stdout
        try:
            file(filename, "w").write(data)
        except:
            os.unlink(filename)
            raise

    filename = os.path.join("mtn2cache", "manifest", revision)
    if not os.path.exists(filename):
        data = Child(*MTN+["au", "get_manifest_of", revision]).stdout
        try:
            file(filename, "w").write(data)
        except:
            os.unlink(filename)
            raise

    filename = os.path.join("mtn2cache", "certs", revision)
    if not os.path.exists(filename):
        data = Child(*MTN+["au", "certs", revision]).stdout
        try:
            file(filename, "w").write(data)
        except:
            os.unlink(filename)
            raise

def handle_head(head):
    print "head: %s" % head
    ancestors = Child(*MTN+["au", "ancestors", head]).stdout.strip().split('\n')
    pool.map(handle_revision, ancestors)
    pool.map(handle_parents, ancestors)

def handle_branch(branch):
    print "branch: %s" % branch
    heads = Child(*MTN+["au", "heads", branch]).stdout.strip().split('\n')
    for head in heads:
        handle_head(head)

def main():
    branches = Child(*MTN+["au", "branches"]).stdout.strip().split('\n')
    for branch in branches:
        handle_branch(branch)

pool = processing.Pool(12)
main()

