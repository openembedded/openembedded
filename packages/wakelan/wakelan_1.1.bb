LICENSE = "GPL"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
DESCRIPTION = "Wakelan sends a magic packet to wake up remote PC's"
PR = "r2"

FILES = "${bindir}/wakelan"
SRC_URI = "http://www.ibiblio.org/pub/Linux/system/network/misc/${PN}-${PV}.tar.gz"

inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/${PN}-${PV}/wakelan ${D}${bindir}/wakelan
}
