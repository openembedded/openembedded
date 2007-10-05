#@TYPE: Machine
#@Name: Gumstix pxa2xx boards
#@DESCRIPTION:  Gumstix pxa2xx boards

TARGET_ARCH = "arm"
PACKAGE_EXTRA_ARCHS = "armv4 armv4t armv5e armv5te "

PREFERRED_PROVIDER_virtual/kernel = "linux"
KERNEL_IMAGETYPE = "uImage"

module_autoload_pxamci = "pxamci"
module_autoload_mmc_block = "mmc_block"
module_autoload_gumstix_gadget = "gumstix_gadget"
module_autoload_g_ether = "g_ether"
module_autoload_smc91x = "smc91x"
module_autoload_smc911x = "smc911x"

UBOOT_ENTRYPOINT = "a0008000"

#Assume people have some gumstix extension boards 
MACHINE_FEATURES = "kernel26 alsa ext2 bluetooth"

EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=0x20000 --squash"

# Install all kernel modules
#MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS = "kernel-modules"

# Install only selected kernel modules, comment out line above also
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS = "kernel-module-unix \
                             kernel-module-rtc-core \
                             kernel-module-rtc-dev \
                             kernel-module-rtc-proc \
                             kernel-module-rtc-sa1100 \
                             kernel-module-rtc-sysfs \
                             kernel-module-smc91x \
                             kernel-module-gumstix-smc91x \
                             kernel-module-smc911x \
                             kernel-module-gumstix-smc911x \
                             "

# used by sysvinit_2
SERIAL_CONSOLE = "115200 ttyS0 vt100"

#don't try to access tty1
USE_VT = "0"

require conf/machine/include/tune-xscale.inc

