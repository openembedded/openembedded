DESCRIPTION = "Support for the Linux 2.6.x ALSA Sound System"
SECTION = "devel/python"
DEPENDS = "alsa-lib"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pyalsa"
PR = "ml1"

SRC_URI = "ftp://ftp.alsa-project.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "a1f4d561fa5c41a570480f3f328559a2"
SRC_URI[sha256sum] = "f2c9195284d3c3925d83424a9e24ac8ce96e706abced5d3007df57f9fe51518f"
