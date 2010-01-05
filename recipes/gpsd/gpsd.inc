DESCRIPTION = "A TCP/IP Daemon simplifying the communication with GPS devices"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus-glib ncurses python"
PROVIDES = "virtual/gpsd"

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
                --enable-dbus \
                --enable-python"

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz \
           file://gpsd-default \
           file://gps-hardware \
           file://gpsd"

SRC_URI_append_om-gta01 = " \
           file://restart_gllin.sh \
"
			   
inherit autotools_stage update-rc.d

INITSCRIPT_NAME = "gpsd"
INITSCRIPT_PARAMS = "defaults 35"

LDFLAGS += "-L${STAGING_LIBDIR} -lm"
export STAGING_INCDIR
export STAGING_LIBDIR

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
        install -d ${D}/dev
        install -m 0755 ${WORKDIR}/gpsd ${D}/${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/gps-hardware ${D}/${sysconfdir}/init.d/gps-hardware.default
        install -d ${D}/${sysconfdir}/default
        install -m 0644 ${WORKDIR}/gpsd-default ${D}/${sysconfdir}/default/gpsd.default
}

do_install_append_om-gta01() {
	install -d ${D}/${sysconfdir}/apm/resume.d
	install -m 755 ${WORKDIR}/restart_gllin.sh ${D}/${sysconfdir}/apm/resume.d
}

pkg_postinst_${PN}-conf() {
	update-alternatives --install ${sysconfdir}/default/gpsd gpsd-defaults ${sysconfdir}/default/gpsd.default 10
	update-alternatives --install ${sysconfdir}/init.d/gps-hardware gps-hardware ${sysconfdir}/init.d/gps-hardware.default 10
}

pkg_postrm_${PN}-conf() {	
	update-alternatives --remove gpsd-defaults ${sysconfdir}/default/gpsd.default
	update-alternatives --remove gps-hardware ${sysconfdir}/init.d/gps-hardware.default		
}

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"

PACKAGES =+ "libgps python-pygps gpsd-conf gpsd-gpsctl gps-utils"

PACKAGE_ARCH_gpsd-conf = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "gpsd-gpsctl"
RRECOMMENDS_${PN} = "gpsd-conf"

FILES_libgps = "${libdir}/*.so.*"
FILES_gpsd-conf = "${sysconfdir}"
FILES_gpsd-gpsctl = "${bindir}/gpsctl"
FILES_gps-utils = "${bindir}/*"

# might split them up even more fine granular
RDEPENDS_gps-utils = "python-pygps"

DESCRIPTION_python-pygps = "Python bindings to gpsd"
FILES_python-pygps = "${libdir}/*/site-packages/*"
RDEPENDS_python-pygps = "python-core python-curses gpsd"

