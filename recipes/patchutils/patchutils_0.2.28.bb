SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."


SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "cb063425ae2d7065737857b4b58ae18a"
SRC_URI[sha256sum] = "46e20652ae4b9ceab5879ab939ec3eb2e57de742ea734272749ca53c93a20339"
