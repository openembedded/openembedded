PACKAGES = gpe-task-apps-extra gpe-task-games gpe-task-web gpe-task-desktopapps
DESCRIPTION = "Meta-package of extra applications for the GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR="r1"

ALLOW_EMPTY = 1

RDEPENDS_gpe-task-apps-extra := "\
    gpe-filemanager \
    gpe-nmf \
    gpe-soundbite \
    mbmerlin"

RDEPENDS_gpe-task-web := "\
    gpe-irc \
    minimo \
    gaim"

RDEPENDS_gpe-task-desktopapps := "\
    firefox \
    thunderbird \
    galculator \
    gnumeric \
    gpdf \
    totem"

LICENSE = MIT
