DESCRIPTION = "Task for Beagleboard-demo-image"

inherit task 

ECONFIG ?= "e-wm-config-standard e-wm-config-default"

RDEPENDS_${PN} = "\
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-zeroconf-audio \
    angstrom-led-config \ 
    gpe-scap \
    psplash \
    mime-support e-wm ${ECONFIG} exhibit \
    xterm xmms \
    epiphany firefox midori \
    swfdec-mozilla \
    hicolor-icon-theme gnome-icon-theme \
    jaaa nmap iperf gnuplot \
    abiword \
    gnumeric \
    gimp \
    powertop oprofile \
    pidgin \
#    irssi \
    mplayer omapfbplay \
    gnome-games \
    rt73-firmware zd1211-firmware \
    stalonetray \
	synergy \
	x11vnc \
	angstrom-gnome-icon-theme-enable \
"
