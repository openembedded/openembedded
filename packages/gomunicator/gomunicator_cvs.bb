DESCRIPTION = "Gomunicator is a GSM Voice and SMS application for GPE"
HOMEPAGE = "http://projects.linuxtogo.org/projects/gomunicator"
LICENSE = "GPLv2"
AUTHOR = "Robert Woerle"
SECTION = "gpe"
DEPENDS = "libgpewidget gtk+ glib-2.0 alsa-lib dbus-glib"
PV = "0.1.3+cvs${SRCDATE}"
PR = "r1"

inherit autotools pkgconfig

SRC_URI = "cvs://anonymous@projects.linuxtogo.org/cvsroot/gomunicator;module=gomunicator"
S = "${WORKDIR}/${PN}"

do_install_append() {
	install -d ${D}${datadir}/applications
}
