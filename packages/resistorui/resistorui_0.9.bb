DESCRIPTION = "A frontend for the nmap port scanner, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://www.pellicosystems.com/zaurus/applications/index.html"
APPNAME = "resistorUI"
APPTYPE = "binary"
APPDESKTOP = "${S}"
PR = "r0"

SRC_URI = "http://www.pellicosystems.com/zaurus/applications/resistorUI_1.5.0-0.9_armSRC.zip"
S = "${WORKDIR}/ResistorUI"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 resistorUI.png ${D}${palmtopdir}/pics/
	
}
