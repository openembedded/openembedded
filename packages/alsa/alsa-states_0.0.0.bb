DESCRIPTION = "Machine specific alsa state files"
SECTION = "base"
LICENSE = "MIT"
PR = "r0"

SRC_URI = "file://*.state"

do_install () {
    install -d ${D}${sysconfdir}/alsa
    install -m 0644 ${WORKDIR}/*.state ${D}${sysconfdir}/alsa
}

FILES_${PN} += "${sysconfdir}/alsa/*"
