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

SRC_URI[md5sum] = "e70e91d2e90831c0eb78944b6a9605ef"
SRC_URI[sha256sum] = "fc04f2f2bae4b3eef7eb331330e2e3fd336d1894dbf4cae631c8b635622cdd52"
