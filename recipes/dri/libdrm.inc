SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"

INC_PR = "r4"

inherit autotools pkgconfig

PACKAGES =+ "${PN}-drivers"
FILES_${PN}-drivers = "${libdir}/libdrm_*.so.*"

LEAD_SONAME_${PN} = "libdrm.so"
