DESCRIPTION = "GPE Display Manager"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xserver-common"
RDEPENDS_${PN} += "procps xserver-common"

GPE_TARBALL_SUFFIX ?= "bz2"

inherit gpe autotools update-rc.d

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

SRC_URI[md5sum] = "f7b53abf39bd3fa48cd3e0378bd47534"
SRC_URI[sha256sum] = "bc656eb1846509539bbfaf9269f07588f6f3c05c847b41b351a7571a252f6fee"
