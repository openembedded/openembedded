DESCRIPTION = "GPE Display Manager"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xserver-common"
RDEPENDS_${PN} += "procps xserver-common"
PV = "gpe-dm-0.50+svn-${SRCDATE}"

inherit gpe autotools update-rc.d

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

DEFAULT_PREFERENCE = "-1"
