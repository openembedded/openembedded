SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."


SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "6a33888e34c23f7fde09a6e94e4f5950"
SRC_URI[sha256sum] = "6e3549b8586d8ac3ae8b2251b6cff9065f12a5d648c9c464543988ddb670545b"
