FILESPATHPKG .= ":mpfr-${PV}"

require mpfr_${PV}.bb
inherit canadian-native
DEPENDS = "gmp-canadian"

