DESCRIPTION = "Kanji Kana Simple Inverter"
HOMEPAGE = "http://kakasi.namazu.org/"
LICENSE = "GPL"

SRC_URI = "http://kakasi.namazu.org/stable/kakasi-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-shared"
