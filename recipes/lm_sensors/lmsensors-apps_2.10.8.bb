DESCRIPTION = "Hardware health monitoring applications"
HOMEPAGE = "http://www.lm-sensors.org/"
DEPENDS = "sysfsutils virtual/libiconv"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://dl.lm-sensors.org/lm-sensors/releases/lm_sensors-${PV}.tar.gz \
           file://prefix-fix.patch;patch=1 \
           file://add-sysfs-ldflags.patch;patch=1"

SRC_URI_append_uclibc = "file://iconv.patch;patch=1"

S = "${WORKDIR}/lm_sensors-${PV}"

do_compile() {
	oe_runmake user LINUX=${STAGING_KERNEL_DIR} EXLDFLAGS="${LDFLAGS}" PROG_EXTRA=sensors MACHINE=${TARGET_ARCH}
}

do_install() {
	oe_runmake user_install EXLDFLAGS="${LDFLAGS}" DESTDIR=${D}

	install -d ${D}/.usr
	mv ${D}/* ${D}/.usr
	mv ${D}/.usr ${D}/usr

	install -d ${D}${sysconfdir}
	mv ${D}/usr/etc/sensors.conf ${D}${sysconfdir}
	# move manuals into proper place
	install -d ${D}${mandir}
	rm -rf ${D}${mandir}/*
	mv ${D}/usr/man/* ${D}${mandir}
}

do_stage() {
	oe_runmake user_install EXLDFLAGS="${LDFLAGS}" DESTDIR=${STAGING_DIR_TARGET}/${layout_prefix}
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

SRC_URI[md5sum] = "1e4ece01157f5d7b5b054a76a8ceae7c"
SRC_URI[sha256sum] = "d1410d41304ad601d8475f790a23a05e75f612c6b425df105784f5e3aee34f7d"
