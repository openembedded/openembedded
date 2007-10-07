#!/usr/bin/env python

## This utility takes the debian directory from an unpacked debian mono source tree
## (e.g. apt-get source mono), parses the *.install files and generates python source
## for a list of dictionaries that describe the individual packages and their contents
## The output will look like
##debian_mono_file_table = [
##        {       'name': 'libmono-peapi1.0-cil',
##                'patterns': [
##                                '/usr/lib/mono/gac/PEAPI/1.0.*/',
##                                '/usr/lib/mono/1.0/PEAPI.dll'
##                        ],
##                'assemblies': [
##                                ('PEAPI', '1.0.*')
##                        ]
##        },
##        {       'name': 'mono-mjs',
##                'patterns': [
##                                '/usr/bin/mjs',
##                                '/usr/lib/mono/1.0/mjs.exe*'
##                        ]
##        },
##....


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
                lineparts = line.strip().split()
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
    gac_re = re.compile(r'/usr/lib/mono/gac/(?P<assembly>[^/]+)/(?P<version>[^/]+)/?')
    
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
    
    packages = []
    for name in packagenames:
        patterns = paths[ name ]
        package = { "name": name,
            "patterns": patterns}
        
        provided_assemblies = []
        for pattern in patterns:
            match = gac_re.match(pattern)
            if match:
                provided_assemblies.append( (match.group("assembly"), match.group("version")) )
            if pattern == "/usr/lib/mono/1.0/mscorlib.dll*":
                provided_assemblies.append( ("mscorlib", "1.0.*" ) )
            elif pattern == "/usr/lib/mono/2.0/mscorlib.dll*":
                provided_assemblies.append( ("mscorlib", "2.0.*" ) )
        
        if len(provided_assemblies) > 0:
            package["assemblies"] = provided_assemblies
        
        packages.append(package)
    
    return packages

if __name__ == "__main__":
    packages = collect_packages( collect_paths(".") )
    
    if False: # Human-friendly
        for package in packages:
            print "Package: %s" % package["name"]
            if package.has_key("provided_assemblies"):
                print "Provides: \t%s" % ( "\n\t\t".join( [" ".join(e) for e in package["assemblies"] ] ) )
            print "Patterns: \t\t%s" % ( "\n\t\t\t".join(package["patterns"]) )
            print
    else:
        print "# This is a generated file, please do not edit directly"
        print "# Use collect-paths.py instead. -- Henryk <henryk@openmoko.org>"
        print "debian_mono_file_table = ["
        print ",\n".join( 
            [ 
                "\t{\t%s\n\t}" % ",\n\t\t".join( 
                    [
                        "%r: %r" % (key, value)
                        for key, value in package.items()
                        if not isinstance(value, (list,tuple))
                    ] + [
                        "%r: [\n\t\t\t\t%s\n\t\t\t]" % (key, ",\n\t\t\t\t".join( [
                                "%r"%(e,) for e in value
                            ])
                        )
                        for key, value in package.items()
                        if isinstance(value, (list,tuple))
                    ]

                )
                for package in packages 
            ]
        )
        print "]"
    
