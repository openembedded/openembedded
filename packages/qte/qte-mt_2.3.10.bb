require qte-common_${PV}.inc
PR = "r15"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
