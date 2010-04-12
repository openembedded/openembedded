require irk.inc
PR = "r2"

DESCRIPTION += "(version with Targus support)"
HOMEPAGE = "http://angela1.data-uncertain.co.uk/~zaurus/irk.php"

RCONFLICTS = "irk-belkin"
RREPLACES = "irk-belkin"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/irk-${PV}.tgz \
           file://install-default-conf.patch;patch=1"

SRC_URI[md5sum] = "5b39a7fb06fd24edfb543a3a0130065c"
SRC_URI[sha256sum] = "5eeba81a5e5163e0b0b92b5e5aaf91c07b412a743a98f59975c75d28c133a85f"
