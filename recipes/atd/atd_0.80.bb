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

SRC_URI[md5sum] = "b64a8ae8592b4d32ac9baebf0b915c1e"
SRC_URI[sha256sum] = "456d2bf4550a37c70e829b3029acf3cb81f931908d35f1dbade7ec54f4cdb146"
