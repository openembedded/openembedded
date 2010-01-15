require irk.inc
PR = "r2"

DESCRIPTION += "(version with Targus support)"
HOMEPAGE = "http://angela1.data-uncertain.co.uk/~zaurus/irk.php"

RCONFLICTS = "irk-belkin"
RREPLACES = "irk-belkin"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/irk-${PV}.tgz \
           file://install-default-conf.patch;patch=1"
