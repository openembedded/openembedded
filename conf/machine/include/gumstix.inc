#@TYPE: Machine
#@Name: Gumstix pxa2xx boards
#@DESCRIPTION:  Gumstix pxa2xx boards

# Don't edit this file unless you *really* know what you are doing!

TARGET_ARCH = "arm"

#Compile with armv5te optimizations, incompatible with armv4(t) cpus
require conf/machine/include/tune-xscale.inc


PREFERRED_PROVIDER_virtual/kernel = "gumstix-kernel"
KERNEL_IMAGETYPE = "uImage"
RDEPENDS_kernel-base = ""

KERNEL_IMAGE_MAXSIZE = "1048577"

UBOOT_ENTRYPOINT = "a0008000"

MACHINE_FEATURES += "kernel26 "

IMAGE_FSTYPES = "jffs2 tar.gz"
EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=0x20000 --squash-uids"

SERIAL_CONSOLE = "115200 ttyS0 vt100"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS =     " \
                                       "

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= " \
                                       "
