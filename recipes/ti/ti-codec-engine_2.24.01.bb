DESCRIPTION = "Codec Engine 2.24.01 for TI ARM/DSP processors"

require ti-paths.inc

# compile time dependencies
DEPENDS_dm6446-evm 	+= "ti-xdctools-native ti-cgt6x-native ti-dspbios-native ti-dsplink-module"
DEPENDS_armv7a   	+= "ti-cgt6x-native ti-dspbios-native ti-xdctools-native ti-dsplink-module"
DEPENDS_dm355-evm 	+= "ti-xdctools-native"

# tconf from xdctools dislikes '.' in pwd :/
PR = "r7"
PV = "2241"

SRC_URI = "http://install.source.dir.local/codec_engine_2_24_01.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_2_24_01"

# Define Device variable
DEVICES_dm355-evm 	?= "DM355"
DEVICES_dm6446-evm 	?= "DM6446"

# define gppos variable
GPPOS_dm355-evm 	?= "LINUX_GCC"
GPPOS_dm6446-evm 	?= "LINUX_GCC"

#define PROGRAM variables
PROGRAMS 		   = "APP_CLIENT DSP_SERVER"
PROGRAMS_dm355-evm ?= "APP_LOCAL"

LINK_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dsplink-module/packages"
DSPBIOS_DIR="${STAGING_DIR_NATIVE}/ti-dspbios-native"
CGT6x_DIR="${STAGING_DIR_NATIVE}/ti-cgt6x-native"
XDCTOOLS_DIR="${STAGING_DIR_NATIVE}/ti-xdctools-native"
CE_INSTALL_DIR="${S}"

do_compile () {

	sed -i  \
		-e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
		${S}/examples/xdcpaths.mak

	for i in codecs extensions servers apps ; do
		cd ${S}/examples/ti/sdo/ce/examples/$i
		make DEVICES="${DEVICES}" \
			GPPOS="${GPPOS}" \
			PROGRAMS="${PROGRAMS}" \
			CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
        	XDC_INSTALL_DIR="${XDCTOOLS_DIR}" \
        	BIOS_INSTALL_DIR="${DSPBIOS_DIR}"\
        	DSPLINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
        	XDAIS_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
        	FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
        	CMEM_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
        	LPM_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
        	EDMA3_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
			FC_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
        	CGTOOLS_V5T="${CROSS_DIR}"\
			CGTOOLS_C64P="${CGT6x_DIR}" \
			clean all
	done
}

do_install() {
	install -d ${D}/${installdir}/codec-engine-apps
    cp ${S}/examples/apps/system_files/${DEVICES}/loadmodules.sh ${D}/${installdir}/codec-engine-apps
	sed -i 's/insmod/modprobe/g' ${D}/${installdir}/codec-engine-apps/loadmodules.sh

	cd ${S}/examples/ti/sdo/ce/examples

    for i in $(find . -name "*.xv5T"); do
		install -d ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
		install ${i} ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`

    	for j in $(find . -name "*.x64P"); do
		install ${j} ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
    	done

    done
}


# stage tree - other packages may need this
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/ 
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
PACKAGES += "ti-codec-engine-apps"
FILES_ti-codec-engine-apps = "${installdir}/codec-engine-apps/*"
INSANE_SKIP_ti-codec-engine-apps = True

