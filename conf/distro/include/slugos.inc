#@TYPE: Distribution
#@NAME: SlugOS
#@DESCRIPTION: SlugOS Linux Distribution for the NSLU2

# WARNING: this file should not be used directly, use one of
# the supported slugos-derived distributions instead.

#===============================================================================#
#===============================================================================#
#===============================================================================#
#                              NOTE NOTE NOTE
#
# This *forces* the preferred kernel version; making it unable to be overridden
# in the local.conf file.  This is a Very Bad Thing.  This is temporary, and
# is intended to facilitate some SlugOS-specific testing without disturbing
# other distros that use the ixp4xx machine type (which is currently where the
# preferred kernel version is set).
#
# This *must* be removed after initial testing is completed.  MJW 08-Dec-2008
#
PREFERRED_VERSION_linux-ixp4xx = "2.6.27.8+svnr${SRCREV}"
#
#===============================================================================#
#===============================================================================#
#===============================================================================#



#===============================================================================#
#===============================================================================#
#===============================================================================#
#                              NOTE NOTE NOTE
#
# Override the sane-srcrev file with regard to the opkg versions - this should
# be removed as soon as opkg starts to work correctly again as newer opkg
# versions fix a number of bugs and add some desireable features.
#
SRCREV_pn-opkg        = "160"
SRCREV_pn-opkg-native = "160"
SRCREV_pn-opkg-sdk    = "160"
#
#===============================================================================#
#===============================================================================#
#===============================================================================#


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
SLUGOS_VERSION = "5.2"
DISTRO_REVISION ?= ""
DISTRO_VERSION ?= "${SLUGOS_VERSION}${DISTRO_REVISION}-${DISTRO_TYPE}"
# For release (only):
# DISTRO_FEED ?= "${SLUGOS_VERSION}-${DISTRO_TYPE}"
DISTRO_FEED ?= "unstable"

# We want images supporting the following features (for task-base)
DISTRO_FEATURES = "nfs smbfs wifi ppp alsa bluetooth ext2 vfat irda pcmcia usbgadget usbhost pci"

IMAGE_BASENAME = "${@['slugos${SITEINFO_ENDIANESS}', 'ucslugc'][bb.data.getVar('TARGET_OS', d, 1) == 'linux-uclibc']}"

# The following need not be set, the defaults should be adequate
#USE_NLS = "no" or "yes"
USE_NLS ?= "no"

# To make errors easier to identify:
DISTRO_NAME ?= "INVALID-${SITEINFO_ENDIANESS}-${ARM_INSTRUCTION_SET}-${TARGET_OS}"
DISTRO_TYPE ?= "INVALID"

# The following must not be changed.
TARGET_FPU = "soft"

# glib-2.0 builds require USE_NLS to be overridden
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

INHERIT += "package_ipk debian testlab packaged-staging"

# FULL_OPTIMIZATION
#    Optimization settings.  Os works fine and is significantly better than O2.
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"

# We need to keep OABI compat for things like madwifi-ng.
ARM_KEEP_OABI = "1"

# We may wish to experiment with this as a further performance improvement, but
# small steps at a time are the best strategy.
#TARGET_LINK_HASH_STYLE = "-Wl,--hash-style=gnu"

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
FEED_URIS_append += "native##http://ipkg.nslu2-linux.org/feeds/${IMAGE_BASENAME}/native/${DISTRO_FEED}"

#----------------------------------------------------------------------------------
# FIRMWARE CONFIGURATION
#----------------------------------------------------------------------------------
# IMAGE BUILD OPTIONS
# -------------------
# CMDLINE* macros define the kernel command line.  CMDLINE_DEBUG is provided
# to enable/disable debugging in the distro.  Here noirqdebug is used to
# remove the messages about unhandled interrupts - people debugging interrupt
# issues in the kernel need to cancel this (set CMDLINE_DEBUG empty in local.conf)
CMDLINE_ROOT  = "root=/dev/mtdblock4 rootfstype=jffs2 rw init=/linuxrc"
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

#----------------------------------------------------------------------------------
# PACKAGE VERSION CONTROL
#----------------------------------------------------------------------------------
# Define how to bootstrap the system - we need cross compilers.  It is also
# necessary to define which gets generated first, glibc or the kernel, and
# this is done by selecting the provider of libc (in this case it needs the
# kernel, so there has to be a non-libc gcc to build the kernel!)

# Virtuals:
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-initial = "gcc-cross-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-intermediate = "gcc-cross-intermediate"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc = "gcc-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}g++ = "gcc-cross"

#Set preferred provider for the C library that is used to build the crosscompiler (NPTL voodoo)
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "glibc"
PREFERRED_PROVIDER_virtual/arm-linux-libc-for-gcc       = "glibc"
PREFERRED_PROVIDER_virtual/armeb-linux-libc-for-gcc     = "glibc"
PREFERRED_PROVIDER_virtual/arm-linux-gnueabi-libc-for-gcc    = "glibc"
PREFERRED_PROVIDER_virtual/armeb-linux-gnueabi-libc-for-gcc  = "glibc"

# Set the preferred provider for a few toolchain-related items, otherwise
# these may be selected from the external-toolchain instead.
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils = "binutils-cross"
PREFERRED_PROVIDER_virtual/arm-linux-binutils       = "binutils-cross"
PREFERRED_PROVIDER_virtual/armeb-linux-binutils     = "binutils-cross"
PREFERRED_PROVIDER_linux-libc-headers               = "linux-libc-headers"

# compiler/binary/library versions
PREFERRED_VERSION_binutils               ?= "2.18.50.0.7"
PREFERRED_VERSION_binutils-cross         ?= "2.18.50.0.7"
PREFERRED_VERSION_binutils-cross-sdk     ?= "2.18.50.0.7"
PREFERRED_VERSION_gcc                    ?= "4.2.4"
PREFERRED_VERSION_gcc-cross              ?= "4.2.4"
PREFERRED_VERSION_gcc-cross-sdk          ?= "4.2.4"
PREFERRED_VERSION_gcc-cross-initial      ?= "4.2.4"
PREFERRED_VERSION_gcc-cross-intermediate ?= "4.2.4"
PREFERRED_VERSION_glibc                  ?= "2.6.1"
PREFERRED_VERSION_glibc-initial          ?= "2.6.1"

# Select the smallest provider of x11 libraries
PREFERRED_PROVIDER_virtual/libx11 ?= "diet-x11"
SRCDATE_diet-x11 ?= "20060106"

# Ensure consistency across all SlugOS builds for the provider of a
# relational database - use the latest version of the SleepyCat
# Berkeley database
PREFERRED_PROVIDER_virtual/db = "db"
PREFERRED_PROVIDER_virtual/db-native = "db-native"

SRCDATE_ipkg-utils ?= "20060106"
SRCDATE_ipkg-utils-native ?= "20060106"
SRCDATE_ipkg-link ?= "20060106"
SRCDATE_irssi ?= "20050930"

CVS_TARBALL_STASH = "http://sources.nslu2-linux.org/sources/"
INHERIT += "nslu2-mirrors"

PREFERRED_VERSION_nslu2-linksys-firmware ?= "2.3r63"

PREFERRED_VERSION_ipkg ?= "0.99.163"
PREFERRED_VERSION_ipkg-native ?= "0.99.163"

#FIXME: HACK: REMOVE THIS
IGNORE_STRIP_ERRORS = ""

PREFERRED_VERSION_linux-libc-headers ?= "2.6.23"

# New pango and older glib-2.0 versions don't mix,
# so specify exactly what we would like to build.
#PREFERRED_VERSION_pango    ?= "1.20.5"
#PREFERRED_VERSION_glib-2.0 ?= "2.16.1"
#PREFERRED_VERSION_cairo    ?= "1.4.8"

PREFERRED_VERSION_udev	   ?= "118"

# Stick with an older gettext and e2fsprogs stuff
# and gnutls... (our autotools is too old at the moment)
#PREFERRED_VERSION_gnutls           ?= "1.6.3"
#PREFERRED_VERSION_gettext          ?= "0.14.1"
#PREFERRED_VERSION_gettext-native   ?= "0.14.1"
#PREFERRED_VERSION_e2fsprogs-libs   ?= "1.39"
#PREFERRED_VERSION_e2fsprogs        ?= "1.38"
#PREFERRED_VERSION_e2fsprogs-native ?= "1.38"

# we don't ship gtk-directfb by default
PREFERRED_PROVIDER_gtk+                   ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ani  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-bmpg ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-gif  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ico  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-jpeg ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-pcx  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-png  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-pnm  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-ras  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-tga  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-wbmp ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-xbm  ?= "gtk+"
PREFERRED_PROVIDER_gdk-pixbuf-loader-xpm  ?= "gtk+"

PREFERRED_PROVIDER_avahi  ?= "avahi"
PREFERRED_PROVIDER_gconf  ?= "gconf"

# These shouldn't be here either -- these versions should
# be pulled from a separate include file.  But they can
# go here for now.
PREFERRED_VERSION_automake-native       ?= "1.10"
PREFERRED_VERSION_busybox               ?= "1.13.2"
PREFERRED_VERSION_dbus                  ?= "1.2.1"
PREFERRED_VERSION_glib-2.0              ?= "2.18.3"
PREFERRED_VERSION_glib-2.0-native       ?= "2.18.0"
PREFERRED_VERSION_libtool               ?= "1.5.10"
PREFERRED_VERSION_libtool-native        ?= "1.5.10"
PREFERRED_VERSION_libtool-cross         ?= "1.5.10"
PREFERRED_VERSION_libtool-sdk           ?= "1.5.10"
PREFERRED_VERSION_m4                    ?= "1.4.8"
PREFERRED_VERSION_m4-native             ?= "1.4.8"
PREFERRED_VERSION_pkgconfig             ?= "0.23"
PREFERRED_VERSION_pkgconfig-native      ?= "0.23"

# Hack alert - selecting this version of libusb effectively selects
# the use of libusb1 and libusb-compat in the case that something
# still depends on libusb.  This is required because otherwise
# libusb will overwrite libusb-compat in staging.
PREFERRED_VERSION_libusb                ?= "0.0.0"

# mtd-utils 1.2.0+git cannot be fetched, so SlugOS will stick
# with 1.1.0 for now:
PREFERRED_VERSION_mtd-utils             ?= "1.1.0"

# boost 1.36 won't build
PREFERRED_VERSION_boost			?= "1.33.1"

require conf/distro/include/sane-srcdates.inc
require conf/distro/include/sane-srcrevs.inc
