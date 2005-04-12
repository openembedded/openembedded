DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "Robert Anderson <rea@sr.unh.edu>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://ftp.berlios.de/gpsd/gpsd-${PV}.tar.gz"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

LDFLAGS = -lm

do_configure() {
	oe_runconf 
}

do_compile() {
	oe_runmake gpsd gpsd.1 libgps.3 libgpsd.3 gps.h gpsd.h
}

do_stage () {
	oe_libinstall -so -C ${S}/.libs libgps ${STAGING_LIBDIR}
	install -m 0655 ${S}/libgps.la ${STAGING_LIBDIR}
	install -m 0655 ${S}/gps.h ${STAGING_INCDIR}
	install -m 0655 ${S}/gpsd.h ${STAGING_INCDIR}
}

do_install () {
	install -d ${D}${sbindir}
	install -d ${D}${mandir}/man1
	install -d ${D}${mandir}/man3
	install -d ${D}${incdir}
	install -d ${D}${libdir}
	install -d ${D}${sysconfdir}/init.d

	install -m 0755 ${S}/.libs/gpsd ${D}${sbindir}
	oe_libinstall -so -C ${S}/.libs libgps ${D}${libdir}
	install -m 755 gpsd.1 ${D}${mandir}/man1/gpsd.1
	install -m 0755 ${S}/libgps.la ${D}${libdir}libgps.la
	install -m 0755 ${S}/gps.h ${S}/gpsd.h ${D}${incdir}
	install -m 755 libgps.3 libgpsd.3 ${D}${mandir}/man3/
	install -m 755 gpsd.init ${D}${sysconfdir}/init.d/gpsd
}

PACKAGES =+ "gpsd-devdoc "
FILES_${PN}-devdoc = "${mandir}/man3 "
