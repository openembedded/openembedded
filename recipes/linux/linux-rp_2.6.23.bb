require linux-rp.inc

PR = "r36"

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
#

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.23.tar.bz2;name=kernel \
	   file://0001-time-prevent-the-loop-in-timespec_add_ns-from-bei.patch;apply=yes \
           ${RPSRC}/pxa25x_suspend_fixes-r0.patch;apply=yes;status=merged;name=rppatch30 \
           ${RPSRC}/lzo_jffs2-r3.patch;apply=yes;status=merged;name=rppatch31 \
           ${RPSRC}/lzo_jffs2_lzomode-r1.patch;apply=yes;status=merged;name=rppatch32 \
           ${RPSRC}/spitzkbd_fix-r0.patch;apply=yes;status=merged;name=rppatch33 \
           file://uvesafb-0.1-rc3-2.6.22.patch;apply=yes;status=merged \
           ${RPSRC}/locomo_led_fix-r0.patch;apply=yes;status=merged;name=rppatch34 \
           file://hrw-add-wcf11-to-hostap.patch;apply=yes;status=merged \
           ${RPSRC}/export_atags-r0a.patch;apply=yes;status=pending;name=rppatch35 \
           ${RPSRC}/lzo_crypto-r2.patch;apply=yes;status=pending;name=rppatch36 \
           ${RPSRC}/lzo_jffs2_sysfs-r1.patch;apply=yes;name=rppatch1 \
           ${RPSRC}/hx2750_base-r29.patch;apply=yes;name=rppatch37 \
           ${RPSRC}/hx2750_bl-r9.patch;apply=yes;name=rppatch3 \
           ${RPSRC}/hx2750_pcmcia-r2.patch;apply=yes;name=rppatch38 \
           file://hx2750_make.patch;apply=yes;name=rppatch39 \
           ${RPSRC}/pxa_keys-r7.patch;apply=yes;name=rppatch40 \
           ${RPSRC}/tsc2101-r16.patch;apply=yes;name=rppatch41 \
           ${RPSRC}/hx2750_test1-r7.patch;apply=yes;name=rppatch42 \
           ${RPSRC}/input_power-r9.patch;apply=yes;name=rppatch43 \
           ${RPSRC}/pxa25x_cpufreq-r2.patch;apply=yes;name=rppatch44 \
           ${RPSRC}/sharpsl_pm_fixes1-r0.patch;apply=yes;name=rppatch8 \
           ${RPSRC}/pm_changes-r1.patch;apply=yes;name=rppatch9 \
           ${RPSRC}/usb_add_epalloc-r3.patch;apply=yes;name=rppatch45 \
           ${RPSRC}/usb_pxa27x_udc-r6.patch;apply=yes;name=rppatch46 \
           ${RPSRC}/locomo_kbd_tweak-r1.patch;apply=yes;name=rppatch47 \
           ${RPSRC}/pxa27x_overlay-r6.patch;apply=yes;name=rppatch48 \
           ${RPSRC}/w100_extaccel-r2.patch;apply=yes;name=rppatch12 \
           ${RPSRC}/w100_extmem-r1.patch;apply=yes;name=rppatch13 \
           ${RPSRC}/poodle_pm-r4.patch;apply=yes;name=rppatch49 \
           ${RPSRC}/poodle_lcd_hack-r0.patch;apply=yes;name=rppatch15 \
           ${RPSRC}/poodle_asoc_fix-r1.patch;apply=yes;name=rppatch16 \
           file://wm8750-treble.patch;apply=yes \
           file://mtd-module.patch;apply=yes \
           file://squashfs3.0-2.6.15.patch;apply=yes;status=external \
           ${RPSRC}/logo_oh-r1.patch.bz2;apply=yes;status=unmergable;name=rppatch17 \
           ${RPSRC}/pxa-linking-bug.patch;apply=yes;status=unmergable;name=rppatch18 \
           file://hostap-monitor-mode.patch;apply=yes;status=unmergable \
           file://serial-add-support-for-non-standard-xtals-to-16c950-driver.patch;apply=yes;status=unmergable \
           ${RPSRC}/mmcsd_large_cards-r1.patch;apply=yes;status=hack;name=rppatch19 \
           ${RPSRC}/mmcsd_no_scr_check-r2.patch;apply=yes;status=hack;name=rppatch20 \
           ${RPSRC}/integrator_rgb-r1.patch;apply=yes;status=hack;name=rppatch21 \
           ${RPSRC}/pxa_cf_initorder_hack-r1.patch;apply=yes;status=hack;name=rppatch22 \
           file://pxa-serial-hack.patch;apply=yes;status=hack \
           file://connectplus-remove-ide-HACK.patch;apply=yes;status=hack \
           file://connectplus-prevent-oops-HACK.patch;apply=yes;status=hack \
           file://htcuni.patch;apply=yes \
           file://binutils-buildid-arm.patch;apply=yes \
           file://versatile-armv6.patch;apply=yes \
           file://defconfig-c7x0 \
           file://defconfig-hx2000 \
           file://defconfig-collie \
           file://defconfig-poodle \
           file://defconfig-akita \
           file://defconfig-spitz \
           file://defconfig-qemuarm \
           file://defconfig-qemux86 \
           file://defconfig-bootcdx86 \
           file://defconfig-htcuniversal \
           file://defconfig-zylonite \
           file://defconfig-tosa "

# FIXMEs before made default	   
# ${RPSRC}/mmcsd_no_scr_check-r1.patch;apply=yes;status=hack;name=rppatch50

# Add this to enable pm debug code (useful with a serial lead)
#  ${RPSRC}/sharpsl_pm_debug-r0.patch;apply=yes;name=rppatch51

# Disabled until I find the reason this gives issues with cdc_subset
#            ${RPSRC}/usb_rndis_tweaks-r0.patch;apply=yes;name=rppatch52 \

# Is anything out of this still needed? Parts were commited to mainline by rmk (drivers/mfd/)
# (Pavel Machek's git tree has updated versions of this?)
#  ${JLSRC}/zaurus-lcd-2.6.11.diff.gz;apply=yes;name=jlpatch1

# These patches are extracted from Pavel Machek's git tree
# (diff against vanilla kernel)
SRC_URI_append_collie = "\
           ${DOSRC}/collie/mtd-sharp-flash-hack-r0.patch;apply=yes;name=dopatch1 \
           ${DOSRC}/collie/collie-r0.patch;apply=yes;name=dopatch2 \
           ${DOSRC}/collie/locomolcd-backlight-r0.patch;apply=yes;name=dopatch3 \
           ${DOSRC}/collie/ucb1x00-touch-audio-r0.patch;apply=yes;name=dopatch4 \
           file://collie-mcp-r1.patch;apply=yes \
           ${DOSRC}/collie/sa1100-udc-r0.patch;apply=yes;name=dopatch5 \
#          ${DOSRC}/collie/collie-pm-r1.patch;apply=yes;name=dopatch6 \
"

SRC_URI_append_poodle = "\
           ${RPSRC}/poodle_serial_vcc-r0.patch;apply=yes;name=rppatch53 \
"

SRC_URI_append_tosa = "\
           ${CHSRC}/tmio-core-r4.patch;apply=yes;name=chpatch1 \
           file://tmio-tc6393-r8.patch;apply=yes \
           file://tmio-nand-r8.patch;apply=yes \
           ${CHSRC}/tmio-fb-r6.patch;apply=yes;name=chpatch2 \
	   file://tmio-fb-r6-fix-r0.patch;apply=yes \
           file://tosa-keyboard-r19.patch;apply=yes \
           ${DOSRC}/tosa-pxaac97-r6.patch;apply=yes;name=dopatch7 \
	   file://tosa-pxaac97-r6-fix-r0.patch;apply=yes \
           ${DOSRC}/tosa-tmio-r6.patch;apply=yes;name=dopatch8 \
           file://tosa-power-r18.patch;apply=yes \
           file://tosa-power-r18-fix-r0.patch;apply=yes \
           file://tosa-tmio-lcd-r10.patch;apply=yes \
           file://tosa-tmio-lcd-r10-fix-r0.patch;apply=yes \
           file://tosa-bluetooth-r8.patch;apply=yes \
           file://wm97xx-lg13-r0.patch;apply=yes \
           file://wm97xx-lg13-r0-fix-r0.patch;apply=yes \
           file://wm9712-suspend-cold-res-r2.patch;apply=yes \
           file://sharpsl-pm-postresume-r1.patch;apply=yes \
           file://wm9712-reset-loop-r2.patch;apply=yes \
           file://tosa-lcdnoise-r1.patch;apply=yes \
           file://tosa-lcdnoise-r1-fix-r0.patch;apply=yes \
	   file://arm-dma-coherent.patch;apply=yes \
           file://usb-ohci-hooks-r3.patch;apply=yes \
           file://tmio-ohci-r9.patch;apply=yes \
           file://pxa2xx_udc_support_inverse_vbus.patch;apply=yes \
           file://tosa_udc_use_gpio_vbus.patch;apply=yes \
           "
#          ${DOSRC}/tosa-asoc-r1.patch;apply=yes;name=dopatch9 "

SRC_URI_append_akita = "\
           file://sharpsl-rc-r1.patch;apply=yes;status=external \
           "

SRC_URI_append_spitz = "\
           file://sharpsl-rc-r1.patch;apply=yes;status=external \
           "

SRC_URI_append_htcuniversal ="\
	file://htcuni-acx.patch;apply=yes;status=external \
	"

SRC_URI_append_zylonite ="\
	file://arm_pxa_20070923.patch;apply=yes \
	file://pxa_fb_overlay.patch;apply=yes \
	file://zylonite-boot.patch;apply=yes \
	file://zylonite_mtd-r0.patch;apply=yes \
	file://zylonite_touch-r0.patch;apply=yes \
	file://zylonite_keypad-r0.patch;apply=yes \
	"

S = "${WORKDIR}/linux-2.6.23"

SRC_URI[kernel.md5sum] = "2cc2fd4d521dc5d7cfce0d8a9d1b3472"
SRC_URI[kernel.sha256sum] = "d4e67c0935ffb2a4158234bff92cc791b83177866009fc9b2214104e0038dbdb"
