DESCRIPTION = "OLSR mesh routing daemon"
DESCRIPTION_olsrd-libs = "OLSR mesh routing daemon -  optional libraries"
HOMEPAGE = "http://www.olsr.org"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI="http://www.olsr.org/downloadolsr.cgi?file=olsrd-${PV}.tar.bz2 \
	file://init \
	file://lib.diff;patch=1"

PACKAGES =+ "olsrd-libs"
FILES_olsrd-libs = "${libdir}"

S = "${WORKDIR}/olsrd-${PV}"

do_compile() {
	oe_runmake all libs
}

do_install () {
	oe_runmake INSTALL_PREFIX=${D} install install_libs
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/olsrd
}

CONFFILES_${PN} = "/etc/olsrd.conf"

