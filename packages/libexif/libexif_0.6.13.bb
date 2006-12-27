DESCRIPTION = "Library to read the extended image information (EXIF) from JPEG pictures"
HOMEPAGE = "http://sourceforge.net/projects/libexif"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libexif/libexif-${PV}.tar.bz2"

inherit autotools pkgconfig

do_configure_append() {
	sed -i s:doc\ binary:binary:g Makefile
}

do_stage() {
	autotools_stage_all
}
