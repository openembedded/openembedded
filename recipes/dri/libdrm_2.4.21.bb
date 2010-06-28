require libdrm.inc

DEPENDS = "libpthread-stubs"

PR = "${INC_PR}.0"

SRC_URI += "file://glamo.patch"

SRC_URI[md5sum] = "273ed9dad986e3a931649f3d8762ff74"
SRC_URI[sha256sum] = "4e1b612ba3b6b1deae4a8c14946099283e7a00e48a5ab002eaf4312f5a8ba14b"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '', '--disable-intel',d)}"
EXTRA_OECONF_append_shr = " --enable-glamo-experimental-api --disable-radeon --disable-intel"

PACKAGES =+ "${@base_contains('MACHINE_FEATURES', 'x86', '${PN}-intel', '',d)}"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"
