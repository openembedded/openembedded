DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
SECTION = "console/utils"
DEPENDS = "ncurses"

SRC_URI = "http://www.nano-editor.org/dist/v2.2/nano-${PV}.tar.gz"
SRC_URI[md5sum] = "6304308afb1f7ef4a5e93eb99206632a"
SRC_URI[sha256sum] = "971b8547be157de5a814cb26c804dc2515b686d7188f4dc016269312965d4da5"

inherit autotools

EXTRA_OECONF = "--enable-all"
