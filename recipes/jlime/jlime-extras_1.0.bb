DESCRIPTION = "Various extras for the Jlime userlands"
PR = "r0"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/jlime-extras-1.0.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "a3a9179307ef2af13d535e2cd2d98e86"
SRC_URI[sha256sum] = "388a03a6380890cf63239b8af351910eb9ad5247383b61f63fb1b4ee3de3cc88"
