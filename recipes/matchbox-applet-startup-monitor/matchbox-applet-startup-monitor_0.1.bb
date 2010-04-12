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

SRC_URI[md5sum] = "6d06e7542c3e927adee7e67f3c734858"
SRC_URI[sha256sum] = "be52ed8fc2fdd0747e4aea25650de398efa284f7712838f5c90494b694c3719a"
