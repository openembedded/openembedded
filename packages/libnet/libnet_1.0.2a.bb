DESCRIPTION = "Libnet is a collection of routines to help with \
the construction and handling of network packets. It provides a \
portable framework for low-level network packet shaping, \
handling, and injection."
SECTION = "libs/network"
LICENSE = "GPL"

SRC_URI = "http://www.packetfactory.net/libnet/dist/deprecated/libnet-${PV}.tar.gz \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/Libnet-${PV}"

inherit autotools

CPPFLAGS_prepend = "-I${S}/libnet/include -DHAVE_PF_PACKET "
EXTRA_OEMAKE = "'LIB_PREFIX=${libdir}/' 'MAN_PREFIX=${mandir}/' \
	        'BIN_PREFIX=${bindir}/' 'INC_PREFIX=${includedir}/'"

#FIXME:
do_configure() {
	oe_runconf
}

do_stage() {
	install -m 0755 libnet-config ${STAGING_BINDIR}/
	install -m 0644 include/libnet.h ${STAGING_INCDIR}/
	install -d ${STAGING_INCDIR}/libnet
	install -m 0644 include/libnet/libnet-headers.h ${STAGING_INCDIR}/libnet/
	install -m 0644 include/libnet/libnet-functions.h ${STAGING_INCDIR}/libnet/
	install -m 0644 include/libnet/libnet-structures.h ${STAGING_INCDIR}/libnet/
	install -m 0644 include/libnet/libnet-macros.h ${STAGING_INCDIR}/libnet/
	install -m 0644 include/libnet/libnet-asn1.h ${STAGING_INCDIR}/libnet/
	install -m 0644 include/libnet/libnet-ospf.h ${STAGING_INCDIR}/libnet/
	oe_libinstall -a -C lib libnet ${STAGING_LIBDIR}
}
