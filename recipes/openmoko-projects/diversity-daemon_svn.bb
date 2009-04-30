DESCRIPTION = "Diversity Daemon"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "network/misc"
LICENSE = "GPL"
DEPENDS = "glib-2.0 dbus dbus-glib eds-dbus libjana curl"
RDEPENDS_${PN} = "eds-dbus"
PV = "0.0+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/diversity/trunk;module=diversity-daemon;proto=https \
           file://no-xmmp.patch;patch=1;minrev=276"
S = "${WORKDIR}/diversity-daemon"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-nm --disable-xmpp --enable-session-bus"

FILES_${PN} += "${datadir}/dbus-1/"
FILES_${PN} += "${sysconfdir}/dbus-1/"
