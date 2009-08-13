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
