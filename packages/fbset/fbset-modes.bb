DESCRIPTION = "Default display timings and resolutions for fbset"
PV = "0.1.0"
PR = "r0"

ALLOW_EMPTY = "1"

SRC_URI_append_fic-gta01 = " \
    file://fb.modes"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fb.modes ${D}${sysconfdir}
}

FILES_${PN} = "${sysconfdir}/fb.modes"
PACKAGE_ARCH_${PN} = "all"
PACKAGE_ARCH_fbset-modes = "${MACHINE}"

