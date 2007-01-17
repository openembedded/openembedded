DESCRIPTION = "This is a library to render text and shapes into a buffer usable by the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libg15"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15render-${PV}.tar.bz2"

inherit autotools

do_stage () {
        oe_libinstall -a -so libg15render ${STAGING_LIBDIR}
        for i in libg15render.h; do
                install -m 0644 ${S}/$i ${STAGING_INCDIR}/
        done
}

