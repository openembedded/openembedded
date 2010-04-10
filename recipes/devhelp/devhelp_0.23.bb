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

SRC_URI[archive.md5sum] = "704c0c90616aeb1c52ca3af1df93fde6"
SRC_URI[archive.sha256sum] = "60f336ac396f67a0cce70d71ea931545727ab48e9d09bf36415098965f9a7ef2"
