DESCRIPTION = "ddccontrol - softwarewise change monitor settings"
LICENSE = "GPLv2"
HOMEPAGE = "http://sourceforge.net/projects/ddccontrol/"

PR = "r0"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/ddccontrol/ddccontrol-db-${PV}.tar.bz2"


SRC_URI[md5sum] = "91951918e5bc553c251776cdff8cea9c"
SRC_URI[sha256sum] = "ff88f8e5122a2ab7b69a961f267f74d09ec7c54e90453ee80930edf66955c7b8"
