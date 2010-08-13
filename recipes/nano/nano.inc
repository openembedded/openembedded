DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
SECTION = "console/utils"
DEPENDS = "ncurses"
# actually RDEPENDS, but ncurses-terminfo is only in ncurses-5.7, so RRECOMMENDS for now
RRECOMMENDS_${PN} = "ncurses-terminfo"

INC_PR = "r1"

PV_MAJOR = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "http://www.nano-editor.org/dist/v${PV_MAJOR}/nano-${PV}.tar.gz"

inherit autotools gettext

EXTRA_OECONF = "--enable-all"
