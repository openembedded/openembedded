DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE = "GPL"
PR = "r2"

COMPATIBLE_MACHINE = "ep93xx"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
	   http://www.wantstofly.org/~buytenh/ep93xx/derevo17.diff;patch=1 \
	   file://eabi-enums.patch;patch=1 \
           file://defconfig \
		   "

S = "${WORKDIR}/linux-2.6.16"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

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


