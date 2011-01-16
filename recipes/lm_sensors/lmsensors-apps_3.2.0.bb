DESCRIPTION = "Hardware health monitoring applications"
HOMEPAGE = "http://www.lm-sensors.org/"
DEPENDS = "sysfsutils virtual/libiconv"
LICENSE = "GPL"

SRC_URI = "http://dl.lm-sensors.org/lm-sensors/releases/lm_sensors-${PV}.tar.bz2 \
"

SRC_URI[md5sum] = "829d88fb09d67723fbf42853eb84d1fd"
SRC_URI[sha256sum] = "bde7e1d8b473bca6528694b696668c4cd0a28515aef36b961e4f7d8a6b47e581"

S = "${WORKDIR}/lm_sensors-${PV}"

export PREFIX="${prefix}"

do_compile() {
	oe_runmake user LINUX=${STAGING_KERNEL_DIR} EXLDFLAGS="${LDFLAGS}" PROG_EXTRA=sensors MACHINE=${TARGET_ARCH}
}

do_install() {
	oe_runmake user_install EXLDFLAGS="${LDFLAGS}" DESTDIR=${D}

	# move manuals into proper place
	install -d ${D}${mandir}
	rm -rf ${D}${mandir}/*
	mv ${D}/usr/man/* ${D}${mandir}
}

PACKAGES =+  "libsensors libsensors-dev libsensors-dbg libsensors-doc"
PACKAGES =+ "lmsensors-sensors lmsensors-sensors-dbg lmsensors-sensors-doc"
PACKAGES =+ "lmsensors-scripts"

FILES_lmsensors-scripts = "${bindir}/*.pl ${bindir}/ddcmon ${sbindir}/fancontrol* ${sbindir}/pwmconfig ${sbindir}/sensors-detect"
RDEPENDS_lmsensors-scripts += "lmsensors-sensors perl bash"

FILES_lmsensors-sensors = "${bindir}/sensors ${sysconfdir}"
FILES_lmsensors-sensors-dbg += "${bindir}/.debug/sensors"
FILES_lmsensors-sensors-doc = "${mandir}/man1 ${mandir}/man5"
FILES_libsensors = "${libdir}/libsensors.so.*"
FILES_libsensors-dbg += "${libdir}/.debug"
FILES_libsensors-dev = "${libdir}/libsensors.so ${libdir}/libsensors.a ${includedir}"
FILES_libsensors-doc = "${mandir}/man3"

