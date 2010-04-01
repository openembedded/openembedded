# linux-ixp4xx.inc
#
DESCRIPTION = "Linux 2.6.x kernel for IXP4xx devices"
SRCREV = "1089"

COMPATIBLE_HOST = 'arm.*-linux.*'
COMPATIBLE_MACHINE = '(ixp4xx|nslu2|syhl1)'

# To specify the console set KERNEL_CONSOLE in the .bb file.

# CMDLINE_ROOT: machine specific boot options - should not be set on a
#  generic kernel!
CMDLINE_ROOT ?= ""

# CMDLINE_DEBUG: debug options such as noirqdebug, defaults to empty
# override in local.conf etc
CMDLINE_DEBUG ?= ""

CMDLINE  = "${CMDLINE_ROOT}"
CMDLINE += "${CMDLINE_DEBUG}"
CMDLINE += "${CMDLINE_CONSOLE}"

# Kernel module dependencies
# (according to hrw, these should go in kernel.bbclass)

DEPENDS_kernel-module-zd1211rw  += "zd1211-firmware"
RDEPENDS_kernel-module-zd1211rw += "zd1211-firmware"
