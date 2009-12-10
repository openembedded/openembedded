DESCRIPTION = "DVSDK Demo applications for TI ARM/DSP processors"

DEPENDS += "ti-dmai"
DEPENDS += "alsa-lib libpng freetype jpeg"

SRC_URI = "${BASE_SRC_URI}/dvsdk_demos_${PV}.tar.gz "

S = "${WORKDIR}/dvsdk_demos_${PV}"

inherit module-base
require ti-multimedia-common.inc

# Should go into machine config
TARGET           ?= "all"
TARGET_dm355 ?= "dm355"
TARGET_dm365-evm ?= "dm365"

VERBOSE = "true"

do_compile () {
        cd ${S}
        make -e clean
        make -e ${PLATFORM}
}
do_install () {
        cd ${S}
        make -e ${TARGET} EXEC_DIR=${D}/${installdir}/dvsdk-demos install
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_ti-dvsdk-demos_dm355 += "ti-dm355mm-module ti-linuxutils alsa-lib libpng freetype jpeg"
RDEPENDS_ti-dvsdk-demos_dm365-evm += "ti-dm365mm-module ti-linuxutils alsa-lib libpng freetype jpeg"

FILES_${PN} = "${installdir}/dvsdk-demos/*"


BASE_SRC_URI ?= "http://install.source.dir.local"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "True"
