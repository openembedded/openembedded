LICENSE = "GPL"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
DESCRIPTION = "Wakelan sends a magic packet to wake up remote PC's"
PR = "r0"

FILES = "${bindir}/wakelan"
SRC_URI = "http://www.ibiblio.org/pub/Linux/system/network/misc/${PN}-${PV}.tar.gz"

inherit autotools

do_install () {
	install -d ${bindir}
	install -m 0755 ${WORKDIR}/${PN}-${PV}/wakelan ${D}${bindir}/wakelan
}
