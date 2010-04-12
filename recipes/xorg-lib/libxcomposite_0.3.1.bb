require xorg-lib-common.inc
PE = "1"

DESCRIPTION = "X Composite extension library."
LICENSE= "BSD-X"

DEPENDS += " compositeproto virtual/libx11 libxfixes"
PROVIDES = "xcomposite"

XORG_PN = "libXcomposite"

SRC_URI += " file://change-include-order.patch;patch=1"

SRC_URI[archive.md5sum] = "a80650d660486ea7bb2e5fd84a83799a"
SRC_URI[archive.sha256sum] = "d42b59d3c38dae5e4fec375d12e56e7a5764ba10e8b8ec70f9ce951fc9cec72b"
