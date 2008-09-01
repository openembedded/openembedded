DESCRIPTION = "Sugar etoys"
LICENSE = "GPLv2"

DEPENDS = "sugar"
RDEPENDS = "sugar"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/etoys/etoys-${PV}.tar.gz \
           file://etoys.diff;patch=1"

inherit autotools distutils-base

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

PACKAGES_ARCH = "all"
FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${datadir}/sugar/activities \
		${sysconfdir} "


