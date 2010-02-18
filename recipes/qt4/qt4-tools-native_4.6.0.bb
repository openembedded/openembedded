DEFAULT_PREFERENCE = "-1"

require qt4-tools-native.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.0"

EXTRA_OECONF += " -fast"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"
