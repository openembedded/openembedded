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



SRC_URI[md5sum] = "9cd0026f5bc89c96cafbd6d1d3500a3b"
SRC_URI[sha256sum] = "4a2a9f54f3fc68250a92eab43a030b6b96c4b6e251b698b3378bfee751f1cbd8"
