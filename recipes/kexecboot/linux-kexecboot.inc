# We set PR here, since a change in the kexecboot recipe will need to get picked up by *all* the kernels:
PR = "r16"

SRC_URI = "file://defconfig"

LOGO_SIZE = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "vga", "qvga", d)}'
SRC_URI += "file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2"

require ../linux/linux.inc

DONT_CHECK_KERNELSIZE = ""
INITRAMFS_IMAGE = "initramfs-kexecboot-image"

# here we set master console on serial
CMDLINE = "console=tty1 console=ttyS0,115200n8"
CMDLINE_poodle = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_akita = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_collie = "console=tty1 console=ttySA0,115200n8 fbcon=rotate:1 mem=64M"
CMDLINE_spitz = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_hx4700 = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"

PACKAGES = ""
PROVIDES = ""

DOSRC = "http://www.do13.de/openzaurus/patches"
JLSRC = "http://www.cs.wisc.edu/~lenz/zaurus/files"
BASRC = "http://www.orca.cx/zaurus/patches"
CHSRC = "http://oz.drigon.com/patches"
TKSRC = "http://www.informatik.hu-berlin.de/~tkunze/zaurus/patches"

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}"

#
# default lzma compressor for kernels >= 2.6.30
INITRAMFS_COMPRESSION = '${@base_version_less_or_equal("PV", "2.6.30", "", "CONFIG_INITRAMFS_COMPRESSION_LZMA=y", d)}'
INITRAMFS_COMPRESSION_SUFFIX = '${@base_version_less_or_equal("PV", "2.6.30", "gz", "lzma", d)}'

do_configure[depends] += "${INITRAMFS_IMAGE}:do_rootfs"

do_configure_append() {
sed -i -e /CONFIG_BLK_DEV_INITRD/d \
       -e /CONFIG_KEXEC/d \
       -e /CONFIG_INITRAMFS_SOURCE/d \
       -e /CONFIG_INITRAMFS_COMPRESSION/d \
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
${INITRAMFS_COMPRESSION}
CONFIG_INITRAMFS_SOURCE="initramfs.cpio.${INITRAMFS_COMPRESSION_SUFFIX}"
CONFIG_MODULES=n' >> ${S}/.config

        yes '' | oe_runmake oldconfig
}

do_stage() {
}

do_install() {
}

python do_package() {
}
