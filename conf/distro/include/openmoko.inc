#
# Header
#
DISTRO_NAME = "OpenMoko"

#
# Naming schemes
#
INHERIT += "debian multimachine"

#
# Packaging and output format
#
INHERIT += "package_ipk"
IMAGE_FSTYPES = "tar.gz ext2.gz jffs2"
IMAGE_FSTYPES_x86 = "tar.gz"
IMAGE_ROOTFS_SIZE_ext2 = "131072"

#
# Binutils & Compiler
#
PREFERRED_PROVIDERS += " virtual/${TARGET_PREFIX}gcc-initial:gcc-cross-initial"
PREFERRED_PROVIDERS += " virtual/${TARGET_PREFIX}gcc:gcc-cross"
PREFERRED_PROVIDERS += " virtual/${TARGET_PREFIX}g++:gcc-cross"

# EABI stuff
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}-libc-for-gcc = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-angstrom-linux-gnueabi-libc-for-gcc = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-linux-libc-for-gcc = "glibc-intermediate"

#
# Target OS & FPU system
# 
TARGET_OS = "linux"
TARGET_FPU_arm = "soft"
TARGET_FPU_armeb = "soft"
PREFERRED_PROVIDER_virtual/libiconv = "glibc"
PREFERRED_PROVIDER_virtual/libintl = "glibc"
PREFERRED_VERSION_linux-libc-headers_x86 = "2.6.15.99"
PREFERRED_VERSION_linux-libc_headers = "2.6.18"
#
# Features
#
DISTRO_FEATURES = "alsa bluetooth ext2 ipsec nfs ppp smbfs usbgadget usbhost"

#
# Bootstrap & Init
#
require conf/distro/include/sane-srcdates.inc

#
# Framebuffer & X
#
PREFERRED_PROVIDER_virtual/libx11 ?= "libx11"
PREFERRED_PROVIDER_virtual/ecore ?= "ecore-x11"
PREFERRED_PROVIDER_virtual/evas ?= "evas-x11"
PREFERRED_PROVIDER_virtual/esmart ?= "esmart-x11"
PREFERRED_PROVIDER_virtual/libsdl = "libsdl-x11"
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-kdrive"
PREFERRED_PROVIDER_tslib ?= "tslib"
PREFERRED_PROVIDER_xserver ?= "xserver-kdrive"
require conf/distro/include/preferred-xorg-versions-X11R7.1.inc

#
# Gnome
#
PREFERRED_PROVIDER_dbus-glib = "dbus-glib"
PREFERRED_PROVIDER_gconf = "gconf-dbus"
#new
#PREFERRED_PROVIDER_gnome-vfs = "gnome-vfs"
#old
PREFERRED_PROVIDER_gnome-vfs = "gnome-vfs"
PREFERRED_PROVIDER_gnome-vfs-plugin-file = "gnome-vfs"

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_bluez-utils = "bluez-utils-dbus"

PREFERRED_VERSION_dbus-native = "1.0.2"
PREFERRED_VERSION_dbus = "1.0.2"
PREFERRED_VERSION_dbus-glib-native = "0.71"
PREFERRED_VERSION_dbus-glib = "0.71"
PREFERRED_VERSION_atk = "1.9.0"
PREFERRED_VERSION_pango = "1.8.2"
PREFERRED_VERSION_glib-2.0 = "2.12.3"
PREFERRED_VERSION_gtk+ = "2.6.10"
PREFERRED_VERSION_gtk-engines = "2.6.5"
#PREFERRED_VERSION_gnome-vfs = "2.16.3"

PREFERRED_VERSION_fontconfig = "2.4.1"

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
#
# GPE
#
PREFERRED_PROVIDER_libgpewidget = "libgpewidget"

#
# O-Hand
#
PREFERRED_VERSION_contacts = "0.1"
PREFERRED_VERSION_dates = "0.1"
# PREFERRED_VERSION_web = "???"

#
# Development
#
PREFERRED_PROVIDER_qemu-native = "qemu-native"
PREFERRED_VERSION_qemu-native = "0.9.0+cvs${SRCDATE}"

#
# Opie
#
QTE_VERSION = "2.3.10"
PALMTOP_USE_MULTITHREADED_QTE = "yes"
require conf/distro/include/preferred-opie-versions.inc

#
# Enlightenment
#
require conf/distro/include/preferred-e-versions.inc

#
# OpenMoko
#

#We comment this out since external developers don't needs to use SRCDATE="now" as that generated unneed traffic
#require conf/distro/include/preferred-openmoko-versions.inc

