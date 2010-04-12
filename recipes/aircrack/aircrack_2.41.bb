SECTION = "console/network"
DESCRIPTION = "Aircrack is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.cr0.net:8040/code/network/aircrack/"
LICENSE = "GPLv2"
DEPENDS = ""
PR ="r1"

SRC_URI = "http://www.wirelessdefence.org/Contents/Files/${P}.tgz \
		file://oe.patch;patch=1;pnum=1"

inherit autotools

do_install() {
        install -d ${D}/${sbindir}
        install -d ${D}/${libdir}/${PN}
        install -m 0755 airodump          ${D}/${sbindir}
        install -m 0755 aircrack          ${D}/${sbindir}
        install -m 0755 aireplay          ${D}/${sbindir}
        install -m 0755 airdecap          ${D}/${sbindir}
        install -m 0755 arpforge          ${D}/${sbindir}
        install -m 0755 airmon.sh         ${D}/${sbindir}
        install -m 0755 mergeivs          ${D}/${sbindir}
        install -m 0755 pcap2ivs          ${D}/${sbindir}
}

SRC_URI[md5sum] = "05a37c8a165efb11ea226829c809deb3"
SRC_URI[sha256sum] = "0273c476875e5dd09c7e15e8de58ed18fa9f5f2f9482a78e4171b3f56d75efa4"
