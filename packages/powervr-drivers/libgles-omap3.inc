DESCRIPTION = "libGLES for the omap3"
LICENCE = "proprietary-binary"

# Put "OMAP35x_Graphics_SDK_setuplinux_3_00_00_05.bin" in the same directory as this recipe
SRC_URI = "file://OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin \
           file://rc.pvr \
          "
S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}"

BINLOCATION ?= "${S}/gfx_rel"

PACKAGES += " xserver-kdrive-powervrsgx ${PN}-tests"

FILES_${PN} = "${sysconfdir} ${libdir}/lib*.so.* ${bindir}/pvrsrvinit"
FILES_xserver-kdrive-powervrsgx = "${bindir}/Xsgx"
FILES_${PN}-tests = "${bindir}/*"

RRECOMMENDS_${PN} = "${PN}-tests \
                     omap3-sgx-modules"

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

do_accept_license() {
	export HOME="${WORKDIR}"
	echo "Y
Y
${S}" | ${WORKDIR}/OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin
}

addtask accept_license after do_unpack before do_configure

do_compile() {
    for sofile in $(find ${S} -name "lib*Open*.so") $(find ${S} -name "lib*srv*.so")   $(find ${S} -name "lib*gl*.so") $(find ${S} -name "libpvr*.so") $(find ${S} -name "lib*GL*.so"); do
        if [ "$(readlink -n ${sofile})" = "" ] ; then
            mv $sofile ${sofile}.${IMGPV}
            ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}
        fi
    done
}

do_install () {

	install -d ${D}${libdir}
	cp -pP ${BINLOCATION}/*.so* ${D}${libdir}

	install -d ${D}${bindir}/
	cp -pP ${BINLOCATION}/*_test ${D}${bindir}/
	cp -pP ${BINLOCATION}/gl2info ${D}${bindir}/
	cp -pP ${BINLOCATION}/gles1test1 ${D}${bindir}/
	cp -pP ${BINLOCATION}/gles1_texture_stream ${D}${bindir}/
	cp -pP ${BINLOCATION}/gles2test1 ${D}${bindir}/
	cp -pP ${BINLOCATION}/pvrsrvinit ${D}${bindir}/
	cp -pP ${BINLOCATION}/xgles1test1 ${D}${bindir}/

	cp -pP ${BINLOCATION}/freedesktop/kdrive/usr/X11R6_SGX/bin/Xsgx || true
	cp -pP ${BINLOCATION}/freedesktop/usr/X11R6_SGX/bin/Xsgx ${D}${bindir}/ || true

	install -d ${D}${includedir}
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/* ${D}${includedir}/
	
	install -d ${D}${sysconfdir}/init.d/
	cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init
}

do_stage () {
	install -d ${STAGING_LIBDIR}/
	cp -pP ${BINLOCATION}/*.so* ${STAGING_LIBDIR}
	cp -pP ${BINLOCATION}/*.a ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/*  ${STAGING_INCDIR}/
}

pkg_postinst() {
#!/bin/sh
ln -sf /usr/lib/libXdmcp.so.6.0.0 /usr/lib/libXdmcp.so.0 
ln -sf /usr/lib/libXau.so.6.0.0 /usr/lib/libXau.so.0
}
