DESCRIPTION = "A japanese inputmethod for Qt/Embedded based palmtop environments."
SECTION = "opie/inputmethods"
RDEPENDS_${PN} = "poboxserver virtual-japanese-font"
LICENSE = "GPL"
HOMEPAGE = "http://takahr.dhis.portside.net/cgi-bin/rwiki.cgi?cmd=view;name=QPOBox"
PR = "r3"

SRC_URI = "http://www.vanille.de/mirror/qpobox-${PV}.tar.gz \
           file://qpobox-0.5.4-opie.patch \
           file://qpobox.patch"
S = "${WORKDIR}/qpobox"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/share
        install -m 644 qpobox.key ${D}${palmtopdir}/share
}

SRC_URI[md5sum] = "45a7f9baeaaf638c6fcd0aa6f1f78080"
SRC_URI[sha256sum] = "405538793e33bf959cfc53955544615e691da8e37538e79855532d64dad5a95b"
