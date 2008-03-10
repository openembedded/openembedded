DESCRIPTION = "Diveristy Daemon"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "net/misc"
LICENSE = "GPL"
DEPENDS = "glib-2.0 dbus dbus-glib eds-dbus gypsy libjana curl"
RDEPENDS = "eds-dbus gypsy openmoko-dialer2"
PV = "0.0+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/diversity/trunk;module=diversity-daemon;proto=https"

S = "${WORKDIR}/diversity-daemon"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-nm --disable-geoclue --disable-xmpp --enable-session-bus"

FILES_${PN} += "${datadir}/dbus-1/"
FILES_${PN} += "${sysconfdir}/dbus-1/"
