DESCRIPTION = "Init script for qtdemo"
LICENSE = "MIT"
SRC_URI = "file://qtdemo-init"
PR = "r2"

PACKAGE_ARCH = "all"

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/qtdemo-init ${D}${sysconfdir}/init.d/qtdemo
}

inherit update-rc.d

INITSCRIPT_NAME = "qtdemo"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
