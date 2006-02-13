LICENSE = "GPL"
inherit update-rc.d

DESCRIPTION = "Initscript for login-managers"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
PR = "r1"

INITSCRIPT_NAME = "login-manager"
INITSCRIPT_PARAMS = "start 99 5 . stop 20 0 1 6 ."

SRC_URI = "file://login-manager"

do_install() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/login-manager ${D}/etc/init.d/
}		

