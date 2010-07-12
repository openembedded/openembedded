require jsch_${PV}.bb

S = "${WORKDIR}/jsch-${PV}"

inherit java-native

DEPENDS = "fastjar-native jzlib-native"
RDEPENDS = ""
