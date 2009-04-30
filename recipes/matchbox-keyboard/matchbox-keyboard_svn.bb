DESCRIPTION = "Matchbox virtual keyboard for X11"
LICENSE = "GPL"
DEPENDS = "libfakekey expat libxft"
RCONFLICTS = matchbox-keyboard-inputmethod
RPROVIDES_${PN} = matchbox-keyboard-inputmethod
SECTION = "x11"
PV = "0.0+svnr${SRCPV}"
PR ="r7"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
           file://smallscreen-fontsize.patch;patch=1 \
           file://2-Add-new-modifier--layout--Used-to-cycle-thru-all-available-layouts.patch;patch=1 \
           file://3-Changes-to-improve-layout-rendering--especially-after-adding-support-for.patch;patch=1 \
           file://4-Add-rendering-debug-logging.patch;patch=1 \
           file://5-Add-support-for-loading-multiple-independent-layouts.patch;patch=1 \
           file://6-Add-layout-switch-key-to-all-layouts.patch;patch=1 \
          "


S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-cairo"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps \
	       ${datadir}/matchbox-keyboard"

