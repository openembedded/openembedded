DESCRIPTION = "gsm.07.10 muxer userspace daemon"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=gsm0710muxd"
S = "${WORKDIR}/gsm0710muxd"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gsm0710muxd"
INITSCRIPT_PARAMS = "defaults 35"
