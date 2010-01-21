DESCRIPTION = "System Utilities Based on Sysfs"
HOMEPAGE = "http://linux-diag.sourceforge.net/Sysfsutils.html"
LICENSE = "GPLv2"
INC_PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-diag/sysfsutils-${PV}.tar.gz"

inherit autotools autotools_stage

acpaths = "-I ${S}/m4"

PACKAGES = "libsysfs libsysfs-dbg libsysfs-dev \
	    ${PN} ${PN}-dbg ${PN}-doc ${PN}-locale"

FILES_libsysfs = "${libdir}/*.so.*"
FILES_libsysfs-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
		     ${libdir}/*.a"
FILES_libsysfs-dbg += "${libdir}/.debug"
