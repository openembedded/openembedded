PR = "r1"

include app-common.inc
DEPENDS = "libx11 libxt libxmu"

inherit update-alternatives

ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"



