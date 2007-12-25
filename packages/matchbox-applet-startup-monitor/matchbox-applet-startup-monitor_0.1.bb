DESCRIPTION = "Matchbox Startup monitor applet"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"

PR = "r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/mb-applet-startup-monitor/${PV}/mb-applet-startup-monitor-${PV}.tar.gz \
    file://mb-applet-startup-monitor.desktop"
S = "${WORKDIR}/mb-applet-startup-monitor-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "${bindir}/* ${datadir}/applications ${datadir}/pixmaps"

do_install_append() {
        install -d ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/mb-applet-startup-monitor.desktop ${D}${datadir}/applications/
}
