DESCRIPTION = "enigma2 default services/transponder"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "tmbinc@elitedvb.net"

PR = "r1"

SRC_URI = "file://*"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/share/enigma2/dealer
	install ${WORKDIR}/*.info ${D}/usr/share/enigma2/dealer
	install ${WORKDIR}/lamedb.* ${D}/usr/share/enigma2/dealer
}

FILES_${PN} = "/"
