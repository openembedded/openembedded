DESCRIPTION = "Matchbox virtual keyboard for X11"
LICENSE = "GPL"
DEPENDS = "libfakekey expat libxft"
RCONFLICTS = matchbox-keyboard-inputmethod
RPROVIDES_${PN} = matchbox-keyboard-inputmethod
SECTION = "x11"
SRCREV = "1910"
PV = "0.0+svnr${SRCPV}"
PR ="r7"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
           file://smallscreen-fontsize.patch;apply=yes \
           file://2-Add-new-modifier--layout--Used-to-cycle-thru-all-available-layouts.patch;apply=yes \
           file://3-Changes-to-improve-layout-rendering--especially-after-adding-support-for.patch;apply=yes \
           file://4-Add-rendering-debug-logging.patch;apply=yes \
           file://5-Add-support-for-loading-multiple-independent-layouts.patch;apply=yes \
           file://6-Add-layout-switch-key-to-all-layouts.patch;apply=yes \
          "


S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-cairo"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps \
	       ${datadir}/matchbox-keyboard"

