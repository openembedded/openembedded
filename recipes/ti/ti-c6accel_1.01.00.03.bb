require ti-c6accel.inc

SRC_URI[c6accelbin.md5sum] = "0ddf37fd9dad91fa3a914e549da933b9"
SRC_URI[c6accelbin.sha256sum] = "453399a84bf117bd7a91393242c7c005e2829692db5ede18e4be166c61e4354c"

SRC_URI_append = "file://fix-loadmodule.patch \
                  file://0001-soc-honour-buildsystem-CFLAGS-and-LDFLAGS-when-set.patch \
                 "

PV = "1_01_00_03"


CFLAGS += "-fPIC"

