DESCRIPTION = "Hand-writing recognition for Japanese Kanji characters (no kana)"
AUTHOR = "Owen Taylor <otaylor@fishsoup.net>"
HOMEPAGE = "http://fishsoup.net/software/kanjipad/"
SECTION = "inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+"

SRC_URI="http://fishsoup.net/software/kanjipad/kanjipad-2.0.0.tar.gz"

S = ${WORKDIR}/kanjipad-2.0.0/

inherit autotools pkgconfig
