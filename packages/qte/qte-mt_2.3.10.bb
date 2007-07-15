require qte-common_${PV}.inc
PR = "r18"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
