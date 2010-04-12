# Bitbake recipe for the madwifi-ng driver

# This recipe needs testing by other than ixp4xx distros before
# it can become the default:
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_slugos = "1"

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

SRCNAME = "madwifi-trunk"

# PR set after the include, to override what's set in the included file.
PR = "r1"

# It's not clear that we even need the wackelf patches any longer; certainly
# they are not required for ixp4xx builds.  This needs testing on pxa270.
WACKELF_SRC_URI_ixp4xx          = ""
WACKELF_SRC_URI_compulab-pxa270 = ""

# This works for EABI as well as the original OABI IXP4xx.
EXTRA_OEMAKE = "V=1 KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX}"

# We really must clear out LDFLAGS to get this to link.
do_compile() {
	unset LDFLAGS
	oe_runmake all
}
