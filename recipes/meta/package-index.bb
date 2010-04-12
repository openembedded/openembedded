DESCRIPTION = "Rebuild the package index"
LICENSE = "MIT"
DEPENDS = "ipkg-utils-native"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"
PACKAGES = ""

do_fetch() {
}
do_unpack() {
}
do_patch() {
}
do_configure() {
}
do_compile() {
}
do_install() {
}

do_build[nostamp] = "1"
do_build[dirs] = "${DEPLOY_DIR_IPK}"
addtask package_update_index_ipk before do_build
