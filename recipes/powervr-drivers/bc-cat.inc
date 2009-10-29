DESCRIPTION = "Video texture streaming via IMG 3rdparty bufferclass (bc-cat) module"
DEPENDS = "libgles-omap3"
inherit module

SRC_URI="http://software-dl.ti.com/dsps/dsps_public_sw/apps_processors/OMAP35x_AM35x_Video_Texture_Streaming/1_0/exports/bc-cat-${PV}.tar.gz \
           file://rc.bccat \
"

S=${WORKDIR}/bc-cat-${PV}

PACKAGES += " ${PN}-tests" 
INSANE_SKIP_${PN}-tests = True
INSANE_SKIP_${PN} = True
FILES_${PN} = "${sysconfdir} /lib/modules/${KERNEL_VERSION}/drivers/gpu/bc-cat/bc_cat.ko"
FILES_${PN}-tests = "/usr/demos/bc-cat/*"
RDEPENDS_${PN}-tests += "${PN}"

inherit update-rc.d

INITSCRIPT_NAME = "bccat-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

do_compile () {
	# build kernel module
	cd ${S}/module
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	make GSDK_KM_DIR=${STAGING_INCDIR} \
		KERNEL_DIR=${STAGING_KERNEL_DIR} \
		CROSS_COMPILE=${TARGET_PREFIX}

	# build test application
	cd ${S}/test
	make  GSDK_KM_DIR=${STAGING_INCDIR} \
		KERNEL_DIR=${STAGING_KERNEL_DIR} \
		CROSS_COMPILE=${TARGET_PREFIX} \
		X11BUILD=1  
}

do_install () {
	# install kernel module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/drivers/gpu/bc-cat
    cp ${S}/module/bc_cat.ko ${D}/lib/modules/${KERNEL_VERSION}/drivers/gpu/bc-cat
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/rc.bccat ${D}${sysconfdir}/init.d/bccat-init

	# install test app
	install -d ${D}/usr/demos/bc-cat
    cp ${S}/test/gles1_bc_mmap ${D}/usr/demos/bc-cat/
    cp ${S}/test/gles1_bc_webcam ${D}/usr/demos/bc-cat/
}

