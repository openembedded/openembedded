DESCRIPTION = "A frontend for the nmap port scanner, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
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

SRC_URI[md5sum] = "6e913e436a7b0f7572ec1ac77db41fde"
SRC_URI[sha256sum] = "ded3abdab8333aaf7f451963f32465ca1451a38afb173ef64e0f898d907a6e02"
