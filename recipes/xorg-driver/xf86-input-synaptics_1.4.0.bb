require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- mouse input driver"
PE = "1"
PR = "${INC_PR}.0"

EXTRA_OEMAKE += " sdkdir=${STAGING_INCDIR}/xorg "

SRC_URI[archive.md5sum] = "cbe487f9d22237d1e39c7d0b5812ab7e"
SRC_URI[archive.sha256sum] = "5874d979f028636dbddf14fffb84b496b006e63d5ea8dfa120820e58642812c2"
