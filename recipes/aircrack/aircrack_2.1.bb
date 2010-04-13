SECTION = "console/network"
DESCRIPTION = "Aircrack is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.cr0.net:8040/code/network/aircrack/"
LICENSE = "GPLv2"
DEPENDS = ""
PV="2.1"
PR ="r0"

SRC_URI = "http://archive.aircrack-ng.org/aircrack-old/${P}.tgz \
file://silent_patch.diff;patch=1;pnum=0"

SRC_URI[md5sum] = "694c6180f620b0534e5925a71b960bd1"
SRC_URI[sha256sum] = "9b749d98278450b80153c1f82b7e253548a3f03603062dc98cc1320803d791da"

inherit autotools

do_install() {
        install -d ${D}/${sbindir}
        install -d ${D}/${libdir}/${PN}
        install -m 0755 802ether          ${D}/${sbindir}
        install -m 0755 airodump          ${D}/${sbindir}
        install -m 0755 aircrack          ${D}/${sbindir}
        install -m 0755 aireplay          ${D}/${sbindir}
        install -m 0755 hopper.sh          ${D}/${sbindir}
}
