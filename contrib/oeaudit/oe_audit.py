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

def strip_bsd_version(bsd_version):
    """
    FreeBSD is adding ,1 for revisions.. remove that
    """
    # FIXME return a tuple with a revision...
    split = bsd_version.rsplit(',', 1)
    split = split[0]
    split = split.rsplit('_', 1)
    return split[0]

def compare_versions(oe, freebsd, not_known):
    def handle_package(oe_name, bsd_name):
        if not oe_name in oe:
            if oe_name == bsd_name:
                print >> not_known, "%s is not in OE" % oe_name
            return

        oe_version = strip_oe_version(oe[oe_name])
        for ver in freebsd[bsd_name]:
            affected = True
            str = []
            for (cmp, vers) in ver.versions:
                bsd_ver = strip_bsd_version(vers)
                cmp_res = bb.utils.vercmp(('0', oe_version, 'r0'), ('0', bsd_ver, 'r0'))
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

    for package in freebsd.keys():
        # handle the various versions of OE packages
        handle_package(package, package)
        handle_package("%s-native" % package, package)
        handle_package("%s-full-native" % package, package)
        handle_package("%s-sdk" % package, package)


# read the input data
oe_packages = oe.read_available("available")
freebsd_vuln = freebsd.read_auditfile("auditfile")
buggy = open("not_in_oe.bugs", "w+")

compare_versions(oe=oe_packages, freebsd=freebsd_vuln, not_known=buggy)
