require linux-kexecboot.inc
require ../linux/linux-rp.checksums.inc

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_qemuarm = "-1"
DEFAULT_PREFERENCE_qemux86 = "-1"
DEFAULT_PREFERENCE_spitz = "1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_c7x0 = "1"
DEFAULT_PREFERENCE_akita = "1"

# Handy URLs
# git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;tag=ef7d1b244fa6c94fb76d5f787b8629df64ea4046
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-2.6.20-rc4.tar.bz2
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.18-rc6.bz2;apply=yes
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/snapshots/patch-2.6.18-rc2-git1.bz2;apply=yes
# ${KERNELORG_MIRROR}/pub/linux/kernel/people/alan/linux-2.6/2.6.10/patch-2.6.10-ac8.gz;apply=yes
# ${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/2.6/2.6.14-rc2/2.6.14-rc2-mm1/2.6.14-rc2-mm1.bz2;apply=yes

# Patches submitted upstream are towards top of this list 
# Hacks should clearly named and at the bottom
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.26.tar.bz2;name=kernel \
           ${RPSRC}/lzo_jffs2_sysfs-r1.patch;apply=yes;name=rppatch1 \
           ${RPSRC}/hx2750_base-r34.patch;apply=yes;name=rppatch2 \
           ${RPSRC}/hx2750_bl-r9.patch;apply=yes;name=rppatch3 \
           ${RPSRC}/hx2750_pcmcia-r3.patch;apply=yes;name=rppatch4 \
           ${RPSRC}/pxa_keys-r9.patch;apply=yes;name=rppatch5 \
           ${RPSRC}/tsc2101-r19.patch;apply=yes;name=rppatch6 \
           ${RPSRC}/hx2750_test1-r8.patch;apply=yes;name=rppatch7 \
           ${RPSRC}/sharpsl_pm_fixes1-r0.patch;apply=yes;name=rppatch8 \
           ${RPSRC}/pm_changes-r1.patch;apply=yes;name=rppatch9 \
           ${RPSRC}/locomo_kbd_tweak-r2.patch;apply=yes;name=rppatch10 \
#           ${RPSRC}/pxa27x_overlay-r8.patch;apply=yes;name=rppatch11 \
           ${RPSRC}/w100_extaccel-r2.patch;apply=yes;name=rppatch12 \
           ${RPSRC}/w100_extmem-r1.patch;apply=yes;name=rppatch13 \
           ${RPSRC}/poodle_pm-r6.patch;apply=yes;name=rppatch14 \
           ${RPSRC}/poodle_lcd_hack-r0.patch;apply=yes;name=rppatch15 \
           ${RPSRC}/poodle_asoc_fix-r1.patch;apply=yes;name=rppatch16 \
           file://zaurus-i2c-init.patch;apply=yes;status=upstream \
#           ${RPSRC}/logo_oh-r1.patch.bz2;apply=yes;status=unmergable;name=rppatch17 \
           ${RPSRC}/pxa-linking-bug.patch;apply=yes;status=unmergable;name=rppatch18 \
           file://hostap-monitor-mode.patch;apply=yes;status=unmergable \
           file://serial-add-support-for-non-standard-xtals-to-16c950-driver.patch;apply=yes;status=unmergable \
           ${RPSRC}/mmcsd_large_cards-r1.patch;apply=yes;status=hack;name=rppatch19 \
           ${RPSRC}/mmcsd_no_scr_check-r2.patch;apply=yes;status=hack;name=rppatch20 \
           ${RPSRC}/integrator_rgb-r1.patch;apply=yes;status=hack;name=rppatch21 \
           ${RPSRC}/pxa_cf_initorder_hack-r1.patch;apply=yes;status=hack;name=rppatch22 \
           file://sharpsl-rc-r1.patch;apply=yes \
           file://spitz_h_rewrite.patch;apply=yes \
           file://pxa-serial-hack.patch;apply=yes;status=hack \
           file://connectplus-remove-ide-HACK.patch;apply=yes;status=hack \
           file://connectplus-prevent-oops-HACK.patch;apply=yes;status=hack \
           file://htcuni.patch;apply=yes \
           file://versatile-armv6.patch;apply=yes \
           file://defconfig"

# FIXMEs before made default	   
# ${RPSRC}/mmcsd_no_scr_check-r1.patch;apply=yes;status=hack;name=rppatch50


# Add this to enable pm debug code (useful with a serial lead)
#  ${RPSRC}/sharpsl_pm_debug-r0.patch;apply=yes;name=rppatch51

# Disabled until I find the reason this gives issues with cdc_subset
#            ${RPSRC}/usb_rndis_tweaks-r0.patch;apply=yes;name=rppatch52 \


SRC_URI_append_collie = "\
	file://collie.patch;apply=yes \
	file://collie_keymap.patch;apply=yes \
"

SRC_URI_append_htcuniversal ="\
	file://htcuni-acx.patch;apply=yes;status=external \
	"

SRC_URI_append_zylonite ="\
	file://pxa_fb_overlay.patch;apply=yes \
	file://zylonite-boot.patch;apply=yes \
	file://zylonite_mtd-r0.patch;apply=yes \
	file://zylonite_touch-r0.patch;apply=yes \
	file://zylonite_keypad-r0.patch;apply=yes \
	"

S = "${WORKDIR}/linux-2.6.26"

SRC_URI[kernel.md5sum] = "5169d01c405bc3f866c59338e217968c"
SRC_URI[kernel.sha256sum] = "666488e2511393fdb901eaf1e67275bcc38ab37c930e8a9adb290a95c1721a2a"
