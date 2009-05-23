DESCRIPTION = "SHR Feed"
PR = "r14"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
		python-elementary \
		openmoko-agpsui \
		mc \
		mplayer \
		x11vnc \
		omview \
		openvpn \
		navit \
		pythm \
		fbreader \
		omoney \
		enotes \
		epdfview \
		pyphonelog \
		pingus \
		mokomaze \
		openmoocow \
		vagalume \
		python-pygame \
		mokoko \
		bluez-utils-alsa \
		obexpush \
		obexftp \
		gpe-calendar \
		fltk-chess \
		remoko \
		shr-config \
                shr-splash \
		shr-splash-theme-simple \
                shr-splash-theme-dontpanic \
		openbmap-logger \
		ffalarms \
		libnotify \
		accelges \
		gpe-todo \
		ebrainy \
		sms-sentry \
		cellhunter \
		dillo2 \
		usbmode \
		pyefl-sudoku \
		tasks \
		dates \
		omnewrotate \
		xchat \
		python-pyid3lib \
		libframeworkd-phonegui-efl2 \
		intone \
		vim \
		vpnc \
		emacs \
		mcabber \
		gdb \
                oh-puzzles \
"
