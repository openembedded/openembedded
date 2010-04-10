DESCRIPTION = "Freeciv is a free turn-based multiplayer strategy game, in which each player becomes the leader of a civilization, fighting to obtain the ultimate goal: To become the greatest civilization."
SECTION = "x11/games"
LICENSE = "GPL"
DEPENDS = "gtk+ cairo esound zlib readline"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig






SRC_URI[md5sum] = "7d597d59236cc0cc1cfaa0cbbda24bd4"
SRC_URI[sha256sum] = "784b6eb132d37c51f7d9cd50a92138f4520146715f64b8fd64c410b5997f77de"
