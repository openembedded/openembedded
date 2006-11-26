DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r24"
ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "\
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-gpe-task-pim \
    angstrom-gpe-task-apps \
    angstrom-gpe-task-games \
    angstrom-task-office \
    angstrom-task-printing \
    angstrom-task-sectest"

RDEPENDS_angstrom-x11-base-depends := "\
    virtual/libx11 \
    virtual/xserver \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "

RDEPENDS_angstrom-gpe-task-base := "\
    matchbox \
    matchbox-panel-hacks \
    xcursor-transparent-theme \
    rxvt-unicode \
    gpe-terminal \
    matchbox-keyboard \
    gpe-theme-clearlooks \
    xst \
    xhost \
    xrdb \
    gpe-soundserver \
    gpe-dm \
    gpe-login \
    gpe-session-scripts \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    libgtkstylus \
    suspend-desktop \
    teleport \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc"

RDEPENDS_angstrom-gpe-task-pim := "\
    gpe-timesheet \
    gpe-todo \
    gpe-calendar \
    gpe-contacts \
    gpesyncd"

RDEPENDS_angstrom-gpe-task-settings := "\
    matchbox-panel-manager \
    gpe-su \
    gpe-conf \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    minilite \
    minimix \
    xmonobut"

RDEPENDS_angstrom-gpe-task-apps := "\
    gpe-edit \
    gpe-gallery \
    gpe-calculator \
    gpe-clock \
    gpe-plucker \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    gpe-aerial \
    gpe-soundbite \
    rosetta \
    gpe-scap \
    gpe-windowlist"

RDEPENDS_angstrom-gpe-task-games := "\
    gpe-go \
    gpe-lights \
    gpe-othello \
    gpe-tetris \
    gsoko \
#    xdemineur \
"

RDEPENDS_angstrom-task-office := "\
    gnumeric \
    abiword \
    imposter \
#    evince \
    gqview"

RDEPENDS_angstrom-task-printing := "\
    cups \
    gnome-cups-manager"

RDEPENDS_angstrom-task-sectest := "\
    nmap \
    ettercap \
    stunnel \
    curl \
#    dsniff \
    prismstumbler \
#    tcpdump \
    kismet \
    hydra \
#    thcrut \
#    driftnet \
    miniclipboard"
