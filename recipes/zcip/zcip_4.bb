SECTION = "console/network"
DEPENDS = "libpcap libnet-1.0.2a"
DESCRIPTION = "zcip is an implementation of zero configuration networking (zeroconf)."
LICENSE = "BSD"
SRC_URI = "${SOURCEFORGE_MIRROR}/zeroconf/zcip-${PV}.tar.gz \
	   file://compile.patch;patch=1 \
	   file://linux-types.patch;patch=1 \
	   file://char-signed-idiocy.patch;patch=1"

CPPFLAGS_append = " -DLIBNET_LIL_ENDIAN"
do_compile () {
	oe_runmake 'LIBS=${STAGING_LIBDIR}/libpcap.a ${STAGING_LIBDIR}/libnet.a'
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0744 make-arp zcip ${D}${sbindir}/
}

SRC_URI[md5sum] = "ce40fdcd923110ee75717295a5fd4100"
SRC_URI[sha256sum] = "09bff63fdf2ae0704423ad232d31e792b342433e12306e107c14dc02f06ed507"
