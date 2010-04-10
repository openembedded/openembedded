require poppler.inc

PR = "r1"

SRC_URI += "file://fix-splash.patch;patch=1"
EXTRA_OECONF_append = " --disable-abiword-output "


SRC_URI[md5sum] = "8d1ac008614c0e413bcac95b8102fa07"
SRC_URI[sha256sum] = "bee251e5149ac9dd8824aac316456b78a82f4e1954eb3c1a94db3625340ef61e"
