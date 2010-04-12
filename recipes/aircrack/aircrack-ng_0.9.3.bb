DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://download.aircrack-ng.org/aircrack-ng-${PV}.tar.gz \
           file://makefile-ldflags.patch;patch=1"

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

SRC_URI[md5sum] = "f37fdb000d8bad77da6a0a43bc2ef67a"
SRC_URI[sha256sum] = "71bca53eae0261d5bdd72e4363f43f5a6e40b2375dc4852a4029a061c789da58"
