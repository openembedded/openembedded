# Kernel for IXP4xx
#
# This bitbake file pulls patches and the defconfig straight
# from the NSLU2-Linux SVN repository. Information about this
# repository can be found at:
# http://trac.nslu2-linux.org/kernel/
#
# The revision that is pulled from SVN is specified below
IXP4XX_KERNEL_SVN_REV = "699"
#
# The directory containing the patches to be applied is
# specified below
IXP4XX_KERNEL_PATCH_DIR = "2.6.19"
#
# Increment the number below (i.e. the digits after PR) when
# the changes in SVN between revisions include changes in the
# patches applied to the kernel, rather than simply defconfig
# changes
PR = "r1.${IXP4XX_KERNEL_SVN_REV}"

require ixp4xx-kernel.inc
require ixp4xx-kernel-svnpatch.inc

SRC_URI += "file://defconfig"

SRC_URI[kernel.md5sum] = "443c265b57e87eadc0c677c3acc37e20"
SRC_URI[kernel.sha256sum] = "c2fd6bcd2b7c1b3d37d64e4d1825703792a75474830a3db7d2dc603a8d392d58"
