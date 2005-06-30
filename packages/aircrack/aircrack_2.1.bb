SECTION = "console/network"
DESCRIPTION = "Aircrack is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.cr0.net:8040/code/network/aircrack/"
LICENSE = "GPLv2"
MAINTAINER = "Olivier Fauchon <olivier@aixmarseille.com>"
DEPENDS = ""
PV="2.1"
PR="r0"

SRC_URI = "http://www.cr0.net:8040/code/network/aircrack-2.1.tgz \
file://silent_patch.diff;patch=1;pnum=0"

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
