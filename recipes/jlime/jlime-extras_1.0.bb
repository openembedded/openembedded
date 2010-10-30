DESCRIPTION = "Various extras for the Jlime userlands"
PR = "r0"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/jlime-extras-1.0.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "6593cd0509c0f79b091d6b15a92ff65d"
SRC_URI[sha256sum] = "66800f009e3de2c0541f1d5a6be498fa4b2941f73405fe90d6f4c1b34ca5d2c6"
