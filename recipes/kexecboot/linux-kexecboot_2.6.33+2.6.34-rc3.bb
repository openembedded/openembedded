require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.34-rc3"
OLD_KERNEL_RELEASE = "2.6.33"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}"
PR = "${INC_PR}.0"

S = "${WORKDIR}/linux-${OLD_KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-${KERNEL_RELEASE}.bz2;name=patch;patch=1 \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

SRC_URI[kernel.md5sum] = "c3883760b18d50e8d78819c54d579b00"
SRC_URI[kernel.sha256sum] = "63e237de3b3c4c46a21833b9ce7e20574548d52dabbd1a8bf376041e4455d5c6"

SRC_URI[patch.md5sum] = "f8bf58920ee30d12c54e9326ef74af32"
SRC_URI[patch.sha256sum] = "c53504b595db44d888fd01982006389e06b0f7f9d2ea2f6f5087e7f7e1acda8a"
