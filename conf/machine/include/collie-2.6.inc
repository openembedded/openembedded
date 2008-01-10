PREFERRED_PROVIDER_virtual/kernel = "linux-rp"

SERIAL_CONSOLE = "115200 ttySA0"
MACHINE_FEATURES = "kernel26 apm pcmcia screen irda usbgadget keyboard touchscreen wifi vfat"

MACHINE_EXTRA_RDEPENDS = "kernel-modules"

MACHINE_POSTPROCESS_COMMAND = "zaurus_make_installkit"
