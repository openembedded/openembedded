require xorg-font-common.inc

DESCRIPTION = "X font aliases."

DEPENDS = "virtual/xserver font-util"
RDEPENDS = "encodings font-util"

PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "9d40dba6fb8cb58dacb433fc7bcaafca"
SRC_URI[archive.sha256sum] = "438bd6f3f9305edb6ea9905dc92c135d6067bbd7e01df913cb3ef27162b38270"
