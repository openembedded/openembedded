PREFERRED_PROVIDER_virtual/kernel = "openzaurus-sa"
COLLIE_MEMORY_SIZE ?= "64"

# workaround for bug 1877
PREFERRED_PROVIDER_hostap-modules = "hostap-modules"

SERIAL_CONSOLE = "115200 ttyS0"
#
# no keyboard feature because 2.4 kernel keymap works ok and we have limited flash
# no usbgadget feature because 2.4 kernel handle it in own way on each machine
#
MACHINE_FEATURES = "kernel24 apm pcmcia screen irda"

MACHINE_EXTRA_RRECOMMENDS = "kernel-module-net-fd kernel-module-sa1100-bi \
                             kernel-module-usbdcore kernel-module-usbdmonitor \
                             sharp-sdmmc-support"

# kernel-module-collie-ssp kernel-module-collie-tc35143af if buzzer.patch applied

# Later versions are broken on kernel 2.4
PREFERRED_VERSION_orinoco-modules = "0.13e"
