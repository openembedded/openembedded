DESCRIPTION = "libGLES for the omap3"
LICENCE = "proprietary-binary"

COMPATIBLE_MACHINE = "(am3517-evm|beagleboard|cm-t35|igep0020|omap3-pandora|omap3-touchbook|omap3evm|omapzoom|omapzoom2|overo|palmpre)"

DEPENDS = "virtual/libx11 libxau libxdmcp"

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
# 
# voila!

SRC_URI = "file://OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin \
		   file://cputype \
		   file://rc.pvr \
		   file://sample.desktop \
		  "

S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}"

# Logic to unpack installjammer file
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../ti/ti-eula-unpack.inc

BINLOCATION ?= "${S}/gfx_rel"

do_configure() {
	# Attempt to fix up the worst offenders for file permissions
	for i in $(find ${S} -name "*.h") $(find ${S} -name "*.c") $(find ${S} -name "Make*") ; do
		chmod 0644 $i
	done 

	# Attempt to create proper library softlinks
	for sofile in $(find ${S} -name "lib*Open*.so") $(find ${S} -name "lib*srv*.so") $(find ${S} -name "lib*gl*.so") $(find ${S} -name "libpvr*.so") $(find ${S} -name "lib*GL*.so"); do
		if [ "$(readlink -n ${sofile})" = "" ] ; then
			mv $sofile ${sofile}.${IMGPV}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1}')
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1 "." $2}')
		fi
	done

	# Due to recursive make PLAT_* isn't always passed down correctly, so use sed to fix those
	for mak in $(find ${S} -name "*.mak") ; do
		sed -i -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g $mak
	done

	# clear out old stuff
	find Binaries/ | xargs rm -f || true
}

# Force in GNU_HASH and paths to libs
TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION}"
PARALLEL_MAKE = ""

do_compile() {
	export X11ROOT="${STAGING_INCDIR}"
	export PLATFORM="LinuxOMAP3"

	export PLAT_CC="${CC}"
	export PLAT_CPP="${CXX}"
	export PLAR_AR="${AR}"

	mkdir -p ${S}/demos/raw
	mkdir -p ${S}/demos/x11

	# Rebuild demos for both Raw and X11
	for X11BUILD in 0 1 ; do
		for demo in ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Demos/* ; do
			cd $demo/OGLES/Build/LinuxGeneric
			oe_runmake Common=1 PLATFORM=$PLATFORM X11BUILD=$X11BUILD  
			rm $demo/OGLES/Build/LinuxOMAP3/Release*/*.o
			install -m 0755 $demo/OGLES/Build/LinuxOMAP3/ReleaseX11/* ${S}/demos/x11 || true
			sed -e s:NAME:$(basename $demo): \
			    -e s:EXEC:${bindir}/SGX/demos/X11/$(basename $demo/OGLES/Build/LinuxOMAP3/ReleaseX11/*): \
			     ${WORKDIR}/sample.desktop > ${WORKDIR}/$(basename $demo).desktop
			install -m 0755 $demo/OGLES/Build/LinuxOMAP3/ReleaseRaw/* ${S}/demos/raw || true	
		done
		for demo in ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Demos/* ; do
			cd $demo/OGLES2/Build/LinuxGeneric
			oe_runmake Common=1 PLATFORM=$PLATFORM X11BUILD=$X11BUILD  
			rm $demo/OGLES2/Build/LinuxOMAP3/Release*/*.o
			install -m 0755 $demo/OGLES2/Build/LinuxOMAP3/ReleaseX11/* ${S}/demos/x11 || true
			sed -e s:NAME:$(basename $demo): \
			    -e s:EXEC:${bindir}/SGX/demos/X11/$(basename $demo/OGLES2/Build/LinuxOMAP3/ReleaseX11/*): \
			     ${WORKDIR}/sample.desktop > ${WORKDIR}/$(basename $demo).desktop
			install -m 0755 $demo/OGLES2/Build/LinuxOMAP3/ReleaseRaw/* ${S}/demos/raw || true	
		done
	done

	mkdir -p ${S}/trainingcourses/raw
	mkdir -p ${S}/trainingcourses/x11

	# Build OGLES2 Trainingcourses for both Raw and X11
	for X11BUILD in 0 1 ; do
		for training in ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/TrainingCourse/* ; do
			if [ -e $training/OGLES2/Build/LinuxGeneric/Makefile ] ; then
				cd $training/OGLES2/Build/LinuxGeneric
			fi

			if [ -e $training/OGLES2/Build/LinuxOMAP3/Makefile ] ; then
				cd $training/OGLES2/Build/LinuxOMAP3
			fi			

			oe_runmake Common=1 PLATFORM=$PLATFORM X11BUILD=$X11BUILD  
			rm $training/OGLES2/Build/LinuxOMAP3/Release*/*.o
			install -m 0755 $training/OGLES2/Build/LinuxOMAP3/ReleaseX11/* ${S}/trainingcourses/x11 || true
			install -m 0755 $training/OGLES2/Build/LinuxOMAP3/ReleaseRaw/* ${S}/trainingcourses/raw || true	
		done
	done

}

do_install () {
	install -d ${D}${libdir}
	cp -pPR ${BINLOCATION}/*.so* ${D}${libdir}
	install -m 0644 ${BINLOCATION}/*.a ${D}${libdir}

	install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/cputype ${D}${bindir}/

	install -m 0755 ${BINLOCATION}/*_test ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/gl* ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/p[dv]* ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/xgles1test1 ${D}${bindir}/

	install -m 0755 ${BINLOCATION}/freedesktop/kdrive/usr/X11R6_SGX/bin/Xsgx ${D}${bindir}/|| true

	install -d ${D}${includedir}
	cp -pPR ${S}/GFX_Linux_KM/include4 ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_KM/services4 ${D}${includedir}/

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

	# The ES2.x and ES3.x CPUs have different SGX hardware, so we need to install 2 sets of userspace

	install -d ${D}${libdir}/ES3.0
	install -d ${D}${libdir}/ES2.0
	install -d ${D}${bindir}/ES3.0
	install -d ${D}${bindir}/ES2.0

	cp -pPR ${S}/gfx_rel_es2.x/lib* ${D}${libdir}/ES2.0/
	cp ${S}/gfx_rel_es2.x//p[dv]* ${D}${bindir}/ES2.0/

	cp -pPR ${D}${libdir}/lib*${IMGPV} ${D}${libdir}/ES3.0/
	cp ${D}${bindir}/p[dv]* ${D}${bindir}/ES3.0

	install -d ${D}${prefix}/share/applications
	cp ${WORKDIR}/*.desktop ${D}${prefix}/share/applications
	rm ${D}${prefix}/share/applications/sample.desktop

	install -d ${D}${bindir}/SGX/demos/X11/
	install -d ${D}${bindir}/SGX/demos/Raw/
	install -m 0755 ${S}/demos/x11/* ${D}${bindir}/SGX/demos/X11/
	install -m 0755 ${S}/demos/raw/* ${D}${bindir}/SGX/demos/Raw/

	install -d ${D}${bindir}/SGX/trainingcourses/Raw
	install -d ${D}${bindir}/SGX/trainingcourses/X11
	install -m 0755 ${S}/trainingcourses/x11/* ${D}${bindir}/SGX/trainingcourses/X11/
	install -m 0755 ${S}/trainingcourses/raw/* ${D}${bindir}/SGX/trainingcourses/Raw/

	# Delete objects and linker scripts hidden between the headers
	find ${D} -name "*.o" -delete
	find ${D} -name "*.o.cmd" -delete
}

PACKAGES =+ "${PN}-rawdemos \
             ${PN}-x11demos \
             ${PN}-rawtrainingcourses \
             ${PN}-x11trainingcourses \
"

PACKAGES += "xserver-kdrive-powervrsgx \
             ${PN}-tests "

FILES_${PN} = "${sysconfdir} ${libdir}/lib*.so.* ${libdir}/ES*/* ${bindir}/pvrsrvinit ${bindir}/cputype ${bindir}/*/*"
FILES_xserver-kdrive-powervrsgx = "${bindir}/Xsgx"
FILES_${PN}-tests = "${bindir}/*"
FILES_${PN}-dbg = "${libdir}/.debug/* ${bindir}/.debug/* \
                   ${libdir}/ES*/.debug ${bindir}/*/.debug\
                   ${bindir}/SGX/demos/*/.debug/* \
                   ${bindir}/SGX/trainingcourses/*/.debug/* \
	"

FILES_${PN}-rawdemos = "${bindir}/SGX/demos/Raw/*"
FILES_${PN}-x11demos = "${bindir}/SGX/demos/X11/* ${prefix}/share/applications "

FILES_${PN}-rawtrainingcourses = "${bindir}/SGX/trainingcourses/Raw/*"
FILES_${PN}-x11trainingcourses = "${bindir}/SGX/trainingcourses/X11/*"

# The libs need the kernel-modules
RRECOMMENDS_${PN} = "omap3-sgx-modules"

# The initscript calls fbset, cputype calls devmem2
RDEPENDS_${PN} += "fbset devmem2"

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = True
INSANE_SKIP_${PN}-tests = True
INSANE_SKIP_xserver-kdrive-powervrsgx = True

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so "
FILES_${PN}-dev = "${includedir}"

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

# Append to update-rc.d postinst
pkg_postinst_${PN}_append() {
ln -sf /usr/lib/libXdmcp.so.6.0.0 /usr/lib/libXdmcp.so.0 
ln -sf /usr/lib/libXau.so.6.0.0 /usr/lib/libXau.so.0
}
