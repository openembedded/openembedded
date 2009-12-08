DESCRIPTION = "libGLES for the omap3"
LICENCE = "proprietary-binary"

RDEPENDS_${PN} += "devmem2"

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = True
INSANE_SKIP_${PN}-tests = True
INSANE_SKIP_${PN}-demos = True
INSANE_SKIP_xserver-kdrive-powervrsgx = True

PROVIDES += "virtual/egl"

# some hints to get you going. as this isnt a totally "open" library, you need
# to do some work. follow the steps below.
#
# 1. if you don't already have a ti account get one here. it's free:
#  http://www.ti.com/hdr_my_ti
# 2. fetch the gl-es bin from here:
#  https://www-a.ti.com/downloads/sds_support/targetcontent/dvsdk/oslinux_dvsdk/v3_00_3530/OMAP35x_Graphics_SDK_setuplinux_3_00_00_06.bin
# (replace version in .bin file as appropriate)
# 3. put the OMAP35x_*.bin file in libgles-omap3/
#  mv OMAP35x_Graphics_SDK_setuplinux_3_00_00_06.bin ./libgles-omap3/
# 4. make it executable:
#  chmod a+x ./libgles-omap3/OMAP35x_Graphics_SDK_setuplinux_3_00_00_06.bin
# 
# voila!

SRC_URI = "file://OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin \
           file://cputype \
           file://rc.pvr \
           file://chameleonman.desktop \
           file://evilskull.desktop \
           file://fivespheres.desktop \
           file://lighting.desktop \
           file://mouse.desktop \
           file://optimizemesh.desktop \
           file://particles.desktop \
           file://polybump.desktop \
           file://shadowtechniques.desktop \
           file://skybox.desktop \
           file://trilinear.desktop \
           file://userclipplanes.desktop \
           file://vase.desktop \
           file://shaders.desktop \
           file://skybox2.desktop \
          "

S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../ti/ti-eula-unpack.inc

BINLOCATION ?= "${S}/gfx_rel"

PACKAGES += " xserver-kdrive-powervrsgx ${PN}-tests ${PN}-demos"

FILES_${PN} = "${sysconfdir} ${libdir}/lib*.so.* ${libdir}/ES*/* ${bindir}/pvrsrvinit ${bindir}/cputype ${bindir}/*/*"
FILES_xserver-kdrive-powervrsgx = "${bindir}/Xsgx"
FILES_${PN}-tests = "${bindir}"
FILES_${PN}-demos = "${prefix}/demos ${prefix}/share/applications "
FILES_${PN}-dbg = "${libdir}/.debug/* ${bindir}/.debug/* ${libdir}/ES*/.debug ${bindir}/*/.debug\
	${prefix}/demos/OGLES/*/.debug/* \
	${prefix}/demos/OGLES2/*/.debug/* \
	"

RRECOMMENDS_${PN} = "${PN}-tests \
                     omap3-sgx-modules"

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."


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
	install -m 0755 ${WORKDIR}/cputype ${D}${bindir}/

	cp -pP ${BINLOCATION}/*_test ${D}${bindir}/
	cp -pP ${BINLOCATION}/gl* ${D}${bindir}/
	cp -pP ${BINLOCATION}/p[dv]* ${D}${bindir}/
	cp -pP ${BINLOCATION}/xgles1test1 ${D}${bindir}/

	cp -pP ${BINLOCATION}/freedesktop/kdrive/usr/X11R6_SGX/bin/Xsgx ${D}${bindir}/|| true

	install -d ${D}${includedir}
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/* ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/* ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/LinuxOMAP3/Include/GLES/* ${D}${includedir}/GLES/ || true
	cp -pPr ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/LinuxOMAP3/Include/GLES/* ${D}${includedir}/GLES2/ || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/v* ${D}${includedir}/ || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/V* ${D}${includedir}/ || true
	cp -pPr ${S}/include/*.h ${D}${includedir} || true
	
	install -d ${D}${sysconfdir}/init.d/
	cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init

	install -d ${D}${sysconfdir}
	echo "[default]" > ${D}${sysconfdir}/powervr.ini
	echo "WindowSystem=libpvrPVR2D_FRONTWSEGL.so" >> ${D}${sysconfdir}/powervr.ini

	install -d ${D}${prefix}/demos/OGLES/
	cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Binaries/CommonX11/Demos/* ${D}${prefix}/demos/OGLES/

	install -d ${D}${prefix}/demos/OGLES2
	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Binaries/X11/Demos/* ${D}${prefix}/demos/OGLES2

	install -d ${D}${prefix}/share/applications
	cp -pPR ${WORKDIR}/*.desktop ${D}${prefix}/share/applications
}

do_stage () {
	install -d ${STAGING_LIBDIR}/
	cp -pP ${BINLOCATION}/*.so* ${STAGING_LIBDIR}
	cp -pP ${BINLOCATION}/*.a ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}
        cp -pPR ${S}/GFX_Linux_KM/include4 ${STAGING_INCDIR}/
        cp -pPR ${S}/GFX_Linux_KM/services4 ${STAGING_INCDIR}/

	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/*  ${STAGING_INCDIR}/
    cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/* ${STAGING_INCDIR}/
    cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/LinuxOMAP3/Include/GLES/* ${STAGING_INCDIR}/GLES/ || true
    cp -pPr ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/LinuxOMAP3/Include/GLES/* ${STAGING_INCDIR}/GLES2/ || true
	cp -pPr ${S}/include/*.h ${STAGING_INCDIR} || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/v* ${STAGING_INCDIR}/ || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/V* ${STAGING_INCDIR}/ || true
}

pkg_postinst() {
#!/bin/sh
ln -sf /usr/lib/libXdmcp.so.6.0.0 /usr/lib/libXdmcp.so.0 
ln -sf /usr/lib/libXau.so.6.0.0 /usr/lib/libXau.so.0
}
