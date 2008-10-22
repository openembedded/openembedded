DESCRIPTION = "Backend library for the free nx-clients"
HOMEPAGE = "http://freenx.berlios.de/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r0"

RDEPENDS = "nxproxy ssh"

SRC_URI = "http://download.berlios.de/freenx/freenx-client-${PV}.tar.bz2 \
	   file://gcc4.3-ftbfs.patch;patch=1 \
	  "

S = "${WORKDIR}/freenx-client-${PV}/nxcl"

EXTRA_OECONF += "--without-nxcmd \
	         --without-doxygen \
                "

inherit lib_package autotools pkgconfig

do_stage () {
	autotools_stage_all
}
