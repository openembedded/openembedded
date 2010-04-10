SECTION = "console/network"
DESCRIPTION = "Proof of concept 802.11 attack tool"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/"
LICENSE = "GPLv2"

SRC_URI = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/mdk2-${PV}.tar.bz2"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 mdk2       ${D}/${sbindir}
}

SRC_URI[md5sum] = "fbe3aaefc220556a03bf06a7811dc83c"
SRC_URI[sha256sum] = "87aa1784ffba9131b9fe3bbe7b1fa5d2fcb3ddffe9f8b73435894923467b981a"
