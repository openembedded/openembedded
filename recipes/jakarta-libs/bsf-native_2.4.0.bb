require bsf_${PV}.bb

S = "${WORKDIR}/bsf-${PV}"

inherit java-native

DEPENDS = "fastjar-native jacl-native commons-logging-native rhino-native xalan-j-native bcel-native"

