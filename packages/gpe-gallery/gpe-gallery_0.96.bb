LICENSE = "GPL"
PR = "r0"

inherit gpe

DEPENDS = "libgpewidget"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

FILES_${PN} += "${datadir}/gpe/pixmaps"
FILES_${PN} += "${datadir}/application-registry"

DESCRIPTION = "GPE image viewer application"
export CVSBUILD = "no"

