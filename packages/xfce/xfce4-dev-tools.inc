DESCRIPTION = "Xfce4 development tools"
SECTION = "x11/libs"
LICENSE = "GPL"

inherit xfce pkgconfig

do_stage() {
	install -d ${STAGING_DATADIR}/aclocal
	install -m 644 m4macros/*.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN}-dev += " ${datadir}/xfce4/dev-tools/m4macros/*.m4"
