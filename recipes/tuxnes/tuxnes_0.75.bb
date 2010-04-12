DESCRIPTION = "Tuxnes Nintendo (8bit) Emulator"
HOMEPAGE = "http://prdownloads.sourceforge.net/tuxnes/tuxnes-0.75.tar.gz"
LICENSE = "GPLv2"
SECTION = "x/games"
PRIORITY = "optional"
PR ="r1"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/tuxnes/tuxnes-0.75.tar.gz"

inherit autotools


SRC_URI[md5sum] = "5db0cd42dfdff3e681805e93b4867c43"
SRC_URI[sha256sum] = "217fc57fdd2a5ec360c197ea36110ec929d3f27c88cf875f0f4723b3496ed7c2"
