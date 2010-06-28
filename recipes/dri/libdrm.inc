SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"

INC_PR = "r5"
PE = "1"

inherit autotools pkgconfig

PACKAGES =+ "${PN}-drivers ${PN}-kms"
FILES_${PN}-drivers = "${libdir}/libdrm_*.so.*"
FILES_${PN}-kms = "${libdir}/libkms*.so.*"

LEAD_SONAME = "libdrm.so"
