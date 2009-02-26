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

### Standard package preferred versions go here, sorted
### alphabetically.  Note that the main slugos.inc file
### may include preferred versions for toolchain components.

PREFERRED_VERSION_automake-native		?= "1.10"
PREFERRED_VERSION_binutils			?= "2.18.50.0.7"
PREFERRED_VERSION_binutils-cross		?= "2.18.50.0.7"
PREFERRED_VERSION_binutils-cross-sdk		?= "2.18.50.0.7"
PREFERRED_VERSION_busybox			?= "1.13.2"
PREFERRED_VERSION_dbus				?= "1.2.1"
PREFERRED_VERSION_gcc				?= "4.2.4"
PREFERRED_VERSION_gcc-cross			?= "4.2.4"
PREFERRED_VERSION_gcc-cross-sdk			?= "4.2.4"
PREFERRED_VERSION_gcc-cross-initial		?= "4.2.4"
PREFERRED_VERSION_gcc-cross-intermediate	?= "4.2.4"
PREFERRED_VERSION_glib-2.0			?= "2.18.3"
PREFERRED_VERSION_glib-2.0-native		?= "2.18.0"
PREFERRED_VERSION_glibc				?= "2.6.1"
PREFERRED_VERSION_glibc-initial			?= "2.6.1"
PREFERRED_VERSION_ipkg				?= "0.99.163"
PREFERRED_VERSION_ipkg-native			?= "0.99.163"
PREFERRED_VERSION_libtool			?= "1.5.10"
PREFERRED_VERSION_libtool-native		?= "1.5.10"
PREFERRED_VERSION_libtool-cross			?= "1.5.10"
PREFERRED_VERSION_libtool-sdk			?= "1.5.10"
PREFERRED_VERSION_linux-libc-headers		?= "2.6.23"
PREFERRED_VERSION_m4				?= "1.4.8"
PREFERRED_VERSION_m4-native			?= "1.4.8"
PREFERRED_VERSION_netatalk			?= "2.0.3"
PREFERRED_VERSION_nslu2-linksys-firmware	?= "2.3r63"
PREFERRED_VERSION_pkgconfig			?= "0.23"
PREFERRED_VERSION_pkgconfig-native		?= "0.23"
PREFERRED_VERSION_udev				?= "118"

##################### Stuff with special notes, and broken stuff:

# libtool/pkgconfig victims -- these packages are locked down because
# newer versions also require newer libtool/pkgconfig versions.

PREFERRED_VERSION_avahi				?= "0.6.23"
PREFERRED_VERSION_gst-plugins-base		?= "0.10.17"
PREFERRED_VERSION_tiff				?= "3.7.2"
PREFERRED_VERSION_fakeroot			?= "1.9.6"
PREFERRED_VERSION_fakeroot-native		?= "1.9.6"

# Hack alert - selecting this version of libusb effectively selects
# the use of libusb1 and libusb-compat in the case that something
# still depends on libusb. This is required because otherwise
# libusb will overwrite libusb-compat in staging.
PREFERRED_VERSION_libusb			?= "0.0.0"

# mtd-utils 1.2.0+git cannot be fetched, so SlugOS will stick
# with 1.1.0 for now:
PREFERRED_VERSION_mtd-utils			?= "1.1.0"

# boost 1.36 won't build
PREFERRED_VERSION_boost				?= "1.33.1"

####################### Obsolete stuff, not sure why we keep this:

# New pango and older glib-2.0 versions don't mix,
# so specify exactly what we would like to build.
#PREFERRED_VERSION_pango    ?= "1.20.5"
#PREFERRED_VERSION_glib-2.0 ?= "2.16.1"
#PREFERRED_VERSION_cairo    ?= "1.4.8"
#
# Stick with an older gettext and e2fsprogs stuff
# and gnutls... (our autotools is too old at the moment)
#PREFERRED_VERSION_gnutls           ?= "1.6.3"
#PREFERRED_VERSION_gettext          ?= "0.14.1"
#PREFERRED_VERSION_gettext-native   ?= "0.14.1"
#PREFERRED_VERSION_e2fsprogs-libs   ?= "1.39"
#PREFERRED_VERSION_e2fsprogs        ?= "1.38"
#PREFERRED_VERSION_e2fsprogs-native ?= "1.38"

