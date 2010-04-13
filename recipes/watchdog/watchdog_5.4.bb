DESCRIPTION = "System watchdog daemon"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz \
	file://init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "watchdog"
INITSCRIPT_PARAMS = "defaults 10"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/watchdog
}


SRC_URI[md5sum] = "66480128b9dabcced2e4c8db3e60fa50"
SRC_URI[sha256sum] = "6c5bfb2edae5c289233b6cd65393bb7414a2d30ad4d1239c207a659a4232d91a"
