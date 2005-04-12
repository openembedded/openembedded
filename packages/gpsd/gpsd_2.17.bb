DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "Jose Bernardo Silva <jbs@bandos.homelinux.com> \
		Robert Anderson <rea@sr.unh.edu> \
		Stephan Zalewski <stephan.zalewski@uni-dusseldorf.de>"
LICENSE = "GPL"

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz \
	file://gpsd"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

LDFLAGS = -lm

do_stage () {
        oe_libinstall -so -C ${S}/.libs libgps ${STAGING_LIBDIR}
        install -m 0655 ${S}/libgps.la ${STAGING_LIBDIR}
        install -m 0655 ${S}/gps.h ${STAGING_INCDIR}
        install -m 0655 ${S}/gpsd.h ${STAGING_INCDIR}
}

do_install_append () {
        install -d ${D}/${sysconfdir}/init.d
        install -d ${D}/dev
        install -m 0755 ${WORKDIR}/gpsd ${D}/${sysconfdir}/init.d/
	ln -sf /dev/ttyS3 ${D}/dev/gps
}

FILES_gpsd =+ "/dev/gps ${sysconfdir}/inid.d/gpsd"
PACKAGES =+ "libgps"
FILES_libgps = "${libdir}"
