DESCRIPTION = "Backend library for the free nx-clients"
HOMEPAGE = "http://freenx.berlios.de/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r2"

RDEPENDS = "nxproxy nxssh"

SRC_URI = "http://download.berlios.de/freenx/freenx-client-${PV}.tar.bz2 \
	   file://gcc4.3-ftbfs.patch;patch=1 \
	   file://dodnx.patch;patch=1 \
	   file://gcc-warnings.patch;patch=1 \
	   file://restorekeyboard.patch;patch=1 \
	   file://publicKey.patch;patch=1 \
	   file://deletelogfiles.patch;patch=1 \
	   file://ssh_dnserror.patch;patch=1 \
	  "

S = "${WORKDIR}/freenx-client-${PV}/nxcl"

EXTRA_OECONF += "--without-nxcmd \
	         --without-doxygen \
                "

inherit lib_package autotools pkgconfig

do_stage () {
	autotools_stage_all
}
