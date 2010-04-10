DESCRIPTION = "Library to read the extended image information (EXIF) from JPEG pictures"
HOMEPAGE = "http://sourceforge.net/projects/libexif"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libexif/libexif-${PV}.tar.bz2"

inherit autotools 

do_configure_append() {
	sed -i s:doc\ binary:binary:g Makefile
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "1b1e2b495c5aa20c08725f30545a110b"
SRC_URI[sha256sum] = "830802525700e65809afdd56ccdb5cd9950747044ab50666257bbb3d59a82754"
