DESCRIPTION = "Ecore input method for the Mokosuite window manager"
HOMEPAGE = "http://wiki.openmoko.org/"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "ecore eina"
SECTION = "misc/utils"

PV = "1.0+svnr${SRCPV}"
SRCREV = "457"

SRC_URI = "svn://svn.casaricci.it/openmoko/trunk;module=mokowm-imf-ecore;proto=svn"
S = "${WORKDIR}/mokowm-imf-ecore"

FILES_${PN}-dbg += "${libdir}/ecore/immodules/.debug"
FILES_${PN} += "${libdir}/ecore/immodules"

inherit autotools
