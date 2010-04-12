SECTION = "console/network"
DESCRIPTION = "Supybot is a clearly-written Python IRC \
framework and bot, intended to be both easily \
extensible and very flexible."
LICENSE = "BSD"
SRC_URI = "${SOURCEFORGE_MIRROR}/supybot/Supybot-${PV}.tar.bz2"
S = "${WORKDIR}/Supybot-${PV}"

inherit distutils

SRC_URI[md5sum] = "6d53a2a9901549d52fecfafb0012134b"
SRC_URI[sha256sum] = "6fd69febfd804437a9d5b610502c6d3c2caabef7a4832a3bcac2357515adaa71"
