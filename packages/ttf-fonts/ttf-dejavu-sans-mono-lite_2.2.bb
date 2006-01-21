include ttf-dejavu_${PV}.bb

DESCRIPTION = "DejaVu font - TTF Edition - Sans Mono Lite"

RCONFLICTS = "ttf-dejavu-sans-mono"
RREPLACES = "ttf-dejavu-sans-mono"

PACKAGES = "ttf-dejavu-sans-mono-lite"

FILES_${PN}  = "${datadir}/fonts/truetype/DejaVuSansMono.ttf"
