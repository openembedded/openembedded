include irk.inc

DESCRIPTION += "(version with Targus support)"
HOMEPAGE = "http://angela1.data-uncertain.co.uk/~zaurus/irk.php"

RCONFLICTS = "irk-belkin"
RREPLACES = "irk-belkin"

SRC_URI = "http://angela1.data-uncertain.co.uk/~zaurus/irk-${PV}.tgz \
           file://install-default-conf.patch;patch=1"
