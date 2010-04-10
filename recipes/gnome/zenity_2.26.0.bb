DESCRIPTION = "A tool to display dialogs from the command line and shell scripts."
LICENSE = "GPL"

DEPENDS = "gtk+ libglade glib-2.0 libnotify"

inherit gnome

do_configure_prepend() {
	sed -i -e '/-I$(includedir)/d' src/Makefile.am
}


SRC_URI[archive.md5sum] = "6660ce6dac0a6ca495a0e954cb6b40a2"
SRC_URI[archive.sha256sum] = "fc619215ca90cab48efae7bdf524d1de690b75832f07f3cbcb6d5c3910d402a1"
