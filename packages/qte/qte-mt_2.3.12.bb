require qte-common_${PV}.inc
PR = "r2"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += "-thread"

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
