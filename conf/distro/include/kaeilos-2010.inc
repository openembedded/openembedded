#@TYPE: Distribution
#@NAME: kaeilos-2010
#@DESCRIPTION: Release independent distribution configuration for KaeilOS 
#@MAINTAINER: Marco Cavallini <m.cavallini@koansoftware.com>
#@VERSION: 06-10-2010
#
# KaeilOS is a registered trade mark of KOAN - Bergamo - Italia
# Product website : http://www.KaeilOS.com 

# Preserve original DISTRO value
USERDISTRO := "${DISTRO}"
DISTRO = "kaeilos"
DISTRO_NAME = "KaeilOS"
BUILDNAME = "KaeilOS ${DISTRO_VERSION}"
TARGET_VENDOR = "-kaeilos"

# Add FEED_ARCH to overrides
OVERRIDES .= ":${FEED_ARCH}"

# Put links to sources in deploy/sources to make it easier for people to be GPL compliant
INHERIT += "src_distribute_local"
SRC_DIST_LOCAL ?= "symlink"

# Can be "glibc", "eglibc" or "uclibc"
KAEILOSLIBC ?= "eglibc"
LIBC ?= "${KAEILOSLIBC}"
PSTAGE_EXTRAPATH = "${LIBC}"

CACHE = "${TMPDIR}/cache/${LIBC}/${MACHINE}"
DEPLOY_DIR = "${TMPDIR}/deploy/${LIBC}"
require conf/distro/include/angstrom-${LIBC}.inc

ARM_INSTRUCTION_SET = "arm"
THUMB_INTERWORK = "yes"

#Use this variable in feeds and other parts that need a URI
KAEILOS_URI ?= "http://www.kaeilos.com"

#Use this variable to select which recipe you want to use to get feed configs (/etc/ipkg/, /etc/apt/sources.list)
# useful for derivative distros and local testing
# As this is runtime we can't and won't use virtual/feed-configs
DISTRO_FEED_CONFIGS = ""

#Set the default maintainer of kaeilos
MAINTAINER = "KaeilOS Mantainer <m.cavallini@koansoftware.com>"

#use debian style naming
INHERIT += "debian"

#activate config checker
INHERIT += "sanity" 

#make devshell available as task
INHERIT += "devshell" 

#run QA tests on builds and packages and log them  
INHERIT += "insane"
QA_LOG = "1"

#run QA tests on recipes
INHERIT += "recipe_sanity"

#save statistical info on images
INHERIT += "testlab"

INHERIT += "package_ipk"
PREFERRED_PROVIDER_virtual/update-alternatives-native ?= "opkg-native"
PREFERRED_PROVIDER_virtual/update-alternatives ?= ${PREFERRED_PROVIDER_opkg}

# We don't want to keep OABI compat
ARM_KEEP_OABI = "0"
# Do keep OABI compat for om-gta01 to keep the gllin binary working
ARM_KEEP_OABI_pn-linux-openmoko-2.6.24_om-gta01 = "1"
ARM_KEEP_OABI_pn-linux-openmoko-2.6.28_om-gta01 = "1"


#Generate locales on the buildsystem instead of on the target. Speeds up first boot, set to "1" to enable
PREFERRED_PROVIDER_qemu-native = "qemu-native"
ENABLE_BINARY_LOCALE_GENERATION ?= "1"

# We only want to build UTF8 locales
LOCALE_UTF8_ONLY = "1"

#qemu doesn't like this fp
ENABLE_BINARY_LOCALE_GENERATION_ep9312 = "0"

#qemu has taken a dislike to armeb as well
ENABLE_BINARY_LOCALE_GENERATION_armeb = "0"

#ARM EABI is softfloat by default, but let's make sure :)
#make it overridable for platforms with FPU, like ep93xx or i.mx31
TARGET_FPU_arm ?= "soft"
TARGET_FPU_armeb ?= "soft"
TARGET_FPU_ixp4xx ?= "soft"

TARGET_FPU_armv6 ?= "hard"
TARGET_FPU_armv6-novfp ?= "soft"
TARGET_FPU_armv7a ?= "hard"

# webkit-gtk and cairo have alignment issues with double instructions on armv5 so
# disable them here
TARGET_CC_ARCH_pn-webkit-gtk_armv5te = "-march=armv4t"
TARGET_CC_ARCH_pn-cairo_armv5te = "-march=armv4t"

#Set the right arch for the feeds
#Alphabetically sorted
FEED_ARCH ?= "${BASE_PACKAGE_ARCH}"

#Tweak packaging for strongarm machines since they can't use EABI
PACKAGE_EXTRA_ARCHS_collie = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3600  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3800  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_simpad = "arm-oabi"
PACKAGE_EXTRA_ARCHS_htcwallaby = "arm-oabi"

#Name the generated images in a sane way
IMAGE_NAME = "${DISTRO_NAME}-${IMAGE_BASENAME}-${LIBC}-${PREFERRED_PKG_FORMAT}-${DISTRO_VERSION}-${MACHINE}"
DEPLOY_DIR_IMAGE = "${DEPLOY_DIR}/images/${MACHINE}"

# KaeilOS *always* has some form of release config, so error out if someone thinks he knows better 
DISTRO_CHECK := "${@bb.data.getVar("DISTRO_VERSION",d,1) or bb.fatal('Remove this line or set a dummy DISTRO_VERSION if you really want to build an unversioned distro')}"

OESTATS_SERVER      ?= "tinderbox.openembedded.org"

# We want images supporting the following features (for task-base)
DISTRO_FEATURES = "nfs wifi alsa bluetooth ext2 vfat pcmcia usbgadget usbhost pci pam"

# Following features are for ARM and E500 based machines
DISTRO_FEATURES += "eabi"

# Use-like features
DISTRO_FEATURES += "tk"

