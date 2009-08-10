require portmap.inc

PR = "r4"

SRC_URI = "http://www.sourcefiles.org/Networking/Tools/Miscellanenous/portmap-6.0.tgz \
           file://destdir-no-strip.patch;patch=1 \
	   file://no-tcpd-support.patch;patch=1 \
           file://no-libwrap.patch;patch=1;pnum=0 \
           file://portmap.init "

S = "${WORKDIR}/${PN}_${PV}/"

CPPFLAGS += "-DFACILITY=LOG_DAEMON -DENABLE_DNS"
CFLAGS += "-O2 -Wall -Wstrict-prototypes -fpie"

fakeroot do_install() {
    install -d ${D}${mandir}/man8/ ${D}${base_sbindir} ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/portmap.init ${D}${sysconfdir}/init.d/portmap
    oe_runmake install DESTDIR=${D}
}
