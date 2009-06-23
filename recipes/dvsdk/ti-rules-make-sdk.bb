DESCRIPTION = "This package creates Rules.make file and copies top label Makefile for rebuilding dvsdk components."

inherit sdk

PR="r7"

FILES=${@os.path.dirname(bb.data.getVar('FILE',d,1))}/files/dvsdk-rules

DEPENDS_dm355-evm = "ti-xdctools-sdk ti-codec-engine-sdk ti-codec-combo-dm355-sdk ti-dmai-sdk"
DEPENDS_dm6446-evm = "ti-xdctools-sdk ti-codec-engine-sdk ti-codec-combo-dm6446-sdk ti-dmai-sdk ti-cgt6x-sdk ti-dspbios-sdk"
DEPENDS_omap3evm  = "ti-xdctools-sdk ti-codec-engine-sdk ti-codec-combo-omap3530-sdk ti-dmai-sdk ti-cgt6x-sdk ti-dspbios-sdk"
DEPENDS_beagleboard = "ti-xdctools-sdk ti-codec-engine-sdk ti-codec-combo-omap3530-sdk ti-dmai-sdk ti-cgt6x-sdk ti-dspbios-sdk"


PLATFORM_dm355-evm = "dm355"
PLATFORM_dm6446-evm = "dm6446"
PLATFORM_omap3evm = "omap3530"
PLATFORM_dm6467-evm = "dm6467"
PLATFORM_beagleboard = "omap3530"

do_install () {
	mkdir -p  ${D}/${prefix}/dvsdk/	

	# Create Rules.make file by concatinating pkg Rules.make files.
	echo "# Define target platform." > ${D}/${prefix}/dvsdk/Rules.make
	echo "PLATFORM=${PLATFORM}" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "" >> ${D}/${prefix}/dvsdk/Rules.make
    echo "# The installation directory of the DVSDK." >> ${D}/${prefix}/dvsdk/Rules.make
    echo "DVSDK_INSTALL_DIR=${prefix}/dvsdk" >> ${D}/${prefix}/dvsdk/Rules.make
    echo "" >> ${D}/${prefix}/dvsdk/Rules.make
    echo "# For backwards compatibility" >> ${D}/${prefix}/dvsdk/Rules.make
    echo "DVEVM_INSTALL_DIR=\$(DVSDK_INSTALL_DIR)" >> ${D}/${prefix}/dvsdk/Rules.make
    echo "" >> ${D}/${prefix}/dvsdk/Rules.make
  
	for file in `ls -1 ${STAGING_DIR_HOST}/ti-sdk-rules` ; do
	  cat ${STAGING_DIR_HOST}/ti-sdk-rules/${file} >> ${D}/${prefix}/dvsdk/Rules.make
	  echo "" >> ${D}/${prefix}/dvsdk/Rules.make
	done
	
	echo "# The directory that points to your kernel source directory." >>  ${D}/${prefix}/dvsdk/Rules.make 
	echo "LINUXKERNEL_INSTALL_DIR=${prefix}/${TARGET_SYS}/usr/src/kernel" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "# Where temporary Linux headers and libs are installed." >>  ${D}/${prefix}/dvsdk/Rules.make
	echo "LINUXLIBS_INSTALL_DIR=${prefix}/${TARGET_SYS}/usr" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "# The prefix to be added before the GNU compiler tools (optionally including # path), i.e. \"arm_v5t_le-\" or \"/opt/bin/arm_v5t_le-\"." >>  ${D}/${prefix}/dvsdk/Rules.make 
	echo "CSTOOL_DIR=${SDK_PATH}" >>  ${D}/${prefix}/dvsdk/Rules.make
	echo "CSTOOL_PREFIX=\$(CSTOOL_DIR)/bin/arm-none-linux-gnueabi-" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "MVTOOL_DIR=\$(CSTOOL_DIR)" >>  ${D}/${prefix}/dvsdk/Rules.make
	echo "MVTOOL_PREFIX=\$(CSTOOL_PREFIX)" >> ${D}/${prefix}/dvsdk/Rules.make
	echo "" >> ${D}/${prefix}/dvsdk/Rules.make 
	echo "# Where to copy the resulting executables" >>  ${D}/${prefix}/dvsdk/Rules.make
	echo "EXEC_DIR=\$(HOME)/install/\$(PLATFORM)" >>  ${D}/${prefix}/dvsdk/Rules.make

	# copy Makefile and other scripts needed by Makefile
	mkdir -p ${D}/${prefix}/dvsdk/bin
	cp ${FILES}/Makefile ${D}/${prefix}/dvsdk/
	cp ${FILES}/info.sh  ${D}/${prefix}/dvsdk/bin
	cp ${FILES}/check.sh ${D}/${prefix}/dvsdk/bin
}

FILES_${PN} = "${prefix}/dvsdk/*"
