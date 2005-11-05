PACKAGES = gpe-task-apps-extra gpe-task-games gpe-task-web gpe-task-desktopapps
DESCRIPTION = "Meta-package of extra applications for the GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR="r1"

ALLOW_EMPTY = 1

gpe-task-apps-extra = "\
    gpe-filemanager \
    gpe-nmf \
    gpe-soundbite \
    mbmerlin"

RDEPENDS_gpe-task-apps-extra := "${gpe-task-apps-extra}"
DEPENDS += " ${gpe-task-apps-extra}"

gpe-task-web = "\
    gpe-irc \
    minimo \
    gaim"

RDEPENDS_gpe-task-web := "${gpe-task-web}"
DEPENDS += " ${gpe-task-web}"

gpe-task-desktopapps = "\
    firefox \
    thunderbird \
    galculator \
    gnumeric \
    gpdf \
    totem"

RDEPENDS_gpe-task-desktopapps := "${gpe-task-desktopapps}"
DEPENDS += " ${gpe-task-desktopapps}"
LICENSE = MIT
