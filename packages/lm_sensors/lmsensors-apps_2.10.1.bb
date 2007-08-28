DESCRIPTION = "Hardware health monitoring applications"
HOMEPAGE = "http://secure.netroedge.com/~lm78/"
DEPENDS = "libsysfs virtual/libiconv"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://dl.lm-sensors.org/lm-sensors/releases/lm_sensors-${PV}.tar.gz \
           file://iconv.patch;patch=1 \
           file://prefix-fix.patch;patch=1 \
           file://add-sysfs-ldflags.patch;patch=1"

S = "${WORKDIR}/lm_sensors-${PV}"

do_compile() {
	oe_runmake LINUX=${STAGING_KERNEL_DIR} EXLDFLAGS="${LDFLAGS}" user PROG_EXTRA=sensors PREFIX=${prefix}
}

do_install() {
	oe_runmake user_install DESTDIR=${D}

	# backward compatibility with older OE packages
	mv ${D}${sbindir}/* ${D}${bindir}

	# move manuals into proper place
	install -d ${D}${mandir}
	rm -rf ${D}${mandir}/*
	mv ${D}/usr/man/* ${D}${mandir}

	# remove perl or bash scripts
	rm ${D}${bindir}/*.pl ${D}${bindir}/ddcmon
	rm ${D}${bindir}/fancontrol ${D}${bindir}/pwmconfig ${D}${bindir}/sensors-detect
	rm ${D}${mandir}/man8/fancontrol.8 ${D}${mandir}/man8/pwmconfig.8 ${D}${mandir}/man8/sensors-detect.8
}

PACKAGES =+  "libsensors libsensors-dev libsensors-dbg libsensors-doc"
PACKAGES =+ "lmsensors-sensors lmsensors-sensors-dbg lmsensors-sensors-doc"

FILES_lmsensors-sensors = "${bindir}/sensors ${sysconfdir}"
FILES_lmsensors-sensors-dbg = "${bindir}/.debug/sensors"
FILES_lmsensors-sensors-doc = "${mandir}/man1 ${mandir}/man5"
FILES_libsensors = "${libdir}/libsensors.so.*"
FILES_libsensors-dbg = "${libdir}/.debug"
FILES_libsensors-dev = "${libdir}/libsensors.so ${libdir}/libsensors.a ${includedir}"
FILES_libsensors-doc = "${mandir}/man3"
