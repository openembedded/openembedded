DESCRIPTION = "Minisip is a SIP User Agent"
SECTION = "opie/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libmikey libopie1"

SRC_URI = "http://minisip.org/source/minisip-0.1a.tar.gz"
S = "${WORKDIR}/minisip-0.1"

inherit autotools

EXTRA_OECONF = "--enable-qte --enable-opie"

