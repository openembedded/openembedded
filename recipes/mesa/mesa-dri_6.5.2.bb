include mesa-common-old.inc

SRC_URI += " file://mklib-cross.patch;patch=1"

FILESPATH = "${FILE_DIRNAME}/mesa-${PV}:${FILE_DIRNAME}/files:${FILE_DIRNAME}"

PACKAGES_DYNAMIC = "mesa-dri-driver-*"

PR = "${INC_PR}.0"

DEPENDS += "libdrm"
# DRI is useless without the kernel drivers
RRECOMMENDS += " kernel-module-drm kernel-module-radeon "

do_configure() {
	cd configs

	ln -sf linux-dri current
	sed -e "s%CC *= *.*%CC = ${CC}%" -i current
	sed -e "s%CXX *= *.*%CXX = ${CXX}%" -i current
	sed -e "s%LD *= *.*%LD = ${LD}%" -i current
	sed -e "s%OPT_FLAGS *= *.*%OPT_FLAGS = ${TARGET_CFLAGS}%" -i current
	sed -e "s%X11_INCLUDES *= *.*%X11_INCLUDES = -I${STAGING_INCDIR}/X11%" -i current
	sed -e "s%EXTRA_LIB_PATH *= *.*%EXTRA_LIB_PATH = ${LDFLAGS}%" -i current
	sed -i s:\$\(CC\):gcc:g  ../src/mesa/x86/Makefile
	echo "SRC_DIRS = mesa" >> current
	echo "DRI_DRIVER_INSTALL_DIR = ${D}${libdir}/dri" >> current
}

do_install() {
	oe_runmake -C src/mesa/drivers/dri install
}

FILES_${PN}-dbg += "${libdir}/dri/.debug"

python populate_packages_prepend () {
        import re, os.path

        do_split_packages(d, root=bb.data.expand('${libdir}/dri', d), file_regex='(.*)_dri\.so', output_pattern='mesa-dri-driver-%s', description='%s DRI driver', extra_depends='')
}


SRC_URI[md5sum] = "e4d894181f1859651658b3704633e10d"
SRC_URI[sha256sum] = "137f50a30461d51eb9af5aac737bc788d536354cf47b26129b97bde6e41fb85f"
