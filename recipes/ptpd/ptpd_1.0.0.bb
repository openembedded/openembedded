DESCRIPTION = "Precision Time Protocol (PTP) as defined by the IEEE 1588 standard"
HOMEPAGE = "http://sourceforge.net/projects/ptpd"
LICENSE = "BSD"
SECTION = "network"
PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/project/ptpd/ptpd/${PV}/ptpd-${PV}.tar.gz" 
S = "${WORKDIR}/ptpd-${PV}/src"

do_install() {
        install -d ${D}${bindir} ${D}${mandir}/man8
        install -m 4555 ptpd ${D}${bindir}
        install -m 644 ptpd.8 ${D}${mandir}/man8
}
