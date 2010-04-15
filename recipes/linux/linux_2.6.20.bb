require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "20"
DEFAULT_PREFERENCE_at91sam9261ek = "20"
DEFAULT_PREFERENCE_at91sam9260ek = "20"
DEFAULT_PREFERENCE_nhk15 = "1"

PR = "r11"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.21.bz2;patch=1;name=stablepatch \
	   file://0001-kbuild-include-limits.h-in-sumversion.c-for-PATH_MAX.patch;patch=1 \
           file://defconfig"

SRC_URI_append_n2100 = "\
	   file://n2100-r8169-parity.patch;patch=1 \
	   file://rtc-rs5c372-n2100.patch;patch=1 \
	   "

SRC_URI_append_at91sam9263ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1;name=at91patch \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1;name=exppatch \
                               "
SRC_URI_append_at91sam9261ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1;name=at91patch \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1;name=exppatch \
                               "
SRC_URI_append_at91sam9260ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1;name=at91patch \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1;name=exppatch \
                               "

SRC_URI_append_nhk15 = " \
		file://nomadik_baseline_linux_2620.patch;patch=1 \
		file://audio_codec_patch_base_v5.6.0.patch;patch=1 \
		file://linux-2.6.20_01_dec_2.patch;patch=1 \
		file://patch_classdamp_pm_v_audio_codec_patch.patch;patch=1 \
		file://patch_audiocodec_glitch.patch;patch=1 \
		file://hrw-saa-fix.diff;patch=1 \
		file://hrw-make-create-kconfig-executable.patch;patch=1 \
"

do_install_append_nhk15 () {
    install -D -m 666 ${S}/drivers/video/nomadik/sga_interface.h $kerneldir/drivers/video/nomadik/sga_interface.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_defs.h $kerneldir/drivers/video/nomadik/sga_defs.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_err.h $kerneldir/drivers/video/nomadik/sga_err.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_interface.h $kerneldir/drivers/video/nomadik/sga_interface.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_ioctlfns.h $kerneldir/drivers/video/nomadik/sga_ioctlfns.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_main.h  $kerneldir/drivers/video/nomadik/sga_main.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_typs.h $kerneldir/drivers/video/nomadik/sga_typs.h

    install -D -m 666 ${S}/drivers/video/nomadik/hcl/debug.h $kerneldir/drivers/video/nomadik/hcl/debug.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/hcl_defs.h $kerneldir/drivers/video/nomadik/hcl/hcl_defs.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/platform_os.h $kerneldir/drivers/video/nomadik/hcl/platform_os.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga.h $kerneldir/drivers/video/nomadik/hcl/sga.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_irq.h $kerneldir/drivers/video/nomadik/hcl/sga_irq.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_irqp.h $kerneldir/drivers/video/nomadik/hcl/sga_irqp.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_p.h $kerneldir/drivers/video/nomadik/hcl/sga_p.h

    install -D -m 666 ${S}/drivers/media/video/hcl_defs.h $kerneldir/drivers/video/nomadik/hcl_defs.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_camera.h $kerneldir/drivers/video/nomadik/nomadik_camera.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_defs.h $kerneldir/drivers/video/nomadik/nomadik_defs.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva.h $kerneldir/drivers/video/nomadik/nomadik_sva.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva_services.h $kerneldir/drivers/video/nomadik/nomadik_sva_services.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva_utils.h $kerneldir/drivers/video/nomadik/nomadik_sva_utils.h
    install -D -m 666 ${S}/drivers/media/video/platform_os.h $kerneldir/drivers/video/nomadik/platform_os.h
    install -D -m 666 ${S}/drivers/media/video/sva.h $kerneldir/drivers/video/nomadik/sva.h
    install -D -m 666 ${S}/drivers/media/video/v4l2-nomadik.h $kerneldir/drivers/video/nomadik/v4l2-nomadik.h

    install -D -m 666 ${S}/drivers/media/nomadik_mm/saa/saaioctl.h $kerneldir/include/saaioctl.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/saa.h $kerneldir/../multimedia/include/saa.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/hcl_defs.h $kerneldir/../multimedia/include/hcl_defs.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/platform_os.h $kerneldir/../multimedia/include/platform_os.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/debug.h $kerneldir/../multimedia/include/debug.h

    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_hcl_fw_interface.h $kerneldir/../multimedia/include/ha_hcl_fw_interface.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_api_params.h $kerneldir/../multimedia/include/ha_api_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_codec_params.h $kerneldir/../multimedia/include/ha_codec_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_effect_params.h $kerneldir/../multimedia/include/ha_effect_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_effect_info.h $kerneldir/../multimedia/include/ha_effect_info.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_codec_info.h $kerneldir/../multimedia/include/ha_codec_info.h

}

SRC_URI[kernel.md5sum] = "34b0f354819217e6a345f48ebbd8f13e"
SRC_URI[kernel.sha256sum] = "2c14ada1ac7d272e03b430d3a530d60fc9ec69cc8252382aa049afba7d2b8558"
SRC_URI[stablepatch.md5sum] = "10319d634fa66ae8a758e03a227ff79f"
SRC_URI[stablepatch.sha256sum] = "1e0b8c7c5c923b396dcd0a0a1aa3108676f6ad67b35132d0c068ee59fd48408f"
SRC_URI[at91patch.md5sum] = "333b0e9328194f28af83c26d3717e4ac"
SRC_URI[at91patch.sha256sum] = "8930ebfdc8a606d8cb26f073d4700460c3289fb79e943e12948329e17336ca47"
SRC_URI[exppatch.md5sum] = "691a9fd94de318aebb4b241fcff22cc6"
SRC_URI[exppatch.sha256sum] = "4f8529718a45a570cfbf452760009960264028467f398769236b501c9338fc1e"
