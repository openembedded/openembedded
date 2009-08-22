require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_VERSION = "2.6.30.4"

SRC_URI = "\
  http://kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
  file://defconfig \
  file://openwrt-files.tgz \
  file://fix-install.patch;patch=1 \
  file://001-merge-openmoko.patch;patch=1 \                         
  file://010-s3c-dma.patch;patch=1 \                                
  file://011-s3c-pwm.patch;patch=1 \                                
  file://012-s3c-usb.patch;patch=1 \                                
  file://013-fiq_c_handler.patch;patch=1 \                          
  file://014-neo1973_mach.patch;patch=1 \                           
  file://015-mach-gta02.patch;patch=1 \                             
  file://030-dont-override-logo-with-early-printks.patch;patch=1 \  
  file://040-rename-serialdevs.patch;patch=1 \                      
  file://050-s3c2442-touchscreen.patch;patch=1 \
#  file://051-gta02kbd.patch;patch=1 \             
  file://052-touchscreen_filter.patch;patch=1 \   
  file://053-glamo.patch;patch=1 \                
  file://054-bq27000.patch;patch=1 \              
  file://055-jbt6k74.patch;patch=1 \              
  file://055-gta02-leds.patch;patch=1 \           
  file://056-pcf50633.patch;patch=1 \             
  file://057-lis302dl.patch;patch=1 \             
  file://058-gta02-wm8752.patch;patch=1 \
  file://060-spi-gpio-non-blocking.patch;patch=1 \
  file://068-ar6000.patch;patch=1 \
  file://070-s3c24xx-time.patch;patch=1 \
  file://080-nr-tty-devices.patch;patch=1 \
  file://100-udc-poll-vbus.patch;patch=1 \
  file://110-serial.patch;patch=1 \
  file://120-fix-wm8753-reg_cache.patch;patch=1 \
  file://130-fix-s3c_gpiolib_getchip.patch;patch=1 \
#  file://150-ignore-init-argument.patch;patch=1 \
  file://004-extra_optimization.patch;patch=1 \
  file://006-gcc4_inline_fix.patch;patch=1 \
  file://007-samsung_flash.patch;patch=1 \
  file://011-mips_boot.patch;patch=1 \
  file://020-mips_multi_machine_support.patch;patch=1 \
  file://021-mips_simple_prom_emulator.patch;patch=1 \
  file://024-mips_delay.patch;patch=1 \
  file://025-mips_disable_fpu.patch;patch=1 \
  file://026-mips_fix_loading_of_modules_with_unresolved_weak_sy.patch;patch=1 \
  file://027-mips_module_reloc.patch;patch=1 \
  file://028-module_exports.patch;patch=1 \
  file://030-pci_disable_common_quirks.patch;patch=1 \
  file://050-pcomp_update.patch;patch=1 \
#  file://051-squashfs_pcomp.patch;patch=1 \
#  file://052-pcomp_lzma_support.patch;patch=1 \
#  file://053-squashfs_lzma.patch;patch=1 \
  file://060-block2mtd_init.patch;patch=1 \
  file://065-rootfs_split.patch;patch=1 \
  file://070-redboot_space.patch;patch=1 \
  file://071-redboot_boardconfig.patch;patch=1 \
  file://080-mtd_plat_nand_chip_fixup.patch;patch=1 \
  file://081-mtd_myloader_partition_parser.patch;patch=1 \
  file://090-mtd_fix_nand_correct_data_return_code.patch;patch=1 \
  file://100-netfilter_layer7_2.21.patch;patch=1 \
  file://101-netfilter_layer7_pktmatch.patch;patch=1 \
  file://110-netfilter_match_speedup.patch;patch=1 \
  file://130-netfilter_ipset.patch;patch=1 \
  file://150-netfilter_imq.patch;patch=1 \
  file://180-netfilter_depends.patch;patch=1 \
  file://190-netfilter_rtsp.patch;patch=1 \
  file://200-sched_esfq.patch;patch=1 \
  file://201-jhash3.patch;patch=1 \
  file://202-mips-freestanding.patch;patch=1 \
  file://203-slab_maxsize.patch;patch=1 \
  file://204-jffs2_eofdetect.patch;patch=1 \
  file://205-skb_padding.patch;patch=1 \
  file://207-powerpc_asm_segment_h.patch;patch=1 \
  file://209-mini_fo.patch;patch=1 \
  file://210-mini_fo_2.6.25_fixes.patch;patch=1 \
  file://211-mini_fo_2.6.25_dentry_open_war.patch;patch=1 \
  file://212-mini_fo_2.6.26_fixes.patch;patch=1 \
  file://213-mini_fo_2.6.27_fixes.patch;patch=1 \
  file://214-mini_fo_2.6.29.patch;patch=1 \
  file://215-mini_fo_2.6.30.patch;patch=1 \
  file://219-kobject_uevent.patch;patch=1 \
  file://220-sound_kconfig.patch;patch=1 \
  file://221-binfmt_elf_gcc4.1.patch;patch=1 \
  file://240-packet_socket_type.patch;patch=1 \
  file://250-pppoe_header_pad.patch;patch=1 \
  file://260-extend_pfifo_fast.patch;patch=1 \
  file://400-ledtrig_morse.patch;patch=1 \
  file://402-ledtrig_netdev.patch;patch=1 \
#  file://410-gpio_buttons.patch;patch=1 \
  file://420-gpiodev.patch;patch=1 \
  file://510-yaffs_support.patch;patch=1 \
  file://511-yaffs-cvs-2009-04-24.patch;patch=1 \
  file://600-phy_extension.patch;patch=1 \
  file://620-phy_adm6996.patch;patch=1 \
  file://630-phy_packets.patch;patch=1 \
  file://650-swconfig.patch;patch=1 \
  file://660-phy_mvswitch.patch;patch=1 \
  file://670-phy_ip175c.patch;patch=1 \
  file://680-phy_ar8216.patch;patch=1 \
  file://690-phy_rtl8306.patch;patch=1 \
  file://700-rtc7301.patch;patch=1 \
  file://750-glamo-headers.patch;patch=1 \
  file://780-fix-race-in-snd_soc_jack_add_gpios.patch;patch=1 \
  file://801-usb_serial_endpoint_size.patch;patch=1 \
  file://840-unable_to_open_console.patch;patch=1 \
  file://902-darwin_scripts_include.patch;patch=1 \
  file://903-hostap_txpower.patch;patch=1 \
  file://903-stddef_include.patch;patch=1 \
  file://905-i386_build.patch;patch=1 \
  file://920-01-hotpluggable-spi-gpio.patch;patch=1 \
  file://920-04-spi-gpio-implement-spi-delay.patch;patch=1 \
  file://921-gpio_spi_driver.patch;patch=1 \
  file://922-gpiommc.patch;patch=1 \
  file://923-gpiommc-configfs-locking.patch;patch=1 \
  file://924-cs5535_gpio.patch;patch=1 \
  file://925-modify-i2c-gpio-initcall-level.patch;patch=1 \
  file://940-wireless_mesh_header.patch;patch=1 \
  file://951-revert_gcc4_4_fixes.patch;patch=1 \
#  file://960-arm_lzma_loader.patch;patch=1 \
  file://970-ocf_kbuild_integration.patch;patch=1 \
  file://971-ocf_20080917.patch;patch=1 \
  file://972-ocf_compile_fix.patch;patch=1 \
  file://973-ocf_2.6.27_fix.patch;patch=1 \
  file://974-ssb_b43_default_on.patch;patch=1 \
  file://977-textsearch_kconfig_hacks.patch;patch=1 \
  file://978-lib80211_kconfig_hacks.patch;patch=1 \
  file://979-crypto_add_kconfig_prompts.patch;patch=1 \
  file://980-vm_exports.patch;patch=1 \
  file://985-cris-headers.patch;patch=1 \
  file://990-fix_feroceon_vfp_handling.patch;patch=1 \
  file://991-ppc4xx_optimization.patch;patch=1 \
#  file://998-openwrt_lzma_options.patch;patch=1 \
#  file://999-use_preinit_as_init.patch;patch=1 \
"

S = "${WORKDIR}/linux-${PV}"

#CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
#CONFIG_NAME_om-gta02 = "gta02_defconfig"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
