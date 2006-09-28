# choose the proper kernel for this hardware
PREFERRED_PROVIDER_virtual/kernel = "ezx-kernels"
# we don't need support for kernel 2.4
MODUTILS = "26"
# build tar.gz for SD/MMC/Transflash and jffs2 for later when we have mtd
IMAGE_FSTYPES = "tar.gz jffs2"

BOOTSTRAP_EXTRA_RDEPENDS += "kernel udev sysfsutils apm irda-utils udev-utils ppp ppp-dialin module-init-tools"

#
# disable all modules until we have something that boots...
#

# Ethernet modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-pcnet-cs"
# NFS Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-nfs kernel-module-lockd kernel-module-sunrpc"
# Crypto Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-des kernel-module-md5"
# SMB and CRAMFS
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-smbfs kernel-module-cramfs"
# Serial Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-8250 kernel-module-serial-cs"
# Bluetooth Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-bluetooth kernel-module-l2cap kernel-module-rfcomm kernel-module-hci-vhci \
#                              kernel-module-bnep kernel-module-hidp kernel-module-hci-uart kernel-module-sco \
#                              kernel-module-bt3c-cs kernel-module-bluecard-cs kernel-module-btuart-cs kernel-module-dtl1-cs"
# Infrared Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-pxaficp-ir kernel-module-irda kernel-module-ircomm \
#                             kernel-module-ircomm-tty kernel-module-irlan kernel-module-irnet kernel-module-ir-usb"
#
# USB Gadget Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-gadgetfs kernel-module-g-file-storage \
#                             kernel-module-g-serial kernel-module-g-ether"
#
# Sound Modules
#BOOTSTRAP_EXTRA_RDEPENDS += "kernel-module-snd-mixer-oss kernel-module-snd-pcm-oss"
#BOOTSTRAP_EXTRA_SOUND     = "kernel-module-soundcore kernel-module-snd kernel-module-snd-page-alloc 
#                              kernel-module-snd-timer kernel-module-snd-pcm  \
#                              kernel-module-snd-soc-core kernel-module-snd-soc-pxa2xx kernel-module-snd-soc-pxa2xx-i2s"
#                             
