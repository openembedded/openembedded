DESCRIPTION = "A cross platform audio visualization library"
HOMEPAGE = "http://libvisual.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/libvisual/libvisual-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	install -d ${STAGING_INCDIR}/libvisual/
	install -m 0644 ${S}/libvisual/*.h ${STAGING_INCDIR}/libvisual/
	oe_libinstall -so -C libvisual libvisual ${STAGING_LIBDIR}
}
