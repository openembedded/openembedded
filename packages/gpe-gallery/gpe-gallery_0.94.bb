LICENSE = "GPL"
PR = "r1"

inherit gpe

SRC_URI += "file://mcheck.patch;patch=1"
DEPENDS = "libgpewidget"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

FILES_${PN} += "${datadir}/gpe/pixmaps"
FILES_${PN} += "${datadir}/application-registry"

DESCRIPTION = "GPE image viewer application"
export CVSBUILD = no

