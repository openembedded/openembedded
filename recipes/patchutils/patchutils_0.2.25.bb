SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."


SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "4a86341ad45eff6bc961c45f3af2348d"
SRC_URI[sha256sum] = "cb3a710e9dfe7776aab45362e0cb28fe5440ab6e9e6983fa02eb174c010108d6"
