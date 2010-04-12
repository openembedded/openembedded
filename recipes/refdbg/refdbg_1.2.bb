DESCRIPTION = "RefDbg is a GObject Reference Count Debugger"
HOMEPAGE = "http://refdbg.sourceforge.net/index.html"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "binutils"

SRC_URI = "${SOURCEFORGE_MIRROR}/refdbg/refdbg-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "ed807a83455b8aaff5e894e94161a352"
SRC_URI[sha256sum] = "0b8591a646d214f0f959483dfcd9b9624996790d546982d814b47ca8fe4c5725"
