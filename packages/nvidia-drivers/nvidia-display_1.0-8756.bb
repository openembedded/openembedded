# nvidia-display .bb build file
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

include nvidia-drivers.inc

PKG_BASENAME="NVIDIA-Linux-${NVIDIA_ARCH}-${PV}-${NVIDIA_PKGRUN}"

SRC_URI="http://download.nvidia.com/XFree86/Linux-${NVIDIA_ARCH}/${PV}/${PKG_BASENAME}.run \
	file://nvidia-oe-conftest.patch;patch=1"

S="${WORKDIR}/${PKG_BASENAME}/usr/src/nv"

EXTRA_OEMAKE=" KERNEL_SOURCES=${STAGING_KERNEL_DIR} KERNEL_MODLIB=${STAGING_KERNEL_DIR} KERNEL_UNAME=${KERNEL_VERSION} PATCHLEVEL=${KERNEL_PATCHLEVEL} MODULE_ROOT=${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers IGNORE_CC_MISMATCH=1"

FILES_${PN} += " /usr/lib /usr/bin /usr/share"

do_configure() {
	rm -f ${S}/makefile
	if [ "${KERNEL_PATCHLEVEL}" != "4" ] ; then
		ln -sf Makefile.kbuild ${S}/Makefile
	else
		ln -sf Makefile.nvidia ${S}/Makefile
	fi
}

do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" CC="${KERNEL_CC}" LD="${KERNEL_LD}" install

	install -d ${D}/usr
	for dir in bin include lib share ; do
		cp -a ${WORKDIR}/${PKG_BASENAME}/usr/$dir ${D}/usr/
	done
	
	#X11R7.0 style...
	install -d ${D}/usr/lib/xorg/
	cp ${WORKDIR}/${PKG_BASENAME}/usr/X11R6/lib/lib* ${D}/usr/lib/
	cp -a ${WORKDIR}/${PKG_BASENAME}/usr/X11R6/lib/modules ${D}/usr/lib/xorg/
	ln -s libglx.so.1.0.8756 ${D}/usr/lib/xorg/modules/extensions/libglx.so
	
}

do_stage() {
	#Not sure what we need here. This looks like it provides GL
	:
}

