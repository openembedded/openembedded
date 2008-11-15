inherit native
require xcursorgen_${PV}.bb

DEPENDS = "libx11-native libpng-native"

S="${WORKDIR}/xcursorgen-${PV}"
XORG_PN="xcursorgen"
