include irk.inc

DESCRIPTION += "(version with Targus support)"

RCONFLICTS = "irk-belkin"
PR = "r1"

SRC_URI = "http://angela1.data-uncertain.co.uk/~zaurus/irk-${PV}.tgz \
           file://install-default-conf.patch;patch=1"
