SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for StrongArm processor based devices."
LICENSE = "GPLv2"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

KERNEL_CCSUFFIX = "-3.3.4"
COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(h3600|simpad)'

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-sa-${PV}"
SRC_URI = "${HANDHELDS_CVS};module=linux/kernel;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://defconfig-${PACKAGE_ARCH} \
	   file://ipaq-hal.init"

S = "${WORKDIR}/kernel"

inherit kernel update-rc.d

K_MAJOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[0]}"
K_MINOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[1]}"
K_MICRO = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[2]}"
RMKV    = "${@bb.data.getVar('PV',d,1).split('-')[1].split('rmk')[-1]}"
PXAV    = "${@bb.data.getVar('PV',d,1).split('-')[2].split('pxa')[-1]}"
HHV     = "${@bb.data.getVar('PV',d,1).split('-')[3].split('hh')[-1]}"

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + int(bb.data.getVar('RMKV',d,1)) * 1000 + int(bb.data.getVar('PXAV',d,1)) * 100 + float(bb.data.getVar('HHV',d,1)))}"

module_conf_h3600_micro = "alias ipaq_hal_3600 h3600_micro"
module_conf_h3600_asic = "alias ipaq_hal_3800 h3600_asic"
module_conf_sa1100_ir = "alias irda0 sa1100_ir"
module_conf_pcmcia_core = "options pcmcia_core ignore_cis_vcc=1"
module_conf_ppp_async = "alias ppp0 ppp_async"
module_conf_orinoco_cs = "options orinoco_cs ignore_cis_vcc=1"
module_conf_hostap_cs = "options hostap_cs ignore_cis_vcc=1"
module_conf_spectrum_cs = "options spectrum_cs ignore_cis_vcc=1"

module_autoload_h3600_ts = "h3600_ts"
module_autoload_apm = "apm"
module_autoload_h3600-uda1341 = "h3600-uda1341"
module_autoload_af_packet = "af_packet"
module_autoload_ppp_async = "ppp_async"
module_autoload_usb-eth = "usb-eth"

FILES_kernel += "/etc/init.d/ipaq-hal"
INITSCRIPT_NAME = "ipaq-hal"
INITSCRIPT_PARAMS = "start 21 S ."

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-${PACKAGE_ARCH} ${S}/.config
}

do_install_append() {
        install -d ${D}${sysconfdir}/init.d
        install ${WORKDIR}/ipaq-hal.init ${D}${sysconfdir}/init.d/ipaq-hal
}
