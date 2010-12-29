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
SRCREV_pn-linux-ixp4xx ?= "1090"
PREFERRED_VERSION_linux-ixp4xx = "2.6.27.8+svnr${SRCREV_pn-linux-ixp4xx}"
#
#===============================================================================#
#===============================================================================#

### Standard package preferred versions go here, sorted
### alphabetically.  Note that the main slugos.inc file
### may include preferred versions for toolchain components.

PREFERRED_VERSION_atk				?= "1.28.0"
PREFERRED_VERSION_atk-native			?= "1.28.0"
PREFERRED_VERSION_autoconf			?= "2.65"
PREFERRED_VERSION_autoconf-native		?= "2.65"
PREFERRED_VERSION_automake			?= "1.11.1"
PREFERRED_VERSION_automake-native		?= "1.11.1"
PREFERRED_VERSION_binutils			?= "2.20.1"
PREFERRED_VERSION_binutils-cross		?= "2.20.1"
PREFERRED_VERSION_binutils-cross-sdk		?= "2.20.1"
PREFERRED_VERSION_busybox			?= "1.18.1"
PREFERRED_VERSION_dbus				?= "1.2.3"
PREFERRED_VERSION_eglibc			?= "2.11"
PREFERRED_VERSION_eglibc-initial		?= "2.11"
PREFERRED_VERSION_gcc				?= "4.4.4"
PREFERRED_VERSION_gcc-cross			?= "4.4.4"
PREFERRED_VERSION_gcc-cross-sdk			?= "4.4.4"
PREFERRED_VERSION_gcc-cross-initial		?= "4.4.4"
PREFERRED_VERSION_gcc-cross-intermediate	?= "4.4.4"
PREFERRED_VERSION_glib-2.0			?= "2.22.1"
PREFERRED_VERSION_glib-2.0-native		?= "2.22.1"
PREFERRED_VERSION_glibc				?= "2.10.1"
PREFERRED_VERSION_glibc-initial			?= "2.10.1"
PREFERRED_VERSION_gtk+				?= "2.18.6"
PREFERRED_VERSION_gtk+-native			?= "2.18.6"
PREFERRED_VERSION_ipkg				?= "0.99.163"
PREFERRED_VERSION_ipkg-native			?= "0.99.163"
PREFERRED_VERSION_libtool			?= "2.2.6b"
PREFERRED_VERSION_libtool-native		?= "2.2.6b"
PREFERRED_VERSION_libtool-cross			?= "2.2.6b"
PREFERRED_VERSION_libtool-sdk			?= "2.2.6b"
PREFERRED_VERSION_linux-libc-headers		?= "2.6.23"
PREFERRED_VERSION_m4				?= "1.4.14"
PREFERRED_VERSION_m4-native			?= "1.4.14"
PREFERRED_VERSION_nslu2-linksys-firmware	?= "2.3r63"
PREFERRED_VERSION_pkgconfig			?= "0.23"
PREFERRED_VERSION_pkgconfig-native		?= "0.23"
PREFERRED_VERSION_uclibc			?= "0.9.30.1"
PREFERRED_VERSION_uclibc-initial		?= "0.9.30.1"
PREFERRED_VERSION_udev				?= "118"

##################### Stuff with special notes, and broken stuff:

# Newer version required by glibc and some userspace apps
#PREFERRED_VERSION_linux-libc-headers		?= "2.6.31"

# boost 1.36 won't build
#PREFERRED_VERSION_boost				?= "1.33.1"

# pulseaudio 0.9.19 is broken (ASM errors during do_compile):
#PREFERRED_VERSION_pulseaudio                    ?= "0.9.15"

# latest tcl recipe has a bug that overwites regex.h; use the old tcl
#PREFERRED_VERSION_tcl				?= "8.4.19"

# We need the bluez4 version of the libs, which has default_precedence = -1
PREFERRED_VERSION_bluez-libs			?= "4.42"
