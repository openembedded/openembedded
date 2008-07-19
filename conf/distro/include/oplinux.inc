# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)

# extra checking for needed tools
#
# set minimal version of BitBake needed
BB_MIN_VERSION = "1.8.10"

#OPLinux and OPLinux-uclibc source mirrors
INHERIT += "oplinux-mirrors"

# check for required tools and minimal BitBake version
INHERIT += "sanity"



# Naming schemes
INHERIT += "package_ipk debian"
PARALLEL_INSTALL_MODULES = "1"


#
# Maintainer email
MAINTAINER = "Digital OPSiS Developers Team <oplinux-developers@digital-opsis.com>"


#
# Packaging and output format
IMAGE_FSTYPES = "tar.gz jffs2 ext2.gz cramfs squashfs squashfs-lzma cpio.gz"

# Specifies a location to search for pre-generated tarballs when fetching
# a cvs:// URI. Outcomment this, if you always want to pull directly from CVS.
#CVS_TARBALL_STASH = "http://www.digital-opsis.com/oplinux/sources/"

PREMIRRORS = "(ftp|http)://.*/.*/ http://source.digital-opsis.com/"

#
# Bootstrap & Init
PREFERRED_PROVIDER_task-bootstrap = "task-base"

# We want images supporting the following features (for task-base
DISTRO_FEATURES = "nfs smbfs ext2 usbhost pci"


#We need to set this to avoid problems when building for if host=target
TARGET_VENDOR = "-oplinux"

#URI for base feeds
OPLINUX_URI = "http://www.digital-opsis.com/oplinux"
OPLINUX-uCLIBC_URI = "http://www.digital-opsis.com/oplinux-uclibc"

#Dir config
IMAGE_ROOTFS = "${TMPDIR}/rootfs/${MACHINE}"
DEPLOY_DIR_IMAGE = "${DEPLOY_DIR}/images/${MACHINE}"

#Set the name of the generated images
IMAGE_NAME = "${DISTRO_NAME}-${IMAGE_BASENAME}-${MACHINE}-${DATE}-${SVN_REV}"


#Do not ship kernel image with the rootfs
IMAGE_PREPROCESS_COMMAND_append = "if [ -f ${IMAGE_ROOTFS}/boot/bzImage ]; then rm \
${IMAGE_ROOTFS}/boot/bzImage*;fi;"



#
#Feed definitions
#
#i32 machines
#i486 machines
FEED_ARCH_x86           ="i486"
FEED_ARCH_wrap          ="i486"

#i586 machines
FEED_ARCH_i586-generic  = "i586"
FEED_ARCH_epia          = "i586"

#i686 machines
FEED_ARCH_i686-generic  = "i686"

#powerpc machines
#ppc405
FEED_ARCH_dht-walnut    = "ppc405"
FEED_ARCH_magicbox      = "ppc405"
FEED_ARCH_xilinx-ml403  = "ppc405"

#ppc440e
FEED_ARCH_sequoia       = "ppc440e"

#ppc603e
FEED_ARCH_efika         = "ppc603e"

#ppce300c2
FEED_ARCH_mpc8323e-rdb  = "ppce300c2"

#avr32
FEED_ARCH_atngw100      = "avr32"
FEED_ARCH_at32stk100    = "avr32"



#
#Preferred versions of packages we need
#
PREFERRED_VERSION_busybox = "1.2.1"
PREFERRED_VERSION_u-boot ?= "1.1.4"
PREFERRED_VERSION_fakeroot ?= "1.7.1"
PREFERRED_VERSION_fakeroot-native ?= "1.7.1"
PREFERRED_VERSION_makedev ?= "2.3.1"
PREFERRED_VERSION_makedevs ?= "1.0.0"
PREFERRED_VERSION_makedevs-native ?= "1.0.0"


# Latest linphone supports yeaphone
PREFERRED_VERSION_linphone ?= "1.6.0"

#
#SSH daemon
#
DISTRO_SSH_DAEMON ?= "dropbear"


#PREFERRED_VERSION_opsis-asterisk-bri_dht-walnut = "1.2.17"
#PREFERRED_VERSION_zaptel-bri_dht-walnut = "1.2.19"
#PREFERRED_VERSION_libpri_dht-walnut = "1.2.4"
