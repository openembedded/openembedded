require xorg-app-common.inc

DESCRIPTION = "X Event Viewer"
LICENSE = "MIT"
PE = "1"

SRC_URI += "file://diet-x11.patch;patch=1"

SRC_URI[archive.md5sum] = "5f98c0a2725a33d60ef4956befe078fb"
SRC_URI[archive.sha256sum] = "7fad9c9755a624e677f44633dee218e9c22b4ba9a83e6709a6cbf8c1a501fde8"
