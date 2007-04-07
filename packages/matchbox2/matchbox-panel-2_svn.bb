DESCRIPTION = "matchbox-panel-2 is a lightweight dock (system tray) application based on Gtk+"
LICENSE = "GPL"
SECTION = "x11/panels"
DEPENDS = "gtk+"

PV = "0.1+svn${SRCDATE}"
PR = "r6"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-startup-notification --disable-libnotify"

# matchbox-<anything>-2 aims to replace their -1 counterpart, but at this point in time it's unfinished and unusable,  so make it parallel installable
do_install_append() {
    mv ${D}${bindir}/matchbox-panel ${D}${bindir}/matchbox-panel-2
}

do_stage() {
    autotools_stage_all
}

PACKAGES += "${PN}-applets"
FILES_${PN}-applets = "${libdir}/matchbox-panel/lib*.so* ${datadir}/*"

