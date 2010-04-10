DESCRIPTION = "A tool to apply the data-recovery capability concepts of RAID-like systems \
to the posting & recovery of multi-part archives on Usenet."
SECTION = "libs"
LICENSE = "GPL"
HOMEPAGE = "http://parchive.sourceforge.net/"
DEPENDS = "libsigc++-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/parchive/libpar2/libpar2-${PV}.tar.gz"

inherit autotools_stage pkgconfig

SRC_URI[md5sum] = "94c6df4e38efe08056ecde2a04e0be91"
SRC_URI[sha256sum] = "074fbf840f73b1e13e0405fce261078c81c8c0a4859e30a7bba10510f9199908"
