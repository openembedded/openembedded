# Vala has problems with multiple concurrent invocations
PARALLEL_MAKE = ""

# Vala needs vala-native
DEPENDS += "vala-native"
DEPENDS_virtclass-native += "vala-native"

# Vala looks in STAGING_DATADIR for .vapi files
export STAGING_DATADIR

# Package additional files
FILES_${PN}-dev += "\
  ${datadir}/vala/vapi/*.vapi \
  ${datadir}/vala/vapi/*.deps \
  ${datadir}/gir-1.0 \
"
