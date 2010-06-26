DESCRIPTION = "Matchbox virtual keyboard for X11"
LICENSE = "GPL"
DEPENDS = "libfakekey expat libxft"
RCONFLICTS_${PN} = matchbox-keyboard-inputmethod
SECTION = "x11"
SRCREV = "1910"
PV = "0.0+svnr${SRCPV}"
PR = "r9"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
           file://smallscreen-fontsize.patch \
           file://2-Add-new-modifier--layout--Used-to-cycle-thru-all-available-layouts.patch \
           file://3-Changes-to-improve-layout-rendering--especially-after-adding-support-for.patch \
           file://4-Add-rendering-debug-logging.patch \
           file://5-Add-support-for-loading-multiple-independent-layouts.patch \
           file://6-Add-layout-switch-key-to-all-layouts.patch \
          "


S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-cairo"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps \
	       ${datadir}/matchbox-keyboard"

