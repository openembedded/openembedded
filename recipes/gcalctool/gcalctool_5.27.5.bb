LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "gtk+"
DESCRIPTION = "gcalctool is a powerful calculator"
PR = "r0"

SRC_URI = "file://makefile-fix.diff;patch=1"

inherit gnome

do_configure_prepend() {
	sed -i 's:-I$(includedir)::g' src/Makefile.am
}

