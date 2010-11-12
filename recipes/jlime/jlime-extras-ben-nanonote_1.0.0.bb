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

SRC_URI[md5sum] = "cb0d9957407696e5251ff6fe1369f774"
SRC_URI[sha256sum] = "b8832015a4aecb5e6e1b4578665bb2a2daadc5cf422779eaaa634f4ed125e177"
