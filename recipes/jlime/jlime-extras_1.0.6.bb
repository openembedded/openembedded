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

SRC_URI[md5sum] = "d8021d921db703e10ecf98d9a88cbfa3"
SRC_URI[sha256sum] = "2b075fc7ec06fe4d91815b300186011b7cdcb4ab7617c43773db598aac85de26"
