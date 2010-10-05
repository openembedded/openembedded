require libdrm.inc

DEPENDS = "libpthread-stubs"

PR = "${INC_PR}.0"

SRC_URI += "file://glamo.patch"

SRC_URI[md5sum] = "3bdfa33f35d1c902e5115cceb5500c83"
SRC_URI[sha256sum] = "0bb0e594e4094d9000d80f38e96e8f640b6364f96cfef5b970cf4481443c6b3d"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '', '--disable-intel',d)}"
EXTRA_OECONF_append_shr = " --enable-glamo-experimental-api --disable-radeon --disable-intel"

EXTRA_OECONF_append_angstrom = " --disable-radeon "

PACKAGES =+ "${@base_contains('MACHINE_FEATURES', 'x86', '${PN}-intel', '',d)}"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"
