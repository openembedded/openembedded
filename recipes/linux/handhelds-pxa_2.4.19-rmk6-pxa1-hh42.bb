SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA25x based devices."
LICENSE = "GPLv2"
#PR = "r1"


KERNEL_CCSUFFIX = "-3.3.4"
COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(h3900|h5000)'


SRC_URI = "${HANDHELDS_CVS};module=linux/kernel;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
	   file://defconfig-${PACKAGE_ARCH} \
	   file://ipaq-hal.init \
           file://linux-2.4-usb-gadget.patch;patch=1 \
           file://usb-gadget-ether-compat.patch;patch=1 \
	   file://linux-2.4-no-short-loads.patch;patch=1 \
	   file://linux-2.4-cpufreq.patch;patch=1"

S = "${WORKDIR}/kernel"

inherit kernel update-rc.d

K_MAJOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[0]}"
K_MINOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[1]}"
K_MICRO = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[2]}"
RMKV    = "${@bb.data.getVar('PV',d,1).split('-')[1].split('rmk')[-1]}"
PXAV    = "${@bb.data.getVar('PV',d,1).split('-')[2].split('pxa')[-1]}"
HHV     = "${@bb.data.getVar('PV',d,1).split('-')[3].split('hh')[-1]}"

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + int(bb.data.getVar('RMKV',d,1)) * 1000 + int(bb.data.getVar('PXAV',d,1)) * 100 + float(bb.data.getVar('HHV',d,1)))}"

module_conf_h3900_asic = "alias ipaq_hal_3900 h3900_asic"
module_conf_h5400_asic = "alias ipaq_hal_5400 h5400_asic"
module_conf_pxa_ir = "alias irda0 pxa_ir"
module_conf_i2c-algo-pxa = "options i2c-algo-pxa pxa_scan=0"
module_conf_pcmcia_core = "options pcmcia_core ignore_cis_vcc=1"
module_conf_ppp_async = "alias ppp0 ppp_async"
module_conf_orinoco_cs = "options orinoco_cs ignore_cis_vcc=1"
module_conf_hostap_cs = "options hostap_cs ignore_cis_vcc=1"
module_conf_hidp = "alias bt-prot-5 hidp"

module_autoload_h3600_ts = "h3600_ts"
module_autoload_apm = "apm"
module_autoload_af_packet = "af_packet"
module_autoload_usb-ohci-h5400 = "usb-ohci-h5400"
module_autoload_ppp_async = "ppp_async"
module_autoload_usb-eth = "usb-eth"
module_autoload_h5400_buzzer = "h5400_buzzer"
# breaks booting on first install of h3900 handhelds
#module_autoload_mmc_asic3 = "mmc_asic3"
module_autoload_mmc_h5400 = "mmc_h5400"
module_autoload_h5400-audio = "h5400-audio"
module_autoload_h3900-uda1380 = "h3900-uda1380"
module_autoload_sa1100-rtc = "sa1100-rtc"
module_autoload_ak4535 = "ak4535"
module_autoload_i2c-adap-pxa = "i2c-adap-pxa"

FILES_kernel += "/etc/init.d/ipaq-hal"
INITSCRIPT_NAME = "ipaq-hal"
INITSCRIPT_PARAMS = "start 21 S ."

# extra depends
RDEPENDS_kernel-module-h5400-audio = "kernel-module-ak4535 kernel-module-i2c-adap-pxa"
RDEPENDS_kernel-module-h3900-uda1380 = "kernel-module-uda1380 kernel-module-i2c-adap-pxa"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-${PACKAGE_ARCH} ${S}/.config
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/ipaq-hal.init ${D}${sysconfdir}/init.d/ipaq-hal
}
