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

SRC_URI[md5sum] = "29d20fec3febf96de43bc27db4b47cfd"
SRC_URI[sha256sum] = "7107d31e05168febe4cd11bc7fb91ea8f6283b225c7c48a0e9579458d3b5de33"
