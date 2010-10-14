DESCRIPTION = "Dns2tcp is a network tool designed to relay TCP connections through DNS traffic"
HOMEPAGE = "http://www.hsc.fr/ressources/outils/dns2tcp/index.html.en"
LICENSE = "GPLv2"
SECTION = "console/network"
PR = "r0"

SRC_URI = "http://www.hsc.fr/ressources/outils/dns2tcp/download/dns2tcp-${PV}.tar.gz"
SRC_URI[md5sum] = "51c5dc69f5814c2936ce6832217d292d"
SRC_URI[sha256sum] = "ea9ef59002b86519a43fca320982ae971e2df54cdc54cdb35562c751704278d9"

inherit autotools

PACKAGES =+ "${PN}-client ${PN}-client-dbg ${PN}-client-doc ${PN}-server ${PN}-server-dbg ${PN}-server-doc"
FILES_${PN}-client = "${bindir}/dns2tcpc"
FILES_${PN}-client-dbg = "${bindir}/.debug/dns2tcpc"
FILES_${PN}-client-doc = "${mandir}/man1/dns2tcpc.1"
FILES_${PN}-server = "${bindir}/dns2tcpd"
FILES_${PN}-server-dbg = "${bindir}/.debug/dns2tcpd"
FILES_${PN}-server-doc = "${mandir}/man1/dns2tcpd.1"
