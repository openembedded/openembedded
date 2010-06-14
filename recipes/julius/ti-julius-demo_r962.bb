DESCRIPTION = "TI speech recognizer demo"
LICENSE = "GPL"

RDEPENDS_${PN} = "julius"
PACKAGE_ARCH = "all"
PR = "r1"

SRC_URI = "http://dominion.thruhere.net/koen/OE/ecas-julius_acousticfiles.${PV}.tar.gz"

S = "${WORKDIR}/julius_acousticfiles.r962"

do_install() {
	rm ${S}/patches -rf
	install -d ${D}${datadir}/ti/julius-demo
	cp ${S}/* ${D}${datadir}/ti/julius-demo/
}

FILES_${PN} = "${datadir}"


SRC_URI[md5sum] = "406df5cd8ffa096bdb51466691e16b82"
SRC_URI[sha256sum] = "56cba0e065cdbc11dc74e379af9082b0f8a771ec5984733408c21163a8bea588"
