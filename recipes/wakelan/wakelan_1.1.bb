DESCRIPTION = "Wakelan sends a magic packet to wake up remote PC's"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/network/misc/${PN}-${PV}.tar.gz"

inherit autotools

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/${PN}-${PV}/wakelan ${D}${bindir}/wakelan
}

FILES = "${bindir}/wakelan"

INHIBIT_AUTO_STAGE = "1"
