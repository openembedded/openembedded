DESCRIPTION = "A tool to display dialogs from the command line and shell scripts."
LICENSE = "GPL"

DEPENDS = "gtk+ libglade glib-2.0 libnotify"

inherit gnome

do_configure_prepend() {
	sed -i -e '/-I$(includedir)/d' src/Makefile.am
}

