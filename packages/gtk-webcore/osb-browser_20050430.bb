DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = GPL
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

FIXEDCVSDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDCVSDATE}"
PR = "r1"

DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
RRECOMMENDS = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-ico gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/gtk-webcore;module=osb-browser;date=${FIXEDCVSDATE} \
           file://no-pedantic.patch;patch=1"
S = "${WORKDIR}/osb-browser"

inherit autotools
