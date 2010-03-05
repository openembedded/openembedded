DESCRIPTION = "SHR Feed"
PR = "r44"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
		babiloo-efl \
		claws-mail \
		claws-plugin-mailmbox \
#		claws-plugin-gtkhtml2-viewer \
		claws-plugin-rssyl \
		di \
		dictator \
		dosbox \
		enotes \
		epdfview \
		estardict \
		fbreader \
		ffalarms \
		gpe-calendar \
		gpe-todo \
		gpe-scap \
		gpe-sketchbook \
		gpe-filemanager \
		gpe-gallery \
		gpe-timesheet \
		gpe-contacts \
		gtkmm \
		guitartune \
		jefliks \
		mc \
		mpd \
		mplayer \
		navit \
# omview depends on deprecated (now broken) epsilon
#		omview \
		orrery \
		python-elementary \
		pythm \
		python-wifi \
		omoney \
		openmoko-agpsui \
		openvpn \
		pyphonelog \
#		shr-config \
		shr-today \
                shr-theme-neo \
		shr-theme-niebiee \
		shr-theme-sixteen \
# gry should be in image already
#		shr-theme-gry \
		shr-splash \
		shr-splash-theme-simple \
		shr-splash-theme-dontpanic \
		shr-splash-theme-handy \
		vagalume \
		wireshark \
		x11vnc \

		pingus \
		openmoocow \
		python-pygame \
		mokoko \
#		exhibit \
		edje-viewer \
		obexpush \
		obexftp \
		obex-data-server \
		mtpaint \
		telepathy-python \
		intone-video \
		ipkg-link \
		ipkg-utils \
		mysql \
		fltk-chess \
		remoko \
		openbmap-logger \
		pisi \
		libnotify \
		accelges \
		ebrainy \
		sms-sentry \
		cellhunter \
		dillo2 \
		pyefl-sudoku \
#		tasks \
		dates \
		omnewrotate \
		xchat \
		python-pyid3lib \
#		libframeworkd-phonegui-efl2 \
		intone \
		vim \
		vpnc \
#		emacs \
		mcabber \
		gdb \
		oh-puzzles \
		links-x11 \
		e-wm-illume-dict-pl \
		callrec \
		midori \
		numptyphysics \
		pidgin \
		libpurple-protocol-msn \
		libpurple-protocol-icq \
		vagalume \
		ppp \
		bluez-hcidump \
		kbdd \
		kexec-tools \
		mc \
		iotop \
		xprop \
		xev \
		xwininfo \
		tcpdump \
		lsof \
		zsh \
		gzip \
		zip \
		microcom \
		minicom \
		leafpad \
		abiword \
		aspell \
		enchant \
		joe \
		nano \
		ntpclient \
		ntp \
		tor \
		vnc \
#		gpsdrive \
		wxwidgets \
		x11vnc \
#		libswt3.4-gtk-java \
		cacao \
#		jamvm \
		dbus-x11 \
#		bluez-utils-alsa \
		xournal \
#		evince \
#		asterisk \
		git \
		ruby \
		synergy \
		irssi \
		zhone \
		paroli \
		cu \
		net-tools \
		iproute2 \
		iputils \
		i2c-tools \
		psmisc \
		debianutils \
		tcptraceroute \
		task-proper-tools \
		wmiconfig \
		netkit-telnet \
		bind-utils \
		bubble-keyboard \
		intuition \
		gridpad \
#		essential-dialer \
		font-adobe-100dpi \
		font-adobe-75dpi \
		font-adobe-utopia-100dpi \
		font-adobe-utopia-75dpi \
#		font-adobe-utopia-type1 \
		font-arabic-misc \
		font-bh-100dpi \
		font-bh-75dpi \
		font-bh-lucidatypewriter-100dpi \
		font-bh-lucidatypewriter-75dpi \
#		font-bh-ttf \
#		font-bh-type1 \
		font-bitstream-100dpi \
		font-bitstream-75dpi \
		font-bitstream-speedo \
#		font-bitstream-type1 \
		font-cronyx-cyrillic \
		font-cursor-misc \
		font-daewoo-misc \
		font-dec-misc \
#		font-ibm-type1 \
		font-isas-misc \
		font-jis-misc \
		font-micro-misc \
		font-misc-cyrillic \
#		font-misc-ethiopic \
#		font-misc-meltho \
		font-misc-misc \
		font-mutt-misc \
		font-schumacher-misc \
		font-screen-cyrillic \
		font-sony-misc \
		font-sun-misc \
		font-winitzki-cyrillic \
#		font-xfree86-type1 \
#		msn-pecan \
		qwo \
		fso-apm \
		fso-abyss \
		fsousaged \
		fsodeviced \
		fsonetworkd \
		mdbus \
		mickeyterm \
		opimd-utils \
		omgps \
		shr-launcher \
		e-tasks \
		elmdentica \
		shr-installer \
		eject \
		illume-keyboard-arabic \
		illume-keyboard-browse \
		illume-keyboard-danish \
		illume-keyboard-default-alt \
		illume-keyboard-dutch \
		illume-keyboard-dvorak \
		illume-keyboard-french \
		illume-keyboard-german \
		illume-keyboard-hebrew \
		illume-keyboard-numeric-alt \
		illume-keyboard-default-numeric \
		illume-keyboard-russian \
		illume-keyboard-russian-terminal \
		python-xlib \
		xcompmgr \
		man \
		man-pages \
		aceofpenguins-launcher \
		om-neon \
		ipython \
#		phoneme-advanced-foundation \
#		eve was killed in svnr45979
		python-pybluez \
		x11perf \
		pyring \
		bt-configure \
		bt-gps \
		advancedcaching \
		bonnie++ \
		reiserfsprogs \
		blipomoko \
		imagemagick \
		xboard \
		sox \
#		mpg123 \
		zile \
		speex \
		podpooch \
		fltkclock \
		fltkhackdiet \
		fltkwwpointcal \
		transmission \
		xf86-input-tslib \
		fltkcocktailbar \
		fltkcurrency \
		fltkspacetrader \
		mokoeightball \
		babiloo-efl \
		make \
		dnsmasq \
		libsyncml \
		qi \
		qi-ubi \
		wpa-gui \
		gabriel \
		stopwatch \
		qgpslog \
		litephone \
		rtmom \
		ventura \
		emtooth \
		podboy \
		mcnavi \
"

# this is only usefull on gta02 and on other devices it's trying to pull mesa-dri (not respecting DEFAULT_PROVIDER for virtual/libgl)
RDEPENDS_${PN}_append_om-gta02 = "glamo-dri-tests"
