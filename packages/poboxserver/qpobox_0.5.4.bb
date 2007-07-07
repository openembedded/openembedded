DESCRIPTION = "A japanese inputmethod for Qt/Embedded based palmtop environments."
SECTION = "opie/inputmethods"
RDEPENDS = "poboxserver virtual/japanese-font"
LICENSE = "GPL"
HOMEPAGE = "http://takahr.dhis.portside.net/cgi-bin/rwiki.cgi?cmd=view;name=QPOBox"
PR = "r1"

SRC_URI = "http://www.vanille.de/mirror/qpobox-${PV}.tar.gz \
           file://qpobox-0.5.4-opie.patch;patch=1 \
           file://qpobox.patch;patch=1"
S = "${WORKDIR}/qpobox"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/share
        install -m 644 qpobox.key ${D}${palmtopdir}/share
}
