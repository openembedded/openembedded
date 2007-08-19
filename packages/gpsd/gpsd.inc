DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus-glib ncurses python"

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
                --enable-dbus \
                --enable-python"

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz \
           file://gpsd-default \
           file://gpsd"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

export LDFLAGS = "-L${STAGING_LIBDIR} -lm"

do_compile_prepend() {
    export BUILD_SYS="${BUILD_SYS}"
    export HOST_SYS="${HOST_SYS}"
	find ${S} -name "*.so" -exec rm -f {} \;
}

do_install_prepend() {
    export BUILD_SYS="${BUILD_SYS}"
    export HOST_SYS="${HOST_SYS}"
}

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
        install -d ${D}/${sysconfdir}/default
        install -m 0644 ${WORKDIR}/gpsd-default ${D}/${sysconfdir}/default/gpsd
}

PACKAGES =+ "libgps python-pygps"

FILES_${PN} += "${sysconfdir}"
FILES_libgps = "${libdir}/*.so.*"
CONFFILES_${PN} = "${sysconfdir}/default/gpsd"

DESCRIPTION_python-pygps = "Python bindings to gpsd"
FILES_python-pygps = "${libdir}/*/site-packages/*"
RDEPENDS_python-pygps = "python-core gpsd"

