require xorg-app-common.inc
PE = "1"

DESCRIPTION = "adjust backlight brightness using RandR extension"

DEPENDS += " virtual/libx11 libxrender libxrandr"

SRC_URI[archive.md5sum] = "3e39eec6d0fd5c587ca6d55aa7bb8fe1"
SRC_URI[archive.sha256sum] = "5d32d891c83b9c0089231f4f1c424ab02301b627ce26e5c2e6e397b8ea606fb2"
