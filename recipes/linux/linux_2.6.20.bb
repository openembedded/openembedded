require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "20"
DEFAULT_PREFERENCE_at91sam9261ek = "20"
DEFAULT_PREFERENCE_at91sam9260ek = "20"
DEFAULT_PREFERENCE_nhk15 = "1"

PR = "r11"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.21.bz2;patch=1 \
	   file://0001-kbuild-include-limits.h-in-sumversion.c-for-PATH_MAX.patch;patch=1 \
           file://defconfig"

SRC_URI_append_n2100 = "\
	   file://n2100-r8169-parity.patch;patch=1 \
	   file://rtc-rs5c372-n2100.patch;patch=1 \
	   "

SRC_URI_append_at91sam9263ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "
SRC_URI_append_at91sam9261ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "
SRC_URI_append_at91sam9260ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
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

do_stage_append_nhk15 () {
    install -D -m 666 ${S}/drivers/video/nomadik/sga_interface.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_interface.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_defs.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_defs.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_err.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_err.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_interface.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_interface.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_ioctlfns.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_ioctlfns.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_main.h  ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_main.h
    install -D -m 666 ${S}/drivers/video/nomadik/sga_typs.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sga_typs.h

    install -D -m 666 ${S}/drivers/video/nomadik/hcl/debug.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/debug.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/hcl_defs.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/hcl_defs.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/platform_os.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/platform_os.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/sga.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_irq.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/sga_irq.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_irqp.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/sga_irqp.h
    install -D -m 666 ${S}/drivers/video/nomadik/hcl/sga_p.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl/sga_p.h

    install -D -m 666 ${S}/drivers/media/video/hcl_defs.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/hcl_defs.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_camera.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/nomadik_camera.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_defs.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/nomadik_defs.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/nomadik_sva.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva_services.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/nomadik_sva_services.h
    install -D -m 666 ${S}/drivers/media/video/nomadik_sva_utils.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/nomadik_sva_utils.h
    install -D -m 666 ${S}/drivers/media/video/platform_os.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/platform_os.h
    install -D -m 666 ${S}/drivers/media/video/sva.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/sva.h
    install -D -m 666 ${S}/drivers/media/video/v4l2-nomadik.h ${STAGING_KERNEL_DIR}/drivers/video/nomadik/v4l2-nomadik.h

    install -D -m 666 ${S}/drivers/media/nomadik_mm/saa/saaioctl.h ${STAGING_KERNEL_DIR}/include/saaioctl.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/saa.h ${STAGING_KERNEL_DIR}/../multimedia/include/saa.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/hcl_defs.h ${STAGING_KERNEL_DIR}/../multimedia/include/hcl_defs.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/platform_os.h ${STAGING_KERNEL_DIR}/../multimedia/include/platform_os.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/include/debug.h ${STAGING_KERNEL_DIR}/../multimedia/include/debug.h

    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_hcl_fw_interface.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_hcl_fw_interface.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_api_params.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_api_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_codec_params.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_codec_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_effect_params.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_effect_params.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_effect_info.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_effect_info.h
    install -D -m 666 ${S}/drivers/media/nomadik_mm/hcl/saa/ha_codec_info.h ${STAGING_KERNEL_DIR}/../multimedia/include/ha_codec_info.h

}
