DESCRIPTION = "Sugar presence service"
LICENSE = "GPLv2"

PR = "r1"
 
DEPENDS = "sugar-toolkit"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base mime

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime/packages \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${sysconfdir} \
		${PYTHON_SITEPACKAGES_DIR}/"

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug"


AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

