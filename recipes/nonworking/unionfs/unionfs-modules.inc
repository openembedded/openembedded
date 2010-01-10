unionutils = "unionctl uniondbg"

include unionfs.inc
inherit module

SECTION = "kernel/modules"

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' 'LD=${KERNEL_LD}' \
		'KERNELVER=${KERNEL_VERSION}' \
		'LINUXSRC=${STAGING_KERNEL_DIR}' \
		'CROSS_COMPILE=${TARGET_PREFIX}' \
		'OS=${TARGET_OS}' \
		${@get_flags(d, bb)}"

KCFLAGS = "-D__KERNEL__ -DMODULE -DFISTGEN \
	   -DUNIONFS_UNSUPPORTED -DNODEBUG \
	   -I. -I${STAGING_KERNEL_DIR}/include \
           -DUNIONFS_VERSION=\"${PV}\" \
	   ${CFLAGS}"

def get_flags(d, bb):
	ret = ""
	if bb.data.getVar('KERNEL_OBJECT_SUFFIX', d, 1) == '.ko':
		return "'EXTRA_CFLAGS=%s'" % bb.data.getVar('KCFLAGS', d, 1)
	return "'CFLAGS=%s'" % bb.data.getVar('KCFLAGS', d, 1)

do_compile () {
	unset LDFLAGS
	oe_runmake unionfs${KERNEL_OBJECT_SUFFIX}
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs
	install -m 0644 unionfs${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs/

	install -d ${D}${mandir}/man4
	install -m 0644 man/unionfs.4 ${D}${mandir}/man4/
}
