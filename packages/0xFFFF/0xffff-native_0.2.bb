require 0xffff.inc

inherit native

do_stage() {
        install -m 755 0xFFFF ${STAGING_BINDIR_NATIVE}
}

do_deploy[dirs] = "${S}"

do_deploy() {
        install -m 755 0xFFFF ${DEPLOY_DIR_IMAGE}
}

addtask deploy before do_package after do_install


