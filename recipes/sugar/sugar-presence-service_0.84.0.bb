DESCRIPTION = "Sugar presence service"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar-toolkit"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-presence-service/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base mime

do_configure_prepend() {
        mkdir -p ${S}/m4
}

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime/packages \
                ${datadir}/xsessions \
                ${datadir}/dbus-1 \
                ${sysconfdir} \
                ${libdir}/python*/site-packages/"

FILES_${PN}-dbg += "${libdir}/python*/site-packages/*/.debug"


AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

