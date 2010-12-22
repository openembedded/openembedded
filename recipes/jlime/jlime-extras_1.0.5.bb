DESCRIPTION = "Various extras for the Jlime userlands"
PR = "r0"

RRECOMMENDS_${PN} = "jlime-extras-${MACHINE}"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/${PN}-${PV}.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "b1639d3176fe95b40cffcae530d2ed99"
SRC_URI[sha256sum] = "0410832ab77dbc04a6ea440795a4d50e126cbde170e589b0d93c5fb11a69c089"
