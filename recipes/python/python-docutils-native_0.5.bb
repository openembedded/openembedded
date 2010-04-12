require python-docutils_${PV}.bb
DEPENDS = "python-native"
inherit native

do_stage() {
	distutils_stage_all
}


SRC_URI[md5sum] = "dd72dac92fc8e3eb0f48c3effeef80f6"
SRC_URI[sha256sum] = "747cf984edfca0575addbb42453274a1bdd98ec7780bd37a883dc8b2a66a610e"
