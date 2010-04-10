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


SRC_URI[md5sum] = "0b50a2467e4e9eedd22f51bf2fe6e6f3"
SRC_URI[sha256sum] = "3b33c9689fb9faaeaf4308cd66794b02951249253ac96df99bd308c4b6d38850"
