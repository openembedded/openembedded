DEPENDS = "enigma"
DESCRIPTION = "Enigma Blindscan Plugin"
MAINTAINER = "Andreas Monzner <ghost@dream-multimedia-tv.de>"
LICENSE = "GPL"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/enigma/enigma-blindscan-${PV}.tar.bz2"

PV = "0.1"
PN = "enigma-blindscan"
PR = "r0"

PACKAGES = "enigma-blindscan"

S = "${WORKDIR}/enigma-blindscan-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "/usr/lib/tuxbox/plugins/enigma_blindscan.so \
		/usr/lib/tuxbox/plugins/enigma_blindscan.cfg"

EXTRA_OECONF = "--with-target=native "
