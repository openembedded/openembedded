DESCRIPTION = "Libnids performs assembly of TCP segments \
into TCP streams, IP defragmentation, and TCP port \
scan detection."
LICENSE = "GPL"
SECTION = "libs"
DEPENDS = "libnet-1.0 libpcap"
PR = "r0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/libnids/libnids-${PV}.tar.gz;name=libnids \
  file://configure.patch;patch=1"
SRC_URI[libnids.md5sum] = "72d37c79c85615ffe158aa524d649610"
SRC_URI[libnids.sha256sum] = "314b4793e0902fbf1fdb7fb659af37a3c1306ed1aad5d1c84de6c931b351d359"

inherit autotools

EXTRA_OECONF = "\
  --with-libpcap=${STAGING_LIBDIR}/.. \
  --with-libnet=${STAGING_LIBDIR}/.. \
"
EXTRA_OEMAKE = "'install_prefix=${D}'"

do_stage () {
	install -m 0644 ${S}/src/nids.h ${STAGING_INCDIR}/
	oe_libinstall -a -C src libnids ${STAGING_LIBDIR}
}
