SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA25x based devices."
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "GPL"
PR = "r0"

KERNEL_CCSUFFIX = "-3.3.3"
COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
	   file://defconfig-ipaqpxa \
	   file://ipaq-hal.init \
	   file://linux-2.4-no-short-loads.patch;patch=1 \
	   file://linux-2.4-cpufreq.patch;patch=1 \
	   file://ipsec.patch;patch=1"

S = "${WORKDIR}/kernel"

inherit kernel update-rc.d

PACKAGE_ARCH = "ipaqpxa"

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
module_conf_i2c_algo_pxa = "options i2c-algo-pxa pxa_scan=0"
module_conf_pcmcia_core = "options pcmcia_core ignore_cis_vcc=1"
module_conf_ppp_async = "alias ppp0 ppp_async"
module_conf_orinoco_cs = "options orinoco_cs ignore_cis_vcc=1"
module_conf_hostap_cs = "options hostap_cs ignore_cis_vcc=1"

module_autoload_h3600_generic_sleeve = "h3600_generic_sleeve"
module_autoload_ds = "ds"
module_autoload_pxa_cs = "pxa_cs"
module_autoload_h3600_ts = "h3600_ts"
module_autoload_apm = "apm"

FILES_kernel += "/etc/init.d/ipaq-hal"
INITSCRIPT_NAME = "ipaq-hal"
INITSCRIPT_PARAMS = "start 21 S ."

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-${PACKAGE_ARCH} ${S}/.config
}

do_install_append() {
	install -d ${D}/etc/init.d
	install ${WORKDIR}/ipaq-hal.init ${D}/etc/init.d/ipaq-hal
}
