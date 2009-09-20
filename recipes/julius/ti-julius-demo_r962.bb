DESCRIPTION = "TI speech recognizer demo"
LICENSE = "GPL"

RDEPENDS = "julius"
PACKAGE_ARCH = "all"

SRC_URI = "http://dominion.thruhere.net/koen/OE/ecas-julius_acousticfiles.${PV}.tar.gz"

S = "${WORKDIR}/julius_acousticfiles.r962"

do_install() {
	rm ${S}/patches -rf
	install -d ${D}${datadir}/ti/julius-demo
	cp ${S}/* ${D}${datadir}/ti/julius-demo/
}

FILES_${PN} = "${datadir}"

