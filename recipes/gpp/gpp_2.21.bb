SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "GPP is a general-purpose preprocessor with \
customizable syntax, suitable for a wide range of \
preprocessing tasks."

SRC_URI = "http://www.nothingisreal.com/gpp/gpp-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "0be03c6da8d1551a262be11798c00478"
SRC_URI[sha256sum] = "c29373b752730195fc52e6ab0fc871f259284e2175bf2baf1701f027da60d200"
