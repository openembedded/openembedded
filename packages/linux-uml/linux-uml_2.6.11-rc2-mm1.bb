DESCRIPTION = "User Mode Linux Kernel"
SECTION = "kernel"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
KV = "${@bb.data.getVar('PV',d,True).split('-')[0]}"
RCV = "${@bb.data.getVar('PV',d,True).split('-')[1]}"
MMV = "${@bb.data.getVar('PV',d,True).split('-')[2]}"
LV = "2.6.10"
PR = "r3"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/linux-${LV}.tar.bz2 \
           http://www.kernel.org/pub/linux/kernel/v2.6/testing/patch-${KV}-${RCV}.bz2;patch=1 \
           http://www.kernel.org/pub/linux/kernel/people/akpm/patches/2.6/${KV}-${RCV}/${KV}-${RCV}-${MMV}/${KV}-${RCV}-${MMV}.gz;patch=1 \
           file://defconfig"
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-core-on-panic;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-pretend-to-be-i586;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-general-protection-fault;patch=1 \
#http://www.suse.de/~kraxel/uml/patches/2.6.10-rc3/uml-x11-fb;patch=1 \

S = "${WORKDIR}/linux-${LV}"

inherit kernel

COMPATIBLE_HOST = 'i.86.*-linux'

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
