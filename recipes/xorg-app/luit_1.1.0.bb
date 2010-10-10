require xorg-app-common.inc
DESCRIPTION = "a filter for locale and ISO 2022 support on Unicode terminals"
DEPENDS += " zlib zlib libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "cb9377b09e562e4084cc614a44df2641"
SRC_URI[archive.sha256sum] = "f1fafd7ea9486b3ff099d184ca9dde15d08445adfb5ecd3fde9a403b7d5903d1"
