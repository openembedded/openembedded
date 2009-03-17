require zziplib_${PV}.bb

DEPENDS = "zlib-native"

inherit native

S = "${WORKDIR}/zziplib-${PV}"

PACKAGES = ""
