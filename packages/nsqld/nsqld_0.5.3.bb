DESCRIPTION = "Server process for syncing"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Tim Teulings <tim@teulings.org>"
LICENSE = "GPL"

SRC_URI = "${GPE_MIRROR}/nsqld-${PV}.tar.gz"

S = "${WORKDIR}/nsqld-${PV}"

inherit autotools pkgconfig

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/nsqld-${PV}/nsqld ${D}${bindir}
}
