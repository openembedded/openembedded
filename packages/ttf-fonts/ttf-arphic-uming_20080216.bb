DESCRIPTION = "Unicode Mingti (printed) TrueType Font"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/CJKUnifonts"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RPROVIDES = "virtual/chinese-font"
PR = "r1"

SRC_URI = \
"http://archive.ubuntu.com/ubuntu/pool/main/t/ttf-arphic-uming/ttf-arphic-uming_0.2.${PV}.1.orig.tar.gz"
S = "${WORKDIR}"

require ttf.inc

FILES_${PN} = "${datadir}"

