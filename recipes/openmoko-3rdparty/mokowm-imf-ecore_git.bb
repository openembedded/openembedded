DESCRIPTION = "Ecore input method for the Mokosuite window manager"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "ecore eina"
SECTION = "misc/utils"

PV = "1.0.99+gitr${SRCPV}"
SRCREV = "7ce10c69038c664a08fa345270865ddcd7445cf1"

SRC_URI = "git://gitorious.org/mokosuite2/mokowm-imf-ecore.git;protocol=git"
S = "${WORKDIR}/git"

FILES_${PN}-dbg += "${libdir}/ecore/immodules/.debug"
FILES_${PN} += "${libdir}/ecore/immodules"

inherit autotools
