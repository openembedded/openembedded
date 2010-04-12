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

SRC_URI[md5sum] = "539cff747634b8ee6f0d2362ee78a286"
SRC_URI[sha256sum] = "3468a9cb348bf54f8a0afa386366683eff1987b722d2e81326f9e7ec7dfbe093"
