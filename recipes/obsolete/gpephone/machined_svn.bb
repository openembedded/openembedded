DESCRIPTION = "Device abstraction and support daemon"
SECTION = "gpephone"
PRIORITY = "required"
LICENSE = "GPL"
DEPENDS = "glib-2.0 dbus-glib gtk+"
PV = "0.1+svnr-${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/;module=${PN}"

S = "${WORKDIR}/${PN}"
