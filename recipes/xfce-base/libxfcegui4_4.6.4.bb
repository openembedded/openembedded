# libxfcegui4 OE build file

DESCRIPTION = "Xfce4 Widget library and X Window System interaction"
DEPENDS = "gettext pkgconfig intltool virtual/libx11 libxfce4util xfconf dbh libxml2 gtk+ libglade"
RDEPENDS_${PN} = "xfconf startup-notification "

SECTION = "x11/libs"
PR = "r0"

inherit xfce46

LEAD_SONAME = "libxfcegui4.so.4"

FILES_${PN} += "${libdir}/xfce4/modules ${libdir}/libglade/2.0/*.so ${datadir}/xfce4/mime ${datadir}/icons/hicolor"

SRC_URI[md5sum] = "88de59b222cb9977f93a4c61011c1e1f"
SRC_URI[sha256sum] = "c37e407dc00fb87dc16758d53e69edeac7b32aa76c5fcad2b784cf22f58af421"
