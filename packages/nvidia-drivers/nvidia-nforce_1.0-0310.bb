# nvidia-display .bb build file
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

include nvidia-drivers.inc

PKG_BASENAME="NFORCE-Linux-${NVIDIA_ARCH}-${PV}-${NVIDIA_PKGRUN}"

SRC_URI="http://download.nvidia.com/XFree86/nforce/${PV}/NFORCE-Linux-${NVIDIA_ARCH}-${PV}-${NVIDIA_PKGRUN}.run \
	file://nvaudio-remap_page_range.patch;patch=1"

S="${WORKDIR}/${PKG_BASENAME}"

EXTRA_OEMAKE=" KERNEL_SOURCES=${STAGING_KERNEL_DIR} TARGET_KERNEL=${KERNEL_VERSION} INSTROOT=${D} IGNORE_CC_MISMATCH=1"

FILES_${PN} += " /usr/lib /usr/bin"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

	cd nvnet
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
		KERNEL_SRC=${STAGING_KERNEL_DIR}    \
		KERNEL_VERSION=${KERNEL_VERSION}    \
		CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
		${MAKE_TARGETS}
									   
	cd ../nvsound/main
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
		KERNEL_SRC=${STAGING_KERNEL_DIR}    \
		KERNEL_VERSION=${KERNEL_VERSION}    \
		CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
		${MAKE_TARGETS}

}

do_configure() {
	rm -f ${S}/nvnet/makefile
	rm -f ${S}/nvsound/main/makefile
	
	if [ "${KERNEL_PATCHLEVEL}" != "4" ] ; then
		ln -sf Makefile.kbuild ${S}/nvnet/Makefile
		ln -sf Makefile.kbuild ${S}/nvsound/main/Makefile
	else
		ln -sf Makefile.nvidia ${S}/nvnet/Makefile
		ln -sf Makefile.nvidia ${S}/nvsound/main/Makefile
	fi
}


do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

	cd nvnet
	oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" CC="${KERNEL_CC}" LD="${KERNEL_LD}" install

	cd ../nvsound/main
	oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" CC="${KERNEL_CC}" LD="${KERNEL_LD}" install

	install -d ${D}/usr
	for dir in usr/bin nvsound/lib ; do
		cp -a ${S}/$dir ${D}/usr/
	done
	
}

do_stage() {
	install -d ${STAGING_LIBDIR}
	oe_libinstall -a -C ${S}/nvsound/lib libnvalut ${STAGING_LIBDIR}
	oe_libinstall -a -C ${S}/nvsound/lib libnvopenal ${STAGING_LIBDIR}
}
