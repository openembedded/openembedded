DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
SECTION = "console/utils"
DEPENDS = "ncurses"

SRC_URI = "http://www.nano-editor.org/dist/v1.3/nano-${PV}.tar.gz \
           file://glib.m4"

inherit autotools

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glib.m4 m4/
}
