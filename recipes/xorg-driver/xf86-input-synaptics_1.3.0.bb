require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- mouse input driver"
PE = "1"
PR = "${INC_PR}.1"

EXTRA_OEMAKE += " sdkdir=${STAGING_INCDIR}/xorg "

SRC_URI[archive.md5sum] = "b4e58eba1bdca13f0929a4b03b262135"
SRC_URI[archive.sha256sum] = "30a33250c4f3d2daa8a61cab847dc7befd3248db0fca139d17fd7b890b5a8fd7"
