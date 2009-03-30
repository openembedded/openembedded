SECTION = "console/network"
DESCRIPTION = "Proof of concept 802.11 attack tool"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/"
LICENSE = "GPLv2"

SRC_URI = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/mdk2-${PV}.tar.bz2"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 mdk2       ${D}/${sbindir}
}
