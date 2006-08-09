include swig_cvs.bb
inherit native

do_stage() {
	oe_runmake install PREFIX=${STAGING_DIR}/${BUILD_SYS}
}
