#!/usr/bin/env python

import freebsd, oe

try:
    import bb
except Exception, e:
    import sys
    sys.stderr.write("Set PYTHONPATH to bitbake/lib and restart.\n")
    sys.stderr.write("The backtrace can be seen below.\n")
    raise e
    

def strip_oe_version(oe_version):
    """
    We need to strip the package epoch... and the PR to compare
    it to the FreeBSD versions. Also FreeBSD seems to use _N as
    PR so we might need to do more..
    """
    split = oe_version.split(':', 1)
    ver = split[1]

    split = ver.rsplit('-r', 1)
    ver = split[0]
    return ver

def compare_versions(oe, freebsd_dict, not_known):
    def handle_package(oe_name, bsd_name):
        if not oe_name in oe:
            if oe_name == bsd_name:
                print >> not_known, "%s is not in OE" % oe_name
            return

        oe_version = strip_oe_version(oe[oe_name])
        for ver in freebsd_dict[bsd_name]:
            affected = True
            str = []
            for (cmp, vers) in ver.versions:
                (bsd_ver, bsd_pr) = freebsd.prepare_version(vers)
                cmp_res = bb.utils.vercmp(('0', oe_version, 'r0'), ('0', bsd_ver, bsd_pr))
                if cmp == '<':
                    if cmp_res >= 0:
                        affected = False
                    pass
                elif cmp == '<=':
                    if cmp_res > 0:
                        affected = False
                    pass
                elif cmp == '>':
                    if cmp_res <= 0:
                        affected = False
                    pass
                elif cmp == '>=':
                    if cmp_res < 0:
                        affected = False
                    pass
                elif cmp == '=':
                    if cmp_res > 0:
                        affected = False
                else:
                    print cmp
                    assert True

                str.append("%s %s %s %s" % (oe_name, oe_version, cmp, bsd_ver))
            if affected:
                print " && ".join(str), ver.link

    for package in freebsd_dict.keys():
        # handle the various versions of OE packages
        handle_package(package, package)
        handle_package("%s-native" % package, package)
        handle_package("%s-full-native" % package, package)
        handle_package("%s-sdk" % package, package)
        handle_package("%s-essential" % package, package)
        handle_package("%s-cross" % package, package)
        handle_package("%s-initial" % package, package)
        handle_package("%s-trim" % package, package)
        handle_package("%s-canadian" % package, package)
        handle_package("%s-cross-sdk" % package, package)

def handle_options(args):
    import optparse
    parser = optparse.OptionParser(version = "OE Audit version 0.1",
                                   usage = "%prog [options]")
    parser.add_option("-a", "--auditfile", help = "FreeBSD auditfile to use",
                      action = "store", dest = "freebsd_auditfile", default = None)
    parser.add_option("-p", "--available", help = "Output of bitbake -s",
                      action = "store", dest = "oe_available", default = None)
    parser.add_option("-b", "--buggy", help = "Write out unmaped packets",
                      action = "store", dest = "buggy", default = "not_in_oe.bugs")
    parser.add_option("-f", "--fetch", help = "Fetch a new auditfile",
                     action = "store_true", dest = "fetch", default = False)

    options, args = parser.parse_args(args)
    return options

# read the input data
import sys
opts = handle_options(sys.argv)

if opts.fetch:
    import os
    print "Fetching new auditfile with wget and unpacking to the local directory"
    os.system("(rm auditfile.tbz || true) && wget -c http://ports.freebsd.org/auditfile.tbz; tar xjf auditfile.tbz auditfile && rm auditfile.tbz")

if not opts.oe_available or not opts.freebsd_auditfile:
    print "You need to specific -a and -p."
    sys.exit(0)

oe_packages = oe.read_available(opts.oe_available)
freebsd_vuln = freebsd.read_auditfile(opts.freebsd_auditfile)
buggy = open(opts.buggy, "w+")

compare_versions(oe=oe_packages, freebsd_dict=freebsd_vuln, not_known=buggy)
