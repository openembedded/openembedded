DESCRIPTION = "libusb is a library to provide userspace access to USB \
devices.  This version is a metapackage that pulls in libusb-compat, \
the replacement for libusb."

# This version of libusb will never be pulled in automagically.  The
# intention is that a distro wishing to use libusb1 and libusb-compat
# will place the following in the appropriate conf file:
#
# PREFERRED_VERSION_libusb = "0.0.0"
#
# This essentially results in the replacement of libusb by libusb-compat,
# and resolves the issues of some packages depending on libusb, while
# other (newer) ones depend on libusb-compat.
#
# Note that using this version of libusb will break certain packages
# that cannot work with libusb-compat (gnuradio is said to be such a
# packages, as is dfu-util).  Unfortunately other packages (such as bluez)
# require libusb-compat -- there's no good solution for this conflict
# at this time.  The fundamental problem is that both libusb and
# libusb-compat stage to the same libs (/usr/lib/libusb.a, for example),
# so if you have built both, the last one staged wins.
#
# This "hack" seems to be the most flexible and least intrusive workaround.

DEFAULT_PREFERENCE = "-1"

DEPENDS = "libusb-compat"
