inherit gpe

DESCRIPTION = "An Othello clone using GTK, hacked from ugothello."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe/games"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-makefiles.patch;patch=1"

SRC_URI[md5sum] = "2997e14b0956e73580e6c19ade35eb4f"
SRC_URI[sha256sum] = "8beb35d6bc48e083adc6dd39851632f042ad364b5b8579c14bf8cdcf7dd91552"
