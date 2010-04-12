SECTION = "console/network"
DESCRIPTION = "Proof of concept 802.11 attack tool"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/"
LICENSE = "GPLv2"

SRC_URI = "http://www.tu-darmstadt.de/~p_larbig/wlan/mdk3-${PV}.tar.bz2 \
           file://cross-compile.diff;patch=1"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 mdk3       ${D}/${sbindir}
}

SRC_URI[md5sum] = "06ed66c2f6651004b436199d1aa9a3cb"
SRC_URI[sha256sum] = "3fa27adcc60b090b22b510343818f8076dd87ea5a911ebee7709ae8dadb6d4d0"
