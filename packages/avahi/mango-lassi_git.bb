ESCRIPTION = "Input sharing, the avahi way"
DEPENDS = "avahi-ui libglade libnotify"

SRCREV = "73638817126a68d62f1233f6e6859ce75a259e93"
PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.0pointer.de/repos/mango-lassi.git/;protocol=http"

S = "${WORKDIR}/git"

inherit autotools

