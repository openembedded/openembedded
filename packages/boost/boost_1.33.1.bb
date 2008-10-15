include boost.inc

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2"
#SRC_URI += "file://unit_test_log10f.patch;patch=1"
SRC_URI += "file://linux-uclibc.patch;patch=1"
SRC_URI += "file://atomic_count_gcc_atomicity.patch;patch=1"
SRC_URI += "file://gcc43.patch;patch=1"
