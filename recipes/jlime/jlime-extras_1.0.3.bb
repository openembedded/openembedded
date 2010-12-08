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

SRC_URI[md5sum] = "da56fc17d634eca0d91e5fb2439d0f1b"
SRC_URI[sha256sum] = "6bec27a320b1c8a61f625fa1c1f521a876caaae01cca5cb26bc548c33866c06c"
