SECTION = "x11/wm"
DESCRIPTION = "Metacity is the boring window manager for the adult in you."
LICENSE = "GPL"
DEPENDS = "libwnck startup-notification gtk+ gconf gdk-pixbuf-csource-native"

PR = "r1"

inherit gnome update-alternatives

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/metacity"
ALTERNATIVE_PRIORITY = "30"

EXTRA_OECONF += "--disable-verbose \
	         --disable-xinerama"

FILES_${PN} += "${datadir}/themes ${datadir}/gnome*"

do_stage () {
	 autotools_stage_all
}

SRC_URI[archive.md5sum] = "d4aa782d5f71b6c42514b239684a4aa3"
SRC_URI[archive.sha256sum] = "90eed0a36aae302db52af12220c4cf863c9cccebd233015104f2d88cb17ec076"
