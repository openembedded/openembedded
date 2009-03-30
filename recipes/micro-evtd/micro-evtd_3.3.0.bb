DESCRIPTION = "micro_evtd daemon for ARM Linkstations and Kurobox Pro"
HOMEPAGE = "http://buffalo.nas-central.org/download/Users/lb_worm/micro_evtd/"
SECTION = "console/network"
PR = "r1"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "(kuropro|lspro)"

SRC_URI = "http://downloads.buffalo.nas-central.org/Users/timtimred/kuropro/micro-evtd-3.3.0.tar.gz"

inherit update-rc.d

do_compile() {
        ${CC} ${CFLAGS} ${LDFLAGS} -o ${S}/micro_evtd ${S}/micro_evtd.c
}

do_install() {
        install -D -m 0755 ${S}/micro_evtd ${D}${sbindir}/micro_evtd
        install -D -m 0644 ${S}/microevtd ${D}${sysconfdir}/default/micro_evtd	
        install -D -m 0755 ${S}/EventScript ${D}${sysconfdir}/micro_evtd/EventScript
        install -D -m 0755 ${S}/init ${D}${sysconfdir}/init.d/micro-evtd
}

INITSCRIPT_NAME = "micro-evtd"
INITSCRIPT_PARAMS = "defaults"
