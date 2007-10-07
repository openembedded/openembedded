#!/usr/bin/env python
# -*- coding: utf-8 -*-

## This utility takes the debian directory from an unpacked debian mono source
## tree (e.g. apt-get source mono), parses the *.install files and generates a
## bitbake include file with the file and package lists. It tries to handle -dbg
## packages by creating additional glob patterns for *.mdb and */.debug/*. Most 
## of these will not match, but that's fine (I think). 
##   -- Henryk Plötz <henryk@openmoko.org>
##
##The output looks like:
##FILES_mono-jit-dbg = "/usr/bin/mono*.mdb \
##        /usr/bin/mono*/*.mdb"
##FILES_mono-jit = "/usr/bin/mono"
##FILES_mono-gac-dbg = "/usr/bin/gacutil*.mdb \
##        /usr/bin/gacutil*/*.mdb \
##        /usr/lib/mono/1.0/gacutil.exe*.mdb \
##        /usr/lib/mono/1.0/gacutil.exe*/*.mdb"
##FILES_mono-gac = "/usr/bin/gacutil \
##        /usr/lib/mono/1.0/gacutil.exe"
## ...
##PACKAGES = "mono-jit-dbg \
##        mono-jit \
##        mono-gac-dbg \
##        mono-gac \
## ...

import os, sys, re

def collect_paths(dir):
    paths = {}
    
    os.chdir(dir)
    for filename in os.listdir("."):
        if filename.endswith(".install"):
            fp = file(filename, "r")
            lines = fp.readlines()
            fp.close()
            
            contents = []
            for line in lines:
                line = line.strip()
                if line.startswith("#"): continue
                if line == "": continue
                
                lineparts = line.split()
                if lineparts[0].startswith("debian/tmp"):
                    pattern = lineparts[0][ len("debian/tmp"): ]
                    if len(lineparts) == 2:
                        if not pattern.startswith(lineparts[1]):
                            print >>sys.stderr, "Warning: Apparently I don't fully understand the format in file %s" % filename
                    elif len(lineparts) > 2:
                        print >>sys.stderr, "Warning: Apparently I don't fully understand the format in file %s" % filename
                    
                    contents.append( pattern )
                else:
                    print >>sys.stderr, "Note: Ignoring %s in %s" % (lineparts, filename)
                
            paths[ filename[ :-len(".install") ] ] = contents
    
    return paths

def collect_packages(paths):
    # These packages should be populated first (e.g. because their files will otherwise end up
    # in other packages)
    PACKAGES_FIRST = ("mono-jit", "mono-gac", "mono-mjs", "mono-gmcs", "mono-utils", "mono-doc")
    # These should be populated last (because their spec is very broad)
    PACKAGES_LAST = ("mono-mcs", "libmono-system1.0-cil", "libmono-system2.0-cil", "libmono1.0-cil", "libmono2.0-cil")
    first = []
    last = []
    packages = paths.keys()
    for packagename in PACKAGES_FIRST + PACKAGES_LAST:
        if packagename in packages:
            packages.remove(packagename)
            if packagename in PACKAGES_FIRST:
                first.append(packagename)
            else:
                last.append(packagename)
    packagenames = first + packages + last
    
    return packagenames, paths

def debugify(packagenames, paths):
    pnames = []
    for pkg in packagenames:
        if not pkg.endswith("-dbg"):
            result = []
            for path in paths[pkg]:
                if not path.endswith("*"):
                    result.append(path + "*.mdb")
                    result.append(path + "*/*.mdb")
                else:
                    result.append(path + ".mdb")
                    result.append(path + "/*.mdb")
                if path.endswith("/"):
                    result.append(path + ".debug/")
                    result.append(path + "../.debug/")
            paths[pkg + "-dbg"] = result
            pnames.append(pkg + "-dbg")
        pnames.append(pkg)
    return pnames, paths

if __name__ == "__main__":
    packagenames, paths = collect_packages( collect_paths(".") )
    packagenames, paths = debugify(packagenames, paths)
    
    print "# This is a generated file, please do not edit directly"
    print "# Use collect-files.py instead. -- Henryk <henryk@openmoko.org>"
    
    packages = []
    for pkg in packagenames:
        if not paths[pkg]: continue
        
        print 'FILES_%s = "%s"' % (pkg, " \\\n\t".join(paths[pkg]))
        packages.append(pkg)
    
    print
    print 'PACKAGES = "%s"' % (" \\\n\t".join(packages))
