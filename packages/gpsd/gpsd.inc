DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus-0.23.4 ncurses"

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11  \
		--x-libraries=${STAGING_LIBDIR}"

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz \
	file://gpsd"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

export LDFLAGS = "-L${STAGING_LIBDIR} -lm"

do_stage() {
        oe_libinstall -so -C ${S}/.libs libgps ${STAGING_LIBDIR}
        install -m 0655 ${S}/libgps.la ${STAGING_LIBDIR}
        install -m 0655 ${S}/gps.h ${STAGING_INCDIR}
        install -m 0655 ${S}/gpsd.h ${STAGING_INCDIR}
}

do_install_append() {
        install -d ${D}/${sysconfdir}/init.d
        install -d ${D}/dev
        install -m 0755 ${WORKDIR}/gpsd ${D}/${sysconfdir}/init.d/
}

PACKAGES =+ "libgps"

FILES_${PN} += "${sysconfdir}"
FILES_libgps = "${libdir}/*.so*"
