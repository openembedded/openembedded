DESCRIPTION = "A frontend for the nmap port scanner, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
AUTHOR = "Dennis Webb"
APPNAME = "qpenmapfe"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"
PR = "r0"

SRC_URI = "http://home.midsouth.rr.com/zaurus/qpenmapfe_${PV}_src.tar.gz \
           file://qpenmapfe.desktop \
           file://qpenmapfe.png"
S = "${WORKDIR}/qpe-nmapfe"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/*.png ${D}${palmtopdir}/pics/
	
}
