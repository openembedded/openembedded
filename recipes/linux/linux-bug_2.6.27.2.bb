DESCRIPTION = "Linux kernel for bug"

PV_append = "+svnr${SRCREV}"
KV = "2.6.27.2"
PR = "r32"

COMPATIBLE_MACHINE = "bug"

SVN_PRJ = "bug-linux-${KV}"
SRCREV = "10746"

SRC_URI = "svn://svn.buglabs.net/bug/branches/R1.4/qa;module=${SVN_PRJ};proto=svn \
           file://defconfig \
           "

S = "${WORKDIR}/${SVN_PRJ}"

ARM_KEEP_OABI ?= "0"
UBOOT_ENTRYPOINT = "0x80008000"

require linux.inc

do_install_append() {
        cd ${D}/${KERNEL_IMAGEDEST} && ln -sf uImage-${KERNEL_VERSION} uImage
}

do_stage_append() {
	cp -fR arch/arm/include/asm/* ${STAGING_KERNEL_DIR}/include/asm/
	if [ ! -e ${STAGING_KERNEL_DIR}/include/mach ]; then
		mkdir ${STAGING_KERNEL_DIR}/include/mach
	fi
	cp -fR arch/arm/plat-mxc/include/mach/* ${STAGING_KERNEL_DIR}/include/mach/
}

FILESDIR = "${WORKDIR}"
FILES_kernel-image += "${KERNEL_IMAGEDEST}/uImage*"

module_conf_g_ether = "options g_ether host_addr=46:0d:9e:67:69:eb"
module_conf_bmi_audio = "options bmi_audio output_ints=1"
module_autoload_arcotg_udc = "arcotg_udc"
module_autoload_ehci-hcd = "ehci-hcd"
module_autoload_g_ether = "g_ether"
module_autoload_bugnav = "bugnav"
module_autoload_bug_audio = "bug_audio"
module_autoload_bugpm = "bugpm"
module_autoload_bugpm_apm = "bugpm_apm"
module_autoload_rtc-isl12026 = "rtc-isl12026"
module_autoload_bug_v4l2_capture = "bug_v4l2_capture"
module_autoload_libertas_sdio = "libertas_sdio"
# bmi_lcd_core loaded to ensure xserver device nodes are created on boot.
module_autoload_bmi_lcd_core = "bmi_lcd_core"
