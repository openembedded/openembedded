require xerces-j_${PV}.bb

S = "${WORKDIR}/xerces-2_9_1"

inherit java-native

DEPENDS = "fastjar-native jaxp1.3-native xml-commons-resolver1.1-native"
RDEPENDS = ""
