require linux-kexecboot.inc

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
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.18-rc6.bz2;patch=1
# ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/snapshots/patch-2.6.18-rc2-git1.bz2;patch=1
# ${KERNELORG_MIRROR}/pub/linux/kernel/people/alan/linux-2.6/2.6.10/patch-2.6.10-ac8.gz;patch=1
# ${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/2.6/2.6.14-rc2/2.6.14-rc2-mm1/2.6.14-rc2-mm1.bz2;patch=1

# Patches submitted upstream are towards top of this list 
# Hacks should clearly named and at the bottom
SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.26.tar.bz2 \
           ${RPSRC}/lzo_jffs2_sysfs-r1.patch;patch=1 \
           ${RPSRC}/hx2750_base-r34.patch;patch=1 \
           ${RPSRC}/hx2750_bl-r9.patch;patch=1 \
           ${RPSRC}/hx2750_pcmcia-r3.patch;patch=1 \
           ${RPSRC}/pxa_keys-r9.patch;patch=1 \
           ${RPSRC}/tsc2101-r19.patch;patch=1 \
           ${RPSRC}/hx2750_test1-r8.patch;patch=1 \
           ${RPSRC}/sharpsl_pm_fixes1-r0.patch;patch=1 \
           ${RPSRC}/pm_changes-r1.patch;patch=1 \
           ${RPSRC}/locomo_kbd_tweak-r2.patch;patch=1 \
#           ${RPSRC}/pxa27x_overlay-r8.patch;patch=1 \
           ${RPSRC}/w100_extaccel-r2.patch;patch=1 \
           ${RPSRC}/w100_extmem-r1.patch;patch=1 \
           ${RPSRC}/poodle_pm-r6.patch;patch=1 \
           ${RPSRC}/poodle_lcd_hack-r0.patch;patch=1 \
           ${RPSRC}/poodle_asoc_fix-r1.patch;patch=1 \
           file://zaurus-i2c-init.patch;patch=1;status=upstream \
#           ${RPSRC}/logo_oh-r1.patch.bz2;patch=1;status=unmergable \
           ${RPSRC}/pxa-linking-bug.patch;patch=1;status=unmergable \
           file://hostap-monitor-mode.patch;patch=1;status=unmergable \
           file://serial-add-support-for-non-standard-xtals-to-16c950-driver.patch;patch=1;status=unmergable \
           ${RPSRC}/mmcsd_large_cards-r1.patch;patch=1;status=hack \
           ${RPSRC}/mmcsd_no_scr_check-r2.patch;patch=1;status=hack \
           ${RPSRC}/integrator_rgb-r1.patch;patch=1;status=hack \
           ${RPSRC}/pxa_cf_initorder_hack-r1.patch;patch=1;status=hack \
           file://sharpsl-rc-r1.patch;patch=1 \
           file://spitz_h_rewrite.patch;patch=1 \
           file://pxa-serial-hack.patch;patch=1;status=hack \
           file://connectplus-remove-ide-HACK.patch;patch=1;status=hack \
           file://connectplus-prevent-oops-HACK.patch;patch=1;status=hack \
           file://htcuni.patch;patch=1 \
           file://versatile-armv6.patch;patch=1 \
           file://defconfig"

# FIXMEs before made default	   
# ${RPSRC}/mmcsd_no_scr_check-r1.patch;patch=1;status=hack


# Add this to enable pm debug code (useful with a serial lead)
#  ${RPSRC}/sharpsl_pm_debug-r0.patch;patch=1

# Disabled until I find the reason this gives issues with cdc_subset
#            ${RPSRC}/usb_rndis_tweaks-r0.patch;patch=1 \


SRC_URI_append_collie = "\
	file://collie.patch;patch=1 \
	file://collie_keymap.patch;patch=1 \
"

SRC_URI_append_htcuniversal ="\
	file://htcuni-acx.patch;patch=1;status=external \
	"

SRC_URI_append_zylonite ="\
	file://pxa_fb_overlay.patch;patch=1 \
	file://zylonite-boot.patch;patch=1 \
	file://zylonite_mtd-r0.patch;patch=1 \
	file://zylonite_touch-r0.patch;patch=1 \
	file://zylonite_keypad-r0.patch;patch=1 \
	"

S = "${WORKDIR}/linux-2.6.26"

SRC_URI[md5sum] = "5169d01c405bc3f866c59338e217968c"
SRC_URI[sha256sum] = "666488e2511393fdb901eaf1e67275bcc38ab37c930e8a9adb290a95c1721a2a"
SRC_URI[md5sum] = "a8b75ef4190dfc0afcfa8789d3e4c64c"
SRC_URI[sha256sum] = "3fed945b590db46a902fa434054b967dd1bf4af1ee5f5643e00d1d66a9d69543"
SRC_URI[md5sum] = "38e1ea5768cba4be72088a8a12d4b1af"
SRC_URI[sha256sum] = "837b95b128815f3d6689d2ecfbdc9a28023bae5f45879513f3b4c2ad12f459ee"
SRC_URI[md5sum] = "ebb78f58e9c84c73b90e9cbdde5f89d6"
SRC_URI[sha256sum] = "7578448fc2adbfc820158b2467dbb127ab012b3a97ad95366d8d1af002defbce"
SRC_URI[md5sum] = "896d3e29ab5715b7558b972fba626425"
SRC_URI[sha256sum] = "29f21117a17f945783f2eee5d5c89e10959fed44ac423ad9809d6afc0db5996c"
SRC_URI[md5sum] = "c1358d4c210d1d701b5b0d96d8e73c12"
SRC_URI[sha256sum] = "8697e76beb6ea44ce450e8cb9bed764803fe189eaea89e0aa72ebd1974bc52e4"
SRC_URI[md5sum] = "c70fa3e0184842e4f6822b7002eac33e"
SRC_URI[sha256sum] = "7ca39d0df0a102114eabcd39df94ff271d81a71d9ef9f61915ac0a04031b68d1"
SRC_URI[md5sum] = "33eed5a26b2776508500532c07956dc4"
SRC_URI[sha256sum] = "a93c7f0caa8e212a4515ce209918e250e80d2643317732d707d4f25649457545"
SRC_URI[md5sum] = "aeea5a2614fd8f9ae7d729d1ea1dddba"
SRC_URI[sha256sum] = "1bd129c7a68537533c77267992eaf490ff64bcc3d01c6f4b51343b8f266ae99e"
SRC_URI[md5sum] = "e10058b52841d138630b69b954bea0b9"
SRC_URI[sha256sum] = "779561c658ccb190f3a2cd7626e4a229834c5f9b093be8f7a06bbfaf12121b9c"
SRC_URI[md5sum] = "c51ae4d5fa800ec81660fdf5b776fae6"
SRC_URI[sha256sum] = "af92b078cb52f9c58964d49b074a5d09de601435c8e84cec817b636fc53c8eeb"
SRC_URI[md5sum] = "2c958056e0a82da4d85810ea51b9e07b"
SRC_URI[sha256sum] = "c8e0cf191fb60b26eb5481c24d162c3675c72bc940c42393af2f0b62897de90f"
SRC_URI[md5sum] = "a17be90788c4ccd6ee8253659b9321f8"
SRC_URI[sha256sum] = "56dfd5365848095793faa31ee1cf753c10891dd076944d3533b05c6547965134"
SRC_URI[md5sum] = "e897eb0dc64c2862091f97e20f580de6"
SRC_URI[sha256sum] = "66283a36122d77a4118a1b2e48af92c03ae09b3e53fe7875e7fe3db1486a522c"
SRC_URI[md5sum] = "05766128b2b0abdd01048e5e08430600"
SRC_URI[sha256sum] = "5fcd54adf3c8e7e99078a585683926224b5b49a99e4e675694621c3e08e6aad0"
SRC_URI[md5sum] = "7c766563674dec668baa5f650a14b7cd"
SRC_URI[sha256sum] = "3f78e714248cdaa0b83f530a3b7f80da02446b179e86fbb043d57c3e05ae0d7e"
SRC_URI[md5sum] = "ce6d8a7a25cc1c9593417746bcf84ca0"
SRC_URI[sha256sum] = "24aac1d158095007a10a47e38320a1618fab2d536f19caff94f4dd0ab29f306b"
SRC_URI[md5sum] = "9b69a1f5951ebd26d5b29ac326c5c414"
SRC_URI[sha256sum] = "8de4e1a8696c2f47ed1b9009498b4f89ba9dd3fbda6083531ef40c35ce001996"
SRC_URI[md5sum] = "b60a6035a3e84ba68771fef999ccc96f"
SRC_URI[sha256sum] = "fe3dcba12eab368a5c14e6c247886bcbaa3fafc662ea8de00fd579f956a21a71"
SRC_URI[md5sum] = "15a09026135382c716a11633344ba3c4"
SRC_URI[sha256sum] = "49521feb1a6e2bc9b355e93b3251e3c74ebe2327eb89c6e681347464e81e3664"
SRC_URI[md5sum] = "b67218e773a236631b41a1718049bbc7"
SRC_URI[sha256sum] = "f6ddc6636b2a8e4392dab43fdcfd9521e2d7f9022e56c39ecee66d50a94bdc98"
