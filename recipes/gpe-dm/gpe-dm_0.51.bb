DESCRIPTION = "GPE Display Manager"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xserver-common"
RDEPENDS_${PN} += " xserver-common"

GPE_TARBALL_SUFFIX ?= "bz2"

inherit gpe autotools update-rc.d

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

SRC_URI[md5sum] = "8064121d3b13ea34c5fb77d2907c78f1"
SRC_URI[sha256sum] = "4f7546bc5f8df7eb9511b919e34eb08945db4359fd3db07c555b83959923a1cf"
