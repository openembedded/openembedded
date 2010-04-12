DESCRIPTION = "Sugar presence service"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar-toolkit"
RDEPEDS = "avahi networkmanager"

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
                ${PYTHON_SITEPACKAGES_DIR}/"

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug"


AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


SRC_URI[md5sum] = "bf292605b6c2d0ef3761a957acc8a95e"
SRC_URI[sha256sum] = "15afba51ef2c34b86ae2c4b8ecfe612e37a7024ae9ccf42a3b612d70e3034d48"
