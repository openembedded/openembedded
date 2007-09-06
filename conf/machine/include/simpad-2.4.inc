PREFERRED_PROVIDER_virtual/kernel = "opensimpad-64+0"

MACHINE_FEATURES_append = "kernel24"
MACHINE_EXTRA_RRECOMMENDS = " kernel-module-sa1100-ir \
	kernel-module-sa1100usb-core kernel-module-usb-eth \
	kernel-module-pcnet-cs kernel-module-8390 "

USE_DEVFS = "1"

PREFERRED_PROVIDER_hostap-modules = "hostap-modules"

# Later versions are broken on kernel 2.4
PREFERRED_VERSION_orinoco-modules = "0.13e"

