# This class exists to provide information about the targets that
# may be needed by other classes and/or recipes. If you add a new
# target this will probably need to be updated.

#
# Returns information about 'what' for the named target 'target'
# where 'target' == "<arch>-<os>"
#
# 'what' can be one of
# * target: Returns the target name ("<arch>-<os>")
# * endianess: Return "be" for big endian targets, "le" for little endian
# * bits: Returns the bit size of the target, either "32" or "64"
# * libc: Returns the name of the c library used by the target
#
# It is an error for the target not to exist.
# If 'what' doesn't exist then an empty value is returned
#
def siteinfo_get_filenames(d):
    archinfo = {
        "arm": "endian-little bit-32 arm-common",
        "armeb": "endian-big bit-32 arm-common",
        "avr32": "endian-big bit-32 avr32-common",
        "bfin": "endian-little bit-32 bfin-common",
        "i386": "endian-little bit-32 ix86-common",
        "i486": "endian-little bit-32 ix86-common",
        "i586": "endian-little bit-32 ix86-common",
        "i686": "endian-little bit-32 ix86-common",
        "ia64": "endian-little bit-64",
        "mips": "endian-big bit-32 mips-common",
        "mipsel": "endian-little bit-32 mips-common",
        "powerpc": "endian-big bit-32 powerpc-common",
        "nios2": "endian-little bit-32 nios2-common",
        "powerpc64": "endian-big bit-64 powerpc-common powerpc64-linux",
        "ppc": "endian-big bit-32 powerpc-common",
        "ppc64": "endian-big bit-64 powerpc-common powerpc64-linux",
        "sh3": "endian-little bit-32 sh-common",
        "sh4": "endian-little bit-32 sh-common",
        "sparc": "endian-big bit-32",
        "viac3": "endian-little bit-32 ix86-common",
        "x86_64": "endian-little bit-64",
    }
    osinfo = {
        "darwin": "common-darwin",
        "darwin9": "common-darwin",
        "linux": "common-linux common-glibc",
        "linux-gnueabi": "common-linux common-glibc",
        "linux-gnuspe": "common-linux common-glibc",
        "linux-uclibc": "common-linux common-uclibc",
        "linux-uclibceabi": "common-linux common-uclibc",
        "linux-uclibcspe": "common-linux common-uclibc",
        "uclinux-uclibc": "common-uclibc",
        "cygwin": "common-cygwin",
        "mingw32": "common-mingw",
    }
    targetinfo = {
        "arm-linux-gnueabi":    "arm-linux",
        "arm-linux-uclibceabi":    "arm-linux-uclibc",
        "armeb-linux-gnueabi":     "armeb-linux",
        "armeb-linux-uclibceabi":  "armeb-linux-uclibc",
        "powerpc-linux-gnuspe":    "powerpc-linux",
        "powerpc-linux-uclibcspe": "powerpc-linux-uclibc",
    }

    arch = d.getVar("HOST_ARCH", True)
    os = d.getVar("HOST_OS", True)
    target = "%s-%s" % (arch, os)

    sitefiles = []
    if arch in archinfo:
        sitefiles.extend(archinfo[arch].split())
    if os in osinfo:
        sitefiles.extend(osinfo[os].split())
    if target in targetinfo:
        sitefiles.extend(targetinfo[target].split())
    sitefiles.append(target)
    sitefiles.append("common")

    return sitefiles

def _siteinfo_get_files(d):
    import itertools

    def inherits(d, *classes):
        if any(bb.data.inherits_class(cls, d) for cls in classes):
            return True

    if inherits(d, "native", "nativesdk"):
        return

    paths = itertools.chain(d.getVar("BBPATH", True).split(":"),
                            d.getVar("FILESPATH", True).split(":"))
    for filename in siteinfo_get_filenames(d):
        for p in paths:
            fullpath = os.path.join(p, "site", filename)
            if os.path.exists(fullpath):
                yield fullpath

def siteinfo_get_files(d):
    return " ".join(_siteinfo_get_files(d))

python () {
    sitefiles = set(siteinfo_get_filenames(d))
    if "endian-little" in sitefiles:
        d.setVar("SITEINFO_ENDIANNESS", "le")
    elif "endian-big" in sitefiles:
        d.setVar("SITEINFO_ENDIANNESS", "be")
    else:
        bb.error("Unable to determine endianness for architecture '%s'" %
                 d.getVar("HOST_ARCH", True))
        bb.fatal("Please add your architecture to siteinfo.bbclass")

    if "bit-32" in sitefiles:
        d.setVar("SITEINFO_BITS", "32")
    elif "bit-64" in sitefiles:
        d.setVar("SITEINFO_BITS", "64")
    else:
        bb.error("Unable to determine bit size for architecture '%s'" %
                 d.getVar("HOST_ARCH", True))
        bb.fatal("Please add your architecture to siteinfo.bbclass")
}
