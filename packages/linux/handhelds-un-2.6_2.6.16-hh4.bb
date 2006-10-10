DESCRIPTION = "Handhelds HTC-PXA phones kernel based on the hh 2.6.16"
LICENSE = "GPL"
PR="r0"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=K2-6-16-hh4"

S = "${WORKDIR}/kernel26"

COMPATIBLE_HOST = "arm.*-linux"

inherit kernel

do_configure() {
        cp arch/arm/configs/htcuniversal_defconfig .config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}


###############################################################
# put into deploy directory
#
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
