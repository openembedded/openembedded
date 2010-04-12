inherit native
require xcursorgen_${PV}.bb

DEPENDS = "libx11-native libpng-native"

S="${WORKDIR}/xcursorgen-${PV}"
XORG_PN="xcursorgen"

SRC_URI[archive.md5sum] = "69df079b3950a0db4e5f4e6f0e00ddee"
SRC_URI[archive.sha256sum] = "ed5f3ffe881c21ffca85406e5a5f553ed4985cc5e9acdb535f682c33bebac254"
