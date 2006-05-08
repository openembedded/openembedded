SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA based devices."
MAINTAINER = "Greg Gilbert <greg@treke.net>"
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"
PR = "r3"
#
COMPATIBLE_HOST = "arm.*-linux"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://24-hostap_cs_id.diff;patch=1 \
           file://hrw-pcmcia-ids-r2.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/kernel26"

inherit kernel

FILES_kernel-image_ipaq-pxa270 = ""
ALLOW_EMPTY_ipaq_pxa270 = 1

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "16"
HHV     = "0"
#

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"
do_configure() {
        rm -f ${S}/.config

        if [ ! -e ${WORKDIR}/defconfig ]; then
                die "No default configuration for ${MACHINE} available."
        fi


        if [ "${TARGET_OS}" == "linux-gnueabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi

        sed -e '/CONFIG_AEABI/d' \
            -e '/CONFIG_OABI_COMPAT=/d' \
            '${WORKDIR}/defconfig' >>'${S}/.config'

        yes '' | oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

