require cmake.inc
inherit native

do_stage() {
	for i in cpack ctest ccmake cmake; do
		install -m 0755 bin/$i ${STAGING_BINDIR_NATIVE}
	done
}

do_install() {
	:
}
