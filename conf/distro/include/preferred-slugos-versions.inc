#===========================================================================#
#===========================================================================#
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
SRCREV_pn-linux-ixp4xx ?= "1091"
PREFERRED_VERSION_linux-ixp4xx = "2.6.37+svnr${SRCREV_pn-linux-ixp4xx}"
#
#===========================================================================#
#===========================================================================#

### Standard package preferred versions go here, sorted
### alphabetically.  Note that the main slugos.inc file
### may include preferred versions for toolchain components.

PREFERRED_VERSION_atk				?= "1.28.0"
PREFERRED_VERSION_atk-native			?= "1.28.0"
PREFERRED_VERSION_autoconf			?= "2.65"
PREFERRED_VERSION_autoconf-native		?= "2.65"
PREFERRED_VERSION_automake			?= "1.11.1"
PREFERRED_VERSION_automake-native		?= "1.11.1"
PREFERRED_VERSION_busybox			?= "1.18.3"
PREFERRED_VERSION_dbus				?= "1.4.1"
PREFERRED_VERSION_glib-2.0			?= "2.26.1"
PREFERRED_VERSION_glib-2.0-native		?= "2.26.1"
PREFERRED_VERSION_gvfs				?= "1.6.6"
PREFERRED_VERSION_linux-libc-headers		?= "2.6.31"
PREFERRED_VERSION_m4				?= "1.4.14"
PREFERRED_VERSION_m4-native			?= "1.4.14"
PREFERRED_VERSION_nslu2-linksys-firmware	?= "2.3r63"
PREFERRED_VERSION_perl				?= "5.10.1"
PREFERRED_VERSION_perl-native			?= "5.10.1"
PREFERRED_VERSION_pkgconfig			?= "0.23"
PREFERRED_VERSION_pkgconfig-native		?= "0.23"
PREFERRED_VERSION_udev				?= "118"
