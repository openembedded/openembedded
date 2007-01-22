DESCRIPTION = "This is a library to handle the LCD and extra keys on the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libusb"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15-${PV}.tar.bz2"

inherit autotools

do_stage () {
        oe_libinstall -a -so libg15 ${STAGING_LIBDIR}
        for i in libg15.h; do
                install -m 0644 ${S}/$i ${STAGING_INCDIR}/
        done
}

