DESCRIPTION = "micro_evtd daemon for ARM Linkstations"
SECTION = "console/network"
PR = "r2"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "(lsarm)"

SRC_URI = "http://downloads.linkstationwiki.net/Users/timtimred/lsarm/micro_evtd.tar.gz"

inherit autotools gettext update-rc.d

S = ${WORKDIR}/micro_evtd

INITSCRIPT_NAME = "microevtd"
INITSCRIPT_PARAMS = "defaults 92"

do_configure() {
}

do_install() {
	install -D -m 0755 ${S}/micro_evtd ${D}${sbindir}/micro_evtd
	install -D -m 0755 ${S}/init ${D}${sysconfdir}/init.d/microevtd	
}
