require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_VERSION = "2.6.30.1"

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
  file://750-glamo-headers.patch;patch=1 \
#  file://150-ignore-init-argument.patch;patch=1 \
"

S = "${WORKDIR}/linux-${PV}"

#CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
#CONFIG_NAME_om-gta02 = "gta02_defconfig"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
