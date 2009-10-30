DESCRIPTION = "Xfce4 development tools"
SECTION = "x11/libs"
LICENSE = "GPL"
PR = "r1"

inherit xfce46

inherit autotools autotools_stage

XFCE_VERSION = ${PV}
SRC_URI = "http://www.us.xfce.org/archive/xfce-${XFCE_VERSION}/src/${PN}-${PV}.tar.bz2"

do_stage() {
	install -d ${STAGING_DATADIR}/aclocal
	install -m 644 m4macros/*.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN}-dev += " ${datadir}/xfce4/dev-tools/m4macros/*.m4"
