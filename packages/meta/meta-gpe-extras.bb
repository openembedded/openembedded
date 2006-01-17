DESCRIPTION = "Meta-package of extra applications for the GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = MIT
PR="r2"

ALLOW_EMPTY = 1
BUILD_ALL_DEPS = "1"

DEPENDS = "task-gpe"

RDEPENDS = "\
    gpe-task-apps-extra \
    gpe-task-games \
    gpe-task-web \
    gpe-task-desktopapps"


