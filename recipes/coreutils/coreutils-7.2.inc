require coreutils.inc

SRC_URI = "ftp://ftp.gnu.org/gnu/coreutils/coreutils-${PV}.tar.gz \
           file://coreutils-7.2-fix-sort-segfault.patch;patch=1"
