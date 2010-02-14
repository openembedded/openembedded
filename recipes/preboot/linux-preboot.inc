# We set PR here, since a change in the kexecboot recipe will need to get picked up by *all* the kernels:
PR = "r15"

LOGO_SIZE = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "vga", "qvga", d)}'

require ../linux/linux.inc

INITRAMFS_IMAGE = "initramfs-preboot-image"

# here we set master console on serial
CMDLINE = "console=tty1 console=ttyS0,115200n8"

PACKAGES = ""
PROVIDES = ""

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-preboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-preboot-${MACHINE}"

do_configure[depends] += "${INITRAMFS_IMAGE}:do_rootfs"

do_configure_append() {
sed -i -e /CONFIG_BLK_DEV_INITRD/d \
       -e /CONFIG_KEXEC/d \
       -e /CONFIG_INITRAMFS_SOURCE/d \
       -e /=m/d \
       -e /CONFIG_MODULES/d \
       -e /CONFIG_DEBUG_ERRORS/d \
       -e /CONFIG_DEBUG_BUGVERBOSE/d \
       -e /CONFIG_DEBUG_KERNEL/d \
       ${S}/.config

# Remove last tag appended by linux.inc (output messes screen)
sed -i -e /CONFIG_CMDLINE/s/quiet/loglevel=3/1 ${S}/.config
sed -i -e /CONFIG_CMDLINE/s/debug/loglevel=3/1 ${S}/.config

echo 'CONFIG_BLK_DEV_INITRD=y
CONFIG_KEXEC=y
CONFIG_INITRAMFS_SOURCE="initramfs.cpio.gz"
CONFIG_MODULES=n' >> ${S}/.config

        yes '' | oe_runmake oldconfig
}

do_stage() {
}

do_install() {
}

python do_package() {
}
