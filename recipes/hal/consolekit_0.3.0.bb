DESCRIPTION = "ConsoleKit is a framework for defining and tracking users, login sessions, and seats."
LICENSE = "GPLv2"
DEPENDS = "policykit libpam dbus"

PR = "r1"

inherit gnome

SRC_URI = "http://people.freedesktop.org/~mccann/dist/ConsoleKit-${PV}.tar.bz2"
S = "${WORKDIR}/ConsoleKit-${PV}"

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/ConsoleKit ${datadir}/dbus-1 ${datadir}/PolicyKit"




