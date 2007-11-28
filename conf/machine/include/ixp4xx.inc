#@TYPE: Machine configuration
#@NAME: ixp4xx
#@DESCRIPTION: genric machine configuration for ixp4xx platforms

MACHINE_FEATURES = "kernel26 usbhost ext2"

ROOT_FLASH_SIZE ?= "12"

EXTRA_IMAGECMD_jffs2 = "--pad --eraseblock=0x20000 -n"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-ixp4xx"

require conf/machine/include/tune-xscale.inc
require conf/machine/include/tune-thumb.inc

#-------------------------------------------------------------------------------
# Board defaults
#-------------------------------------------------------------------------------
# These values are board specific but they seem to be common to a large number
# of boards so are reasonable defaults.
SERIAL_CONSOLE = "115200 ttyS0"
KERNEL_CONSOLE = "ttyS0,115200n8"
USE_VT = "0"
