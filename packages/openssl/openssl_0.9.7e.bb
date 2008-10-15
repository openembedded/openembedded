require openssl.inc

FILE_PR = "r6"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1 \
            file://gnueabi-arm.patch;patch=1"
