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

SRC_URI[md5sum] = "8cd2e31183ac37343d0009de5f5ac6b2"
SRC_URI[sha256sum] = "d467534f52cc24477ce8407d179834720a7dc4a7f01e7be4ab0f9810dc460e44"
