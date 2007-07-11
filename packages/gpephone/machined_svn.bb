DESCRIPTION = "Device abstraction and support daemon"
SECTION = "gpephone"
PRIORITY = "required"
LICENSE = "GPL"
DEPENDS = "glib-2.0"
PV = "0.1+svn-${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/;module=${PN}"

S = "${WORKDIR}/${PN}"

#FILES_${PN} += " ${libdir}/gtk-2.0/*/immodules/ptim/helper/*.so ${libdir}/gtk-2.0/*/immodules/ptim/pixmaps"

