DESCRIPTION = "Freeciv is a free turn-based multiplayer strategy game, in which each player becomes the leader of a civilization, fighting to obtain the ultimate goal: To become the greatest civilization."
LICENSE = "GPL"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEPENDS = "gtk+ cairo esound zlib readline"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig





