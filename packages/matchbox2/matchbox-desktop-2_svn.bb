DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
SECTION = "x11/panels"
DEPENDS = "gtk+ startup-notification"

PV = "0.1+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-startup-notification --disable-libnotify"

PARALLEL_MAKE = ""

# matchbox-<anything>-2 aims to replace their -1 counterpart, but at this point in time it's unfinished and unusable,  so make it parallel installable
do_install_append() {
    mv ${D}${bindir}/matchbox-desktop ${D}${bindir}/matchbox-desktop-2
}

do_stage() {
    autotools_stage_all
}


