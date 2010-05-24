require tar.inc

LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "ftp://alpha.gnu.org/gnu/tar/tar-${PV}.tar.gz \
           file://configure.patch \
           file://m4.patch"

SRC_URI[md5sum] = "71bfeab35c9935631fc133f9d272b041"
SRC_URI[sha256sum] = "0ef70273b6a54357c7823ed1f11015523f5cc5fe16df097e0b5300ae725c44e1"
