DESCRIPTION = "User Mode Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"
KV = "${@bb.data.getVar('PV',d,True).split('-')[0]}"
RCV = "${@bb.data.getVar('PV',d,True).split('-')[1]}"
MMV = "${@bb.data.getVar('PV',d,True).split('-')[2]}"
LV = "2.6.10"
PR = "r3"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${LV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-${KV}-${RCV}.bz2;patch=1;name=patch \
           ${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/2.6/${KV}-${RCV}/${KV}-${RCV}-${MMV}/${KV}-${RCV}-${MMV}.gz;patch=1;name=akpmpatch \
           file://defconfig"
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-core-on-panic;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-pretend-to-be-i586;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-general-protection-fault;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-x11-fb;patch=1 \

SRC_URI[kernel.md5sum] = "cffcd2919d9c8ef793ce1ac07a440eda"
SRC_URI[kernel.sha256sum] = "21646736755faee214f489b7388e6c47f5bcf6c2df64298ed2597104fabb8f0e"
SRC_URI[patch.md5sum] = "c93568f10a6aa445184b005a0754aa71"
SRC_URI[patch.sha256sum] = "82dd73b3db7abeadc33e9b2ede0406de35277a8b897a23d266af0614f15052f1"
SRC_URI[akpmpatch.md5sum] = "0e34b11b54e99a4d1d058a711bfad3d4"
SRC_URI[akpmpatch.sha256sum] = "189e355021a87d11bbc3caf65fa96b937d8da4060eb4f8773457c19519a079a4"

S = "${WORKDIR}/linux-${LV}"

inherit kernel

COMPATIBLE_HOST = 'i.86.*-linux'
COMPATIBLE_MACHINE = "x86-uml"

export OS = "Linux"
ARCH = "um"
SUBARCH = "${TARGET_ARCH}"
KERNEL_IMAGETYPE = "linux"
EXTRA_OEMAKE = "'CC=${KERNEL_CC}' 'LD=${KERNEL_LD}' \
		'SUBARCH=${SUBARCH}'"
EXTRA_CFLAGS += "-I${includedir}"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig .config
	oe_runmake oldconfig
}

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        install -d arch/um/include/linux/
        install -m 0644 include/linux/inet.h arch/um/include/linux/
	kernel_do_compile
}

do_stage_prepend() {
	install -d arch/um/boot/
	ln -sf ${S}/linux arch/um/boot/linux
}

do_install() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        #oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" modules_install
        install -d ${D}/boot
        install -m 0755 linux ${D}/boot/linux-${PV}
        install -m 0644 System.map ${D}/boot/System.map-${PV}
        install -m 0644 .config ${D}/boot/config-${PV}
}
