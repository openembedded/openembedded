DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "http://download.aircrack-ng.org/aircrack-ng-${PV}.tar.gz"

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
	install -m 0755 airtun-ng	  ${D}/${sbindir}
	install -m 0755 makeivs 	  ${D}/${bindir}
}
