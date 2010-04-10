LICENSE = "nokia"

PR = "r2"

DEPENDS = "libgpsmgr dbus"

# This is proprietary software in Chinook, so we have to stay with the last released
# free version.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-18.tar.gz \
           file://configure-fix-version.patch;patch=1"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"


SRC_URI[md5sum] = "ce884aff8d063f9d51ebf75d899747fa"
SRC_URI[sha256sum] = "495ebd711a63bee4eeaae7f0766323f2070bf30ab9b54f5ac18912baa1b41084"
