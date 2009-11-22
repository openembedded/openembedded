INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r3"

FILESPATH = "${FILE_DIRNAME}/${PN}/${PV}"

#SRC_URI = "git://sopc.et.ntust.edu.tw/git/linux-2.6.git;branch=test-nios2;tags=3146b39c185f8a436d430132457e84fa1d8f8208 \
SRC_URI = "http://127.0.0.1/linux-nios2-2.6.28-git.tbz \
           file://procinfo.h \
           file://system.ptf"
SRC_URI += "file://defconfig"

S = "${WORKDIR}/linux-2.6"

COMPATIBLE_HOST = 'nios2.*-linux.*'
COMPATIBLE_MACHINE = '(nios2|sygeg1)'

inherit kernel

ARCH = "nios2"
KERNEL_IMAGETYPE = "zImage"


do_configure() {
        rm -f ${S}/.config

        if [ ! -e ${WORKDIR}/defconfig ]; then
                die "No default configuration for ${MACHINE} available."
        fi
        
	echo "CONFIG_INITRAMFS_SOURCE=\"${DEPLOY_DIR_IMAGE}/initramfs_root.cpio\""   >> ${S}/.config
        sed -e '/CONFIG_INITRAMFS_SOURCE/d' '${WORKDIR}/defconfig' >>'${S}/.config'

	oe_runmake hwselect SYSPTF=../system.ptf CPU_SELECTION=1 MEM_SELECTION=2 ARCH=$ARCH
        yes '' | oe_runmake oldconfig
}
