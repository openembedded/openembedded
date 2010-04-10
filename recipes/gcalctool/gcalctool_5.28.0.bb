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


SRC_URI[archive.md5sum] = "03d8f034ee844888e7ec9ad317096028"
SRC_URI[archive.sha256sum] = "4271a17bbca56d7b335f18c1ebf350b931565d90e92925b9e5c0585b416f3765"
