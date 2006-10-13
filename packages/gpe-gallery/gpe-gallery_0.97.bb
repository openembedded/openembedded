LICENSE = "GPL"
PR = "r0"

inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

DEPENDS = "libgpewidget"
SECTION = "gpe"

FILES_${PN} += "${datadir}/gpe/pixmaps"
FILES_${PN} += "${datadir}/application-registry"

DESCRIPTION = "GPE image viewer application"
export CVSBUILD = "no"

