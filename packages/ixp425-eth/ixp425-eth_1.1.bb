DEPENDS = "ixp4xx-csr patcher-native"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SRC_URI = "http://www.intel.com/design/network/swsup/ixp400LinuxEthernetDriverPatch-1_1.zip \
	   http://nslu.sourceforge.net/downloads/ixp425_eth.c.patch \
	   file://makefile.patch;patch=1 \
	   file://ethhdr.patch;patch=1 \
	   file://intdriven.patch;patch=1 \
	   file://pollcontroller.patch;patch=1 \
	   file://mm4.patch;patch=1"
PR = "r7"

S = "${WORKDIR}"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_ARCH} -mno-thumb-interwork"
# KERNEL_LD +=

#do_ixp425_c_patch_fetch () {
#	if test ! -e ${DL_DIR}/ixp425_eth.c.patch.md5; then
#		cd ${DL_DIR}
#		wget -Oixp425_eth.c.patch http://sourceforge.net/tracker/download.php?group_id=74209\&atid=544386\&file_id=90129\&aid=970193
#		md5sum > ixp425_eth.c.patch.md5
#	fi
#}
#
#addtask ixp425_c_patch_fetch after do_fetch before do_unpack

#do_ixp425_c_patch_unpack () {
#	install -m 0644 ${DL_DIR}/ixp425_eth.c.patch ${WORKDIR}/
#}

#addtask ixp425_c_patch_unpack after do_unpack before do_pre_patch

do_pre_patch () {
	patcher -p 0 -i ixp425_eth_1_1_update_nf_bridge.patch
	patcher -f -p 0 -i ixp425_eth.c.patch
}

addtask pre_patch before do_patch

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake 'KDIR=${STAGING_KERNEL_DIR}' \
		   'CC=${KERNEL_CC}' \
		   'LD=${KERNEL_LD}' \
		   'EXTRA_CFLAGS=-I${STAGING_INCDIR}/linux/ixp4xx-csr -I${STAGING_KERNEL_DIR}/include'
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
	install -m 0644 ixp425_eth.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
}
