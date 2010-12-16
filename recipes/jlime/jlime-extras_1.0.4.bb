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

SRC_URI[md5sum] = "6cc0fd77486abf49bf8248640668bb17"
SRC_URI[sha256sum] = "f7dc823bea17fdef546a4803a4b73704526bd58015334615f0d6b09d131d8967"
