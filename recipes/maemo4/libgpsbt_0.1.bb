LICENSE = "nokia"

PR = "r2"

DEPENDS = "libgpsmgr dbus"

# This is proprietary software in Chinook, so we have to stay with the last released
# free version.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-18.tar.gz \
           file://configure-fix-version.patch;patch=1"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

