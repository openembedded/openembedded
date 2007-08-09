require qte-common_${PV}.inc
PR = "r24"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
