SRCREV = "e1910c6289f754dcbf863d309ed8b72452a5de74"
_pv = "0.32"
PR = "r0"

inherit gitpkgv

PV = "${_pv}+gitr${SRCPV}"
PKGV = "${_pv}+gitr${GITPKGV}"

SRC_URI = " \
        git://github.com/ensc/dietlibc.git;protocol=git;branch=master \
        file://ccache.patch \
        file://runtests-X.sh \
"
S = "${WORKDIR}/git"
