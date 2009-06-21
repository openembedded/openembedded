DESCRIPTION = "Lightweight At Daemon"
SECTION = "base"
LICENSE = "GPLv2"
RCONFLICTS = "at"
RREPLACES = "at"

PR = "r1"

SRC_URI = "http://projects.linuxtogo.org/frs/download.php/222/${P}.tar.gz"

inherit autotools update-rc.d

INITSCRIPT_NAME = "atd"
INITSCRIPT_PARAMS = "defaults 97"
