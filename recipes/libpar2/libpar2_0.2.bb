DESCRIPTION = "A tool to apply the data-recovery capability concepts of RAID-like systems \
to the posting & recovery of multi-part archives on Usenet."
SECTION = "libs"
LICENSE = "GPL"
HOMEPAGE = "http://parchive.sourceforge.net/"
DEPENDS = "libsigc++-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/parchive/libpar2/libpar2-${PV}.tar.gz"

inherit autotools_stage pkgconfig
