DESCRIPTION = "Nevow is a web application construction kit written in Python"
LICENSE = "MIT"

REALPN = "Nevow"

require divmod.inc

FILES_${PN} += "${datadir}"
DEPENDS += "python-twisted-native"

