require qte-common_${PV}.inc
PR = "r20"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
