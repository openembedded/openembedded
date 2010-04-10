SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."


SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "798d68d9d7ec3499d63b075ca4d4a6a9"
SRC_URI[sha256sum] = "7630c3f1b0f7f8e3f3c9b814a553e910adaa2a13778ee095e86af27f6cb646dc"
