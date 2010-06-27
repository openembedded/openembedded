require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- VMMouse input driver to use with VMWare"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6b7f2ffffc650ed61c9d333aeece893f"
SRC_URI[archive.sha256sum] = "a5e2069fc080de9c7d037c0def0135a5c93b76a8b535099e021d65a5e1d0b00f"

COMPATIBLE_HOST = "i.86.*-linux"
