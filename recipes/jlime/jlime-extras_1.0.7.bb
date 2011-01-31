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

SRC_URI[md5sum] = "cc702da4b5818aefb492bf1c22c8ab64"
SRC_URI[sha256sum] = "839a3d43f6736a0c111fe37140c6e9a7c4576b67d3d1ca4084a5973a739d8c66"
