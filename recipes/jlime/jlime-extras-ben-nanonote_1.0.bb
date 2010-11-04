DESCRIPTION = "Various extras for the Ben Nanonote"
PR = "r0"

COMPATIBLE_MACHINE = "ben-nanonote"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/jlime-extras-ben-nanonote-1.0.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "72815eed1688a268145bc924518061e9"
SRC_URI[sha256sum] = "6fa29a42abf58f8a3137685af48e3cf647def7f111027deb39492bdd39f194a4"
