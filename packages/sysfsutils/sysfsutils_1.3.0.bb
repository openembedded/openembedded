PR = "r1"
SECTION = "base"
DESCRIPTION = "System Utilities Based on Sysfs"
HOMEPAGE = "http://linux-diag.sourceforge.net/Sysfsutils.html"
LICENSE = "GPLv2"
SRC_URI = "${SOURCEFORGE_MIRROR}/linux-diag/sysfsutils-${PV}.tar.gz"

S = "${WORKDIR}/sysfsutils-${PV}"

inherit autotools

includedir += "/sysfs"

PACKAGES_prepend = "libsysfs "
FILES_libsysfs = "${libdir}/*.so.1.0.3"
