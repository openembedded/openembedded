LICENSE = "GPL"
DESCRIPTION = "Gtk+ WebCore - reference browser"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
DEPENDS = "osb-nrcit gtk+ glib-2.0 libglade"
SECTION = "gpe"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-browser-${PV}.tar.gz \
           file://no-pedantic.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "4dad43f6e1291dfefaec6e9209928a0d"
SRC_URI[sha256sum] = "78bed1f7a227c7844f4f1c3fd4eaa8c1c15f3ba6133ab1186f5b35371344de96"
