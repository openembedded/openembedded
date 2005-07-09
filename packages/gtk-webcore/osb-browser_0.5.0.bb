LICENSE = "GPL"
DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
SECTION = "gpe"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-browser-${PV}.tar.gz \
           file://no-pedantic.patch;patch=1"

inherit autotools
