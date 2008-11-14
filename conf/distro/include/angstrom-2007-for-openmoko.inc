#@--------------------------------------------------------------------
#@TYPE: Distribution
#@NAME: Angstrom <http://www.angstrom-distribution.org>
#@DESCRIPTION: The Linux Distribution for Kernel 2.6 based devices
#@MAINTAINER: Koen Kooi <koen@openembedded.org>
#@MAINTAINER: Michael 'Mickey' Lauer <mickey@Vanille.de>
#@--------------------------------------------------------------------

DISTRO_VERSION = "2007.11RC3"
DISTRO_REVISION = "51"

require conf/distro/include/sane-srcdates.inc
require conf/distro/include/sane-srcrevs.inc

#Images built can have to modes:
# 'debug': empty rootpassword, strace included
# 'release' no root password, no strace and gdb by default
DISTRO_TYPE ?= "debug"
#DISTRO_TYPE = "release"

# Ship just basic locale by default. Locales are big (~1Mb uncompr.), so
# shipping some adhoc subset will be still useless and size burden for
# users of all other languages/countries. Instead, worth to make it easy
# to install additional languages: installer/wizard + metapackages which
# will RRECOMMEND as much as possible content for a given language
# (locales, UI transalations, help, etc. - useless for pros, but really 
# helpful for common users).
# Also, it appears that no locales fit in 16Mb for now. "C" locale rules!
IMAGE_LINGUAS = '${@base_less_or_equal("ROOT_FLASH_SIZE", "16", "", "en-gb", d)}'

# set feed path variables
FEED_BASEPATH = "feeds/2007/${ANGSTROM_PKG_FORMAT}/${ANGSTROM_MODE}/"


#The angstrom-mirrors.bbclass should have everything, but we can use this as a fallback
CVS_TARBALL_STASH ?= "http://www.angstrom-distribution.org/unstable/sources/"

#Make sure we use 2.6 on machines with a 2.4/2.6 selector
KERNEL = "kernel26"
MACHINE_KERNEL_VERSION = "2.6"
PCMCIA_MANAGER = "pcmciautils"

#Preferred version for the kernel on various machines
PREFERRED_VERSION_linux-handhelds-2.6               ?= "2.6.21-hh20"
PREFERRED_VERSION_linux-ixp4xx                      ?= "2.6.21.6+svnr${SRCREV}"
RDEPENDS_kernel-base_hx4700 = ""
RDEPENDS_kernel-base_htcuniversal = ""

PREFERRED_PROVIDER_libgsmd = "libgsmd"

# older gtk-webcore releases don't work on ARM/EABI
# We need to switch to a fixed SRCDATE or release as soon as possible 
PREFERRED_VERSION_osb-browser      = "0.5.0+svn${SRCDATE}"
PREFERRED_VERSION_osb-jscore       = "0.5.2+svn${SRCDATE}"
PREFERRED_VERSION_osb-nrcit        = "0.5.2+svn${SRCDATE}"
PREFERRED_VERSION_osb-nrcore       = "0.5.2+svn${SRCDATE}"

PREFERRED_PROVIDER_avahi = "avahi"

#Small machines prefer kdrive, but we might ship full Xorg in other images
PREFERRED_PROVIDER_virtual/xserver  ?= "xserver-kdrive"
PREFERRED_PROVIDER_xserver          ?= "xserver-kdrive"

#use EABI ready toolchain
PREFERRED_VERSION_gcc               ?= "4.1.2"
PREFERRED_VERSION_gcc-cross         ?= "4.1.2"
PREFERRED_VERSION_gcc-cross-sdk     ?= "4.1.2"
PREFERRED_VERSION_gcc-cross-initial ?= "4.1.2"
PREFERRED_VERSION_gcc-cross-intermediate ?= "4.1.2"

PREFERRED_VERSION_gcc_dht-walnut               ?= "4.1.1"
PREFERRED_VERSION_gcc-cross_dht-walnut         ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-sdk_dht-walnut     ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-initial_dht-walnut ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-intermediate_dht-walnut ?= "4.1.1"

PREFERRED_VERSION_gcc_xilinx-ml403               ?= "4.1.1"
PREFERRED_VERSION_gcc-cross_xilinx-ml403         ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-sdk_xilinx-ml403     ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-initial_xilinx-ml403 ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-intermediate_xilinx-ml403 ?= "4.1.1"

PREFERRED_VERSION_gcc_mpc8323e-rdb               ?= "4.1.1"
PREFERRED_VERSION_gcc-cross_mpc8323e-rdb         ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-sdk_mpc8323e-rdb     ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-initial_mpc8323e-rdb ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-intermediate_mpc8323e-rdb ?= "4.1.1"

PREFERRED_VERSION_binutils          ?= "2.18"
PREFERRED_VERSION_binutils-cross    ?= "2.18"
PREFERRED_VERSION_binutils-cross-sdk ?= "2.18"

#avr32 only has patches for binutils 2.17 and gcc 4.1.2 in OE
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc_avr32 = "avr32-gcc-cross"
PREFERRED_VERSION_avr32-gcc               = "4.1.2"
PREFERRED_VERSION_avr32-gcc-cross         = "4.1.2"
PREFERRED_VERSION_gcc-cross-sdk_avr32     = "4.0.2"
PREFERRED_VERSION_gcc-cross-initial_avr32 = "4.0.2"
PREFERRED_VERSION_gcc-cross-intermediate_avr32 = "4.0.2"

PREFERRED_VERSION_binutils_avr32 = "2.17"
PREFERRED_VERSION_binutils-cross_avr32 = "2.17"
PREFERRED_VERSION_binutils-cross-sdk_avr32 = "2.17"

#This is unrelated to the kernel version, but userspace apps (e.g. HAL) require a recent version to build against
PREFERRED_VERSION_linux-libc-headers ?= "2.6.20"
PREFERRED_VERSION_linux-libc-headers_bfin = "2.6.21"

#Prefer glibc 2.5 and uclibc 0.9.29, these have had the most testing.
PREFERRED_VERSION_glibc ?= "2.5"
PREFERRED_VERSION_uclibc ?= "0.9.29"
PREFERRED_VERSION_uclibc-initial ?= "0.9.29"

#there's is no avr32 patch for 0.9.29
PREFERRED_VERSION_uclibc_avr32 = "0.9.28"
PREFERRED_VERSION_uclibc-initial_avr32 = "0.9.28"

PREFERRED_VERSION_glibc-initial ?= "2.5"

# To use an EABI compatible version 3 series gcc, either uncomment 
# the lines below or set them in local.conf: 
#
# PREFERRED_VERSION_gcc-cross = "3.4.4+csl-arm-2005q3"
# PREFERRED_VERSION_gcc-cross-initial = "3.4.4+csl-arm-2005q3"
# PREFERRED_VERSION_gcc-cross-intermediate = "3.4.4+csl-arm-2005q3"

#Loads preferred versions from files, these have weak assigments (?=), so put them at the bottom
require conf/distro/include/preferred-xorg-versions.inc
require conf/distro/include/preferred-gpe-versions-2.8.inc
require conf/distro/include/preferred-e-versions.inc


# Virtuals:
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils = "binutils-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-initial = "gcc-cross-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-intermediate = "gcc-cross-intermediate"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc = "gcc-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}g++ = "gcc-cross"

#Set preferred provider for the C library that is used to build the crosscompiler (NPTL voodoo)
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc               = "glibc"
PREFERRED_PROVIDER_virtual/arm-angstrom-linux-gnueabi-libc-for-gcc    = "glibc"
PREFERRED_PROVIDER_virtual/armeb-angstrom-linux-gnueabi-libc-for-gcc  = "glibc"
PREFERRED_PROVIDER_virtual/powerpc-angstrom-linux-libc-for-gcc        = "glibc"
PREFERRED_PROVIDER_virtual/mipsel-angstrom-linux-libc-for-gcc         = "glibc"
PREFERRED_PROVIDER_virtual/sparc-angstrom-linux-libc-for-gcc          = "glibc"

PREFERRED_PROVIDER_virtual/arm-angstrom-linux-uclibcgnueabi-libc-for-gcc    = "uclibc-initial"
PREFERRED_PROVIDER_virtual/armeb-angstrom-linux-uclibcgnueabi-libc-for-gcc  = "uclibc-initial"

# hostap stuff, we prefer the in-kernel modules, but those don't work for all machines
PREFERRED_PROVIDER_hostap-conf                      ?= "hostap-conf"
PREFERRED_PROVIDER_hostap-modules_h2200             ?= "hostap-modules"
PREFERRED_PROVIDER_hostap-modules_hx4700            ?= "hostap-modules"

PREFERRED_PROVIDER_virtual/db           ?= "db"
PREFERRED_PROVIDER_virtual/db-native    ?= "db-native"
PREFERRED_PROVIDER_virtual/libsdl       ?= "libsdl-x11"
PREFERRED_PROVIDER_virtual/libx11       ?= "libx11"
PREFERRED_PROVIDER_virtual/libxine      ?= "libxine-x11"
PREFERRED_PROVIDER_virtual/xserver      ?= "xserver-kdrive"

# Others:
PREFERRED_PROVIDER_linux-libc-headers = "linux-libc-headers"
PREFERRED_PROVIDER_dbus-glib             = "dbus-glib"
PREFERRED_PROVIDER_esound 		?= "pulseaudio"
PREFERRED_PROVIDER_gconf                ?= "gconf-dbus"
PREFERRED_PROVIDER_gnome-vfs            ?= "gnome-vfs"
PREFERRED_PROVIDER_gnome-vfs-plugin-file ?= "gnome-vfs"
PREFERRED_PROVIDER_tslib                ?= "tslib"
PREFERRED_PROVIDER_tslib-conf           ?= "tslib"
PREFERRED_PROVIDER_libgpewidget         ?= "libgpewidget"
PREFERRED_PROVIDER_ntp                  ?= "ntp"
PREFERRED_PROVIDER_hotplug               = "udev"
PREFERRED_PROVIDER_libxss                = "libxss"

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


#Silence a warning during parsing
PREFERRED_PROVIDER_task-bootstrap = "task-bootstrap"

#This is needed to get a correct PACKAGE_ARCH for packages that have PACKAGE_ARCH = ${MACHINE_ARCH}
ARM_ABI ?= "${@['','oabi'][bb.data.getVar('MACHINE',d) in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"
require conf/distro/include/angstrom${ARM_ABI}.inc

# do some task-base stuff here

# We want to ship extra debug utils in the rootfs when doing a debug build 
DEBUG_APPS ?= ""
DEBUG_APPS += '${@base_conditional("DISTRO_TYPE", "release", "", "strace procps",d)}'

#this should go away soon
EXTRA_STUFF ?= ""


# Angstrom want to ship some extra stuff. This should be moved into task-base eventually
# contains ipkg specific stuff as well :(

#work around a bitbake bug where mtd-utils-native isn't created so do_rootfs fails 
DISTRO_EXTRA_DEPENDS += " \
    mtd-utils-native \
    "    

DISTRO_EXTRA_RDEPENDS += "\
    update-modules \
    ${@base_contains("MACHINE_FEATURES", "screen", "exquisite", "",d)} \
    angstrom-version \
    opkg opkg-collateral distro-feed-configs \
    util-linux-mount util-linux-umount \
    ${EXTRA_STUFF} \
    ${DEBUG_APPS} \
    "

DISTRO_EXTRA_RRECOMMENDS += " \
    kernel-module-vfat \
    kernel-module-ext2 \
    kernel-module-af-packet \
    avahi-daemon \
    avahi-autoipd \
    openssh-sftp-server \
    "

SEPPUKU_NEWREPORT    = "http://bugs.openembedded.net/post_bug.cgi?bug_file_loc=http%3A%2F%2F&version=Angstrom%202007.12&priority=P2&bug_severity=normal&op_sys=Linux&rep_platform=Other&"

