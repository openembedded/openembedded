#@TYPE: Machine configuration
#@NAME: ixp4xx
#@DESCRIPTION: genric machine configuration for ixp4xx platforms

# Set default for nslu2 - can be overridden for machines with other features.
MACHINE_FEATURES ?= "kernel26 usbhost ext2"

# Set defaults for nslu2 - can be overridden for machines with other requirements.
MACHINE_ESSENTIAL_EXTRA_RDEPENDS    ?= "ixp4xx-npe"
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

# Set default for nslu2 - can be overridden for machines with more flash.
ROOT_FLASH_SIZE ?= "12"

# Set default for nslu2, nas100d, dsmg600
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
