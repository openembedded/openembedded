DESCRIPTION = "Tool to work with series of patches."
HOMEPAGE = "http://savannah.nongnu.org/projects/quilt/"
SECTION = "devel"
LICENSE = "GPL"
INC_PR = "r6"

SRC_URI = "http://download.savannah.gnu.org/releases/quilt/quilt-${PV}.tar.gz \
           file://install.patch \
	   file://no_rm_symlinks.patch \
	   "

S = "${WORKDIR}/quilt-${PV}"
