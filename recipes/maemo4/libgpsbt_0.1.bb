LICENSE = "nokia"

PR = "r1"

DEPENDS = "libgpsmgr dbus"

# This is proprietary software in Chinook, so we have to stay with the last released
# free version.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-18.tar.gz"

inherit autotools pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"

do_stage() {
        autotools_stage_all
}


