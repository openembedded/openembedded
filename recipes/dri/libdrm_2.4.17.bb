require libdrm.inc

PR = "${INC_PR}.0"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '', '--disable-intel',d)}"

PACKAGES =+ "${@base_contains('MACHINE_FEATURES', 'x86', '${PN}-intel', '',d)}"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"

SRC_URI[md5sum] = "667d81f993f7fd8a1b1b1b830a28a748"
SRC_URI[sha256sum] = "b8a4e7c610b0e970546d791c06e28882857a49d34698633a89292d7ae142316a"
