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

SRC_URI[md5sum] = "16187fed2bdefec6275ece6401ce4cd2"
SRC_URI[sha256sum] = "5dc783c412c4d1ff463c450d2a2f9e1ea53a43d9ba1dda92bbf5182f60db532f"
