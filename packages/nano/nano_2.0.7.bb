DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
SECTION = "console/utils"
DEPENDS = "ncurses"

SRC_URI = "http://www.nano-editor.org/dist/v2.0/nano-${PV}.tar.gz \
           file://glib.m4"

inherit autotools

# only 16K more to get everything but the kitchen sink
EXTRA_OECONF = "--enable-all"

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glib.m4 m4/
}
