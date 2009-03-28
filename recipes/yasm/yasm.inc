DESCRIPTION = "x86 (SSE) assembler supporting NASM and GAS-syntaxes"
LICENSE = "BSD"
HOMEPAGE = "http://www.tortall.net/projects/yasm/"

SRC_URI = "http://www.tortall.net/projects/yasm/releases/yasm-${PV}.tar.gz"

S = "${WORKDIR}/yasm-${PV}"

inherit autotools

