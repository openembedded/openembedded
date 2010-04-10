DESCRIPTION = "CHMLIB is a library for dealing with Microsoft ITSS/CHM format files."
LICENSE = "GPLv2"
HOMEPAGE = "http://66.93.236.84/~jedwin/projects/chmlib/"

SRC_URI = "${DEBIAN_MIRROR}/main/c/chmlib/chmlib_0.380.orig.tar.gz \
	   file://arm-guess.patch;patch=1"

S = "${WORKDIR}/chmlib-0.380"

inherit autotools pkgconfig

SRC_URI[md5sum] = "2282c228ab3776c828e79b7b51f2ccc1"
SRC_URI[sha256sum] = "36645bb9e89ba63c303591a4c365f1819a1dd435d46f227140640f4089bfe6f0"
