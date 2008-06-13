DESCRIPTION = "Xfce4 development tools"
SECTION = "x11/libs"
LICENSE = "GPL"

inherit xfce
XFCE_VERSION = 4.4.2

do_stage() {
	install -d ${STAGING_DATADIR}/aclocal
	install -m 644 m4macros/*.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN}-dev += " ${datadir}/xfce4/dev-tools/m4macros/*.m4"
