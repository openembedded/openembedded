require tar.inc

LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "ftp://alpha.gnu.org/gnu/tar/tar-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://m4.patch;patch=1"
