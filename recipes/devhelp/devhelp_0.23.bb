DESCRIPTION = "API documentation browser for GTK+ and GNOME"
HOMEPAGE = "http://live.gnome.org/devhelp"
DEPENDS = "gconf glib-2.0 gtk+ libwnck webkit-gtk zlib"
PR = "r0"

inherit gnome

SRC_URI += "file://devhelp-includes.patch;patch=1 \
	    file://devhelp-webkit.patch;patch=1"

PACKAGES += "gedit-plugin-${PN}"
FILES_gedit-plugin-${PN} += "${libdir}/gedit-2"

do_stage() {
	autotools_stage_all
}
