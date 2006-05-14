DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r0"

DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
RRECOMMENDS = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-ico gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=osb-browser;date=${FIXEDSRCDATE} \
           file://no-pedantic.patch;patch=1"
S = "${WORKDIR}/osb-browser"

DEFAULT_PREFERENCE = "${@['-1', '1'][not bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1) or bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1).split('.')[0] == '4']}"

inherit autotools
