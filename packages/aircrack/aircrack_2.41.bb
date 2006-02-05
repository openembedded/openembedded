SECTION = "console/network"
DESCRIPTION = "Aircrack is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.cr0.net:8040/code/network/aircrack/"
LICENSE = "GPLv2"
MAINTAINER = "Rick Farina <sidhayn@hotmail.com>"
DEPENDS = ""
PR="r0"

SRC_URI = "http://distfiles.gentoo.org/distfiles/${P}.tgz \
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
