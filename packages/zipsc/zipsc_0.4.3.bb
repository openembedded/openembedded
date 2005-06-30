DESCRIPTION = "IP/Subnet calculator for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://www.warmi.net/zaurus/zipsc.shtml"
PR = "r1"

SRC_URI = "http://www.warmi.net/zaurus/files/zipsc_${PV}.tar.gz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/zipsc_${PV}"

inherit palmtop

do_install() {
        install -m 0755 zipsc Qtopia${palmtopdir}/bin/zipsc
	install -d ${D}/
	cp -a Qtopia/* ${D}/
}
