DESCRIPTION = "Support for the Linux 2.6.x ALSA Sound System"
SECTION = "devel/python"
DEPENDS = "alsa-lib"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pyalsaaudio"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyalsaaudio/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
