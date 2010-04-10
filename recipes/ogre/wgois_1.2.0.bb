DESCRIPTION = "Object Oriented Input System (OIS) is meant to be a cross platform, simple solution for using all kinds of Input Devices."
LICENSE = "zlib"
DEPENDS = "virtual/libx11 libxaw"

SRC_URI = "${SOURCEFORGE_MIRROR}/wgois/ois_${PV}.tar.gz"

inherit autotools

S = "${WORKDIR}/ois"

FILES_${PN} += "${libdir}/libOIS-1*.so"





SRC_URI[md5sum] = "6a8cedad04f095127ca1455162fec955"
SRC_URI[sha256sum] = "175414df5d7b924779fa513ea614081ae55ae708a5e29473e74911297e4be708"
