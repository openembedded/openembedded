DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
LICENSE = "GPLv2"

SRC_URI = "http://wirbel.htpc-forum.de/w_scan/w_scan-${PV}.tar.bz2"

S = "${WORKDIR}/w_scan-${PV}"

inherit autotools


FILES_${PN} += "${datadir}"
