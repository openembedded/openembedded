DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
SECTION = "devel"
LICENSE = "BSD"

SRC_URI = "http://mesh.dl.sf.net/lex/flex-2.5.31.tar.bz2"
S = "${WORKDIR}/flex-${PV}"

inherit autotools

