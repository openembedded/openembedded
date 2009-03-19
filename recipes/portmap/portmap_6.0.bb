require portmap.inc

PR = "r3"

SRC_URI = "http://www.sourcefiles.org/Networking/Tools/Miscellanenous/portmap-6.0.tgz \
           file://destdir-no-strip.patch;patch=1 \
	   file://no-tcpd-support.patch;patch=1 \
           file://no-libwrap.patch;patch=1;pnum=0 \
           file://portmap.init "

# Remove this patch when SlugOS upgrades to binutils 1.18
SRC_URI_append_slugos = " file://no-pie.patch;patch=1 "

S = "${WORKDIR}/${PN}_${PV}/"

CPPFLAGS += "-DFACILITY=LOG_DAEMON -DENABLE_DNS"

fakeroot do_install() {
    install -d ${D}${mandir}/man8/ ${D}${base_sbindir} ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/portmap.init ${D}${sysconfdir}/init.d/portmap
    oe_runmake install DESTDIR=${D}
}
