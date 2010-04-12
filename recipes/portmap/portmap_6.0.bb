require portmap.inc

PR = "r5"

SRC_URI = "http://www.sourcefiles.org/Networking/Tools/Miscellanenous/portmap-6.0.tgz \
           file://destdir-no-strip.patch;patch=1 \
	   file://no-tcpd-support.patch;patch=1 \
           file://no-libwrap.patch;patch=1;pnum=0 \
           file://portmap.init "

S = "${WORKDIR}/${PN}_${PV}/"

CPPFLAGS += "-DFACILITY=LOG_DAEMON -DENABLE_DNS"
CFLAGS += "-Wall -Wstrict-prototypes -fPIC"

fakeroot do_install() {
    install -d ${D}${mandir}/man8/ ${D}${base_sbindir} ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/portmap.init ${D}${sysconfdir}/init.d/portmap
    oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "ac108ab68bf0f34477f8317791aaf1ff"
SRC_URI[sha256sum] = "02c820d39f3e6e729d1bea3287a2d8a6c684f1006fb9612f97dcad4a281d41de"
