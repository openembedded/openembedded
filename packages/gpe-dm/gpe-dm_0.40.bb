LICENSE = "GPL"
inherit gpe update-rc.d

DESCRIPTION = "GPE Desktop Manager"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "glib-2.0"
PR = "r2"

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "defaults 99"

