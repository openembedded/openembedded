DESCRIPTION = "CHMLIB is a library for dealing with Microsoft ITSS/CHM format files."
LICENSE = "GPLv2"
HOMEPAGE = "http://66.93.236.84/~jedwin/projects/chmlib/"

SRC_URI = "${DEBIAN_MIRROR}/main/c/chmlib/chmlib_0.380.orig.tar.gz \
	   file://arm-guess.patch;patch=1"

S = "${WORKDIR}/chmlib-0.380"

inherit autotools pkgconfig
