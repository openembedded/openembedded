DESCRIPTION = "libGLES for the omap3"
LICENCE = "proprietary-binary"
PR = "r5"

# Put "OMAP35x_Graphics_SDK_setuplinux_3_00_00_01.bin" in the same directory as this recipe
SRC_URI = "file://OMAP35x_Graphics_SDK_setuplinux_3_00_00_01.bin \
           file://rc.pvr \
          "

S = "${WORKDIR}/OMAP35x_Graphics_SDK_3_00_00_01"

PACKAGES =+ " ${PN}-tests"

FILES_${PN}-tests = "${bindir}/*"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RRECOMMENDS_${PN} = "${PN}-tests \
                     kernel-module-pvr2d \
                     kernel-module-pvrsrvkm \
                     kernel-module-omaplfb \
                    "

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

do_accept_license() {
	export HOME="${WORKDIR}"
	echo "Y
Y
${S}" | ${WORKDIR}/OMAP35x_Graphics_SDK_setuplinux_3_00_00_01.bin
}

addtask accept_license after do_unpack before do_compile

do_compile () {
	:
}

do_install () {

	install -d ${D}${libdir}
	cp -pR ${S}/gfx_rel/*.so* ${D}${libdir}

	install -d ${D}${bindir}/
	cp -pP ${S}/gfx_rel/*_test ${D}${bindir}/
	cp -pP ${S}/gfx_rel/gl2info ${D}${bindir}/
	cp -pP ${S}/gfx_rel/gles1test1 ${D}${bindir}/
	cp -pP ${S}/gfx_rel/gles1_texture_stream ${D}${bindir}/
	cp -pP ${S}/gfx_rel/gles2test1 ${D}${bindir}/
	cp -pP ${S}/gfx_rel/pvrsrvinit ${D}${bindir}/
	cp -pP ${S}/gfx_rel/xgles1test1 ${D}${bindir}/

	cp -pP ${S}/gfx_rel/freedesktop/usr/X11R6_SGX/bin/Xsgx ${D}${bindir}/

	install -d ${D}${includedir}
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/* ${D}${includedir}/
	
	install -d ${D}${sysconfdir}/init.d/
	cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init
}

do_stage () {
	install -d ${STAGING_LIBDIR}/
	cp -pP ${S}/gfx_rel/*.so* ${STAGING_LIBDIR}
	cp -pP ${S}/gfx_rel/*.a ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/*  ${STAGING_INCDIR}/
}


pkg_postinst() {
#!/bin/sh
ln -sf /usr/lib/libXdmcp.so.6.0.0 /usr/lib/libXdmcp.so.0 
ln -sf /usr/lib/libXau.so.6.0.0 /usr/lib/libXau.so.0
}
