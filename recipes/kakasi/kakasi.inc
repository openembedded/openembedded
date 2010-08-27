DESCRIPTION = "Kanji Kana Simple Inverter"
SECTION = "utils"
HOMEPAGE = "http://kakasi.namazu.org/"
LICENSE = "GPL"

INC_PR = "r0"

# the lines below are a little bit yucky but I found no better way to do this
SRC_URI = "http://kakasi.namazu.org/stable/kakasi-${PV}.tar.gz"
SRC_URI += "file://makefile.patch"
SRC_URI_virtclass-native = "http://kakasi.namazu.org/stable/kakasi-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-shared"
