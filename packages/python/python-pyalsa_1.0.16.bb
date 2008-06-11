DESCRIPTION = "Support for the Linux 2.6.x ALSA Sound System"
SECTION = "devel/python"
DEPENDS = "alsa-lib"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pyalsa"
PR = "ml0"

SRC_URI = "ftp://ftp.alsa-project.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
