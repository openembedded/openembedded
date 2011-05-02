LICENSE = "BSD"
DEPENDS = "ti-codec-engine ti-dsplib"

PV = "0+svnr${SRCPV}"
SRCREV = "180"
PR = "r1"

SRC_URI = "svn://opencv-dsp-acceleration.googlecode.com/svn/;proto=http;module=trunk \
           http://focus.ti.com/lit/sw/sprc264/sprc264.zip;name=imglib \
"

SRC_URI[imglib.md5sum] = "97dca3f1612d7c35b3d3fe9f32ab3e0c"
SRC_URI[imglib.sha256sum] = "bf22c58cf81362ec3e7ed2d8debc39f00d1bfd0343094401cce2f928830858c1"

S = "${WORKDIR}/trunk/dsp_opencv"

require recipes/ti/ti-paths.inc
require recipes/ti/ti-staging.inc

export CROSS_COMPILE = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"
export LINUXKERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"
export OPENCV_PATH = "${STAGING_INCDIR}"
export DSPLIB_PATH = "${DSPLIB_INSTALL_DIR}"

# You need to extract the imglib from the .exe manually and place it in /OE/tmp (or somewhere else and change the patch below)
export IMGLIB_PATH = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${installdir}/imglib_v201"

do_configure() {
	echo "-l ${DSPLIB_INSTALL_DIR}/dsplib64plus.lib" >> ${S}/beagle/server/opencv_unitserver_evm3530/link.cmd
	echo "-l ${IMGLIB_PATH}/lib/target/imglib2.l64P" >> ${S}/beagle/server/opencv_unitserver_evm3530/link.cmd
	sed -e /DIR/d -e /PATH/d -i Rules.make
	for i in $(find ${S} -name "*.mak" ; find ${S} -name "*.cmd") ; do
		sed -i s:/media/disk/OE/work/ti/dsplib_v210:${DSPLIB_PATH}:g $i
		sed -i s:/media/disk/OE/work/ti/imglib_v201:${IMGLIB_PATH}:g $i
	done

	# Add in build *FLAGS as well	
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e 's:LD_FLAGS):LD_FLAGS) $(LDFLAGS):g' -e 's:C_FLAGS):C_FLAGS) $(CFLAGS):g' $i
	done
}

do_compile() {
	oe_runmake -e codec 
	oe_runmake -e server
	oe_runmake -e library
	oe_runmake -e app
}

do_install() {
	oe_runmake -e install EXEC_DIR=${D}${datadir}/ti/opencv-dsp
}

FILES_${PN} += "${datadir}"
