require qpf.inc

DESCRIPTION = "Lightweight Japanese font in 10 point suitable for 320x240 display"
HOMEPAGE = "http://sourceforge.jp/projects/zaurus-ja/"
LICENSE = "GPL"
RPROVIDES = "virtual/japanese-font"
PR = "r4"

SRC_URI = "http://osdn.dl.sourceforge.jp/zaurus-ja/773/unismall-${PV}.tar.gz"

S = "${WORKDIR}"
