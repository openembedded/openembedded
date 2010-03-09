DESCRIPTION = "Kernelmodule for IMG BufferClass API"
LICENSE = "GPLv2"

DEPENDS = "virtual/egl"

PV = "0.10.1.1"
MACHINE_KERNEL_PR_append = "+gitr${SRCREV}"

inherit module autotools 

SRC_URI = "git://gitorious.org/gst-plugin-bc/gst-plugin-bc.git;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.25.tar.bz2 \
"

SRCREV = "e14e249ef6cb67e91be9198b71efc61eb84c11b5"

S = "${WORKDIR}/git"

EXTRA_OECONF = " --with-kpath=${STAGING_KERNEL_DIR} --enable-module-only --with-gsdk=${STAGING_DIR_TARGET}"

# bitbake git fetcher doesn't handle git submodules currently
do_configure_prepend () {
	sed -i s:cp:echo:g ${S}/module/Makefile.in
	cp -rf ${WORKDIR}/gstreamer-0.10.25/common/* ${S}/common/
	autopoint
	mkdir -p ${S}/win32
	touch ${S}/win32/MANIFEST
}

EXTRA_OEMAKE = " CROSS_COMPILE=${TARGET_PREFIX} GSDK_KM_DIR=${STAGING_INCDIR} "

do_install() {
	cd ${S}/module
	oe_runmake -C ${STAGING_KERNEL_DIR} M=${PWD} DEPMOD=echo INSTALL_MOD_PATH="${D}" ${MODULE_MAKE_FLAGS} modules_install
	cp ${S}/module/*.ko ${D}${base_libdir}/modules/*/extra/
}


ALLOW_EMPTY = "1"


