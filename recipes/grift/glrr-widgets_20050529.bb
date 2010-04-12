DESCRIPTION = "gtk+ debug and inspection widgets"
HOMEPAGE = "http://sf.net/project/grift"
SECTION = "libs/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0 gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/grift/glrr-widgets-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "97bd37e930e4e3837ee3fae45a4eec8f"
SRC_URI[sha256sum] = "62a88525ae1deb3112221c4e1068e8d940afb3b8e5664e353cf3360ab403b845"
