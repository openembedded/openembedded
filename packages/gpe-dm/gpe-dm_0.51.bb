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
