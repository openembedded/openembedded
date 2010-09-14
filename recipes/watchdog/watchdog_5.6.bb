DESCRIPTION = "System watchdog daemon"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz \
	file://init"

SRC_URI_append_nokia900 = " \
	file://watchdog.conf \
	file://watchdog-omap.conf"

inherit autotools update-rc.d

INITSCRIPT_NAME = "watchdog"
INITSCRIPT_PARAMS = "defaults 10"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/watchdog
}

do_install_append_nokia900() {
	install -m 0644 ${WORKDIR}/watchdog.conf ${D}${sysconfdir}/watchdog.conf
	install -m 0644 ${WORKDIR}/watchdog-omap.conf ${D}${sysconfdir}/watchdog-omap.conf
}


SRC_URI[md5sum] = "6df285569dd1d85528b983c98c9b2b7c"
SRC_URI[sha256sum] = "a2c7d6726e092315dbb047211b754528e4532521678a30e16f60a31bb86a7f74"
