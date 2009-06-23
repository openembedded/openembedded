DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "http://wirbel.htpc-forum.de/w_scan/w_scan-${PV}.tar.bz2"
S = "${WORKDIR}/w_scan-${PV}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 w_scan ${D}/${bindir}/

	install -d ${D}/${datadir}/w_scan
	install -m 0644 *.ids *.classes  ${D}/${datadir}/w_scan/
}

FILES_${PN} += "${datadir}"
