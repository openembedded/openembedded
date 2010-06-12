require yum-metadata-parser_${PV}.bb
inherit native
DEPENDS = "python-native sqlite3-native glib-2.0-native libxml2-native"
RDEPENDS_${PN} = ""
PR = "r2"

do_stage() {
	distutils_stage_all
}
