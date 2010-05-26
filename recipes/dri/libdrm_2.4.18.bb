require libdrm.inc

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "d2b5fbfd37742af7d2169f7d26ce3007"
SRC_URI[sha256sum] = "f6c5b44fff5cb602096cc48a1bced426496bc8060463c577a7d86f2e56eeb604"


EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '', '--disable-intel',d)}"

PACKAGES =+ "${@base_contains('MACHINE_FEATURES', 'x86', '${PN}-intel', '',d)}"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"
