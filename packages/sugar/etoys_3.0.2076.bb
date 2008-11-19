DESCRIPTION = "Sugar etoys"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "sugar"
RDEPENDS = "sugar shared-mime-info"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/etoys/etoys-${PV}.tar.gz \
           file://etoys.diff;patch=1"

inherit autotools distutils-base

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

PACKAGES_ARCH = "all"
FILES_${PN} += "${datadir}/${PN} \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${datadir}/sugar/activities \
		${sysconfdir} "


