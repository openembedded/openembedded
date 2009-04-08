DESCRIPTION = "System watchdog daemon"
LICENSE = "GPL"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz \
	file://init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "watchdog"
INITSCRIPT_PARAMS = "defaults 10"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/watchdog
}

