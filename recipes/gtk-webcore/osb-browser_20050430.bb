DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r2"

DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
RRECOMMENDS_${PN} = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-ico gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=osb-browser;date=${FIXEDSRCDATE} \
           file://no-pedantic.patch"
S = "${WORKDIR}/osb-browser"

inherit autotools
