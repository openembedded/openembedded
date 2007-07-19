require qte-common_${PV}.inc
PR = "r23"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
