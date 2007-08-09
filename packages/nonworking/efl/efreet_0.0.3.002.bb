DESCRIPTION = "An implementation of freedesktop.org specs for the EFL"
DEPENDS = "virtual/ecore"
LICENSE = "BSD"
PR = "r0"

inherit efl

headers += "efreet_base.h efreet_desktop.h efreet_icon.h efreet_ini.h efreet_menu.h efreet_private.h efreet_utils.h efreet_xml.h"
