require irk.inc

DESCRIPTION += "(version with Belkin support)"
RCONFLICTS = "irk-targus"
RREPLACES = "irk-targus"
PR = "r3"

SRC_URI = "http://kopsisengineering.com/irk-current.tgz \
           file://install-default-conf.patch;patch=1"
