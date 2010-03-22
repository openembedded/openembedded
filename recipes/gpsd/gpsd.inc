DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus-glib ncurses python"
PROVIDES = "virtual/gpsd"
INC_PR = "r4"

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
                --enable-dbus \
"

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz;name=gpsd \
           file://gpsd-default \
           file://gpsd \
           file://60-gpsd.rules"
			   
inherit autotools_stage update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

LDFLAGS += "-L${STAGING_LIBDIR} -lm"
export STAGING_INCDIR
export STAGING_LIBDIR

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile_prepend() {
    export BUILD_SYS="${BUILD_SYS}"
    export HOST_SYS="${HOST_SYS}"
	find ${S} -name "*.so" -exec rm -f {} \;
}

do_install_prepend() {
    export BUILD_SYS="${BUILD_SYS}"
    export HOST_SYS="${HOST_SYS}"
}

do_install_append() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/gpsd ${D}/${sysconfdir}/init.d/
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/gpsd-default ${D}/${sysconfdir}/default/gpsd.default

    #support for udev
    install -d ${D}/${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/60-gpsd.rules ${D}/${sysconfdir}/udev/rules.d
    install -d ${D}${base_libdir}/udev/
    install -m 0755 ${S}/gpsd.hotplug ${D}${base_libdir}/udev/
    install -m 0755 ${S}/gpsd.hotplug.wrapper ${D}${base_libdir}/udev/
}

pkg_postinst_${PN}-conf() {
	update-alternatives --install ${sysconfdir}/default/gpsd gpsd-defaults ${sysconfdir}/default/gpsd.default 10
}

pkg_postrm_${PN}-conf() {	
	update-alternatives --remove gpsd-defaults ${sysconfdir}/default/gpsd.default	
}

PACKAGES =+ "libgps python-pygps gpsd-udev gpsd-conf gpsd-gpsctl gps-utils"

RDEPENDS_${PN} = "gpsd-gpsctl"
RRECOMMENDS_${PN} = "gpsd-conf gpsd-udev"

DESCRIPTION_gpsd-udev = "udev relevant files to use gpsd hotplugging"
FILES_gpsd-udev = "${base_libdir}/* ${sysconfdir}/udev/*"
RDEPENDS_gpsd-udev += "udev gpsd-conf"

DESCRIPTION_libgps = "C service library used for communicating with gpsd"
FILES_libgps = "${libdir}/*.so.*"

DESCRIPTION_gpsd-conf = "gpsd configuration files and init scripts" 
FILES_gpsd-conf = "${sysconfdir}"

DESCRIPTION_gpsd-gpsctl = "Tool for tweaking GPS modes"
FILES_gpsd-gpsctl = "${bindir}/gpsctl"

DESCRIPTION_gps-utils = "Utils used for simulating, monitoring,... a GPS"
FILES_gps-utils = "${bindir}/*"
RDEPENDS_gps-utils = "python-pygps"

DESCRIPTION_python-pygps = "Python bindings to gpsd"
FILES_python-pygps = "${libdir}/*/site-packages/*"
RDEPENDS_python-pygps = "python-core python-curses gpsd"

