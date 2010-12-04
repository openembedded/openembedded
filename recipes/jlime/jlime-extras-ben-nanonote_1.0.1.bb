DESCRIPTION = "Various extras for the Ben Nanonote"
PR = "r0"

COMPATIBLE_MACHINE = "ben-nanonote"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/${PN}-${PV}.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "c4c4f7542bb431bb9cc241d12fc60970"
SRC_URI[sha256sum] = "f6911d933e860cabe3067744c2df70712ee1fa9df449501b65bb010a33cb936b"
