DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "http://download.aircrack-ng.org/aircrack-ng-${PV}.tar.gz"

SBINFILES = "airodump-ng aireplay-ng airmon-ng airtun-ng"
BINFILES = "aircrack-ng airdecap-ng packetforge-ng ivstools kstats makeivs"

do_install() {
	install -d ${D}/${sbindir}
	for i in ${SBINFILES}; do
		install -m 0755 $i ${D}/${sbindir}
	done

	install -d ${D}/${bindir}
	for i in ${BINFILES}; do
		install -m 0755 $i ${D}/${bindir}
	done
}
