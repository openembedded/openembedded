DESCRIPTION = "OpenEZX 2.6 Linux Development Kernel for the Motorola EZX GSM phones"
AUTHOR = "The OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"

DEFAULT_PREFERENCE = "-1"

require linux.inc

RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

KERNEL_RELEASE = "2.6.25"
KERNEL_PATCHES = "kernel-${KERNEL_RELEASE}.x-patches"
PV = "${KERNEL_RELEASE}+svnr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KERNEL_RELEASE}.tar.bz2 \
  svn://svn.openezx.org/branches;module=${KERNEL_PATCHES};proto=http \
#  file://logo_linux_clut224.ppm \
"
S = "${WORKDIR}/linux-${KERNEL_RELEASE}"


##############################################################
# kernel image resides on a seperate flash partition (for now)
# But we can flash it from userspace (flash_unlock /dev/mtdX && flash_eraseall /dev/mtdX && flashcp /boot/zImage /dev/mtdX)
# so lets make a package of it. What about a postinst that flashes the new kernel?

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a1200|rorkre2|rokre6)'

# For now the code for serial console is disabled in compress.c
#CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 "
CMDLINE_CON = "console=tty1 "

CMDLINE_ROOT = "root=/dev/mmcblk0p2 rootfstype=ext2 rootwait=1"
CMDLINE_NFSROOT = "root=/dev/nfs rootfstype=nfs nfsroot=192.168.0.200:/export/ezx-image rootdelay=1 "
# Uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.0.202:192.168.0.200:192.168.0.200:255.255.255.0"
CMDLINE_MEM = "mem=32M@0xA0000000 mem=16M@0xAC000000"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} ${CMDLINE_MEM}"
# Uncomment to use root-over-nfs-over-usb
#CMDLINE_NFSROOT_USB = "${CMDLINE_CON} ${CMDLINE_NFSROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} ${CMDLINE_MEM}"

# 1024x1024 once was the maximum kernel size for boot-over-usb -- is it still?
#KERNEL_IMAGE_MAXSIZE = "1294336"

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_prepatch() {
        mv ${WORKDIR}/${KERNEL_PATCHES}/defconfig-${MACHINE} ${WORKDIR}/defconfig
#        mv ${WORKDIR}/defconfig-${MACHINE} ${WORKDIR}/defconfig
        mv ${WORKDIR}/${KERNEL_PATCHES} ${S}/patches && cd ${S} && quilt push -av
        mv patches patches.openezx
        mv .pc .pc.old
}

addtask prepatch after do_unpack before do_patch
