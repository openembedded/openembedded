# We set INC_PR here, since a change in the kexecboot recipe will need to get picked up by *all* the kernels:
INC_PR = "r31"

inherit kernel siteinfo

# Additional Sources for 2.6.24 and 2.6.26
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"
TKSRC = "http://www.informatik.hu-berlin.de/~tkunze/zaurus/patches"

# Kernel bootlogo is distro-specific (default is OE logo).
# Logo resolution (qvga, vga, ...) is machine-specific.
LOGO_SIZE ?= "."
SRC_URI = "file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2"

# Set the verbosity of kernel messages during runtime
# You can define CMDLINE_DEBUG in your local.conf or distro.conf to override this behaviour..
CMDLINE_DEBUG ?= '${@base_conditional("DISTRO_TYPE", "release", "loglevel=3", "debug", d)}'

# Note how we set master console on serial to protect bootlogo.
CMDLINE_c7x0 = "console=tty1 console=ttyS0,115200n8 ${CMDLINE_DEBUG}"
CMDLINE_tosa = "console=tty1 console=ttyS0,115200n8 ${CMDLINE_DEBUG}"
CMDLINE_poodle = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_akita = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_collie = "console=tty1 console=ttySA0,115200n8 fbcon=rotate:1 mem=64M ${CMDLINE_DEBUG}"
CMDLINE_spitz = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_hx4700 = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_ben-nanonote = "console=tty0 console=ttyS0,57600n8 mem=32M ${CMDLINE_DEBUG}"

PACKAGES = ""
PROVIDES = ""

# Zaurus machines need kernel size-check
KERNEL_IMAGE_MAXSIZE_akita = "1294336"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"
KERNEL_IMAGE_MAXSIZE_poodle = "1294336"
KERNEL_IMAGE_MAXSIZE_tosa = "1294336"
KERNEL_IMAGE_MAXSIZE_spitz = "1294336"

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}"

LOCALVERSION ?= ""

# we want the smallest size
INITRAMFS_IMAGE = "initramfs-kexecboot-klibc-image"

# use custom function until base_version_less_or_equal is fixed
#
def kernel_version_less_or_equal(variable, checkvalue, truevalue, falsevalue, d):
    from bb import utils
    result = bb.utils.vercmp_part(bb.data.getVar(variable,d,True), checkvalue)
    if result <= 0:
        return truevalue
    else:
        return falsevalue

# force lzma compression for kernel (linux-kexecboot >= 2.6.32)
# force lzma compression for initramfs (linux-kexecboot >= 2.6.30)
DEPENDS += '${@kernel_version_less_or_equal("PV", "2.6.29", "", "lzma-native", d)}'

KERNEL_COMPRESSION = '${@kernel_version_less_or_equal("PV", "2.6.31", "", "CONFIG_KERNEL_LZMA=y", d)}'

INITRAMFS_COMPRESSION = '${@kernel_version_less_or_equal("PV", "2.6.29", "", "CONFIG_INITRAMFS_COMPRESSION_LZMA=y", d)}'
INITRAMFS_COMPRESSION_SUFFIX = '${@kernel_version_less_or_equal("PV", "2.6.29", "gz", "lzma", d)}'
RD_COMPRESSION = '${@kernel_version_less_or_equal("PV", "2.6.29", "", "CONFIG_RD_LZMA=y", d)}'

do_configure_prepend() {

        # Rename getline in ./scripts/unifdef.c
        # Kernels up to 2.6.29 are currently failing to build unifdef.c,
        # clashing with exposed getline() from <stdio.h>
        # see https://patchwork.kernel.org/patch/11166/
        # committed in 2.6.29 (commit d15bd1067b1fcb2b7250d22bc0c7c7fea0b759f7)

        if [ -e ${S}/scripts/unifdef.c ]; then
                sed -i -e 's/getline/parseline/g' ${S}/scripts/unifdef.c
        fi

        echo "" > ${S}/.config

        echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

        #
        # endian support
        #
        if [ "${SITEINFO_ENDIANNESS}" = "be" ]; then
                echo "CONFIG_CPU_BIG_ENDIAN=y"          >> ${S}/.config
        fi

        #
        # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it is going to be used
        #
        if [ -e ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm ]; then
                install -m 0644 ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm
                echo "CONFIG_LOGO=y"                    >> ${S}/.config
                echo "CONFIG_LOGO_LINUX_CLUT224=y"      >> ${S}/.config
        fi

        # When enabling thumb for userspace we also need thumb support in the kernel
        if [ "${ARM_INSTRUCTION_SET}" = "thumb" ] ; then
            sed -i -e /CONFIG_ARM_THUMB/d ${WORKDIR}/defconfig 
            echo "CONFIG_ARM_THUMB=y" >> ${S}/.config
        fi

        sed -e '/CONFIG_CMDLINE=/d' \
            -e '/CONFIG_CPU_BIG_ENDIAN/d' \
            -e '/CONFIG_LOGO=/d' \
            -e '/CONFIG_LOGO_LINUX_CLUT224=/d' \
            -e '/CONFIG_LOCALVERSION/d' \
            -e '/CONFIG_LOCALVERSION_AUTO/d' \
            < '${WORKDIR}/defconfig' >>'${S}/.config'

        echo 'CONFIG_LOCALVERSION="${LOCALVERSION}"' >>${S}/.config
        echo '# CONFIG_LOCALVERSION_AUTO is not set' >>${S}/.config

        # Force sane defaults for kexec-enabled kernels and keep size small
        sed -i -e /CONFIG_BLK_DEV_INITRD/d \
               -e /CONFIG_KEXEC/d \
               -e /CONFIG_KERNEL/d \
               -e /CONFIG_INITRAMFS_COMPRESSION/d \
               -e /CONFIG_INITRAMFS_SOURCE/d \
               -e /CONFIG_RD/d \
               -e /=m/d \
               -e /CONFIG_MODULES/d \
               -e /CONFIG_DEBUG_ERRORS/d \
               -e /CONFIG_DEBUG_BUGVERBOSE/d \
               -e /CONFIG_DEBUG_KERNEL/d \
               ${S}/.config

               echo 'CONFIG_BLK_DEV_INITRD=y' >>${S}/.config
               echo 'CONFIG_KEXEC=y' >>${S}/.config
               echo '${KERNEL_COMPRESSION}' >>${S}/.config
               echo '"${INITRAMFS_COMPRESSION}"' >>${S}/.config
               echo 'CONFIG_INITRAMFS_SOURCE="initramfs.cpio.${INITRAMFS_COMPRESSION_SUFFIX}"' >>${S}/.config
               echo '"${RD_COMPRESSION}"' >>${S}/.config
               echo 'CONFIG_MODULES=n' >> ${S}/.config

        yes '' | oe_runmake oldconfig
}

do_populate_sysroot() {
}

do_install() {
}

python do_package() {
}


# With 2.6.37 mips has no uImage target upstream.
# use custom task in the meantime

do_uboot_mkimage_ben-nanonote() {
        cd ${S}
        kernel_entry=`nm vmlinux | grep " kernel_entry" | cut -d' ' -f1`

        cd ${S}/arch/mips/boot
        rm -f vmlinux.bin.gz
        gzip -c9 vmlinux.bin > vmlinux.bin.gz

        mkimage -A mips -O linux -T kernel -C gzip -a 0x80010000 -e 0x${kernel_entry} \
        -n 'MIPS' -d vmlinux.bin.gz uImage-kexecboot-${PV}-${PR}-${MACHINE}.bin

        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 uImage-kexecboot-${PV}-${PR}-${MACHINE}.bin ${DEPLOY_DIR_IMAGE}
}
