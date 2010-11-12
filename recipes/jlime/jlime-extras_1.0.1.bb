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

SRC_URI[md5sum] = "ebad10a6e081273271393507f88cca39"
SRC_URI[sha256sum] = "bb78cda43906deb5bbd73f0d9157108799ecc048521bf9654e7cfbba0885f2be"
