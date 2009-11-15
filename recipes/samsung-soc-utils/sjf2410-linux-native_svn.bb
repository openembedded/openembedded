DESCRIPTION = "JTAG utility to interface w/ a S3C2410 device"
SECTION = "devel"
AUTHOR = "Harald Welte <laforge@openmoko.org>"
LICENSE = "GPL"
PV = "0.1+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=sjf2410-linux;proto=http"
S = "${WORKDIR}/sjf2410-linux"

inherit native

CFLAGS += "-DLINUX_PPDEV"

do_compile() {
	oe_runmake
}

do_deploy() {
        install -d ${DEPLOY_DIR_TOOLS}
        install -m 0755 sjf2410 ${DEPLOY_DIR_TOOLS}/sjf2410-${PV}
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_package after do_install
