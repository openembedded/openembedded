DESCRIPTION = "Library to read the extended image information (EXIF) from JPEG pictures"
HOMEPAGE = "http://sourceforge.net/projects/libexif"
SECTION = "libs"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/libexif/libexif-${PV}.tar.bz2"

inherit autotools 

do_configure_append() {
	sed -i s:doc\ binary:binary:g Makefile
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "f7cf4e623a48c9a3b13f7f95f0a41015"
SRC_URI[sha256sum] = "dceb9355b148a8ee6aa96e3dff82a06c066c81e6ab18c190c946ed3b30fc7353"
