DESCRIPTION = "x86 (SSE) assembler supporting NASM and GAS-syntaxes"
LICENSE = "BSD"
HOMEPAGE = "http://www.tortall.net/projects/yasm/"
PR = "r1"

SRC_URI = "http://www.tortall.net/projects/yasm/releases/yasm-${PV}.tar.gz"

S = "${WORKDIR}/yasm-${PV}"

inherit autotools

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "cc9360593de5625dca286f0bfcb27dd5"
SRC_URI[sha256sum] = "2c4f916883cbaf5c177a3fd105c3180bd0f574c87d7215ecfbe5b087efcc0dd6"
