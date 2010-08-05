DESCRIPTION = "Runtime support for GTK interface builder"
HOMEPAGE = "http://glade.gnome.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "gtk+ gtk-doc"

inherit autotools pkgconfig

PACKAGES += " ${PN}-data"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-data = "${datadir}/xml/libglade/glade-2.0.dtd"
FILES_${PN}-dev += "${bindir}/libglade-convert"
#RDEPENDS_${PN} = "${PN}-data"
