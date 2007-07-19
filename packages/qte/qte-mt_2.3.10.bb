require qte-common_${PV}.inc
PR = "r22"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
