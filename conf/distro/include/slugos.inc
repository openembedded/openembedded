#@TYPE: Distribution
#@NAME: SlugOS
#@DESCRIPTION: SlugOS Linux Distribution for the NSLU2

# WARNING: this file should not be used directly, use one of
# the supported slugos-derived distributions instead.

#----------------------------------------------------------------------------------
# STANDARD SLUGOS DEFINITIONS
#----------------------------------------------------------------------------------
# The following must be set in the top level distro file:
#
#DISTRO_NAME
#DISTRO_TYPE
#ARM_INSTRUCTION_SET "arm" or "thumb"
#TARGET_OS "linux" or "linux-uclibc"

# The following may be overridden to make sub-versions
SLUGOS_VERSION = "6.0"
DISTRO_REVISION ?= ""
DISTRO_VERSION ?= "${SLUGOS_VERSION}${DISTRO_REVISION}-${DISTRO_TYPE}"
# For release (only):
# DISTRO_FEED ?= "${SLUGOS_VERSION}-${DISTRO_TYPE}"
DISTRO_FEED ?= "unstable"

THUMB_INTERWORK = "yes"
# "yes" "no"
#    Whether to compile with code to allow interworking between the two
#    instruction sets.  This allows thumb code to be executed on a primarily
#    arm system and vice versa.  It is strongly recommended that DISTROs not
#    turn this off - the actual cost is very small.
# We want images supporting the following features (for task-base)
DISTRO_FEATURES = "largefile ipv4 ipv6 nfs smbfs wifi ppp alsa bluetooth ext2 vfat irda pcmcia usbhost pci eabi xattr"
# We may also wish to enable raid support at some point (space permitting)
#DISTRO_FEATURES += " raid"

IMAGE_BASENAME = "${@['slugos${SITEINFO_ENDIANNESS}', 'ucslugc'][bb.data.getVar('TARGET_OS', d, 1) == 'linux-uclibceabi']}"

# Define CACHE and DEPLOY_DIR so we could do multi-distro/multi-machine builds

CACHE = "${TMPDIR}/cache/${LIBC}/${MACHINE}"
DEPLOY_DIR = "${TMPDIR}/deploy/${LIBC}"
IMAGE_ROOTFS = "${TMPDIR}/rootfs/${MACHINE}-${LIBC}-${PN}"

# The following need not be set, the defaults should be adequate
#USE_NLS = "no" or "yes"
USE_NLS ?= "no"

# To make errors easier to identify:
DISTRO_NAME ?= "INVALID-${SITEINFO_ENDIANNESS}-${ARM_INSTRUCTION_SET}-${TARGET_OS}"
DISTRO_TYPE ?= "INVALID"

# The following must not be changed.
TARGET_FPU = "soft"

# glib-2.0 builds require USE_NLS to be overridden
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

INHERIT += "package_ipk debian testlab siteinfo devshell"

# FULL_OPTIMIZATION
#    Optimization settings.  Os works fine and is significantly better than O2.
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"

# We need to keep OABI compat for things like madwifi-ng.
ARM_KEEP_OABI = "1"

TARGET_LINK_HASH_STYLE = "-Wl,--hash-style=gnu"

CXXFLAGS += "-fvisibility-inlines-hidden"

# There is a problem of sorts with Perl.  This needs a better home eventually,
# but for now put it in this file.
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
BUILD_OPTIMIZATION_pn-perl = "-O1"

#----------------------------------------------------------------------------------
# FEEDS
#  The FEED_URIS lines define where on the internet SlugOS looks for packages
#  when downloading new packages or updating existing packages.  Additional feeds
#  (such as a local feed) can be defined in local.conf
#----------------------------------------------------------------------------------
#
FEED_URIS_append += "cross##http://ipkg.nslu2-linux.org/feeds/${IMAGE_BASENAME}/cross/${DISTRO_FEED}"
#FEED_URIS_append += "native##http://ipkg.nslu2-linux.org/feeds/${IMAGE_BASENAME}/native/${DISTRO_FEED}"

#----------------------------------------------------------------------------------
# FIRMWARE CONFIGURATION
#----------------------------------------------------------------------------------
# IMAGE BUILD OPTIONS
# -------------------
# CMDLINE* macros define the kernel command line.  CMDLINE_DEBUG is provided
# to enable/disable debugging in the distro.  Here noirqdebug is used to
# remove the messages about unhandled interrupts - people debugging interrupt
# issues in the kernel need to cancel this (set CMDLINE_DEBUG empty in local.conf)
CMDLINE_ROOT  = "root=/dev/mtdblock4 rootfstype=jffs2 rootflags=noatime rw init=/linuxrc"
CMDLINE_DEBUG = "noirqdebug"

# EXTRA PACKAGES
# --------------
# SlugOS builds an image with no extra packages - to add packages to the
# firmware include this file in a new 'distro' configuration file) and set
# the definition below to include the requirements.
# NOTE: as built this system will *not* be able to boot off anything other than
# the flash file system ('turnup' will not work).  You need to add the filesystem
# modules for your chosen root file system (and any others which will be used).
# See openslug.conf for a more full-featured system!
#
# Everything in this list gets added to the flash image, along with any RDEPENDS
# it has itself!
DISTRO_EXTRA_DEPENDS ?= ""
DISTRO_EXTRA_RDEPENDS ?= ""
DISTRO_EXTRA_RRECOMMENDS ?= ""

SOURCE_MIRROR_URL ?= "http://sources.nslu2-linux.org/sources/"
INHERIT += "own-mirrors"

#FIXME: HACK: REMOVE THIS
IGNORE_STRIP_ERRORS = ""

#----------------------------------------------------------------------------------
# PACKAGE VERSION CONTROL
#----------------------------------------------------------------------------------
# Define how to bootstrap the system - we need cross compilers.  It is also
# necessary to define which gets generated first, glibc or the kernel, and
# this is done by selecting the provider of libc (in this case it needs the
# kernel, so there has to be a non-libc gcc to build the kernel!)

# Virtuals:

# Select the appropriate x11 library provider.  The diet-x11 libraries are
# much smaller, but may not be as current as the standard x11 libraries; by
# default we will select the standard libraries and permit the use of an
# override if the user wishes (and has the correct PREFERRED_VERSIONs set).
PREFERRED_PROVIDER_virtual/libx11		?= "libx11"
PREFERRED_PROVIDER_virtual/libx11-native        ?= "libx11-native"

# Ensure consistency across all SlugOS builds for the provider of a relational
# database - use the latest version of the SleepyCat Berkeley database
PREFERRED_PROVIDER_virtual/db			= "db"
PREFERRED_PROVIDER_virtual/db-native		= "db-native"

SRCDATE_irssi					?= "20050930"

# We want the newer util-linux package
PREFERRED_PROVIDER_util-linux			?= "util-linux-ng"

# we don't ship gtk-directfb by default
PREFERRED_PROVIDER_gtk+				?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ani	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-bmpg	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-gif	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ico	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-jpeg	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-pcx	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-png	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-pnm	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ras	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-tga	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-wbmp	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-xbm	?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-xpm	?= "gtk+"

PREFERRED_PROVIDER_avahi			?= "avahi"
PREFERRED_PROVIDER_ifupdown			?= "ifupdown"
PREFERRED_PROVIDER_gconf			?= "gconf"
PREFERRED_PROVIDER_virtual/libqte2		?= "qte"
PREFERRED_PROVIDER_virtual/libusb0		?= "libusb-compat"

# we use bluez4 instead of the older bluez3
DISTRO_BLUETOOTH_MANAGER			= "bluez4"
PREFERRED_PROVIDER_bluez-utils-dbus		= "bluez4"
PREFERRED_PROVIDER_bluez-libs			= "bluez4"
PREFERRED_PROVIDER_bluez-utils			= "bluez4"

# Include any package preferred versions and srcrevs:

require conf/distro/include/preferred-slugos-versions.inc
