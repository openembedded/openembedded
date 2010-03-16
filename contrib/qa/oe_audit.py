#!/usr/bin/env python

def read_available(filename):
    """
    Parses the output of bitbake -s
    minus the first few lines
    """
    f = open(filename)
    packages = {}

    for line in f:
        # str.split can not be used as we have multiple whitespace
        first_space = line.find(" ")
        package = line[0:first_space]
        rest = line[first_space+1:]
        pv = rest.strip().split(" ")[0]

        packages[package] = pv
    return packages


def map_names(str):
    """Map a FreeBSD name to OE"""
    maps = {
        "libpurple" : "pidgin",
        "php4" : "php",
        "php5" : "php",
        "expat2" : "expat",
        "freeciv-gtk" : "freeciv",
        "pcre" : "libpcre",
        "vim-gnome" : "vim",
        "python23" : "python",
        "python24" : "python",
        "python25" : "python",
        "python+ipv6" : "python",
        "wget-devel" : "wget",
        "xchat2" : "xchat",
        "freetype" : "freetype",
        "qemu-devel" : "qemu",
        "krb5-beta" : "krb5",
        "freeciv-gtk2": "freeciv",
    }

    try:
        return maps[str]
    except:
        return str

def is_not_in_oe(name):
    """Method to reject packages not in OE"""
    not_in = [
        "openoffice.org-2-devel",
        "linux-firefox", "fr-linux-netscape", "linux-netscape-{communicator,navigator}",
        "linux_base", "ja-netscape7", "{ja,ko}-netscape-{communicator,navigator}-linux",
    ]

    return name in not_in

class freebsd_info:
    """
    Handles an entry like the one below:
    vulnerability-test-port>=2000<2010.02.26|http://cvsweb.freebsd.org/ports/security/vulnerability-test-port/|Not vulnerable, just a test port (database: 2010-02-26)
    """
    def __init__(self, line):
        split = line.split("|")
        for i in range(0, len(split[0])):
            c = split[0][i]
            if c != '<' and c != '=' and c != '>':
                continue
            self.name = map_names(split[0][0:i])
            self.versions = self.split_versions(split[0][i:])
            break

        self.link = split[1]
        self.kind = split[2]

    @classmethod
    def split_versions(self, input):
        """
        Split versions by <, >, >=, >=
        """
        versions = []
        last_pos = 0

        # Try to determine <, >, >=, <=
        # we will have to carry stuff on to find the
        # version..
        i = 0
        while i < len(input) - 1:
            c1 = input[i]
            c2 = input[i+1]
            if c1 != '<' and c1 != '>' and c1 != '=':
                i = i + 1
                continue

            # is a '=' coming behind it?
            next = i + 1
            if c2 == '=':
                next = next + 1

            # submit
            if last_pos != 0:
                versions.append((next_type, input[last_pos:i]))

            # remember stuff
            next_type = input[i:next]
            last_pos = next
            i = next

        assert last_pos != 0
        versions.append((next_type, input[last_pos:len(input)]))
        return versions

    def __repr__(self):
        return "%s: %s" % (self.name, self.versions)

def read_auditfile(filename):
    """
    Read an uncompressed audit file from freebsd
    """
    f = open(filename)
    packages = {}
    for line in f:
        if line.startswith("#"):
            continue

        info = freebsd_info(line)
        try:
            packages[info.name].append(info)
        except:
            packages[info.name] = []
            packages[info.name].append(info)
    return packages


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
    split = bsd_version.rsplit(',', 1)
    return split[0]

def compare_versions(oe, freebsd, not_known):
    def handle_package(oe_name, bsd_name):
        if not oe_name in oe:
            if oe_name == bsd_name:
                print >> not_known, "%s is not in OE" % oe_name
            return

        oe_version = strip_oe_version(oe[oe_name])
        for ver in freebsd[bsd_name]:
            str = []
            for (cmp, vers) in ver.versions:
                bsd_ver = strip_bsd_version(vers)
                str.append("%s %s %s %s" % (oe_name, oe_version, cmp, bsd_ver))
            print " && ".join(str), ver.link

    for package in freebsd.keys():
        # handle the various versions of OE packages
        handle_package(package, package)
        handle_package("%s-native" % package, package)
        handle_package("%s-full-native" % package, package)
        handle_package("%s-sdk" % package, package)


# read the input data
oe_packages = read_available("available")
freebsd_vuln = read_auditfile("auditfile")
buggy = open("not_in_oe.bugs", "w+")

compare_versions(oe=oe_packages, freebsd=freebsd_vuln, not_known=buggy)
