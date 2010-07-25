require cornucopia.inc
inherit fso-plugin

SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.1.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

EXTRA_OECONF = ""
EXTRA_OECONF_append_palmpre = "--with-machine=palmpre"
EXTRA_OECONF_append_om-gta02 = "--with-machine=om-gta02"

PACKAGE_ARCH = "${MACHINE_ARCH}"

