RDEPENDS += "kernel (${KERNEL_VERSION}) update-modules"
DEPENDS += "virtual/kernel"

inherit module-base

MODULE_MAKE_FLAGS = '\
	KERNEL_PATH=${STAGING_KERNEL_DIR}\
	KERNEL_SRC=${STAGING_KERNEL_DIR}\
	KDIR=${STAGING_KERNEL_DIR}\
	KERNELDIR=${STAGING_KERNEL_DIR}\
	KERNEL_VERSION=${KERNEL_VERSION}\
	CC="${KERNEL_CC}" LD="${KERNEL_LD}"\
	AR="${KERNEL_AR}"\
	'

module_do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake ${MODULE_MAKE_FLAGS} ${MAKE_TARGETS}
}

module_do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" ${MODULE_MAKE_FLAGS} modules_install
}

pkg_postinst_append () {
if [ -n "$D" ]; then
	exit 1
else
	depmod -a ${KERNEL_VERSION}
	update-modules || true
fi
}

pkg_postrm_append () {
	update-modules || true
}

EXPORT_FUNCTIONS do_compile do_install

FILES_${PN} = "/etc /lib/modules"
