DESCRIPTION = "Backend library for the free nx-clients"
HOMEPAGE = "http://freenx.berlios.de/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r2"

RDEPENDS = "nxproxy nxssh"

SRC_URI = "http://download.berlios.de/freenx/freenx-client-${PV}.tar.bz2 \
	   file://gcc4.3-ftbfs.patch;apply=yes \
	   file://dodnx.patch;apply=yes \
	   file://gcc-warnings.patch;apply=yes \
	   file://restorekeyboard.patch;apply=yes \
	   file://publicKey.patch;apply=yes \
	   file://deletelogfiles.patch;apply=yes \
	   file://ssh_dnserror.patch;apply=yes \
	  "

S = "${WORKDIR}/freenx-client-${PV}/nxcl"

EXTRA_OECONF += "--without-nxcmd \
	         --without-doxygen \
                "

inherit lib_package autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "777b3cda7a245e3870d4870a9460cb73"
SRC_URI[sha256sum] = "dfc6c8dd89c26171411d8f7fa92613004eb8947ff509459151fdb03de7fe9608"
