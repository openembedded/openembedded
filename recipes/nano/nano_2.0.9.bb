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

SRC_URI[md5sum] = "2be94dc43fb60fff4626a2401a977220"
SRC_URI[sha256sum] = "6d212385680d29dcda35dda7801da19c80182a8bc6bc6d5cf7533034c853d37f"
