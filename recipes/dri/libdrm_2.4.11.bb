SECTION = "x11/base"
DEPENDS = "libpthread-stubs"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"
PR = "r1"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "${PN}-intel"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"

SRC_URI[md5sum] = "e0e66fae165d0b665b61e9516bf33ade"
SRC_URI[sha256sum] = "5e07ec4b644f50160900d4281a74dd1cbf1535cfe4ab24e0c28ae5b038836a8c"
