require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- dummy display driver"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
SRC_URI[archive.md5sum] = "3ffe3a28f4452e66bf56180e7da9cbc5"
SRC_URI[archive.sha256sum] = "df3f55de7953dba6d7ce10cc5f355da1a6164f781ad9393a38dae502dba4955d"
