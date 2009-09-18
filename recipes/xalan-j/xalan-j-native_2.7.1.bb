require xalan-j_${PV}.bb

DEPENDS = "\
	fastjar-native \
	xerces-j-native regexp-native jlex-native cup-native jaxp1.3-native bcel-native \
	"

inherit java-native


do_install_append() {
	:
}

