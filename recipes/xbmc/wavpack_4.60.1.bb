DESCRIPTION = "WavPack is a completely open audio compression format providing lossless, high-quality lossy, and a unique hybrid compression mode."
LICENSE = "BSD"

SRC_URI = "http://wavpack.com/wavpack-${PV}.tar.bz2"
SRC_URI[md5sum] = "7bb1528f910e4d0003426c02db856063"
SRC_URI[sha256sum] = "175ee4f2effd6f51e6ec487956f41177256bf892c2e8e07de5d27ed4ee6888c5"

inherit autotools lib_package

