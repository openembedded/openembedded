require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- dummy display driver"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
SRC_URI[archive.md5sum] = "3d96297556846bee02a74166ffb5d052"
SRC_URI[archive.sha256sum] = "5a4bbde0b7f0334bb63b159e5ef6e164be3699e3424734c2bd9823f20a30a278"
