unionutils = "unionctl uniondbg"

include unionfs.inc
inherit module
CFLAGS =+ "-D__KERNEL__ -DMODULE -I${STAGING_KERNEL_DIR}/include"
EXTRA_OEMAKE = "'CC=${KERNEL_CC}' 'LD=${KERNEL_LD}' \
		'KERNELVER=${KERNEL_VERSION}' \
		'LINUXSRC=${STAGING_KERNEL_DIR}' \
		'CROSS_COMPILE=${TARGET_PREFIX}' \
		'OS=${TARGET_OS}'"

do_compile () {
	unset CFLAGS LDFLAGS
	oe_runmake unionfs${KERNEL_OBJECT_SUFFIX}
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs
	install -m 0644 unionfs${KERNEL_OBJECT_SUFFIX} ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs/

	install -d ${D}/${mandir}/man4
	install -m 0644 man/unionfs.4 ${D}/${mandir}/man4/
}
