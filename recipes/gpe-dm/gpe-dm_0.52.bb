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

SRC_URI[md5sum] = "ea157a2b47d932cea9738882df887ae1"
SRC_URI[sha256sum] = "b2ef45fbe57bdc73a6a5fb244da782fc912c105453bf120128c93284fc05c4ce"
