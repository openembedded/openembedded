DESCRIPTION = "Rebuild the package index"
LICENSE = "MIT"
PR = "r3"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"
PACKAGES = ""

inherit rootfs_ipk

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
do_stage() {
}

do_build[nostamp] = "1"
do_build[dirs] = "${DEPLOY_DIR_IPK}"
do_build() {
	set -ex
	rootfs_ipk_do_indexes
	set +ex
}
