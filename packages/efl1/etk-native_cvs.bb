require etk_cvs.bb
inherit native
DEPENDS = "evas-native ecore-native edje-native"

SRC_URI += "file://no-tests.patch;patch=1"

do_stage_append() {
	mv ${STAGING_DIR}/include/etk ${STAGING_INCDIR}
}

