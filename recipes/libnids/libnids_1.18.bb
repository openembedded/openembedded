DESCRIPTION = "Libnids performs assembly of TCP segments \
into TCP streams, IP defragmentation, and TCP port \
scan detection."
LICENSE = "GPL"
SECTION = "libs"
DEPENDS = "libnet-1.0 libpcap"
PR = "r1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/libnids/libnids-${PV}.tar.gz \
  file://configure.patch;patch=1"

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

SRC_URI[md5sum] = "9ee6dcdfac97bae6fe611aa27d2594a5"
SRC_URI[sha256sum] = "b0275c914197a53c6ccf631eac756fd37ec6f2d8f09f15757061495cf9be0fcd"
