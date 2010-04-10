DESCRIPTION = "GPE task manager"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpelaunch libgpewidget"

inherit gpe

SRC_URI += "file://setlocale.patch;patch=1"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "3754287bfccdcc7d219a3118ea2dd53f"
SRC_URI[sha256sum] = "71c07e58b9eaa66ff140f5baa76c14d0fe3120223687bbb4b9817fe55b5e52e4"
