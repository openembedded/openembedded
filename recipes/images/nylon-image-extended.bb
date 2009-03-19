require nylon-image-base.bb
require ../meta/nylon-feed.inc

export IMAGE_BASENAME = "nylon-extended"

NYLON_EXTENDED_DEPENDS = "${NYLON_FEED}"

NYLON_EXTENDED_RDEPENDS = "\
    hostap-modules-cs \
    hostap-modules-pci \
    modutils-depmod \
    modutils-initscripts \
    modutils-modinfo \
    ntpdate \
    ntp-bin \
    ntp-tickadj \
    openssh-scp \
    openssh-ssh \
    openssh-sshd \
    perl-misc \
    perl-module-autoloader \
    perl-module-base \
    perl-module-bytes \
    perl-module-carp \
    perl-module-config \
    perl-module-constant \
    perl-module-data-dumper \
    perl-module-encode \
    perl-module-encode-alias \
    perl-module-encode-config \
    perl-module-encode-encoding \
    perl-module-encode-unicode \
    perl-module-errno \
    perl-module-exporter \
    perl-module-exporter-heavy \
    perl-module-fields \
    perl-module-getopt-long \
    perl-module-integer \
    perl-module-io \
    perl-module-io-handle \
    perl-module-io-socket \
    perl-module-io-socket-inet \
    perl-module-io-socket-unix \
    perl-module-locale \
    perl-module-overload \
    perl-module-posix \
    perl-module-selectsaver \
    perl-module-socket \
    perl-module-strict \
    perl-module-symbol \
    perl-module-sys-hostname \
    perl-module-vars \
    perl-module-warnings \
    perl-module-warnings-register \
    perl-module-xsloader \
"

KERNEL_MODULES = " \
    kernel-module-aes \
    kernel-module-bridge \
    kernel-module-ds \
    kernel-module-fat \
    kernel-module-mii \
    kernel-module-pcmcia-core \
    kernel-module-scsi-mod \
    kernel-module-sd-mod \
    kernel-module-usb-storage \
    kernel-module-usb-ohci \
    kernel-module-usbnet \
    kernel-module-usbserial \
    kernel-module-vfat \
    kernel-module-yenta-socket \
"


DEPENDS += "${NYLON_EXTENDED_DEPENDS}"

IMAGE_INSTALL += "${NYLON_EXTENDED_DEPENDS} ${KERNEL_MODULES} \
	${NYLON_EXTENDED_RDEPENDS} elvis-tools"

IMAGE_INSTALL_append_mtx-1 = "\
    kernel-module-au1x00-bi \
    kernel-module-network-fd \
    kernel-module-usbdcore"
#    kernel-module-usbdprocfs \
