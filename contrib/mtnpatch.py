#!/usr/bin/env python
import sys, os, string, getopt

mtncmd = "monotone"

def main(argv = None):
    if argv is None:
        argv = sys.argv
    opts, list = getopt.getopt(sys.argv[1:], ':R')
    if len(list) < 1:
        print "You must specify a file"
        return 2
    reverse = False
    for o, a in opts:
        if o == "-R":
            reverse = True
    if os.path.exists(list[0]):
        input = open(list[0], 'r')
        renameFrom = ""
        cmd = ""
        if reverse:
            print "patch -R -p0 < %s" % list[0]
        else:
            print "patch -p0 < %s" % list[0]
        for line in input:
            if len(line) > 0:
                if line[0] == '#':
                    parts = line.split()
                    if len(parts) > 2:
                        cmd = parts[1]
                        # deal with whilespace in filenames (badly)
                        fileName = parts[2]
                        i = 3
                        while i < len(parts) and fileName.count('"') % 2:
                            fileName += " %s" % parts[i]
                        if cmd == "delete_file":
                            if reverse:
                                print "%s add %s" % (mtncmd, fileName)
                            else:
                                print "%s drop -e %s" % (mtncmd, fileName)
                        elif cmd == "add_file":
                            if reverse:
                                print "%s drop -e %s" % (mtncmd, fileName)
                            else:
                                print "%s add %s" % (mtncmd, fileName)
                        elif cmd == "rename_file":
                            renameFrom = fileName
                        elif cmd == "to" and renameFrom != "":
                            if reverse:
                                print "%s rename -e %s %s" % (mtncmd, fileName, renameFrom)
                            else:
                                print "%s rename -e %s %s" % (mtncmd, renameFrom, fileName)
                            renameFrom = ""
                        else:
                            cmd = ""

if __name__ == "__main__":
    sys.exit(main())
