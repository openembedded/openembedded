DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
LICENSE = "GPLv2"

SRC_URI = "http://wirbel.htpc-forum.de/w_scan/w_scan-${PV}.tar.bz2"

S = "${WORKDIR}/w_scan-${PV}"

inherit autotools


FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "97cd83d5c174e386d01a364b2d280f2a"
SRC_URI[sha256sum] = "1a5864559b6a0acb76b9fa66b4e1351acd7d06c4e4a9a2ba323e7eafa4d4788b"
