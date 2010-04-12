DESCRIPTION = "Nevow is a web application construction kit written in Python"
LICENSE = "MIT"

REALPN = "Nevow"

require divmod.inc

FILES_${PN} += "${datadir}"
DEPENDS += "python-twisted-native"


SRC_URI[md5sum] = "75828090af2b26f69fe4a7f148a400f6"
SRC_URI[sha256sum] = "bc35ce187481db91f047055b3edbce49c14d291b1a2eb3e915e9c1c511620f9a"
