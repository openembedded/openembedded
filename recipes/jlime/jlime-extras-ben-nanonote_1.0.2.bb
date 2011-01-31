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

SRC_URI[md5sum] = "320082193cde1de2bff8005f5c6f0e90"
SRC_URI[sha256sum] = "ea5d4bd236788fdd48e7cecd65f43a52a42b5c7aebb9a9e124b6ebf983188d7d"
