LICENSE = "LGPL"
SECTION = "x11"
DEPENDS = "glib-2.0 gtk+ libglade eds-dbus"
MAINTAINER = "Richard Purdie <richard@openedhand.com>"
DESCRIPTION = "Dates is a calendar application."

PR = "r3"

PV = "0.0+svn${SRCDATE}"
S = "${WORKDIR}/${PN}"

SRC_URI = "svn://svn.o-hand.com/repos/;module=${PN};proto=http"

inherit autotools pkgconfig

CFLAGS_prepend = " -DFRAMES=5 "
FILES_${PN} += "${datadir}/icons/hicolor/48x48/apps/oh-dates.png"

pkg_postinst_${PN} () {
	if [ "x$D" != "x" ]; then 
		gtk-update-icon-cache /usr/share/icons/hicolor
	fi
}
