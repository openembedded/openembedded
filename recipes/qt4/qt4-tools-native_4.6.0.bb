DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.0"

EXTRA_OECONF += " -fast"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "2a7b5126f2450d8525af355fc4c12ad6"
SRC_URI[sha256sum] = "55259c813324f6383cbd441aa2f23e01c320b6d63fbe3b5d52a7715055d28589"
