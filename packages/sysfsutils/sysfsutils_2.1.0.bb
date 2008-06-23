DESCRIPTION = "System Utilities Based on Sysfs"
HOMEPAGE = "http://linux-diag.sourceforge.net/Sysfsutils.html"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-diag/sysfsutils-${PV}.tar.gz \
	   file://get_mnt_path_check.patch;patch=1"

inherit autotools

do_stage () {
	autotools_stage_all
}

PACKAGES = "libsysfs libsysfs-dbg libsysfs-dev \
	    ${PN} ${PN}-dbg ${PN}-doc ${PN}-locale"

FILES_libsysfs = "${libdir}/*.so.*"
FILES_libsysfs-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
		     ${libdir}/*.a"
FILES_libsysfs-dbg += "${libdir}/.debug"
FILES_${PN}-dbg += "${bindir}/.debug"
