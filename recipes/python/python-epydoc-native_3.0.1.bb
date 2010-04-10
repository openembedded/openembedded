require python-epydoc_${PV}.bb
DEPENDS = "python-native"
inherit native

do_stage() {
	distutils_stage_all
}


SRC_URI[md5sum] = "cdd6f6c76dd8bab5e653a343a0544294"
SRC_URI[sha256sum] = "d4e5c8d90937d01b05170f592c1fa9b29e9ed0498dfe7f0eb2a3af61725b6ad1"
