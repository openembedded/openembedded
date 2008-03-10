DESCRIPTION = "Diveristy Daemon"
SECTION = "net/misc"
LICENSE = "GPL"
HOMEPAGE = "http://www.openmoko.org/"
DEPENDS = "glib-2.0 dbus dbus-glib eds-dbus gypsy libjana curl"
RDEPENDS = "eds-dbus gypsy openmoko-dialer2"
SRCREV = "${AUTOREV}"
PV = "0.0+svnr${SRCREV}"

PR = "r1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-nm --disable-geoclue --disable-xmpp --enable-session-bus"
SRC_URI = "svn://svn.internal.openmoko.org/trunk/diversity;module=backends;proto=https"

S = "${WORKDIR}/backends"
FILES_${PN} += "${datadir}/dbus-1/"
FILES_${PN} += "${sysconfdir}/dbus-1/"
