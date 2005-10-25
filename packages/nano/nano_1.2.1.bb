DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"

SRC_URI = "http://www.nano-editor.org/dist/v1.2/nano-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://glib.m4"

inherit autotools

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glib.m4 m4/
}
