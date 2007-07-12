require qte-common_${PV}.inc
PR = "r17"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
