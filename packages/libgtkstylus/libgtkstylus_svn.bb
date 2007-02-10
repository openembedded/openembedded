DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "gtk+"
PV = "0.3+svn${SRCDATE}"
PR = "r5"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install_append() {
       install -d ${D}/${sysconfdir}/X11/Xsession.d
       install -m 755 ${S}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xsession.d/45gtkstylus
}

FILES_${PN} = "/etc ${libdir}/gtk-2.0/*/modules/*.so*"

DEFAULT_PREFERENCE = "-1"
