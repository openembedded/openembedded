DESCRIPTION = "x86 (SSE) assembler supporting NASM and GAS-syntaxes"
LICENSE = "BSD"
HOMEPAGE = "http://www.tortall.net/projects/yasm/"
PR = "r0"

SRC_URI = "http://www.tortall.net/projects/yasm/releases/yasm-${PV}.tar.gz"

SRC_URI[md5sum] = "8392e5f2235c2c2a981e1a633f2698cb"
SRC_URI[sha256sum] = "e5d56b582f3d0c30ed5c4fc221063e4175602307ea645520889458133671c232"

S = "${WORKDIR}/yasm-${PV}"

inherit autotools

BBCLASSEXTEND = "native"
