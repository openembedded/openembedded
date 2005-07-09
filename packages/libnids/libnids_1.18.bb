LICENSE = "GPL"
SECTION = "libs"
DEPENDS = "libnet libpcap"
DESCRIPTION = "Libnids performs assembly of TCP segments \
into TCP streams, IP defragmentation, and TCP port \
scan detection."

SRC_URI = "${SOURCEFORGE_MIRROR}/libnids/libnids-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-libpcap=${STAGING_LIBDIR}/.. \
		--with-libnet=${STAGING_LIBDIR}/.."
EXTRA_OEMAKE = "'install_prefix=${D}'"

do_stage () {
	install -m 0644 ${S}/src/nids.h ${STAGING_INCDIR}/
	oe_libinstall -a -C src libnids ${STAGING_LIBDIR}
}
