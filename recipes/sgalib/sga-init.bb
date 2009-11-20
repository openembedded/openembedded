DESCRIPTION = "Simple Nomadik SGA Init Script"
LICENSE = "ST"
SECTION = "x11"
PRIORITY = "optional"
PR = "r1"

SRC_URI = "file://sga-init"
S = ${WORKDIR}

PACKAGE_ARCH = "all"

FILES_${PN}= "${sysconfdir}"

do_install() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/sga-init ${D}/${sysconfdir}/init.d
}

inherit update-rc.d

INITSCRIPT_NAME = "sga-init"
INITSCRIPT_PARAMS = "start 30 5 2 ."
