# libxfcegui4 OE build file

DESCRIPTION = "Xfce Widget library and X Window System interaction"
DEPENDS = "gettext pkgconfig intltool virtual/libx11 libxfce4util xfconf dbh libxml2 gtk+ libglade"
RDEPENDS = "xfconf startup-notification "

SECTION = "x11/libs"
PR = "r4"

inherit xfce46

do_stage() {
   autotools_stage_all
}

LEAD_SONAME = "libxfcegui4.so.4"

FILES_${PN} += "${libdir}/xfce4/modules ${libdir}/libglade/2.0/*.so ${datadir}/xfce4/mime ${datadir}/icons/hicolor"
