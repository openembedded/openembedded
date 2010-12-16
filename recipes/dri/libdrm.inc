SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"
DEPENDS = "libpthread-stubs cairo"

INC_PR = "r7"
PE = "1"

inherit autotools pkgconfig

PACKAGES =+ "${PN}-drivers ${PN}-kms ${@base_contains('MACHINE_FEATURES', 'x86', '${PN}-intel', '',d)}"
FILES_${PN}-drivers = "${libdir}/libdrm_*.so.*"
FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"
FILES_${PN}-kms = "${libdir}/libkms*.so.*"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '', '--disable-intel --disable-radeon',d)}"
EXTRA_OECONF_append_shr = " --enable-glamo-experimental-api"

LEAD_SONAME = "libdrm.so"
