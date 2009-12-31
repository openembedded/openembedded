# nvidia-display .bb build file
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

require nvidia-drivers.inc

PR = "r2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_ion = "1"

PKG_BASENAME="NVIDIA-Linux-${NVIDIA_ARCH}-${PV}-${NVIDIA_PKGRUN}"

SRC_URI="http://download.nvidia.com/XFree86/Linux-${NVIDIA_ARCH}/${PV}/${PKG_BASENAME}.run \
	file://nvidia-oe-conftest.patch;patch=1"

S="${WORKDIR}/${PKG_BASENAME}/usr/src/nv"

EXTRA_OEMAKE=" KERNEL_SOURCES=${STAGING_KERNEL_DIR} KERNEL_MODLIB=${STAGING_KERNEL_DIR} KERNEL_UNAME=${KERNEL_VERSION} PATCHLEVEL=${KERNEL_PATCHLEVEL} MODULE_ROOT=${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers IGNORE_CC_MISMATCH=1"

FILES_${PN} += " /usr/lib /usr/bin /usr/share"
FILES_${PN}-dev += " /usr/lib/xorg/modules/extensions/libglx.so"

INSANE_SKIP_${PN} = True

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
		cp -pPR ${WORKDIR}/${PKG_BASENAME}/usr/$dir ${D}/usr/
	done

	#X11R7.0 style...
	install -d ${D}/usr/lib/xorg/
	cp ${WORKDIR}/${PKG_BASENAME}/usr/X11R6/lib/lib* ${D}/usr/lib/
	cp -pPR ${WORKDIR}/${PKG_BASENAME}/usr/X11R6/lib/modules ${D}/usr/lib/xorg/
	ln -s libglx.so.${PV} ${D}/usr/lib/xorg/modules/extensions/libglx.so
	ln -s libGL.so.${PV} ${D}/usr/lib/libGL.so
	ln -s libGL.so.${PV} ${D}/usr/lib/libGL.so.1
	ln -s libGLcore.so.${PV} ${D}/usr/lib/libGLcore.so
	ln -s libGLcore.so.${PV} ${D}/usr/lib/libGLcore.so.1
}
