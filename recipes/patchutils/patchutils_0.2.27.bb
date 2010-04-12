SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."


SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "421c627f149ff261d07ac9e8afd4226e"
SRC_URI[sha256sum] = "7b7abe4b63c506e3c487d2bf148d95037c7017a1e925133b070b668bfc778712"
