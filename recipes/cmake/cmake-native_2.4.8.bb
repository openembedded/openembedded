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

SRC_URI[md5sum] = "f5dd061c31765a49dc17ae8bdc986779"
SRC_URI[sha256sum] = "f20607d4f33376ea648307681630574662d0c3f59d88a7a02ad547b6320631f1"
