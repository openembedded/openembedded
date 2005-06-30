SECTION = "kernel"
DESCRIPTION = "Linux kernel for the MASTERIA PA-100 device."
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
KV = "${@bb.data.getVar('PV',d,True).split('-')[0]}"
MVLV = "${@bb.data.getVar('PV',d,True).split('-')[1]}"
PR = "r7"
DEPENDS = "cetools-native"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/montavista-sa-${PV}"

SRC_URI = "http://www.vanille.de/temp/linux-${KV}_${MVLV}.tar.gz \
           file://iw_handlers.w13-5.diff;patch=1 \
           file://iw_handlers.w14-5.diff;patch=1 \
           file://iw240_we15-6.diff;patch=1 \
	   file://flash-for-beagle-iii.patch;patch=1 \
	   file://remove-montavista-init-stupidity.patch;patch=1 \
           file://mkdep.patch;patch=1 \
	   file://machine_name.patch;patch=1 \
	   file://opie-logo.patch;patch=1 \
	   file://apm-hh-merge.patch;patch=1 \
	   file://beagle-sound.patch;patch=1 \
	   file://linux-2.4.18-list_move.patch;patch=1 \
	   file://pcmcia_preempt.patch;patch=1 \
           file://defconfig-${MACHINE}"

S = "${WORKDIR}/linux-${KV}_${MVLV}"

def beagle_multiline_ppp():
	str = "alias char-major-108\Tppp_generic\nalias /dev/ppp\tppp_generic"
	return str


inherit kernel

CMDLINE    = "root=/dev/mtdblock/1 mem=32M console=ttySA0 noinitrd"

KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

EXTRA_OEMAKE = ""

module_conf_sa1100_ir = "alias irda0 sa1100_ir"
module_conf_pcmcia_core = "options pcmcia_core ignore_cis_vcc=1"
module_conf_ppp_async = "alias ppp0 ppp_async"
module_conf_orinoco_cs = "options orinoco_cs ignore_cis_vcc=1"
module_conf_hostap_cs = "options hostap_cs ignore_cis_vcc=1"
module_conf_spectrum_cs = "options spectrum_cs ignore_cis_vcc=1"
module_conf_ppp_generic = "${@beagle_multiline_ppp()} "
module_conf_ppp_mppe = "alais ppp-compress-18 ppp_mppe"
module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_sa1100_bi = "below sa1100_bi net_fd usbdcore "


module_autoload_sa1100_pcmcia = "sa1100_pcmcia"
module_autoload_unix = "unix"
module_autoload_usb-eth = "usb-eth"
module_autoload_af_packet = "af_packet"

FILES_kernel = ""
ALLOW_EMPTY  = 1

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        bin2rom arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${DATETIME}.bin c0008000 c0008000
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
