require gpe-clock.inc

PR = "${INC_PR}.0"

SRC_URI += "file://fix-install.patch;patch=1"

SRC_URI[md5sum] = "b0b2c843a562f72df32a66993a215e3c"
SRC_URI[sha256sum] = "ff0dfe70c1ac68180dfb26da83d9aee9f0e9007d428dae225abe7dc3bba512b9"
