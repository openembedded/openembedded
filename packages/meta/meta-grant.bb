PACKAGES = grant-base-depends grant-task-base grant-task-settings grant-task-apps
DESCRIPTION = "Meta-package for Grant Palmtop Environment(Based on GPE)"
MAINTAINER = "Jeremy Grant <jeremy@thegrantclan.org>"
PR = "r1"

ALLOW_EMPTY = 1

grant-base-depends = "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_grant-base-depends := "${grant-base-depends}"
DEPENDS += " ${grant-base-depends}"

grant-task-base = "\
    matchbox \
    xcursor-transparent-theme \
    rxvt-unicode \
    gtk2-theme-angelistic \
    xst \
    xprop \
    xhost \
    xrdb \
    gpe-soundserver \
    ttf-bitstream-vera \
    gpe-dm \
    gpe-login \
    gpe-session-scripts \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    gpe-bootsplash \
    libgtkstylus \
    detect-stylus"

RDEPENDS_grant-task-base := "glibc-gconv \
			   glibc-gconv-iso8859-1 \
			   gdk-pixbuf-loader-png \
			   gdk-pixbuf-loader-xpm \
			   gdk-pixbuf-loader-jpeg \
			   pango-module-basic-x \
			   pango-module-basic-fc \
			   ${gpe-task-base}"
DEPENDS += " ${grant-task-base}"

grant-task-settings = "\
    matchbox-panel-manager \
    gpe-bluetooth \
    gpe-su \
    gpe-conf \
    gpe-clock \
    gpe-mininet \
    gpe-mixer \
    gpe-shield \
    gpe-wlancfg \
    gpe-taskmanager \
    keylaunch \
    minilite \
    xmonobut"

RDEPENDS_grant-task-settings := "${grant-task-settings}"
DEPENDS += " ${grant-task-settings}"

grant-task-apps = "\
    gpe-calculator \
    gpe-package \
    gpe-terminal \
    gpe-watch \
    matchbox-panel-hacks \
    rosetta \
	 bash \
	 bitchx \
	 sudo \
	 vim"

RDEPENDS_grant-task-apps := "${grant-task-apps}"
DEPENDS += " ${grant-task-apps}"
LICENSE = MIT
