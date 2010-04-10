require qpf.inc

DESCRIPTION = "Lightweight Japanese font in 10 point suitable for 320x240 display"
HOMEPAGE = "http://sourceforge.jp/projects/zaurus-ja/"
LICENSE = "GPL"
RPROVIDES = "virtual-japanese-font"
PR = "r4"

SRC_URI = "http://osdn.dl.sourceforge.jp/zaurus-ja/773/unismall-${PV}.tar.gz"

S = "${WORKDIR}"

SRC_URI[md5sum] = "fb608934ab87ad5203aebb85c2d130c7"
SRC_URI[sha256sum] = "9f60583875713e7d45797f25c321c1bb36f43afbbe3c4ab4fd1f58c157022eb6"
