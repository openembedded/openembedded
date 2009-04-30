DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
RRECOMMENDS = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-ico gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png"
PV = "0.5.0+svnr${SRCPV}"
PR = "r0"

inherit autotools

SRC_URI = "svn://gtk-webcore.svn.sourceforge.net/svnroot/gtk-webcore/trunk;module=osb-browser;proto=https"

S = "${WORKDIR}/osb-browser"

DEFAULT_PREFERENCE = "-1"

