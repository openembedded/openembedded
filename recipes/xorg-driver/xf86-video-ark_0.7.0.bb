require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- ark display driver"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
SRC_URI[archive.md5sum] = "6826c556ebe9a1248cbc7f7edd44f956"
SRC_URI[archive.sha256sum] = "8e65e73045fabe37c15f6d4895baa09346bdac2f7537607b523aacd7bcf57594"
