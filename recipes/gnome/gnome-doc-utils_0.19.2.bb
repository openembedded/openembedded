require gnome-doc-utils.inc

do_configure_append() {
	sed -i 's: doc::g' Makefile.am 
}

DEPENDS += "libxml2-native"

PR = "${INC_PR}.1"
