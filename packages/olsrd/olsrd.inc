DESCRIPTION = "OLSR mesh routing daemon"
HOMEPAGE = "http://www.olsr.org"
DESCRIPTION_olsrd-libs = "OLSR mesh routing daemon -  optional libraries"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS_olsrd = "olsrd-libs"

SRC_URI="http://www.olsr.org/releases/0.4/olsrd-${PV}.tar.bz2 \
	file://init \
	file://olsrd.conf"

PACKAGES =+ "olsrd-libs"
FILES_olsrd-libs = "${libdir}"

S = "${WORKDIR}/olsrd-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "olsrd"
INITSCRIPT_PARAMS = "defaults"
EXTRA_OEMAKE="MAKEFLAGS=-I${WORKDIR}/olsrd-${PV}"


do_configure() {
	oe_runmake OS=linux clean
}

do_compile() {
        oe_runmake
}

do_install () {
	oe_runmake OS=linux INSTALL_PREFIX=${D} install install_libs
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/olsrd
	install -m 644 ${WORKDIR}/olsrd.conf ${D}/${sysconfdir}
}

CONFFILES_${PN} = "${sysconfdir}/olsrd.conf"
