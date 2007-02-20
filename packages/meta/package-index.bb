DESCRIPTION = "Rebuild the package index"
LICENSE = "MIT"
PR = "r2"

DEPENDS = "ipkg-utils-native"

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
do_stage() {
}

do_build[nostamp] = "1"
do_build[dirs] = "${DEPLOY_DIR_IPK}"
do_build() {
	set -ex
	touch Packages
	ipkg-make-index -r Packages -p Packages -l Packages.filelist -m .

	ipkgarchs="${PACKAGE_ARCHS}"

        for arch in $ipkgarchs; do
            if [ -e ${DEPLOY_DIR_IPK}/$arch/ ] ; then
                 touch ${DEPLOY_DIR_IPK}/$arch/Packages
                 ipkg-make-index -r ${DEPLOY_DIR_IPK}/$arch/Packages -p ${DEPLOY_DIR_IPK}/$arch/Packages -l ${DEPLOY_DIR_IPK}/$arch/Packages.filelist -m ${DEPLOY_DIR_IPK}/$arch/
            fi
        done

        set +ex
}
