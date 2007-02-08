# Kernel for IXP4xx
#
# This bitbake file pulls patches and the defconfig straight
# from the NSLU2-Linux SVN repository. Information about this
# repository can be found at:
# http://trac.nslu2-linux.org/kernel/
#
# The revision that is pulled from SVN is specified below
IXP4XX_KERNEL_SVN_REV = "686"
#
# The directory containing the patches to be applied is
# specified below
IXP4XX_KERNEL_PATCH_DIR = "2.6.20"
#
# Increment the number below (i.e. the digits after PR) when
# the changes in SVN between revisions include changes in the
# patches applied to the kernel, rather than simply defconfig
# changes
PR = "r2.${IXP4XX_KERNEL_SVN_REV}"

require ixp4xx-kernel.inc
require ixp4xx-kernel-svnpatch.inc

SRC_URI += "file://defconfig"
SRC_URI += "file://series"

# Remove the specific cmdline hacking patches if we are not building for nslu2.
addtask remove_cmdline_hacks before do_patch after do_unpack
do_remove_cmdline_hacks() {

	if [ "${MACHINE}" != "nslu2" ] ; then
		sed	-e '/88-nas100d-dflt-cmdline.patch/d' \
			-e '/88-nslu2-dflt-cmdline.patch/d' \
			'${WORKDIR}/series' > '${WORKDIR}/series.new'
		mv '${WORKDIR}/series.new' '${WORKDIR}/series'
	fi

}
