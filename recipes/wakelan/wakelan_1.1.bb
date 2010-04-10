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

SRC_URI[md5sum] = "4a3a31d874967cd6ac761b7d4323e0d5"
SRC_URI[sha256sum] = "3df5eb8f877648799ab623cf1718ecc6f86eb0c2f51d344d8e860442dcc5cd6f"
