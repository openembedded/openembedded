DESCRIPTION = "Sugar presence service"
LICENSE = "GPLv2"

DEPENDS = "sugar-toolkit"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${sysconfdir} \
		${libdir}/python*/site-packages/"

FILES_${PN}-dbg += "${libdir}/python*/site-packages/*/.debug"


AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

