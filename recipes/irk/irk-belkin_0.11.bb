require irk.inc

DESCRIPTION += "(version with Belkin support)"
RCONFLICTS = "irk-targus"
RREPLACES = "irk-targus"
PR = "r3"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/irk-current.tgz \
           file://install-default-conf.patch;patch=1"

SRC_URI[md5sum] = "a77eaea6930b9af5bbcd59bf9f8859c8"
SRC_URI[sha256sum] = "942240421710da8a04fa6c7071f50f0737ab7198e31c1d96f1e0b73330e0d066"
