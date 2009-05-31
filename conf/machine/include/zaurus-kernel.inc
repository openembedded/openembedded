# Zaurus common kernel settings

MACHINE_KERNEL_VERSION = "2.6"

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"
PREFERRED_PROVIDER_virtual/kernel_collie = "linux"
PREFERRED_PROVIDER_virtual/kernel_tosa = "linux"

# Increase PR everytime you change something in the kernel
MACHINE_KERNEL_PR = "r11"
MACHINE_KERNEL_PR_collie = "r8"
MACHINE_KERNEL_PR_tosa = "r4"

MACHINE_KERNEL_PR_pn-linux-kexecboot = "r13"

KERNEL_IMAGE_MAXSIZE = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"

ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"
