require libxsettings-client.inc

DEPENDS += "gtk-doc"
PR ="r2"

SRC_URI += "file://no-host-includes.patch;patch=1 "

SRC_URI[md5sum] = "2c052bbe613d2d83abad391824b217ad"
SRC_URI[sha256sum] = "900e9b131bd357a3e6bcc5fe9a94d42018d9cf52e85d1c772a7e69a7f99ea9ab"
