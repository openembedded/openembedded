DESCRIPTION = "A japanese inputmethod for Qt/Embedded based palmtop environments."
SECTION = "opie/inputmethods"
RDEPENDS = "poboxserver"
LICENSE = "GPL"

SRC_URI = "http://www.vanille.de/mirror/qpobox-${PV}.tar.gz \
           file://ashikase.patch;patch=1"
S = "${WORKDIR}/qpobox"

inherit opie

