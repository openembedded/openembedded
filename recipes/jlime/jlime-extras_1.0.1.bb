DESCRIPTION = "Various extras for the Jlime userlands"
PR = "r0"

RRECOMMENDS = "jlime-extras-${MACHINE}"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/${PN}-${PV}.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "920be63e2269289b5ffdf3c0199d71ef"
SRC_URI[sha256sum] = "3fd6016ac8bafab8eaa8c1cc2975a8bbeca116dcdf807989154bc772fbf518d0"
