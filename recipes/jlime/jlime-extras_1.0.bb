DESCRIPTION = "Various extras for the Jlime userlands"
PR = "r0"

RRECOMMENDS = "jlime-extras-${MACHINE}"

PACKAGE_ARCH = "all"
SRC_URI = "http://jlime.com/downloads/development/software/jlime-extras-1.0.tar.gz"

FILES_${PN} = "/etc /usr"

do_install() {
	install -d ${D}
	cp -R etc usr ${D}
}

SRC_URI[md5sum] = "27b38dbe209da42ee11977bfd1f69cd6"
SRC_URI[sha256sum] = "40798e7246c44b4739ded837043a0fc527f2401f8cbac31f989f573a171a61c8"
