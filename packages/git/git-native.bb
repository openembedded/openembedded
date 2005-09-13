include git.bb
inherit native

do_stage () {
	oe_runmake install bindir=${STAGING_BINDIR} \
		template_dir=${STAGING_DIR}/${BUILD_SYS}/share/git-core/templates/ \
		GIT_PYTHON_DIR=${STAGING_DIR}/${BUILD_SYS}/share/git-core/python
}
