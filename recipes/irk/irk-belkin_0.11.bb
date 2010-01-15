require irk.inc

DESCRIPTION += "(version with Belkin support)"
RCONFLICTS = "irk-targus"
RREPLACES = "irk-targus"
PR = "r3"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/irk-current.tgz \
           file://install-default-conf.patch;patch=1"
