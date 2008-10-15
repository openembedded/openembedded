DESCRIPTION = "A frontend for the nmap port scanner, Qt/Embedded Palmtop Environment"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "nmap"
PR = "r0"

SRC_URI = "http://www.bluelightning.org/qpe-nmap/files/qpe-nmap-${PV}.tar.bz2"

APPNAME = "qpe-nmap"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

S = "${WORKDIR}/qpe-nmap"

inherit opie

do_install () {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/qpe-nmap/ipk/opt/QtPalmtop/pics/qpe-nmap.png ${D}${palmtopdir}/pics/
    install -d ${D}${palmtopdir}/apps/Applications/
    install -m 0644 ${WORKDIR}/qpe-nmap/ipk/opt/QtPalmtop/apps/Applications/qpe-nmap.desktop ${D}${palmtopdir}/apps/Applications/
}

