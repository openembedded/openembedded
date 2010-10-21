DESCRIPTION = "Tool to work with series of patches."
HOMEPAGE = "http://savannah.nongnu.org/projects/quilt/"
SECTION = "devel"
LICENSE = "GPLv2+"
INC_PR = "r7"

SRC_URI = "http://download.savannah.gnu.org/releases/quilt/quilt-${PV}.tar.gz \
           file://install.patch \
	   file://no_rm_symlinks.patch \
	   file://use-cp-for-patch-backup.patch \
	   "

S = "${WORKDIR}/quilt-${PV}"
