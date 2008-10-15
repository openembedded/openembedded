DESCRIPTION = "gpe-snes is a gpe frontend for the snes9x SNES emulator"
SECTION = "games"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "gtk+ libgpewidget libxrandr"

inherit autotools

PR = "r0"

SRC_URI = "http://www.telefonica.net/web2/mteirap/gpe-snes-${PV}.tar.gz"
