DESCRIPTION = "Matchbox Startup monitor applet"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"

PR = "r5"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/mb-applet-startup-monitor/${PV}/mb-applet-startup-monitor-${PV}.tar.gz \
    file://85mb-applet-startup-monitor"
S = "${WORKDIR}/mb-applet-startup-monitor-${PV}"

inherit autotools pkgconfig

do_install_append() {
        install -d ${D}${sysconfdir}/X11/Xsession.d
        install -m 0755 ${WORKDIR}/85mb-applet-startup-monitor ${D}${sysconfdir}/X11/Xsession.d/
}
