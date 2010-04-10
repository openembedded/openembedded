DESCRIPTION = "A tool to display dialogs from the command line and shell scripts."
LICENSE = "GPL"

DEPENDS = "gtk+ libglade glib-2.0 libnotify"

inherit gnome

do_configure_prepend() {
	sed -i -e '/-I$(includedir)/d' src/Makefile.am
}


SRC_URI[archive.md5sum] = "262c476aebbf67a7043cd80c6a03add3"
SRC_URI[archive.sha256sum] = "3747a23ce46b0ee68e6261d669ae461f0f460d9c6ad19e04acbd518ddfcc8c63"
