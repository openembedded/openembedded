DESCRIPTION = "Python IRC (Internet Relay Chat) Support Library"
SECTION = "devel/python"
HOMEPAGE = "http://python-irclib.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/python-irclib/python-irclib-${PV}.tar.gz"

inherit distutils


SRC_URI[md5sum] = "7e4fc4b5382c6b54ede8b6e29270cba8"
SRC_URI[sha256sum] = "f1f472a698966b0350857b20fc7f6dd86e4a1f83870edfbe30eb36552b449680"
