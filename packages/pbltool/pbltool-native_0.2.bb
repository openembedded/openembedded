DESCRIPTION = "Loader tool for Amstrad Delta (E3)"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://the.earth.li/pub/e3/pbltool-${PV}.c"

INHIBIT_NATIVE_STAGE_INSTALL = 1

do_compile() {
	${CC} -o pbltool ${WORKDIR}/pbltool-${PV}.c
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0755 pbltool ${DEPLOY_DIR_IMAGE}
}

addtask deploy before do_build after do_compile

inherit native
