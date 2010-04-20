DESCRIPTION = "Encrypted shellscript for the Zaurus ROM update"
DEPENDS = "encdec-updater-native"
LICENSE = "zaurus-updater"
PR = "r25"

PACKAGES = ""
COMPATIBLE_MACHINE = '(poodle|c7x0|spitz|akita|tosa)'

SRC_URI = "file://updater.sh"

S = "${WORKDIR}"

do_configure() {
        sed -i "s/ZAURUS_UPDATER_VERSION/${PR}/" "${S}/updater.sh"
}

do_compile() {
        encdec-updater -e updater.sh
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0755 updater.sh ${DEPLOY_DIR_IMAGE}/updater.sh
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/updater.sh
}

# package_stagefile_shell needs to run before populate_staging for packaged-staging
addtask deploy before do_populate_staging after do_compile
