DESCRIPTION = "Virtual Tunnels over TCP/IP networks with traffic shaping, compression and encryption."
HOMEPAGE = "http://vtun.sourceforge.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "zlib lzo"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/vtun/vtun-${PV}.tar.gz \
	file://init \
	file://makefile.in-ldflags.patch;patch=1;pnum=0"

S = "${WORKDIR}/vtun"

inherit autotools

do_configure() {
	export BLOWFISH_HDR_DIR=${STAGING_INCDIR}/openssl
	oe_runconf --with-lzo-headers=${STAGING_INCDIR} --with-ssl-headers=${STAGING_INCDIR}/openssl
}

do_install() {
	oe_runmake INSTALL_OWNER="" DESTDIR=${D} install
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/vtund
	install ${S}/scripts/vtund-start.conf ${D}${sysconfdir}
}

CONFFILES_${PN}_nylon = "${sysconfdir}/vtund-start.conf ${sysconfdir}/vtund.conf"

SRC_URI[md5sum] = "309534fd03c5d13a19c43916f61f4bbf"
SRC_URI[sha256sum] = "fc80dac6d622fdb2db16d772edc6ff7d0023ee6eb5f2acb79d894ee30197c2e5"
