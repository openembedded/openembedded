require linux.inc

PR = "r0"

S = "${WORKDIR}/linux-2.6"

# For nios2 the source comes from sopc.et.ntust.edu.tw, but as this one is very slow
# a tarball is placed at opensource.axon.tv
#SRC_URI_nios2 = "git://sopc.et.ntust.edu.tw/git/linux-2.6.git;branch=nios2mmu;protocol=http;tag=a32ca88c4f3f3850c5c9789db2afab2530c6856d;protocol=http \
SRC_URI_nios2 = "ftp://opensource.axon.nl/mirror/git_sopc.et.ntust.edu.tw.linux-2.6.git_a32ca88c4f3f3850c5c9789db2afab2530c6856d.tar.gz;name=nios2tarball \
           file://defconfig \
	   "

# nios2 checksums
SRC_URI[nios2tarball.md5sum] = "ad27c6ddfe5b2bb0f81968c0155d072d"
SRC_URI[nios2tarball.sha256sum] = "7c99c5ee4bf26d08fde030c605c618454984dba5ae79c298064228ab0053e60f"

KERNEL_IMAGETYPE = "zImage"

do_configure() {
        rm -f ${S}/.config

        if [ ! -e ${WORKDIR}/defconfig ]; then
                die "No default configuration for ${MACHINE} available."
        fi

	cp  ${WORKDIR}/defconfig  ${S}/.config

#	echo "CONFIG_INITRAMFS_SOURCE=\"${DEPLOY_DIR_IMAGE}/initramfs_root.cpio\""   >> ${S}/.config
#        sed -e '/CONFIG_INITRAMFS_SOURCE/d' '${WORKDIR}/defconfig' >>'${S}/.config'


        yes '' | oe_runmake oldconfig
}

