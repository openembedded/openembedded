DESCRIPTION = "System Utilities Based on Sysfs"
HOMEPAGE = "http://linux-diag.sourceforge.net/Sysfsutils.html"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-diag/sysfsutils-${PV}.tar.gz \
	   file://get_mnt_path_check.patch;patch=1"

S = "${WORKDIR}/sysfsutils-${PV}"

inherit autotools

includedir += "/sysfs"

do_stage () {
	oe_libinstall -a -so -C lib libsysfs ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/sysfs
	install -m 0644 ${S}/include/dlist.h ${STAGING_INCDIR}/sysfs
	install -m 0644 ${S}/include/libsysfs.h ${STAGING_INCDIR}/sysfs
}

PACKAGES = "libsysfs libsysfs-dbg libsysfs-dev \
	    ${PN} ${PN}-dbg ${PN}-doc ${PN}-locale"

FILES_libsysfs = "${libdir}/*.so.*"
FILES_libsysfs-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
		     ${libdir}/*.a ${libdir}/*.o "
FILES_libsysfs-dbg += "${libdir}/.debug"
FILES_${PN}-dbg += "${bindir}/.debug"

