SECTION = "console/network"
DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
LICENSE = "GPLv2"
MAINTAINER = "Zero_Chaos <sidhayn@gmail.com>"
DEPENDS = ""
RDEPENDS = ""
PR="r2"

SRC_URI = "http://download.aircrack-ng.org/aircrack-ng-${PV}.tar.gz"

oe_compile() {
        oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="-O3 ${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}"
}

do_install() {
        install -d ${D}/${sbindir}
	install -d ${D}/${bindir}
        install -m 0755 airodump-ng       ${D}/${sbindir}
        install -m 0755 aircrack-ng       ${D}/${bindir}
        install -m 0755 aireplay-ng       ${D}/${sbindir}
        install -m 0755 airdecap-ng       ${D}/${bindir}
        install -m 0755 packetforge-ng    ${D}/${bindir}
        install -m 0755 airmon-ng         ${D}/${sbindir}
        install -m 0755 ivstools          ${D}/${bindir}
	install -m 0755 kstats		  ${D}/${bindir}
	install -m 0755 airtun-ng	  ${D}/${bindir}
}
