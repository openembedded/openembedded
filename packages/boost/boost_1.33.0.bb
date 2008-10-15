include boost.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2"
#SRC_URI += "file://unit_test_log10f.patch;patch=1"
SRC_URI += "file://linux-uclibc.patch;patch=1"

