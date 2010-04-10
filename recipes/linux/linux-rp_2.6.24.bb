require linux-rp.inc

PR = "r23"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_qemux86 = "1"
DEFAULT_PREFERENCE_tosa = "1"
DEFAULT_PREFERENCE_poodle = "1"
DEFAULT_PREFERENCE_c7x0 = "1"
DEFAULT_PREFERENCE_akita = "1"
DEFAULT_PREFERENCE_spitz = "1"

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
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2;name=archive \
	   file://0001-time-prevent-the-loop-in-timespec_add_ns-from-bei.patch;patch=1 \
           ${RPSRC}/export_atags-r2.patch;patch=1;status=pending;name=patch1 \
           ${RPSRC}/lzo_crypto-r2.patch;patch=1;status=pending;name=patch2 \
           ${RPSRC}/corgi_rearrange_lcd-r0.patch;patch=1;status=pending;name=patch3 \
	   file://hrw-hostapcard.patch;patch=1;status=pending \
           ${RPSRC}/allow_disable_deferrred-r0.patch;patch=1;name=patch4 \
           ${RPSRC}/lzo_jffs2_sysfs-r1.patch;patch=1;name=patch5 \
           ${RPSRC}/hx2750_base-r33.patch;patch=1;name=patch6 \
           ${RPSRC}/hx2750_bl-r9.patch;patch=1;name=patch7 \
           ${RPSRC}/hx2750_pcmcia-r3.patch;patch=1;name=patch8 \
           ${RPSRC}/pxa_keys-r8.patch;patch=1;name=patch9 \
           ${RPSRC}/tsc2101-r18.patch;patch=1;name=patch10 \
           ${RPSRC}/hx2750_test1-r8.patch;patch=1;name=patch11 \
           ${RPSRC}/input_power-r10.patch;patch=1;name=patch12 \
           ${RPSRC}/pxa25x_cpufreq-r2.patch;patch=1;name=patch13 \
           ${RPSRC}/sharpsl_pm_fixes1-r0.patch;patch=1;name=patch14 \
           ${RPSRC}/pm_changes-r1.patch;patch=1;name=patch15 \
           ${RPSRC}/usb_add_epalloc-r4.patch;patch=1;name=patch16 \
           ${RPSRC}/usb_pxa27x_udc-r8.patch;patch=1;name=patch17 \
           ${RPSRC}/locomo_kbd_tweak-r1a.patch;patch=1;name=patch18 \
           ${RPSRC}/pxa27x_overlay-r8.patch;patch=1;name=patch19 \
           ${RPSRC}/w100_extaccel-r2.patch;patch=1;name=patch20 \
           ${RPSRC}/w100_extmem-r1.patch;patch=1;name=patch21 \
           ${RPSRC}/poodle_pm-r5.patch;patch=1;name=patch22 \
           ${RPSRC}/poodle_lcd_hack-r0.patch;patch=1;name=patch23 \
           ${RPSRC}/poodle_asoc_fix-r1.patch;patch=1;name=patch24 \
           file://pxa27x-resume.patch;patch=1;status=external \
           file://mtd-module.patch;patch=1;status=external \
           file://wm8750-treble.patch;patch=1;status=external \
           file://spitz_h_rewrite.patch;patch=1;status=external \
           file://pxa2xx_udc-clock.patch;patch=1 \
           file://sharpsl-rc-r1.patch;patch=1 \
           file://sharpsl-rc-r2.patch;patch=1 \
           file://squashfs3.3.patch;patch=1;status=external \
#           ${RPSRC}/logo_oh-r1.patch.bz2;patch=1;status=unmergable \
           ${RPSRC}/pxa-linking-bug.patch;patch=1;status=unmergable;name=patch25 \
           file://hostap-monitor-mode.patch;patch=1;status=unmergable \
           file://serial-add-support-for-non-standard-xtals-to-16c950-driver.patch;patch=1;status=unmergable \
           ${RPSRC}/mmcsd_large_cards-r1.patch;patch=1;status=hack;name=patch26 \
           ${RPSRC}/mmcsd_no_scr_check-r2.patch;patch=1;status=hack;name=patch27 \
           ${RPSRC}/integrator_rgb-r1.patch;patch=1;status=hack;name=patch28 \
           ${RPSRC}/pxa_cf_initorder_hack-r1.patch;patch=1;status=hack;name=patch29 \
           file://pxa-serial-hack.patch;patch=1;status=hack \
           file://connectplus-remove-ide-HACK.patch;patch=1;status=hack \
           file://connectplus-prevent-oops-HACK.patch;patch=1;status=hack \
           file://binutils-buildid-arm.patch;patch=1 \
           file://versatile-armv6.patch;patch=1 \
	   file://htcuni.patch;patch=1 \
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
           file://defconfig-tosa \
           file://defconfig-zylonite"

# FIXMEs before made default	   
# ${RPSRC}/mmcsd_no_scr_check-r1.patch;patch=1;status=hack


# Add this to enable pm debug code (useful with a serial lead)
#  ${RPSRC}/sharpsl_pm_debug-r0.patch;patch=1

# Disabled until I find the reason this gives issues with cdc_subset
#            ${RPSRC}/usb_rndis_tweaks-r0.patch;patch=1 \


SRC_URI_append_collie = "\
	${TKSRC}/mtd-sharp-flash-hack-r4.patch;patch=1;name=tkpatch1 \
	${TKSRC}/mcp-sa11x0-r0.patch;patch=1;name=tkpatch2 \
	${TKSRC}/locomo-r1.patch;patch=1;name=tkpatch3 \
	${TKSRC}/collie-kexec-r1.patch;patch=1;name=tkpatch4 \
	${TKSRC}/sharpsl_pm-4.patch;patch=1;name=tkpatch5 \
	${TKSRC}/collie_pm-3.patch;patch=1;name=tkpatch6 \
	${TKSRC}/ucb1x00_suspend.patch;patch=1;name=tkpatch7 \
	${TKSRC}/collie-ts.patch;patch=1;name=tkpatch8 \
	${TKSRC}/pcmcia_suspend.patch;patch=1;name=tkpatch9 \
	${TKSRC}/locomo_spi-6.patch;patch=1;name=tkpatch10 \
	${TKSRC}/config.patch;patch=1;name=tkpatch11 \
	${TKSRC}/mmc-spi.patch;patch=1;name=tkpatch12 \
	${TKSRC}/linux-2.6.24-SIMpad-rtc-sa1100.patch;patch=1;name=tkpatch13 \
	${TKSRC}/sa1100_spinlock.patch;patch=1;name=tkpatch14 \
	${TKSRC}/sa1100-dma.patch;patch=1;name=tkpatch15 \
"

SRC_URI_append_poodle = "\
           ${RPSRC}/poodle_serial_vcc-r0.patch;patch=1 \
           file://poodle_ts.patch;patch=1 \
           file://pxafb.patch;patch=1 \
"

SRC_URI_append_tosa = "\
           file://tosa/0001-Allow-runtime-registration-of-regions-of-memory-that.patch;patch=1 \
           file://tosa/0002-Modify-dma_alloc_coherent-on-ARM-so-that-it-supports.patch;patch=1 \
           file://tosa/0003-Core-MFD-support.patch;patch=1 \
           file://tosa/0004-Add-support-for-tc6393xb-MFD-core.patch;patch=1 \
           file://tosa/0005-Add-support-for-tc6387xb-MFD-core.patch;patch=1 \
           file://tosa/0006-Add-support-for-t7l66xb-MFD-core.patch;patch=1 \
           file://tosa/0007-Common-headers-for-TMIO-MFD-subdevices.patch;patch=1 \
           file://tosa/0008-Nand-driver-for-TMIO-devices.patch;patch=1 \
           file://tosa/0009-FB-driver-for-TMIO-devices.patch;patch=1 \
           file://tosa/0010-OHCI-driver-for-TMIO-devices.patch;patch=1 \
           file://tosa/0011-MMC-driver-for-TMIO-devices.patch;patch=1 \
           file://tosa/0012-Tosa-keyboard-support.patch;patch=1 \
           file://tosa/0013-USB-gadget-pxa2xx_udc-supports-inverted-vbus.patch;patch=1 \
           file://tosa/0014-tosa_udc_use_gpio_vbus.patch.patch;patch=1 \
           file://tosa/0015-sharpsl-export-params.patch;patch=1 \
           file://tosa/0016-This-patch-fixes-the-pxa25x-clocks-definitions-to-ad.patch;patch=1 \
           file://tosa/0026-I-don-t-think-we-should-check-for-IRQs-when-determin.patch;patch=1 \
           file://tosa/0027-Add-LiMn-one-of-the-most-common-for-small-non-recha.patch;patch=1 \
           file://tosa/0028-Add-suspend-resume-wakeup-support-for-pda_power.patch;patch=1 \
           file://tosa/0029-Support-using-VOLTAGE_-properties-for-apm-calculati.patch;patch=1 \
           file://tosa/0030-Core-driver-for-WM97xx-touchscreens.patch;patch=1 \
           file://tosa/0031-Add-chip-driver-for-WM9705-touchscreen.patch;patch=1 \
           file://tosa/0032-Add-chip-driver-for-WM9712-touchscreen.patch;patch=1 \
           file://tosa/0033-Add-chip-driver-for-WM9713-touchscreen.patch;patch=1 \
           file://tosa/0034-Driver-for-WM97xx-touchscreens-in-streaming-mode-on.patch;patch=1 \
           file://tosa/0035-Build-system-and-MAINTAINERS-entry-for-WM97xx-touchs.patch;patch=1 \
           file://tosa/0036-Set-id-to-1-for-wm97xx-subdevices.patch;patch=1 \
           file://tosa/0037-Don-t-lock-the-codec-list-in-snd_soc_dapm_new_widget.patch;patch=1 \
           file://tosa/0038-Don-t-lock-the-codec-list-in-snd_soc_dapm_new_widget.patch;patch=1 \
           file://tosa/0044-fix-tmio_mmc-debug-compilation.patch;patch=1 \
           file://tosa/0045-Update-tmio_ohci.patch;patch=1 \
           file://tosa/0046-patch-tc6393xb-cleanup.patch;patch=1 \
           file://tosa/0047-tc6393xb-use-bitmasks-instead-of-bit-field-structs.patch;patch=1 \
           file://tosa/0048-tc6393xb-GPIO-support.patch;patch=1 \
           file://tosa/0049-platform-support-for-TMIO-on-tosa.patch;patch=1 \
           file://tosa/0050-tosa-update-for-tc6393xb-gpio.patch;patch=1 \
           file://tosa/0051-fix-sound-soc-pxa-tosa.c-to-new-gpio-api.patch;patch=1 \
           file://tosa/0052-tosa-platform-backlight-support.patch;patch=1 \
           file://tosa/0053-sound-soc-codecs-wm9712.c-28.patch;patch=1 \
           file://tosa/0054-sound-soc-codecs-wm9712.c-2.patch;patch=1 \
           file://tosa/0055-Add-GPIO_POWERON-to-the-list-of-devices-that-we-supp.patch;patch=1 \
           file://tosa/0058-Fix-tosakbd-suspend.patch;patch=1 \
           file://tosa/0059-patch-tosa-wakeup-test.patch;patch=1 \
           file://tosa/0060-Add-support-for-power_supply-on-tosa.patch;patch=1 \
           file://tosa/0061-tosa-bat-unify.patch;patch=1 \
           file://tosa/0062-tosa-bat-fix-charging.patch;patch=1 \
           file://tosa/0063-patch-tosa-bat-jacket-detect.patch;patch=1 \
           file://tosa/0064-Export-modes-via-sysfs.patch;patch=1 \
           file://tosa/0065-wm97xx-core-fixes.patch;patch=1 \
           file://tosa/0066-tmiofb_probe-should-be-__devinit.patch;patch=1 \
           file://tosa/0067-modeswitching.patch;patch=1 \
           file://tosa/0068-Preliminary-tosa-denoiser.patch;patch=1 \
           file://tosa/0019-pxa-remove-periodic-mode-emulation-support.patch;patch=1 \
           file://tosa/0020-Provide-dew-device-clock-backports-from-2.6.24-git.patch;patch=1 \
           file://tosa/0021-Add-an-empty-drivers-gpio-directory-for-gpiolib-infr.patch;patch=1 \
           file://tosa/0022-Provide-new-implementation-infrastructure-that-platf.patch;patch=1 \
           file://tosa/0023-This-adds-gpiolib-support-for-the-PXA-architecture.patch;patch=1 \
           file://tosa/0024-Update-Documentation-gpio.txt-primarily-to-include.patch;patch=1 \
           file://tosa/0025-Signed-off-by-Dmitry-Baryshkov-dbaryshkov-gmail.co.patch;patch=1 \
           file://tosa/0039-Add-generic-framework-for-managing-clocks.patch;patch=1 \
           file://tosa/0040-Clocklib-debugfs-support.patch;patch=1 \
           file://tosa/0041-From-80a359e60c2aec59ccf4fca0a7fd20495f82b1d2-Mon-Se.patch;patch=1 \
           file://tosa/0042-Use-correct-clock-for-IrDA-on-pxa.patch;patch=1 \
           file://tosa/0043-Use-clocklib-for-sa1100-sub-arch.patch;patch=1 \
           file://tosa/0056-Support-resetting-by-asserting-GPIO-pin.patch;patch=1 \
           file://tosa/0057-Clean-up-tosa-resetting.patch;patch=1 \
           file://tosa/0001-pxa2xx-ac97-switch-AC-unit-to-correct-state-before.patch;patch=1 \
	   file://tosa/tosa-bl-fixup.diff;patch=1 \
           "
#           file://tosa/0017-Convert-pxa2xx-UDC-to-use-debugfs.patch;patch=1 \
#           file://tosa/0018-Fix-the-pxa2xx_udc-to-balance-calls-to-clk_enable-cl.patch;patch=1 \

SRC_URI_append_htcuniversal ="\
	file://htcuni-acx.patch;patch=1;status=external \
	"

SRC_URI_append_zylonite ="\
	file://pxa_fb_overlay.patch;patch=1 \
	file://zylonite-boot.patch;patch=1 \
	"

S = "${WORKDIR}/linux-2.6.24"

SRC_URI[md5sum] = "3f23ad4b69d0a552042d1ed0f4399857"
SRC_URI[sha256sum] = "413c64fbbcf81244cb5571be4963644a1e81166a2b0f008a016528363b65c5d3"
SRC_URI[md5sum] = "987956757c3707ba0e62ce2cd133011b"
SRC_URI[sha256sum] = "7754930742d3c3cc2a05af38263ba58ba416b7359f8a0c598ae0f7377277d3b3"
SRC_URI[md5sum] = "29162001c88d9dbe0ccb25103a1aefb4"
SRC_URI[sha256sum] = "0b68f2d73dc54404d29015455ba84021a925aa2cfb6f1fe75705fe2268b2e2e8"
SRC_URI[md5sum] = "c1bec44c92f5da5abad97137c73b1365"
SRC_URI[sha256sum] = "d4dc8f0583e616e74ea41b103d5f6a29b6d079ce37eaf9f362825514c7082490"
SRC_URI[md5sum] = "1cc6aee6d128edf41775472764652435"
SRC_URI[sha256sum] = "02657350458e7d82b8c926e1f027e408e1e2e8d9570f31e7b5f84472fe2e41c2"
SRC_URI[md5sum] = "a8b75ef4190dfc0afcfa8789d3e4c64c"
SRC_URI[sha256sum] = "3fed945b590db46a902fa434054b967dd1bf4af1ee5f5643e00d1d66a9d69543"
SRC_URI[md5sum] = "e9ef4b8b78ab64cd7dbd0d41b05e932c"
SRC_URI[sha256sum] = "ed4f25e0da55714c618c2721209a2d22a7296b5dc85af028d20aff6062a4a13b"
SRC_URI[md5sum] = "ebb78f58e9c84c73b90e9cbdde5f89d6"
SRC_URI[sha256sum] = "7578448fc2adbfc820158b2467dbb127ab012b3a97ad95366d8d1af002defbce"
SRC_URI[md5sum] = "896d3e29ab5715b7558b972fba626425"
SRC_URI[sha256sum] = "29f21117a17f945783f2eee5d5c89e10959fed44ac423ad9809d6afc0db5996c"
SRC_URI[md5sum] = "4f41fd3a0e031a26d3a2d354f5995ffd"
SRC_URI[sha256sum] = "3959a45bb65f66a622d7752e41808604032f4ab66f736f96fee83e252d85df5a"
SRC_URI[md5sum] = "95e9a5dfc1852e2db3d1d9da6df439df"
SRC_URI[sha256sum] = "83097559d413b57aa67da1de975e8fbb99d02a2b2166aad57d7b30881208ff1e"
SRC_URI[md5sum] = "33eed5a26b2776508500532c07956dc4"
SRC_URI[sha256sum] = "a93c7f0caa8e212a4515ce209918e250e80d2643317732d707d4f25649457545"
SRC_URI[md5sum] = "6ddb822c5ee92a58b667795b41f31963"
SRC_URI[sha256sum] = "d42ec6f70b00100aa8816740259e3d70686aeae8c05a4f76b67f76b84c79833c"
SRC_URI[md5sum] = "c076ac1f2368d9e8399e64a3adf3a036"
SRC_URI[sha256sum] = "34358aa53caaf393af550d9771f02f144eafabb7518e84d872427dc297e493b4"
SRC_URI[md5sum] = "aeea5a2614fd8f9ae7d729d1ea1dddba"
SRC_URI[sha256sum] = "1bd129c7a68537533c77267992eaf490ff64bcc3d01c6f4b51343b8f266ae99e"
SRC_URI[md5sum] = "e10058b52841d138630b69b954bea0b9"
SRC_URI[sha256sum] = "779561c658ccb190f3a2cd7626e4a229834c5f9b093be8f7a06bbfaf12121b9c"
SRC_URI[md5sum] = "042c5243ce0253341fe920a8a863e37b"
SRC_URI[sha256sum] = "6d2ae5d70609df7d2c2b518eca0624c4a59328b277ed114b9e5b57dd030e6e94"
SRC_URI[md5sum] = "d4bbe2b9ef6b5879d72875896632d8b3"
SRC_URI[sha256sum] = "c4bf829816c3e53b0807bb12cfdc8b1f0e0c1eae14a5be2ffb1a59ad71bbb188"
SRC_URI[md5sum] = "f126bdd73fa79a770b8c0caa95c5bae8"
SRC_URI[sha256sum] = "a80748d7438ffa589eaee6d4870c74cebc90cc5c8134d070c8f4090fe9bab58c"
SRC_URI[md5sum] = "94926c8dbea9035ca9e5b44d9dd68726"
SRC_URI[sha256sum] = "8848bf269257316e845857d58023fec82e7e2ff5a8092915ec4a8b033429a5cc"
SRC_URI[md5sum] = "2c958056e0a82da4d85810ea51b9e07b"
SRC_URI[sha256sum] = "c8e0cf191fb60b26eb5481c24d162c3675c72bc940c42393af2f0b62897de90f"
SRC_URI[md5sum] = "a17be90788c4ccd6ee8253659b9321f8"
SRC_URI[sha256sum] = "56dfd5365848095793faa31ee1cf753c10891dd076944d3533b05c6547965134"
SRC_URI[md5sum] = "3ed63ce3884d6cdd71b6d471e3c49407"
SRC_URI[sha256sum] = "e87d44d5a77c591db83598295109c033708a458797247a31cfa20d54c52d7b41"
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
