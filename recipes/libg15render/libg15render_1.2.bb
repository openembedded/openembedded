DESCRIPTION = "This is a library to render text and shapes into a buffer usable by the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libg15"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15render-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-gnu-ld"

do_stage () {
	autotools_stage_all
}


SRC_URI[md5sum] = "a5a2a833d098926c3d289aeae452cc53"
SRC_URI[sha256sum] = "d22335af6a17ec44799da82671778d2072499b26c5773ab913d9ba20d159d20f"
