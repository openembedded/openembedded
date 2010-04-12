SECTION = "kernel"
DESCRIPTION = "Linux kernel for MNCI device"
LICENSE = "GPLv2"
DEPENDS = "modutils-cross virtual/${TARGET_PREFIX}gcc${KERNEL_CCSUFFIX}"
COMPATIBLE_MACHINE = "mnci"
KV = "2.4.21"
RMKV = "2"
PXAV = "1"
PR = "r5"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2;name=kernel \
	   http://ftp.linux.org.uk/pub/linux/arm/kernel/v2.4/patch-${KV}-rmk${RMKV}.bz2;patch=1;name=rmkpatch \
	   file://diff-${KV}-rmk${RMKV}-pxa${PXAV}.gz;patch=1 \
	   file://mnci-combined.patch;patch=1"

S = "${WORKDIR}/linux-${KV}"

inherit kernel

KERNEL_CCSUFFIX = "-3.3.4"

# Put the zImage into kernel-image
ALLOW_EMPTY_kernel = "1"
FILES_kernel = ""
FILES_kernel-image += "/tmp/zImage"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/def-configs/${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
}

kernel_do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	if (grep -q -i -e '^CONFIG_MODULES=y$' .config); then
		oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" modules_install
	else
		oenote "no modules to install"
	fi
	install -d ${D}/tmp
	install -m 0644 ${KERNEL_OUTPUT} ${D}/tmp
	install -d ${D}/boot
	install -m 0644 .config ${D}/boot/config-${PV}
	bzip2 -9 ${D}/boot/*
	install -d ${D}${sysconfdir}/modutils
}


pkg_postinst_kernel-image () {
test -f /tmp/zImage || exit 0
cp /tmp/zImage /dev/mtdblock/1
rm /tmp/zImage
sync
cat /dev/mtdblock/1 >/dev/null
}

pkg_postinst_kernel () {
}

pkg_postinst_modules () {
if [ -n "$D" ]; then
	${HOST_PREFIX}depmod-${KERNEL_MAJOR_VERSION} -A -b $D -F $D/boot/System.map-${PV} ${KERNEL_VERSION}
else
	depmod -A
fi
}

pkg_postrm_modules () {
}

pkg_postrm_kernel () {
}

SRC_URI[kernel.md5sum] = "f51e12efa18bb828cf57d9d4a81b2fb1"
SRC_URI[kernel.sha256sum] = "dd197b9b80535591c0dc0505fae31c8eceeb07a891e85b85396494a0f97688db"
SRC_URI[rmkpatch.md5sum] = "23169d1265241683bb8c9d0daf22b6b5"
SRC_URI[rmkpatch.sha256sum] = "1381ef6cfb9460adee987322657fbfcd081e70d7be4255163ed1a2afeb7becfb"
