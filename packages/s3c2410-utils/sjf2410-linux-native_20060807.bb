DESCRIPTION = "Jtag utility to interface w/ a S3C2410 device"
SECTION = "devel"
AUTHOR = "Harald Welte"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "file://sjf2410-linux-20060807.tar.bz2"
S = "${WORKDIR}/sjf2410-linux"

inherit native

CFLAGS += "-DLINUX_PPDEV"

do_compile() {
	oe_runmake
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0755 sjf2410 ${DEPLOY_DIR_IMAGE}/sjf2410
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_package after do_install
