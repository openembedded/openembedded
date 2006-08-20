require irk.inc

DESCRIPTION += "(version with Belkin support)"
RCONFLICTS = "irk-targus"
RREPLACES = "irk-targus"
PR = "r3"

SRC_URI = "http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/sources/irk-current.tgz \
           file://install-default-conf.patch;patch=1"
