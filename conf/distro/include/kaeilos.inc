#@TYPE: Distribution
#@NAME: KaeilOS 
#@DESCRIPTION: Release independent distribution configuration for KaeilOS 
#@MAINTAINER: Marco Cavallini <m.cavallini@koansoftware.com>
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
KAEILOSLIBC ?= "glibc"
LIBC ?= "${KAEILOSLIBC}"
PSTAGE_EXTRAPATH = "${LIBC}"

CACHE = "${TMPDIR}/cache/${LIBC}/${MACHINE}"
DEPLOY_DIR = "${TMPDIR}/deploy/${LIBC}"
require conf/distro/include/angstrom-${LIBC}.inc

# ARM920T and up can use thumb mode to decrease binary size at the expense of speed
# (the complete story is a bit more nuanced due to cache starvation)
# KaeilOS turns on thumb for armv4t machine according to this RFC:
# http://lists.linuxtogo.org/pipermail/angstrom-distro-devel/2008-October/002714.html

# We can't do ARM_INSTRUCTION_SET_armv4t since that will un-overridable in recipes like gcc
ANGSTROM_ARM_INSTRUCTION_SET ?= "arm"
#ANGSTROM_ARM_INSTRUCTION_SET_armv4t = "thumb"
#ANGSTROM_ARM_INSTRUCTION_SET_armv5te = "thumb"


ARM_INSTRUCTION_SET = "${ANGSTROM_ARM_INSTRUCTION_SET}"
# "arm" "thumb"
#    The instruction set the compiler should use when generating application
#    code.  The kernel is always compiled with arm code at present.  arm code
#    is the original 32 bit ARM instruction set, thumb code is the 16 bit
#    encoded RISC sub-set.  Thumb code is smaller (maybe 70% of the ARM size)
#    but requires more instructions (140% for 70% smaller code) so may be
#    slower.

THUMB_INTERWORK = "yes"
# "yes" "no"
#    Whether to compile with code to allow interworking between the two
#    instruction sets.  This allows thumb code to be executed on a primarily
#    arm system and vice versa.  It is strongly recommended that DISTROs not
#    turn this off - the actual cost is very small.


#Use this variable in feeds and other parts that need a URI
ANGSTROM_URI ?= "http://www.kaeilos.com"

#Use this variable to select which recipe you want to use to get feed configs (/etc/ipkg/, /etc/apt/sources.list)
# usefull for derivative distros and local testing
# As this is runtime we can't and won't use virtual/feed-configs
ANGSTROM_FEED_CONFIGS ?= "angstrom-feed-configs"

#Set the default maintainer of kaeilos
MAINTAINER = "KaeilOS Mantainer <m.cavallini@koansoftware.com>"

#use debian style naming
INHERIT += "debian"

#activate config checker
INHERIT += "sanity" 

#activate the blacklister
INHERIT += "angstrom"

#make devshell available as task
INHERIT += "devshell" 

#use angstrom source mirrors to combat 404s
INHERIT += "angstrom-mirrors" 

#run QA tests on builds and packages and log them  
INHERIT += "insane"
# INHERIT += "packagehistory"
QA_LOG = "1"

#run QA tests on recipes
INHERIT += "recipe_sanity"

#save statistical info on images
INHERIT += "testlab"

ANGSTROM_PKG_FORMAT ?= "ipk"
require conf/distro/include/angstrom-package-${ANGSTROM_PKG_FORMAT}.inc


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
TARGET_FPU_ppc405 ?= "soft"

TARGET_FPU_armv6 ?= "hard"
TARGET_FPU_armv6-novfp ?= "soft"
TARGET_FPU_armv7a ?= "hard"
TARGET_FPU_ppc603e ?= "hard"

# webkit-gtk and cairo have alignment issues with double instructions on armv5 so
# disable them here
TARGET_CC_ARCH_pn-webkit-gtk_armv5te = "-march=armv4t"
TARGET_CC_ARCH_pn-cairo_armv5te = "-march=armv4t"

#Set the right arch for the feeds
#Alphabetically sorted

FEED_ARCH ?= "${BASE_PACKAGE_ARCH}"

#blackfin machines
FEED_ARCH_bfin          = "blackfin"

#Tweak packaging for strongarm machines since they can't use EABI

PACKAGE_EXTRA_ARCHS_collie = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3600  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3800  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_simpad = "arm-oabi"
PACKAGE_EXTRA_ARCHS_htcwallaby = "arm-oabi"


#Name the generated images in a sane way
IMAGE_NAME = "${DISTRO_NAME}-${IMAGE_BASENAME}-${LIBC}-${ANGSTROM_PKG_FORMAT}-${DISTRO_VERSION}-${MACHINE}"
DEPLOY_DIR_IMAGE = "${DEPLOY_DIR}/images/${MACHINE}"

# KaeilOS *always* has some form of release config, so error out if someone thinks he knows better 
DISTRO_CHECK := "${@bb.data.getVar("DISTRO_VERSION",d,1) or bb.fatal('Remove this line or set a dummy DISTRO_VERSION if you really want to build an unversioned distro')}"


# Configuration for tinderbox, so people only need:
# INHERIT          += "tinderclient"
# in their local.conf 

#Name of the client
TINDER_MACHINE  = "${MACHINE}-${LIBC}-build-image"

# Which lof file to write to, which tree to report to
TINDER_LOG        = "${TMPDIR}/tinder.log"
TINDER_TREE       = "KaeilOS"

# HTTP posting    
#TINDER_HOST       ?= "ewi546.ewi.utwente.nl"
#TINDER_URL        ?= "/tinderbox"

# Which branch do we build
TINDER_BRANCH     = "org.openembedded.dev"
   
## Clobbing
## 0 for rebuilding everything from scratch
## 1 for incremental builds
TINDER_CLOBBER    = "1"

## Do a report at all
TINDER_REPORT     = "1"

# Configuration for seppuku autobuilder, people only need to put:
# INHERIT += "seppuku oestats-client"
# SEPPUKU_USER         = "your_bugzilla@user.id"
# SEPPUKU_PASS         = "your_bugzilla_password"
# OESTATS_BUILDER      = "your_name" 
# in their local.conf

# seppuku bbclass
SEPPUKU_LOGIN        = "http://bugs.openembedded.net/query.cgi?"
SEPPUKU_QUERY        = "http://bugs.openembedded.net/buglist.cgi?"
SEPPUKU_NEWREPORT    = "http://bugs.openembedded.net/post_bug.cgi?bug_file_loc=http%3A%2F%2F&version=Angstrom%20unstable&priority=P2&bug_severity=normal&op_sys=Linux&rep_platform=Other&"
SEPPUKU_ADDCOMMENT   = "http://bugs.openembedded.net/process_bug.cgi?bug_file_loc=http%3A%2F%2F&version=Angstrom&priority=P2&bug_severity=normal&op_sys=Linux&rep_platform=Other&"
SEPPUKU_ATTACHMENT   = "http://bugs.openembedded.net/attachment.cgi?"
SEPPUKU_AUTOBUILD    = "1"

SEPPUKU_PRODUCT      = "Openembedded"
SEPPUKU_COMPONENT    = "org.openembedded.dev"

OESTATS_SERVER      ?= "tinderbox.openembedded.org"



# We want images supporting the following features (for task-base)
DISTRO_FEATURES = "nfs smbfs wifi ppp alsa bluetooth ext2 vfat irda pcmcia usbgadget usbhost pci pam"

# Use-like features
DISTRO_FEATURES += "tk"
