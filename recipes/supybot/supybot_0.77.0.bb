SECTION = "console/network"
DESCRIPTION = "Supybot is a clearly-written Python IRC \
framework and bot, intended to be both easily \
extensible and very flexible."
LICENSE = "BSD"
SRC_URI = "${SOURCEFORGE_MIRROR}/supybot/Supybot-${PV}.tar.bz2"
S = "${WORKDIR}/Supybot-${PV}"

inherit distutils
